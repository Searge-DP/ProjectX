package dca.projectx.machine.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerEngineeringTable extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
