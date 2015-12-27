package dca.projectx.world;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class WorldOreDict {
	
	public static void registerOres(){
		OreDictionary.registerOre("oreXycroniumBlue", XWorldBlocks.oreBlue);
		OreDictionary.registerOre("oreXycroniumGreen", XWorldBlocks.oreGreen);
		OreDictionary.registerOre("oreXycroniumRed", XWorldBlocks.oreRed);
		OreDictionary.registerOre("oreXycroniumDark", XWorldBlocks.oreDark);
		OreDictionary.registerOre("oreXycroniumLight", XWorldBlocks.oreLight);
		OreDictionary.registerOre("oreAluminum", XWorldBlocks.oreAluminum);
		OreDictionary.registerOre("gemXycroniumBlue", new ItemStack(XWorldItems.gem, 1, 0));
		OreDictionary.registerOre("gemXycroniumGreen", new ItemStack(XWorldItems.gem, 1, 1));
		OreDictionary.registerOre("gemXycroniumRed", new ItemStack(XWorldItems.gem, 1, 2));
		OreDictionary.registerOre("gemXycroniumDark", new ItemStack(XWorldItems.gem, 1, 3));
		OreDictionary.registerOre("gemXycroniumLight", new ItemStack(XWorldItems.gem, 1, 4));
		OreDictionary.registerOre("ingotXycroniumBlue", new ItemStack(XWorldItems.ingot, 1, 0));
		OreDictionary.registerOre("ingotXycroniumGreen", new ItemStack(XWorldItems.ingot, 1, 1));
		OreDictionary.registerOre("ingotXycroniumRed", new ItemStack(XWorldItems.ingot, 1, 2));
		OreDictionary.registerOre("ingotXycroniumDark", new ItemStack(XWorldItems.ingot, 1, 3));
		OreDictionary.registerOre("ingotXycroniumLight", new ItemStack(XWorldItems.ingot, 1, 4));
		OreDictionary.registerOre("ingotAluminum", new ItemStack(XWorldItems.ingot, 1, 5));
		OreDictionary.registerOre("nuggetXycroniumBlue", new ItemStack(XWorldItems.nugget, 1, 0));
		OreDictionary.registerOre("nuggetXycroniumGreen", new ItemStack(XWorldItems.nugget, 1, 1));
		OreDictionary.registerOre("nuggetXycroniumRed", new ItemStack(XWorldItems.nugget, 1, 2));
		OreDictionary.registerOre("nuggetXycroniumDark", new ItemStack(XWorldItems.nugget, 1, 3));
		OreDictionary.registerOre("nuggetXycroniumLight", new ItemStack(XWorldItems.nugget, 1, 4));
		OreDictionary.registerOre("nuggetAluminum", new ItemStack(XWorldItems.nugget, 1, 5));
		OreDictionary.registerOre("dustXycroniumBlue", new ItemStack(XWorldItems.dust, 1, 0));
		OreDictionary.registerOre("dustXycroniumGreen", new ItemStack(XWorldItems.dust, 1, 1));
		OreDictionary.registerOre("dustXycroniumRed", new ItemStack(XWorldItems.dust, 1, 2));
		OreDictionary.registerOre("dustXycroniumDark", new ItemStack(XWorldItems.dust, 1, 3));
		OreDictionary.registerOre("dustXycroniumLight", new ItemStack(XWorldItems.dust, 1, 4));
		OreDictionary.registerOre("dustAluminum", new ItemStack(XWorldItems.dust, 1, 5));
		OreDictionary.registerOre("blockXycroniumBlue", XWorldBlocks.storageBlue);
		OreDictionary.registerOre("blockXycroniumGreen", XWorldBlocks.storageGreen);
		OreDictionary.registerOre("blockXycroniumRed", XWorldBlocks.storageRed);
		OreDictionary.registerOre("blockXycroniumDark", XWorldBlocks.storageDark);
		OreDictionary.registerOre("blockXycroniumLight", XWorldBlocks.storageLight);
		OreDictionary.registerOre("blockAluminum", XWorldBlocks.storageAluminum);
		OreDictionary.registerOre("seedCorn", XWorldItems.seedCorn);
	}

}
