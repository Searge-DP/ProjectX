package snowpaw.projectx.core;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import snowpaw.projectx.machine.XMachineBlocks;
import snowpaw.projectx.world.XWorldBlocks;
import snowpaw.projectx.world.XWorldItems;

public class XTabs {
	
	public static CreativeTabs tabProjectX = new CreativeTabs("tabProjectX"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return (XWorldItems.gem);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int func_151243_f()
		{
			return 1;
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
