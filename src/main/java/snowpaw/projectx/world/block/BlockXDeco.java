package snowpaw.projectx.world.block;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.lib.helper.BlockColorHelper;
import snowpaw.projectx.world.XWorldBlocks;

public class BlockXDeco extends BlockXGlow {

	public BlockXDeco(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setCreativeTab(XTabs.tabProjectX);
		this.setHardness(1.3F);
		adjustSound();
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public ColourRGBA setBlockColor(int meta){
    	if(this == XWorldBlocks.xycroniumStorage){
    		return BlockColorHelper.setColor5(meta);
    	}
    	else if(this == XWorldBlocks.xycroniumBrick){
    		return BlockColorHelper.setColor5(meta);
    	}
    	else if(this == XWorldBlocks.xycroniumBrickSmall){
    		return BlockColorHelper.setColor5(meta);
    	}
    	else if(this == XWorldBlocks.xycroniumStructure){
    		return BlockColorHelper.setColor16(meta);
    	}
    	else if(this == XWorldBlocks.xycroniumPlatform){
    		return BlockColorHelper.setColor16(meta);
    	}
    	else if(this == XWorldBlocks.xycroniumShield){
    		return BlockColorHelper.setColor16(meta);
    	}
    	else
    		return null;
    }
    
	public void adjustSound()
	{
		if(this.blockMaterial==Material.anvil)
			this.stepSound = Block.soundTypeAnvil;
		else if(this.blockMaterial==Material.carpet||this.blockMaterial==Material.cloth)
			this.stepSound = Block.soundTypeCloth;
		else if(this.blockMaterial==Material.glass||this.blockMaterial==Material.ice)
			this.stepSound = Block.soundTypeGlass;
		else if(this.blockMaterial==Material.grass||this.blockMaterial==Material.tnt||this.blockMaterial==Material.plants||this.blockMaterial==Material.vine)
			this.stepSound = Block.soundTypeGrass;
		else if(this.blockMaterial==Material.ground)
			this.stepSound = Block.soundTypeGravel;
		else if(this.blockMaterial==Material.iron)
			this.stepSound = Block.soundTypeMetal;
		else if(this.blockMaterial==Material.sand)
			this.stepSound = Block.soundTypeSand;
		else if(this.blockMaterial==Material.snow)
			this.stepSound = Block.soundTypeSnow;
		else if(this.blockMaterial==Material.rock)
			this.stepSound = Block.soundTypeStone;
		else if(this.blockMaterial==Material.wood||this.blockMaterial==Material.cactus)
			this.stepSound = Block.soundTypeWood;
	}

}
