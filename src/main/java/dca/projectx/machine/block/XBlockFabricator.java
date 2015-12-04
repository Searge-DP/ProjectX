package dca.projectx.machine.block;

import dca.projectx.core.block.XBlockBase;
import dca.projectx.machine.block.tile.TileFabricator;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class XBlockFabricator extends XBlockBase {

	public XBlockFabricator(Material material, String blockName) {
		super(material, blockName);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileFabricator();
	}

}
