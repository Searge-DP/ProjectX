package snowpaw.projectx.world;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import snowpaw.projectx.lib.item.XAxeBase;
import snowpaw.projectx.lib.item.XFoodBase;
import snowpaw.projectx.lib.item.XHoeBase;
import snowpaw.projectx.lib.item.XPickaxeBase;
import snowpaw.projectx.lib.item.XSeedBase;
import snowpaw.projectx.lib.item.XShovelBase;
import snowpaw.projectx.lib.item.XSwordBase;
import snowpaw.projectx.world.item.XItemDust;
import snowpaw.projectx.world.item.XItemGem;
import snowpaw.projectx.world.item.XItemIngot;
import snowpaw.projectx.world.item.XItemNugget;

public class XWorldItems {
	
	public static Item gem;
	public static Item ingot;
	public static Item nugget;
	public static Item dust;
	public static Item seedCorn;
	public static Item foodCorn;
	public static Item cobOCorn;
	public static Item popCorn;
	public static Item swordBlue;
	public static Item pickaxeBlue;
	public static Item shovelBlue;
	public static Item axeBlue;
	public static Item hoeBlue;
	public static Item swordGreen;
	public static Item pickaxeGreen;
	public static Item shovelGreen;
	public static Item axeGreen;
	public static Item hoeGreen;
	public static Item swordRed;
	public static Item pickaxeRed;
	public static Item shovelRed;
	public static Item axeRed;
	public static Item hoeRed;
	public static Item swordDark;
	public static Item pickaxeDark;
	public static Item shovelDark;
	public static Item axeDark;
	public static Item hoeDark;
	public static Item swordLight;
	public static Item pickaxeLight;
	public static Item shovelLight;
	public static Item axeLight;
	public static Item hoeLight;
	public static Item swordAluminum;
	public static Item pickaxeAluminum;
	public static Item shovelAluminum;
	public static Item axeAluminum;
	public static Item hoeAluminum;
	
	public static ToolMaterial XYCRONIUM = EnumHelper.addToolMaterial("XYCRONIUM", 3, 250, 2, 4, 30);
	public static ToolMaterial ALUMINUM = EnumHelper.addToolMaterial("ALUMINUM", 2, 200, 2, 3, 30);
	
	public static void preInit(){
		GameRegistry reg = null;
		reg.registerItem(gem = (new XItemGem("gem", 64, "blue", "green", "red", "dark", "light")), "gem");
		reg.registerItem(ingot = (new XItemIngot("ingot", 64, "blue", "green", "red", "dark", "light", "aluminum")), "ingot");
		reg.registerItem(nugget = (new XItemNugget("nugget", 64, "blue", "green", "red", "dark", "light", "aluminum")), "nugget");
		reg.registerItem(dust = (new XItemDust("dust", 64, "blue", "green", "red", "dark", "light", "aluminum")), "dust");
		//reg.registerItem(seedCorn = (new XSeedBase(XWorldBlocks.cropCorn, "seedCorn", 64)), "seedCorn");
		reg.registerItem(foodCorn = (new XFoodBase("corn", 4, 0.5F, false)), "foodCorn");
		reg.registerItem(cobOCorn = (new XFoodBase("cobOCorn", 8, 1.0F, false)), "cobOCorn");
		reg.registerItem(popCorn = (new XFoodBase("popCorn", 6, 0.8F, false)), "popcorn");
		reg.registerItem(swordBlue = (new XSwordBase(XYCRONIUM, "tool/blue", "swordBlue")), "swordBlue");
		reg.registerItem(pickaxeBlue = (new XPickaxeBase(XYCRONIUM, "tool/blue", "pickaxeBlue")), "pickaxeBlue");
		reg.registerItem(shovelBlue = (new XShovelBase(XYCRONIUM, "tool/blue", "shovelBlue")), "shovelBlue");
		reg.registerItem(axeBlue = (new XAxeBase(XYCRONIUM, "tool/blue", "axeBlue")), "axeBlue");
		reg.registerItem(hoeBlue = (new XHoeBase(XYCRONIUM, "tool/blue", "hoeBlue")), "hoeBlue");
		reg.registerItem(swordGreen = (new XSwordBase(XYCRONIUM, "tool/green", "swordGreen")), "swordGreen");
		reg.registerItem(pickaxeGreen = (new XPickaxeBase(XYCRONIUM, "tool/green", "pickaxeGreen")), "pickaxeGreen");
		reg.registerItem(shovelGreen = (new XShovelBase(XYCRONIUM, "tool/green", "shovelGreen")), "shovelGreen");
		reg.registerItem(axeGreen = (new XAxeBase(XYCRONIUM, "tool/green", "axeGreen")), "axeGreen");
		reg.registerItem(hoeGreen = (new XHoeBase(XYCRONIUM, "tool/green", "hoeGreen")), "hoeGreen");
		reg.registerItem(swordRed = (new XSwordBase(XYCRONIUM, "tool/red", "swordRed")), "swordRed");
		reg.registerItem(pickaxeRed = (new XPickaxeBase(XYCRONIUM, "tool/red", "pickaxeRed")), "pickaxeRed");
		reg.registerItem(shovelRed = (new XShovelBase(XYCRONIUM, "tool/red", "shovelRed")), "shovelRed");
		reg.registerItem(axeRed = (new XAxeBase(XYCRONIUM, "tool/red", "axeRed")), "axeRed");
		reg.registerItem(hoeRed = (new XHoeBase(XYCRONIUM, "tool/red", "hoeRed")), "hoeRed");
		reg.registerItem(swordDark = (new XSwordBase(XYCRONIUM, "tool/dark", "swordDark")), "swordDark");
		reg.registerItem(pickaxeDark = (new XPickaxeBase(XYCRONIUM, "tool/dark", "pickaxeDark")), "pickaxeDark");
		reg.registerItem(shovelDark = (new XShovelBase(XYCRONIUM, "tool/dark", "shovelDark")), "shovelDark");
		reg.registerItem(axeDark = (new XAxeBase(XYCRONIUM, "tool/dark", "axeDark")), "axeDark");
		reg.registerItem(hoeDark = (new XHoeBase(XYCRONIUM, "tool/dark", "hoeDark")), "hoeDark");
		reg.registerItem(swordLight = (new XSwordBase(XYCRONIUM, "tool/light", "swordLight")), "swordLight");
		reg.registerItem(pickaxeLight = (new XPickaxeBase(XYCRONIUM, "tool/light", "pickaxeLight")), "pickaxeLight");
		reg.registerItem(shovelLight = (new XShovelBase(XYCRONIUM, "tool/light", "shovelLight")), "shovelLight");
		reg.registerItem(axeLight = (new XAxeBase(XYCRONIUM, "tool/light", "axeLight")), "axeLight");
		reg.registerItem(hoeLight = (new XHoeBase(XYCRONIUM, "tool/light", "hoeLight")), "hoeLight");
		reg.registerItem(swordAluminum = (new XSwordBase(ALUMINUM, "tool/aluminum", "swordAluminum")), "swordAluminum");
		reg.registerItem(pickaxeAluminum = (new XPickaxeBase(ALUMINUM, "tool/aluminum", "pickaxeAluminum")), "pickaxeAluminum");
		reg.registerItem(shovelAluminum = (new XShovelBase(ALUMINUM, "tool/aluminum", "shovelAluminum")), "shovelAluminum");
		reg.registerItem(axeAluminum = (new XAxeBase(ALUMINUM, "tool/aluminum", "axeAluminum")), "axeAluminum");
		reg.registerItem(hoeAluminum = (new XHoeBase(ALUMINUM, "tool/aluminum", "hoeAluminum")), "hoeAluminum");
	}

}
