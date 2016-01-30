package snowpaw.projectx.lib.item;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

public class XItemBase extends Item {
	
	public String itemName;
	public String[] subNames;
	public IIcon[] icons;
	
	public XItemBase(String itemName, int stackSize, String... subNames){
		this.setHasSubtypes(subNames!=null&&subNames.length>0);
		this.setMaxStackSize(stackSize);
		this.itemName = itemName;
		this.subNames = subNames!=null&&subNames.length<1?null:subNames;
		this.icons = new IIcon[this.subNames!=null?this.subNames.length:1];
		this.setCreativeTab(XTabs.tabProjectX);
		this.setUnlocalizedName(itemName);
	}
	
	public String[] getSubNames()
	{
		return subNames;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		if(getSubNames()!=null)
			for(int i=0;i<icons.length;i++)
				this.icons[i] = ir.registerIcon(ProjectX.INSTANCE + ":" + itemName + "_" + getSubNames()[i]);
		else
			this.icons[0] = ir.registerIcon(ProjectX.INSTANCE + ":" + itemName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta)
	{
		if(getSubNames()!=null)
			if(meta>=0 && meta<icons.length)
				return this.icons[meta];
		return icons[0];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		if(getSubNames()!=null)
			for(int i=0;i<getSubNames().length;i++)
				list.add(new ItemStack(this,1,i));
		else
			list.add(new ItemStack(this));

	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		if(getSubNames()!=null)
		{
			String subName = stack.getItemDamage()<getSubNames().length?getSubNames()[stack.getItemDamage()]:"";
			return this.getUnlocalizedName()+"."+subName;
		}
		return this.getUnlocalizedName();
	}

}
