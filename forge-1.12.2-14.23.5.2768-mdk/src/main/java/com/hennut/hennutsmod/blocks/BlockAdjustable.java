package com.hennut.hennutsmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockAdjustable extends BlockBase {

	public BlockAdjustable(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, boolean unbreakable) {
		super(name, material);
		
		setSoundType(soundType);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, harvestLevel);
		setLightLevel(lightLevel);
		
		if(unbreakable)	setBlockUnbreakable();
	}
	
	public BlockAdjustable(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, int lightOpacity, boolean unbreakable) {
		super(name, material);
		
		setSoundType(soundType);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, harvestLevel);
		setLightLevel(lightLevel);
		setLightOpacity(lightOpacity);

		if(unbreakable)	setBlockUnbreakable();
	}
}
