package dca.projectx.machine.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.machine.XMachineBlocks;
import dca.projectx.machine.XMachineItems;
import dca.projectx.world.XWorldItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MachineCraftingHandler {
	
	public static GameRegistry reg = null;
	
	public static void registerRecipes(){
		reg.addRecipe(new ItemStack(XMachineItems.wrench, 1), new Object[]{"X X", " C ", " X ", 'C', Items.iron_ingot, 'X', new ItemStack(XWorldItems.ingot, 1, 5)});
		
		reg.addRecipe(new ItemStack(XMachineBlocks.engineeringTable, 1), new Object[]{"XCX", " V ", "YYY", 'C', new ItemStack(XWorldItems.ingot, 1, 5), 'X', Items.iron_ingot, 'V', XMachineItems.energyCoreT1, 'Y', Blocks.iron_block});
	}

}
