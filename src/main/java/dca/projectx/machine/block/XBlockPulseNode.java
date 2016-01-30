package dca.projectx.machine.block;

import java.util.ArrayList;

import cofh.api.block.IDismantleable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.block.tile.TileMachineBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.lib.render.PlacementLogic;

public class XBlockPulseNode extends BlockContainer implements IDismantleable {
	
	public XBlockPulseNode(Material material, String blockName){
		super(material);
		this.setBlockName(blockName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setBlockTextureName("minecraft:iron_block");
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockBounds(0.2F, 0F, 0.2F, 0.8F, 1F, 0.8F);
	}
	
	public TileEntity createNewTileEntity(World world, int meta){
		return null;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return -1;
    }
    
    public NBTTagCompound getItemStackTag(World paramWorld, int paramInt1, int paramInt2, int paramInt3)
    {
      TileEntity localTileEntity = paramWorld.getTileEntity(paramInt1, paramInt2, paramInt3);
      NBTTagCompound localNBTTagCompound = null;
      return localNBTTagCompound;
    }

	@Override
	public boolean canDismantle(EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if(tile instanceof TileMachineBase){
			return ((TileMachineBase)tile).canPlayerDismantle(player);
		}
		return true;
	}

	@Override
	public ArrayList<ItemStack> dismantleBlock(EntityPlayer player, World world, int x, int y, int z, boolean b) {
		return dismantleBlock(player, getItemStackTag(world, x, y, z), world, x, y, z, b, false);
	}
	
	public ArrayList<ItemStack> dismantleBlock(EntityPlayer paramEntityPlayer, NBTTagCompound paramNBTTagCompound, World paramWorld, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
	  {
	    TileEntity localTileEntity = paramWorld.getTileEntity(paramInt1, paramInt2, paramInt3);
	    int i = paramWorld.getBlockMetadata(paramInt1, paramInt2, paramInt3);
	    
	    ItemStack localItemStack = new ItemStack(this, 1, i);
	    if (paramNBTTagCompound != null) {
	      localItemStack.setTagCompound(paramNBTTagCompound);
	    }
	    if (!paramBoolean2)
	    {
	      if ((localTileEntity instanceof TileMachineBase)) {
	        ((TileMachineBase)localTileEntity).blockDismantled();
	      }
	      paramWorld.setBlockToAir(paramInt1, paramInt2, paramInt3);
	      if (!paramBoolean1)
	      {
	        float f = 0.3F;
	        double d1 = paramWorld.rand.nextFloat() * f + (1.0F - f) * 0.5D;
	        double d2 = paramWorld.rand.nextFloat() * f + (1.0F - f) * 0.5D;
	        double d3 = paramWorld.rand.nextFloat() * f + (1.0F - f) * 0.5D;
	        EntityItem localEntityItem = new EntityItem(paramWorld, paramInt1 + d1, paramInt2 + d2, paramInt3 + d3, localItemStack);
	        localEntityItem.delayBeforeCanPickup = 10;
	        paramWorld.spawnEntityInWorld(localEntityItem);
	      }
	    }
	    ArrayList localArrayList = new ArrayList();
	    localArrayList.add(localItemStack);
	    return localArrayList;
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
		return PlacementLogic.isPlacementPossible(world, x, y, z);
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta){
		return PlacementLogic.getPlacementData(world, x, y, z, side, true);
	}

}
