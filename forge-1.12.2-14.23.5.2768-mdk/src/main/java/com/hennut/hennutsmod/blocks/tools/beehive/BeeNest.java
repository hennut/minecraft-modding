package com.hennut.hennutsmod.blocks.tools.beehive;

import java.util.Random;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BeeNest extends BlockWithModel {

	public BeeNest(String name) {
		super(name, Material.CLOTH, SoundType.CLOTH, 0.5f, 0.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.BEE_QUEEN;
	}
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}
}
