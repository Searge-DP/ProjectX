package snowpaw.projectx.machine.network;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import snowpaw.projectx.machine.container.ContainerPulseFurnace;
import snowpaw.projectx.machine.container.ContainerPulseGenerator;
import snowpaw.projectx.machine.gui.GuiMultiTank;
import snowpaw.projectx.machine.gui.GuiPulseFurnace;
import snowpaw.projectx.machine.gui.GuiPulseGenerator;
import snowpaw.projectx.machine.tile.TileXPulseFurnace;
import snowpaw.projectx.machine.tile.TileXPulseGenerator;
import snowpaw.projectx.machine.tile.TileXTankFrame;
import snowpaw.projectx.machine.tile.TileXTankValve;

public class MachineGuiHandler implements IGuiHandler {
	
	public enum EnumGuiID{
		TANK_VALVE,
		PULSE_GENERATOR,
		PULSE_FURNACE
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(tile == null){
			return null;
		}
		
		if(ID == EnumGuiID.TANK_VALVE.ordinal()){
			return null;
		}
		else if(ID == EnumGuiID.PULSE_GENERATOR.ordinal()){
			if(tile instanceof TileXPulseGenerator)
				return new ContainerPulseGenerator(player.inventory, (TileXPulseGenerator)tile);
		}
		else if(ID == EnumGuiID.PULSE_FURNACE.ordinal()){
			if(tile instanceof TileXPulseFurnace)
				return new ContainerPulseFurnace(player.inventory, (TileXPulseFurnace)tile);
		}
		else return null;
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(tile == null){
			return null;
		}
		
		if(ID == EnumGuiID.TANK_VALVE.ordinal()){
			if(tile instanceof TileXTankValve)
				return new GuiMultiTank((TileXTankValve)tile, false);
			else if(tile instanceof TileXTankFrame)
				return new GuiMultiTank(((TileXTankFrame)tile).getValve(), true);
		}
		else if(ID == EnumGuiID.PULSE_GENERATOR.ordinal()){
			if(tile instanceof TileXPulseGenerator)
				return new GuiPulseGenerator(player.inventory, (TileXPulseGenerator)tile);
		}
		else if(ID == EnumGuiID.PULSE_FURNACE.ordinal()){
			if(tile instanceof TileXPulseFurnace)
				return new GuiPulseFurnace(player.inventory, (TileXPulseFurnace)tile);
		}
		else
			return null;
		
		return null;
	}

}
