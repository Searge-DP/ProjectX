package snowpaw.projectx.world.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.world.render.RenderQuartzCrystal;

public class WClientProxy extends WCommonProxy {
	
	public static int crystalRenderId;
	
	@Override
	public void preInit(){
		
	}
	
	@Override
	public void init(){
		crystalRenderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderQuartzCrystal());
	}
	
	@Override
	public void postInit(){
		
	}

}
