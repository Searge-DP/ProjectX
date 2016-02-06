package snowpaw.projectx.machine.tile;

import java.util.ArrayList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import snowpaw.projectx.machine.XMachineBlocks;
import snowpaw.projectx.machine.energy.PulseDevice;

public class TileXPulseFurnace extends TileEntity implements ISidedInventory {
	
    private static String machineName = "Pulse Furnace";
    
    private ArrayList<PulseDevice> machinesPulseGenerator;
    
    private static final int[] slotsTop = new int[] { 0 };
    private static final int[] slotsSide = new int[] { 1 };
    private static final int[] slotsBlank = new int[] { 2 };
    private ItemStack[] machineItemStacks = new ItemStack[3];
    
    public static int energyPerTick = 32;
    private static float energyTotal = 3200;
    private float energy;
    private float energyIn;
    
    private static int energyTotalGui = (int) energyTotal / energyPerTick;
    public int energyGui;
    public int energyInGui;
    
    private boolean hasEnergy = false;
    public boolean isActive = false;
    private int usableGenerators = 0;
    
    @Override
    public void openInventory() {

    }
    
    @Override
    public void closeInventory() {

    }
    
    @Override
    public int getSizeInventory() {
        return machineItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return machineItemStacks[slot];
    }
    
    @Override
    public ItemStack decrStackSize(int slot, int count) {
        if (machineItemStacks[slot] != null) {
            ItemStack itemStack;
            if (machineItemStacks[slot].stackSize <= count) {
                itemStack = machineItemStacks[slot];
                machineItemStacks[slot] = null;
                return itemStack;
            } else {
                itemStack = machineItemStacks[slot].splitStack(count);

                if (machineItemStacks[slot].stackSize == 0) {
                    machineItemStacks[slot] = null;
                }
                return itemStack;
            }
        } else {
            return null;
        }
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (machineItemStacks[slot] != null) {
            ItemStack itemstack = machineItemStacks[slot];
            machineItemStacks[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }
    
    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        machineItemStacks[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        int meta = blockMetadata;

        if (meta >= 4 && meta < 8)
            meta -= 4;
        else if (meta >= 8)
            meta -= 8;

        if (side == 1)
            return slotsTop;
        else if (side == 2 && meta == 0)
            return slotsSide;
        else if (side == 3 && meta == 2)
            return slotsSide;
        else if (side == 4 && meta == 3)
            return slotsSide;
        else if (side == 5 && meta == 1)
            return slotsSide;
        else
            return slotsBlank;
    }
    
    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int par3) {
        return isItemValidForSlot(slot, itemstack);
    }
    
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return slot == 0;
    }
    
    @Override
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3) {
        return par3 != 0;
    }
    
    @Override
    public String getInventoryName() {
        return machineName;
    }
    
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }
    
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64.0D;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);

        energy = tagCompound.getFloat("Energy");
        energyIn = tagCompound.getFloat("EnergyIn");

        energyGui = tagCompound.getInteger("EnergyGui");

        isActive = tagCompound.getBoolean("IsActive");
        hasEnergy = tagCompound.getBoolean("HasEnergy");
        usableGenerators = tagCompound.getInteger("UsableGenerators");

        int machinesX[] = tagCompound.getIntArray("machinesGeneratorX");
        int machinesY[] = tagCompound.getIntArray("machinesGeneratorY");
        int machinesZ[] = tagCompound.getIntArray("machinesGeneratorZ");
        
        machinesPulseGenerator = new ArrayList<PulseDevice>();
        
        for (int i = 0; i < machinesX.length; i++)
        	machinesPulseGenerator.add(new PulseDevice(machinesX[i], machinesY[i], machinesZ[i], XMachineBlocks.pulseGenerator));


        machineItemStacks = new ItemStack[getSizeInventory()];
        NBTTagList tagsItems = tagCompound.getTagList("Items", 10);
        for (int i = 0; i < tagsItems.tagCount(); ++i) {
            NBTTagCompound tagCompound1 = tagsItems.getCompoundTagAt(i);
            byte byte0 = tagCompound1.getByte("Slot");

            if (byte0 >= 0 && byte0 < machineItemStacks.length) {
                machineItemStacks[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
            }
        }
    }
    
    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

        tagCompound.setFloat("Energy", energy);
        tagCompound.setFloat("EnergyIn", energyIn);

        tagCompound.setInteger("EnergyGui", energyGui);

        tagCompound.setBoolean("IsActive", isActive);
        tagCompound.setBoolean("HasEnergy", hasEnergy);
        tagCompound.setInteger("UsableGenerators", usableGenerators);

        int machinesX[];
        int machinesY[];
        int machinesZ[];

        if (machinesPulseGenerator != null) {
            machinesX = new int[machinesPulseGenerator.size()];
            machinesY = new int[machinesPulseGenerator.size()];
            machinesZ = new int[machinesPulseGenerator.size()];
            
            int i = 0;
            for (PulseDevice entry : machinesPulseGenerator) {
                machinesX[i] = entry.x;
                machinesY[i] = entry.y;
                machinesZ[i] = entry.z;
                i++;
            }
            
            tagCompound.setIntArray("machinesGeneratorX", machinesX);
            tagCompound.setIntArray("machinesGeneratorY", machinesY);
            tagCompound.setIntArray("machinesGeneratorZ", machinesZ);
        }
        
        else  {
            machinesX = new int[0];
            machinesY = new int[0];
            machinesZ = new int[0];
            tagCompound.setIntArray("machinesGeneratorX", machinesX);
            tagCompound.setIntArray("machinesGeneratorY", machinesY);
            tagCompound.setIntArray("machinesGeneratorZ", machinesZ);
        }

        NBTTagList tagsItems = new NBTTagList();
        for (int i = 0; i < machineItemStacks.length; i++)
            if (machineItemStacks[i] != null) {
                NBTTagCompound tagCompoundLoop = new NBTTagCompound();
                tagCompoundLoop.setByte("Slot", (byte) i);
                machineItemStacks[i].writeToNBT(tagCompoundLoop);
                tagsItems.appendTag(tagCompoundLoop);
            }
        tagCompound.setTag("Items", tagsItems);
    }
    
    @Override
    public void updateEntity() {
        if (!worldObj.isRemote) {
            energyIn = 0;

            checkEnergy();
            if (hasEnergy && canProcess()) {
                if (!isActive) {
                    isActive = countGenerators();
                    if (isActive)
                        XMachineBlocks.updateMachineState(1, worldObj, xCoord, yCoord, zCoord);
                    else
                        energyIn = -1;
                }

                if (isActive) {

                    energyIn = 0;
                    if (machinesPulseGenerator != null)
                        for (PulseDevice entry : machinesPulseGenerator) {
                            if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                                TileXPulseGenerator generator = (TileXPulseGenerator) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                                if (generator != null)
                                    if (energy + energyIn < energyTotal) {
                                        if (energyTotal - energy - energyIn < energyPerTick / usableGenerators)
                                            energyIn = energyIn + generator.pullEnergy(energyTotal - energy - energyIn);
                                        else
                                            energyIn = energyIn + generator.pullEnergy((float) energyPerTick / usableGenerators);
                                    }
                            }
                        }

                    if (energyIn == 0)
                        stopProcessing();
                    else
                        energy = energy + energyIn;

                    if (energy >= energyTotal) {
                        energy = 0;
                        processItem();
                    }
                }
            } else
                stopProcessing();

            energyGui = (int) (energy / energyPerTick);
            energyInGui = (Math.round(energyIn));
        }
    }
    
    public boolean countGenerators() {
        int usableGenerators1 = 0;
        if(machinesPulseGenerator != null)
            for (PulseDevice entry : machinesPulseGenerator) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TileXPulseGenerator generator = (TileXPulseGenerator) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (generator != null)
                        if (generator.canProvideEnergy)
                            usableGenerators1++;
                }
            }
        
        usableGenerators = usableGenerators1;

        return usableGenerators != 0;
    }

    private void checkEnergy() {
        boolean checkEnergy = false;

        if (machinesPulseGenerator != null)
            for (PulseDevice entry : machinesPulseGenerator) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TileXPulseGenerator generator = (TileXPulseGenerator) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (generator != null)
                        if (generator.canProvideEnergy)
                            checkEnergy = true;
                }
            }

        if ((checkEnergy && !hasEnergy) || (blockMetadata >= 4 && blockMetadata < 8 && !isActive))
            XMachineBlocks.updateMachineState(0, worldObj, xCoord, yCoord, zCoord);
        else if (!checkEnergy && hasEnergy)
        	XMachineBlocks.updateMachineState(2, worldObj, xCoord, yCoord, zCoord);

        hasEnergy = checkEnergy;
    }
    
    public void stopProcessing() {
        energy = 0;
        if (isActive) {
            isActive = false;
            checkEnergy();
        }
    }
    
    public void injectMachines(ArrayList<PulseDevice> incomingMachines) {
        if (incomingMachines.size() != 0)
        	machinesPulseGenerator = incomingMachines;
        else
        	machinesPulseGenerator = null;

        countGenerators();
    }
    
    private boolean canProcess() {
        if (this.machineItemStacks[0] == null)
            return false;
        else {
            ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(machineItemStacks[0]);
            if (itemStack == null)
                return false;
            if (machineItemStacks[1] == null)
                return true;
            if (!machineItemStacks[1].isItemEqual(itemStack))
                return false;
            int result = machineItemStacks[1].stackSize + itemStack.stackSize;
            return result <= getInventoryStackLimit() && result <= machineItemStacks[1].getMaxStackSize();
        }
    }
    
    public void processItem() {
        if (canProcess()) {
            ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(machineItemStacks[0]);

            if (machineItemStacks[1] == null)
                machineItemStacks[1] = itemStack.copy();
            else if (machineItemStacks[1].getItem() == itemStack.getItem())
                machineItemStacks[1].stackSize += itemStack.stackSize;

            machineItemStacks[0].stackSize--;

            if (machineItemStacks[0].stackSize == 0)
                machineItemStacks[0] = null;
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(int length) {
        return energyGui * length / energyTotalGui;
    }

}
