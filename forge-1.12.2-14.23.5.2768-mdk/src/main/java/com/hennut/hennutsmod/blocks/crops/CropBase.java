package com.hennut.hennutsmod.blocks.crops;

import java.util.Random;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.handlers.EnumHandler.CropAge;
import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CropBase extends BlockWithModel {

	public static final PropertyEnum AGE = PropertyEnum.create("age", CropAge.class);
	
	private CropAge maxAge;
	
	public CropBase(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, boolean unbreakable, AxisAlignedBB aabb, CropAge maxAge) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, lightLevel, unbreakable, aabb);
		this.maxAge = maxAge;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(getMetaFromState(worldIn.getBlockState(pos)) != maxAge.getID()){
			worldIn.setBlockState(pos, state.cycleProperty(AGE));
		}
		
		super.updateTick(worldIn, pos, state, rand);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {AGE});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		CropAge stage = (CropAge) state.getValue(AGE);
		return stage.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, CropAge.values()[meta]); 
	}
}
