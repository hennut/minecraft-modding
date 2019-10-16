package com.hennut.wildOverhaul.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs{

	public ModTab() {
		super("tabWildOverhaul");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.honey);
	}

}
