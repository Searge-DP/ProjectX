package snowpaw.projectx.machine.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.lib.block.ExtendedBlock;
import snowpaw.projectx.lib.util.FluidUtils;
import snowpaw.projectx.lib.vec.Vector3i;
import snowpaw.projectx.machine.XMachineBlocks;
import snowpaw.projectx.machine.block.BlockXTankFrame;

public class TileXTankValve extends TileEntity implements IFluidTank, IFluidHandler {
	
    private final int maxSize = 13;
    protected int mbPerVirtualTank = 16000;
    protected int minBurnableTemp = 1300;

    private int frameBurnability = 0;

    private String valveName = "";
    public boolean isValid;
    private boolean isMaster;
    private Vector3i masterValvePos;
    public boolean initiated;

    private boolean needsUpdate;

    public int tankHeight = 0;
    public int valveHeightPosition = 0;
    private boolean autoOutput;

    private int fluidIntake, fluidOuttake, rainIntake;

    private int randomBurnTicks = 20 * 5; 
    private int randomLeakTicks = 20 * 60; 

    private ForgeDirection inside = ForgeDirection.UNKNOWN;

    private TileXTankValve master;
    public List<TileXTankFrame> tankFrames;
    public List<TileXFluidDetector> allLiquidDetectors;
    public List<TileXTankValve> otherValves;
    
    private Map<Vector3i, ExtendedBlock>[] maps;
    
    private int[] length = new int[6];
    public Vector3i bottomDiagFrame, topDiagFrame;
    public int initialWaitTick = 20;

    private FluidStack fluidStack;
    private int fluidTemperature = 0;
    private int fluidCapacity = 0;
    private int lastComparatorOut = 0;
    
    public TileXTankValve() {
        tankFrames = new ArrayList<TileXTankFrame>();
        allLiquidDetectors = new ArrayList<TileXFluidDetector>();
        otherValves = new ArrayList<TileXTankValve>();
    }
    
    @Override
    public void validate() {
        super.validate();
        initiated = true;
        initialWaitTick = 20;
    }
    
    @Override
    public void updateEntity() {
        if(worldObj.isRemote)
            return;

        if(needsUpdate) {
            getMaster().markForUpdate(true);
            needsUpdate = false;

            if(fluidIntake != 0) {
                ProjectX.analytics.event(FluidAnalytics.Category.TANK, FluidAnalytics.Event.FLUID_INTAKE, fluidIntake);
                fluidIntake = 0;
            }
            if(fluidOuttake != 0) {
                ProjectX.analytics.event(FluidAnalytics.Category.TANK, FluidAnalytics.Event.FLUID_OUTTAKE, fluidOuttake);
                fluidOuttake = 0;
            }
            if(rainIntake != 0) {
                ProjectX.analytics.event(FluidAnalytics.Category.TANK, FluidAnalytics.Event.RAIN_INTAKE, rainIntake);
                rainIntake = 0;
            }
        }

        if(initiated) {
            if (isMaster()) {
                if(bottomDiagFrame != null && topDiagFrame != null) { // Potential fix for huge-ass tanks not loading properly on master-valve chunk load.
                    Chunk chunkBottom = worldObj.getChunkFromBlockCoords(bottomDiagFrame.getX(), bottomDiagFrame.getZ());
                    Chunk chunkTop = worldObj.getChunkFromBlockCoords(topDiagFrame.getX(), topDiagFrame.getZ());

                    Vector3i pos_chunkBottom = new Vector3i(chunkBottom.xPosition, 0, chunkBottom.zPosition);
                    Vector3i pos_chunkTop = new Vector3i(chunkTop.xPosition, 0, chunkTop.zPosition);

                    Vector3i diff = pos_chunkTop.getDistance(pos_chunkBottom);
                    for(int x = 0; x <= diff.getX(); x++) {
                        for(int z = 0; z <= diff.getZ(); z++) {
                            worldObj.getChunkProvider().loadChunk(pos_chunkTop.getX() + x, pos_chunkTop.getZ() + z);
                        }
                    }

                    updateBlockAndNeighbors();
                }
                if (initialWaitTick-- <= 0) {
                    initiated = false;
                    buildTank(inside);
                    return;
                }
            }
        }

        if(!isValid())
            return;

        if(!isMaster() && getMaster() == null) {
            setValid(false);
            updateBlockAndNeighbors();
        }

        if(getFluid() == null)
            return;

        if(getAutoOutput() || valveHeightPosition == 0) { // Auto outputs at 50mB/t (1B/s) if enabled
            if (getFluidAmount() != 0) {
                float height = (float) getFluidAmount() / (float) getCapacity();
                boolean isNegativeDensity = getFluid().getFluid().getDensity(getFluid()) < 0 ;
                if (FluidUtils.canAutoOutput(height, getTankHeight(), valveHeightPosition, isNegativeDensity)) { // Valves can output until the liquid is at their halfway point.
                    ForgeDirection out = inside.getOpposite();
                    TileEntity tile = worldObj.getTileEntity(xCoord + out.offsetX, yCoord + out.offsetY, zCoord + out.offsetZ);
                    if(tile != null) {
                        if(!(tile instanceof TileXTankValve) && !getAutoOutput() && valveHeightPosition == 0) {}
                        else {
                            int maxAmount = 0;
                            if (tile instanceof TileXTankValve)
                                maxAmount = 1000; 
                            else if (tile instanceof IFluidHandler)
                                maxAmount = 50;

                            if (maxAmount != 0) {
                                IFluidHandler handler = (IFluidHandler) tile;
                                FluidStack fillStack = getFluid().copy();
                                fillStack.amount = Math.min(getFluidAmount(), maxAmount);
                                if (handler.fill(inside, fillStack, false) > 0) {
                                    drain(handler.fill(inside, fillStack, true), true);
                                }
                            }
                        }
                    }
                }
            }
        }

        if(getFluid() != null && getFluid().getFluid() == FluidRegistry.WATER) {
            if(worldObj.isRaining()) {
                int rate = (int) Math.floor(worldObj.rainingStrength * 5 * worldObj.getBiomeGenForCoords(xCoord, zCoord).rainfall);
                if (yCoord == worldObj.getPrecipitationHeight(xCoord, zCoord) - 1) {
                    FluidStack waterStack = getFluid().copy();
                    waterStack.amount = rate * 10;
                    rainIntake += waterStack.amount;
                    fill(waterStack, true);
                }
            }
        }

        if(isMaster()) {
            if(minBurnableTemp > 0 && fluidTemperature >= minBurnableTemp && frameBurnability > 0) {
                if(randomBurnTicks-- <= 0) {
                    randomBurnTicks = 20 * 5;
                    Random random = new Random();

                    int temperatureDiff = fluidTemperature - minBurnableTemp;
                    int chanceOfBurnability = 300 - frameBurnability;
                    int rand = random.nextInt(300) + temperatureDiff + ((int) Math.floor((float) getFluidAmount() / (float) getCapacity() * 300));
                    if(rand >= chanceOfBurnability) {
                        boolean successfullyBurned = false;

                        List<TileXTankFrame> remainingFrames = new ArrayList<TileXTankFrame>();
                        remainingFrames.addAll(tankFrames);

                        List<TileXTankFrame> removingFrames = new ArrayList<TileXTankFrame>();
                        while(!successfullyBurned) { 
                            if(remainingFrames.size() == 0)
                                break;

                            boolean couldBurnOne = false;
                            for(int i=0; i<Math.min(10, remainingFrames.size()); i++) {
                                int id = random.nextInt(remainingFrames.size());
                                TileXTankFrame frame = remainingFrames.get(id);
                                couldBurnOne = frame.tryBurning();
                                if(!couldBurnOne)
                                    removingFrames.add(frame);
                            }
                            remainingFrames.removeAll(removingFrames);
                            removingFrames.clear();
                            if(couldBurnOne)
                                successfullyBurned = true;
                        }
                        if(!successfullyBurned) {
                            remainingFrames.clear();
                            remainingFrames.addAll(tankFrames);
                            List<Vector3i> firePos = new ArrayList<Vector3i>();
                            for(int i=0; i<3;) {
                                if(remainingFrames.size() == 0)
                                    break;

                                int id = random.nextInt(remainingFrames.size());
                                TileXTankFrame frame = remainingFrames.get(id);
                                if(frame.getBlock().getBlock().isFlammable(worldObj, frame.xCoord, frame.yCoord, frame.zCoord, ForgeDirection.UNKNOWN)) {
                                    firePos.add(new Vector3i(frame.xCoord, frame.yCoord, frame.zCoord));
                                    i++;
                                }
                                else
                                    remainingFrames.remove(id);
                            }
                            for(Vector3i pos : firePos) {
                                if(worldObj.getBlock(pos.getX(), pos.getY(), pos.getZ()).isFlammable(worldObj, pos.getX(), pos.getY(), pos.getZ(), ForgeDirection.UNKNOWN))
                                    worldObj.setBlock(pos.getX(), pos.getY(), pos.getZ(), Blocks.fire);
                            }
                        }

                        frameBurnability = 0;

                        if(ProjectX.instance.SET_WORLD_ON_FIRE)
                            worldObj.playSoundEffect(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, ProjectX.MODID + ":fire", 1.0F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
                    }
                }
            }

            if(true) {
                if(randomLeakTicks-- <= 0 && fluidStack != null && fluidStack.getFluid().canBePlacedInWorld()) {
                    randomLeakTicks = 20 * 60;

                    Random random = new Random();
                    int amt = random.nextInt(3) + 1;

                    List<TileXTankFrame> validFrames = new ArrayList<TileXTankFrame>();

                    List<TileXTankFrame> remainingFrames = new ArrayList<TileXTankFrame>();
                    remainingFrames.addAll(tankFrames);

                    for (int i = 0; i < amt; ) {
                        if (remainingFrames.size() == 0)
                            break;

                        int id = random.nextInt(remainingFrames.size());
                        TileXTankFrame frame = remainingFrames.get(id);
                        Block block = frame.getBlock().getBlock();
                        if (FluidUtils.canBlockLeak(block) && !frame.getNeighborBlockOrAir(fluidStack.getFluid().getBlock()).isEmpty() && block.getBlockHardness(worldObj, frame.xCoord, frame.yCoord, frame.zCoord) <= 1.0F) {
                            validFrames.add(frame);
                            i++;
                        } else
                            remainingFrames.remove(id);
                    }

                    for (TileXTankFrame frame : validFrames) {
                        Block block = frame.getBlock().getBlock();
                        int hardness = (int) Math.ceil(block.getBlockHardness(worldObj, frame.xCoord, frame.yCoord, frame.zCoord) * 100);
                        int rand = random.nextInt(hardness) + 1;
                        int diff = (int) Math.ceil(50 * ((float) getFluidAmount() / (float) getCapacity()));
                        if (rand >= hardness - diff) {
                            ForgeDirection leakDir;
                            List<ForgeDirection> dirs = frame.getNeighborBlockOrAir(fluidStack.getFluid().getBlock());
                            if (dirs.size() == 0)
                                continue;

                            if (dirs.size() > 1) {
                                leakDir = dirs.get(random.nextInt(dirs.size()));
                            } else
                                leakDir = dirs.get(0);

                            Vector3i leakPos = new Vector3i(frame.xCoord + leakDir.offsetX, frame.yCoord + leakDir.offsetY, frame.zCoord + leakDir.offsetZ);
                            if (maps[2].containsKey(leakPos))
                                continue;

                            if (fluidStack.amount >= FluidContainerRegistry.BUCKET_VOLUME) {
                                worldObj.setBlock(frame.xCoord + leakDir.offsetX, frame.yCoord + leakDir.offsetY, frame.zCoord + leakDir.offsetZ, fluidStack.getFluid().getBlock(), 0, 3);
                                worldObj.notifyBlockOfNeighborChange(frame.xCoord + leakDir.offsetX, frame.yCoord + leakDir.offsetY, frame.zCoord + leakDir.offsetZ, fluidStack.getFluid().getBlock());
                                drain(FluidContainerRegistry.BUCKET_VOLUME, true);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private List<TileXTankValve> getAllValves() {
        if(!isMaster() && getMaster() != this)
            return getMaster().getAllValves();

        List<TileXTankValve> valves = new ArrayList<TileXTankValve>();
        valves.add(this);

        if(otherValves.isEmpty())
            return valves;

        for(TileXTankValve valve : otherValves)
            valves.add(valve);

        return valves;
    }
    
    private List<TileXTankValve> getValvesByName(String name) {
        if(!isMaster())
            return getMaster().getValvesByName(name);

        List<TileXTankValve> valves = new ArrayList<TileXTankValve>();
        if(getAllValves().isEmpty())
            return valves;

        for(TileXTankValve valve : getAllValves()) {
            if(valve.getValveName().toLowerCase().equals(name.toLowerCase()))
                valves.add(valve);
        }
        return valves;
    }
    
    public String getValveName() {
        if(this.valveName.isEmpty())
            setValveName(FluidUtils.getUniqueValveName(this));

        return this.valveName;
    }

    public void setValveName(String valveName) {
        this.valveName = valveName;
    }

    public void setNeedsUpdate() {
        needsUpdate = true;
    }

    public int getTankHeight() {
        return isMaster() ? tankHeight : getMaster().tankHeight;
    }

    public void setInside(ForgeDirection inside) {
        this.inside = inside;
    }

    public ForgeDirection getInside() {
        return this.inside;
    }
    
    public void buildTank(ForgeDirection inside) {
        if (worldObj.isRemote)
            return;

        setValid(false);

        fluidCapacity = 0;
        tankFrames.clear();
        otherValves.clear();

        if(inside != null)
            setInside(inside);

        if(!calculateInside())
            return;

        if(!setupTank())
            return;

        initiated = false;
        updateBlockAndNeighbors();
    }
    
    public boolean calculateInside() {
        int xIn = xCoord + inside.offsetX;
        int yIn = yCoord + inside.offsetY;
        int zIn = zCoord + inside.offsetZ;

        for(ForgeDirection dr : ForgeDirection.VALID_DIRECTIONS) {
            for(int i=0; i<maxSize; i++) {
                if (!worldObj.isAirBlock(xIn + dr.offsetX * i, yIn + dr.offsetY * i, zIn + dr.offsetZ * i)) {
                    length[dr.ordinal()] = i - 1;
                    break;
                }
            }
        }

        for(int i=0; i<6; i += 2) {
            if(length[i] + length[i + 1] > maxSize)
                return false;
        }
        return length[0] != -1;
    }

    private void setSlaveValveInside(Map<Vector3i, ExtendedBlock> airBlocks, TileXTankValve slave) {
        List<Vector3i> possibleAirBlocks = new ArrayList<Vector3i>();
        for(ForgeDirection dr : ForgeDirection.VALID_DIRECTIONS) {
            if(worldObj.isAirBlock(slave.xCoord + dr.offsetX, slave.yCoord + dr.offsetY, slave.zCoord + dr.offsetZ))
                possibleAirBlocks.add(new Vector3i(slave.xCoord + dr.offsetX, slave.yCoord + dr.offsetY, slave.zCoord + dr.offsetZ));
        }

        Vector3i insideAir = null;
        for(Vector3i pos : possibleAirBlocks) {
            if (airBlocks.containsKey(pos)) {
                insideAir = pos;
                break;
            }
        }

        if(insideAir == null)
            return;

        Vector3i dist = insideAir.getDistance(new Vector3i(slave.xCoord, slave.yCoord, slave.zCoord));
        for(ForgeDirection dr : ForgeDirection.VALID_DIRECTIONS) {
            if(dist.equals(new Vector3i(dr.offsetX, dr.offsetY, dr.offsetZ))) {
                slave.setInside(dr);
                break;
            }
        }
    }
    
    public void updateCornerFrames() {
        bottomDiagFrame = new Vector3i(xCoord + inside.offsetX + length[ForgeDirection.WEST.ordinal()] * ForgeDirection.WEST.offsetX + ForgeDirection.WEST.offsetX,
                yCoord + inside.offsetY + length[ForgeDirection.DOWN.ordinal()] * ForgeDirection.DOWN.offsetY + ForgeDirection.DOWN.offsetY,
                zCoord + inside.offsetZ + length[ForgeDirection.NORTH.ordinal()] * ForgeDirection.NORTH.offsetZ + ForgeDirection.NORTH.offsetZ);
        topDiagFrame = new Vector3i(xCoord + inside.offsetX + length[ForgeDirection.EAST.ordinal()] * ForgeDirection.EAST.offsetX + ForgeDirection.EAST.offsetX,
                yCoord + inside.offsetY + length[ForgeDirection.UP.ordinal()] * ForgeDirection.UP.offsetY + ForgeDirection.UP.offsetY,
                zCoord + inside.offsetZ + length[ForgeDirection.SOUTH.ordinal()] * ForgeDirection.SOUTH.offsetZ + ForgeDirection.SOUTH.offsetZ);
    }

    private void fetchMaps() {
        maps = FluidUtils.getTankFrame(worldObj, bottomDiagFrame, topDiagFrame);
    }
    
    private boolean setupTank() {
        updateCornerFrames();
        fetchMaps();
        
        otherValves = new ArrayList<TileXTankValve>();
        tankFrames = new ArrayList<TileXTankFrame>();

        Vector3i pos = new Vector3i(xCoord, yCoord, zCoord);
        valveHeightPosition = Math.abs(bottomDiagFrame.getDistance(pos).getY());
        tankHeight = topDiagFrame.getDistance(bottomDiagFrame).getY() - 1;

        ExtendedBlock bottomDiagBlock = new ExtendedBlock(worldObj.getBlock(bottomDiagFrame.getX(), bottomDiagFrame.getY(), bottomDiagFrame.getZ()),
                worldObj.getBlockMetadata(bottomDiagFrame.getX(), bottomDiagFrame.getY(), bottomDiagFrame.getZ()));
        ExtendedBlock topDiagBlock = new ExtendedBlock(worldObj.getBlock(topDiagFrame.getX(), topDiagFrame.getY(), topDiagFrame.getZ()),
                worldObj.getBlockMetadata(topDiagFrame.getX(), topDiagFrame.getY(), topDiagFrame.getZ()));

        frameBurnability = bottomDiagBlock.getBlock().getFlammability(worldObj, bottomDiagFrame.getX(), bottomDiagFrame.getY(), bottomDiagFrame.getZ(), ForgeDirection.UNKNOWN);

        if(bottomDiagBlock.getBlock() instanceof BlockXTankFrame) {
            TileEntity tile = worldObj.getTileEntity(bottomDiagFrame.getX(), bottomDiagFrame.getY(), bottomDiagFrame.getZ());
            if(tile != null && tile instanceof TileXTankFrame)
                bottomDiagBlock = ((TileXTankFrame) tile).getBlock();
        }

        if(topDiagBlock.getBlock() instanceof BlockXTankFrame) {
            TileEntity tile = worldObj.getTileEntity(topDiagFrame.getX(), topDiagFrame.getY(), topDiagFrame.getZ());
            if(tile != null && tile instanceof TileXTankFrame)
                topDiagBlock = ((TileXTankFrame) tile).getBlock();
        }

        if(!FluidUtils.isValidTankBlock(worldObj, bottomDiagFrame, bottomDiagBlock))
            return false;

        if (!FluidUtils.areTankBlocksValid(bottomDiagBlock, topDiagBlock, worldObj, bottomDiagFrame))
            return false;

        for (Map.Entry<Vector3i, ExtendedBlock> airCheck : maps[2].entrySet()) {
            pos = airCheck.getKey();
            if (!worldObj.isAirBlock(pos.getX(), pos.getY(), pos.getZ())) {
                if (airCheck.getValue().getBlock().getUnlocalizedName().equals("railcraft.residual.heat"))
                    continue;

                return false;
            }
        }
        
        if (false) {
            fluidCapacity = (maps[2].size()) * mbPerVirtualTank;
        } else {
            fluidCapacity = (maps[0].size() + maps[1].size() + maps[2].size()) * mbPerVirtualTank;
        }

        for (Map.Entry<Vector3i, ExtendedBlock> frameCheck : maps[0].entrySet()) {
            Vector3i fPos = frameCheck.getKey();
            ExtendedBlock fBlock = frameCheck.getValue();
            int burnability = fBlock.getBlock().getFlammability(worldObj, fPos.getX(), fPos.getY(), fPos.getZ(), ForgeDirection.UNKNOWN);
            if(burnability > frameBurnability)
                frameBurnability = burnability;

            if(fBlock.getBlock() instanceof BlockXTankFrame) {
                TileEntity tile = worldObj.getTileEntity(fPos.getX(), fPos.getY(), fPos.getZ());
                if(tile != null && tile instanceof TileXTankFrame)
                    fBlock = ((TileXTankFrame) tile).getBlock();
            }
            if (!FluidUtils.areTankBlocksValid(fBlock, bottomDiagBlock, worldObj, fPos))
                return false;
        }
        
        List<TileXTankValve> valves = new ArrayList<TileXTankValve>();
        List<TileXFluidDetector> liquidDetectors = new ArrayList<>();
        for (Map.Entry<Vector3i, ExtendedBlock> insideFrameCheck : maps[1].entrySet()) {
            pos = insideFrameCheck.getKey();
            ExtendedBlock check = insideFrameCheck.getValue();
            int burnability = check.getBlock().getFlammability(worldObj, pos.getX(), pos.getY(), pos.getZ(), ForgeDirection.UNKNOWN);
            if(burnability > frameBurnability)
                frameBurnability = burnability;

            if (FluidUtils.areTankBlocksValid(check, bottomDiagBlock, worldObj, pos) || FluidUtils.isBlockGlass(check.getBlock(), check.getMetadata()))
                continue;

            TileEntity tile = worldObj.getTileEntity(pos.getX(), pos.getY(), pos.getZ());
            if (tile != null) {
                if (tile instanceof TileXTankValve) {
                	ProjectX.serverMgr.sendChatMsg(new ChatComponentText("Hallo"));
                	TileXTankValve valve = (TileXTankValve) tile;
                    if (valve == this)
                        continue;

                    if (valve.fluidStack != null) {
                        this.fluidStack = valve.fluidStack;
                        updateFluidTemperature();
                    }
                    valves.add(valve);
                    continue;
                    
                }
                
                if (tile instanceof TileXFluidDetector) {
                	TileXFluidDetector liquidDetector = (TileXFluidDetector) tile;
                	allLiquidDetectors.add((TileXFluidDetector) tile);
                	continue;
                }
                else if (tile instanceof TileXTankFrame) {
                    continue;
                }
                return false;
            }
            
            return false;
        }
        ProjectX.serverMgr.sendChatMsg(new ChatComponentText("Hallo-J"));

        if (this.fluidStack != null)
            this.fluidStack.amount = Math.min(this.fluidStack.amount, this.fluidCapacity);

        for (TileXTankValve valve : valves) {
            pos = new Vector3i(valve.xCoord, valve.yCoord, valve.zCoord);
            valve.valveHeightPosition = Math.abs(bottomDiagFrame.getDistance(pos).getY());

            valve.setMasterPos(new Vector3i(xCoord, yCoord, zCoord));
            setSlaveValveInside(maps[2], valve);
        }
        for (TileXFluidDetector liquidDetector : allLiquidDetectors)
        {
        	pos = new Vector3i(liquidDetector.xCoord, liquidDetector.yCoord, liquidDetector.zCoord);
        	liquidDetector.setPositionInTank(Math.abs(bottomDiagFrame.getDistance(pos).getY()));
        }
        isMaster = true;

        for (Map.Entry<Vector3i, ExtendedBlock> setTiles : maps[0].entrySet()) {
            pos = setTiles.getKey();
            TileXTankFrame tankFrame;
            if (setTiles.getValue().getBlock() != XMachineBlocks.blockTankFrame) {

                worldObj.setBlock(pos.getX(), pos.getY(), pos.getZ(), XMachineBlocks.blockTankFrame, setTiles.getValue().getMetadata(), 3);
                tankFrame = (TileXTankFrame) worldObj.getTileEntity(pos.getX(), pos.getY(), pos.getZ());
                tankFrame.initialize(this, setTiles.getValue());
            } else {
                tankFrame = (TileXTankFrame) worldObj.getTileEntity(pos.getX(), pos.getY(), pos.getZ());
                tankFrame.setValvePos(new Vector3i(xCoord, yCoord, zCoord));
            }
            tankFrames.add(tankFrame);
        }

        for (Map.Entry<Vector3i, ExtendedBlock> setTiles : maps[1].entrySet()) {
            pos = setTiles.getKey();
            TileEntity tile = worldObj.getTileEntity(pos.getX(), pos.getY(), pos.getZ());
            if (tile != null) {
                if (tile instanceof TileXTankValve && tile != this)
                    otherValves.add((TileXTankValve) tile);

                if (tile instanceof TileXFluidDetector)
                {
                	allLiquidDetectors.add((TileXFluidDetector) tile);
                }
                else if (tile instanceof TileXTankFrame) {
                    ((TileXTankFrame) tile).setValvePos(new Vector3i(xCoord, yCoord, zCoord));
                    tankFrames.add((TileXTankFrame) tile);
                }
                else if (FluidUtils.isTileEntityAcceptable(setTiles.getValue().getBlock(), tile)) {

                	
                    worldObj.setBlock(pos.getX(), pos.getY(), pos.getZ(), XMachineBlocks.tankFrame, setTiles.getValue().getMetadata(), 2);
                    TileXTankFrame tankFrame = (TileXTankFrame) worldObj.getTileEntity(pos.getX(), pos.getY(), pos.getZ());
                    tankFrame.initialize(this, setTiles.getValue());
                    tankFrames.add(tankFrame);
                }
            } else {
         
                worldObj.setBlock(pos.getX(), pos.getY(), pos.getZ(), XMachineBlocks.tankFrame, setTiles.getValue().getMetadata(), 2);
                TileXTankFrame tankFrame = (TileXTankFrame) worldObj.getTileEntity(pos.getX(), pos.getY(), pos.getZ());
                tankFrame.initialize(this, setTiles.getValue());
                tankFrames.add(tankFrame);
            }
        }

        isValid = true;
        return true;
    }

}
