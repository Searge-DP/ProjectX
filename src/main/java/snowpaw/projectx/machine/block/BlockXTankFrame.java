package snowpaw.projectx.machine.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.machine.tile.TileXTankFrame;

public class BlockXTankFrame extends BlockXGlow {

	public BlockXTankFrame(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setStepSound(Block.soundTypeMetal);
		this.setHardness(1.3F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new TileXTankFrame();
	}

}
