package snowpaw.projectx.lib.item;

import net.minecraft.item.ItemHoe;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

public class XHoeBase extends ItemHoe {

	public XHoeBase(ToolMaterial toolMat, String itemName) {
		super(toolMat);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ProjectX.INSTANCE + ":" + itemName);
	}
	
	public XHoeBase(ToolMaterial toolMat, String subFolder, String itemName) {
		super(toolMat);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ProjectX.INSTANCE + ":" + subFolder + "/" + itemName);
	}

}
