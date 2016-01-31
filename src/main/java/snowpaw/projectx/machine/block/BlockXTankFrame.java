package snowpaw.projectx.machine.block;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.ForgeEventFactory;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.lib.block.ExtendedBlock;
import snowpaw.projectx.lib.util.FluidUtils;
import snowpaw.projectx.machine.proxy.MClientProxy;
import snowpaw.projectx.machine.tile.TileXTankFrame;
import snowpaw.projectx.machine.tile.TileXTankValve;

public class BlockXTankFrame extends BlockXMachineBase {

	public BlockXTankFrame(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new TileXTankFrame();
	}
	
	@Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }
	
    @Override
    public void onBlockExploded(World world, int x, int y, int z, Explosion explosion) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && tile instanceof TileXTankFrame) {
        	TileXTankFrame frame = (TileXTankFrame) world.getTileEntity(x, y, z);
            frame.setBlock(null);
            frame.breakFrame();
            frame.onBreak();
        }
        super.onBlockDestroyedByExplosion(world, x, y, z, explosion);
    }
    
    @Override
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && tile instanceof TileXTankFrame) {
            TileXTankFrame frame = (TileXTankFrame) world.getTileEntity(x, y, z);
            if(!player.capabilities.isCreativeMode) {
                ArrayList<ItemStack> items = new ArrayList<ItemStack>();

                Block block = frame.getBlock().getBlock();
                int meta = frame.getBlock().getMetadata();

                if(block.canSilkHarvest(world, player, x, y, z, meta) && EnchantmentHelper.getSilkTouchModifier(player)) {
                    ForgeEventFactory.fireBlockHarvesting(items, world, block, x, y, z, meta, 0, 1.0f, true, player);

                    ItemStack itemstack = new ItemStack(Item.getItemFromBlock(block), 1, meta);
                    items.add(itemstack);

                    for (ItemStack is : items)
                    {
                        this.dropBlockAsItem(world, x, y, z, is);
                    }
                }
                else {
                    ForgeEventFactory.fireBlockHarvesting(items, world, block, x, y, z, meta, 0, 1.0f, false, player);

                    items.addAll(block.getDrops(world, x, y, z, meta, 0));
                    for (ItemStack is : items)
                    {
                        this.dropBlockAsItem(world, x, y, z, is);
                    }
                }
            }
            frame.onBreak();
        }
        return super.removedByPlayer(world, player, x, y, z, willHarvest);
    }
    
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return null;
    }

    @Override
    public float getPlayerRelativeBlockHardness(EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && tile instanceof TileXTankFrame) {
            TileXTankFrame frame = (TileXTankFrame) world.getTileEntity(x, y, z);
            return frame.getBlock().getBlock().getPlayerRelativeBlockHardness(player, world, x, y, z);
        }
        return super.getPlayerRelativeBlockHardness(player, world, x, y, z);
    }
    
    @Override
    public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
        return true;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean canRenderInPass(int pass) {
        ForgeHooksClient.setRenderPass(pass);
        return true;
    }

    @Override
    public int getRenderType() {
        return MClientProxy.tankFrameRenderId;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ)) {
            return true;
        }
        if (player.isSneaking()) return false;

        TileXTankFrame frame = (TileXTankFrame) world.getTileEntity(x, y, z);
        if(frame != null && frame.getValve() != null) {
            TileXTankValve valve = frame.getValve();
            if (valve.isValid()) {
                if(FluidUtils.isFluidContainer(player.getHeldItem()))
                    return FluidUtils.fluidContainerHandler(world, x, y, z, valve, player);

                player.openGui("ProjectXMachines", 0, world, x, y, z);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && tile instanceof TileXTankFrame) {
            ExtendedBlock block = ((TileXTankFrame)tile).getBlock();
            if(block != null)
                return block.getBlock().getPickBlock(target, world, x, y, z, player);
        }
        return null;
    }

    public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && tile instanceof TileXTankFrame) {
            TileXTankFrame frame = (TileXTankFrame) tile;
            if(frame.getBlock() != null) {
                return frame.getBlock().getBlock().getFlammability(world, x, y, z, face);
            }
        }
        return 0;
    }
    
    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && tile instanceof TileXTankFrame) {
            TileXTankFrame frame = (TileXTankFrame) tile;
            if(frame.getBlock() != null) {
                return frame.getBlock().getBlock().getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
            }
        }
        return super.getExplosionResistance(par1Entity);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && tile instanceof TileXTankFrame) {
            TileXTankFrame frame = (TileXTankFrame) world.getTileEntity(x, y, z);
            frame.onBreak();
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }
    
    @Override
    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
        return false;
    }

}
