package dca.projectx.machine.block;

import dca.projectx.core.XTabs;
import dca.projectx.core.block.XBlockBase;
import net.minecraft.block.material.Material;

public class XBlockTankValve extends XBlockBase {

	public XBlockTankValve(Material material, String blockName) {
		super(material, blockName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setHardness(1.5F);
	}

}
