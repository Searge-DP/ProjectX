package dca.projectx.machine.render.item;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class IREnergyPipeT3 implements IItemRenderer {
	
	public static TileEntitySpecialRenderer renderer;
	public static TileEntity entity;
	
	public IREnergyPipeT3(TileEntitySpecialRenderer renderer, TileEntity entity){
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
		this.renderer.renderTileEntityAt(entity, 0D, 0D, 0D, 0F);
	}

}
