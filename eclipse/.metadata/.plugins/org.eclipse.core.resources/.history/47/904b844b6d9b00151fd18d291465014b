package dca.projectx.world;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dca.projectx.util.XLogger;

@Mod
(modid=ProjectXWorld.MODID, name=ProjectXWorld.NAME, version=ProjectXWorld.VERSION)

public class ProjectXWorld {
	
	public static final String MODID = "ProjectXWorld";
	public static final String NAME = "ProjectX World";
	public static final String VERSION = "0.0.1";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		XWorldBlocks.preInit();
		XWorldItems.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		XLogger.info("World Module Initialized !");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
