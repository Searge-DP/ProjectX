package snowpaw.projectx.world;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import snowpaw.projectx.compat.ModuleLoader;
import snowpaw.projectx.core.XConfig;
import snowpaw.projectx.core.XLogger;
import snowpaw.projectx.world.generate.XWorldGenerator;
import snowpaw.projectx.world.proxy.WCommonProxy;

@Mod
(modid=ProjectXWorld.MODID, name=ProjectXWorld.NAME, version=ProjectXWorld.VERSION, dependencies=ProjectXWorld.DEPS)

public class ProjectXWorld {
	
	public static final String MODID = "ProjectXWorld";
	public static final String NAME = "ProjectX World";
	public static final String VERSION = "0.0.2-PRE1";
	public static final String DEPS = "after:ProjectX";
	public static final String SSIDE = "snowpaw.projectx.world.proxy.WCommonProxy";
	public static final String CSIDE = "snowpaw.projectx.world.proxy.WClientProxy";
	
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
		WorldOreDict.registerOres();
		forgeHooks();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit();
		WorldCraftingHandler.registerRecipes();
		ModuleLoader.postInit();
	}
	
	public void forgeHooks(){
		MinecraftForge.addGrassSeed(new ItemStack(XWorldItems.seedCorn), XConfig.cornSeedDropChance);
		MinecraftForge.addGrassSeed(new ItemStack(XWorldItems.itemCustom,1,2), XConfig.cornSeedDropChance);
		GameRegistry.registerWorldGenerator(new XWorldGenerator(), 0);
	}

}
