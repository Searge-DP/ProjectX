package snowpaw.projectx.machine.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.machine.tile.TileXFluidDetector;

public class BlockXFluidDetector extends BlockXMachineBase {

	public BlockXFluidDetector(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new TileXFluidDetector();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean renderAsNormalBlock(){
		return false;
	}

}
