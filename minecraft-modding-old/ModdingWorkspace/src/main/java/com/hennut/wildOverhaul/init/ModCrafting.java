package com.hennut.wildOverhaul.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	
	public static void register(){
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.beehive), "WWW", "WSW", "W W", 'W', Blocks.PLANKS, 'S', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.stool), " W ", "S S", 'W', Blocks.WOODEN_SLAB, 'S', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.stool), " W ", " S ", "SSS", 'W', new ItemStack(Blocks.WOOL, 1, 0), 'S', Items.STICK);
	}
}
