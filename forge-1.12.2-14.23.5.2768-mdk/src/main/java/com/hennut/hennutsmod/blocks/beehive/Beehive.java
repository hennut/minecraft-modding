package com.hennut.hennutsmod.blocks.beehive;

import java.util.Random;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.init.ModItems;
import com.hennut.hennutsmod.init.ModTabs;
import com.hennut.hennutsmod.util.handlers.EnumHandler.BeehiveStage;
import com.hennut.hennutsmod.util.handlers.EnumHandler.CheeseStage;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Beehive extends BlockWithModel {

	public static final PropertyEnum STAGE = PropertyEnum.create("stage", BeehiveStage.class);
	
	public Beehive(String name) {
		super(name, Material.WOOD, SoundType.WOOD, 1.0f, 5.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
		setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(getMetaFromState(worldIn.getBlockState(pos)) > BeehiveStage.UNFILLED.getID() && getMetaFromState(worldIn.getBlockState(pos)) != BeehiveStage.FOUR.getID()){
			worldIn.setBlockState(pos, state.cycleProperty(STAGE));
		}
		
		super.updateTick(worldIn, pos, state, rand);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(getMetaFromState(worldIn.getBlockState(pos)) == BeehiveStage.UNFILLED.getID()){
			if(Item.getIdFromItem(playerIn.getHeldItem(hand).getItem()) == Item.getIdFromItem(ModItems.BEE_QUEEN)){
				worldIn.setBlockState(pos, state.withProperty(STAGE, BeehiveStage.ONE));
				playerIn.getHeldItem(hand).shrink(1);
			}
		}else if(getMetaFromState(worldIn.getBlockState(pos)) > BeehiveStage.UNFILLED.getID()){		
			int count = getMetaFromState(worldIn.getBlockState(pos)) - 1;
			if(!worldIn.isRemote){
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.HONEY_COMB, count)));
			}
			worldIn.setBlockState(pos, state.withProperty(STAGE, BeehiveStage.ONE));
		}
		return true;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {STAGE});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		BeehiveStage stage = (BeehiveStage) state.getValue(STAGE);
		return stage.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE, BeehiveStage.values()[meta]); 
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if(state.getValue(STAGE) != BeehiveStage.UNFILLED){
			worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.BEE_QUEEN, 1)));
		}
		
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
	}
}
