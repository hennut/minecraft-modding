package com.hennut.hennutsmod.items;

import com.hennut.hennutsmod.HennutsMod;
import com.hennut.hennutsmod.init.ModItems;
import com.hennut.hennutsmod.init.ModTabs;
import com.hennut.hennutsmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase (String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModTabs.debugTab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		HennutsMod.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
