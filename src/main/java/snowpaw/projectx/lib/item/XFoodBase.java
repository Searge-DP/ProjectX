package snowpaw.projectx.lib.item;

import net.minecraft.item.ItemFood;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

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
