package dca.projectx.machine.block.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEnergyPipe extends TileEntity {
	
	/**
	 * UP, DOWN, NORTH, EAST, SOUTH, WEST
	 */
	public ForgeDirection[] connections = new ForgeDirection[6];
	
	public TileEnergyPipe(){
		
	}
	
	@Override
	public void updateEntity(){
		updateConnections();
	}
	
	public void updateConnections(){
		if(isPipe(xCoord, yCoord+1, zCoord)||(isGenerator(xCoord, yCoord+1, zCoord))||(isRelay(xCoord, yCoord+1, zCoord))) connections[0] = ForgeDirection.UP;
		else connections[0] = null;
		if(isPipe(xCoord, yCoord-1, zCoord)||(isGenerator(xCoord, yCoord-1, zCoord))) connections[1] = ForgeDirection.DOWN;
		else connections[1] = null;
		if(isPipe(xCoord, yCoord, zCoord-1)) connections[2] = ForgeDirection.NORTH;
		else connections[2] = null;
		if(isPipe(xCoord+1, yCoord, zCoord)||(isGenerator(xCoord+1, yCoord, zCoord))) connections[3] = ForgeDirection.EAST;
		else connections[3] = null;
		if(isPipe(xCoord, yCoord, zCoord+1)||(isGenerator(xCoord, yCoord, zCoord+1))) connections[4] = ForgeDirection.SOUTH;
		else connections[4] = null;
		if(isPipe(xCoord-1, yCoord, zCoord)||(isGenerator(xCoord-1, yCoord, zCoord))) connections[5] = ForgeDirection.WEST;
		else connections[5] = null;
	}
	
	public boolean isPipe(int x, int y, int z){
		return this.worldObj.getTileEntity(x, y, z) instanceof TileEnergyPipe;
	}
	
	public boolean isGenerator(int x, int y, int z){
		return this.worldObj.getTileEntity(x, y, z) instanceof TileGenerator;
	}
	
	public boolean isRelay(int x, int y, int z){
		return this.worldObj.getTileEntity(x, y, z) instanceof TileXRelayT1||(this.worldObj.getTileEntity(x, y, z) instanceof TileXRelayT2||(this.worldObj.getTileEntity(x, y, z) instanceof TileXRelayT3));
	}
	
	public boolean onlyOneOpposite(ForgeDirection[] directions){
		ForgeDirection mainDirection = null;
		boolean isOpposite = false;
		
		for(int i = 0; i < directions.length; i++){
			if(mainDirection == null && directions[i] != null){
				mainDirection = directions[i];
			}
			
			if(directions[i] != null && mainDirection != directions[i]){
				if(!isOpposite(mainDirection, directions[i])) return false;
				else isOpposite = true;
			}
		}
		
		return isOpposite;
	}
	
	public boolean isOpposite(ForgeDirection firstDirection, ForgeDirection secondDirection){
		if(firstDirection.equals(ForgeDirection.NORTH) && secondDirection.equals(ForgeDirection.SOUTH)||(firstDirection.equals(ForgeDirection.SOUTH) && secondDirection.equals(ForgeDirection.NORTH))) return true;
		if(firstDirection.equals(ForgeDirection.EAST) && secondDirection.equals(ForgeDirection.WEST)||(firstDirection.equals(ForgeDirection.EAST) && secondDirection.equals(ForgeDirection.EAST))) return true;
		if(firstDirection.equals(ForgeDirection.UP) && secondDirection.equals(ForgeDirection.DOWN)||(firstDirection.equals(ForgeDirection.DOWN) && secondDirection.equals(ForgeDirection.UP))) return true;
		
		return false;
	}

}
