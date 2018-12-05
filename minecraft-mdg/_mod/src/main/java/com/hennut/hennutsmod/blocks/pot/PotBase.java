package com.hennut.hennutsmod.blocks.pot;

import com.hennut.hennutsmod.blocks.BlockAdjustable;
import com.hennut.hennutsmod.blocks.BlockWithModel;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;

public abstract class PotBase extends BlockWithModel {
	
	public enum Pots {WOODEN_POT, CLAY_POT, IRON_POT}

	public PotBase(String name, Pots type) {
		super (
				name,
				(type == Pots.WOODEN_POT ? Material.WOOD : (type == Pots.CLAY_POT ? Material.CLAY : (type == Pots.IRON_POT ? Material.IRON : Material.CLAY))),
				(type == Pots.WOODEN_POT ? SoundType.WOOD : (type == Pots.CLAY_POT ? SoundType.STONE : (type == Pots.IRON_POT ? SoundType.METAL : SoundType.STONE))),
				(type == Pots.WOODEN_POT ? 0.0f : (type == Pots.CLAY_POT ? 0.0f : (type == Pots.IRON_POT ? 1.0f : 0.0f))),
				15.0f,
				"",
				0,
				0,
				false,
				new AxisAlignedBB(0, 0, 0, 1, 0.75D, 1)
			);		
	}

}
