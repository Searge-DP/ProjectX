package dca.projectx.world;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.util.XLogger;
import dca.projectx.world.gen.XGenOre;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

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
		forgeHooks();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	public void forgeHooks(){
		MinecraftForge.addGrassSeed(new ItemStack(XWorldItems.seedCorn), 2);
		GameRegistry.registerWorldGenerator(new XGenOre(), 0);
	}

}
