package com.hennut.wildOverhaul.blocks;

import java.util.List;
import java.util.Random;

import com.hennut.wildOverhaul.Reference;
import com.hennut.wildOverhaul.WildOverhaul;
import com.hennut.wildOverhaul.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBeenest extends Block {

	public BlockBeenest() {
		super(Material.WEB);
		this.setUnlocalizedName(Reference.wildOverhaulBlocks.BEENEST.getUnlocalizedName());
		this.setRegistryName(Reference.wildOverhaulBlocks.BEENEST.getRegistryName());
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
	
	@Override	//TODO doesnt work
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
		Random rand = world instanceof World ? ((World)world).rand : RANDOM;

        int count = quantityDropped(state, fortune, rand);
        for(int i = 0; i < count; i++){
            Item item = ModItems.queenBee;	//inserted my item here
            if (item != Items.field_190931_a){
                ret.add(new ItemStack(item, 1));
            }
        }
        return ret;
	}
}
