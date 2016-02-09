package snowpaw.projectx.world;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;
import snowpaw.projectx.lib.helper.CraftingHelper;

public class WorldCraftingHandler {
	
	public static GameRegistry reg = null;
	public static CraftingHelper helper = null;
	
	public static void registerRecipes(){
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 0), new ItemStack(XWorldItems.ingot, 1, 0), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 1), new ItemStack(XWorldItems.ingot, 1, 1), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 2), new ItemStack(XWorldItems.ingot, 1, 2), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 3), new ItemStack(XWorldItems.ingot, 1, 3), 1F);
		reg.addSmelting(new ItemStack(XWorldItems.gem, 1, 4), new ItemStack(XWorldItems.ingot, 1, 4), 1F);
		
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

		for(int ix = 0; ix < 5; ix++)
		{
			helper.addStorageRecipe(new ItemStack(XWorldItems.ingot, 1, ix), new ItemStack(XWorldBlocks.xycroniumStorage,1,ix));
			reg.addRecipe(new ItemStack(XWorldBlocks.xycroniumBrick, 4, ix), new Object[]{"XAX","AAA","XAX", 'X' , new ItemStack(XWorldItems.ingot, 1, ix), 'A', Blocks.stonebrick});
			reg.addRecipe(new ItemStack(XWorldBlocks.engineeringBrick, 4, ix), new Object[]{"isi","srs","isi", 'i', new ItemStack(XWorldItems.ingot,1,ix), 's', Blocks.stonebrick, 'r', Items.redstone
			});
			reg.addRecipe(new ItemStack(XWorldBlocks.xycroniumBrickSmall, 4,ix), new Object[]{"XX","XX", 'X', new ItemStack(XWorldBlocks.xycroniumBrick,1,ix)});
		}
		for(int zy = 0; zy < 16; zy++)
		{
			reg.addRecipe(new ItemStack(XWorldBlocks.xycroniumPlatform, 4, zy), new Object[]{"YXY","ODO", "YXY", 'Y', new ItemStack(XWorldItems.ingot,1, OreDictionary.WILDCARD_VALUE), 'X', Blocks.stonebrick, 'O', Blocks.obsidian, 'D', new ItemStack(Items.dye,1,zy)});
			reg.addRecipe(new ItemStack(XWorldBlocks.xycroniumStructure, 4, zy), new Object[]{"IXI","XDX","IXI", 'I', new ItemStack(XWorldItems.ingot,1, OreDictionary.WILDCARD_VALUE), 'D', new ItemStack(Items.dye, 1,zy), 'X', Blocks.stonebrick});
			reg.addRecipe(new ItemStack(XWorldBlocks.xycroniumShield, 4, zy), new Object[]{"XAX","AXA","XAX", 'A', Items.iron_ingot, 'X', new ItemStack(XWorldBlocks.xycroniumStructure, 1, zy)});
		}

		reg.addRecipe(new ItemStack(XWorldBlocks.elementalWater,2,0), new Object[]{"ese","sws","ese", 'e', new ItemStack(XWorldBlocks.engineeringBrick), 's', Blocks.stone, 'w', Items.water_bucket});
		reg.addRecipe(new ItemStack(XWorldBlocks.elementalSoil,2,0), new Object[]{"ese","sis", "ese", 'e', new ItemStack(XWorldBlocks.engineeringBrick, 1, 1), 'i', Items.iron_ingot, 's', Blocks.sapling});
		reg.addRecipe(new ItemStack(XWorldBlocks.elementalFire,1,0), new Object[]{"ebe","sgs","ese", 'e', new ItemStack(XWorldBlocks.engineeringBrick, 1, 2), 'b', Blocks.iron_bars, 'g', Items.gunpowder, 's', Blocks.stone});
		reg.addRecipe(new ItemStack(XWorldBlocks.elementalFire,2,0), new Object[]{"ebe","sgs","ese", 'e', new ItemStack(XWorldBlocks.engineeringBrick, 1, 2), 'b', Blocks.iron_bars, 'g', Items.lava_bucket, 's', Blocks.stone});
		reg.addRecipe(new ItemStack(XWorldBlocks.elementalLiquidVoid,2,0), new Object[]{"ese","sws","ese", 'e', new ItemStack(XWorldBlocks.engineeringBrick, 1,3), 's', Blocks.stone, 'w', /*Items.milk_bucket*/Items.bucket});
		reg.addRecipe(new ItemStack(XWorldBlocks.elementalIce,2,0), new Object[]{"ese","sws","ese", 'e', new ItemStack(XWorldBlocks.engineeringBrick, 1, 4), 's', Blocks.stone, 'w', Items.snowball});
		reg.addShapelessRecipe(new ItemStack(Items.string,1,0), new Object[]{new ItemStack(XWorldItems.itemCustom,1,2),  new ItemStack(XWorldItems.itemCustom,1,2)});
		
	}

}
