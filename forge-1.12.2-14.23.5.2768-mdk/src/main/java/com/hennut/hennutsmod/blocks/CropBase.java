package com.hennut.hennutsmod.blocks;

import java.util.Random;

import com.hennut.hennutsmod.init.ModItems;
import com.hennut.hennutsmod.util.domestication.Domestication;
import com.hennut.hennutsmod.util.domestication.Domestication.PLANT_TYPES;
import com.hennut.hennutsmod.util.handlers.EnumHandler.CropAge;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class CropBase extends BlockWithModel {

	public static final PropertyEnum PLANT_AGE = PropertyEnum.create("age", CropAge.class);
	
	private CropAge maxAge;
	private PLANT_TYPES type;
	
	public CropBase(String name, CropAge maxAge, PLANT_TYPES type) {
		super(name, Material.PLANTS, SoundType.PLANT, 0.5f, 1.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
		this.maxAge = maxAge;
	}
	
	public CropBase(String name, Material material, SoundType soundType, CropAge maxAge, PLANT_TYPES type) {
		super(name, material, soundType, 0.5f, 1.0f, "", 0, 0, false, new AxisAlignedBB(0, 0, 0, 1, 1, 1));
		this.maxAge = maxAge;
		this.type = type;
	}
	
	public CropBase(String name, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel, int lightLevel, boolean unbreakable, AxisAlignedBB aabb, CropAge maxAge, PLANT_TYPES type) {
		super(name, material, soundType, hardness, resistance, tool, harvestLevel, lightLevel, unbreakable, aabb);
		this.maxAge = maxAge;
		this.type = type;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(getMetaFromState(state) >= maxAge.getID() - 1){
			int count = getMetaFromState(state) - maxAge.getID() + 2;
			worldIn.setBlockState(pos, state.withProperty(PLANT_AGE, CropAge.TWO));
			dropFruit(worldIn, pos, count, new Random());
			dropVariants(worldIn, pos, count, new Random());
			return true;
		}
		
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return (this.GetSeed () != null ? this.GetSeed () : this.GetFruit ());
	}
	
	private void dropFruit(World worldIn, BlockPos pos, int count, Random random) {
		EntityItem seeds, fruits;

		if(this.GetSeed () != null){
			seeds = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.GetSeed (), count + 1 + random.nextInt(2)));
			worldIn.spawnEntity(seeds);
		}
		fruits = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.GetFruit (), count + random.nextInt(2)));
		worldIn.spawnEntity(fruits);
	}
	
	private void dropVariants(World worldIn, BlockPos pos, int count, Random random) {
		if(random.nextInt(100) > 89){ // 10% drop
			EntityItem seeds = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Domestication.GET_PLANT_DROP(type, random), 1));
			worldIn.spawnEntity(seeds);
		}
		
		if(random.nextInt(100) > 94){ // 5% drop
			EntityItem seeds = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Domestication.GET_PLANT_DROP(type, random), 1));
			worldIn.spawnEntity(seeds);
		}
	}
	
	protected abstract Item GetSeed () ;
	
	protected abstract Item GetFruit () ;

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(getMetaFromState(worldIn.getBlockState(pos)) != maxAge.getID()){
			worldIn.setBlockState(pos, state.cycleProperty(PLANT_AGE));
		}
		
		super.updateTick(worldIn, pos, state, rand);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {PLANT_AGE});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		CropAge age = (CropAge) state.getValue(PLANT_AGE);
		return age.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(PLANT_AGE, CropAge.values()[meta]); 
	}
}
