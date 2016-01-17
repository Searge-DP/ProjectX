package dca.projectx.lib.energy;

import java.util.ArrayList;
import dca.projectx.machine.block.XBlockPulseNodeBase;
import dca.projectx.machine.block.XBlockPulsePipe;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class PulseNetAnalyzer {
	
	private ArrayList<PulseDevice> cables;
	private ArrayList<PulseDevice> nodes;
	private ArrayList<PulseDevice> pulseSources;
	private ArrayList<PulseDevice> pulseDrains;
	
	public PulseNetAnalyzer(){
		cables = new ArrayList<PulseDevice>(){
			@Override
			public boolean contains(Object obj){
				PulseDevice cable = (PulseDevice)obj;
				for(PulseDevice entry : this){
					if(entry.x == cable.x && (entry.y == cable.y && (entry.z == cable.z && (entry.block == cable.block)))){
						return true;
					}
				}
				return false;
			}
		};
		
		nodes = new ArrayList<PulseDevice>(){
			@Override
			public boolean contains(Object obj){
				PulseDevice node = (PulseDevice)obj;
				for(PulseDevice entry : this){
					if(entry.x == node.x && (entry.y == node.y && (entry.z == node.z && (entry.block == node.block)))){
						return true;
					}
				}
				return false;
			}
		};
		
		pulseSources = new ArrayList<PulseDevice>(){
			@Override
			public boolean contains(Object obj){
				PulseDevice pulseSource = (PulseDevice)obj;
				for(PulseDevice entry : this){
					if(entry.x == pulseSource.x && (entry.y == pulseSource.y && (entry.z == pulseSource.z && (entry.block == pulseSource.block)))){
						return true;
					}
				}
				return false;
			}
		};
		
		pulseDrains = new ArrayList<PulseDevice>(){
			@Override
			public boolean contains(Object obj){
				PulseDevice pulseDrain = (PulseDevice)obj;
				for(PulseDevice entry : this){
					if(entry.x == pulseDrain.x && (entry.y == pulseDrain.y && (entry.z == pulseDrain.z && (entry.block == pulseDrain.block)))){
						return true;
					}
				}
				return false;
			}
		};
	}
	
	public void analyze(World world, int x, int y, int z, Block blockPrev, int direction){
		Block block = world.getBlock(x, y, z);
		
		if(!(block instanceof XBlockPulseNodeBase)){
			if(block instanceof XBlockPulsePipe){
				if(!cables.contains(new PulseDevice(x, y, z, block))){
					if(blockPrev == block || blockPrev instanceof XBlockPulseNodeBase){
						cables.add(new PulseDevice(x, y, z, block));
					}
					else
						return;
				}
				else
					return;
			}
			else
				return;
		}
	}

}
