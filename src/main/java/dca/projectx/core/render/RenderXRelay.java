package dca.projectx.core.render;

import org.lwjgl.opengl.GL11;
import dca.projectx.core.ProjectX;
import dca.projectx.core.render.model.ModelXRelay;
import dca.projectx.machine.block.XBlockXRelayT1;
import dca.projectx.machine.block.XBlockXRelayT2;
import dca.projectx.machine.block.XBlockXRelayT3;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderXRelay extends TileEntitySpecialRenderer {
	
	public static RenderTruncatedIcosahedron irender;
	public static ModelXRelay model;
	public static ResourceLocation texture;
	public float r;
	public float g;
	public float b;
	
	public RenderXRelay(float r, float g, float b){
		this.irender = new RenderTruncatedIcosahedron();
		this.model = new ModelXRelay();
		this.texture = new ResourceLocation(ProjectX.INSTANCE, "textures/models/xRelay.png");
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
		irender.addIcosahedron(x, y, z, r, g, b);
	}

}
