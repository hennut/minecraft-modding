package com.hennut.hennutsmod.util.creativetabs;

import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class DebugTab extends CreativeTabs {

	public DebugTab() {
		super("debugtab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.CHEESE_SLICE);
	}
}
