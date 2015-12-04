package dca.projectx.core.item;

import dca.projectx.core.ProjectX;
import dca.projectx.core.XTabs;
import net.minecraft.item.ItemPickaxe;

public class XPickaxeBase extends ItemPickaxe {

	public XPickaxeBase(ToolMaterial toolMat, String itemName) {
		super(toolMat);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setTextureName(ProjectX.INSTANCE + ":" + itemName);
	}
	
	public XPickaxeBase(ToolMaterial toolMat, String subFolder, String itemName) {
		super(toolMat);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setTextureName(ProjectX.INSTANCE + ":" + subFolder + "/" + itemName);
	}

}
