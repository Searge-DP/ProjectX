package dca.projectx.core;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.machine.XMachineBlocks;
import dca.projectx.world.XWorldBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class XTabs {
	
	public static CreativeTabs tabProjectX = new CreativeTabs("tabProjectX"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(XWorldBlocks.storageBlue);
		}
	};
	
	public static CreativeTabs tabProjectXMachines = new CreativeTabs("tabProjectXMachines"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Item.getItemFromBlock(XMachineBlocks.engineeringTable);
		}
	};

}
