package dca.projectx.machine.item;

import java.util.List;
import cofh.api.block.IDismantleable;
import cofh.api.item.IToolHammer;
import cofh.lib.util.helpers.BlockHelper;
import cofh.lib.util.helpers.ServerHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.XTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class XItemWrench extends Item implements IToolHammer {
	
	public XItemWrench(String itemName){
		this.setCreativeTab(XTabs.tabProjectXMachines);
		this.setUnlocalizedName(itemName);
		this.setTextureName(ProjectX.INSTANCE + ":tool/" + itemName);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b){
		list.add("Acts like a " + EnumChatFormatting.GREEN + "OmniWrench");
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3){
	    return true;
	}
	
	public boolean onItemUseFirst(ItemStack paramItemStack, EntityPlayer paramEntityPlayer, World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3){
			  Block localBlock = paramWorld.getBlock(paramInt1, paramInt2, paramInt3);
			  if (localBlock == null) {
			    return false;
			  }
			  PlayerInteractEvent localPlayerInteractEvent = new PlayerInteractEvent(paramEntityPlayer, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, paramInt1, paramInt2, paramInt3, paramInt4, paramWorld);
			  if ((MinecraftForge.EVENT_BUS.post(localPlayerInteractEvent)) || (localPlayerInteractEvent.getResult() == PlayerInteractEvent.Result.DENY) || (localPlayerInteractEvent.useBlock == PlayerInteractEvent.Result.DENY) || (localPlayerInteractEvent.useItem == PlayerInteractEvent.Result.DENY)) {
			    return false;
			  }
			  if ((ServerHelper.isServerWorld(paramWorld)) && (paramEntityPlayer.isSneaking()) && ((localBlock instanceof IDismantleable)) && 
			    (((IDismantleable)localBlock).canDismantle(paramEntityPlayer, paramWorld, paramInt1, paramInt2, paramInt3)))
			  {
			    ((IDismantleable)localBlock).dismantleBlock(paramEntityPlayer, paramWorld, paramInt1, paramInt2, paramInt3, false);
			    return true;
			  }
			  if (BlockHelper.canRotate(localBlock))
			  {
			    if (paramEntityPlayer.isSneaking())
			    {
			      paramWorld.setBlockMetadataWithNotify(paramInt1, paramInt2, paramInt3, BlockHelper.rotateVanillaBlockAlt(paramWorld, localBlock, paramInt1, paramInt2, paramInt3), 3);
			      paramWorld.playSoundEffect(paramInt1 + 0.5D, paramInt2 + 0.5D, paramInt3 + 0.5D, localBlock.stepSound.getBreakSound(), 1.0F, 0.6F);
			    }
			    else
			    {
			      paramWorld.setBlockMetadataWithNotify(paramInt1, paramInt2, paramInt3, BlockHelper.rotateVanillaBlock(paramWorld, localBlock, paramInt1, paramInt2, paramInt3), 3);
			      paramWorld.playSoundEffect(paramInt1 + 0.5D, paramInt2 + 0.5D, paramInt3 + 0.5D, localBlock.stepSound.getBreakSound(), 1.0F, 0.8F);
			    }
			    return ServerHelper.isServerWorld(paramWorld);
			  }
			  if ((!paramEntityPlayer.isSneaking()) && (localBlock.rotateBlock(paramWorld, paramInt1, paramInt2, paramInt3, ForgeDirection.getOrientation(paramInt4))))
			  {
			    paramEntityPlayer.swingItem();
			    return ServerHelper.isServerWorld(paramWorld);
			  }
			  return false;
	}
	  
	public boolean canWrench(EntityPlayer paramEntityPlayer, int paramInt1, int paramInt2, int paramInt3){
	  return true;
	}

	@Override
	public boolean isUsable(ItemStack stack, EntityLivingBase entity, int x, int y, int z) {
		return true;
	}

	@Override
	public void toolUsed(ItemStack stack, EntityLivingBase entity, int x, int y, int z) {
		
	}

}
