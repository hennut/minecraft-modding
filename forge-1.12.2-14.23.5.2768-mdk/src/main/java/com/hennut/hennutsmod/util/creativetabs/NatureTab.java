package com.hennut.hennutsmod.util.creativetabs;

import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class NatureTab extends CreativeTabs {

	public NatureTab() {
		super("naturetab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.BEE_QUEEN);
	}
}
