package snowpaw.projectx.machine.block;

import java.util.ArrayList;
import cofh.api.block.IDismantleable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.lib.tile.TileXBase;
import snowpaw.projectx.machine.tile.TilePulsePipe;

public class XBlockPulsePipe extends BlockContainer implements IDismantleable {

	public XBlockPulsePipe(Material material, String blockName) {
		super(material);
		float pixel = 1F/16F;
		this.setBlockName(blockName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setHardness(0.2F);
		this.setBlockBounds(11*pixel/2, 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2);
		this.setStepSound(Block.soundTypeGlass);
		this.setBlockTextureName("minecraft:iron_block");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
		TilePulsePipe pipe = (TilePulsePipe)world.getTileEntity(x, y, z);
		
		if(pipe != null){
			float pixel = 1F/16F;
			float minX = 11*pixel/2-(pipe.connections[5]!=null?(11*pixel/2):0);
			float maxX = 1-11*pixel/2+(pipe.connections[3]!=null?(11*pixel/2):0);
			float minY = 11*pixel/2-(pipe.connections[1]!=null?(11*pixel/2):0);
			float maxY = 1-11*pixel/2+(pipe.connections[0]!=null?(11*pixel/2):0);
			float minZ = 11*pixel/2-(pipe.connections[2]!=null?(11*pixel/2):0);
			float maxZ = 1-11*pixel/2+(pipe.connections[4]!=null?(11*pixel/2):0);
			
			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
		
		return AxisAlignedBB.getBoundingBox(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		TilePulsePipe pipe = (TilePulsePipe)world.getTileEntity(x, y, z);
		
		if(pipe != null){
			float pixel = 1F/16F;
			float minX = 11*pixel/2-(pipe.connections[5]!=null?(11*pixel/2):0);
			float maxX = 1-11*pixel/2+(pipe.connections[3]!=null?(11*pixel/2):0);
			float minY = 11*pixel/2-(pipe.connections[1]!=null?(11*pixel/2):0);
			float maxY = 1-11*pixel/2+(pipe.connections[0]!=null?(11*pixel/2):0);
			float minZ = 11*pixel/2-(pipe.connections[2]!=null?(11*pixel/2):0);
			float maxZ = 1-11*pixel/2+(pipe.connections[4]!=null?(11*pixel/2):0);
			
			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
		
		return AxisAlignedBB.getBoundingBox(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
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
		if(tile instanceof TileXBase){
			return ((TileXBase)tile).canPlayerDismantle(player);
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
	      if ((localTileEntity instanceof TileXBase)) {
	        ((TileXBase)localTileEntity).blockDismantled();
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

}
