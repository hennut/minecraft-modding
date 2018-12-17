package com.hennut.hennutsmod.blocks.environment.ores;

import java.util.Random;

import com.hennut.hennutsmod.blocks.BlockAdjustable;
import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SaltOre extends BlockAdjustable {

	public SaltOre(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, 0, false);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.SALT;
	}
}
