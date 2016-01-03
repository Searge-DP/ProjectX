package dca.projectx.machine.render;

import java.awt.Color;

import org.lwjgl.opengl.GL11;
import dca.projectx.core.ProjectX;
import dca.projectx.lib.render.RenderTickHandler;
import dca.projectx.machine.block.tile.TilePulseNodeT1;
import dca.projectx.machine.render.RenderTruncatedIcosahedron.EnumHedronTexture;
import dca.projectx.machine.render.model.ModelXNode;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderXNode extends TileEntitySpecialRenderer {
	
	public static ModelXNode modelNode;
	public static ResourceLocation textureNode;
	public static RenderTruncatedIcosahedron renderIcosa;
	public float r;
	public float g;
	public float b;
	
	public RenderXNode(float r, float g, float b){
		this.modelNode = new ModelXNode();
		this.textureNode = new ResourceLocation(ProjectX.INSTANCE, "textures/models/xNode.png");
		this.renderIcosa = new RenderTruncatedIcosahedron();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f){
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(textureNode);
		modelNode.renderModel(0.0625F);
		GL11.glPopMatrix();
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
