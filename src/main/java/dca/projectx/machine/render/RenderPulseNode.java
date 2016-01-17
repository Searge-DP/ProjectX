package dca.projectx.machine.render;

import java.awt.Color;
import org.lwjgl.opengl.GL11;
import dca.projectx.core.ProjectX;
import dca.projectx.lib.render.PlacementLogic;
import dca.projectx.lib.render.RenderTickHandler;
import dca.projectx.machine.block.tile.TilePulseNode;
import dca.projectx.machine.block.tile.TilePulseNodeT1;
import dca.projectx.machine.render.RenderTruncatedIcosahedron.EnumHedronTexture;
import dca.projectx.machine.render.model.ModelPulseNode;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderPulseNode extends TileEntitySpecialRenderer {
	
	public static ModelPulseNode modelNode;
	public static ResourceLocation textureNode;
	public static RenderTruncatedIcosahedron renderIcosa;
	public float r;
	public float g;
	public float b;
	
	public RenderPulseNode(float r, float g, float b){
		this.modelNode = new ModelPulseNode();
		this.textureNode = new ResourceLocation(ProjectX.INSTANCE, "textures/models/pulseNode.png");
		this.renderIcosa = new RenderTruncatedIcosahedron();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f){
		TilePulseNode node = (TilePulseNode)tile;
		GL11.glPushMatrix();
		PlacementLogic.insertPlacementLogic(x, y, z, node.getRotationData());
		this.bindTexture(textureNode);
		modelNode.renderModel(0.0625F);
		GL11.glPopMatrix();
		renderFX(x, y, z, tile);
	}
	
	public void renderFX(double x, double y, double z, TileEntity tile){
		TilePulseNode node = (TilePulseNode)tile;
		GL11.glPushMatrix();
		PlacementLogic.getIcosaRotation(x, y, z, node.getRotationData());
		GL11.glDisable(2884);
		renderIcosa.render(0.9D, r, g, b, EnumHedronTexture.SPACE);
		GL11.glEnable(2884);
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		PlacementLogic.getNegativeIcosaRotation(x, y, z, node.getRotationData());
		GL11.glDisable(2884);
		renderIcosa.render(0.5D, r - 0.3F, g - 0.3F, b - 0.3F, EnumHedronTexture.FILL);
		GL11.glEnable(2884);
		GL11.glPopMatrix();
	}
	
	//WIP...
	public void renderBeams(){
		Tessellator tess = Tessellator.instance;
	}

}
