package dca.projectx.machine.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.XTabs;
import dca.projectx.machine.block.tile.TilePulseRelayT1;
import dca.projectx.machine.block.tile.TilePulseRelayT3;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class XBlockPulseRelayT3 extends XBlockPulseRelay {

	public XBlockPulseRelayT3(Material material, String blockName) {
		super(material, blockName);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TilePulseRelayT3();
	}
	
}