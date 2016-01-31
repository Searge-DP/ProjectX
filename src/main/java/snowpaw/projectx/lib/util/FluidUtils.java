package snowpaw.projectx.lib.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.oredict.OreDictionary;
import snowpaw.projectx.lib.block.ExtendedBlock;
import snowpaw.projectx.lib.vec.Vector3i;
import snowpaw.projectx.machine.tile.TileXTankValve;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FluidUtils {

	public enum TankFrameMode {
        SAME_BLOCK,
        DIFFERENT_METADATA,
        DIFFERENT_BLOCK
    }
    public static TankFrameMode TANK_FRAME_MODE = TankFrameMode.SAME_BLOCK;

	
	
    private static List<Block> blacklistedBlocks;
    private static List<String> validTiles;
    private static List<ItemStack> glassList;

    public static void init() {
        glassList = OreDictionary.getOres("blockGlass");

        blacklistedBlocks = new ArrayList<Block>();

        blacklistedBlocks.add(Blocks.grass);
        blacklistedBlocks.add(Blocks.dirt);
        blacklistedBlocks.add(Blocks.bedrock);
        blacklistedBlocks.add(Blocks.redstone_lamp);
        blacklistedBlocks.add(Blocks.sponge);

        validTiles = new ArrayList<String>();

        validTiles.add("blockFusedQuartz");
    }

    public static String getUniqueValveName(TileXTankValve valve) {
        return "valve_" + Integer.toHexString(new Vector3i(valve.xCoord, valve.yCoord, valve.zCoord).hashCode());
    }

    public static boolean canAutoOutput(float height, int tankHeight, int valvePosition, boolean negativeDensity) {
        height *= tankHeight;

        if(negativeDensity)
            return false;

        return height > (valvePosition - 0.5f);
    }

    public static boolean isBlockGlass(Block block, int metadata) {
        if(block == null || block.getMaterial() == Material.air)
            return false;

        if(block instanceof BlockGlass)
            return true;

        ItemStack is = new ItemStack(block, 1, metadata);

        if(block.getMaterial() == Material.glass && !is.getUnlocalizedName().contains("pane"))
            return true;

        for(ItemStack is2 : glassList) {
            if(is2.getUnlocalizedName().equals(is.getUnlocalizedName()))
                return true;
        }
        return false;
    }

    public static boolean areTankBlocksValid(ExtendedBlock bottomBlock, ExtendedBlock topBlock, World world, Vector3i bottomPos) {
        if(!isValidTankBlock(world, bottomPos, bottomBlock))
            return false;

        switch(TANK_FRAME_MODE) {
            case SAME_BLOCK: return bottomBlock.equals(topBlock);
            case DIFFERENT_METADATA: return bottomBlock.equalsIgnoreMetadata(topBlock);
            case DIFFERENT_BLOCK: return true;

            default: return false;
        }
    }

    public static boolean isTileEntityAcceptable(Block block, TileEntity tile) {
        for(String name : validTiles) {
            if(block.getUnlocalizedName().toLowerCase().contains(name.toLowerCase()))
                return true;
        }

        return false;
    }

    public static boolean isValidTankBlock(World world, Vector3i pos, ExtendedBlock extendedBlock) {
        Block block = extendedBlock.getBlock();

        if (block.hasTileEntity(extendedBlock.getMetadata())) {
            TileEntity tile = world.getTileEntity(pos.getX(), pos.getY(), pos.getZ());
            if(tile != null) {
                return tile instanceof TileXTankValve || isTileEntityAcceptable(block, tile);
            }
        }

        try
        {
        	if(blacklistedBlocks.contains(extendedBlock))
                return false;
        }
        catch(NullPointerException npe)
        {
        	
        }

        if(block.getMaterial() == Material.sand)
            return false;

        if(!block.isOpaqueCube())
            return false;

        if(!block.renderAsNormalBlock())
            return false;

        if(TANK_FRAME_MODE == TankFrameMode.DIFFERENT_BLOCK)
            return true;

        if(!block.func_149730_j())
            return false;

        return true;

    }

    public static boolean canBlockLeak(Block block) {
        Material mat = block.getMaterial();
        return mat.equals(Material.grass) || mat.equals(Material.sponge) || mat.equals(Material.cloth) || mat.equals(Material.clay) || mat.equals(Material.gourd) || mat.equals(Material.sand);
    }

    public static boolean isFluidContainer(ItemStack playerItem) {
        if (playerItem == null)
            return false;

        return FluidContainerRegistry.isContainer(playerItem) || playerItem.getItem() instanceof IFluidContainerItem;

    }

    public static boolean fluidContainerHandler(World world, int x, int y, int z, TileXTankValve valve, EntityPlayer player) {
        ItemStack current = player.inventory.getCurrentItem();

        if (current != null) {
            if (FluidContainerRegistry.isContainer(current)) {
                FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(current);
                if (liquid != null) {
                    int qty = valve.fillFromContainer(ForgeDirection.UNKNOWN, liquid, true);

                    if (qty != 0 && !player.capabilities.isCreativeMode) {
                        if (current.stackSize > 1) {
                            if (!player.inventory.addItemStackToInventory(FluidContainerRegistry.drainFluidContainer(current))) {
                                player.dropPlayerItemWithRandomChoice(FluidContainerRegistry.drainFluidContainer(current), false);
                            }

                            player.inventory.setInventorySlotContents(player.inventory.currentItem, FluidUtils.consumeItem(current));
                        } else {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, FluidContainerRegistry.drainFluidContainer(current));
                        }
                    }

                    return true;

                } else {
                    FluidStack available = valve.getTankInfo(ForgeDirection.UNKNOWN)[0].fluid;

                    if (available != null) {
                        ItemStack filled = FluidContainerRegistry.fillFluidContainer(available, current);

                        liquid = FluidContainerRegistry.getFluidForFilledItem(filled);

                        if (liquid != null) {
                            if (!player.capabilities.isCreativeMode) {
                                if (current.stackSize > 1) {
                                    if (!player.inventory.addItemStackToInventory(filled)) {
                                        return false;
                                    } else {
                                        player.inventory.setInventorySlotContents(player.inventory.currentItem, FluidUtils.consumeItem(current));
                                    }
                                } else {
                                    player.inventory.setInventorySlotContents(player.inventory.currentItem, FluidUtils.consumeItem(current));
                                    player.inventory.setInventorySlotContents(player.inventory.currentItem, filled);
                                }
                            }

                            valve.drain(ForgeDirection.UNKNOWN, liquid.amount, true);

                            return true;
                        }
                    }
                }
            } else if (current.getItem() instanceof IFluidContainerItem) {
                if (current.stackSize != 1) {
                    return false;
                }

                if (!world.isRemote) {
                    IFluidContainerItem container = (IFluidContainerItem) current.getItem();
                    FluidStack liquid = container.getFluid(current);
                    FluidStack tankLiquid = valve.getTankInfo(ForgeDirection.UNKNOWN)[0].fluid;
                    boolean mustDrain = liquid == null || liquid.amount == 0;
                    boolean mustFill = tankLiquid == null || tankLiquid.amount == 0;
                    if (mustDrain && mustFill) {
                    } else if (mustDrain || !player.isSneaking()) {
                        liquid = valve.drain(ForgeDirection.UNKNOWN, 1000, false);
                        int qtyToFill = container.fill(current, liquid, true);
                        valve.drain(ForgeDirection.UNKNOWN, qtyToFill, true);
                    } else {
                        if (liquid.amount > 0) {
                            int qty = valve.fill(ForgeDirection.UNKNOWN, liquid, false);
                            valve.fill(ForgeDirection.UNKNOWN, container.drain(current, qty, true), true);
                        }
                    }
                }

                return true;
            }
            return false;
        }
        return false;
    }

    public static ItemStack consumeItem(ItemStack stack) {
        if (stack.stackSize == 1) {
            if (stack.getItem().hasContainerItem(stack)) {
                return stack.getItem().getContainerItem(stack);
            } else {
                return null;
            }
        } else {
            stack.splitStack(1);

            return stack;
        }
    }

    private static Map<Vector3i, ExtendedBlock> getBlocksBetweenPoints(World world, Vector3i pos1, Vector3i pos2) {
        Map<Vector3i, ExtendedBlock> blocks = new HashMap<Vector3i, ExtendedBlock>();

        Vector3i distance = pos2.getDistance(pos1);
        int dX, dY, dZ;
        dX = distance.getX();
        dY = distance.getY();
        dZ = distance.getZ();

        for(int x=0; x<=dX; x++)
            for(int y=0; y<=dY; y++)
                for(int z=0; z<=dZ; z++) {
                    Vector3i pos = new Vector3i(pos1.getX() + x, pos1.getY() + y, pos1.getZ() + z);
                    blocks.put(pos, new ExtendedBlock(world.getBlock(pos.getX(), pos.getY(), pos.getZ()), world.getBlockMetadata(pos.getX(), pos.getY(), pos.getZ())));
                }

        return blocks;
    }

    public static Map<Vector3i, ExtendedBlock>[] getTankFrame(World world, Vector3i bottomDiag, Vector3i topDiag) {
        Map<Vector3i, ExtendedBlock>[] maps = new HashMap[3];
        maps[0] = new HashMap<Vector3i, ExtendedBlock>(); 
        maps[1] = new HashMap<Vector3i, ExtendedBlock>(); 
        maps[2] = new HashMap<Vector3i, ExtendedBlock>();

        int x1 = bottomDiag.getX();
        int y1 = bottomDiag.getY();
        int z1 = bottomDiag.getZ();
        int x2 = topDiag.getX();
        int y2 = topDiag.getY();
        int z2 = topDiag.getZ();

        for(Map.Entry<Vector3i, ExtendedBlock> e : getBlocksBetweenPoints(world, new Vector3i(x1, y1, z1), new Vector3i(x2, y2, z2)).entrySet()) {
            Vector3i p = e.getKey();
            if(((p.getX() == x1 || p.getX() == x2) && (p.getY() == y1 || p.getY() == y2)) ||
                ((p.getX() == x1 || p.getX() == x2) && (p.getZ() == z1 || p.getZ() == z2)) ||
                ((p.getY() == y1 || p.getY() == y2) && (p.getZ() == z1 || p.getZ() == z2))) {

                    maps[0].put(p, e.getValue());
            }
            else if(((p.getX() == x1 || p.getX() == x2) || (p.getY() == y1 || p.getY() == y2) || (p.getZ() == z1 || p.getZ() == z2))) {
                maps[1].put(p, e.getValue());
            }
            else {
                maps[2].put(p, e.getValue());
            }
        }

        return maps;
    }

    public static String intToFancyNumber(int number) {
        return NumberFormat.getIntegerInstance().format(number);
    }

}