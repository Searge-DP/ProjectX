package snowpaw.projectx.world;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.world.block.*;

public class XWorldBlocks {

	public static Block blockCustomGlow;
	public static Block xycroniumOreBlue;
	public static Block xycroniumOreGreen;
	public static Block xycroniumOreRed;
	public static Block xycroniumOreBlack;
	public static Block xycroniumOreWhite;
	public static Block xycroniumStorage;
	public static Block xycroniumBrick;
	public static Block xycroniumBrickSmall;
	public static Block xycroniumStructure;
	public static Block xycroniumPlatform;
	public static Block xycroniumShield;
	public static Block xycroniumBrickDark;
	public static Block xycroniumBrickLight;
	public static Block xycroniumStone;
	public static Block oreAluminum;
	public static Block storageAluminum;
	public static Block glassViewer;
	public static Block glassThick;
	public static Block cropCorn;
	public static Block elementalWater;
	public static Block elementalSoil;
	public static Block elementalFire;
	public static Block elementalLiquidVoid;
	public static Block elementalIce;
	public static Block engineeringBrick;
	public static Block quartzCrystal;
	public static Block flaxCrop;

	public static void preInit(){
		GameRegistry reg = null;
		xycroniumOreBlue = new BlockXOre(Material.rock, "oreBlue");
		xycroniumOreGreen = new BlockXOre(Material.rock, "oreGreen");
		xycroniumOreRed = new BlockXOre(Material.rock, "oreRed");
		xycroniumOreBlack = new BlockXOre(Material.rock, "oreBlack");
		xycroniumOreWhite = new BlockXOre(Material.rock, "oreWhite");
		xycroniumStorage = new BlockXDeco("storage", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumBrick = new BlockXDeco("brick", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumBrickSmall = new BlockXDeco("brick_small", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumStructure = new BlockXDeco("structure", Material.iron, ItemBlockXBase.class, "black", "red", "green", "brown", "blue", "purple", "cyan", "lightgray", "gray", "pink", "lime", "yellow", "lightblue", "magenta", "orange", "white");
		xycroniumPlatform = new BlockXDeco("platform", Material.iron, ItemBlockXBase.class, "black", "red", "green", "brown", "blue", "purple", "cyan", "lightgray", "gray", "pink", "lime", "yellow", "lightblue", "magenta", "orange", "white");
		xycroniumShield = new BlockXDeco("shield", Material.iron, ItemBlockXBase.class, "black", "red", "green", "brown", "blue", "purple", "cyan", "lightgray", "gray", "pink", "lime", "yellow", "lightblue", "magenta", "orange", "white").setResistance(999999F);
		xycroniumBrickDark = new BlockXDeco("brick_dark", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumBrickLight = new BlockXDeco("brick_light", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumStone = new BlockXDeco("infused_stone", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		oreAluminum = new BlockXOreAluminum("ore_aluminum", Material.rock, ItemBlockXBase.class);
		storageAluminum = new BlockXStorageAluminum("storage_aluminum", Material.iron, ItemBlockXBase.class);
		glassViewer = new BlockXGlassViewer("glass_viewer", Material.glass, ItemBlockXBase.class);
		glassThick = new BlockXGlassViewer("glass_thick", Material.glass, ItemBlockXBase.class);
		reg.registerBlock(cropCorn = (new BlockXCropCorn("corn", "0B", "1B", "2B", "3B", "4B", "0T")), "corn");
		engineeringBrick = new BlockEngineeringBrick("engineeringBrick", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white").setCreativeTab(XTabs.tabProjectXMachines);
		elementalWater = new BlockXElementalWater("elementalWater", Material.rock, ItemBlockXBase.class, "elementalWater");
		elementalSoil = new BlockXElementalSoil("elementalSoil",Material.rock, ItemBlockXBase.class, "elementalSoil");
		elementalFire = new BlockXElementalFire("elementalFire",Material.rock, ItemBlockXBase.class, "elementalFire");
		elementalLiquidVoid = new BlockXElementalVoid("elementalLiquidVoid", Material.rock, ItemBlockXBase.class, "elementalLiquidVoid");
		elementalIce = new BlockXElementalIce("elementalIce",Material.rock, ItemBlockXBase.class, "elementalIce");
		flaxCrop = new BlockXCropFlax();

		//quartzCrystal = new BlockXQuartzCrystal("quartzCrystal", Material.glass, ItemBlockXBase.class);
	}

}
