package snowpaw.projectx.machine.network.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import snowpaw.projectx.machine.network.NetworkHandler;
import snowpaw.projectx.machine.network.packet.FluidPacket;
import snowpaw.projectx.machine.tile.TileXTankValve;


public class UpdateValveNameServer extends SimpleChannelInboundHandler<FluidPacket.Server.UpdateValveName> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FluidPacket.Server.UpdateValveName msg) throws Exception{
        World world = NetworkHandler.getPlayer(ctx).worldObj;
        if(world != null) {
            TileEntity pahimartherainmaker = world.getTileEntity(msg.x, msg.y, msg.z);
            if(pahimartherainmaker != null && pahimartherainmaker instanceof TileXTankValve) {
            	TileXTankValve valve = (TileXTankValve) pahimartherainmaker;
                valve.setValveName(msg.name);
                valve.updateBlockAndNeighbors(true);
            }
        }
    }
}