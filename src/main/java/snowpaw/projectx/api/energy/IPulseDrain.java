package snowpaw.projectx.api.energy;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import snowpaw.projectx.machine.energy.PulseDevice;

public interface IPulseDrain {
	
	void setSources(ArrayList<PulseDevice> energySources);
	
	void recheckSources();
	
	void displayInfoDrain(EntityPlayer player);

}
