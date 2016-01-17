package dca.projectx.world.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.lib.helper.CraftingHelper;
import dca.projectx.world.XWorldBlocks;
import dca.projectx.world.XWorldItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class WorldCraftingHandler {
	
	public static GameRegistry reg = null;
	public static CraftingHelper helper = null;
	
	public static void registerRecipes(){
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 0), new ItemStack(XWorldItems.ingot, 1, 0), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 1), new ItemStack(XWorldItems.ingot, 1, 1), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 2), new ItemStack(XWorldItems.ingot, 1, 2), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 3), new ItemStack(XWorldItems.ingot, 1, 3), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 4), new ItemStack(XWorldItems.ingot, 1, 4), 1F);
		reg.addSmelting(XWorldBlocks.oreAluminum, new ItemStack(XWorldItems.ingot, 1, 5), 1F);
		
		helper.addStorageRecipe(XWorldItems.gem, 0, XWorldBlocks.storageBlue);
		helper.addStorageRecipe(XWorldItems.gem, 1, XWorldBlocks.storageGreen);
		helper.addStorageRecipe(XWorldItems.gem, 2, XWorldBlocks.storageRed);
		helper.addStorageRecipe(XWorldItems.gem, 3, XWorldBlocks.storageDark);
		helper.addStorageRecipe(XWorldItems.gem, 4, XWorldBlocks.storageLight);
		helper.addStorageRecipe(XWorldItems.ingot, 5, XWorldBlocks.storageAluminum);
		
		helper.addNuggetRecipe(XWorldItems.ingot, 0, XWorldItems.nugget, 0);
		helper.addNuggetRecipe(XWorldItems.ingot, 1, XWorldItems.nugget, 1);
		helper.addNuggetRecipe(XWorldItems.ingot, 2, XWorldItems.nugget, 2);
		helper.addNuggetRecipe(XWorldItems.ingot, 3, XWorldItems.nugget, 3);
		helper.addNuggetRecipe(XWorldItems.ingot, 4, XWorldItems.nugget, 4);
		helper.addNuggetRecipe(XWorldItems.ingot, 5, XWorldItems.nugget, 5);
		
		reg.addSmelting(new ItemStack(XWorldItems.dust, 1, 0), new ItemStack(XWorldItems.ingot, 1, 0), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.dust, 1, 1), new ItemStack(XWorldItems.ingot, 1, 1), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.dust, 1, 2), new ItemStack(XWorldItems.ingot, 1, 2), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.dust, 1, 3), new ItemStack(XWorldItems.ingot, 1, 3), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.dust, 1, 4), new ItemStack(XWorldItems.ingot, 1, 4), 1F);
		
		reg.addSmelting(new ItemStack(XWorldItems.seedCorn, 1), new ItemStack(XWorldItems.popCorn, 1), 3F);
		reg.addSmelting(new ItemStack(XWorldItems.foodCorn, 1), new ItemStack(XWorldItems.cobOCorn, 1), 3F);
		reg.addShapelessRecipe(new ItemStack(XWorldItems.seedCorn, 1), new Object[]{new ItemStack(XWorldItems.foodCorn, 1)});
		
		helper.addToolset(XWorldItems.ingot, 0,
				XWorldItems.swordBlue,
				XWorldItems.pickaxeBlue,
				XWorldItems.shovelBlue,
				XWorldItems.axeBlue,
				XWorldItems.hoeBlue
		);
		
		helper.addToolset(XWorldItems.ingot, 1,
				XWorldItems.swordGreen,
				XWorldItems.pickaxeGreen,
				XWorldItems.shovelGreen,
				XWorldItems.axeGreen,
				XWorldItems.hoeGreen
		);
		
		helper.addToolset(XWorldItems.ingot, 2,
				XWorldItems.swordRed,
				XWorldItems.pickaxeRed,
				XWorldItems.shovelRed,
				XWorldItems.axeRed,
				XWorldItems.hoeRed
		);
		
		helper.addToolset(XWorldItems.ingot, 3,
				XWorldItems.swordDark,
				XWorldItems.pickaxeDark,
				XWorldItems.shovelDark,
				XWorldItems.axeDark,
				XWorldItems.hoeDark
		);
		
		helper.addToolset(XWorldItems.ingot, 4,
				XWorldItems.swordLight,
				XWorldItems.pickaxeLight,
				XWorldItems.shovelLight,
				XWorldItems.axeLight,
				XWorldItems.hoeLight
		);
		
		helper.addToolset(XWorldItems.ingot, 5,
				XWorldItems.swordAluminum,
				XWorldItems.pickaxeAluminum,
				XWorldItems.shovelAluminum,
				XWorldItems.axeAluminum,
				XWorldItems.hoeAluminum
		);
		
		reg.addRecipe(new ItemStack(XWorldBlocks.glassViewer, 4), new Object[]{" X ", "XCX", " X ", 'X', Blocks.glass, 'C', new ItemStack(XWorldItems.ingot, 1, 5)});
		
		reg.addRecipe(new ItemStack(XWorldBlocks.brickBlue, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.stonebrick, 'X', new ItemStack(XWorldItems.ingot, 1, 0)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickGreen, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.stonebrick, 'X', new ItemStack(XWorldItems.ingot, 1, 1)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickRed, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.stonebrick, 'X', new ItemStack(XWorldItems.ingot, 1, 2)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickDark, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.stonebrick, 'X', new ItemStack(XWorldItems.ingot, 1, 3)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickLight, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.stonebrick, 'X', new ItemStack(XWorldItems.ingot, 1, 4)});
		
		reg.addRecipe(new ItemStack(XWorldBlocks.brickSmallBlue, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.brick_block, 'X', new ItemStack(XWorldItems.ingot, 1, 0)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickSmallGreen, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.brick_block, 'X', new ItemStack(XWorldItems.ingot, 1, 1)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickSmallRed, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.brick_block, 'X', new ItemStack(XWorldItems.ingot, 1, 2)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickSmallDark, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.brick_block, 'X', new ItemStack(XWorldItems.ingot, 1, 3)});
		reg.addRecipe(new ItemStack(XWorldBlocks.brickSmallLight, 5), new Object[]{"XCX", "CCC", "XCX", 'C', Blocks.brick_block, 'X', new ItemStack(XWorldItems.ingot, 1, 4)});
		
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
		
		helper.addColoring(XWorldBlocks.strucBlue, 0, XWorldBlocks.strucBlack);
		helper.addColoring(XWorldBlocks.strucBlue, 1, XWorldBlocks.strucRed);
		helper.addColoring(XWorldBlocks.strucBlue, 2, XWorldBlocks.strucGreen);
		helper.addColoring(XWorldBlocks.strucBlue, 3, XWorldBlocks.strucBrown);
		helper.addColoring(XWorldBlocks.strucBlue, 5, XWorldBlocks.strucPurple);
		helper.addColoring(XWorldBlocks.strucBlue, 6, XWorldBlocks.strucCyan);
		helper.addColoring(XWorldBlocks.strucBlue, 7, XWorldBlocks.strucLightGray);
		helper.addColoring(XWorldBlocks.strucBlue, 8, XWorldBlocks.strucGray);
		helper.addColoring(XWorldBlocks.strucBlue, 9, XWorldBlocks.strucPink);
		helper.addColoring(XWorldBlocks.strucBlue, 10, XWorldBlocks.strucLime);
		helper.addColoring(XWorldBlocks.strucBlue, 11, XWorldBlocks.strucYellow);
		helper.addColoring(XWorldBlocks.strucBlue, 12, XWorldBlocks.strucLightBlue);
		helper.addColoring(XWorldBlocks.strucBlue, 13, XWorldBlocks.strucMagenta);
		helper.addColoring(XWorldBlocks.strucBlue, 14, XWorldBlocks.strucOrange);
		helper.addColoring(XWorldBlocks.strucBlue, 15, XWorldBlocks.strucWhite);
		helper.addColoring(XWorldBlocks.strucGreen, 0, XWorldBlocks.strucBlack);
		helper.addColoring(XWorldBlocks.strucGreen, 1, XWorldBlocks.strucRed);
		helper.addColoring(XWorldBlocks.strucGreen, 3, XWorldBlocks.strucBrown);
		helper.addColoring(XWorldBlocks.strucGreen, 4, XWorldBlocks.strucBlue);
		helper.addColoring(XWorldBlocks.strucGreen, 5, XWorldBlocks.strucPurple);
		helper.addColoring(XWorldBlocks.strucGreen, 6, XWorldBlocks.strucCyan);
		helper.addColoring(XWorldBlocks.strucGreen, 7, XWorldBlocks.strucLightGray);
		helper.addColoring(XWorldBlocks.strucGreen, 8, XWorldBlocks.strucGray);
		helper.addColoring(XWorldBlocks.strucGreen, 9, XWorldBlocks.strucPink);
		helper.addColoring(XWorldBlocks.strucGreen, 10, XWorldBlocks.strucLime);
		helper.addColoring(XWorldBlocks.strucGreen, 11, XWorldBlocks.strucYellow);
		helper.addColoring(XWorldBlocks.strucGreen, 12, XWorldBlocks.strucLightBlue);
		helper.addColoring(XWorldBlocks.strucGreen, 13, XWorldBlocks.strucMagenta);
		helper.addColoring(XWorldBlocks.strucGreen, 14, XWorldBlocks.strucOrange);
		helper.addColoring(XWorldBlocks.strucGreen, 15, XWorldBlocks.strucWhite);
		helper.addColoring(XWorldBlocks.strucRed, 0, XWorldBlocks.strucBlack);
		helper.addColoring(XWorldBlocks.strucRed, 2, XWorldBlocks.strucGreen);
		helper.addColoring(XWorldBlocks.strucRed, 3, XWorldBlocks.strucBrown);
		helper.addColoring(XWorldBlocks.strucRed, 4, XWorldBlocks.strucBlue);
		helper.addColoring(XWorldBlocks.strucRed, 5, XWorldBlocks.strucPurple);
		helper.addColoring(XWorldBlocks.strucRed, 6, XWorldBlocks.strucCyan);
		helper.addColoring(XWorldBlocks.strucRed, 7, XWorldBlocks.strucLightGray);
		helper.addColoring(XWorldBlocks.strucRed, 8, XWorldBlocks.strucGray);
		helper.addColoring(XWorldBlocks.strucRed, 9, XWorldBlocks.strucPink);
		helper.addColoring(XWorldBlocks.strucRed, 10, XWorldBlocks.strucLime);
		helper.addColoring(XWorldBlocks.strucRed, 11, XWorldBlocks.strucYellow);
		helper.addColoring(XWorldBlocks.strucRed, 12, XWorldBlocks.strucLightBlue);
		helper.addColoring(XWorldBlocks.strucRed, 13, XWorldBlocks.strucMagenta);
		helper.addColoring(XWorldBlocks.strucRed, 14, XWorldBlocks.strucOrange);
		helper.addColoring(XWorldBlocks.strucRed, 15, XWorldBlocks.strucWhite);
		helper.addColoring(XWorldBlocks.strucBlack, 1, XWorldBlocks.strucRed);
		helper.addColoring(XWorldBlocks.strucBlack, 2, XWorldBlocks.strucGreen);
		helper.addColoring(XWorldBlocks.strucBlack, 3, XWorldBlocks.strucBrown);
		helper.addColoring(XWorldBlocks.strucBlack, 4, XWorldBlocks.strucBlue);
		helper.addColoring(XWorldBlocks.strucBlack, 5, XWorldBlocks.strucPurple);
		helper.addColoring(XWorldBlocks.strucBlack, 6, XWorldBlocks.strucCyan);
		helper.addColoring(XWorldBlocks.strucBlack, 7, XWorldBlocks.strucLightGray);
		helper.addColoring(XWorldBlocks.strucBlack, 8, XWorldBlocks.strucGray);
		helper.addColoring(XWorldBlocks.strucBlack, 9, XWorldBlocks.strucPink);
		helper.addColoring(XWorldBlocks.strucBlack, 10, XWorldBlocks.strucLime);
		helper.addColoring(XWorldBlocks.strucBlack, 11, XWorldBlocks.strucYellow);
		helper.addColoring(XWorldBlocks.strucBlack, 12, XWorldBlocks.strucLightBlue);
		helper.addColoring(XWorldBlocks.strucBlack, 13, XWorldBlocks.strucMagenta);
		helper.addColoring(XWorldBlocks.strucBlack, 14, XWorldBlocks.strucOrange);
		helper.addColoring(XWorldBlocks.strucBlack, 15, XWorldBlocks.strucWhite);
		helper.addColoring(XWorldBlocks.strucWhite, 0, XWorldBlocks.strucBlack);
		helper.addColoring(XWorldBlocks.strucWhite, 1, XWorldBlocks.strucRed);
		helper.addColoring(XWorldBlocks.strucWhite, 2, XWorldBlocks.strucGreen);
		helper.addColoring(XWorldBlocks.strucWhite, 3, XWorldBlocks.strucBrown);
		helper.addColoring(XWorldBlocks.strucWhite, 4, XWorldBlocks.strucBlue);
		helper.addColoring(XWorldBlocks.strucWhite, 5, XWorldBlocks.strucPurple);
		helper.addColoring(XWorldBlocks.strucWhite, 6, XWorldBlocks.strucCyan);
		helper.addColoring(XWorldBlocks.strucWhite, 7, XWorldBlocks.strucLightGray);
		helper.addColoring(XWorldBlocks.strucWhite, 8, XWorldBlocks.strucGray);
		helper.addColoring(XWorldBlocks.strucWhite, 9, XWorldBlocks.strucPink);
		helper.addColoring(XWorldBlocks.strucWhite, 10, XWorldBlocks.strucLime);
		helper.addColoring(XWorldBlocks.strucWhite, 11, XWorldBlocks.strucYellow);
		helper.addColoring(XWorldBlocks.strucWhite, 12, XWorldBlocks.strucLightBlue);
		helper.addColoring(XWorldBlocks.strucWhite, 13, XWorldBlocks.strucMagenta);
		helper.addColoring(XWorldBlocks.strucWhite, 14, XWorldBlocks.strucOrange);
		
		helper.addColoring(XWorldBlocks.platBlue, 0, XWorldBlocks.platBlack);
		helper.addColoring(XWorldBlocks.platBlue, 1, XWorldBlocks.platRed);
		helper.addColoring(XWorldBlocks.platBlue, 2, XWorldBlocks.platGreen);
		helper.addColoring(XWorldBlocks.platBlue, 3, XWorldBlocks.platBrown);
		helper.addColoring(XWorldBlocks.platBlue, 5, XWorldBlocks.platPurple);
		helper.addColoring(XWorldBlocks.platBlue, 6, XWorldBlocks.platCyan);
		helper.addColoring(XWorldBlocks.platBlue, 7, XWorldBlocks.platLightGray);
		helper.addColoring(XWorldBlocks.platBlue, 8, XWorldBlocks.platGray);
		helper.addColoring(XWorldBlocks.platBlue, 9, XWorldBlocks.platPink);
		helper.addColoring(XWorldBlocks.platBlue, 10, XWorldBlocks.platLime);
		helper.addColoring(XWorldBlocks.platBlue, 11, XWorldBlocks.platYellow);
		helper.addColoring(XWorldBlocks.platBlue, 12, XWorldBlocks.platLightBlue);
		helper.addColoring(XWorldBlocks.platBlue, 13, XWorldBlocks.platMagenta);
		helper.addColoring(XWorldBlocks.platBlue, 14, XWorldBlocks.platOrange);
		helper.addColoring(XWorldBlocks.platBlue, 15, XWorldBlocks.platWhite);
		helper.addColoring(XWorldBlocks.platGreen, 0, XWorldBlocks.platBlack);
		helper.addColoring(XWorldBlocks.platGreen, 1, XWorldBlocks.platRed);
		helper.addColoring(XWorldBlocks.platGreen, 3, XWorldBlocks.platBrown);
		helper.addColoring(XWorldBlocks.platGreen, 4, XWorldBlocks.platBlue);
		helper.addColoring(XWorldBlocks.platGreen, 5, XWorldBlocks.platPurple);
		helper.addColoring(XWorldBlocks.platGreen, 6, XWorldBlocks.platCyan);
		helper.addColoring(XWorldBlocks.platGreen, 7, XWorldBlocks.platLightGray);
		helper.addColoring(XWorldBlocks.platGreen, 8, XWorldBlocks.platGray);
		helper.addColoring(XWorldBlocks.platGreen, 9, XWorldBlocks.platPink);
		helper.addColoring(XWorldBlocks.platGreen, 10, XWorldBlocks.platLime);
		helper.addColoring(XWorldBlocks.platGreen, 11, XWorldBlocks.platYellow);
		helper.addColoring(XWorldBlocks.platGreen, 12, XWorldBlocks.platLightBlue);
		helper.addColoring(XWorldBlocks.platGreen, 13, XWorldBlocks.platMagenta);
		helper.addColoring(XWorldBlocks.platGreen, 14, XWorldBlocks.platOrange);
		helper.addColoring(XWorldBlocks.platGreen, 15, XWorldBlocks.platWhite);
		helper.addColoring(XWorldBlocks.platRed, 0, XWorldBlocks.platBlack);
		helper.addColoring(XWorldBlocks.platRed, 2, XWorldBlocks.platGreen);
		helper.addColoring(XWorldBlocks.platRed, 3, XWorldBlocks.platBrown);
		helper.addColoring(XWorldBlocks.platRed, 4, XWorldBlocks.platBlue);
		helper.addColoring(XWorldBlocks.platRed, 5, XWorldBlocks.platPurple);
		helper.addColoring(XWorldBlocks.platRed, 6, XWorldBlocks.platCyan);
		helper.addColoring(XWorldBlocks.platRed, 7, XWorldBlocks.platLightGray);
		helper.addColoring(XWorldBlocks.platRed, 8, XWorldBlocks.platGray);
		helper.addColoring(XWorldBlocks.platRed, 9, XWorldBlocks.platPink);
		helper.addColoring(XWorldBlocks.platRed, 10, XWorldBlocks.platLime);
		helper.addColoring(XWorldBlocks.platRed, 11, XWorldBlocks.platYellow);
		helper.addColoring(XWorldBlocks.platRed, 12, XWorldBlocks.platLightBlue);
		helper.addColoring(XWorldBlocks.platRed, 13, XWorldBlocks.platMagenta);
		helper.addColoring(XWorldBlocks.platRed, 14, XWorldBlocks.platOrange);
		helper.addColoring(XWorldBlocks.platRed, 15, XWorldBlocks.platWhite);
		helper.addColoring(XWorldBlocks.platBlack, 1, XWorldBlocks.platRed);
		helper.addColoring(XWorldBlocks.platBlack, 2, XWorldBlocks.platGreen);
		helper.addColoring(XWorldBlocks.platBlack, 3, XWorldBlocks.platBrown);
		helper.addColoring(XWorldBlocks.platBlack, 4, XWorldBlocks.platBlue);
		helper.addColoring(XWorldBlocks.platBlack, 5, XWorldBlocks.platPurple);
		helper.addColoring(XWorldBlocks.platBlack, 6, XWorldBlocks.platCyan);
		helper.addColoring(XWorldBlocks.platBlack, 7, XWorldBlocks.platLightGray);
		helper.addColoring(XWorldBlocks.platBlack, 8, XWorldBlocks.platGray);
		helper.addColoring(XWorldBlocks.platBlack, 9, XWorldBlocks.platPink);
		helper.addColoring(XWorldBlocks.platBlack, 10, XWorldBlocks.platLime);
		helper.addColoring(XWorldBlocks.platBlack, 11, XWorldBlocks.platYellow);
		helper.addColoring(XWorldBlocks.platBlack, 12, XWorldBlocks.platLightBlue);
		helper.addColoring(XWorldBlocks.platBlack, 13, XWorldBlocks.platMagenta);
		helper.addColoring(XWorldBlocks.platBlack, 14, XWorldBlocks.platOrange);
		helper.addColoring(XWorldBlocks.platBlack, 15, XWorldBlocks.platWhite);
		helper.addColoring(XWorldBlocks.platWhite, 0, XWorldBlocks.platBlack);
		helper.addColoring(XWorldBlocks.platWhite, 1, XWorldBlocks.platRed);
		helper.addColoring(XWorldBlocks.platWhite, 2, XWorldBlocks.platGreen);
		helper.addColoring(XWorldBlocks.platWhite, 3, XWorldBlocks.platBrown);
		helper.addColoring(XWorldBlocks.platWhite, 4, XWorldBlocks.platBlue);
		helper.addColoring(XWorldBlocks.platWhite, 5, XWorldBlocks.platPurple);
		helper.addColoring(XWorldBlocks.platWhite, 6, XWorldBlocks.platCyan);
		helper.addColoring(XWorldBlocks.platWhite, 7, XWorldBlocks.platLightGray);
		helper.addColoring(XWorldBlocks.platWhite, 8, XWorldBlocks.platGray);
		helper.addColoring(XWorldBlocks.platWhite, 9, XWorldBlocks.platPink);
		helper.addColoring(XWorldBlocks.platWhite, 10, XWorldBlocks.platLime);
		helper.addColoring(XWorldBlocks.platWhite, 11, XWorldBlocks.platYellow);
		helper.addColoring(XWorldBlocks.platWhite, 12, XWorldBlocks.platLightBlue);
		helper.addColoring(XWorldBlocks.platWhite, 13, XWorldBlocks.platMagenta);
		helper.addColoring(XWorldBlocks.platWhite, 14, XWorldBlocks.platOrange);
		
		helper.addColoring(XWorldBlocks.shieldBlue, 0, XWorldBlocks.shieldBlack);
		helper.addColoring(XWorldBlocks.shieldBlue, 1, XWorldBlocks.shieldRed);
		helper.addColoring(XWorldBlocks.shieldBlue, 2, XWorldBlocks.shieldGreen);
		helper.addColoring(XWorldBlocks.shieldBlue, 3, XWorldBlocks.shieldBrown);
		helper.addColoring(XWorldBlocks.shieldBlue, 5, XWorldBlocks.shieldPurple);
		helper.addColoring(XWorldBlocks.shieldBlue, 6, XWorldBlocks.shieldCyan);
		helper.addColoring(XWorldBlocks.shieldBlue, 7, XWorldBlocks.shieldLightGray);
		helper.addColoring(XWorldBlocks.shieldBlue, 8, XWorldBlocks.shieldGray);
		helper.addColoring(XWorldBlocks.shieldBlue, 9, XWorldBlocks.shieldPink);
		helper.addColoring(XWorldBlocks.shieldBlue, 10, XWorldBlocks.shieldLime);
		helper.addColoring(XWorldBlocks.shieldBlue, 11, XWorldBlocks.shieldYellow);
		helper.addColoring(XWorldBlocks.shieldBlue, 12, XWorldBlocks.shieldLightBlue);
		helper.addColoring(XWorldBlocks.shieldBlue, 13, XWorldBlocks.shieldMagenta);
		helper.addColoring(XWorldBlocks.shieldBlue, 14, XWorldBlocks.shieldOrange);
		helper.addColoring(XWorldBlocks.shieldBlue, 15, XWorldBlocks.shieldWhite);
		helper.addColoring(XWorldBlocks.shieldGreen, 0, XWorldBlocks.shieldBlack);
		helper.addColoring(XWorldBlocks.shieldGreen, 1, XWorldBlocks.shieldRed);
		helper.addColoring(XWorldBlocks.shieldGreen, 3, XWorldBlocks.shieldBrown);
		helper.addColoring(XWorldBlocks.shieldGreen, 4, XWorldBlocks.shieldBlue);
		helper.addColoring(XWorldBlocks.shieldGreen, 5, XWorldBlocks.shieldPurple);
		helper.addColoring(XWorldBlocks.shieldGreen, 6, XWorldBlocks.shieldCyan);
		helper.addColoring(XWorldBlocks.shieldGreen, 7, XWorldBlocks.shieldLightGray);
		helper.addColoring(XWorldBlocks.shieldGreen, 8, XWorldBlocks.shieldGray);
		helper.addColoring(XWorldBlocks.shieldGreen, 9, XWorldBlocks.shieldPink);
		helper.addColoring(XWorldBlocks.shieldGreen, 10, XWorldBlocks.shieldLime);
		helper.addColoring(XWorldBlocks.shieldGreen, 11, XWorldBlocks.shieldYellow);
		helper.addColoring(XWorldBlocks.shieldGreen, 12, XWorldBlocks.shieldLightBlue);
		helper.addColoring(XWorldBlocks.shieldGreen, 13, XWorldBlocks.shieldMagenta);
		helper.addColoring(XWorldBlocks.shieldGreen, 14, XWorldBlocks.shieldOrange);
		helper.addColoring(XWorldBlocks.shieldGreen, 15, XWorldBlocks.shieldWhite);
		helper.addColoring(XWorldBlocks.shieldRed, 0, XWorldBlocks.shieldBlack);
		helper.addColoring(XWorldBlocks.shieldRed, 2, XWorldBlocks.shieldGreen);
		helper.addColoring(XWorldBlocks.shieldRed, 3, XWorldBlocks.shieldBrown);
		helper.addColoring(XWorldBlocks.shieldRed, 4, XWorldBlocks.shieldBlue);
		helper.addColoring(XWorldBlocks.shieldRed, 5, XWorldBlocks.shieldPurple);
		helper.addColoring(XWorldBlocks.shieldRed, 6, XWorldBlocks.shieldCyan);
		helper.addColoring(XWorldBlocks.shieldRed, 7, XWorldBlocks.shieldLightGray);
		helper.addColoring(XWorldBlocks.shieldRed, 8, XWorldBlocks.shieldGray);
		helper.addColoring(XWorldBlocks.shieldRed, 9, XWorldBlocks.shieldPink);
		helper.addColoring(XWorldBlocks.shieldRed, 10, XWorldBlocks.shieldLime);
		helper.addColoring(XWorldBlocks.shieldRed, 11, XWorldBlocks.shieldYellow);
		helper.addColoring(XWorldBlocks.shieldRed, 12, XWorldBlocks.shieldLightBlue);
		helper.addColoring(XWorldBlocks.shieldRed, 13, XWorldBlocks.shieldMagenta);
		helper.addColoring(XWorldBlocks.shieldRed, 14, XWorldBlocks.shieldOrange);
		helper.addColoring(XWorldBlocks.shieldRed, 15, XWorldBlocks.shieldWhite);
		helper.addColoring(XWorldBlocks.shieldBlack, 1, XWorldBlocks.shieldRed);
		helper.addColoring(XWorldBlocks.shieldBlack, 2, XWorldBlocks.shieldGreen);
		helper.addColoring(XWorldBlocks.shieldBlack, 3, XWorldBlocks.shieldBrown);
		helper.addColoring(XWorldBlocks.shieldBlack, 4, XWorldBlocks.shieldBlue);
		helper.addColoring(XWorldBlocks.shieldBlack, 5, XWorldBlocks.shieldPurple);
		helper.addColoring(XWorldBlocks.shieldBlack, 6, XWorldBlocks.shieldCyan);
		helper.addColoring(XWorldBlocks.shieldBlack, 7, XWorldBlocks.shieldLightGray);
		helper.addColoring(XWorldBlocks.shieldBlack, 8, XWorldBlocks.shieldGray);
		helper.addColoring(XWorldBlocks.shieldBlack, 9, XWorldBlocks.shieldPink);
		helper.addColoring(XWorldBlocks.shieldBlack, 10, XWorldBlocks.shieldLime);
		helper.addColoring(XWorldBlocks.shieldBlack, 11, XWorldBlocks.shieldYellow);
		helper.addColoring(XWorldBlocks.shieldBlack, 12, XWorldBlocks.shieldLightBlue);
		helper.addColoring(XWorldBlocks.shieldBlack, 13, XWorldBlocks.shieldMagenta);
		helper.addColoring(XWorldBlocks.shieldBlack, 14, XWorldBlocks.shieldOrange);
		helper.addColoring(XWorldBlocks.shieldBlack, 15, XWorldBlocks.shieldWhite);
		helper.addColoring(XWorldBlocks.shieldWhite, 0, XWorldBlocks.shieldBlack);
		helper.addColoring(XWorldBlocks.shieldWhite, 1, XWorldBlocks.shieldRed);
		helper.addColoring(XWorldBlocks.shieldWhite, 2, XWorldBlocks.shieldGreen);
		helper.addColoring(XWorldBlocks.shieldWhite, 3, XWorldBlocks.shieldBrown);
		helper.addColoring(XWorldBlocks.shieldWhite, 4, XWorldBlocks.shieldBlue);
		helper.addColoring(XWorldBlocks.shieldWhite, 5, XWorldBlocks.shieldPurple);
		helper.addColoring(XWorldBlocks.shieldWhite, 6, XWorldBlocks.shieldCyan);
		helper.addColoring(XWorldBlocks.shieldWhite, 7, XWorldBlocks.shieldLightGray);
		helper.addColoring(XWorldBlocks.shieldWhite, 8, XWorldBlocks.shieldGray);
		helper.addColoring(XWorldBlocks.shieldWhite, 9, XWorldBlocks.shieldPink);
		helper.addColoring(XWorldBlocks.shieldWhite, 10, XWorldBlocks.shieldLime);
		helper.addColoring(XWorldBlocks.shieldWhite, 11, XWorldBlocks.shieldYellow);
		helper.addColoring(XWorldBlocks.shieldWhite, 12, XWorldBlocks.shieldLightBlue);
		helper.addColoring(XWorldBlocks.shieldWhite, 13, XWorldBlocks.shieldMagenta);
		helper.addColoring(XWorldBlocks.shieldWhite, 14, XWorldBlocks.shieldOrange);
	}

}
