package snowpaw.projectx.world;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.world.block.BlockXDeco;
import snowpaw.projectx.world.block.BlockXGlassViewer;
import snowpaw.projectx.world.block.BlockXOre;
import snowpaw.projectx.world.block.BlockXOreAluminum;
import snowpaw.projectx.world.block.BlockXStorageAluminum;

public class XWorldBlocks {
	
	public static Block xycroniumOre;
	public static Block xycroniumStorage;
	public static Block xycroniumBrick;
	public static Block xycroniumBrickSmall;
	public static Block xycroniumStructure;
	public static Block xycroniumPlatform;
	public static Block xycroniumShield;
	public static Block oreAluminum;
	public static Block storageAluminum;
	public static Block glassViewer;
	public static Block quartzCrystal;
	
	public static void preInit(){
		xycroniumOre = new BlockXOre("ore", Material.rock, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumStorage = new BlockXDeco("storage", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumBrick = new BlockXDeco("brick", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumBrickSmall = new BlockXDeco("bricksmall", Material.iron, ItemBlockXBase.class, "blue", "green", "red", "black", "white");
		xycroniumStructure = new BlockXDeco("structure", Material.iron, ItemBlockXBase.class, "black", "red", "green", "brown", "blue", "purple", "cyan", "lightgray", "gray", "pink", "lime", "yellow", "lightblue", "magenta", "orange", "white");
		xycroniumPlatform = new BlockXDeco("platform", Material.iron, ItemBlockXBase.class, "black", "red", "green", "brown", "blue", "purple", "cyan", "lightgray", "gray", "pink", "lime", "yellow", "lightblue", "magenta", "orange", "white");
		xycroniumShield = new BlockXDeco("shield", Material.iron, ItemBlockXBase.class, "black", "red", "green", "brown", "blue", "purple", "cyan", "lightgray", "gray", "pink", "lime", "yellow", "lightblue", "magenta", "orange", "white").setResistance(999999F);
		oreAluminum = new BlockXOreAluminum("orealuminum", Material.rock, ItemBlockXBase.class);
		storageAluminum = new BlockXStorageAluminum("storagealuminum", Material.iron, ItemBlockXBase.class);
		glassViewer = new BlockXGlassViewer("glassviewer", Material.glass, ItemBlockXBase.class);
	}

}
