package com.hennut.hennutsmod.items;

import com.hennut.hennutsmod.HennutsMod;
import com.hennut.hennutsmod.init.ModItems;
import com.hennut.hennutsmod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public abstract class FruitBase extends FoodBase implements IPlantable {
	
	private EnumPlantType type;
	
	public FruitBase(String name, int amount, boolean isWolfFood, EnumPlantType type) {
		super(name, amount, isWolfFood);
		this.type = type;
	}

	
	public FruitBase(String name, int amount, float saturation, boolean isWolfFood, EnumPlantType type) {
		super(name, amount, saturation, isWolfFood);
		this.type = type;
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemStack = player.getHeldItem(hand);
		IBlockState state = worldIn.getBlockState(pos);
		
		if(facing == EnumFacing.UP && player.canPlayerEdit(pos, facing, itemStack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())) {
			worldIn.setBlockState(pos.up(), getCropState ());
			itemStack.shrink(1);
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return type;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return getCropState ();
	}

	protected abstract Block getCropBlock ();
	
	private IBlockState getCropState () {
		return getCropBlock().getDefaultState();
	}
}
