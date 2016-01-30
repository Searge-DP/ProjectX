package snowpaw.projectx.lib.block;

import net.minecraft.block.Block;

public class ExtendedBlock {

    private final Block block;
    private final int metadata;

    public ExtendedBlock(Block block, int metadata) {
        this.block = block;
        this.metadata = metadata;
    }

    public Block getBlock() {
        return this.block;
    }

    public int getMetadata() {
        return this.metadata;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ExtendedBlock))
            return false;

        ExtendedBlock other = (ExtendedBlock) obj;
        return other.getBlock().getUnlocalizedName().equals(getBlock().getUnlocalizedName()) && other.getMetadata() == getMetadata();
    }

    public boolean equalsIgnoreMetadata(ExtendedBlock block) {
        return block.getBlock().getUnlocalizedName().equals(getBlock().getUnlocalizedName());
    }

    @Override
    public String toString() {
        return getBlock().getUnlocalizedName() + ":" + getMetadata();
    }
}