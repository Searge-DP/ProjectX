package snowpaw.projectx.machine.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.machine.tile.TilePulseNodeT1;
import snowpaw.projectx.machine.tile.TilePulseNodeT3;

public class XBlockPulseNodeT3 extends XBlockPulseNode {

	public XBlockPulseNodeT3(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(1.5F);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TilePulseNodeT3();
	}
    
}
