package snowpaw.projectx.machine.energy;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import snowpaw.projectx.machine.XMachineBlocks;
import snowpaw.projectx.machine.block.XBlockNodeBase;
import snowpaw.projectx.machine.block.XBlockPulsePipe;
import snowpaw.projectx.machine.tile.TilePulseNode;

public class PulseNetAnalyzer {
	
	public ArrayList<PulseDevice> cables;
	public ArrayList<PulseDevice> machines;
	public ArrayList<PulseDevice> nodes;
	
	public PulseNetAnalyzer(){
        cables = new ArrayList<PulseDevice>() {
            @Override
            public boolean contains(Object o) {
                PulseDevice cable = (PulseDevice) o;
                for (PulseDevice entry : this) {
                    if ((entry.x == cable.x) && (entry.y == cable.y) && (entry.z == cable.z) && (entry.block == cable.block)) {
                        return true;
                    }
                }
                return false;
            }
        };
        
        machines = new ArrayList<PulseDevice>() {
            @Override
            public boolean contains(Object o) {
                PulseDevice machine = (PulseDevice) o;
                for (PulseDevice entry : this) {
                    if ((entry.x == machine.x) && (entry.y == machine.y) && (entry.z == machine.z) && (entry.block == machine.block)) {
                        return true;
                    }
                }
                return false;
            }
        };
        
        nodes = new ArrayList<PulseDevice>() {
            @Override
            public boolean contains(Object o) {
                PulseDevice node = (PulseDevice) o;
                for (PulseDevice entry : this) {
                    if ((entry.x == node.x) && (entry.y == node.y) && (entry.z == node.z) && (entry.block == node.block)) {
                        return true;
                    }
                }
                return false;
            }
        };
	}
	
	public void analyze(World world, int x, int y, int z, Block blockPrev, int direction){
		Block block = world.getBlock(x, y, z);
		
		if(!(block instanceof XBlockNodeBase)){
			if(block instanceof XBlockPulsePipe){
				if(!cables.contains(new PulseDevice(x, y, z, block))){
					if(blockPrev == block || blockPrev instanceof XBlockNodeBase){
						cables.add(new PulseDevice(x, y, z, block));
					}
					else
						return;
				}
				else
					return;
			}
			else if(block == XMachineBlocks.pulseGenerator ||
					block == XMachineBlocks.pulseFurnace){
				if(!machines.contains(new PulseDevice(x, y, z, block))){
					int meta = world.getBlockMetadata(x, y, z);
					
                    if (meta >= 4 && meta < 8)
                        meta = meta - 4;
                    else if (meta >= 8)
                        meta = meta - 8;
                    
                    if ((meta == 0 && direction == 2) || (meta == 1 && direction == 5) || (meta == 2 && direction == 3) || (meta == 3 && direction == 4))
                        machines.add(new PulseDevice(x, y, z, block));
                    
                    return;
				}
				else
					return;
			}
			else
				return;
			
            if (direction != 1)
                analyze(world, x, y - 1, z, block, 0);
            if (direction != 0)
                analyze(world, x, y + 1, z, block, 1);
            if (direction != 3)
                analyze(world, x, y, z - 1, block, 2);
            if (direction != 2)
                analyze(world, x, y, z + 1, block, 3);
            if (direction != 5)
                analyze(world, x - 1, y, z, block, 4);
            if (direction != 4)
                analyze(world, x + 1, y, z, block, 5);
		}
		else
			//determineBase(world, x, y, z, block, direction);
			return;
	}
	
	/**
    public void pylonize(World world, int x, int y, int z, Block blockPrev, int direction) {
        Block block = world.getBlock(x, y, z);

        if (block == XMachineBlocks.energyNodeT1 ||
        	block == XMachineBlocks.energyNodeT2 ||
        	block == XMachineBlocks.energyNodeT3) {
        	
            int meta = world.getBlockMetadata(x, y, z);

            if (meta < 6) {
                if ((meta == direction) || direction == -1) {
                    if (!nodes.contains(new PulseDevice(x, y, z, block))) {
                        nodes.add(new PulseDevice(x, y, z, block));
                        
                        TilePulseNode node = (TilePulseNode) world.getTileEntity(x, y, z);

                        if (node != null) {
                            if (node.nodes != null)
                                for (PulseNode entry : node.nodes)
                                    if (world.getBlockMetadata(entry.x, entry.y, entry.z) < 6)
                                        if (!nodes.contains(new PulseDevice(entry.x, entry.y, entry.z, world.getBlock(entry.x, entry.y, entry.z))))
                                            pylonize(world, entry.x, entry.y, entry.z, block, -1);
                        } else
                            return;
                    } else
                        return;
                } else
                    return;
            }
            
            if (meta >= 6)
                meta = meta - 6;

            if (!(blockPrev instanceof XBlockNodeBase)) {
                if (meta == 1 &&
                        (world.getBlock(x, y - 1, z)) == XMachineBlocks.pulseNodeBase && world.getBlockMetadata(x, y - 1, z) == 1)
                    analyze(world, x, y - 1, z, block, -1);
                else if (meta == 0 &&
                        (world.getBlock(x, y + 1, z)) == XMachineBlocks.pulseNodeBase && world.getBlockMetadata(x, y + 1, z) == 0) 
                    analyze(world, x, y + 1, z, block, -1);
                else if (meta == 3 &&
                        (world.getBlock(x, y, z - 1)) == XMachineBlocks.pulseNodeBase && world.getBlockMetadata(x, y, z - 1) == 3) 
                    analyze(world, x, y, z - 1, block, -1);
                else if (meta == 2 &&
                        (world.getBlock(x, y, z + 1)) == XMachineBlocks.pulseNodeBase && world.getBlockMetadata(x, y, z + 1) == 2) 
                    analyze(world, x, y, z + 1, block, -1);
                else if (meta == 5 &&
                        (world.getBlock(x - 1, y, z)) == XMachineBlocks.pulseNodeBase && world.getBlockMetadata(x - 1, y, z) == 5) 
                    analyze(world, x - 1, y, z, block, -1);
                else if (meta == 4 &&
                        (world.getBlock(x + 1, y, z)) == XMachineBlocks.pulseNodeBase && world.getBlockMetadata(x + 1, y, z) == 4) 
                    analyze(world, x + 1, y, z, block, -1);
            }
        }
    }

	
    public void determineBase(World world, int x, int y, int z, Block block, int direction) {
        int meta = world.getBlockMetadata(x, y, z);
        if (block == XMachineBlocks.pulseNodeBase) {
            if ((meta == 0 && direction != 1) ||
                    (meta == 1 && direction != 0) ||
                    (meta == 2 && direction != 3) ||
                    (meta == 3 && direction != 2) ||
                    (meta == 4 && direction != 5) ||
                    (meta == 5 && direction != 4) ||
                    direction == -1) {
                if (!cables.contains(new PulseDevice(x, y, z, block))) {
                    cables.add(new PulseDevice(x, y, z, block));

                    if (meta == 0) {
                        pylonize(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else if (meta == 1) {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else if (meta == 2) {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else if (meta == 3) {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else if (meta == 4) {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        if (direction != 4)
                            analyze(world, x + 1, y, z, block, 5);
                    } else {
                        if (direction != 1)
                            analyze(world, x, y - 1, z, block, 0);
                        if (direction != 0)
                            analyze(world, x, y + 1, z, block, 1);
                        if (direction != 3)
                            analyze(world, x, y, z - 1, block, 2);
                        if (direction != 2)
                            analyze(world, x, y, z + 1, block, 3);
                        if (direction != 5)
                            analyze(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    }
                }
            }
        }
        
        else if (block == HexBlocks.blockPylonBase15) {
            // Check if orientation is correct.
            if ((meta == 0 && direction == 1) ||
                    (meta == 1 && direction == 0) ||
                    (meta == 2 && direction == 3) ||
                    (meta == 3 && direction == 2) ||
                    (meta == 4 && direction == 5) ||
                    (meta == 5 && direction == 4) ||
                    direction == -1) {
                // Check if the base is not already added (use cable list).
                if (!cables.contains(new HexDevice(x, y, z, block))) {
                    // Add the base.
                    cables.add(new HexDevice(x, y, z, block));

                    // Continue analysis.
                    if (meta == 0) {
                        if (direction == -1)
                            analyze(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else if (meta == 1) {
                        pylonize(world, x, y - 1, z, block, 0);
                        if (direction == -1)
                            analyze(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else if (meta == 2) {
                        pylonize(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        if (direction == -1)
                            analyze(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else if (meta == 3) {
                        pylonize(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        if (direction == -1)
                            analyze(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else if (meta == 4) {
                        pylonize(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        if (direction == -1)
                            analyze(world, x - 1, y, z, block, 4);
                        pylonize(world, x + 1, y, z, block, 5);
                    } else {
                        pylonize(world, x, y - 1, z, block, 0);
                        pylonize(world, x, y + 1, z, block, 1);
                        pylonize(world, x, y, z - 1, block, 2);
                        pylonize(world, x, y, z + 1, block, 3);
                        pylonize(world, x - 1, y, z, block, 4);
                        if (direction == -1)
                            analyze(world, x + 1, y, z, block, 5);
                    }
                }
            }
        }
    }
    */

}
