package dca.projectx.world.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.block.XBlockBase;
import dca.projectx.util.CTMUtil;
import dca.projectx.world.block.ctm.XBlockStorageB;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class XBlockViewer extends XBlockBase {

	public XBlockViewer(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(1.0F);
	}
	
    @SideOnly(Side.CLIENT)
	protected IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[96];

        for(int i = 0; i < 48; i++) {
            if(i < 9)
                icon[i] = iconRegister.registerIcon(ProjectX.INSTANCE + ":viewer/viewer" + "A0" + (i + 1));
            else
                icon[i] = iconRegister.registerIcon(ProjectX.INSTANCE + ":viewer/viewer" + "A" + (i + 1));
        }

        for(int i = 48; i < 96; i++) {
                icon[i] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "transparent");
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side < 6)
            return icon[0];
        else
            return icon[48];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
     public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return !(world.getBlock(x, y, z) instanceof XBlockViewer);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int s) {
        boolean[] bitMatrix = new boolean[8];

        int side;
        if (s < 6)
            side = s;
        else
            side = s - 6;

        if (side == 0 || side == 1) {
            bitMatrix[0] = world.getBlock(x - 1, y, z - 1) instanceof XBlockViewer;
            bitMatrix[1] = world.getBlock(x, y, z - 1) instanceof XBlockViewer;
            bitMatrix[2] = world.getBlock(x + 1, y, z - 1) instanceof XBlockViewer;
            bitMatrix[3] = world.getBlock(x - 1, y, z) instanceof XBlockViewer;
            bitMatrix[4] = world.getBlock(x + 1, y, z) instanceof XBlockViewer;
            bitMatrix[5] = world.getBlock(x - 1, y, z + 1) instanceof XBlockViewer;
            bitMatrix[6] = world.getBlock(x, y, z + 1) instanceof XBlockViewer;
            bitMatrix[7] = world.getBlock(x + 1, y, z + 1) instanceof XBlockViewer;
        } else if (side == 2 || side == 3) {
            bitMatrix[0] = world.getBlock(x + (side == 2 ? 1 : -1), y + 1, z) instanceof XBlockViewer;
            bitMatrix[1] = world.getBlock(x, y + 1, z) instanceof XBlockViewer;
            bitMatrix[2] = world.getBlock(x + (side == 3 ? 1 : -1), y + 1, z) instanceof XBlockViewer;
            bitMatrix[3] = world.getBlock(x + (side == 2 ? 1 : -1), y, z) instanceof XBlockViewer;
            bitMatrix[4] = world.getBlock(x + (side == 3 ? 1 : -1), y, z) instanceof XBlockViewer;
            bitMatrix[5] = world.getBlock(x + (side == 2 ? 1 : -1), y - 1, z) instanceof XBlockViewer;
            bitMatrix[6] = world.getBlock(x, y - 1, z) instanceof XBlockViewer;
            bitMatrix[7] = world.getBlock(x + (side == 3 ? 1 : -1), y - 1, z) instanceof XBlockViewer;
        } else if (side == 4 || side == 5) {
            bitMatrix[0] = world.getBlock(x, y + 1, z + (side == 5 ? 1 : -1)) instanceof XBlockViewer;
            bitMatrix[1] = world.getBlock(x, y + 1, z) instanceof XBlockViewer;
            bitMatrix[2] = world.getBlock(x, y + 1, z + (side == 4 ? 1 : -1)) instanceof XBlockViewer;
            bitMatrix[3] = world.getBlock(x, y, z + (side == 5 ? 1 : -1)) instanceof XBlockViewer;
            bitMatrix[4] = world.getBlock(x, y, z + (side == 4 ? 1 : -1)) instanceof XBlockViewer;
            bitMatrix[5] = world.getBlock(x, y - 1, z + (side == 5 ? 1 : -1)) instanceof XBlockViewer;
            bitMatrix[6] = world.getBlock(x, y - 1, z) instanceof XBlockViewer;
            bitMatrix[7] = world.getBlock(x, y - 1, z + (side == 4 ? 1 : -1)) instanceof XBlockViewer;
        }

        int idBuilder = 0;
        for (int i = 0; i < 8; i++)
            idBuilder = idBuilder + (bitMatrix[i] ? (i == 0 ? 1 : (i == 1 ? 2 : (i == 2 ? 4 : (i == 3 ? 8 : (i == 4 ? 16 : (i == 5 ? 32 : (i == 6 ? 64 : 128))))))) : 0);

        if (s < 6)
            return icon[CTMUtil.textureRefByID[idBuilder]];
        else
            return icon[48 + CTMUtil.textureRefByID[idBuilder]];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
    }

}
