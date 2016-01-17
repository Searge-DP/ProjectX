package dca.projectx.machine.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import dca.projectx.machine.block.tile.TileEngineeringTable;
import dca.projectx.machine.container.ContainerEngineeringTable;
import dca.projectx.machine.gui.GuiEngineeringTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MachineGuiHandler implements IGuiHandler {
	
	public static final int GUI_ID_ENGINEERING_TABLE = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GUI_ID_ENGINEERING_TABLE){
			return new ContainerEngineeringTable();
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GUI_ID_ENGINEERING_TABLE){
			TileEngineeringTable tile = (TileEngineeringTable)world.getTileEntity(x, y, z);
			return new GuiEngineeringTable(player.inventory, tile);
		}
		
		return null;
	}

}
