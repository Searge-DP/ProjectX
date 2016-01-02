package dca.projectx.machine.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.block.XBlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class XBlockXWater extends XBlockBase {

	public XBlockXWater(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(1.5F);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[3];
        icon[0] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "machine");
        icon[1] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "water");
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
            return icon[0];
        else if (side == 3)
            return icon[0];
        else if (side == 4)
            return icon[0];
        else if (side == 5)
            return icon[0];
        else
            return icon[2];
    }

}
