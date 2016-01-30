package snowpaw.projectx.core.render;

import codechicken.lib.colour.ColourRGBA;
import codechicken.lib.render.CCModel;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.uv.IconTransformation;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Translation;
import codechicken.lib.vec.Vector3;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.proxy.ClientProxy;
import snowpaw.projectx.lib.render.RenderBlock;

public class RenderSimpleGlow extends RenderBlock implements ISimpleBlockRenderingHandler {
	
	public static CCModel baseModel = CCModel.quadModel(24).generateBlock(0, new Cuboid6(new Vector3(0.001, 0.001, 0.001), new Vector3(.999, .999, .999))).apply(new Translation(new Vector3(-.5, -.5, -.5))).computeNormals();

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		BlockXGlow blockGlow = (BlockXGlow)block;
		renderStandardInvBlock(renderer, block, metadata);
		CCRenderState.reset();
		CCRenderState.useNormals = true;
		CCRenderState.startDrawing();
		CCRenderState.setBrightness(0x00F000F0);
		baseModel.setColour(blockGlow.setBlockColor(metadata).rgba()).render(new IconTransformation(blockGlow.animationIcon));;
		CCRenderState.draw();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		Tessellator tess = Tessellator.instance;
		BlockXGlow blockGlow = (BlockXGlow)block;
		int meta = world.getBlockMetadata(x, y, z);
		tess.setBrightness(0x00F000F0);
		tess.setColorRGBA_I(blockGlow.setBlockColor(meta).rgb(), 255);
		renderAllSides(world, x, y, z, block, renderer, blockGlow.getAnimationIcon(), false);
		renderer.renderStandardBlock(block, x, y, z);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.glowRenderId;
	}

}
