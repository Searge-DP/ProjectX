package snowpaw.projectx.machine.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import snowpaw.projectx.machine.tile.TilePulsePipeT1;
import snowpaw.projectx.machine.tile.TilePulsePipeT3;

public class XBlockPulsePipeT1 extends XBlockPulsePipe {

	public XBlockPulsePipeT1(Material material, String blockName) {
		super(material, blockName);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TilePulsePipeT1();
	}

}
