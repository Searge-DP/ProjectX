package dca.projectx.machine.block;

import java.util.ArrayList;
import cofh.api.block.IDismantleable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.XTabs;
import dca.projectx.core.block.XMachineBlockBase;
import dca.projectx.core.proxy.ClientProxy;
import dca.projectx.machine.XMachineBlocks;
import dca.projectx.machine.block.tile.TileEngineeringTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class XBlockEngineeringTable extends XMachineBlockBase {

	public XBlockEngineeringTable(Material material, String blockName) {
		super(material, blockName);
		this.setBlockName(blockName);
		this.setHardness(1.5F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.7F, 1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEngineeringTable();
	}

}
