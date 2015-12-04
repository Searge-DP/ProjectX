package dca.projectx.machine.item;

import dca.projectx.core.XTabs;
import net.minecraft.item.Item;

public class XItemEnergyCore extends Item {
	
	public XItemEnergyCore(String itemName){
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
	}
	
	public XItemEnergyCore(String itemName, String subFolder){
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
	}

}
