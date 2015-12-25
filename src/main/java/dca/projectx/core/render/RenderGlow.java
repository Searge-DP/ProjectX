package dca.projectx.core.render;

import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import dca.projectx.core.ProjectX;
import dca.projectx.core.block.XBlockBase;
import dca.projectx.core.proxy.ClientProxy;
import dca.projectx.lib.XColors;
import dca.projectx.lib.XLogger;
import dca.projectx.world.block.XBlockOre;
import dca.projectx.world.proxy.WClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderGlow implements ISimpleBlockRenderingHandler {
	
	public int renderID;
    public int renderBlockID;
	public float r = 1F;
	public float g = 1F;
	public float b = 1F;
	public int brightness = 0x00F000F0;
	
	public RenderGlow(int renderID, float r, float g, float b){
		this.renderID = renderID;
        this.renderBlockID = ProjectX.idCounter;
		this.r = r;
		this.g = g;
		this.b = b;
		ProjectX.idCounter++;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        int minFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER);
        int magFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        int meta = 2;

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /**
        if (block instanceof BlockHexoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else if (block instanceof BlockHexoriumLampInv)
            tessellator.setColorOpaque_F(r, g, b);
        else
        */
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /**
        if (block instanceof BlockHexoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else if (block instanceof BlockHexoriumLampInv)
            tessellator.setColorOpaque_F(r, g, b);
        else
        */
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        if(block instanceof XBlockBase)
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, 1));
        else
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /**
        if (block instanceof BlockHexoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else if (block instanceof BlockHexoriumLampInv)
            tessellator.setColorOpaque_F(r, g, b);
        else
        */
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        if(block instanceof XBlockBase)
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(8, 1));
        else
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /**
        if (block instanceof BlockHexoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else if (block instanceof BlockHexoriumLampInv)
            tessellator.setColorOpaque_F(r, g, b);
        else
        */
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        if(block instanceof XBlockBase)
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(9, 1));
        else
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /**
        if (block instanceof BlockHexoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else if (block instanceof BlockHexoriumLampInv)
            tessellator.setColorOpaque_F(r, g, b);
        else
        */
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        if(block instanceof XBlockBase)
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(10, 1));
        else
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /**
        if (block instanceof BlockHexoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else if (block instanceof BlockHexoriumLampInv)
            tessellator.setColorOpaque_F(r, g, b);
        else
        */
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        if(block instanceof XBlockBase)
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(11, 1));
        else
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        // Start drawing outer layer of the block.
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, meta));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, meta));
        tessellator.draw();

        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, minFilter);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, magFilter);

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        int meta = world.getBlockMetadata(x, y, z);
        Tessellator tessellator = Tessellator.instance;

        if(WClientProxy.renderPass[renderBlockID] == 0) {
            IIcon c = block.getIcon(6, 0);
            float u = c.getMinU();
            float v = c.getMinV();
            float U = c.getMaxU();
            float V = c.getMaxV();

            tessellator.addTranslation(x, y, z);
            tessellator.setBrightness(brightness);
            tessellator.setColorOpaque_F(r, g, b);
            
            if(block.shouldSideBeRendered(world, x, y - 1, z, 0)) {
                if (block instanceof XBlockBase) {
                    c = block.getIcon(world, x, y, z, 6);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 0, 1, u, V);
                tessellator.addVertexWithUV(0, 0, 0, u, v);
                tessellator.addVertexWithUV(1, 0, 0, U, v);
                tessellator.addVertexWithUV(1, 0, 1, U, V);
            }

            if(block.shouldSideBeRendered(world, x, y + 1, z, 1)) {
                if (block instanceof XBlockBase) {
                    c = block.getIcon(world, x, y, z, 7);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 1, 0, u, v);
                tessellator.addVertexWithUV(0, 1, 1, u, V);
                tessellator.addVertexWithUV(1, 1, 1, U, V);
                tessellator.addVertexWithUV(1, 1, 0, U, v);
            }

            if(block.shouldSideBeRendered(world, x, y, z - 1, 2)) {
                if (block instanceof XBlockBase) {
                    c = block.getIcon(world, x, y, z, 8);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(1, 0, 0, u, V);
                tessellator.addVertexWithUV(0, 0, 0, U, V);
                tessellator.addVertexWithUV(0, 1, 0, U, v);
                tessellator.addVertexWithUV(1, 1, 0, u, v);
            }

            if(block.shouldSideBeRendered(world, x, y, z + 1, 3)) {
                if (block instanceof XBlockBase) {
                    c = block.getIcon(world, x, y, z, 9);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 1, 1, u, v);
                tessellator.addVertexWithUV(0, 0, 1, u, V);
                tessellator.addVertexWithUV(1, 0, 1, U, V);
                tessellator.addVertexWithUV(1, 1, 1, U, v);
            }

            if(block.shouldSideBeRendered(world, x - 1, y, z, 4)) {
                if (block instanceof XBlockBase) {
                    c = block.getIcon(world, x, y, z, 10);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(0, 0, 0, u, V);
                tessellator.addVertexWithUV(0, 0, 1, U, V);
                tessellator.addVertexWithUV(0, 1, 1, U, v);
                tessellator.addVertexWithUV(0, 1, 0, u, v);
            }

            if(block.shouldSideBeRendered(world, x + 1, y, z, 5)) {
                if (block instanceof XBlockBase) {
                    c = block.getIcon(world, x, y, z, 11);
                    u = c.getMinU();
                    v = c.getMinV();
                    U = c.getMaxU();
                    V = c.getMaxV();
                }
                tessellator.addVertexWithUV(1, 0, 1, u, V);
                tessellator.addVertexWithUV(1, 0, 0, U, V);
                tessellator.addVertexWithUV(1, 1, 0, U, v);
                tessellator.addVertexWithUV(1, 1, 1, u, v);
            }
            tessellator.addTranslation(-x, -y, -z);
        }

        else {
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            tessellator.addVertex(0, 0, 0);
            renderer.renderStandardBlock(block, x, y, z);
        }
		
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return renderID;
	}

}
