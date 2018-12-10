package com.hennut.hennutsmod.blocks.pot;

import javax.annotation.Nullable;

import com.hennut.hennutsmod.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronPot extends ClayPot {

	public IronPot(String name) {
		super(name, Pots.IRON_POT);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(Item.getIdFromItem(playerIn.getHeldItem(hand).getItem()) == Item.getIdFromItem(Items.MILK_BUCKET)){
			worldIn.setBlockState(pos, ModBlocks.CHEESE_MAKER.getDefaultState());
			playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
			return true;
		}
		
		return false;
	}
}
