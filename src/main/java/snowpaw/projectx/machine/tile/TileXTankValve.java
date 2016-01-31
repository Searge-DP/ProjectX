package snowpaw.projectx.machine.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import cpw.mods.fml.common.Optional;
import buildcraft.api.transport.IPipeConnection;
import buildcraft.api.transport.IPipeConnection.ConnectOverride;
import buildcraft.api.transport.IPipeTile;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.lib.block.ExtendedBlock;
import snowpaw.projectx.lib.util.FluidUtils;
import snowpaw.projectx.lib.vec.Vector3i;
import snowpaw.projectx.machine.ProjectXMachines;
import snowpaw.projectx.machine.XMachineBlocks;
import snowpaw.projectx.machine.block.BlockXTankFrame;

@Optional.Interface(iface = "buildcraft.api.transport.IPipeConnection", modid = "BuildCraftAPI|Transport")
public class TileXTankValve extends TileEntity implements IFluidTank, IFluidHandler, IPipeConnection {
	
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

                        if(ProjectXMachines.instance.SET_WORLD_ON_FIRE)
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
        List<TileXFluidDetector> liquidDetectors = new ArrayList<TileXFluidDetector>();
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
            if (setTiles.getValue().getBlock() != XMachineBlocks.tankFrame) {

                worldObj.setBlock(pos.getX(), pos.getY(), pos.getZ(), XMachineBlocks.tankFrame, setTiles.getValue().getMetadata(), 3);
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
    
    public void breakTank(TileEntity frame) {
        if (worldObj.isRemote)
            return;

        if(!isMaster() && getMaster() != null) {
            if(getMaster() != this)
                getMaster().breakTank(frame);

            return;
        }

        setValid(false);

        for(TileXTankValve valve : otherValves) {
            valve.fluidStack = getFluid();
            valve.updateFluidTemperature();
            valve.master = null;
            valve.setValid(false);
            valve.updateBlockAndNeighbors();
        }
        
        

        for(TileXTankFrame tankFrame : tankFrames) {
            if(frame == tankFrame)
                continue;

            tankFrame.breakFrame();
        }
        tankFrames.clear();
        otherValves.clear();
        allLiquidDetectors.clear();

        this.updateBlockAndNeighbors();
    }
    
    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return getMaster() != null && getMaster().isValid;
    }

    public void updateBlockAndNeighbors() {
        updateBlockAndNeighbors(false);
    }
    
    private void markForUpdate(boolean onlyThis) {
        if(!onlyThis || this.lastComparatorOut != getComparatorOutput()) {
            this.lastComparatorOut = getComparatorOutput();
            for (TileXTankValve valve : otherValves) {
                valve.updateBlockAndNeighbors();
            }
        }
        if (!onlyThis) {
            for (TileXTankFrame frame : tankFrames) {
                frame.markForUpdate();
            }
            for (TileXFluidDetector liquidDetector: allLiquidDetectors)
            {
            	liquidDetector.markForUpdate();
            }
        }
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
    
    public void updateBlockAndNeighbors(boolean onlyThis) {
        if(worldObj.isRemote)
            return;

        this.markForUpdate(onlyThis);

        if(otherValves != null) {
            for(TileXTankValve otherValve : otherValves) {
                otherValve.isValid = isValid;
                otherValve.markForUpdate(true);
            }
        }

        ForgeDirection outside = getInside().getOpposite();
        TileEntity outsideTile = worldObj.getTileEntity(xCoord + outside.offsetX, yCoord + outside.offsetY, zCoord + outside.offsetZ);
        if (outsideTile != null) {
            if(ProjectXMachines.proxy.BUILDCRAFT_LOADED) {
                if(outsideTile instanceof IPipeTile)
                    ((IPipeTile) outsideTile).scheduleNeighborChange();
            }
        }
        
        worldObj.notifyBlockChange(xCoord, yCoord, zCoord, XMachineBlocks.tankValve);
        worldObj.markBlockForUpdate(xCoord + outside.offsetX, yCoord + outside.offsetY, zCoord + outside.offsetZ);
    }
    
    public boolean isMaster() {
        return isMaster;
    }

    public TileXTankValve getMaster() {
        if(isMaster())
            return this;

        if(masterValvePos != null) {
            TileEntity tile = worldObj.getTileEntity(masterValvePos.getX(), masterValvePos.getY(), masterValvePos.getZ());
            master = tile instanceof TileXTankValve ? (TileXTankValve) tile : null;
        }

        return master;
    }
    
    public void setMasterPos(Vector3i masterValvePos) {
        this.masterValvePos = masterValvePos;
        this.master = null;
    }

    public boolean getAutoOutput() {
        return isValid() && this.autoOutput;
    }

    public void setAutoOutput(boolean autoOutput) {
        this.autoOutput = autoOutput;
        updateBlockAndNeighbors(true);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        isValid = tag.getBoolean("isValid");
        inside = ForgeDirection.getOrientation(tag.getInteger("inside"));

        isMaster = tag.getBoolean("master");
        if(isMaster()) {
            if(tag.getBoolean("hasFluid")) {
                if(tag.hasKey("fluidID"))
                    fluidStack = new FluidStack(FluidRegistry.getFluid(tag.getInteger("fluidID")), tag.getInteger("fluidAmount"));
                else if(tag.hasKey("fluidName"))
                    fluidStack = new FluidStack(FluidRegistry.getFluid(tag.getString("fluidName")), tag.getInteger("fluidAmount"));
                updateFluidTemperature();
            }
            else {
                fluidStack = null;
            }

            tankHeight = tag.getInteger("tankHeight");
            fluidCapacity = tag.getInteger("fluidCapacity");
        }
        else {
            if(getMaster() == null && tag.hasKey("masterValve")) {
                int[] masterValveP = tag.getIntArray("masterValve");
                setMasterPos(new Vector3i(masterValveP[0], masterValveP[1], masterValveP[2]));
            }
        }

        autoOutput = tag.getBoolean("autoOutput");
        if(tag.hasKey("valveName"))
            setValveName(tag.getString("valveName"));
        else
            setValveName(FluidUtils.getUniqueValveName(this));

        if(tag.hasKey("bottomDiagF")) {
            int[] bottomDiagF = tag.getIntArray("bottomDiagF");
            int[] topDiagF = tag.getIntArray("topDiagF");
            bottomDiagFrame = new Vector3i(bottomDiagF[0], bottomDiagF[1], bottomDiagF[2]);
            topDiagFrame = new Vector3i(topDiagF[0], topDiagF[1], topDiagF[2]);
        }
    }
    
    @Override
    public void writeToNBT(NBTTagCompound tag) {
        tag.setBoolean("isValid", isValid);
        tag.setInteger("inside", inside.ordinal());

        tag.setBoolean("master", isMaster());
        if(isMaster()) {
            tag.setBoolean("hasFluid", fluidStack != null);
            if(fluidStack != null) {
                tag.setString("fluidName", FluidRegistry.getFluidName(fluidStack));
                tag.setInteger("fluidAmount", fluidStack.amount);
            }

            tag.setInteger("tankHeight", tankHeight);
            tag.setInteger("fluidCapacity", fluidCapacity);
        }
        else {
            if(getMaster() != null) {
                int[] masterPos = new int[]{getMaster().xCoord, getMaster().yCoord, getMaster().zCoord};
                tag.setIntArray("masterValve", masterPos);
            }
        }

        tag.setBoolean("autoOutput", autoOutput);
        if(!getValveName().isEmpty())
            tag.setString("valveName", getValveName());

        if(bottomDiagFrame != null && topDiagFrame != null) {
            tag.setIntArray("bottomDiagF", new int[]{bottomDiagFrame.getX(), bottomDiagFrame.getY(), bottomDiagFrame.getZ()});
            tag.setIntArray("topDiagF", new int[]{topDiagFrame.getX(), topDiagFrame.getY(), topDiagFrame.getZ()});
        }

        super.writeToNBT(tag);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        if(bottomDiagFrame == null || topDiagFrame == null)
            return super.getRenderBoundingBox();

        return AxisAlignedBB.getBoundingBox(bottomDiagFrame.getX(), bottomDiagFrame.getY(), bottomDiagFrame.getZ(), topDiagFrame.getX(), topDiagFrame.getY(), topDiagFrame.getZ());
    }
    
    public int getFluidLuminosity() {
        FluidStack fstack = getFluid();
        if(fstack == null)
            return 0;

        Fluid fluid = fstack.getFluid();
        if(fluid == null)
            return 0;

        return fluid.getLuminosity(fstack);
    }

    public void updateFluidTemperature() {
        FluidStack fstack = fluidStack;
        if(fstack == null)
            return;

        Fluid fluid = fstack.getFluid();
        if(fluid == null)
            return;

        this.fluidTemperature = fluid.getTemperature(fstack);
    }
    
    @Override
    public FluidStack getFluid() {
        if(!isValid())
            return null;

        return getMaster() == this ? fluidStack : getMaster().fluidStack;
    }

    @Override
    public int getFluidAmount() {
        if(getFluid() == null)
            return 0;

        return getFluid().amount;
    }

    @Override
    public int getCapacity() {
        if(!isValid())
            return 0;
            
        return getMaster() == this ? fluidCapacity : getMaster().fluidCapacity;
    }

    @Override
    public FluidTankInfo getInfo() {
        if(!isValid())
            return null;

        return new FluidTankInfo(getMaster());
    }
    
    @Override
    public int fill(FluidStack resource, boolean doFill) {
        if(getMaster() == this) {
            if (!isValid() || fluidStack != null && !fluidStack.isFluidEqual(resource))
                return 0;

            if (getFluidAmount() >= getCapacity()) {
                for(TileXTankValve valve : getAllValves()) {
                    if (valve == this)
                        continue;

                    ForgeDirection outside = valve.getInside().getOpposite();
                    TileEntity tile = worldObj.getTileEntity(valve.xCoord + outside.offsetX, valve.yCoord + outside.offsetY, valve.zCoord + outside.offsetZ);
                    if (tile != null && tile instanceof TileXTankValve) {
                        return ((TileXTankValve) tile).fill(getInside(), resource, doFill);
                    }
                }
            }

            if (!doFill)
            {
                if (fluidStack == null) {
                    return Math.min(fluidCapacity, resource.amount);
                }

                return Math.min(fluidCapacity - fluidStack.amount, resource.amount);
            }

            if (fluidStack == null)
            {
                fluidStack = new FluidStack(resource, Math.min(fluidCapacity, resource.amount));
                updateFluidTemperature();
                setNeedsUpdate();
                fluidIntake += fluidStack.amount;
                return fluidStack.amount;
            }

            int filled = fluidCapacity - fluidStack.amount;
            if (resource.amount < filled) {
                fluidStack.amount += resource.amount;
                filled = resource.amount;
            }
            else {
                fluidStack.amount = fluidCapacity;
            }

            fluidIntake += filled;

            getMaster().setNeedsUpdate();

            return filled;
        }
        else
            return getMaster().fill(resource, doFill);
    }
    
    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        if(getMaster() == this) {
            if(!isValid() || fluidStack == null)
                return null;

            int drained = maxDrain;
            if (fluidStack.amount < drained) {
                drained = fluidStack.amount;
            }

            FluidStack stack = new FluidStack(fluidStack, drained);
            if (doDrain) {
                fluidStack.amount -= drained;
                if (fluidStack.amount <= 0) {
                    fluidStack = null;
                    updateFluidTemperature();
                }
                fluidOuttake += drained;
                getMaster().setNeedsUpdate();
            }
            return stack;
        }
        else
            return getMaster().drain(maxDrain, doDrain);
    }
    
    public double getFillPercentage() {
        if(getFluid() == null)
            return 0;

        return Math.floor((double) getFluidAmount() / (double) getCapacity() * 100);
    }

    public int fillFromContainer(ForgeDirection from, FluidStack resource, boolean doFill) {
        if(!canFillIncludingContainers(from, resource.getFluid()))
            return 0;

        return getMaster() == this ? fill(resource, doFill) : getMaster().fill(resource, doFill);
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        if(!canFill(from, resource.getFluid()))
            return 0;

        return getMaster() == this ? fill(resource, doFill) : getMaster().fill(resource, doFill);
    }
    
    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        return getMaster() == this ? drain(resource.amount, doDrain) : getMaster().drain(resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        return getMaster() == this ? drain(maxDrain, doDrain) : getMaster().drain(maxDrain, doDrain);
    }
    
    public boolean canFillIncludingContainers(ForgeDirection from, Fluid fluid) {
        if (!isValid())
            return false;

        if (getFluid() != null && getFluid().getFluid() != fluid)
            return false;

        if (getFluidAmount() >= getCapacity()) {
            for (TileXTankValve valve : getAllValves()) {
                if (valve == this)
                    continue;

                if (valve.valveHeightPosition > getTankHeight()) {
                    ForgeDirection outside = valve.getInside().getOpposite();
                    TileEntity tile = worldObj.getTileEntity(valve.xCoord + outside.offsetX, valve.yCoord + outside.offsetY, valve.zCoord + outside.offsetZ);
                    if (tile != null && tile instanceof TileXTankValve) {
                        return ((TileXTankValve) tile).canFill(valve.getInside(), fluid);
                    }
                }
            }
            return false;
        }

        return true;
    }
    
    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        if(!canFillIncludingContainers(from, fluid))
            return false;

        return !getAutoOutput() || valveHeightPosition > getTankHeight() || valveHeightPosition + 0.5f >= getTankHeight() * getFillPercentage();

    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        if(!isValid())
            return false;

        if(getFluid() == null)
            return false;

        return getFluid().getFluid() == fluid && getFluidAmount() > 0;
    }
    
    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        if(!isValid())
            return null;

        return getMaster() == this ? new FluidTankInfo[]{ getInfo() } : getMaster().getTankInfo(from);
    }

    @Optional.Method(modid = "BuildCraftAPI|Transport")
    @Override
    public ConnectOverride overridePipeConnection(IPipeTile.PipeType pipeType, ForgeDirection from) {
        if(!isValid())
            return ConnectOverride.DISCONNECT;

        return ConnectOverride.CONNECT;
    }
    
    public String[] methodNames() {
        return new String[]{"getFluidName", "getFluidAmount", "getFluidCapacity", "setAutoOutput", "doesAutoOutput"};
    }

  
   
    public int getComparatorOutput() {
        return MathHelper.floor_float(((float) this.getFluidAmount() / this.getCapacity()) * 14.0F);
    }

}
