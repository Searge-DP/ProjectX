package snowpaw.projectx.core.block;

import java.util.List;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;

public class BlockXBase extends BlockContainer {
	
	public String blockName;
	public String[] subNames;

	public BlockXBase(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(material);
		this.setBlockName(ProjectX.INSTANCE + "." + blockName);
		this.setBlockTextureName(ProjectX.INSTANCE + ":" + blockName);
		this.blockName = blockName;
		this.subNames = subNames;
	}
	
	@Override
	public int damageDropped(int meta){
		return meta;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for(int i=0; i<subNames.length; i++)
			list.add(new ItemStack(item, 1, i));
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return null;
	}

}
