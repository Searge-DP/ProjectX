package snowpaw.projectx.core.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import snowpaw.projectx.lib.render.RGBColor;
import snowpaw.projectx.world.proxy.WClientProxy;
import org.lwjgl.opengl.GL11;
/**
 * Created by Le9enD on 09.02.2016.
 */
public class RenderXOre implements ISimpleBlockRenderingHandler{
    public int renderID;
    public int renderBlockID;
    public int brightness;
    public float r;
    public float g;
    public float b;
    public static float darkLamp = 0.15f;

    public RenderXOre(int renderID, int brightness, float r, float g, float b)
    {
        this.renderBlockID = WClientProxy.oreCounter;
        this.renderID = renderID;

        if(Loader.isModLoaded("coloredlightscore"))
            this.brightness = RGBColor.brightnessCL;
        else
            this.brightness = brightness;

        this.r=r;
        this.g=g;
        this.b=b;

        WClientProxy.oreCounter++;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer){

        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        int minFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER);
        int magFilter = GL11.glGetTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /*if (block instanceof XychoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else*/
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /*if (block instanceof XychoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else*/
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);

        /*if(block instanceof XychoriumBlock)
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(7, 1));
        else*/
            renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /*if (block instanceof XychoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else*/
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        /*if(block instanceof XychoriumBlock)
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(8, 1));
        else*/
            renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /*if (block instanceof XychoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else*/
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        /*if(block instanceof XychoriumBlock)
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(9, 1));
        else*/
            renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /*if (block instanceof XychoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else*/
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        /*if(block instanceof XychoriumBlock)
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(10, 1));
        else*/
            renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setBrightness(brightness);
        /*if (block instanceof XychoriumLamp)
            tessellator.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
        else*/
            tessellator.setColorOpaque_F(r, g, b);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        /*if(block instanceof XychoriumBlock)
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(11, 1));
        else*/
            renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(6, 1));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, 2));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, 2));
        tessellator.draw();

        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, minFilter);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, magFilter);

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);

    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer){

        int meta = world.getBlockMetadata(x, y, z);
        Tessellator tess = Tessellator.instance;

        if(WClientProxy.renderPass[renderBlockID] == 0) {

            IIcon c = block.getIcon(6, 0);
            float u = c.getMinU();
            float v = c.getMaxV();
            float U = c.getMaxU();
            float V = c.getMaxV();

            tess.addTranslation(x, y, z);
            tess.setBrightness(brightness);

            /*if (block instanceof XychoriumLamp) {
                if (meta == 0)
                    tess.setColorOpaque_F(r * darkLamp, g * darkLamp, b * darkLamp);
                else if (meta == 1)
                    tess.setColorOpaque_F(r, g, b);
            }
            else*/
                tess.setColorOpaque_F(r, g, b);


            //DOWN
            if(block.shouldSideBeRendered(world, x, y - 1, z, 0)){
                c = block.getIcon(6, meta);
                u = c.getMinU();
                v = c.getMinV();
                U = c.getMaxU();
                V = c.getMaxV();

                tess.addVertexWithUV(0, 0, 1, u, V);
                tess.addVertexWithUV(0, 0, 0, u, v);
                tess.addVertexWithUV(1, 0, 0, U, v);
                tess.addVertexWithUV(1, 0, 1, U, V);
            }

            //UP
            if(block.shouldSideBeRendered(world, x, y + 1, z, 1)){
                c = block.getIcon(7, meta);
                u = c.getMinU();
                v = c.getMinV();
                U = c.getMaxU();
                V = c.getMaxV();

                tess.addVertexWithUV(0, 1, 0, u, v);
                tess.addVertexWithUV(0, 1, 1, u, V);
                tess.addVertexWithUV(1, 1, 1, U, V);
                tess.addVertexWithUV(1, 1, 0, U, v);
            }

            //NORTH
            if(block.shouldSideBeRendered(world, x, y, z - 1, 2)){
                c = block.getIcon(8, meta);
                u = c.getMinU();
                v = c.getMinV();
                U = c.getMaxU();
                V = c.getMaxV();

                tess.addVertexWithUV(1, 0, 0, u, V);
                tess.addVertexWithUV(0, 0, 0, U, V);
                tess.addVertexWithUV(0, 1, 0, U, v);
                tess.addVertexWithUV(1, 1, 0, u, v);
            }

            //SOUTH
            if(block.shouldSideBeRendered(world, x, y, z + 1, 3)){
                c = block.getIcon(9, meta);
                u = c.getMinU();
                v = c.getMinV();
                U = c.getMaxU();
                V = c.getMaxV();

                tess.addVertexWithUV(0, 1, 1, u, v);
                tess.addVertexWithUV(0, 0, 1, u, V);
                tess.addVertexWithUV(1, 0, 1, U, V);
                tess.addVertexWithUV(1, 1, 1, U, v);
            }

            //WEST
            if(block.shouldSideBeRendered(world, x - 1, y, z, 4)){
                c = block.getIcon(10, meta);
                u = c.getMinU();
                v = c.getMinV();
                U = c.getMaxU();
                V = c.getMaxV();

                tess.addVertexWithUV(0, 0, 0, u, V);
                tess.addVertexWithUV(0, 0, 1, U, V);
                tess.addVertexWithUV(0, 1, 1, U, v);
                tess.addVertexWithUV(0, 1, 0, u, v);
            }

            //EAST
            if(block.shouldSideBeRendered(world, x + 1, y, z, 5)){
                c = block.getIcon(11, meta);
                u = c.getMinU();
                v = c.getMinV();
                U = c.getMaxU();
                V = c.getMaxV();

                tess.addVertexWithUV(1, 0, 1, u, V);
                tess.addVertexWithUV(1, 0, 0, U, V);
                tess.addVertexWithUV(1, 1, 0, U, v);
                tess.addVertexWithUV(1, 1, 1, u, v);
            }

            tess.addTranslation(-x, -y, -z);

        }

        else {
            tess.addVertex(0, 0, 0);
            tess.addVertex(0, 0, 0);
            tess.addVertex(0, 0, 0);
            tess.addVertex(0, 0, 0);
            renderer.renderStandardBlock(block, x, y, z);
        }

        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId){
        return true;
    }

    @Override
    public int getRenderId(){
        return renderID;
    }



}
