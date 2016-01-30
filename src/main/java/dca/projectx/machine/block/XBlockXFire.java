package dca.projectx.machine.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.block.XBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

public class XBlockXFire extends XBlockBase {

	public XBlockXFire(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(1.2F);
		this.setCreativeTab(XTabs.tabProjectXMachines);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[5];
        icon[0] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "fire");
        icon[1] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "machine");
        icon[2] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "fireOff");
        icon[3] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "fireOn");
        icon[4] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "glow");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0)
            return icon[1];
        else if (side == 1)
        	if(meta == 1){
        		return icon[3];
        	}
        	else
        		return icon[2];
        else if (side == 2)
            return icon[0];
        else if (side == 3)
            return icon[0];
        else if (side == 4)
            return icon[0];
        else if (side == 5)
            return icon[0];
        else
            return icon[4];
    }
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4) {
		return false;
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
		return true;
	}
	
	@Override
	public boolean isNormalCube() {
		return true;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlock(x, y + 1, z).isReplaceable(world, x, y, z)) {
			world.setBlock(x, y + 1, z, Blocks.fire);
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		else
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
	}
	
	@Override
	public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
		return true;
	}

}
