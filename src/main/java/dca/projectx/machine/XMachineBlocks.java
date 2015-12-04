package dca.projectx.machine;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.machine.block.XBlockEngineeringTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class XMachineBlocks {
	
	public static Block engineeringTable;
	
	public static void preInit(){
		GameRegistry reg = null;
		reg.registerBlock(engineeringTable = (new XBlockEngineeringTable(Material.iron, "engineeringTable")), "engineeringTable");
	}

}
