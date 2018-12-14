package com.hennut.hennutsmod.init;

import java.util.ArrayList;
import java.util.List;

import com.hennut.hennutsmod.blocks.BlockAdjustable;
import com.hennut.hennutsmod.blocks.BlockBase;
import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.blocks.CropBase;
import com.hennut.hennutsmod.blocks.crops.WildLeafCrop;
import com.hennut.hennutsmod.blocks.furniture.TableBase;
import com.hennut.hennutsmod.blocks.tools.beehive.BeeNest;
import com.hennut.hennutsmod.blocks.tools.beehive.Beehive;
import com.hennut.hennutsmod.blocks.tools.cheesemaker.CheeseMaker;
import com.hennut.hennutsmod.blocks.tools.pots.ClayPot;
import com.hennut.hennutsmod.blocks.tools.pots.IronPot;
import com.hennut.hennutsmod.blocks.tools.pots.WoodPot;
import com.hennut.hennutsmod.util.domestication.Domestication.PLANT_TYPES;
import com.hennut.hennutsmod.util.handlers.EnumHandler.CropAge;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	

	//Pots
	public static final Block OAK_WOOD_POT = new WoodPot("oakwoodpot").setCreativeTab(ModTabs.potTab);
	public static final Block BIRCH_WOOD_POT = new WoodPot("birchwoodpot").setCreativeTab(ModTabs.potTab);
	public static final Block SPRUCE_WOOD_POT = new WoodPot("sprucewoodpot").setCreativeTab(ModTabs.potTab);
	public static final Block ACACIA_WOOD_POT = new WoodPot("acaciawoodpot").setCreativeTab(ModTabs.potTab);
	public static final Block BIG_OAK_WOOD_POT = new WoodPot("bigoakwoodpot").setCreativeTab(ModTabs.potTab);
	public static final Block JUNGLE_WOOD_POT = new WoodPot("junglewoodpot").setCreativeTab(ModTabs.potTab);
	public static final Block CLAY_POT = new ClayPot("claypot").setCreativeTab(ModTabs.potTab);
	public static final Block IRON_POT = new IronPot("ironpot").setCreativeTab(ModTabs.potTab);
	
	//Cheese
	public static final Block CHEESE_MAKER = new CheeseMaker("cheesemaker").setCreativeTab(ModTabs.toolTab);
	public static final Block CHEESE_BLOCK = new BlockAdjustable("cheeseblock", Material.CLAY, SoundType.SLIME, 1.0f, 5.0f, "", 0, 0, false).setCreativeTab(ModTabs.cropTab);
	public static final Block BUTTER_BLOCK = new BlockAdjustable("butterblock", Material.CLAY, SoundType.SLIME, 1.0f, 5.0f, "", 0, 0, 1.1f, false).setCreativeTab(ModTabs.cropTab);
	
	//Honey
	public static final Block BEE_NEST = new BeeNest("beenest").setCreativeTab(ModTabs.natureTab);
	public static final Block BEEHIVE = new Beehive("beehive").setCreativeTab(ModTabs.toolTab);
	
	//Plants
		//Shrub
		//Wild
		public static final Block WILD_LEAF_CROP = new WildLeafCrop("wildleafcrop").setCreativeTab(ModTabs.debugTab);
		//Domesticated
		
	//Furniture
	public static final Block WOODEN_TABLE = new TableBase("woodentable", Material.WOOD, SoundType.WOOD, 0.5f, 1.0f, "axe", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1)).setCreativeTab(ModTabs.furnitureTab);
}
