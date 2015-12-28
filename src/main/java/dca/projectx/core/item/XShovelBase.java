package dca.projectx.core.item;

import dca.projectx.core.ProjectX;
import dca.projectx.core.XTabs;
import net.minecraft.item.ItemSpade;

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
