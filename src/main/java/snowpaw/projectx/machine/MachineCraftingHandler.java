package snowpaw.projectx.machine;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import snowpaw.projectx.world.XWorldItems;

public class MachineCraftingHandler {
	
	public static GameRegistry reg = null;
	
	public static void registerRecipes(){
		//reg.addRecipe(new ItemStack(XMachineBlocks.eBrickBlue, 5), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 0), 'C', Blocks.stonebrick, 'V', Items.redstone});
		//reg.addRecipe(new ItemStack(XMachineBlocks.eBrickGreen, 5), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 1), 'C', Blocks.stonebrick, 'V', Items.redstone});
		//reg.addRecipe(new ItemStack(XMachineBlocks.eBrickRed, 5), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 2), 'C', Blocks.stonebrick, 'V', Items.redstone});
		//reg.addRecipe(new ItemStack(XMachineBlocks.eBrickDark, 5), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 3), 'C', Blocks.stonebrick, 'V', Items.redstone});
		//reg.addRecipe(new ItemStack(XMachineBlocks.eBrickLight, 5), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 4), 'C', Blocks.stonebrick, 'V', Items.redstone});
		
		reg.addRecipe(new ItemStack(XMachineItems.wrench, 1), new Object[]{"X X", " C ", " X ", 'C', Items.iron_ingot, 'X', new ItemStack(XWorldItems.ingot, 1, 5)});

		//reg.addRecipe(new ItemStack(XMachineBlocks.xycroniumWater, 2), new Object[]{" X ", "CVC", " X ", 'X', Items.water_bucket, 'C', Items.iron_ingot, 'V', XMachineBlocks.eBrickBlue});
		//reg.addRecipe(new ItemStack(XMachineBlocks.xycroniumSoil, 2), new Object[]{" X ", "CVC", " X ", 'X', Blocks.dirt, 'C', Blocks.sapling, 'V', XMachineBlocks.eBrickGreen});
		//reg.addRecipe(new ItemStack(XMachineBlocks.xycroniumFire, 2), new Object[]{" S ", "CVC", " X ", 'S', Items.flint_and_steel, 'X', Items.redstone, 'C', Items.iron_ingot, 'V', XMachineBlocks.eBrickRed});
		//reg.addRecipe(new ItemStack(XMachineBlocks.xycroniumVoid, 2), new Object[]{" X ", "CVC", " X ", 'X', Items.bucket, 'C', Items.iron_ingot, 'V', XMachineBlocks.eBrickDark});
		//reg.addRecipe(new ItemStack(XMachineBlocks.xycroniumIce, 2), new Object[]{" X ", "CVC", " X ", 'X', Items.snowball, 'C', Blocks.snow, 'V', XMachineBlocks.eBrickLight});
		
		reg.addRecipe(new ItemStack(XMachineBlocks.engineeringTable, 1), new Object[]{"XCX", " V ", "YYY", 'C', new ItemStack(XWorldItems.ingot, 1, 5), 'X', Items.iron_ingot, 'V', XMachineItems.energyCoreT1, 'Y', Blocks.iron_block});
	}

}
