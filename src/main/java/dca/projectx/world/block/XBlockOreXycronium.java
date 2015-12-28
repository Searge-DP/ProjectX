package dca.projectx.world.block;

import java.util.ArrayList;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.block.XBlockBase;
import dca.projectx.world.XWorldBlocks;
import dca.projectx.world.XWorldItems;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneOre;

public class XBlockOreXycronium extends XBlockBase {

	public XBlockOreXycronium(Material material, String blockName) {
		super(material, blockName);
		this.setHardness(2.0F);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[2];
        icon[0] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "ore");
        icon[1] = iconRegister.registerIcon(ProjectX.INSTANCE + ":" + "oreGlow");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side < 6)
            return icon[0];
        else
            return icon[1];
    }
    
    @Override
    public Item getItemDropped(int i, Random rand, int j){
    	return XWorldItems.gem;
    }
    
    @Override
    public int damageDropped(int meta){
    	if(this==XWorldBlocks.oreBlue){
    		return 0;
    	}
    	if(this==XWorldBlocks.oreGreen){
    		return 1;
    	}
    	if(this==XWorldBlocks.oreRed){
    		return 2;
    	}
    	if(this==XWorldBlocks.oreDark){
    		return 3;
    	}
    	if(this==XWorldBlocks.oreLight){
    		return 4;
    	}
    	return meta;
    }
    
    @Override
    public int quantityDropped(Random rand){
    	return 4;
    }
}
