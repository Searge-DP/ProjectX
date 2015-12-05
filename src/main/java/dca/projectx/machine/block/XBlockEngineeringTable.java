package dca.projectx.machine.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.XTabs;
import dca.projectx.core.proxy.ClientProxy;
import dca.projectx.machine.block.tile.TileEngineeringTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class XBlockEngineeringTable extends BlockContainer {

	public XBlockEngineeringTable(Material material, String blockName) {
		super(material);
		this.setBlockName(blockName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setStepSound(Block.soundTypeMetal);
		this.setHardness(1.5F);
		this.setBlockTextureName("minecraft:iron_block");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEngineeringTable();
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
