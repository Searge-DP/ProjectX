package snowpaw.projectx.lib.item;

import net.minecraft.item.ItemSword;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

public class XSwordBase extends ItemSword {

	public XSwordBase(ToolMaterial toolMat, String itemName) {
		super(toolMat);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ProjectX.INSTANCE + ":" + itemName);
	}
	
	public XSwordBase(ToolMaterial toolMat, String subFolder, String itemName) {
		super(toolMat);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ProjectX.INSTANCE + ":" + subFolder + "/" + itemName);
	}

}
