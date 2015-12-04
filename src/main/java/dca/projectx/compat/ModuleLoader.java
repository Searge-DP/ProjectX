package dca.projectx.compat;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import dca.projectx.util.XLogger;

/**
 * ModuleLoader for all compat Modules.
 * @author KitsuneAlex
 *
 */

public class ModuleLoader {
	
	public static void postInit(){
		if(Loader.isModLoaded("thermalfoundation")){
			XLogger.info("Thermal Foundation found !");
			ModuleTF.preInit();
		}
		else
			XLogger.info("Thermal Foundation not found...");
		if(Loader.isModLoaded("thermalexpansion")){
			XLogger.info("Thermal Expansion found !");
			ModuleTE.postInit();
		}
		else
			XLogger.info("Thermal Expansion not found...");
		if(Loader.isModLoaded("immersiveengineering")){
			XLogger.info("Immersive Engineering found !");
			ModuleIE.preInit();
		}
		else
			XLogger.info("Immersive Engineering not found...");
	}

}
