package dca.projectx.world.gen;

import java.util.Random;
import cpw.mods.fml.common.IWorldGenerator;
import dca.projectx.lib.XConfig;
import dca.projectx.world.XWorldBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class XGenOre implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
	}
	
	public void generateNether(World world, Random rand, int i, int j){
		
	}
	
	public void generateSurface(World world, Random rand, int i, int j){
		this.addOreSpawn(XWorldBlocks.oreBlue, world, rand, i, j, 16, 16, 3 + rand.nextInt(3), XConfig.xOreSpawnChance, 15, 50);
		this.addOreSpawn(XWorldBlocks.oreGreen, world, rand, i, j, 16, 16, 3 + rand.nextInt(3), XConfig.xOreSpawnChance, 15, 50);
		this.addOreSpawn(XWorldBlocks.oreRed, world, rand, i, j, 16, 16, 3 + rand.nextInt(3), XConfig.xOreSpawnChance, 15, 50);
		this.addOreSpawn(XWorldBlocks.oreDark, world, rand, i, j, 16, 16, 3 + rand.nextInt(3), XConfig.xOreSpawnChance, 15, 50);
		this.addOreSpawn(XWorldBlocks.oreLight, world, rand, i, j, 16, 16, 3 + rand.nextInt(3), XConfig.xOreSpawnChance, 15, 50);
		this.addOreSpawn(XWorldBlocks.oreAluminum, world, rand, i, j, 16, 16, 4 + rand.nextInt(1), XConfig.aOreSpawnChance, 15, 50);
	}
	
	public void generateEnd(World world, Random rand, int i, int j){
		
	}
	
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
	 
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++){
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}

}
