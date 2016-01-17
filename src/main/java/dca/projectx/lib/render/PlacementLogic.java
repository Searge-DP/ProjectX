package dca.projectx.lib.render;

import org.lwjgl.opengl.GL11;
import dca.projectx.lib.XLogger;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Class that provides a placement logic for custom rendered blocks.
 * WIP !!!
 * @author KitsuneAlex
 *
 */

public class PlacementLogic {
	
	public static void insertPlacementLogic(double x, double y, double z, int meta){
		if(meta == 0){
			GL11.glTranslated(x + 0.5D, y - 0.5D, z + 0.5D);
			GL11.glRotated(360, 0D, 0D, 1D);
		}
		else if(meta == 1){
			GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
			GL11.glRotated(180, 0D, 0D, 1D);
		}
		else if(meta == 2){
			GL11.glTranslated(x + 0.5D, y + 0.5D, z - 0.5D);
			GL11.glRotated(-270, 1D, 0D, 0D);
		}
		else if(meta == 3){
			GL11.glTranslated(x + 0.5D, y + 0.5D, z + 1.5D);
			GL11.glRotated(270, 1D, 0D, 0D);
		}
		else if(meta == 4){
			GL11.glTranslated(x + -0.5D, y + 0.5D, z + 0.5D);
			GL11.glRotated(270, 0D, 0D, 1D);
		}
		else if(meta == 5){
			GL11.glTranslated(x + 1.5D, y + 0.5D, z + 0.5D);
			GL11.glRotated(-270, 0D, 0D, 1D);
		}
	}
	
	public static int getPlacementData(World world, int x, int y, int z, int side, boolean changeState){
		int orientation = -1;
		
		if (side == 0 && world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN))
            orientation = side;
        else if (side == 1 && world.isSideSolid(x, y - 1, z, ForgeDirection.UP))
            orientation = side;
        else if (side == 2 && world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH))
            orientation = side;
        else if (side == 3 && world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH))
            orientation = side;
        else if (side == 4 && world.isSideSolid(x + 1, y, z, ForgeDirection.WEST))
            orientation = side;
        else if (side == 5 && world.isSideSolid(x - 1, y, z, ForgeDirection.EAST))
            orientation = side;
        else {
            if (world.isSideSolid(x, y - 1, z, ForgeDirection.UP))
                orientation = 1;
            else if (world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH))
                orientation = 2;
            else if (world.isSideSolid(x - 1, y, z, ForgeDirection.EAST))
                orientation = 5;
            else if (world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH))
                orientation = 3;
            else if (world.isSideSolid(x + 1, y, z, ForgeDirection.WEST))
                orientation = 4;
            else if (world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN))
                orientation = 0;
        }
		
		if(changeState = true){
			if(world.isBlockIndirectlyGettingPowered(x, y, z)){
				orientation = orientation + 6;
			}
		}
		
		return orientation;
	}
	
	public static boolean isPlacementPossible(World world, int x, int y, int z){
        return (world.isSideSolid(x, y - 1, z, ForgeDirection.UP)) ||
                (world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN)) ||
                (world.isSideSolid(x, y, z + 1, ForgeDirection.NORTH)) ||
                (world.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH)) ||
                (world.isSideSolid(x + 1, y, z, ForgeDirection.WEST)) ||
                (world.isSideSolid(x - 1, y, z, ForgeDirection.EAST));
	}
	
	public static void getIcosaRotation(double x, double y, double z, int meta){
		GL11.glTranslated(x + 0.5D, y + 0.5D, z + 0.5D);
		
		if(meta == 0){
			GL11.glRotatef(RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		}
		else if(meta == 1){
			GL11.glRotatef(RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		}
		else if(meta == 2){
			GL11.glRotatef(RenderTickHandler.getRenderTime(), 0F, 0F, 1F);
		}
		else if(meta == 3){
			GL11.glRotatef(RenderTickHandler.getRenderTime(), 0F, 0F, 1F);
		}
		else if(meta == 4){
			GL11.glRotatef(RenderTickHandler.getRenderTime(), 1F, 0F, 0F);
		}
		else if(meta == 5){
			GL11.glRotatef(RenderTickHandler.getRenderTime(), 1F, 0F, 0F);
		}
	}
	
	public static void getNegativeIcosaRotation(double x, double y, double z, int meta){
		GL11.glTranslated(x + 0.5D, y + 0.5D, z + 0.5D);
		
		if(meta == 0){
			GL11.glRotatef(-RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		}
		else if(meta == 1){
			GL11.glRotatef(-RenderTickHandler.getRenderTime(), 0F, 1F, 0F);
		}
		else if(meta == 2){
			GL11.glRotatef(-RenderTickHandler.getRenderTime(), 0F, 0F, 1F);
		}
		else if(meta == 3){
			GL11.glRotatef(-RenderTickHandler.getRenderTime(), 0F, 0F, 1F);
		}
		else if(meta == 4){
			GL11.glRotatef(-RenderTickHandler.getRenderTime(), 1F, 0F, 0F);
		}
		else if(meta == 5){
			GL11.glRotatef(-RenderTickHandler.getRenderTime(), 1F, 0F, 0F);
		}
	}

}
