package dca.projectx.lib.energy;

import net.minecraft.block.Block;

public class PulseDevice {
	
	public int x;
	public int y;
	public int z;
	public Block block;
	
	public PulseDevice(int x, int y, int z, Block block){
		this.x = x;
		this.y = y;
		this.z = z;
		this.block = block;
	}

}
