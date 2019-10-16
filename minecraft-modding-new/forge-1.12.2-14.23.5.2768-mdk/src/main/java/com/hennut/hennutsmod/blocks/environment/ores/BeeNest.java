package com.hennut.hennutsmod.blocks.environment.ores;

import java.util.Random;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BeeNest extends BlockWithModel {

	public BeeNest(String name) {
		super(name, Material.CLOTH, SoundType.CLOTH, 0.5f, 0.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if(!player.isCreative()){
			EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.HONEY_COMB, new Random().nextInt(3)));
			if(!worldIn.isRemote)	worldIn.spawnEntity(item);
		}
		
		super.onBlockHarvested(worldIn, pos, state, player);
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
