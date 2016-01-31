package snowpaw.projectx.machine.network;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import snowpaw.projectx.machine.gui.GuiMultiTank;
import snowpaw.projectx.machine.tile.TileXTankFrame;
import snowpaw.projectx.machine.tile.TileXTankValve;

public class MachineGuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(tile == null){
			return null;
		}
		
		switch(ID){
		case 0: 
			if(tile instanceof TileXTankValve)
				return new GuiMultiTank((TileXTankValve)tile, false);
			else if(tile instanceof TileXTankFrame)
				return new GuiMultiTank(((TileXTankFrame)tile).getValve(), true);
		}
		
		return null;
	}

}
