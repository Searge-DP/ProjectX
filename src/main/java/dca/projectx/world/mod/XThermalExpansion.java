package dca.projectx.world.mod;

import cofh.api.modhelpers.ThermalExpansionHelper;
import dca.projectx.world.XWorldItems;
import net.minecraft.item.ItemStack;

public class XThermalExpansion {
	
	public static void init(){
		ThermalExpansionHelper reg = null;
		reg.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 0), new ItemStack(XWorldItems.dust, 2, 0));
		reg.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 1), new ItemStack(XWorldItems.dust, 2, 1));
		reg.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 2), new ItemStack(XWorldItems.dust, 2, 2));
		reg.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 3), new ItemStack(XWorldItems.dust, 2, 3));
		reg.addPulverizerRecipe(2400, new ItemStack(XWorldItems.gem, 1, 4), new ItemStack(XWorldItems.dust, 2, 4));
		reg.addPulverizerRecipe(2400, new ItemStack(XWorldItems.ingot, 1, 5), new ItemStack(XWorldItems.dust, 1, 5));
	}

}
