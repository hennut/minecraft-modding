package com.hennut.wildOverhaul.items;

import com.hennut.wildOverhaul.Reference;
import com.hennut.wildOverhaul.WildOverhaul;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemHoney extends ItemFood {
	
	public ItemHoney() {
		super(1, 0.1f, false);
		this.setUnlocalizedName(Reference.wildOverhaulItems.HONEY.getUnlocalizedName());
		this.setRegistryName(Reference.wildOverhaulItems.HONEY.getRegistryName());
		this.setCreativeTab(WildOverhaul.CREATIVE_TAB);
	}
}
