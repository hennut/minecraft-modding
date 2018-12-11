package com.hennut.hennutsmod.util.domestication;

import java.util.Random;

import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.item.Item;

public class Domestication {
	
	public static enum PLANT_TYPES {LEAF, ROOT, SPICE, POD, BULB}
	
	private static Item[] LEAF_SEEDS = new Item[]{ModItems.LETTUCE_SEED};
	private static Item[] ROOT_SEEDS = new Item[]{};
	private static Item[] SPICE_SEEDS = new Item[]{};
	private static Item[] POD_SEEDS = new Item[]{};
	private static Item[] BULB_SEEDS = new Item[]{};
	
	public static Item GET_PLANT_DROP (PLANT_TYPES type, Random random) {
		switch(type){
		case LEAF:
			return GET_LEAF_PLANT_DROP(random);
		case ROOT:
			return GET_ROOT_PLANT_DROP(random);
		case SPICE:
			return GET_SPICE_PLANT_DROP(random);
		case POD:
			return GET_POD_PLANT_DROP(random);
		case BULB:
			return GET_BULB_PLANT_DROP(random);
		}
		
		return null;
	}
	
	private static Item GET_LEAF_PLANT_DROP (Random random) {
		int i = random.nextInt(LEAF_SEEDS.length);
		
		return LEAF_SEEDS[i];
	}
	
	private static Item GET_ROOT_PLANT_DROP (Random random) {
		int i = random.nextInt(ROOT_SEEDS.length);
		
		return ROOT_SEEDS[i];
	}
	
	private static Item GET_SPICE_PLANT_DROP (Random random) {
		int i = random.nextInt(SPICE_SEEDS.length);
		
		return SPICE_SEEDS[i];
	}
	
	private static Item GET_POD_PLANT_DROP (Random random) {
		int i = random.nextInt(POD_SEEDS.length);
		
		return POD_SEEDS[i];
	}
	
	private static Item GET_BULB_PLANT_DROP (Random random) {
		int i = random.nextInt(BULB_SEEDS.length);
		
		return BULB_SEEDS[i];
	}
}
