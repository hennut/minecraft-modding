package com.hennut.hennutsmod.blocks.cheesemaker;

import java.util.Random;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.init.ModBlocks;
import com.hennut.hennutsmod.init.ModItems;
import com.hennut.hennutsmod.util.handlers.EnumHandler.CheeseStage;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CheeseMaker extends BlockWithModel{

	public static final PropertyEnum STAGE = PropertyEnum.create("stage", CheeseStage.class);
	
	public CheeseMaker(String name) {
		super(name, Material.CLAY, SoundType.SLIME, 1.0f, 5.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
	}
	
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		IBlockState state = worldIn.getBlockState(pos);
		if(state.getValue(STAGE) != CheeseStage.CHEESE) {
			worldIn.setBlockState(pos, state.cycleProperty(STAGE));
		}
		super.onBlockClicked(worldIn, pos, playerIn);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		int count = 3;
		if(getMetaFromState(worldIn.getBlockState(pos)) >= CheeseStage.CHEESE.getID()){
			if(!worldIn.isRemote){
				EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Item.getItemFromBlock(ModBlocks.CHEESE_BLOCK), 1));
				worldIn.spawnEntity(item);				
			}
		}else if(getMetaFromState(worldIn.getBlockState(pos)) >= CheeseStage.BUTTER.getID()){
			if(!worldIn.isRemote){
				EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.BUTTER, count));
				worldIn.spawnEntity(item);
			}
		}
		worldIn.setBlockState(pos, ModBlocks.IRON_POT.getDefaultState());
		return true;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {STAGE});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		CheeseStage stage = (CheeseStage) state.getValue(STAGE);
		return stage.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE, CheeseStage.values()[meta]); 
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModBlocks.IRON_POT.getItemDropped(ModBlocks.IRON_POT.getDefaultState(), rand, fortune);
	}
}
