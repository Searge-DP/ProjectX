package dca.projectx.world;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.core.item.XFoodBase;
import dca.projectx.core.item.XSeedBase;
import dca.projectx.world.item.XItemDust;
import dca.projectx.world.item.XItemGem;
import dca.projectx.world.item.XItemIngot;
import dca.projectx.world.item.XItemNugget;
import net.minecraft.item.Item;

public class XWorldItems {
	
	public static Item gem;
	public static Item ingot;
	public static Item nugget;
	public static Item dust;
	public static Item seedCorn;
	public static Item foodCorn;
	public static Item cobOCorn;
	public static Item popCorn;
	
	public static void preInit(){
		GameRegistry reg = null;
		reg.registerItem(gem = (new XItemGem("gem", 64, "blue", "green", "red", "dark", "light")), "gem");
		reg.registerItem(ingot = (new XItemIngot("ingot", 64, "blue", "green", "red", "dark", "light", "aluminum")), "ingot");
		reg.registerItem(nugget = (new XItemNugget("nugget", 64, "blue", "green", "red", "dark", "light", "aluminum")), "nugget");
		reg.registerItem(dust = (new XItemDust("dust", 64, "blue", "green", "red", "dark", "light", "aluminum")), "dust");
		reg.registerItem(seedCorn = (new XSeedBase(XWorldBlocks.cropCorn, "seedCorn", 64)), "seedCorn");
		reg.registerItem(foodCorn = (new XFoodBase("corn", 4, 0.5F, false)), "foodCorn");
		reg.registerItem(cobOCorn = (new XFoodBase("cobOCorn", 8, 1.0F, false)), "cobOCorn");
		reg.registerItem(popCorn = (new XFoodBase("popCorn", 6, 0.8F, false)), "popcorn");
	}

}
