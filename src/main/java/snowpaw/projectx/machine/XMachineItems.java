package snowpaw.projectx.machine;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import snowpaw.projectx.machine.item.XItemEnergyCore;
import snowpaw.projectx.machine.item.XItemWrench;

public class XMachineItems {
	
	public static Item energyCoreT1;
	public static Item energyCoreT2;
	public static Item energyCoreT3;
	public static Item wrench;
	
	public static void preInit(){
		GameRegistry reg = null;
		reg.registerItem(energyCoreT1 = (new XItemEnergyCore("energyCoreT1")), "energyCoreT1");
		reg.registerItem(energyCoreT2 = (new XItemEnergyCore("energyCoreT2")), "energyCoreT2");
		reg.registerItem(energyCoreT3 = (new XItemEnergyCore("energyCoreT3")), "energyCoreT3");
		reg.registerItem(wrench = (new XItemWrench("wrench")), "wrench");
	}

}
