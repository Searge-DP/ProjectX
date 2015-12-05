package dca.projectx.util;

/**
 * This class provides a simple method to bind model textures
 * in IItemRenderers or TESR's
 * @author KitsuneAlex
 */

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class ResourceAction {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	public static ResourceLocation loc;
	
	public ResourceAction(ResourceLocation loc){
		this.loc = loc;
	}
	
	public static void bind(){
		mc.renderEngine.bindTexture(loc);
	}
	
	public static void bindToModel(){
		mc.getTextureManager().bindTexture(loc);
	}

}
