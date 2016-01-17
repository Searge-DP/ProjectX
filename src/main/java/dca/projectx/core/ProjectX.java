package dca.projectx.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dca.projectx.core.proxy.CommonProxy;
import dca.projectx.lib.XConfig;
import dca.projectx.lib.XLogger;
import dca.projectx.lib.render.RenderTickHandler;

@Mod
(modid=ProjectX.MODID, name=ProjectX.NAME, version=ProjectX.VERSION)

public class ProjectX {
	
	public static int idCounter;
	public static int countBlocks = 80;
	
	@SidedProxy
	(clientSide=ProjectX.CSIDE, serverSide=ProjectX.SSIDE)
	public static CommonProxy proxy;
	
	@Instance
	(value=ProjectX.INSTANCE)
	public static ProjectX instance;
	
	public static final String MODID = "ProjectX";
	public static final String NAME = "ProjectX";
	public static final String VERSION = "0.0.1-PRE5";
	public static final String INSTANCE = "projectx";
	public static final String CSIDE = "dca.projectx.core.proxy.ClientProxy";
	public static final String SSIDE = "dca.projectx.core.proxy.CommonProxy";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		proxy.preInit();
		XLogger.debug("ProjectX Debugging...");
		XConfig.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init();
		XLogger.info("Core Module Initialized !");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit();
	}

}
