package snowpaw.projectx.machine.tile;

import cpw.mods.fml.common.Optional;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.lib.block.ExtendedBlock;
import snowpaw.projectx.lib.vec.Vector3i;

import java.util.ArrayList;
import java.util.List;



public class TileXTankFrame extends TileEntity {

    private ExtendedBlock block;
    private Vector3i valvePos;
    private TileXTankValve masterValve;
    private boolean wantsUpdate = false;

    public void initialize(TileXTankValve masterValve, ExtendedBlock block) {
        this.masterValve = masterValve;
        this.block = block;
    }

    public boolean isFrameInvalid() {
        TileEntity tile = worldObj.getTileEntity(xCoord, yCoord, zCoord);
        return tile == null || !(tile instanceof TileXTankFrame) || tile != this;
    }

    public List<ForgeDirection> getNeighborBlockOrAir(Block block) {
        List<ForgeDirection> dirs = new ArrayList<ForgeDirection>();
        for(ForgeDirection dr : ForgeDirection.VALID_DIRECTIONS) {
            if(block == Blocks.air) {
                if (worldObj.isAirBlock(xCoord + dr.offsetX, yCoord + dr.offsetY, zCoord + dr.offsetZ))
                    dirs.add(dr);
            }
            else {
                Block otherBlock = worldObj.getBlock(xCoord + dr.offsetX, yCoord + dr.offsetY, zCoord + dr.offsetZ);
                if(block == otherBlock || worldObj.isAirBlock(xCoord + dr.offsetX, yCoord + dr.offsetY, zCoord + dr.offsetZ))
                    dirs.add(dr);
            }
        }
        return dirs;
    }

    public boolean tryBurning() {
        Block block = getBlock().getBlock();
        if(block == null)
            return false;

        List<ForgeDirection> air = getNeighborBlockOrAir(Blocks.air);
        for(ForgeDirection dr : air) {
            if(block.isFlammable(worldObj, xCoord, yCoord, zCoord, dr)) {
                worldObj.setBlock(xCoord + dr.offsetX, yCoord + dr.offsetY, zCoord + dr.offsetZ, Blocks.fire, 0, 3);
                return true;
            }
        }
        return false;
    }

    public void breakFrame() {
        if(isFrameInvalid())
            return;

        worldObj.removeTileEntity(xCoord, yCoord, zCoord);
        if(block != null && block.getBlock() != null)
            worldObj.setBlock(xCoord, yCoord, zCoord, block.getBlock(), block.getMetadata(), 3);
        else
            worldObj.setBlockToAir(xCoord, yCoord, zCoord);
    }

    public void onBreak() {
        if(worldObj != null && !worldObj.isRemote && getValve() != null) {
            masterValve.breakTank(this);
        }
    }

    public void setValvePos(Vector3i valvePos) {
        this.valvePos = valvePos;
        this.masterValve = null;
    }

    public TileXTankValve getValve() {
        if(masterValve == null && this.valvePos != null) {
            TileEntity tile = worldObj.getTileEntity(valvePos.getX(), valvePos.getY(), valvePos.getZ());
            masterValve = tile instanceof TileXTankValve ? (TileXTankValve) tile : null;
        }

        return masterValve;
    }

    public void setBlock(ExtendedBlock block) {
        this.block = block;
    }

    public ExtendedBlock getBlock() {
        return block;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        if(tag.hasKey("valveX")) {
            setValvePos(new Vector3i(tag.getInteger("valveX"), tag.getInteger("valveY"), tag.getInteger("valveZ")));
        }
        if(tag.hasKey("blockId")) {
            this.block = new ExtendedBlock(Block.getBlockById(tag.getInteger("blockId")), tag.getInteger("metadata"));
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        if(getValve() != null) {
            tag.setInteger("valveX", getValve().xCoord);
            tag.setInteger("valveY", getValve().yCoord);
            tag.setInteger("valveZ", getValve().zCoord);
        }
        if(getBlock() != null) {
            tag.setInteger("blockId", Block.getIdFromBlock(getBlock().getBlock()));
            tag.setInteger("metadata", getBlock().getMetadata());
        }
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }

    public void markForUpdate() {
        if(worldObj == null) {
            wantsUpdate = true;
            return;
        }

        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public void updateEntity() {
        if (wantsUpdate) {
            markForUpdate();
            wantsUpdate = false;
        }
    }

}
