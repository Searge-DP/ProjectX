package dca.projectx.machine.block;

import dca.projectx.core.XTabs;
import dca.projectx.machine.block.tile.TileCrystalInfuser;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class XBlockCrystalInfuser extends BlockContainer {

	public XBlockCrystalInfuser(Material material, String blockName) {
		super(material);
		this.setBlockName(blockName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundTypeMetal);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new TileCrystalInfuser();
	}

}
