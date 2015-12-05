package dca.projectx.machine;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.machine.item.XItemCircuit;
import dca.projectx.machine.item.XItemEnergyCore;
import net.minecraft.item.Item;

public class XMachineItems {
	
	public static Item energyCoreT1;
	public static Item energyCoreT2;
	public static Item energyCoreT3;
	public static Item circuit;
	
	public static void preInit(){
		GameRegistry reg = null;
		reg.registerItem(energyCoreT1 = (new XItemEnergyCore("energyCoreT1")), "energyCoreT1");
		reg.registerItem(energyCoreT2 = (new XItemEnergyCore("energyCoreT2")), "energyCoreT2");
		reg.registerItem(energyCoreT3 = (new XItemEnergyCore("energyCoreT3")), "energyCoreT3");
		//reg.registerItem(circuit = (new XItemCircuit("circuit", 16, "tier1", "tier2", "tier3")), "circuit");
	}

}
