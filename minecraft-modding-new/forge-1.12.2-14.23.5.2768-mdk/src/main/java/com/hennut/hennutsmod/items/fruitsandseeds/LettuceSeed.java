package com.hennut.hennutsmod.items.fruitsandseeds;

import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.init.ModTabs;
import com.hennut.hennutsmod.items.SeedBase;

import net.minecraft.block.Block;
import net.minecraftforge.common.EnumPlantType;

public class LettuceSeed extends SeedBase {

	public LettuceSeed(String name) {
		super(name, EnumPlantType.Crop);
	}

	@Override
	protected Block getCropBlock() {
		return ModBlocks.WILD_LEAF_CROP;
	}
}
