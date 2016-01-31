package snowpaw.projectx.machine.proxy;

import cpw.mods.fml.common.Loader;
import net.minecraftforge.common.MinecraftForge;

public class MCommonProxy {
	
	public static boolean BUILDCRAFT_LOADED = false;
	
	public void preInit(){
		if(Loader.isModLoaded("BuildCraftAPI|Transport")){
			BUILDCRAFT_LOADED = true;
		}
		else 
			BUILDCRAFT_LOADED = false;
	}
	
	public void init(){
	
	}
	
	public void postInit(){
		
	}

}
