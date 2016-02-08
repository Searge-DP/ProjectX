package snowpaw.projectx.world.block;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.lib.helper.BlockColorHelper;

/**
 * Created by Le9enD on 07.02.2016.
 */
public class BlockEngineeringBrick extends BlockXGlow {
    public BlockEngineeringBrick(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
        super(blockName, material, itemBlock, subNames);
    }

    @SideOnly(Side.CLIENT)
    private IIcon icon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icon = iconRegister.registerIcon(ProjectX.MODID + ":" + "machine/" + "engineeringBrick");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ColourRGBA setBlockColor(int meta){
        return BlockColorHelper.setColor5(meta);
    }
}
