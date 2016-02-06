package snowpaw.projectx.world;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.world.block.BlockXDeco;
import snowpaw.projectx.world.block.BlockXGlassViewer;
import snowpaw.projectx.world.block.BlockXOre;
import snowpaw.projectx.world.block.BlockXOreAluminum;
import snowpaw.projectx.world.block.BlockXQuartzCrystal;
import snowpaw.projectx.world.block.BlockXStorageAluminum;

public class XWorldBlocks {
	
	public static Block xycroniumOre;
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
	
	public static Block quartzCrystal;
	
	public static void preInit(){
		xycroniumOre = new BlockXOre("ore", Material.rock, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
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
		
		//quartzCrystal = new BlockXQuartzCrystal("quartzCrystal", Material.glass, ItemBlockXBase.class);
	}

}
