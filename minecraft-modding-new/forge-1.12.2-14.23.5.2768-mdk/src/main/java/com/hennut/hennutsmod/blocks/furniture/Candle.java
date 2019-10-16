package com.hennut.hennutsmod.blocks.furniture;

import java.util.Random;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.util.handlers.EnumHandler.Status;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Candle extends BlockWithModel {
	
	private boolean on;
	
	public Candle(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, boolean unbreakable, AxisAlignedBB aabb, boolean on) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, lightLevel, unbreakable, aabb);
		this.on = on;
		setLightOpacity(15);
	}
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 0;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(on){
			worldIn.setBlockState(pos, ModBlocks.CANDLE_OFF.getDefaultState());
			return true;
		}else if(Item.getIdFromItem(playerIn.getHeldItem(hand).getItem()) == Item.getIdFromItem(Items.FLINT_AND_STEEL)) {
			ItemStack stack = playerIn.getHeldItem(hand);
			stack.getItem().setDamage(stack, stack.getItemDamage() - 1);
			worldIn.setBlockState(pos, ModBlocks.CANDLE_ON.getDefaultState());
			return true;
		}

		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.CANDLE_OFF);
	}
}
