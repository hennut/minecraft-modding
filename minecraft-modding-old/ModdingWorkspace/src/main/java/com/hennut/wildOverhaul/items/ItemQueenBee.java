package com.hennut.wildOverhaul.items;

import com.hennut.wildOverhaul.Reference;
import com.hennut.wildOverhaul.WildOverhaul;

import net.minecraft.item.Item;

public class ItemQueenBee extends Item {
	
	public ItemQueenBee(){
		this.setUnlocalizedName(Reference.wildOverhaulItems.QUEEN_BEE.getUnlocalizedName());
		this.setRegistryName(Reference.wildOverhaulItems.QUEEN_BEE.getRegistryName());
		this.setCreativeTab(WildOverhaul.CREATIVE_TAB);
	}
}
