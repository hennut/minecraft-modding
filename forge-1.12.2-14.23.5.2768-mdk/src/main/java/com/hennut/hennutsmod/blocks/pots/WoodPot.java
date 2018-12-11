package com.hennut.hennutsmod.blocks.pots;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.init.ModTabs;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;

public class WoodPot extends BlockWithModel {
	
	public WoodPot(String name) {
		super(name, Material.WOOD, SoundType.WOOD, 1.0f, 5.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
	}
	
	public WoodPot(String name, Material material, SoundType soundType) {
		super(name, material, soundType, 1.0f, 5.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
	}
}
