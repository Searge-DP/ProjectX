package snowpaw.projectx.lib.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import snowpaw.projectx.machine.energy.PulseDevice;
import snowpaw.projectx.machine.energy.PulseNode;

import java.util.ArrayList;

public class XUtils {

    public static final int META_NOTIFY_NEIGHBOR = 1;
    public static final int META_NOTIFY_UPDATE = 2;
    public static final int META_NOTIFY_BOTH = 3;
    public static final int META_NOTIFY_NOTHING = 4;

    public static boolean checkChunk(World world, int x, int z) {
        return world.getChunkProvider().chunkExists(x >> 4, z >> 4);
    }

    public static void rotateBlock(int b0, int b1, boolean direction, int notify, World world, int x, int y, int z) {
        int rot = getMetaBitBiInt(b0, b1, world, x, y, z);
        if (direction) {
            rot++;
            if (rot > 3)
                rot = 0;
        }
        else {
            rot--;
            if (rot < 0)
                rot = 3;
        }
        setMetaBitBiInt(b0, b1, rot, notify, world, x, y, z);
    }

    public static void orientBlock(int b0, int b1, int b2, boolean direction, int notify, World world, int x, int y, int z) {
        int ori = getMetaBitTriInt(b0, b1, b2, world, x, y, z);
        if (direction) {
            ori++;
            if (ori > 5)
                ori = 0;
        }
        else {
            ori--;
            if (ori < 0)
                ori = 5;
        }
        setMetaBitTriInt(b0, b1, b2, ori, notify, world, x, y, z);
    }

    public static boolean getBit(int b0, int number) {
        return ((number >> b0) & 1) == 1;
    }

    public static boolean getMetaBit(int b0, World world, int x, int y, int z) {
        return getBit(b0, world.getBlockMetadata(x, y, z));
    }

    public static boolean getMetaBit(int b0, IBlockAccess world, int x, int y, int z) {
        return getBit(b0, world.getBlockMetadata(x, y, z));
    }

    public static int getBitBiInt(int b0, int b1, int number) {
        return (getBit(b0, number) ? 1 : 0) + (getBit(b1, number) ? 2 : 0);
    }

    public static int getMetaBitBiInt(int b0, int b1, World world, int x, int y, int z) {
        return getBitBiInt(b0, b1, world.getBlockMetadata(x, y, z));
    }

    public static int getMetaBitBiInt(int b0, int b1, IBlockAccess world, int x, int y, int z) {
        return getBitBiInt(b0, b1, world.getBlockMetadata(x, y, z));
    }

    public static int getBitTriInt(int b0, int b1, int b2, int number) {
        return (getBit(b0, number) ? 1 : 0) + (getBit(b1, number) ? 2 : 0) + (getBit(b2, number) ? 4 : 0);
    }

    public static int getMetaBitTriInt(int b0, int b1, int b2, World world, int x, int y, int z) {
        return getBitTriInt(b0, b1, b2, world.getBlockMetadata(x, y, z));
    }

    public static int getMetaBitTriInt(int b0, int b1, int b2, IBlockAccess world, int x, int y, int z) {
        return getBitTriInt(b0, b1, b2, world.getBlockMetadata(x, y, z));
    }

    public static int setBit(int b0, boolean value, int original) {
        if (getBit(b0, original) != value) {
            int mask = (1 << b0);
            return original^mask;
        }
        return original;
    }

    public static void setMetaBit(int b0, boolean value, int notify, World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, setBit(b0, value, world.getBlockMetadata(x, y, z)), notify);
    }

    public static int setBitBiInt(int b0, int b1, int value, int original) {
        original = setBit(b0, getBit(0, value), original);
        original = setBit(b1, getBit(1, value), original);
        return original;
    }

    public static void setMetaBitBiInt(int b0, int b1, int value, int notify, World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, setBitBiInt(b0, b1, value, world.getBlockMetadata(x, y, z)), notify);
    }

    public static int setBitTriInt(int b0, int b1, int b2, int value, int original) {
        original = setBit(b0, getBit(0, value), original);
        original = setBit(b1, getBit(1, value), original);
        original = setBit(b2, getBit(2, value), original);
        return original;
    }

    public static void setMetaBitTriInt(int b0, int b1, int b2, int value, int notify, World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, setBitTriInt(b0, b1, b2, value, world.getBlockMetadata(x, y, z)), notify);
    }

    public static void flipMetaBit(int b0, int notify, World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, y, z, setBit(b0, !getMetaBit(b0, world, x, y, z), world.getBlockMetadata(x, y, z)), notify);
    }

    private static byte[] intToBytes(int i) {
        return new byte[] {
            (byte) (i >> 24),
            (byte) (i >> 16),
            (byte) (i >> 8),
            (byte) i};
    }

    public static int[] intToMCInts(int i) {
        byte[] bytes = intToBytes(i);

        int[] mcInts = new int[] {
            (int) (bytes[0] << 8 | (bytes[1] & 0xFF)),
            (int) (bytes[2] << 8 | (bytes[3] & 0xFF))
        };

        return mcInts;
    }

    public static int joinMCIntsToInt(int[] mcInts) {
        return mcInts[0] << 16 | (mcInts[1] & 0xFFFF);
    }

    public static String formatFluids(int amount) {
        if (amount >= 1000 && amount < 1000000)
            return String.format("%.3f B", (float) amount / 1000);
        else if (amount >= 1000000 && amount < 1000000000)
            return String.format("%.3f KB", (float) amount / 1000000);
        else if (amount >= 1000000000)
            return String.format("%.3f MB", (float) amount / 1000000000);
        else
            return String.format("%d mB", amount);
    }

    public static void writePulseDevicesArrayToNBT(NBTTagCompound tagCompound, String name, ArrayList<PulseDevice> devices) {
        int devicesX[];
        int devicesY[];
        int devicesZ[];

        if (devices != null) {
            devicesX = new int[devices.size()];
            devicesY = new int[devices.size()];
            devicesZ = new int[devices.size()];
            int i = 0;
            for (PulseDevice entry : devices) {
                devicesX[i] = entry.x;
                devicesY[i] = entry.y;
                devicesZ[i] = entry.z;
                i++;
            }
        }
        else {
            devicesX = new int[0];
            devicesY = new int[0];
            devicesZ = new int[0];
        }
        tagCompound.setIntArray(name + "_x", devicesX);
        tagCompound.setIntArray(name + "_y", devicesY);
        tagCompound.setIntArray(name + "_z", devicesZ);
    }

    public static ArrayList<PulseDevice> readPulseDevicesArrayFromNBT(NBTTagCompound tagCompound, String name) {
        ArrayList<PulseDevice> devices = new ArrayList<PulseDevice>();
        int devicesX[];
        int devicesY[];
        int devicesZ[];

        devicesX = tagCompound.getIntArray(name + "_x");
        devicesY = tagCompound.getIntArray(name + "_y");
        devicesZ = tagCompound.getIntArray(name + "_z");
        for (int i = 0; i < devicesX.length; i++)
            devices.add(new PulseDevice(devicesX[i], devicesY[i], devicesZ[i], null));

        return devices;
    }

    public static void writePulseDeviceToNBT(NBTTagCompound tagCompound, String name, PulseDevice device) {
        if (device != null) {
            tagCompound.setInteger(name + "_x", device.x);
            tagCompound.setInteger(name + "_y", device.y);
            tagCompound.setInteger(name + "_z", device.z);
        }
        else {
            tagCompound.setInteger(name + "_x", 0);
            tagCompound.setInteger(name + "_y", 0);
            tagCompound.setInteger(name + "_z", 0);
        }
    }

    public static PulseDevice readPulseDeviceFromNBT(NBTTagCompound tagCompound, String name) {
        return new PulseDevice(
                tagCompound.getInteger(name + "_x"),
                tagCompound.getInteger(name + "_y"),
                tagCompound.getInteger(name + "_z"), null);
    }

    public static void writePulsePylonsArrayToNBT(NBTTagCompound tagCompound, String name, ArrayList<PulseNode> pylons) {
        int nodesX[];
        int nodesY[];
        int nodesZ[];
        int nodesMaster[];

        if (pylons != null) {
        	nodesX = new int[pylons.size()];
        	nodesY = new int[pylons.size()];
        	nodesZ = new int[pylons.size()];
        	nodesMaster = new int[pylons.size()];
            int i = 0;
            for (PulseNode entry : pylons) {
            	nodesX[i] = entry.x;
            	nodesY[i] = entry.y;
            	nodesZ[i] = entry.z;
            	nodesMaster[i] = entry.getMasterAsInt();
                i++;
            }
        }
        else {
        	nodesX = new int[0];
        	nodesY = new int[0];
        	nodesZ = new int[0];
        	nodesMaster = new int[0];
        }
        tagCompound.setIntArray(name + "_x", nodesX);
        tagCompound.setIntArray(name + "_y", nodesY);
        tagCompound.setIntArray(name + "_z", nodesZ);
        tagCompound.setIntArray(name + "_master", nodesMaster);
    }

    public static ArrayList<PulseNode> readPulsePylonsArrayFromNBT(NBTTagCompound tagCompound, String name) {
        ArrayList<PulseNode> pylons = new ArrayList<PulseNode>();
        int nodesX[];
        int nodesY[];
        int nodesZ[];
        int nodesMaster[];

        nodesX = tagCompound.getIntArray(name + "_x");
        nodesY = tagCompound.getIntArray(name + "_y");
        nodesZ = tagCompound.getIntArray(name + "_z");
        nodesMaster = tagCompound.getIntArray(name + "_master");
        for (int i = 0; i < nodesX.length; i++)
            pylons.add(new PulseNode(nodesX[i], nodesY[i], nodesZ[i], nodesMaster[i]));

        return pylons;
    }

    public static void writeInventoryToNBT(NBTTagCompound tagCompound, ItemStack[] inventory) {
        NBTTagList tagsItems = new NBTTagList();

        for (int i = 0; i < inventory.length; ++i) {
            if (inventory[i] != null) {
                NBTTagCompound tagCompound1 = new NBTTagCompound();
                tagCompound1.setByte("slot", (byte) i);
                inventory[i].writeToNBT(tagCompound1);
                tagsItems.appendTag(tagCompound1);
            }
        }
        tagCompound.setTag("items", tagsItems);
    }

    public static ItemStack[] readInventoryFromNBT(NBTTagCompound tagCompound, int invSize) {
        ItemStack inventory[] = new ItemStack[invSize];

        NBTTagList tagsItems = tagCompound.getTagList("items", 10);
        for (int i = 0; i < tagsItems.tagCount(); ++i) {
            NBTTagCompound tagCompound1 = tagsItems.getCompoundTagAt(i);
            byte byte0 = tagCompound1.getByte("slot");

            if (byte0 >= 0 && byte0 < inventory.length) {
                inventory[byte0] = ItemStack.loadItemStackFromNBT(tagCompound1);
            }
        }

        return inventory;
    }

    public static void addChatProbeTitle(EntityPlayer player) {
        player.addChatMessage(new ChatComponentTranslation(""));
        player.addChatMessage(new ChatComponentTranslation("msg.probeTitle.txt"));
    }

    public static void addChatProbeGenericInfo(EntityPlayer player, World world, int x, int y, int z) {
        player.addChatMessage(new ChatComponentTranslation("msg.probeName.txt", world.getBlock(x, y, z).getLocalizedName()));
        player.addChatMessage(new ChatComponentTranslation("msg.probeCoords.txt", x, y, z));
    }

    public static void addChatProbeConnectedMachines(EntityPlayer player, ArrayList<PulseDevice> machines, World world, int x, int y, int z) {
        if (machines != null && machines.size() != 0) {
            if (!(machines.size() == 1 && machines.get(0).x == x && machines.get(0).y == y && machines.get(0).z == z)) {
                for (PulseDevice entry : machines)
                    if (!(entry.x == x && entry.y == y && entry.z == z))
                        player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedEntry.txt", entry.x, entry.y, entry.z,
                                world.getBlock(entry.x, entry.y, entry.z).getLocalizedName()));
            }
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedNone.txt"));
        }
        else
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedNone.txt"));
    }

    public static void addChatProbeConnectedNodes(EntityPlayer player, ArrayList<PulseNode> nodes, World world, int x, int y, int z) {
        if (nodes != null && nodes.size() != 0) {
            if (!(nodes.size() == 1 && nodes.get(0).x == x && nodes.get(0).y == y && nodes.get(0).z == z)) {
                for (PulseNode entry : nodes)
                    if (!(entry.x == x && entry.y == y && entry.z == z))
                        player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedEntry.txt", entry.x, entry.y, entry.z,
                                world.getBlock(entry.x, entry.y, entry.z).getLocalizedName()));
            }
            else
                player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedNone.txt"));
        }
        else
            player.addChatMessage(new ChatComponentTranslation("msg.probeConnectedNone.txt"));
    }
    
}