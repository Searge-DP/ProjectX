package snowpaw.projectx.world.block;

import java.util.Random;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXBase;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.core.proxy.ClientProxy;
import snowpaw.projectx.lib.helper.BlockColorHelper;
import snowpaw.projectx.world.XWorldItems;

public class BlockXOre extends BlockXGlow {
	
	public IIcon animationIcon = ClientProxy.animationFX.texture;

	public BlockXOre(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setStepSound(Block.soundTypeStone);
		this.setHardness(1.2F);
		this.setBlockTextureName(ProjectX.INSTANCE + ":" + "ore");
	}
    
    @Override
    @SideOnly(Side.CLIENT)
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

}
