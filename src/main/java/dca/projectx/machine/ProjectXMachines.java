package dca.projectx.machine;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dca.projectx.util.XLogger;

@Mod
(modid=ProjectXMachines.MODID, name=ProjectXMachines.NAME, version=ProjectXMachines.VERSION)

public class ProjectXMachines {
	
	public static final String MODID = "ProjectXMachines";
	public static final String NAME = "ProjectX Machines";
	public static final String VERSION = "0.0.1";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		XMachineBlocks.preInit();
		XMachineItems.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		XLogger.info("Machine Module Initialized !");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
