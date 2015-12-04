package dca.projectx.core.render;

import org.lwjgl.opengl.GL11;
import dca.projectx.core.ProjectX;
import dca.projectx.core.render.model.ModelEngineeringTable;
import dca.projectx.machine.block.tile.TileEngineeringTable;
import dca.projectx.util.RenderTickHandler;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderEngineeringTable extends TileEntitySpecialRenderer {
	
	public static ModelEngineeringTable modelTable;
	public static ResourceLocation textureTable;
	public static RenderTruncatedIcosahedron irender;
	
	public RenderEngineeringTable(){
		modelTable = new ModelEngineeringTable();
		textureTable = new ResourceLocation(ProjectX.INSTANCE, "textures/models/engineeringTable.png");
		irender = new RenderTruncatedIcosahedron();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(textureTable);
		modelTable.renderModel(0.0625F);
		GL11.glPopMatrix();
		irender.addIcosahedron(x, y, z, 0F, 1F, 0F);
	}

}
