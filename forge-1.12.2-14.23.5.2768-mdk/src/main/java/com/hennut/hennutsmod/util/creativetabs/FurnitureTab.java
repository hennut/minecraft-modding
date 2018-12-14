package com.hennut.hennutsmod.util.creativetabs;

import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FurnitureTab extends CreativeTabs {

	public FurnitureTab() {
		super("furnituretab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.CHEESE_SLICE);
	}
}
