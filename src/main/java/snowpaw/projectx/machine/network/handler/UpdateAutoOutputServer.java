package snowpaw.projectx.machine.network.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import snowpaw.projectx.machine.network.NetworkHandler;
import snowpaw.projectx.machine.network.packet.FluidPacket;
import snowpaw.projectx.machine.tile.TileXTankValve;


public class UpdateAutoOutputServer extends SimpleChannelInboundHandler<FluidPacket.Server.UpdateAutoOutput> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FluidPacket.Server.UpdateAutoOutput msg) throws Exception{
        World world = NetworkHandler.getPlayer(ctx).worldObj;
        if(world != null) {
            TileEntity tile = world.getTileEntity(msg.x, msg.y, msg.z);
            if(tile != null && tile instanceof TileXTankValve) {
                ((TileXTankValve) tile).setAutoOutput(msg.autoOutput);
            }
        }
    }
}