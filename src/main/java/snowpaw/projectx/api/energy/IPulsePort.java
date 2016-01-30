package snowpaw.projectx.api.energy;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import snowpaw.projectx.machine.energy.PulseDevice;

public interface IPulsePort {
	
	void setPorts(ArrayList<PulseDevice> energyPorts);
	
	void setPortTier(int tier);
	
	int getPortTier();
	
	int getPortType();
	
	boolean checkPortConnectivity(int x, int y, int z);
	
	boolean checkPortLinked(int x, int y, int z);
	
	boolean linkPort(int x, int y, int z);
	
	void breakPortLink();
	
	void unlinkPort();
	
	void emptyBuffer();
	
	float getMultiplier(int type, int tier);
	
	float drainPortEnergy(float energy);
	
	void displayInfoPort(EntityPlayer player);

}
