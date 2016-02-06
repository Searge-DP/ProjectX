package snowpaw.projectx.machine.block;

import net.minecraft.block.material.Material;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;

public class XBlockNodeBase extends BlockXGlow {

	public XBlockNodeBase(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
	}

}
