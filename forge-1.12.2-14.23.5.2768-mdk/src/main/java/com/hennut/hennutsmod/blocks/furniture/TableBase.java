package com.hennut.hennutsmod.blocks.furniture;

import java.util.Random;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.util.handlers.EnumHandler.TableDirection;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TableBase extends BlockWithModel {

	public static final PropertyEnum DIRECTION = PropertyEnum.create("direction", TableDirection.class);
	
	public TableBase(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, boolean unbreakable, AxisAlignedBB aabb) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, lightLevel, unbreakable, aabb);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		setDirection(worldIn, state, pos);
		
		super.onBlockAdded(worldIn, pos, state);
	}
	
	@Override
	public void observedNeighborChange(IBlockState observerState, World world, BlockPos observerPos, Block changedBlock, BlockPos changedBlockPos) {
		setDirection(world, observerState, observerPos);
		
		super.observedNeighborChange(observerState, world, observerPos, changedBlock, changedBlockPos);
	}
	
	protected void setDirection(World world, IBlockState state, BlockPos pos) {
		boolean north, south, west, east;
		north = Block.getIdFromBlock(world.getBlockState(pos.north()).getBlock()) == Block.getIdFromBlock(this);
		south = Block.getIdFromBlock(world.getBlockState(pos.south()).getBlock()) == Block.getIdFromBlock(this);
		west = Block.getIdFromBlock(world.getBlockState(pos.west()).getBlock()) == Block.getIdFromBlock(this);
		east = Block.getIdFromBlock(world.getBlockState(pos.east()).getBlock()) == Block.getIdFromBlock(this);
		
		if(north && !south && !west && !east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.N));
		}else if(!north && south && !west && !east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.S));
		}else if(!north && !south && west && !east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.W));
		}else if(!north && !south && !west && east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.E));
		}else if(north && !south && west && !east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.NW));
		}else if(north && !south && !west && east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.NE));
		}else if(!north && south && west && !east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.SW));
		}else if(!north && south && !west && east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.SE));
		}else if(north || south || west || east) {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.NONE));
		}else {
			world.setBlockState(pos, state.withProperty(DIRECTION, TableDirection.ALL));
		}
	}
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {DIRECTION});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		TableDirection dir = (TableDirection) state.getValue(DIRECTION);
		return dir.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DIRECTION, TableDirection.values()[meta]); 
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.WOODEN_TABLE);
	}
}
