package dca.projectx.core.render.item;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class IRXNodeT2 implements IItemRenderer {
	
	public static TileEntitySpecialRenderer renderer;
	public static TileEntity tile;
	
	public IRXNodeT2(TileEntitySpecialRenderer renderer, TileEntity tile){
		this.renderer = renderer;
		this.tile = tile;
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
			this.renderer.renderTileEntityAt(this.tile, 0.0D, 0.0D, 0.0D, 0.0F);
	}

}
