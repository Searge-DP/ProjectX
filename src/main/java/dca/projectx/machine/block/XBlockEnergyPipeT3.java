package dca.projectx.machine.block;

import dca.projectx.machine.block.tile.TileEnergyPipeT3;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class XBlockEnergyPipeT3 extends XBlockEnergyPipe {

	public XBlockEnergyPipeT3(Material material, String blockName) {
		super(material, blockName);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEnergyPipeT3();
	}

}
