package snowpaw.projectx.lib.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockXCrop extends ItemBlock {
	
	public ItemBlockXCrop(Block block){
		super(block);
		if(((BlockXCropBase)block).subNames.length>1)
			setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata (int damageValue)
	{
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
		return getUnlocalizedName()+"."+((BlockXCropBase)field_150939_a).subNames[itemstack.getItemDamage()];
	}
	
	@Override
    public IIcon getIconFromDamage(int p_77617_1_)
	{
		return this.field_150939_a.getIcon(1, p_77617_1_);
	}

}
