package com.hennut.hennutsmod.blocks.pots;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ClayPot extends WoodPot {
	
	public ClayPot(String name) {
		super(name, Material.CLAY, SoundType.STONE);
	}

	public ClayPot(String name, Material material, SoundType soundType) {
		super(name, material, soundType);
	}
}
