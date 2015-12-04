package dca.projectx.core.render;

import org.lwjgl.opengl.GL11;

import dca.projectx.core.ProjectX;
import dca.projectx.util.ResourceAction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Generic Render Class for a Truncated Icosahedron using
 * a .obj model and ResourceAction for binding the texture
 * @author KitsuneAlex
 *
 */

public class RenderTruncatedIcosahedron {
	
	public static IModelCustom model;
	public static ResourceAction texture;
	
	public RenderTruncatedIcosahedron(){
		model = AdvancedModelLoader.loadModel(new ResourceLocation(ProjectX.INSTANCE, "models/truncatedIcosahedron.obj"));
		texture = new ResourceAction(new ResourceLocation(ProjectX.INSTANCE, "textures/models/icosa.png"));
	}
	
	public static void addIcosahedron(double x, double y, double z, float r, float g, float b){
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		texture.bind();
		GL11.glColor3f(r, g, b);
		model.renderAll();
		GL11.glPopMatrix();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
	}

}
