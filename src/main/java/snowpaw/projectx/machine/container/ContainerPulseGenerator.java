package snowpaw.projectx.machine.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import snowpaw.projectx.machine.tile.TileXPulseGenerator;

public class ContainerPulseGenerator extends Container {
	
	private TileXPulseGenerator tileEntity;
	
    private int lastEnergy;
    private int lastEnergyTotal;
    private int lastEnergyOut;

    public ContainerPulseGenerator(InventoryPlayer player, TileXPulseGenerator tileEntity){
        this.tileEntity = tileEntity;

        addSlotToContainer(new Slot(tileEntity, 0, 80, 42));

        int i;
        for(i = 0; i < 3; ++i){
            for(int j = 0; j < 9; ++j){
                addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(i = 0; i < 9; ++i){
            addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
    }
    
    @Override
    public void addCraftingToCrafters(ICrafting craft) {
        super.addCraftingToCrafters(craft);
        craft.sendProgressBarUpdate(this, 0, tileEntity.energyGui);
        craft.sendProgressBarUpdate(this, 1, tileEntity.energyTotalGui);
        craft.sendProgressBarUpdate(this, 2, tileEntity.energyOutGui);
    }
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); ++i) {
            ICrafting craft = (ICrafting) crafters.get(i);

            if( lastEnergy != tileEntity.energyGui)
                craft.sendProgressBarUpdate(this, 0, tileEntity.energyGui);
            if (lastEnergyTotal != tileEntity.energyTotalGui)
                craft.sendProgressBarUpdate(this, 1, tileEntity.energyTotalGui);
            if (lastEnergyOut != tileEntity.energyOutGui)
                craft.sendProgressBarUpdate(this, 2, tileEntity.energyOutGui);
        }

        lastEnergy = tileEntity.energyGui;
        lastEnergyTotal = tileEntity.energyTotalGui;
        lastEnergyOut = tileEntity.energyOutGui;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        if (id == 0)
            tileEntity.energyGui = value;
        if (id == 1)
            tileEntity.energyTotalGui = value;
        if (id == 2)
            tileEntity.energyOutGui = value;
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2){
        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (par2 != 0) {
                if (TileXPulseGenerator.canBurn(itemStack1)) {
                    if (!mergeItemStack(itemStack1, 0, 1, false)) {
                        return null;
                    }
                } else if(par2 >= 1 && par2 < 28) {
                    if (!mergeItemStack(itemStack1, 28, 37, false)) {
                        return null;
                    }
                } else if( par2 >= 28 && par2 < 38 && !mergeItemStack(itemStack1, 1, 28, false)) {
                    return null;
                }
            } else if(!mergeItemStack(itemStack1, 1, 37, false)) {
                return null;
            }

            if (itemStack1.stackSize == 0)
                slot.putStack(null);
            else
                slot.onSlotChanged();

            if(itemStack1.stackSize == itemStack.stackSize)
                return null;

            slot.onPickupFromSlot(player, itemStack1);
        }
        return itemStack;
    }

}
