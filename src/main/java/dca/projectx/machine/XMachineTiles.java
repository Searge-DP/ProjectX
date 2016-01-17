package dca.projectx.machine;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.machine.block.tile.TileEngineeringTable;
import dca.projectx.machine.block.tile.TilePulseNode;

public class XMachineTiles {
	
	public static void init(){
		GameRegistry.registerTileEntity(TileEngineeringTable.class, "engineeringTable");
		GameRegistry.registerTileEntity(TilePulseNode.class, "pulseNode");
	}

}
