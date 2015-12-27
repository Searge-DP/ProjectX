package dca.projectx.world.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.block.XBlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class XBlockStorageXycronium extends XBlockBase {

	public XBlockStorageXycronium(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(1.5F);
	}
	
    @SideOnly(Side.CLIENT)
	protected IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[96];

        for(int i = 0; i < 48; i++) {
            if(i < 9)
                icon[i] = iconRegister.registerIcon(ProjectX.INSTANCE + ":storage/storage" + "A0" + (i + 1));
            else
                icon[i] = iconRegister.registerIcon(ProjectX.INSTANCE + ":storage/storage" + "A" + (i + 1));
        }

        for(int i = 48; i < 96; i++) {
                icon[i] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "glow");
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
        return !(world.getBlock(x, y, z) instanceof XBlockStorageXycronium);
    }

}
