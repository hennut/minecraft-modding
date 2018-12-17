package com.hennut.hennutsmod.util.world.gen;

import java.util.Random;

import com.hennut.hennutsmod.util.Reference;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModOreGeneration implements IWorldGenerator {
	
	private Generation[] generations;
	
	public ModOreGeneration(Generation... gens) {
		generations = gens;
		System.out.println(Reference.MODID + ".generation :  " + gens.length + " generators found");
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		for(Generation gen : generations) {
			if(gen.getDimension() == world.provider.getDimension()) {
				runGenerator(gen.getGen(), world, random, chunkX, chunkZ, gen.getChance(), gen.getMinHeight(), gen.getMaxHeight());
				System.out.println(Reference.MODID + ".generation :  Generated with " + gen.toString());
			}
		}
	}

	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight){
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		int heightDiff = maxHeight - minHeight + 1;
		
		for(int i = 0; i < chance; i++){
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
