package dca.projectx.world.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import dca.projectx.core.ProjectX;
import dca.projectx.core.render.RenderGlow;
import dca.projectx.lib.XColors;

public class WClientProxy extends WCommonProxy {
	
    public static int renderID[] = new int[ProjectX.countBlocks];
    public static int renderPass[] = new int[ProjectX.countBlocks];
	
	@Override
	public void preInit(){
		
	}
	
	@Override
	public void init(){
		ProjectX.idCounter = 0;
		
		//Ores
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Storage Blocks
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Bricks
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Glass Viewer - Dummy
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Small Bricks
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Structures
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBrownR, XColors.colorBrownG, XColors.colorBrownB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPurpleR, XColors.colorPurpleG, XColors.colorPurpleB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorCyanR, XColors.colorCyanG, XColors.colorCyanB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightGrayR, XColors.colorLightGrayG, XColors.colorLightGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGrayR, XColors.colorGrayG, XColors.colorGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPinkR, XColors.colorPinkG, XColors.colorPinkB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLimeR, XColors.colorLimeG, XColors.colorLimeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorYellowR, XColors.colorYellowG, XColors.colorYellowB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightBlueR, XColors.colorLightBlueG, XColors.colorLightBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorMagentaR, XColors.colorMagentaG, XColors.colorMagentaB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorOrangeR, XColors.colorOrangeG, XColors.colorOrangeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Platforms
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBrownR, XColors.colorBrownG, XColors.colorBrownB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPurpleR, XColors.colorPurpleG, XColors.colorPurpleB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorCyanR, XColors.colorCyanG, XColors.colorCyanB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightGrayR, XColors.colorLightGrayG, XColors.colorLightGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGrayR, XColors.colorGrayG, XColors.colorGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPinkR, XColors.colorPinkG, XColors.colorPinkB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLimeR, XColors.colorLimeG, XColors.colorLimeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorYellowR, XColors.colorYellowG, XColors.colorYellowB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightBlueR, XColors.colorLightBlueG, XColors.colorLightBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorMagentaR, XColors.colorMagentaG, XColors.colorMagentaB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorOrangeR, XColors.colorOrangeG, XColors.colorOrangeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Shields
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBrownR, XColors.colorBrownG, XColors.colorBrownB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPurpleR, XColors.colorPurpleG, XColors.colorPurpleB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorCyanR, XColors.colorCyanG, XColors.colorCyanB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightGrayR, XColors.colorLightGrayG, XColors.colorLightGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGrayR, XColors.colorGrayG, XColors.colorGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPinkR, XColors.colorPinkG, XColors.colorPinkB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLimeR, XColors.colorLimeG, XColors.colorLimeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorYellowR, XColors.colorYellowG, XColors.colorYellowB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightBlueR, XColors.colorLightBlueG, XColors.colorLightBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorMagentaR, XColors.colorMagentaG, XColors.colorMagentaB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorOrangeR, XColors.colorOrangeG, XColors.colorOrangeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
	}
	
	@Override
	public void postInit(){
		
	}

}
