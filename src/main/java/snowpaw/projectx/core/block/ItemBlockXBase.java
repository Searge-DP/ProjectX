package snowpaw.projectx.core.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockXBase extends ItemBlock {
	
	public ItemBlockXBase(Block block){
		super(block);
		
		if(((BlockXBase)block).subNames.length > 1){
			this.setHasSubtypes(true);
		}
	}
	
	@Override
	public int getMetadata (int damageValue){
		return damageValue;
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List itemList)
	{
		this.field_150939_a.getSubBlocks(item, tab, itemList);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		if(((BlockXBase)field_150939_a).subNames!=null && ((BlockXBase)field_150939_a).subNames.length>0)
			return getUnlocalizedName()+"."+((BlockXBase)field_150939_a).subNames[ Math.min(((BlockXBase)field_150939_a).subNames.length-1, itemstack.getItemDamage())];
		return super.getUnlocalizedName(itemstack);
	}

}
