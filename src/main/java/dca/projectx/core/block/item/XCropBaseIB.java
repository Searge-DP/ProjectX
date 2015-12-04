package dca.projectx.core.block.item;

import java.util.List;
import dca.projectx.core.block.XCropBase;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class XCropBaseIB extends ItemBlock {
	
	public XCropBaseIB(Block block){
		super(block);
		if(((XCropBase)block).subNames.length>1)
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
		return getUnlocalizedName()+"."+((XCropBase)field_150939_a).subNames[itemstack.getItemDamage()];
	}
	
	@Override
    public IIcon getIconFromDamage(int p_77617_1_)
	{
		return this.field_150939_a.getIcon(1, p_77617_1_);
	}

}
