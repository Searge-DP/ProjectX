package snowpaw.projectx.core.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.world.proxy.WClientProxy;

/**
 * Created by Le9enD on 09.02.2016.
 */
public class BlockXOreBase extends Block{
    public enum ColorType
    {
        blueRender,
        greenRender,
        redRender,
        blackRender,
        whiteRender;
    }
    public int idBlock;
    public BlockXOreBase(Material material, String unlocalName) {
        super(material);
        setBlockName(unlocalName);
        idBlock = WClientProxy.oreCounter;
        WClientProxy.oreCounter++;
    }

    public ColorType getColorType()
    {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return WClientProxy.renderID[idBlock];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass) {
        WClientProxy.renderPass[idBlock] = pass;
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube() {
        return true;
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        return true;
    }

    @Override
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int side) {
        return true;
    }

}
