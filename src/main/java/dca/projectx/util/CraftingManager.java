package dca.projectx.util;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.machine.XMachineBlocks;
import dca.projectx.machine.XMachineItems;
import dca.projectx.world.XWorldBlocks;
import dca.projectx.world.XWorldItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingManager {
	
	public static GameRegistry reg = null;
	public static CraftingHelper helper = null;
	
	public static void postInit(){
		helper.addStorageRecipe(XWorldItems.gem, 0, XWorldBlocks.storageBlue);
		helper.addStorageRecipe(XWorldItems.gem, 1, XWorldBlocks.storageGreen);
		helper.addStorageRecipe(XWorldItems.gem, 2, XWorldBlocks.storageRed);
		helper.addStorageRecipe(XWorldItems.gem, 3, XWorldBlocks.storageDark);
		helper.addStorageRecipe(XWorldItems.gem, 4, XWorldBlocks.storageLight);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 0), new ItemStack(XWorldItems.ingot, 1, 0), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 1), new ItemStack(XWorldItems.ingot, 1, 1), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 2), new ItemStack(XWorldItems.ingot, 1, 2), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 3), new ItemStack(XWorldItems.ingot, 1, 3), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 4), new ItemStack(XWorldItems.ingot, 1, 4), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.seedCorn, 1), new ItemStack(XWorldItems.popCorn, 1), 3F);
		reg.addSmelting(new ItemStack(XWorldItems.foodCorn, 1), new ItemStack(XWorldItems.cobOCorn, 1), 3F);
		reg.addShapelessRecipe(new ItemStack(XWorldItems.seedCorn, 1), new Object[]{new ItemStack(XWorldItems.foodCorn, 1)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickBlue, 5), new Object[]{"XCX", "CCC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 0), 'C', Blocks.stonebrick});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickGreen, 5), new Object[]{"XCX", "CCC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 1), 'C', Blocks.stonebrick});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickRed, 5), new Object[]{"XCX", "CCC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 2), 'C', Blocks.stonebrick});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickDark, 5), new Object[]{"XCX", "CCC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 3), 'C', Blocks.stonebrick});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickLight, 5), new Object[]{"XCX", "CCC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 4), 'C', Blocks.stonebrick});
		reg.addRecipe(new ItemStack(XWorldBlocks.strucBlue, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 0), 'C', Blocks.stonebrick, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.strucGreen, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 1), 'C', Blocks.stonebrick, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.strucRed, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 2), 'C', Blocks.stonebrick, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.strucBlack, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 3), 'C', Blocks.stonebrick, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.strucWhite, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 4), 'C', Blocks.stonebrick, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.platBlue, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 0), 'C', Blocks.glass, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.platGreen, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 1), 'C', Blocks.glass, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.platRed, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 2), 'C', Blocks.glass, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.platBlack, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 3), 'C', Blocks.glass, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.platWhite, 4), new Object[]{"XCX", "CVC", "XCX", 'X', new ItemStack(XWorldItems.ingot, 1, 4), 'C', Blocks.glass, 'V', Items.iron_ingot});
		reg.addRecipe(new ItemStack(XWorldBlocks.shieldBlue, 4), new Object[]{"XCX", "CXC", "XCX", 'X', Items.iron_ingot, 'C', XWorldBlocks.platBlue});
		reg.addRecipe(new ItemStack(XWorldBlocks.shieldGreen, 4), new Object[]{"XCX", "CXC", "XCX", 'X', Items.iron_ingot, 'C', XWorldBlocks.platGreen});
		reg.addRecipe(new ItemStack(XWorldBlocks.shieldRed, 4), new Object[]{"XCX", "CXC", "XCX", 'X', Items.iron_ingot, 'C', XWorldBlocks.platRed});
		reg.addRecipe(new ItemStack(XWorldBlocks.shieldBlack, 4), new Object[]{"XCX", "CXC", "XCX", 'X', Items.iron_ingot, 'C', XWorldBlocks.platBlack});
		reg.addRecipe(new ItemStack(XWorldBlocks.shieldWhite, 4), new Object[]{"XCX", "CXC", "XCX", 'X', Items.iron_ingot, 'C', XWorldBlocks.platWhite});
		
		colorCrafting();
	}
	
	public static void colorCrafting(){
		
	}

}
