package snowpaw.projectx.world.block;
/**
 * Created by Le9enD on 06.02.2016.
 */

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
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

import java.util.Random;

/**
 * Created by Le9enD on 06.02.2016.
 */
public class BlockXElementalWater extends BlockXGlow {
    public BlockXElementalWater(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
        super(blockName, Material.water, itemBlock, subNames);
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
        this.icon = new IIcon[2];
        this.icon[0] = iconRegister.registerIcon(ProjectX.MODID + ":" + "machine/" + "machine_elemental");
        this.icon[1] = iconRegister.registerIcon(ProjectX.MODID + ":" + "machine/" + "water");

    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side < 6)
            switch (side){
                case 0: return icon[0];
                case 1: return icon[0];
                case 2: return icon[1];
                case 3: return icon[1];
                case 4: return icon[1];
                case 5: return icon[1];
            }
        return icon[side];
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return false;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return false;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public ColourRGBA setBlockColor(int meta){
        return new ColourRGBA(0D, 0D, 1D, 1D);
    }
}

