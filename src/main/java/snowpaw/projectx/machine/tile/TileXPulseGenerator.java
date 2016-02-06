package snowpaw.projectx.machine.tile;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import snowpaw.projectx.machine.XMachineBlocks;
import snowpaw.projectx.machine.energy.PulseDevice;

public class TileXPulseGenerator extends TileEntity implements ISidedInventory {
	
    private static String machineName = "Pulse Generator";
   
    private ArrayList<PulseDevice> machinesPulseFurnace;
    
    private static final int[] slotsSide = new int[] { 0 };
    private static final int[] slotsBlank = new int[] { 1 };
    private ItemStack[] machineItemStacks = new ItemStack[2];
    
    public static int energyPerTick = 32;
    private float energyTotal;
    private float energy;
    private float energyOut = 0;

    public int energyTotalGui;
    public int energyGui;
    public int energyOutGui;
    
    private boolean firstTick = false;
    public boolean canProvideEnergy = false;
    private float pulledThisTick = 0;
    
    private float epsilon = 0.0001F;
    
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

        if (side == 2 && meta == 0)
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
    public boolean canExtractItem(int slot, ItemStack itemstack, int par3) {
        return par3 != 0 || slot != 0 || itemstack.getItem() == Items.bucket;
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

        energyTotal = tagCompound.getFloat("EnergyTotal");
        energy = tagCompound.getFloat("Energy");
        energyOut = tagCompound.getFloat("EnergyOut");

        energyTotalGui = tagCompound.getInteger("EnergyTotalGui");
        energyGui = tagCompound.getInteger("EnergyGui");
        energyOutGui = tagCompound.getInteger("EnergyOutGui");

        canProvideEnergy = tagCompound.getBoolean("CanProvideEnergy");

        int machinesX[];
        int machinesY[];
        int machinesZ[];

        machinesX = tagCompound.getIntArray("machinesFurnaceX");
        machinesY = tagCompound.getIntArray("machinesFurnaceY");
        machinesZ = tagCompound.getIntArray("machinesFurnaceZ");
        
        machinesPulseFurnace = new ArrayList<PulseDevice>();
        for (int i = 0; i < machinesX.length; i++)
        	machinesPulseFurnace.add(new PulseDevice(machinesX[i], machinesY[i], machinesZ[i], XMachineBlocks.pulseFurnace));
        
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

        tagCompound.setFloat("EnergyTotal", energyTotal);
        tagCompound.setFloat("Energy", energy);
        tagCompound.setFloat("EnergyOut", energyOut);

        tagCompound.setInteger("EnergyTotalGui", energyTotalGui);
        tagCompound.setInteger("EnergyGui", energyGui);
        tagCompound.setInteger("EnergyOutGui", energyOutGui);

        tagCompound.setBoolean("CanProvideEnergy", canProvideEnergy);

        int machinesX[];
        int machinesY[];
        int machinesZ[];

        if (machinesPulseFurnace != null) {
            machinesX = new int[machinesPulseFurnace.size()];
            machinesY = new int[machinesPulseFurnace.size()];
            machinesZ = new int[machinesPulseFurnace.size()];
            
            int i = 0;
            for (PulseDevice entry : machinesPulseFurnace) {
                machinesX[i] = entry.x;
                machinesY[i] = entry.y;
                machinesZ[i] = entry.z;
                i++;
            }
            tagCompound.setIntArray("machinesFurnaceX", machinesX);
            tagCompound.setIntArray("machinesFurnaceY", machinesY);
            tagCompound.setIntArray("machinesFurnaceZ", machinesZ);
        }
        else {
            machinesX = new int[0];
            machinesY = new int[0];
            machinesZ = new int[0];
            tagCompound.setIntArray("machinesFurnaceX", machinesX);
            tagCompound.setIntArray("machinesFurnaceY", machinesY);
            tagCompound.setIntArray("machinesFurnaceZ", machinesZ);
        }

        NBTTagList tagsItems = new NBTTagList();
        for (int i = 0; i < machineItemStacks.length; ++i) {
            if (machineItemStacks[i] != null) {
                NBTTagCompound tagCompound1 = new NBTTagCompound();
                tagCompound1.setByte("Slot", (byte) i);
                machineItemStacks[i].writeToNBT(tagCompound1);
                tagsItems.appendTag(tagCompound1);
            }
        }
        tagCompound.setTag("Items", tagsItems);
    }
    
    @Override
    public void updateEntity() {
        if (!worldObj.isRemote) {
            
            if (pulledThisTick > 0 && canProvideEnergy &&
                    getBlockMetadata() < 4)
                XMachineBlocks.updateMachineState(1, worldObj, xCoord, yCoord, zCoord);
            else if (pulledThisTick == 0 && canProvideEnergy &&
                    (getBlockMetadata() >= 4 && getBlockMetadata() < 8))
            	XMachineBlocks.updateMachineState(0, worldObj, xCoord, yCoord, zCoord);
            
            energyOut = pulledThisTick;
            pulledThisTick = 0;

            if (energy <= 0 && canBurn(machineItemStacks[0])) {

                energyTotal = energy = getItemBurnTime(machineItemStacks[0]) * energyPerTick;

                if (machineItemStacks[0] != null) {
                    machineItemStacks[0].stackSize--;

                    if (machineItemStacks[0].stackSize == 0)
                        machineItemStacks[0] = machineItemStacks[0].getItem().getContainerItem(machineItemStacks[0]);
                }

                if (energyOut > 0)
                	XMachineBlocks.updateMachineState(1, worldObj, xCoord, yCoord, zCoord);
                else
                	XMachineBlocks.updateMachineState(0, worldObj, xCoord, yCoord, zCoord);

                if (!canProvideEnergy) {
                    canProvideEnergy = true;
                    restartMachinesStart();
                }
            }
            else if (energy <= 0 && !canBurn(machineItemStacks[0])) {
                energyTotal = 0;

                if(canProvideEnergy) {
                    canProvideEnergy = false;
                    restartMachinesStart();
                }

                XMachineBlocks.updateMachineState(2, worldObj, xCoord, yCoord, zCoord);
            }

            energyGui = (int) (energy / energyPerTick);
            energyTotalGui = (int) (energyTotal / energyPerTick);
            energyOutGui = (Math.round(energyOut));
        }
    }
    
    public float pullEnergy(float requestedEnergy) {
        if (canProvideEnergy) {
            if (pulledThisTick + requestedEnergy < energyPerTick - epsilon) {
                energy = energy - requestedEnergy;
                pulledThisTick = pulledThisTick + requestedEnergy;
                return requestedEnergy;
            }
            else {
                float pull = energyPerTick - pulledThisTick;
                energy = energy - pull;
                pulledThisTick = energyPerTick;
                return pull;
            }
        } else
            return  0;
    }
    
    private void restartMachinesStart() {
        if (machinesPulseFurnace != null)
            for (PulseDevice entry : machinesPulseFurnace) {
                if (worldObj.getChunkProvider().chunkExists(entry.x >> 4, entry.z >> 4)) {
                    TileXPulseFurnace tileEntity = (TileXPulseFurnace) worldObj.getTileEntity(entry.x, entry.y, entry.z);
                    if (tileEntity != null)
                        tileEntity.countGenerators();
                }
            }
    }
    
    public void injectMachines(ArrayList<PulseDevice> incomingPulseFurnace){
        if (incomingPulseFurnace.size() != 0)
            machinesPulseFurnace = incomingPulseFurnace;
        else
        	machinesPulseFurnace = null;
    }
    
    public static boolean canBurn(ItemStack itemStack) {
        return itemStack != null && getItemBurnTime(itemStack) > 0;
    }
    
    public static int getItemBurnTime(ItemStack itemStack){
        if (itemStack == null) {
            return 0;
        }
        else {
            Item item = itemStack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                    return 150;

                if (block.getMaterial() == Material.wood)
                    return 300;

                if (block == Blocks.coal_block)
                    return 16000;
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemStack);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(int length) {
        if (energyTotalGui <= 0)
            return -1;
        else
            return energyGui * length / energyTotalGui;
    }

}
