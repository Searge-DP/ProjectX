package snowpaw.projectx.machine.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import snowpaw.projectx.lib.block.ExtendedBlock;
import snowpaw.projectx.lib.block.IBlockAccessHandler;
import snowpaw.projectx.machine.tile.TileXTankFrame;

public class RenderFrameBlock extends IBlockAccessHandler {
	
    public RenderFrameBlock(IBlockAccess iBlockAccess) {
        super(iBlockAccess);
    }

    @Override
    public Block getBlock(int x, int y, int z) {
        Block block = super.getBlock(x, y, z);
        TileEntity tile = getTileEntity(x, y, z);
        if(tile instanceof TileXTankFrame) {
        	TileXTankFrame frame = (TileXTankFrame) tile;
            if(frame.getBlock() == null)
                return block;

            Block fac = frame.getBlock().getBlock();
            if(fac != null) {
                block = fac;
            }
        }
        return block;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getLightBrightnessForSkyBlocks(int var1, int var2, int var3, int var4) {
        return ba.getLightBrightnessForSkyBlocks(var1, var2, var3, var4);
    }

    @Override
    public int getBlockMetadata(int x, int y, int z) {
        TileEntity tile = getTileEntity(x, y, z);
        if(tile instanceof TileXTankFrame) {
        	TileXTankFrame frame = (TileXTankFrame) tile;
            ExtendedBlock exBlock = frame.getBlock();
            if(exBlock.getBlock() != null) {
                return exBlock.getMetadata();
            }
        }
        return super.getBlockMetadata(x, y, z);
    }

}
