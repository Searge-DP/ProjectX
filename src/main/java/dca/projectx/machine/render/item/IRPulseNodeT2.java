package dca.projectx.machine.render.item;

import org.lwjgl.opengl.GL11;
import dca.projectx.core.ProjectX;
import dca.projectx.lib.render.RenderTickHandler;
import dca.projectx.machine.render.RenderTruncatedIcosahedron;
import dca.projectx.machine.render.RenderTruncatedIcosahedron.EnumHedronTexture;
import dca.projectx.machine.render.model.ModelPulseNode;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class IRPulseNodeT2 implements IItemRenderer {
	
	public static TileEntity tile;
	public static RenderTruncatedIcosahedron renderIcosa;
	public static ModelPulseNode modelNode;
	public static ResourceLocation textureNode;
	public float r = 0F;
	public float g = 0F;
	public float b = 1F;
	
	public IRPulseNodeT2(TileEntity tile){
		this.tile = tile;
		this.renderIcosa = new RenderTruncatedIcosahedron();
		this.modelNode = new ModelPulseNode();
		this.textureNode = new ResourceLocation(ProjectX.INSTANCE, "textures/models/pulseNode.png");
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
		GL11.glTranslated(0.5D, 1.5D, 0.5D);	
		GL11.glRotated(180, 0D, 0D, 1D);
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureNode);
		modelNode.renderModel(0.0625F);
		GL11.glPopMatrix();
		renderFX(0D, 0D, 0D);
	}
	
	public void renderFX(double x, double y, double z){
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 0.5D, z + 0.5D);
		GL11.glRotatef(RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		GL11.glDisable(2884);
		renderIcosa.render(0.9D, r, g, b, EnumHedronTexture.SPACE);
		GL11.glEnable(2884);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 0.5D, z + 0.5D);
		GL11.glRotatef(-RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		GL11.glDisable(2884);
		renderIcosa.render(0.5D, r - 0.3F, g - 0.3F, b - 0.3F, EnumHedronTexture.FILL);
		GL11.glEnable(2884);
		GL11.glPopMatrix();
	}

}
