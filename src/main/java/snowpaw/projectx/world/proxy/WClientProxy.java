package snowpaw.projectx.world.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.render.RenderXOre;
import snowpaw.projectx.lib.render.RGBColor;
import snowpaw.projectx.world.render.RenderQuartzCrystal;

public class WClientProxy extends WCommonProxy {
	
	public static int crystalRenderId;
	public static int oreCounter;
	public static int blockCounter = 5;
	public static int renderID[] = new int[blockCounter];
	public static int renderPass[] = new int [blockCounter];

	@Override
	public void preInit(){
		
	}
	
	@Override
	public void init(){
		oreCounter = 0;
		renderID[oreCounter-0] = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderXOre(renderID[oreCounter-0], RGBColor.brightnessBright,
				RGBColor.colorBlueR, RGBColor.colorBlueG, RGBColor.colorBlueB));
		renderID[oreCounter-0] = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderXOre(renderID[oreCounter-0], RGBColor.brightnessBright,
				RGBColor.colorGreenR, RGBColor.colorGreenG, RGBColor.colorGreenB));
		renderID[oreCounter-0] = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderXOre(renderID[oreCounter-0], RGBColor.brightnessBright,
				RGBColor.colorRedR, RGBColor.colorRedG, RGBColor.colorRedB));
		renderID[oreCounter-0] = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderXOre(renderID[oreCounter-0], RGBColor.brightnessBright,
				RGBColor.colorDarkGrayR, RGBColor.colorDarkGrayG, RGBColor.colorDarkGrayB));
		renderID[oreCounter-0] = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderXOre(renderID[oreCounter-0], RGBColor.brightnessBright,
				RGBColor.colorWhiteR, RGBColor.colorWhiteG, RGBColor.colorWhiteB));


		crystalRenderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderQuartzCrystal());

	}
	
	@Override
	public void postInit(){
		
	}

}
