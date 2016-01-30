package snowpaw.projectx.api.energy;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import snowpaw.projectx.machine.energy.PulseDevice;

public interface IPulseSource {
	
	void setDrains(ArrayList<PulseDevice> energyDrains);
	
	boolean canDrainEnergy();
	
	float drainEnergy(float energy);
	
	float getEnergyPerTick();
	
	void displayInfoSource(EntityPlayer player);

}
