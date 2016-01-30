package snowpaw.projectx.machine.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.render.RenderTickHandler;
import snowpaw.projectx.machine.render.RenderTruncatedIcosahedron.EnumHedronTexture;

public class IREnergyCore implements IItemRenderer {
	
	public static RenderTruncatedIcosahedron renderIcosa;
	public float r;
	public float g;
	public float b;
	
	public IREnergyCore(float r, float g, float b){
		this.renderIcosa = new RenderTruncatedIcosahedron();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		GL11.glTranslated(0D, 0D, 0D);
		GL11.glRotatef(RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		GL11.glDisable(2884);
		renderIcosa.render(0.8D, r, g, b, EnumHedronTexture.SPACE);
		GL11.glEnable(2884);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glTranslated(0D, 0D, 0D);
		GL11.glRotatef(-RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		GL11.glDisable(2884);
		renderIcosa.render(0.6D, r, g, b, EnumHedronTexture.FILL);
		GL11.glEnable(2884);
		GL11.glPopMatrix();
	}

}
