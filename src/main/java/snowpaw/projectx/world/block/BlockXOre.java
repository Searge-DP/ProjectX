package snowpaw.projectx.world.block;

import java.util.Random;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXBase;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.core.proxy.ClientProxy;
import snowpaw.projectx.lib.helper.BlockColorHelper;
import snowpaw.projectx.world.XWorldItems;
import net.minecraft.block.BlockRedstoneOre;

public class BlockXOre extends BlockXGlow {

	public BlockXOre(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setStepSound(Block.soundTypeStone);
		this.setHardness(1.2F);
		this.setBlockTextureName(ProjectX.INSTANCE + ":" + "ore");
	}
	
	@Override
	public ColourRGBA setBlockColor(int meta){
		return BlockColorHelper.setColor5(meta);
	}
    
    @Override
    public Item getItemDropped(int i, Random rand, int j){
    	return XWorldItems.gem;
    }
    
    @Override
    public int damageDropped(int meta){
    	return meta;
    }

	@Override
	public int quantityDropped(Random random)
	{
		return 4 + random.nextInt(2);
	}

	@Override
	public int quantityDroppedWithBonus(int quantity, Random random)
	{
		return this.quantityDropped(random) + random.nextInt(quantity + 1);
	}

	@Override
	public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
	{
		super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, p_149690_7_);
	}
}
