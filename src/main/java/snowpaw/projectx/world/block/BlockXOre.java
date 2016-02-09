package snowpaw.projectx.world.block;

import java.util.ArrayList;
import java.util.Random;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXBase;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.BlockXOreBase;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.core.proxy.ClientProxy;
import snowpaw.projectx.lib.helper.BlockColorHelper;
import snowpaw.projectx.world.XWorldBlocks;
import snowpaw.projectx.world.XWorldItems;
import net.minecraft.block.BlockRedstoneOre;

public class BlockXOre extends BlockXOreBase {
	public BlockXOre(Material material, String unlocalName) {
		super(material, unlocalName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setHardness(2.5f);
		this.setStepSound(Block.soundTypeStone);
		GameRegistry.registerBlock(this, unlocalName);
	}

	public enum OreType
	{
		oreBlue,
		oreGreen,
		oreRed,
		oreBlack,
		oreWhite;
	}

	@SideOnly(Side.CLIENT)
	private IIcon icon[];

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		icon = new IIcon[2];
		icon[0] = register.registerIcon(ProjectX.INSTANCE + ":" + "ore");
		if(this == XWorldBlocks.xycroniumOreBlue)
			icon[1] = register.registerIcon(ProjectX.INSTANCE + ":" + "ore/oreBlue");
		if(this == XWorldBlocks.xycroniumOreGreen)
			icon[1] = register.registerIcon(ProjectX.INSTANCE + ":" + "ore/oreGreen");
		if(this == XWorldBlocks.xycroniumOreRed)
			icon[1] = register.registerIcon(ProjectX.INSTANCE + ":" + "ore/oreRed");
		if(this == XWorldBlocks.xycroniumOreBlack)
			icon[1] = register.registerIcon(ProjectX.INSTANCE + ":" + "ore/oreBlack");
		if(this == XWorldBlocks.xycroniumOreWhite)
			icon[1] = register.registerIcon(ProjectX.INSTANCE + ":" + "ore/oreWhite");
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);
		if(this == XWorldBlocks.xycroniumOreBlue)
			ret.add(new ItemStack(XWorldItems.gem, 3+fortune, OreType.oreBlue.ordinal()));
		if(this == XWorldBlocks.xycroniumOreGreen)
			ret.add(new ItemStack(XWorldItems.gem, 3+fortune, OreType.oreGreen.ordinal()));
		if(this == XWorldBlocks.xycroniumOreRed)
			ret.add(new ItemStack(XWorldItems.gem, 3+fortune, OreType.oreRed.ordinal()));
		if(this == XWorldBlocks.xycroniumOreBlack)
			ret.add(new ItemStack(XWorldItems.gem, 3+fortune, OreType.oreBlack.ordinal()));
		if(this == XWorldBlocks.xycroniumOreWhite)
			ret.add(new ItemStack(XWorldItems.gem, 3+fortune, OreType.oreWhite.ordinal()));

		return ret;
	}

		@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if(side < 6 )
			return icon[0];
		else
			return icon[1];
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
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return null;
	}

	@Override
	public int quantityDropped(Random p_149745_1_)
	{
		return 4 + p_149745_1_.nextInt(5) * 1;
	}





}
