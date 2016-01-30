package snowpaw.projectx.world.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXBase;
import snowpaw.projectx.core.block.ItemBlockXBase;

public class BlockXGlassViewer extends BlockXBase {

	public BlockXGlassViewer(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setHardness(1F);
		this.setStepSound(Block.soundTypeGlass);
		GameRegistry.registerBlock(this, itemBlock, blockName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube(){
		return false;
	}

}
