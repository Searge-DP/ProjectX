package snowpaw.projectx.machine.network.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import snowpaw.projectx.machine.tile.TileXTankValve;

public abstract class FluidPacket {
    public abstract void encode(ByteBuf buffer);

    public abstract void decode(ByteBuf buffer);

    public static abstract class Client {
    }

    public static class Server {
        public static class UpdateAutoOutput extends FluidPacket {
            public int x, y, z;
            public boolean autoOutput;

            public UpdateAutoOutput(){
            }

            public UpdateAutoOutput(TileXTankValve valve, boolean autoOutput) {
                this.x = valve.xCoord;
                this.y = valve.yCoord;
                this.z = valve.zCoord;
                this.autoOutput = autoOutput;
            }

            public UpdateAutoOutput(int x, int y, int z, boolean autoOutput) {
                this.x = x;
                this.y = y;
                this.z = z;
                this.autoOutput = autoOutput;
            }

            @Override
            public void encode(ByteBuf buffer) {
                buffer.writeInt(this.x);
                buffer.writeInt(this.y);
                buffer.writeInt(this.z);
                buffer.writeBoolean(this.autoOutput);
            }

            @Override
            public void decode(ByteBuf buffer) {
                this.x = buffer.readInt();
                this.y = buffer.readInt();
                this.z = buffer.readInt();
                this.autoOutput = buffer.readBoolean();
            }
        }

        public static class UpdateValveName extends FluidPacket {
            public int x, y, z;
            public String name;

            public UpdateValveName(){
            }

            public UpdateValveName(TileXTankValve valve, String name) {
                this.x = valve.xCoord;
                this.y = valve.yCoord;
                this.z = valve.zCoord;
                this.name = name;
            }

            public UpdateValveName(int x, int y, int z, String name) {
                this.x = x;
                this.y = y;
                this.z = z;
                this.name = name;
            }

            @Override
            public void encode(ByteBuf buffer) {
                buffer.writeInt(this.x);
                buffer.writeInt(this.y);
                buffer.writeInt(this.z);
                ByteBufUtils.writeUTF8String(buffer, this.name);
            }

            @Override
            public void decode(ByteBuf buffer) {
                this.x = buffer.readInt();
                this.y = buffer.readInt();
                this.z = buffer.readInt();
                this.name = ByteBufUtils.readUTF8String(buffer);
            }
        }
    }
}