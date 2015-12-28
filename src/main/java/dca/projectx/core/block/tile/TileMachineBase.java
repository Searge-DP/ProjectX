package dca.projectx.core.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class TileMachineBase extends TileEntity {
	
	public boolean canPlayerDismantle(EntityPlayer player){
		return true;
	}
	
	public void blockBroken() {
		
	}
	  
	public void blockDismantled() {
	    blockBroken();
	}

}
