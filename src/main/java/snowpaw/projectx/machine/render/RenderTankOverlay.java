package snowpaw.projectx.machine.render;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockFire;
import net.minecraft.util.ChatComponentText;
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
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XLogger;
import snowpaw.projectx.lib.block.BlockXCropBase;
import snowpaw.projectx.machine.tile.TileXTankFrame;
import snowpaw.projectx.world.block.BlockXOreAluminum;

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
			BlockCoord lookedBlock = new BlockCoord(target.blockX, target.blockY, target.blockZ);
			if(curTile instanceof TileXTankFrame)
			{
				EntityPlayer player = event.player;
				GL11.glPushMatrix();
				double interpPosX = player.lastTickPosX + (player.posX - player.lastTickPosX) * event.partialTicks;
				double interpPosY = player.lastTickPosY + (player.posY - player.lastTickPosY) * event.partialTicks;
				double interpPosZ = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * event.partialTicks;
				GL11.glTranslated(-interpPosX, -interpPosY, -interpPosZ);
				renderOverlay((TileXTankFrame)curTile, lookedBlock);
				GL11.glPopMatrix();
			}
		}
	}
	

	public void renderOverlay(TileXTankFrame entity, BlockCoord coord)
	{
		List<BlockCoord> blocksToRender = entity.getValve().tankFrameCoords;
		

		Tessellator tess = Tessellator.instance;
		IIcon icon = BlockXCropBase.icons[0];
		BlockCoord copy = new BlockCoord();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDepthMask(false);
		tess.startDrawingQuads();
		tess.setColorRGBA_F(1.0f, 1.0f, 1.0f, 0.25f);
		ProjectX.serverMgr.sendChatMsg(new ChatComponentText("Looked@tank"));

		for(int side = 0; side < 6; side++)
		{
			RenderUtils.renderBlockOverlaySide(coord.x, coord.y, coord.z, side, icon.getMinU(), icon.getMaxU(), icon.getMinV(), icon.getMaxV());
		}

		tess.draw();
	}
}
