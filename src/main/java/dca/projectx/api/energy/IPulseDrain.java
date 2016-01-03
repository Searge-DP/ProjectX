package dca.projectx.api.energy;

import java.util.ArrayList;
import dca.projectx.lib.energy.PulseDevice;
import net.minecraft.entity.player.EntityPlayer;

public interface IPulseDrain {
	
	void setSources(ArrayList<PulseDevice> energySources);
	
	void recheckSources();
	
	void displayInfoDrain(EntityPlayer player);

}
