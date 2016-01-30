package snowpaw.projectx.machine;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XLogger;
import snowpaw.projectx.core.render.RenderTickHandler;
import snowpaw.projectx.machine.proxy.MCommonProxy;

@Mod
(modid=ProjectXMachines.MODID, name=ProjectXMachines.NAME, version=ProjectXMachines.VERSION, dependencies=ProjectXMachines.DEPS)

public class ProjectXMachines {
	
	public static final String MODID = "ProjectXMachines";
	public static final String NAME = "ProjectX Machines";
	public static final String VERSION = "0.0.1-PRE5";
	public static final String DEPS = "after:ProjectXWorld;after:CoFHCore";
	public static final String SSIDE = "snowpaw.projectx.machine.proxy.MCommonProxy";
	public static final String CSIDE = "snowpaw.projectx.machine.proxy.MClientProxy";
	
    public int MB_PER_TANK_BLOCK = 16000;
    public boolean INSIDE_CAPACITY = false;
    public int MAX_SIZE = 8;
    public int MIN_BURNABLE_TEMPERATURE = 1300;
    public boolean SET_WORLD_ON_FIRE = true;
    public boolean SHOULD_TANKS_LEAK = true;

    public boolean TANK_RENDER_INSIDE = true;
	
	@SidedProxy
	(serverSide=ProjectXMachines.SSIDE, clientSide=ProjectXMachines.CSIDE)
	public static MCommonProxy proxy;
	
	public static ProjectXMachines instance;
	
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
