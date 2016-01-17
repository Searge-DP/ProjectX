package dca.projectx.world.mod;

import cpw.mods.fml.common.Loader;
import dca.projectx.lib.XConfig;
import dca.projectx.lib.XLogger;

public class ModuleLoader {
	
	public static final String LOG = "[Compat] ";
	
	public static void postInit(){
		if(Loader.isModLoaded("CoFHCore")){
			XLogger.info(LOG + "CoFHCore found !");
		}
		else
			XLogger.info(LOG + "CoFHCore not found...");
		
		if(Loader.isModLoaded("ThermalFoundation") && (XConfig.tfSupport = true)){
			XLogger.info(LOG + "Thermal Foundation found !");
			XThermalFoundation.init();
		}
		else
			XLogger.info(LOG + "Thermal Foundation not found...");
		
		if(Loader.isModLoaded("ThermalExpansion") && (XConfig.teSupport = true)){
			XLogger.info(LOG + "Thermal Expansion found !");
			XThermalExpansion.init();
		}
		else
			XLogger.info(LOG + "Thermal Expansion not found...");
		
		if(Loader.isModLoaded("EnderIO") && (XConfig.eioSupport = true)){
			XLogger.info(LOG + "Ender IO found !");
			XEnderIO.init();
		}
		else
			XLogger.info(LOG + "Ender IO not found...");
	}

}
