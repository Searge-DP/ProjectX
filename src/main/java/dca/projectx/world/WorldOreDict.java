package dca.projectx.world;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class WorldOreDict {
	
	public static void registerOres(){
		OreDictionary.registerOre("oreAluminum", XWorldBlocks.oreAluminum);
		OreDictionary.registerOre("ingotAluminum", new ItemStack(XWorldItems.ingot, 1, 5));
		OreDictionary.registerOre("nuggetAluminum", new ItemStack(XWorldItems.nugget, 1, 5));
		OreDictionary.registerOre("dustAluminum", new ItemStack(XWorldItems.dust, 1, 5));
		OreDictionary.registerOre("blockAluminum", XWorldBlocks.storageAluminum);
		OreDictionary.registerOre("seedCorn", XWorldItems.seedCorn);
	}

}
