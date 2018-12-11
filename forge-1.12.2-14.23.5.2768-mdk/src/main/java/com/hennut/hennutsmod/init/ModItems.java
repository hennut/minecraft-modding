package com.hennut.hennutsmod.init;

import java.util.ArrayList;
import java.util.List;

import com.hennut.hennutsmod.items.FoodBase;
import com.hennut.hennutsmod.items.FruitBase;
import com.hennut.hennutsmod.items.ItemBase;
import com.hennut.hennutsmod.items.SeedBase;
import com.hennut.hennutsmod.items.fruitsandseeds.LettuceSeed;
import com.hennut.hennutsmod.items.fruitsandseeds.WildLeafFruit;

import net.minecraft.item.Item;
import net.minecraftforge.common.EnumPlantType;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	//Cheese
	public static Item BUTTER = new FoodBase("butter", 3, false).setCreativeTab(ModTabs.cropTab);
	public static Item CHEESE_SLICE = new FoodBase("cheeseslice", 1, false).setCreativeTab(ModTabs.cropTab);
	
	//Honey
	public static Item BEE_QUEEN = new ItemBase("beequeen").setCreativeTab(ModTabs.natureTab);
	public static Item HONEY_COMB = new ItemBase("honeycomb").setCreativeTab(ModTabs.cropTab);
	
	//Plants
		//Wild
		public static Item WILD_LEAF = new WildLeafFruit("wildleaf", 1).setCreativeTab(ModTabs.natureTab);
		//Domesticated
		public static Item LETTUCE_FRUIT = new FoodBase("lettucefruit", 2).setCreativeTab(ModTabs.cropTab);
		public static Item LETTUCE_SEED = new LettuceSeed("lettuceseed").setCreativeTab(ModTabs.cropTab);
		
}
