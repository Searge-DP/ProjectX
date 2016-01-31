package snowpaw.projectx.machine.tile;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import snowpaw.projectx.lib.vec.Vector3i;

public class TileXFluidDetector extends TileEntity {
	
	private Vector3i valvePos;
	private TileXTankValve masterValve;
	private boolean wantsUpdate = false;
	
	private int positionInTank;
	
	public void initialize(TileXTankValve masterValve) {
        this.masterValve = masterValve;
    }
	
	public boolean isFrameInvalid() {
        TileEntity tile = worldObj.getTileEntity(xCoord, yCoord, zCoord);
        return tile == null || !(tile instanceof TileXFluidDetector) || tile != this;
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
    
    public boolean isLiquidOnStage(int positionOnTank)
    {
    	if(getValve().isValid())
    	{
    		
    		int liquidDetectorPos = positionOnTank;
    		int height = getValve().getTankHeight();
    		double percentagePerBlock = 1 / height * 100;
    		double filledPercentage = getValve().getFillPercentage();
    		
    		if((liquidDetectorPos-1) * percentagePerBlock < filledPercentage)
    		{
    			return true;
    		}
    		return false;
    		
    		
    		
    	}
    	return false;
    }
    
    public void setPositionInTank(int pos){
    	if(getValve().isValid())
    	{
    		if(getValve().getTankHeight() > pos && getValve().getTankHeight() < pos)
    		{
    			positionInTank = pos;
    		}
    		else return;
    	}
    	else return;
    }
    
    public void markForUpdate() {
        if(worldObj == null) {
            wantsUpdate = true;
            return;
        }

        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
    
    @Override
	public void updateEntity()
	{
    	
	}

}
