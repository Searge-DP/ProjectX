package dca.projectx.machine.render;

import org.lwjgl.opengl.GL11;
import dca.projectx.core.ProjectX;
import dca.projectx.lib.render.RenderTickHandler;
import dca.projectx.machine.block.XBlockPulseRelayT1;
import dca.projectx.machine.block.XBlockPulseRelayT2;
import dca.projectx.machine.block.XBlockPulseRelayT3;
import dca.projectx.machine.render.RenderTruncatedIcosahedron.EnumHedronTexture;
import dca.projectx.machine.render.model.ModelXRelay;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderXRelay extends TileEntitySpecialRenderer {
	
	public static RenderTruncatedIcosahedron renderIcosa;
	public static ModelXRelay model;
	public static ResourceLocation texture;
	public float r;
	public float g;
	public float b;
	
	public RenderXRelay(float r, float g, float b){
		this.model = new ModelXRelay();
		this.texture = new ResourceLocation(ProjectX.INSTANCE, "textures/models/xRelay.png");
		this.renderIcosa = new RenderTruncatedIcosahedron();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glDisable(GL11.GL_BLEND);
		renderFX(x, y, z);
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
