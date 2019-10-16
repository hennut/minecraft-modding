package com.hennut.wildOverhaul.blocks;

import com.hennut.wildOverhaul.Reference;
import com.hennut.wildOverhaul.WildOverhaul;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockTable extends Block {
	
	public BlockTable() {
		super(Material.WOOD);
		this.setUnlocalizedName(Reference.wildOverhaulBlocks.TABLE.getUnlocalizedName());
		this.setRegistryName(Reference.wildOverhaulBlocks.TABLE.getRegistryName());
		this.setCreativeTab(WildOverhaul.CREATIVE_TAB);
	}

	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
}
