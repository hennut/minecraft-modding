package com.hennut.wildOverhaul.init;

import com.hennut.wildOverhaul.Reference;
import com.hennut.wildOverhaul.items.ItemHoney;
import com.hennut.wildOverhaul.items.ItemQueenBee;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item honey;
	public static Item queenBee;

	public static void init(){
		honey = new ItemHoney();
		queenBee = new ItemQueenBee();
	}
	
	public static void register(){
		GameRegistry.register(honey);
		GameRegistry.register(queenBee);
	}
	
	public static void registerRenders(){
		registerRender(honey);
		registerRender(queenBee);
	}
	
	private static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
