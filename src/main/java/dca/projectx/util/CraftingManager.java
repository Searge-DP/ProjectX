package dca.projectx.util;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.world.XWorldBlocks;
import dca.projectx.world.XWorldItems;
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
		helper.addStorageRecipe(XWorldItems.ingot, 0, XWorldBlocks.storageBlue);
		helper.addStorageRecipe(XWorldItems.ingot, 1, XWorldBlocks.storageGreen);
		helper.addStorageRecipe(XWorldItems.ingot, 2, XWorldBlocks.storageRed);
		helper.addStorageRecipe(XWorldItems.ingot, 3, XWorldBlocks.storageDark);
		helper.addStorageRecipe(XWorldItems.ingot, 4, XWorldBlocks.storageLight);
	}

}
