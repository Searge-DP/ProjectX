package snowpaw.projectx.world.block;

import java.util.Random;

import net.minecraft.item.Item;
import snowpaw.projectx.lib.block.BlockXCropBase;
import snowpaw.projectx.world.XWorldItems;
import net.minecraft.block.BlockCrops;

public class BlockXCropCorn extends BlockXCropBase {

	public BlockXCropCorn(String blockName, String... subNames) {
		super(blockName, subNames);
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int j){
		if(meta < 5){
			return XWorldItems.seedCorn;
		}
		else
			return XWorldItems.foodCorn;
	}
	
	@Override //Change Rendertype like in 147
	public int getRenderType()
	{
		return 1;
	}
	
	@Override
	public int quantityDropped(Random rand){
		return 2 + rand.nextInt(2);
	}

}
