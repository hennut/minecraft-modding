package com.hennut.hennutsmod.init;

import java.util.ArrayList;
import java.util.List;

import com.hennut.hennutsmod.blocks.BlockBase;
import com.hennut.hennutsmod.blocks.pot.ClayPot;
import com.hennut.hennutsmod.blocks.pot.IronPot;
import com.hennut.hennutsmod.blocks.pot.WoodPot;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block TEST_BLOCK = new BlockBase("testblock", Material.CLAY);
	
	//Pots
	public static final Block OAK_WOOD_POT = new WoodPot("oakwoodpot");
	public static final Block BIRCH_WOOD_POT = new WoodPot("birchwoodpot");
	public static final Block SPRUCE_WOOD_POT = new WoodPot("sprucewoodpot");
	public static final Block ACACIA_WOOD_POT = new WoodPot("acaciawoodpot");
	public static final Block BIG_OAK_WOOD_POT = new WoodPot("bigoakwoodpot");
	public static final Block JUNGLE_WOOD_POT = new WoodPot("junglewoodpot");
	public static final Block CLAY_POT = new ClayPot("claypot");
	public static final Block IRON_POT = new IronPot("ironpot");
}
