package snowpaw.projectx.machine.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import snowpaw.projectx.lib.tile.TileXBase;

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
