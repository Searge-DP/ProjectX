package snowpaw.projectx.world.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXBase;
import snowpaw.projectx.core.block.ItemBlockXBase;

public class BlockXStorageAluminum extends BlockXBase {

	public BlockXStorageAluminum(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundTypeMetal);
		GameRegistry.registerBlock(this, itemBlock, blockName);
	}

}
