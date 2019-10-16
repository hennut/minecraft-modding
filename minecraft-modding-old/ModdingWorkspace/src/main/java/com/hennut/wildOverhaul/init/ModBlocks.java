package com.hennut.wildOverhaul.init;

import com.hennut.wildOverhaul.blocks.BlockBeehive;
import com.hennut.wildOverhaul.blocks.BlockBeenest;
import com.hennut.wildOverhaul.blocks.BlockStool;
import com.hennut.wildOverhaul.blocks.BlockTable;
import com.hennut.wildOverhaul.items.ItemHoney;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block beehive;
	public static Block beenest;
	public static Block stool;
	public static Block table;
	
	public static void init(){
		beehive = new BlockBeehive();
		beenest = new BlockBeenest();
		stool = new BlockStool();
		table = new BlockTable();
	}
	
	public static void register(){
		registerBlock(beehive);
		registerBlock(beenest);
		registerBlock(stool);
		registerBlock(table);
	}
	
	private static void registerBlock(Block block){
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders(){
		registerRender(beehive);
		registerRender(beenest);
		registerRender(stool);
		registerRender(table);
	}
	
	private static void registerRender(Block block){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
