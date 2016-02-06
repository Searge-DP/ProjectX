package snowpaw.projectx.machine;

import cpw.mods.fml.common.registry.GameRegistry;
import snowpaw.projectx.machine.tile.TileEngineeringTable;
import snowpaw.projectx.machine.tile.TilePulseNode;
import snowpaw.projectx.machine.tile.TilePulsePipe;
import snowpaw.projectx.machine.tile.TileXFluidDetector;
import snowpaw.projectx.machine.tile.TileXPulseFurnace;
import snowpaw.projectx.machine.tile.TileXPulseGenerator;
import snowpaw.projectx.machine.tile.TileXTankFrame;
import snowpaw.projectx.machine.tile.TileXTankValve;

public class XMachineTiles {
	
	public static final String ENGINEERING_TABLE = "projectx.engineeringTable";
	public static final String PULSE_NODE = "projectx.pulseNode";
	public static final String TANK_VALVE = "projectx.tankValve";
	public static final String TANK_FRAME = "projectx.tankFrame";
	public static final String FLUID_DETECTOR = "projectx.fluidDetector";
	public static final String PULSE_GENERATOR = "projectx.pulseGenerator";
	public static final String PULSE_FURNACE = "projectx.pulseFurnace";
	public static final String PULSE_PIPE = "projectx.pulsePipe";
	
	public static void init(){
		GameRegistry.registerTileEntity(TileEngineeringTable.class, ENGINEERING_TABLE);
		GameRegistry.registerTileEntity(TilePulseNode.class, PULSE_NODE);
		GameRegistry.registerTileEntity(TileXTankValve.class, TANK_VALVE);
		GameRegistry.registerTileEntity(TileXTankFrame.class, TANK_FRAME);
		GameRegistry.registerTileEntity(TileXFluidDetector.class, FLUID_DETECTOR);
		GameRegistry.registerTileEntity(TileXPulseGenerator.class, PULSE_GENERATOR);
		GameRegistry.registerTileEntity(TileXPulseFurnace.class, PULSE_FURNACE);
		GameRegistry.registerTileEntity(TilePulsePipe.class, PULSE_PIPE);
	}

}
