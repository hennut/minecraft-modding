package com.hennut.hennutsmod.util.creativetabs;

import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ToolTab extends CreativeTabs {

	public ToolTab() {
		super("tooltab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.HONEY_COMB);
	}
}
