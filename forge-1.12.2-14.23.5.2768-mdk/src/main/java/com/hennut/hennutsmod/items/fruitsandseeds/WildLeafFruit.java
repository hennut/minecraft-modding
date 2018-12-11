package com.hennut.hennutsmod.items.fruitsandseeds;

import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.items.FruitBase;

import net.minecraft.block.Block;
import net.minecraftforge.common.EnumPlantType;

public class WildLeafFruit extends FruitBase {

	public WildLeafFruit(String name, int amount) {
		super(name, amount, false, EnumPlantType.Crop);
	}

	@Override
	protected Block getCropBlock() {
		return ModBlocks.WILD_LEAF_CROP;
	}

}
