package snowpaw.projectx.lib.render;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;

public interface IOverlayText {
	
	public String[] getOverlayText(EntityPlayer player, MovingObjectPosition mop, boolean hammer);
	public boolean useNixieFont(EntityPlayer player, MovingObjectPosition mop);

}
