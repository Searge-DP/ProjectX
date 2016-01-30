package snowpaw.projectx.machine.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.lib.tile.TileXBase;

public abstract class TileXMachineAdvanced extends TileXBase {
	
	public ForgeDirection getDirectonByID(int id){
		return ForgeDirection.getOrientation(id);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		this.readCustomNBT(compound, false);
	}
	
	public abstract void readCustomNBT(NBTTagCompound compount, boolean descPacket);
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		this.writeCustomNBT(compound, false);
	}
	
	public abstract void writeCustomNBT(NBTTagCompound compound, boolean descPacket);
	
	@Override
	public Packet getDescriptionPacket(){
		NBTTagCompound compound = new NBTTagCompound();
		this.writeCustomNBT(compound, true);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, compound);
	}
	
	
	
	@Override
	public void onDataPacket(NetworkManager networkMgr, S35PacketUpdateTileEntity packet){
		this.readCustomNBT(packet.func_148857_g(), true);
	}
	
	public void receiveMessageFromClient(NBTTagCompound message)
	{
		
	}

}
