package com.hennut.wildOverhaul.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BlockGen extends WorldGenerator {
	
	private static Block block, spawnInstead;
	private int maxAmount;
	
	public BlockGen(Block block, Block spawnInstead, int maxAmount) {
		this.block = block;
		this.spawnInstead = spawnInstead;
		if(maxAmount < 1)	maxAmount = 1;
		this.maxAmount = maxAmount;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		for (int i = 0; i < maxAmount; i++){
			
            int x = pos.getX() + rand.nextInt(8) - rand.nextInt(8);
            int y = pos.getY() + rand.nextInt(4) - rand.nextInt(4);
            int z = pos.getZ() + rand.nextInt(8) - rand.nextInt(8);
            
            if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == spawnInstead){
            	world.setBlockState(new BlockPos(x, y, z), block.getDefaultState());
                return true;        
            }
		}
		return false;
	}

	

}
