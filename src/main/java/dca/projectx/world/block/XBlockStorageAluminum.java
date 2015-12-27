package dca.projectx.world.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.XTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class XBlockStorageAluminum extends Block {

	public XBlockStorageAluminum(Material material, String blockName) {
		super(material);
		this.setBlockName(blockName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundTypeMetal);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[1];
        icon[0] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "storageAluminum");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
    	return icon[0];
    }

}
