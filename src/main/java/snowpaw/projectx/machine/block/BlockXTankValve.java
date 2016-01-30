package snowpaw.projectx.machine.block;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.machine.tile.TileXTankValve;

public class BlockXTankValve extends BlockXGlow {

	public BlockXTankValve(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setStepSound(Block.soundTypeMetal);
		this.setHardness(1.3F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ColourRGBA setBlockColor(int meta){
		return new ColourRGBA(0D, 0D, 1D, 1D);
	}
	
    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int meta){
    	return new TileXTankValve();
    }
    
    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && tile instanceof TileXTankValve) {
        	TileXTankValve valve = (TileXTankValve) world.getTileEntity(x, y, z);
            valve.breakTank(null);
        }
        super.onBlockDestroyedByExplosion(world, x, y, z, explosion);
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        if(!world.isRemote) {
        	TileXTankValve valve = (TileXTankValve) world.getTileEntity(x, y, z);
            valve.breakTank(null);
        }

        super.breakBlock(world, x, y, z, block, metadata);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ)) {
            return true;
        }
        
        if (player.isSneaking())
        	{
        		return false;
        	};

        	TileXTankValve valve = (TileXTankValve) world.getTileEntity(x, y, z);

        if(valve.isValid()) {
            if(FluidUtils.isFluidContainer(player.getHeldItem()))
                return FluidUtils.fluidContainerHandler(world, x, y, z, valve, player);

            player.openGui("ProjectX", 0, world, x, y, z);
            return true;
        }
        else {
            valve.buildTank(ForgeDirection.getOrientation(side).getOpposite());
            if(valve.isValid()) {
                ProjectX.analytics.event(FluidAnalytics.Category.TANK, FluidAnalytics.Event.TANK_BUILD);
            }
        }
        return true;
    }
    
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Item.getItemFromBlock(XMachineBlocks.blockValve);
    }
    
    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int x, int y, int z, int side) {
        TileEntity te = world.getTileEntity(x, y, z);
        if(te instanceof TileXTankValve) {
        	TileXTankValve valve = (TileXTankValve)te;
            return valve.getComparatorOutput();
        }
        return 0;
    }

}
