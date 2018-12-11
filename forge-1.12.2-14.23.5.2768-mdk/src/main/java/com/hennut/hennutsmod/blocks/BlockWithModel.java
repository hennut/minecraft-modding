package com.hennut.hennutsmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockWithModel extends BlockAdjustable {

	public AxisAlignedBB aabb;
	
	public BlockWithModel(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, boolean unbreakable, AxisAlignedBB aabb) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, lightLevel, unbreakable);
		this.aabb = aabb;
	}
	
	public BlockWithModel(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, int lightOpacity, boolean unbreakable, AxisAlignedBB aabb) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, lightLevel, lightOpacity, unbreakable);
		this.aabb = aabb;
	}
	
	public BlockWithModel(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, float slipperiness, boolean unbreakable, AxisAlignedBB aabb) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, lightLevel, slipperiness, unbreakable);
		this.aabb = aabb;
	}
	
	public BlockWithModel(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, int lightOpacity, float slipperiness, boolean unbreakable, AxisAlignedBB aabb) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, lightLevel, lightOpacity, slipperiness, unbreakable);
		this.aabb = aabb;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return this.aabb;
	}
}
