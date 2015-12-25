package dca.projectx.machine.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.XTabs;
import dca.projectx.machine.block.tile.TileEnergyPipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class XBlockEnergyPipe extends BlockContainer {

	public XBlockEnergyPipe(Material material, String blockName) {
		super(material);
		float pixel = 1F/16F;
		this.setBlockName(blockName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockBounds(11*pixel/2, 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
		TileEnergyPipe pipe = (TileEnergyPipe)world.getTileEntity(x, y, z);
		
		if(pipe != null){
			float pixel = 1F/16F;
			float minX = 11*pixel/2-(pipe.connections[5]!=null?(11*pixel/2):0);
			float maxX = 1-11*pixel/2+(pipe.connections[3]!=null?(11*pixel/2):0);
			float minY = 11*pixel/2-(pipe.connections[1]!=null?(11*pixel/2):0);
			float maxY = 1-11*pixel/2+(pipe.connections[0]!=null?(11*pixel/2):0);
			float minZ = 11*pixel/2-(pipe.connections[2]!=null?(11*pixel/2):0);
			float maxZ = 1-11*pixel/2+(pipe.connections[4]!=null?(11*pixel/2):0);
			
			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
		
		return AxisAlignedBB.getBoundingBox(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		TileEnergyPipe pipe = (TileEnergyPipe)world.getTileEntity(x, y, z);
		
		if(pipe != null){
			float pixel = 1F/16F;
			float minX = 11*pixel/2-(pipe.connections[5]!=null?(11*pixel/2):0);
			float maxX = 1-11*pixel/2+(pipe.connections[3]!=null?(11*pixel/2):0);
			float minY = 11*pixel/2-(pipe.connections[1]!=null?(11*pixel/2):0);
			float maxY = 1-11*pixel/2+(pipe.connections[0]!=null?(11*pixel/2):0);
			float minZ = 11*pixel/2-(pipe.connections[2]!=null?(11*pixel/2):0);
			float maxZ = 1-11*pixel/2+(pipe.connections[4]!=null?(11*pixel/2):0);
			
			this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
		
		return AxisAlignedBB.getBoundingBox(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return -1;
    }

}
