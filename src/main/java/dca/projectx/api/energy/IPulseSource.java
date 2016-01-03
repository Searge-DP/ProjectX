package dca.projectx.api.energy;

import java.util.ArrayList;
import dca.projectx.lib.energy.PulseDevice;
import net.minecraft.entity.player.EntityPlayer;

public interface IPulseSource {
	
	void setDrains(ArrayList<PulseDevice> energyDrains);
	
	boolean canDrainEnergy();
	
	float drainEnergy(float energy);
	
	float getEnergyPerTick();
	
	void displayInfoSource(EntityPlayer player);

}
