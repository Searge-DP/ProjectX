package snowpaw.projectx.machine.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XConfig;
import snowpaw.projectx.core.render.RenderTickHandler;
import snowpaw.projectx.machine.model.ModelEngineeringTable;
import snowpaw.projectx.machine.render.RenderTruncatedIcosahedron.EnumHedronTexture;
import snowpaw.projectx.machine.tile.TileEngineeringTable;

public class RenderEngineeringTable extends TileEntitySpecialRenderer {
	
	public static ModelEngineeringTable modelTable;
	public static ResourceLocation textureTable;
	public static RenderTruncatedIcosahedron renderIcosa;
	
	public RenderEngineeringTable(){
		modelTable = new ModelEngineeringTable();
		textureTable = new ResourceLocation(ProjectX.INSTANCE, "textures/models/engineeringTable.png");
		renderIcosa = new RenderTruncatedIcosahedron();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(textureTable);
		modelTable.renderModel();
		GL11.glPopMatrix();
		renderFX(x, y, z);
	}
	
	public void renderFX(double x, double y, double z){
		float r = RenderTickHandler.getRed();
		float g = RenderTickHandler.getGreen();
		float b = RenderTickHandler.getBlue();
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 0.4D, z + 0.5D);
		GL11.glRotatef(RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		GL11.glDisable(2884);
		renderIcosa.render(0.73D, r, g, b, EnumHedronTexture.SPACE);
		GL11.glEnable(2884);
		GL11.glPopMatrix();
	}

}
