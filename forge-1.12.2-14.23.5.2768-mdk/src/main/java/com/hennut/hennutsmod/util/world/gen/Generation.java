package com.hennut.hennutsmod.util.world.gen;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Generation {

	private WorldGenerator gen;
	private int chance, minHeight, maxHeight, dimension;
	private String name;
	
	public Generation (WorldGenerator gen, int chance, int minHeight, int maxHeight, int dimension){
		this.gen = gen;
		this.chance = chance;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.dimension = dimension;
	}
	
	public Generation (WorldGenerator gen, int chance, int minHeight, int maxHeight, int dimension, String name){
		this.gen = gen;
		this.chance = chance;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.dimension = dimension;
		this.name = name;
	}

	public WorldGenerator getGen() {
		return gen;
	}

	public int getChance() {
		return chance;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public int getDimension() {
		return dimension;
	}
	
	public String toString() {
		if(name != null){
			return name;
		}else {
			return "no name";
		}
	}
}
