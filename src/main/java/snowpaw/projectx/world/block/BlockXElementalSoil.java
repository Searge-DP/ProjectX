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
public class BlockXElementalSoil extends BlockXGlow {
    public BlockXElementalSoil(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
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
        this.icon = new IIcon[2];
        this.icon[0] = iconRegister.registerIcon(ProjectX.MODID + ":" + "machine/" + "machine_elemental");
        this.icon[1] = iconRegister.registerIcon(ProjectX.MODID + ":" + "machine/" + "soil");
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

    @Override
    @SideOnly(Side.CLIENT)
    public ColourRGBA setBlockColor(int meta){
        return new ColourRGBA(0D, 1D, 0D, 1D);
    }
}

