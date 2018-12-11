package com.hennut.hennutsmod.init;

import java.util.ArrayList;
import java.util.List;

import com.hennut.hennutsmod.blocks.BlockAdjustable;
import com.hennut.hennutsmod.blocks.BlockBase;
import com.hennut.hennutsmod.blocks.beehive.Beehive;
import com.hennut.hennutsmod.blocks.cheesemaker.CheeseMaker;
import com.hennut.hennutsmod.blocks.pots.ClayPot;
import com.hennut.hennutsmod.blocks.pots.IronPot;
import com.hennut.hennutsmod.blocks.pots.WoodPot;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	
	//Pots
	public static final Block OAK_WOOD_POT = new WoodPot("oakwoodpot");
	public static final Block BIRCH_WOOD_POT = new WoodPot("birchwoodpot");
	public static final Block SPRUCE_WOOD_POT = new WoodPot("sprucewoodpot");
	public static final Block ACACIA_WOOD_POT = new WoodPot("acaciawoodpot");
	public static final Block BIG_OAK_WOOD_POT = new WoodPot("bigoakwoodpot");
	public static final Block JUNGLE_WOOD_POT = new WoodPot("junglewoodpot");
	public static final Block CLAY_POT = new ClayPot("claypot");
	public static final Block IRON_POT = new IronPot("ironpot");
	
	//Cheese
	public static final Block CHEESE_MAKER = new CheeseMaker("cheesemaker");
	public static final Block CHEESE_BLOCK = new BlockAdjustable("cheeseblock", Material.CLAY, SoundType.SLIME, 1.0f, 5.0f, "", 0, 0, false);
	public static final Block BUTTER_BLOCK = new BlockAdjustable("butterblock", Material.CLAY, SoundType.SLIME, 1.0f, 5.0f, "", 0, 0, 1.1f, false);
	
	//Honey
	public static final Block BEEHIVE = new Beehive("beehive");
}
