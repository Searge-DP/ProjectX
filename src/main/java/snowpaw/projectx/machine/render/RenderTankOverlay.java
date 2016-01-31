package snowpaw.projectx.machine.render;

import java.util.ArrayList;
import org.lwjgl.opengl.GL11;
import codechicken.lib.render.RenderUtils;
import codechicken.lib.vec.BlockCoord;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import snowpaw.projectx.core.XLogger;
import snowpaw.projectx.lib.block.BlockXCropBase;
import snowpaw.projectx.machine.tile.TileXTankFrame;

public class RenderTankOverlay {
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onDrawBlockHighlight(DrawBlockHighlightEvent event)
	{
		MovingObjectPosition target = event.target;
		World world = Minecraft.getMinecraft().theWorld;
		if(target.typeOfHit == MovingObjectType.BLOCK)
		{
			TileEntity curTile = world.getTileEntity(target.blockX, target.blockY, target.blockZ);
			//XLogger.debug("Hallo ich bins Thorsten von AutoKlaus");
			if(curTile instanceof TileXTankFrame)
			{
				EntityPlayer player = event.player;
				GL11.glPushMatrix();
				double interpPosX = player.lastTickPosX + (player.posX - player.lastTickPosX) * event.partialTicks;
				double interpPosY = player.lastTickPosY + (player.posY - player.lastTickPosY) * event.partialTicks;
				double interpPosZ = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * event.partialTicks;
				GL11.glTranslated(-interpPosX, -interpPosY, -interpPosZ);
				renderOverlay((TileXTankFrame)curTile, new BlockCoord(target.blockX, target.blockY, target.blockZ));
				GL11.glPopMatrix();
			}
		}
	}
	
	public ArrayList<BlockCoord> getTankBlocks(TileXTankFrame frame)
	{
		if(frame.getValve().isValid)
		{
			return new ArrayList<BlockCoord>();
			//return (ArrayList<BlockCoord>) frame.getValve().tankFrameCoords;
		}
		return new ArrayList<BlockCoord>();
		
	}
	
	public void renderOverlay(TileXTankFrame entity, BlockCoord target)
	{
		ArrayList<BlockCoord> fullBlockList = getTankBlocks(entity);
		ArrayList<BlockCoord> blocksToRender = new ArrayList<BlockCoord>();
		blocksToRender = fullBlockList;
		
		/**
		Tessellator tess = Tessellator.instance;
		IIcon texture = BlockXCropBase.overlayIcon;
		BlockCoord copy = new BlockCoord();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDepthMask(false);
		tess.startDrawingQuads();
		tess.setColorRGBA_F(1.0f, 1.0f, 1.0f, 0.25f);
		for(int blockSize = 0; blockSize < blocksToRender.size(); blockSize++ )
		{
			for(int side = 0; side < 6; side++)
			{
				RenderUtils.renderBlockOverlaySide(blocksToRender.get(blockSize).x, blocksToRender.get(blockSize).y, blocksToRender.get(blockSize).z, side, texture.getMinU(), texture.getMaxU(), texture.getMinV(), texture.getMaxV());
			}
			//blocksToRender.remove(blockSize);
			XLogger.debug(fullBlockList);
		}
		
		
		
		tess.draw();
		*/
		
	}

}
