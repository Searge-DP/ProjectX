package dca.projectx.machine.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.XTabs;
import dca.projectx.machine.block.tile.TileXRelayT1;
import dca.projectx.machine.block.tile.TileXRelayT2;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class XBlockXRelayT2 extends BlockContainer {
	
	public XBlockXRelayT2(Material material, String blockName) {
		super(material);
		this.setBlockName(blockName);
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setHardness(1.5F);
		this.setStepSound(Block.soundTypeMetal);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileXRelayT2();
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
