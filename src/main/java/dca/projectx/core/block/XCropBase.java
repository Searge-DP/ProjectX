package dca.projectx.core.block;

import java.util.ArrayList;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class XCropBase extends BlockBush implements IGrowable {
	
	public String blockName;
	public String[] subNames;
	public final IIcon[] icons;
	
	public XCropBase(String blockName, String... subNames){
		this.setTickRandomly(true);
		this.blockName = blockName;
		this.subNames = subNames;
		this.icons = new IIcon[subNames.length];
		this.setBlockName(blockName);
		this.setBlockBounds(0,0,0, 1,.25f,1);
		this.disableStats();
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.setCreativeTab((CreativeTabs)null);
	}
	
	@Override
	public int getRenderType()
	{
		return 6;
	}
	
	public int getMinMeta(int meta)
	{
		return meta<=4?0:5;
	}
	
	public int getMaxMeta(int meta)
	{
		return meta<=4?4:5;
	}
	
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		return getMinMeta(meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		for(int i=0;i<subNames.length;i++)
			icons[i] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "crop/" + blockName + "/" + blockName + "_" + subNames[i]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if(meta<icons.length)
			return icons[meta];
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if(meta<icons.length)
			return icons[meta];
		return null;
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		boolean b = super.canBlockStay(world, x, y, z);
		if(world.getBlockMetadata(x, y, z)==5)
			b = world.getBlock(x, y-1, z).equals(this)&&world.getBlockMetadata(x, y-1, z)==getMaxMeta(0);
		return b;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		this.setBlockBounds(0,0,0,1,meta==0?.375f: meta==1?.625f: meta==2?.875f: 1,1);
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		this.setBlockBoundsBasedOnState(world,x,y,z);
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		super.onNeighborBlockChange(world, x, y, z, block);
		if(world.getBlockMetadata(x, y, z)<getMaxMeta(0))
			world.notifyBlockOfNeighborChange(x, y+1, z, this);
	}

	@Override
	public void updateTick (World world, int x, int y, int z, Random random)
	{
		this.checkAndDropBlock(world, x, y, z);
		int light = world.getBlockLightValue(x, y, z);
		if(light >= 12)
		{
			int meta = world.getBlockMetadata(x, y, z);
			if(meta>4)
				return;
			float growth = this.getGrowthSpeed(world, x, y, z, meta, light);
			if (random.nextInt((int)(50F/growth)+1) == 0)
			{
				if(this.getMaxMeta(meta) != meta)
				{
					meta++;
					world.setBlockMetadataWithNotify(x, y, z, meta, 0x3);
				}
				if(meta>3 && world.isAirBlock(x, y+1, z))
					world.setBlock(x, y+1, z, this, meta+1, 0x3);
			}
		}
	}
	
	float getGrowthSpeed(World world, int x, int y, int z, int meta, int light)
	{
		float growth = 0.125f * (light - 11);
		if(world.canBlockSeeTheSky(x, y, z))
			growth += 2f;
		if(world.getBlock(x,y-1,z)!=null && world.getBlock(x,y-1,z).isFertile(world,x,y-1,z))
			growth *= 1.5f;
		return 1f + growth;
	}

	@Override
	protected boolean canPlaceBlockOn(Block block)
	{
		return block!=null && (block==this || block.equals(Blocks.farmland) || block instanceof BlockFarmland);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Crop;
	}

	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean client)
	{
		if(world.getBlockMetadata(x, y, z)<getMaxMeta(world.getBlockMetadata(x, y, z)))
			return true;
		else 
			return world.getBlockMetadata(x, y, z)==4 && !world.getBlock(x, y+1, z).equals(this);
	}

	@Override
	public boolean func_149852_a(World world, Random rand, int x, int y, int z)
	{
		if(world.getBlockMetadata(x, y, z)<getMaxMeta(world.getBlockMetadata(x, y, z)))
			return true;
		else 
			return world.getBlockMetadata(x, y, z)==4 && !world.getBlock(x, y+1, z).equals(this);
	}

	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if(meta<getMaxMeta(meta))
		{
			int span = getMaxMeta(meta)-meta;
			int newMeta = meta+rand.nextInt(span)+1;
			if(newMeta!=meta)
				world.setBlockMetadataWithNotify(x, y, z, newMeta, 0x3);
			meta = newMeta;
		}
		if(meta==4 && world.isAirBlock(x, y+1, z))
			world.setBlock(x, y+1, z, this, meta+1, 0x3);
	}

}
