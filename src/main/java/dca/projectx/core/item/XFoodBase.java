package dca.projectx.core.item;

import dca.projectx.core.ProjectX;
import dca.projectx.core.XTabs;
import net.minecraft.item.ItemFood;

public class XFoodBase extends ItemFood {

	public XFoodBase(String itemName, int heal, float satMod, boolean favFood) {
		super(heal, satMod, favFood);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setAlwaysEdible();
		this.setTextureName(ProjectX.INSTANCE + ":" + itemName);
	}
	
	public XFoodBase(String itemName, int heal, boolean favFood) {
		super(heal, favFood);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setAlwaysEdible();
		this.setTextureName(ProjectX.INSTANCE + ":" + itemName);
	}

}
