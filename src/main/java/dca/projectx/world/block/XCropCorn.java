package dca.projectx.world.block;

import java.util.Random;
import dca.projectx.core.block.XCropBase;
import dca.projectx.world.XWorldItems;
import net.minecraft.item.Item;
import net.minecraft.block.BlockCrops;

public class XCropCorn extends XCropBase {

	public XCropCorn(String blockName, String... subNames) {
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
	
	@Override
	public int quantityDropped(Random rand){
		return 2 + rand.nextInt(2);
	}

}
