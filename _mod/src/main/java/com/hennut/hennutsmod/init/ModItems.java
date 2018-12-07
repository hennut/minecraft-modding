package com.hennut.hennutsmod.init;

import java.util.ArrayList;
import java.util.List;

import com.hennut.hennutsmod.items.FoodBase;
import com.hennut.hennutsmod.items.ItemBase;

import net.minecraft.item.Item;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item TEST_ITEM = new FoodBase("testitem", 2, false);
}
