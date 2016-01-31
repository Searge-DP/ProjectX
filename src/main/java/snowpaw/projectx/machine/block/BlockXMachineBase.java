package snowpaw.projectx.machine.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;

public class BlockXMachineBase extends BlockXGlow {

	public BlockXMachineBase(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setBlockTextureName(ProjectX.INSTANCE + ":machine/" + blockName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setHardness(1.3F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return null;
	}
	
}
