package dca.projectx.machine;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dca.projectx.lib.XLogger;
import dca.projectx.lib.render.RenderTickHandler;
import dca.projectx.machine.handler.MachineCraftingHandler;
import dca.projectx.machine.proxy.MCommonProxy;

@Mod
(modid=ProjectXMachines.MODID, name=ProjectXMachines.NAME, version=ProjectXMachines.VERSION, dependencies=ProjectXMachines.DEPS)

public class ProjectXMachines {
	
	public static final String MODID = "ProjectXMachines";
	public static final String NAME = "ProjectX Machines";
	public static final String VERSION = "0.0.1";
	public static final String DEPS = "after:ProjectXWorld;after:CoFHCore";
	public static final String SSIDE = "dca.projectx.machine.proxy.MCommonProxy";
	public static final String CSIDE = "dca.projectx.machine.proxy.MClientProxy";
	
	@SidedProxy
	(serverSide=ProjectXMachines.SSIDE, clientSide=ProjectXMachines.CSIDE)
	public static MCommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		proxy.preInit();
		XMachineBlocks.preInit();
		XMachineItems.preInit();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init();
		XLogger.info("Machine Module Initialized !");
		FMLCommonHandler.instance().bus().register(new RenderTickHandler());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit();
		MachineCraftingHandler.registerRecipes();
	}

}
