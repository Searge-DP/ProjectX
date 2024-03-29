package snowpaw.projectx.machine.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.machine.model.ModelEngineeringTable;
import snowpaw.projectx.machine.tile.TileEngineeringTable;

public class IREngineeringTable implements IItemRenderer {
	
	public static TileEntitySpecialRenderer renderer;
	public static TileEntity entity;
	
	public IREngineeringTable(TileEntitySpecialRenderer renderer, TileEntity entity){
		this.renderer = renderer;
		this.entity = entity;
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
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			this.renderer.renderTileEntityAt(this.entity, 0D, 0D, 0D, 0F);
	}

}
