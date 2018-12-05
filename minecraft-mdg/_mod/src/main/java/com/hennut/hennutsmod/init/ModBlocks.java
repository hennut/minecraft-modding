package com.hennut.hennutsmod.init;

import java.util.ArrayList;
import java.util.List;

import com.hennut.hennutsmod.blocks.BlockBase;
import com.hennut.hennutsmod.blocks.pot.WoodPot;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block TEST_BLOCK = new BlockBase("testblock", Material.CLAY);
	
	//Pots
	public static final Block WOOD_POT = new WoodPot("woodpot");
	public static final Block CLAY_POT = new WoodPot("claypot");
	public static final Block IRON_POT = new WoodPot("ironpot");
}
