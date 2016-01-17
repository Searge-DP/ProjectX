package dca.projectx.lib;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class XConfig {
	
	public static String CAT_WORLD = "world config";
	public static String CAT_MACHINES = "machines config";
	public static String CAT_MISC = "misc config";
	
	public static boolean tfSupport;
	public static boolean teSupport;
	public static boolean eioSupport;
	
	public static boolean fancyPipes;
	public static boolean experimentalFunctions;
	
	public static int xOreSpawnChance;
	public static int aOreSpawnChance;
	public static int cornSeedDropChance;
	
	public static void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.load();
		
		XLogger.info("Configuration file loaded !");
		
		//Add all categorys
		config.addCustomCategoryComment(CAT_WORLD, "Here you will find all options related to the World Module.");
		config.addCustomCategoryComment(CAT_MACHINES, "Here you will find all options related to the Machines Module.");
		config.addCustomCategoryComment(CAT_MISC, "Here you will find misc options related to ProjectX.");
		
		//Add all flags and vars
		xOreSpawnChance = config.getInt("xycroniumOreSpawnChance", CAT_WORLD, 12, 1, 30, "Chance for Xycronium Ore to spawn.");
		aOreSpawnChance = config.getInt("aluminumOreSpawnChance", CAT_WORLD, 10, 1, 30, "Chance for Aluminum Ore to spawn.");
		cornSeedDropChance = config.getInt("cornSeedDropChance", CAT_WORLD, 2, 1, 10, "Chance for Corn Seed to drop from Grass.");
		
		fancyPipes = config.getBoolean("fancyPipes", CAT_MACHINES, true, "Render inside of Pulse Pipes. (shouldn't affect performance at all)");
		experimentalFunctions = config.getBoolean("enableExpFunctions", CAT_MACHINES, false, "Experimental functions. Expect bugs !");
		
		tfSupport = config.getBoolean("thermalFoundationCompat", CAT_MISC, true, "Manually disable/enable Thermal Foundation support.");
		teSupport = config.getBoolean("thermalExpansionCompat", CAT_MISC, true, "Manually disable/enable Thermal Expansion support.");
		eioSupport = config.getBoolean("enderIOCompat", CAT_MISC, true, "Manually disable/enable Ender IO support.");
		
		config.save();
	}

}
