package com.hennut.hennutsmod.blocks;

import com.hennut.hennutsmod.HennutsMod;
import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.init.ModItems;
import com.hennut.hennutsmod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

	public BlockBase (String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		HennutsMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}
