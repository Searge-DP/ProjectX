package snowpaw.projectx.core.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import snowpaw.projectx.core.render.AnimationFX;
import snowpaw.projectx.core.render.RenderSimpleGlow;

public class ClientProxy extends CommonProxy {
	
	public static AnimationFX animationFX = null;
	public static int glowRenderId;
	
	@Override
	public void preInit(){
		animationFX = new AnimationFX();
		glowRenderId = RenderingRegistry.getNextAvailableRenderId();
	}
	
	@Override
	public void init(){ 
		RenderingRegistry.registerBlockHandler(new RenderSimpleGlow());
	}
	
	@Override
	public void postInit(){
		
	}

}
