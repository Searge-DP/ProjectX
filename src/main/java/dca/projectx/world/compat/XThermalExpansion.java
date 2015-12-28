package dca.projectx.world.compat;

import cofh.api.modhelpers.ThermalExpansionHelper;
import cpw.mods.fml.common.Loader;
import dca.projectx.lib.XLogger;
import dca.projectx.world.XWorldBlocks;
import dca.projectx.world.XWorldItems;
import net.minecraft.item.ItemStack;

public class XThermalExpansion {
	
	public static void loadModule(){
		if(Loader.isModLoaded("ThermalExpansion")){
			XLogger.info("Thermal Expansion found !");
			doStuff();
		}
		else
			XLogger.info("Thermal Expansion not found...");
	}
	
	public static void doStuff(){
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 0), new ItemStack(XWorldItems.dust, 2, 0));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 1), new ItemStack(XWorldItems.dust, 2, 1));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 2), new ItemStack(XWorldItems.dust, 2, 2));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 3), new ItemStack(XWorldItems.dust, 2, 3));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 4), new ItemStack(XWorldItems.dust, 2, 4));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldBlocks.oreAluminum, 1), new ItemStack(XWorldItems.dust, 2, 5));
		
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.ingot, 1, 0), new ItemStack(XWorldItems.dust, 1, 0));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.ingot, 1, 1), new ItemStack(XWorldItems.dust, 1, 1));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.ingot, 1, 2), new ItemStack(XWorldItems.dust, 1, 2));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.ingot, 1, 3), new ItemStack(XWorldItems.dust, 1, 3));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.ingot, 1, 4), new ItemStack(XWorldItems.dust, 1, 4));
		ThermalExpansionHelper.addPulverizerRecipe(2400, new ItemStack(XWorldItems.ingot, 1, 5), new ItemStack(XWorldItems.dust, 1, 5));
	}

}
