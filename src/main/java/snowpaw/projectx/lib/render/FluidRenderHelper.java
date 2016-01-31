package snowpaw.projectx.lib.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidRenderHelper {
	
    public static final ResourceLocation BLOCK_TEXTURE = TextureMap.locationBlocksTexture;

    public static IIcon getFluidTexture(Fluid fluid, boolean flowing) {
        if (fluid == null) {
            return null;
        }
        IIcon icon = flowing ? fluid.getFlowingIcon() : fluid.getStillIcon();
        if (icon == null) {
            icon = ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
        }
        return icon;
    }

}
