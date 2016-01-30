package snowpaw.projectx.world;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
		
	}

}
