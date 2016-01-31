package snowpaw.projectx.machine.network;

import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import snowpaw.projectx.machine.network.packet.FluidPacket;

public class PacketCodec extends FMLIndexedMessageToMessageCodec<FluidPacket> {

    int lastDiscriminator = 0;

    public PacketCodec(){
        addPacket(FluidPacket.Server.UpdateAutoOutput.class);
        addPacket(FluidPacket.Server.UpdateValveName.class);
    }

    void addPacket(Class<? extends FluidPacket> type) {
        this.addDiscriminator(lastDiscriminator, type);
        lastDiscriminator++;
    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, FluidPacket msg, ByteBuf target) throws Exception{
        msg.encode(target);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, FluidPacket msg){
        msg.decode(source);
    }
}