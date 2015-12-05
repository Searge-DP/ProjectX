package dca.projectx.machine;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.machine.block.XBlockEngineeringTable;
import dca.projectx.machine.block.XBlockXNodeT1;
import dca.projectx.machine.block.XBlockXNodeT2;
import dca.projectx.machine.block.XBlockXNodeT3;
import dca.projectx.machine.block.XBlockXRelayT1;
import dca.projectx.machine.block.XBlockXRelayT2;
import dca.projectx.machine.block.XBlockXRelayT3;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class XMachineBlocks {
	
	public static Block engineeringTable;
	public static Block energyNodeT1;
	public static Block energyNodeT2;
	public static Block energyNodeT3;
	public static Block energyRelayT1;
	public static Block energyRelayT2;
	public static Block energyRelayT3;
	
	public static void preInit(){
		GameRegistry reg = null;
		reg.registerBlock(engineeringTable = (new XBlockEngineeringTable(Material.iron, "engineeringTable")), "engineeringTable");
		reg.registerBlock(energyNodeT1 = (new XBlockXNodeT1(Material.iron, "energyNodeT1")), "energyNodeT1");
		reg.registerBlock(energyNodeT2 = (new XBlockXNodeT2(Material.iron, "energyNodeT2")), "energyNodeT2");
		reg.registerBlock(energyNodeT3 = (new XBlockXNodeT3(Material.iron, "energyNodeT3")), "energyNodeT3");
		reg.registerBlock(energyRelayT1 = (new XBlockXRelayT1(Material.iron, "energyRelayT1")), "energyRelayT1");
		reg.registerBlock(energyRelayT2 = (new XBlockXRelayT2(Material.iron, "energyRelayT2")), "energyRelayT2");
		reg.registerBlock(energyRelayT3 = (new XBlockXRelayT3(Material.iron, "energyRelayT3")), "energyRelayT3");
	}

}
