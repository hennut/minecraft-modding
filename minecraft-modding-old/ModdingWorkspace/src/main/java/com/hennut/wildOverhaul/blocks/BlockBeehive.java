package com.hennut.wildOverhaul.blocks;

import java.util.Random;

import com.hennut.wildOverhaul.Reference;
import com.hennut.wildOverhaul.WildOverhaul;
import com.hennut.wildOverhaul.init.ModItems;
import com.hennut.wildOverhaul.tileentity.TileEntityBeehive;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBeehive extends Block implements ITileEntityProvider{

	public BlockBeehive() {
		super(Material.WOOD);
		this.setTickRandomly(true);
		this.setUnlocalizedName(Reference.wildOverhaulBlocks.BEEHIVE.getUnlocalizedName());
		this.setRegistryName(Reference.wildOverhaulBlocks.BEEHIVE.getRegistryName());
		this.setCreativeTab(WildOverhaul.CREATIVE_TAB);
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
	
	//### Funktion ###
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY){
	    if(!worldIn.isRemote){
			TileEntity entity = worldIn.getTileEntity(pos);
	    	if(entity instanceof TileEntityBeehive){
	    		TileEntityBeehive beehiveEntity = (TileEntityBeehive) entity;
	    		if(beehiveEntity.removeHoney()){
	    			return true;
	    		}
	    		if(playerIn.getHeldItem(hand).getItem() == ModItems.queenBee && beehiveEntity.addQueenBee()){
	    			playerIn.getHeldItem(hand).func_190917_f(-1);//remove one item!!
	    			return true;
	    		}
	    	}
	    }
    	return false;
    }
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		super.randomTick(worldIn, pos, state, random);
		
		if(!worldIn.isRemote){
			TileEntity entity = worldIn.getTileEntity(pos);
	    	if(entity instanceof TileEntityBeehive){
	    		TileEntityBeehive beehiveEntity = (TileEntityBeehive) entity;
	    		beehiveEntity.addHoney();
	    	}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBeehive();
	}
}
