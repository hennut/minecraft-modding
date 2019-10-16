package com.hennut.hennutsmod.init;

import com.hennut.hennutsmod.util.world.gen.Generation;
import com.hennut.hennutsmod.util.world.gen.ModOreGeneration;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModGenerators {

	public ModGenerators(){
		GameRegistry.registerWorldGenerator(new ModOreGeneration(
				
					new Generation(new WorldGenMinable(ModBlocks.BEE_NEST.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.LEAVES)), 100, 0, 256, 0, "Bee nest generator"),
					new Generation(new WorldGenMinable(ModBlocks.SALT_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE)), 50, 35, 256, 0, "Salt ore generator")
					
				), 0);
	}
}
