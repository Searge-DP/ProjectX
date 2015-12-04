package dca.projectx.core.render.item;

import org.lwjgl.opengl.GL11;
import dca.projectx.core.ProjectX;
import dca.projectx.core.render.RenderTruncatedIcosahedron;
import dca.projectx.util.ResourceAction;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class IREnergyCore implements IItemRenderer {
	
	public static RenderTruncatedIcosahedron irender;
	public float r;
	public float g;
	public float b;
	
	public IREnergyCore(float r, float g, float b){
		this.irender = new RenderTruncatedIcosahedron();
		this.r = r;
		this.g = g;
		this.b = b;
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
		irender.addIcosahedron(0D, 0D, 0D, this.r, this.g, this.b);
	}

}
