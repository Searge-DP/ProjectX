package dca.projectx.world;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.lib.XLogger;
import dca.projectx.world.gen.XGenOre;
import dca.projectx.world.proxy.WCommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod
(modid=ProjectXWorld.MODID, name=ProjectXWorld.NAME, version=ProjectXWorld.VERSION, dependencies=ProjectXWorld.DEPS)

public class ProjectXWorld {
	
	public static final String MODID = "ProjectXWorld";
	public static final String NAME = "ProjectX World";
	public static final String VERSION = "0.0.1";
	public static final String DEPS = "after:ProjectX";
	public static final String SSIDE = "dca.projectx.world.proxy.WCommonProxy";
	public static final String CSIDE = "dca.projectx.world.proxy.WClientProxy";
	
	@SidedProxy
	(serverSide=ProjectXWorld.SSIDE, clientSide=ProjectXWorld.CSIDE)
	public static WCommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		proxy.preInit();
		XWorldBlocks.preInit();
		XWorldItems.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init();
		XLogger.info("World Module Initialized !");
		forgeHooks();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit();
	}
	
	public void forgeHooks(){
		MinecraftForge.addGrassSeed(new ItemStack(XWorldItems.seedCorn), 2);
		GameRegistry.registerWorldGenerator(new XGenOre(), 0);
	}

}
