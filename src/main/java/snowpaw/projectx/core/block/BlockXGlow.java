package snowpaw.projectx.core.block;

import java.util.List;
import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.proxy.ClientProxy;
import snowpaw.projectx.lib.helper.BlockColorHelper;
import snowpaw.projectx.world.proxy.WClientProxy;

public class BlockXGlow extends BlockXBase {
	
	public IIcon animationIcon = ClientProxy.animationFX.texture;

	public BlockXGlow(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		GameRegistry.registerBlock(this, itemBlock, blockName);
	}
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return ClientProxy.glowRenderId;
    }
	
    @SideOnly(Side.CLIENT)
	public IIcon getAnimationIcon(){
		return this.animationIcon;
	}
    
    @SideOnly(Side.CLIENT)
    public ColourRGBA setBlockColor(int meta){
    	return null;
    }

}
