package dca.projectx.core.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dca.projectx.core.ProjectX;
import dca.projectx.core.XTabs;
import dca.projectx.core.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class XBlockBase extends BlockContainer {
	
    public int idBlock;

	protected XBlockBase(Material material, String blockName) {
		super(material);
		this.setBlockName(blockName);
		this.setCreativeTab(XTabs.tabProjectX);
		adjustSound();
		this.idBlock = ProjectX.idCounter;
		ProjectX.idCounter++;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return null;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return ClientProxy.renderID[idBlock];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInPass(int pass) {
        ClientProxy.renderPass[idBlock] = pass;
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
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
