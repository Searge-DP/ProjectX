package dca.projectx.machine.block;

import dca.projectx.core.XTabs;
import dca.projectx.core.block.XBlockBase;
import net.minecraft.block.material.Material;

public class XBlockPulseFurnace extends XBlockBase {

	public XBlockPulseFurnace(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(1.2F);
		this.setCreativeTab(XTabs.tabProjectXMachines);
	}

}