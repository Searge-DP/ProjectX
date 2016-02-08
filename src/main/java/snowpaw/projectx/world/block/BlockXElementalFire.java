package snowpaw.projectx.world.block;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;

/**
 * Created by Le9enD on 06.02.2016.
 */
public class BlockXElementalFire extends BlockXGlow {
    public BlockXElementalFire(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
        super(blockName, material, itemBlock, subNames);
        this.setBlockName(blockName);
        this.setCreativeTab(XTabs.tabProjectXMachines);
        this.setHardness(1.5F);
        this.setStepSound(Block.soundTypeMetal);

    }

    @SideOnly(Side.CLIENT)
    private IIcon icon[];

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icon = new IIcon[3];
        this.icon[0] = iconRegister.registerIcon(ProjectX.MODID + ":" + "machine/" + "machine_elemental");
        this.icon[1] = iconRegister.registerIcon(ProjectX.MODID + ":" + "machine/" + "fire");
        this.icon[2] = iconRegister.registerIcon(ProjectX.MODID + ":" + "machine/" + "fireOff");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side < 6)
            switch (side){
                case 0: return icon[0];
                case 1: return icon[2];
                case 2: return icon[1];
                case 3: return icon[1];
                case 4: return icon[1];
                case 5: return icon[1];
            }

        return icon[side];
    }

    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {

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
        }
    }

    @Override
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ColourRGBA setBlockColor(int meta){
        return new ColourRGBA(1D, 0D, 0D, 1D);
    }
}
