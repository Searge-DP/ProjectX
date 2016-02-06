package snowpaw.projectx.machine.block;

import java.util.Random;

import codechicken.lib.colour.ColourRGBA;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.core.XTabs;
import snowpaw.projectx.core.block.BlockXGlow;
import snowpaw.projectx.core.block.ItemBlockXBase;
import snowpaw.projectx.core.render.RenderTickHandler;
import snowpaw.projectx.machine.XMachineItems;
import snowpaw.projectx.machine.network.MachineGuiHandler.EnumGuiID;
import snowpaw.projectx.machine.tile.TileXPulseGenerator;

public class BlockXPulseGenerator extends BlockXGlow {
	
	private Random random = new Random();

	public BlockXPulseGenerator(String blockName, Material material, Class<? extends ItemBlockXBase> itemBlock, String... subNames) {
		super(blockName, material, itemBlock, subNames);
		this.setCreativeTab(XTabs.tabProjectXMachines);
	}
	
	@Override
	public ColourRGBA setBlockColor(int meta){
		return new ColourRGBA(RenderTickHandler.getRedD(), RenderTickHandler.getGreenD(), RenderTickHandler.getBlueD(), 1D);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new TileXPulseGenerator();
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        ItemStack itemStack = player.getCurrentEquippedItem();
        if (itemStack != null) {
            if (itemStack.getItem() != XMachineItems.wrench)
                player.openGui("ProjectXMachines", EnumGuiID.PULSE_GENERATOR.ordinal(), world, x, y, z);
        }
        else
            player.openGui("ProjectXMachines", EnumGuiID.PULSE_GENERATOR.ordinal(), world, x, y, z);
        return true;
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileXPulseGenerator tileEntity = (TileXPulseGenerator) world.getTileEntity(x, y, z);

        if (tileEntity != null) {

            for (int i = 0; i < tileEntity.getSizeInventory(); ++i) {
                ItemStack itemstack = tileEntity.getStackInSlot(i);

                if (itemstack != null) {
                    float f = random.nextFloat() * 0.6F + 0.1F;
                    float f1 = random.nextFloat() * 0.6F + 0.1F;
                    float f2 = random.nextFloat() * 0.6F + 0.1F;

                    while (itemstack.stackSize > 0) {
                        int j = random.nextInt(21) + 10;

                        if (j > itemstack.stackSize) {
                            j = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j;
                        EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound()) {
                            entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
                        }

                        float f3 = 0.025F;
                        entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
                        entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
                        world.spawnEntityInWorld(entityitem);
                    }
                }
            }
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, meta);
    }
    
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        if (block == this && meta >= 4 && meta < 8)
            return 12;
        else
            return 0;
    }
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (block instanceof XBlockPulsePipe ||
                block instanceof XBlockNodeBase) {

            int meta = world.getBlockMetadata(x, y, z);

            //NetworkAnalyzer analyzer = new NetworkAnalyzer();
            //analyzer.analyzeMachine(world, x, y, z, meta);
        }
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction + 8, 2);

        if(!world.isRemote) {
            //NetworkAnalyzer analyzer = new NetworkAnalyzer();
            //analyzer.analyzeMachine(world, x, y, z, direction);
        }
    }
    
    @SideOnly(Side.CLIENT)
    private IIcon icon[];
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new IIcon[4];
        icon[0] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "machine_side");
        icon[1] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "machine_bottom");
        icon[2] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "generator_off");
        icon[3] = iconRegister.registerIcon(ProjectX.INSTANCE + ":machine/" + "generator_on");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
    	return icon[3];
    }

}
