package dca.projectx.machine.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.block.XBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

public class XBlockXVoid extends XBlockBase {

	public XBlockXVoid(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(1.2F);
		this.setCreativeTab(XTabs.tabProjectXMachines);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[2];
        icon[0] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "void");
        icon[1] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "glow");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0)
            return icon[0];
        else if (side == 1)
            return icon[0];
        else if (side == 2)
            return icon[0];
        else if (side == 3)
            return icon[0];
        else if (side == 4)
            return icon[0];
        else if (side == 5)
            return icon[0];
        else
            return icon[1];
    }
    
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS)
			voidFluid(world, x, y, z, dir);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS)
			voidFluid(world, x, y, z, dir);
	}
	
	public void voidFluid(World world, int x, int y, int z, ForgeDirection dir) {
		if (world.getBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ).getMaterial() instanceof MaterialLiquid) {
			world.setBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ, Blocks.air);
		}
	}

}
