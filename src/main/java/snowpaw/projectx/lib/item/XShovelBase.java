package snowpaw.projectx.lib.item;

import net.minecraft.item.ItemSpade;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

public class XShovelBase extends ItemSpade {

	public XShovelBase(ToolMaterial toolMat, String itemName) {
		super(toolMat);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ProjectX.INSTANCE + ":" + itemName);
	}
	
	public XShovelBase(ToolMaterial toolMat, String subFolder, String itemName) {
		super(toolMat);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ProjectX.INSTANCE + ":" + subFolder + "/" + itemName);
	}

}
