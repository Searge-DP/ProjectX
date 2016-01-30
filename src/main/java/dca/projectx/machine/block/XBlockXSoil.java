package dca.projectx.machine.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.block.XBlockBase;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

public class XBlockXSoil extends XBlockBase {

	public XBlockXSoil(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(1.2F);
		this.setTickRandomly(true);
		this.setCreativeTab(XTabs.tabProjectXMachines);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[3];
        icon[0] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "machine");
        icon[1] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "soil");
        icon[2] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "glow");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0)
            return icon[0];
        else if (side == 1)
            return icon[0];
        else if (side == 2)
            return icon[1];
        else if (side == 3)
            return icon[1];
        else if (side == 4)
            return icon[1];
        else if (side == 5)
            return icon[1];
        else
            return icon[2];
    }
    
	@Override
	public int tickRate(World world) {
		return 30;
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		return true;
	}
	
	public int countBlocks(World world, int x, int y, int z) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (world.getBlock(x, y - i, z) == this) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(11 - countBlocks(world, x, y, z)) == 0)
			if (world.getBlock(x, y + 1, z) instanceof IGrowable) {
				((IGrowable) world.getBlock(x, y + 1, z)).func_149853_b(world, rand, x, y + 1, z);

			}
	}
	
	@Override
	public boolean isFertile(World world, int x, int y, int z) {
		return true;
	}

}
