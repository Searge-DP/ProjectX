package dca.projectx.util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Generic Crafting Helper Class
 * @author KitsuneAlex
 *
 */

public class CraftingHelper {
	
	/**
	 * Adds a ore storage recipe (with reversed crafting !)
	 * @param input
	 * @param inputMeta
	 * @param output
	 */
	public static void addStorageRecipe(Item input, int inputMeta, Block output){
		GameRegistry reg = null;
		reg.addRecipe(new ItemStack(output, 1, 0), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(input, 1, inputMeta)});
		reg.addShapelessRecipe(new ItemStack(input, 9, inputMeta), new Object[]{new ItemStack(output, 1, 0)});
	}
	
	/**
	 * Adds a gear recipe 
	 * @param material
	 * @param matMeta
	 * @param output
	 * @param outputMeta
	 */
	public static void addGearRecipe(Item material, int matMeta, Item output, int outputMeta){
		GameRegistry reg = null;
		reg.addRecipe(new ItemStack(output, 1, outputMeta), new Object[]{" X ", "CXC", " X ", 'X', new ItemStack(material, 1, matMeta), 'C', Items.iron_ingot});
	}
	
	/**
	 * Adds a nugget storage recipe (with reversed crafting !)
	 * @param input
	 * @param inputMeta
	 * @param output
	 * @param outputMeta
	 */
	public static void addNuggetRecipe(Item input, int inputMeta, Item output, int outputMeta){
		GameRegistry reg = null;
		reg.addShapelessRecipe(new ItemStack(output, 9, outputMeta), new Object[]{new ItemStack(input, 1, inputMeta)});
		reg.addRecipe(new ItemStack(input, 1, inputMeta), new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(output, 1, outputMeta)});
	}
	
	/**
	 * Method for adding a simple dye-coloring recipe
	 * @param input
	 * @param color
	 * @param output
	 */
	public static void addColoring(Block input, int color, Block output){
		GameRegistry reg = null;
		reg.addRecipe(new ItemStack(output, 4), new Object[]{" X ", "XCX", " X ", 'X', input, 'C', new ItemStack(Items.dye, 1, color)});
	}

}
