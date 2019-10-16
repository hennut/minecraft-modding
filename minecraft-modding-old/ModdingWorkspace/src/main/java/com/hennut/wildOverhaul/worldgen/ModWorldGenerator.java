package com.hennut.wildOverhaul.worldgen;

import java.util.Random;

import com.hennut.wildOverhaul.blocks.BlockBeenest;
import com.hennut.wildOverhaul.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
	    switch (world.provider.getDimension()) {
	    case 0: //Overworld
	    	generateSurface(world, random, chunkX * 16, chunkZ * 16);
	        break;
	    case -1: //Nether
	    	generateNether(world, random, chunkX * 16, chunkZ * 16);
	        break;
	    case 1: //End
	    	generateEnd(world, random, chunkX * 16, chunkZ * 16);
	        break;
	    }
	}
	
	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		this.runGenerator(ModBlocks.beenest, Blocks.LEAVES, 4, world, random, chunkX, chunkZ, 60, 25);
	}
	
	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		// TODO Auto-generated method stub
		
	}
	
	private void runGenerator(Block block, Block spawnInstead, int maxAmount, World world, Random random, int chunkX, int chunkZ, int minY, int varY){
		for(int i = 0; i < 2; i++){
			int posX = chunkX + random.nextInt(16);
			int posZ = chunkZ + random.nextInt(16);
			if(minY < 6)	minY = 6;
			if(varY < 1)	varY = 1;
			int posY = minY + random.nextInt(varY);
			new BlockGen(block, spawnInstead, maxAmount).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}

}
