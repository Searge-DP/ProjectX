package dca.projectx.machine.block.tile;

import dca.projectx.core.block.tile.TileMachineBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilePulseNode extends TileEntity {
	
	public int meta;
	
	@Override
	public void updateEntity(){
		this.meta = this.getBlockMetadata();
	}
	
	public int getRotationData(){
		return this.meta;
	}

}
