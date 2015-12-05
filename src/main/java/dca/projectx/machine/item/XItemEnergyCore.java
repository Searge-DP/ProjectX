package dca.projectx.machine.item;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.XTabs;
import dca.projectx.machine.XMachineItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class XItemEnergyCore extends Item {
	
	public XItemEnergyCore(String itemName){
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
	}
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean b){
    	if(this==XMachineItems.energyCoreT1){
    		list.add(EnumChatFormatting.GREEN + "Tier 1");
    	}
    	if(this==XMachineItems.energyCoreT2){
    		list.add(EnumChatFormatting.BLUE + "Tier 2"); 
    	}
    	if(this==XMachineItems.energyCoreT3){
    		list.add(EnumChatFormatting.RED + "Tier 3");
    	}
    }

}
