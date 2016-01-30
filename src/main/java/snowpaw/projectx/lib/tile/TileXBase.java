package snowpaw.projectx.lib.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TileXBase extends TileEntity {
	
	public boolean canPlayerDismantle(EntityPlayer player){
		return true;
	}
	
	public void blockBroken() {
		
	}
	  
	public void blockDismantled() {
	    blockBroken();
	}

}
