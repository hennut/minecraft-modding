package com.hennut.hennutsmod.blocks.crops;

import com.hennut.hennutsmod.blocks.CropBase;
import com.hennut.hennutsmod.init.ModItems;
import com.hennut.hennutsmod.util.domestication.Domestication.PLANT_TYPES;
import com.hennut.hennutsmod.util.handlers.EnumHandler.CropAge;

import net.minecraft.item.Item;

public class WildLeafCrop extends CropBase {

	public WildLeafCrop(String name) {
		super(name, CropAge.SEVEN, PLANT_TYPES.LEAF);
	}

	@Override
	protected Item GetSeed() {
		return null;
	}

	@Override
	protected Item GetFruit() {
		return ModItems.WILD_LEAF;
	}
}
