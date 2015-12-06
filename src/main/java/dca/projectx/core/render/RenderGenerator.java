package dca.projectx.core.render;

import org.lwjgl.opengl.GL11;

import dca.projectx.core.ProjectX;
import dca.projectx.core.render.model.ModelGenerator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderGenerator extends TileEntitySpecialRenderer {
	
	public static ModelGenerator model;
	public static ResourceLocation textureOff;
	public static ResourceLocation textureOn;
	
	public RenderGenerator(){
		this.model = new ModelGenerator();
		this.textureOff = new ResourceLocation(ProjectX.INSTANCE, "textures/models/generatorOff.png");
		this.textureOn = new ResourceLocation(ProjectX.INSTANCE, "textures/models/generatorOn.png");
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(textureOff);
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
	}

}
