package dca.projectx.world.block.ctm;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.lib.util.CTMUtil;
import dca.projectx.world.block.XBlockStorage;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class XBlockStorageL extends XBlockStorage {

	public XBlockStorageL(Material material, String blockName) {
		super(material, blockName);
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
            bitMatrix[0] = world.getBlock(x - 1, y, z - 1) instanceof XBlockStorageL;
            bitMatrix[1] = world.getBlock(x, y, z - 1) instanceof XBlockStorageL;
            bitMatrix[2] = world.getBlock(x + 1, y, z - 1) instanceof XBlockStorageL;
            bitMatrix[3] = world.getBlock(x - 1, y, z) instanceof XBlockStorageL;
            bitMatrix[4] = world.getBlock(x + 1, y, z) instanceof XBlockStorageL;
            bitMatrix[5] = world.getBlock(x - 1, y, z + 1) instanceof XBlockStorageL;
            bitMatrix[6] = world.getBlock(x, y, z + 1) instanceof XBlockStorageL;
            bitMatrix[7] = world.getBlock(x + 1, y, z + 1) instanceof XBlockStorageL;
        } else if (side == 2 || side == 3) {
            bitMatrix[0] = world.getBlock(x + (side == 2 ? 1 : -1), y + 1, z) instanceof XBlockStorageL;
            bitMatrix[1] = world.getBlock(x, y + 1, z) instanceof XBlockStorageL;
            bitMatrix[2] = world.getBlock(x + (side == 3 ? 1 : -1), y + 1, z) instanceof XBlockStorageL;
            bitMatrix[3] = world.getBlock(x + (side == 2 ? 1 : -1), y, z) instanceof XBlockStorageL;
            bitMatrix[4] = world.getBlock(x + (side == 3 ? 1 : -1), y, z) instanceof XBlockStorageL;
            bitMatrix[5] = world.getBlock(x + (side == 2 ? 1 : -1), y - 1, z) instanceof XBlockStorageL;
            bitMatrix[6] = world.getBlock(x, y - 1, z) instanceof XBlockStorageL;
            bitMatrix[7] = world.getBlock(x + (side == 3 ? 1 : -1), y - 1, z) instanceof XBlockStorageL;
        } else if (side == 4 || side == 5) {
            bitMatrix[0] = world.getBlock(x, y + 1, z + (side == 5 ? 1 : -1)) instanceof XBlockStorageL;
            bitMatrix[1] = world.getBlock(x, y + 1, z) instanceof XBlockStorageL;
            bitMatrix[2] = world.getBlock(x, y + 1, z + (side == 4 ? 1 : -1)) instanceof XBlockStorageL;
            bitMatrix[3] = world.getBlock(x, y, z + (side == 5 ? 1 : -1)) instanceof XBlockStorageL;
            bitMatrix[4] = world.getBlock(x, y, z + (side == 4 ? 1 : -1)) instanceof XBlockStorageL;
            bitMatrix[5] = world.getBlock(x, y - 1, z + (side == 5 ? 1 : -1)) instanceof XBlockStorageL;
            bitMatrix[6] = world.getBlock(x, y - 1, z) instanceof XBlockStorageL;
            bitMatrix[7] = world.getBlock(x, y - 1, z + (side == 4 ? 1 : -1)) instanceof XBlockStorageL;
        }

        int idBuilder = 0;
        for (int i = 0; i < 8; i++)
            idBuilder = idBuilder + (bitMatrix[i] ? (i == 0 ? 1 : (i == 1 ? 2 : (i == 2 ? 4 : (i == 3 ? 8 : (i == 4 ? 16 : (i == 5 ? 32 : (i == 6 ? 64 : 128))))))) : 0);

        if (s < 6)
            return icon[CTMUtil.textureRefByID[idBuilder]];
        else
            return icon[48 + CTMUtil.textureRefByID[idBuilder]];
    }

}
