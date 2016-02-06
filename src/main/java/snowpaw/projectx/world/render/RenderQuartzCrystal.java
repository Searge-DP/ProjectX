package snowpaw.projectx.world.render;

import java.awt.Color;

import codechicken.lib.render.CCModel;
import codechicken.lib.render.CCModelLibrary;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.uv.IconTransformation;
import codechicken.lib.vec.Scale;
import codechicken.lib.vec.Transformation;
import codechicken.lib.vec.TransformationList;
import codechicken.lib.vec.Vector3;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import snowpaw.projectx.core.proxy.ClientProxy;
import snowpaw.projectx.world.proxy.WClientProxy;

public class RenderQuartzCrystal implements ISimpleBlockRenderingHandler {
	
	public static CCModel model = CCModelLibrary.icosahedron7.copy().apply(new TransformationList(new Scale(new Vector3(.35, 1, .35))));

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		Transformation transformation = null;
        CCRenderState.reset();
        CCRenderState.useNormals = true;
        CCRenderState.startDrawing();
        CCRenderState.setBrightness(220);
        transformation = new TransformationList(new Scale(.45));
        model.setColour(new Color(200, 200, 0).getRGB()).computeNormals().render(transformation, new IconTransformation(ClientProxy.animationFX.texture));
        CCRenderState.draw();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		Transformation transformation = null;
		Tessellator tess = Tessellator.instance;
		tess.setBrightness(220);
		tess.setColorRGBA_I(new Color(0, 200, 200).getRGB(), 255);
		transformation = new TransformationList(new Scale(2));
		model.render(transformation, new IconTransformation(ClientProxy.animationFX.texture));
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return WClientProxy.crystalRenderId;
	}

}
