package snowpaw.projectx.machine;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.machine.block.BlockXFluidDetector;
import snowpaw.projectx.machine.block.BlockXTankFrame;
import snowpaw.projectx.machine.block.BlockXTankValve;
import snowpaw.projectx.machine.block.XBlockEngineeringTable;
import snowpaw.projectx.machine.block.XBlockPulseNodeT1;
import snowpaw.projectx.machine.block.XBlockPulseNodeT2;
import snowpaw.projectx.machine.block.XBlockPulseNodeT3;
import snowpaw.projectx.machine.block.XBlockPulsePipe;
import snowpaw.projectx.machine.block.XBlockPulsePipeT1;
import snowpaw.projectx.machine.block.XBlockPulsePipeT2;
import snowpaw.projectx.machine.block.XBlockPulsePipeT3;

public class XMachineBlocks {
	
	public static Block eBrickBlue;
	public static Block eBrickGreen;
	public static Block eBrickRed;
	public static Block eBrickDark;
	public static Block eBrickLight;
	public static Block xycroniumWater;
	public static Block xycroniumSoil;
	public static Block xycroniumFire;
	public static Block xycroniumVoid;
	public static Block xycroniumIce;
	public static Block engineeringTable;
	public static Block energyNodeT1;
	public static Block energyNodeT2;
	public static Block energyNodeT3;
	public static Block energyPipeT1;
	public static Block energyPipeT2;
	public static Block energyPipeT3;
	
	public static Block tankValve;
	public static Block tankFrame;
	public static Block fluidDetector;
	
	public static void preInit(){
		GameRegistry reg = null;
		/**
		reg.registerBlock(eBrickBlue = (new XBlockEngineeringBrick(Material.rock, "eBrickBlue")), "eBrickBlue");
		reg.registerBlock(eBrickGreen = (new XBlockEngineeringBrick(Material.rock, "eBrickGreen")), "eBrickGreen");
		reg.registerBlock(eBrickRed = (new XBlockEngineeringBrick(Material.rock, "eBrickRed")), "eBrickRed");
		reg.registerBlock(eBrickDark = (new XBlockEngineeringBrick(Material.rock, "eBrickDark")), "eBrickDark");
		reg.registerBlock(eBrickLight = (new XBlockEngineeringBrick(Material.rock, "eBrickLight")), "eBrickLight");
		reg.registerBlock(xycroniumWater = (new XBlockXWater(Material.water, "xycroniumWater")), "xycroniumWater");
		reg.registerBlock(xycroniumSoil = (new XBlockXSoil(Material.iron, "xycroniumSoil")), "xycroniumSoil");
		reg.registerBlock(xycroniumFire = (new XBlockXFire(Material.iron, "xycroniumFire")), "xycroniumFire");
		reg.registerBlock(xycroniumVoid = (new XBlockXVoid(Material.iron, "xycroniumVoid")), "xycroniumVoid");
		reg.registerBlock(xycroniumIce = (new XBlockXIce(Material.iron, "xycroniumIce")), "xycroniumIce");
		*/
		
		tankValve = new BlockXTankValve("tankValve", Material.iron, ItemBlockXBase.class);
		tankFrame = new BlockXTankFrame("tankFrame", Material.iron, ItemBlockXBase.class);
		fluidDetector = new BlockXFluidDetector("fluidDetector", Material.iron, ItemBlockXBase.class);
		
		reg.registerBlock(engineeringTable = (new XBlockEngineeringTable(Material.iron, "engineeringTable")), "engineeringTable");
		reg.registerBlock(energyNodeT1 = (new XBlockPulseNodeT1(Material.iron, "energyNodeT1")), "energyNodeT1");
		reg.registerBlock(energyNodeT2 = (new XBlockPulseNodeT2(Material.iron, "energyNodeT2")), "energyNodeT2");
		reg.registerBlock(energyNodeT3 = (new XBlockPulseNodeT3(Material.iron, "energyNodeT3")), "energyNodeT3");
		reg.registerBlock(energyPipeT1 = (new XBlockPulsePipeT1(Material.iron, "energyPipeT1")), "energyPipeT1");
		reg.registerBlock(energyPipeT2 = (new XBlockPulsePipeT2(Material.iron, "energyPipeT2")), "energyPipeT2");
		reg.registerBlock(energyPipeT3 = (new XBlockPulsePipeT3(Material.iron, "energyPipeT3")), "energyPipeT3");
	}

}
