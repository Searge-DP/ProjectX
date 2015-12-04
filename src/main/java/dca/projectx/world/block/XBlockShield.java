package dca.projectx.world.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.block.XBlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class XBlockShield extends XBlockBase {

	public XBlockShield(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(2.0F);
		this.setResistance(10000000F);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[2];
        icon[0] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "shield");
        icon[1] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "glow");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side < 6)
            return icon[0];
        else
            return icon[1];
    }

}
