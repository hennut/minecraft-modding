package com.hennut.hennutsmod.blocks.cheesemaker;

import com.hennut.hennutsmod.blocks.BlockWithModel;
import com.hennut.hennutsmod.handlers.EnumHandler.CheeseStage;
import com.hennut.hennutsmod.init.ModBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
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
		super(name, Material.IRON, SoundType.SLIME, 1.0f, 15.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
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
		if(worldIn.getBlockState(pos).getValue(STAGE) == CheeseStage.BUTTER){
			return true;
		}else if(worldIn.getBlockState(pos).getValue(STAGE) == CheeseStage.CHEESE){
			return true;
		}
		worldIn.setBlockState(pos, ModBlocks.IRON_POT.getDefaultState());
		return false;
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
}
