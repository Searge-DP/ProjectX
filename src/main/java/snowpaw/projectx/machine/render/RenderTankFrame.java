package snowpaw.projectx.machine.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.MinecraftForgeClient;
import snowpaw.projectx.machine.proxy.MClientProxy;
import snowpaw.projectx.machine.tile.TileXTankFrame;

public class RenderTankFrame implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return renderWorldBlock(world, x, y, z, block, renderer, getPassForFrameRender(renderer));
	}
	
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks rb, int pass){
		Tessellator tess = Tessellator.instance;
		tess.addVertexWithUV(x, y, z, 0, 0);
		tess.addVertexWithUV(x, y, z, 0, 0);
		tess.addVertexWithUV(x, y, z, 0, 0);
		tess.addVertexWithUV(x, y, z, 0, 0);
		
        TileEntity tile = world.getTileEntity(x, y, z);
        if (!(tile instanceof TileXTankFrame)) {
            return false;
        }
        
        boolean invalidRender = true;
        Block renderBlock = Blocks.stone;

        TileXTankFrame te = (TileXTankFrame) tile;
        if(te.getBlock() != null) {
            Block exBlock = te.getBlock().getBlock();
            if (exBlock != null) {
                renderBlock = exBlock;
                invalidRender = false;
            }
        }
        
        IBlockAccess origBa = rb.blockAccess;
        boolean isFrameBlockOpaque = renderBlock.isOpaqueCube();

        if (((isFrameBlockOpaque || renderBlock.canRenderInPass(0)) && pass == 0) || ((!isFrameBlockOpaque || renderBlock.canRenderInPass(1)) && pass == 1)) {
            if(invalidRender) {
                rb.renderStandardBlock(renderBlock, x, y, z);
            }
            else {
                rb.blockAccess = new RenderFrameBlock(origBa);
                try {
                    rb.renderBlockByRenderType(renderBlock, x, y, z);
                } catch (Exception e) {
                    rb.renderStandardBlock(Blocks.stone, x, y, z);
                }
            }
            rb.blockAccess = origBa;
        }
        
        return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return MClientProxy.tankFrameRenderId;
	}
	
    public static int getPassForFrameRender(RenderBlocks rb) {
        return MinecraftForgeClient.getRenderPass();
    }

}
