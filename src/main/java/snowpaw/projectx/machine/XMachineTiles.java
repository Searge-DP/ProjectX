package snowpaw.projectx.machine;

import cpw.mods.fml.common.registry.GameRegistry;
import snowpaw.projectx.machine.tile.TileEngineeringTable;
import snowpaw.projectx.machine.tile.TilePulseNode;
import snowpaw.projectx.machine.tile.TileXTankValve;

public class XMachineTiles {
	
	public static final String ENGINEERING_TABLE = "projectx.engineeringTable";
	public static final String PULSE_NODE = "projectx.pulseNode";
	public static final String TANK_VALVE = "projectx.tankValve";
	
	public static void init(){
		GameRegistry.registerTileEntity(TileEngineeringTable.class, ENGINEERING_TABLE);
		GameRegistry.registerTileEntity(TilePulseNode.class, PULSE_NODE);
		GameRegistry.registerTileEntity(TileXTankValve.class, TANK_VALVE);
	}

}
