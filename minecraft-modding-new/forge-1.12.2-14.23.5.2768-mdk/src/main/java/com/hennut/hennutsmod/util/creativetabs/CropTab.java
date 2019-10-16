package com.hennut.hennutsmod.util.creativetabs;

import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CropTab extends CreativeTabs {

	public CropTab() {
		super("croptab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.LETTUCE_FRUIT);
	}
}
