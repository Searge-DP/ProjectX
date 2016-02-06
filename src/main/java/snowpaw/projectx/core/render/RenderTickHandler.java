package snowpaw.projectx.core.render;

/**
 * Generic Render Tick Handler Class
 * @author KitsuneAlex
 */

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class RenderTickHandler {
	
	public static int renderTime = 0;
	public static float renderFrame = 0F;
	public static int r = 255;
	public static int g = 0;
	public static int b = 0;
	
	@SubscribeEvent
	public void clientTickEvent(ClientTickEvent event){
		if(event.phase == Phase.END){
			renderTime += 1;
		}
	}
	
	@SubscribeEvent
	public void renderTickEvent(RenderTickEvent event){
		if(event.phase == Phase.END){
			renderFrame = event.renderTickTime;
		}
		if(r > 0 && b == 0){
			r -= 1;
			g += 1;
		}
		else if(g > 0){
			g -= 1;
			b += 1;
		}
		else if(b > 0){
			b -= 1;
			r += 1;
		}
	}
	
	public static float getRenderFrame(){
		return renderFrame;
	}
	
	public static float getRenderTime(){
		return renderTime + renderFrame;
	}
	
	public static float getRed(){
		return (float)r / 255;
	}
	
	public static float getGreen(){
		return (float)g / 255;
	}
	
	public static float getBlue(){
		return (float)b / 255;
	}
	
	public static double getRedD(){
		return (double)r / 255;
	}
	
	public static double getGreenD(){
		return (double)g / 255;
	}
	
	public static double getBlueD(){
		return (double)b / 255;
	}

}
