package com.hennut.hennutsmod.util.creativetabs;

import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class PotTab extends CreativeTabs {

	public PotTab() {
		super("pottab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.OAK_WOOD_POT);
	}
}
