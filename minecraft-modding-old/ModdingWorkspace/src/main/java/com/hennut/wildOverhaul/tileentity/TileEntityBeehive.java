package com.hennut.wildOverhaul.tileentity;

import com.hennut.wildOverhaul.init.ModItems;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBeehive extends TileEntity {
	
	private int honeyCounter = -1;

	public boolean addHoney(){
		if(!worldObj.isRemote){
			if(honeyCounter < 8 && honeyCounter > -1){
				honeyCounter ++;
				return true;
			}
		}
		return false;
	}
	
	public boolean addQueenBee(){
		if(!worldObj.isRemote){
			if(honeyCounter <= -1){
				honeyCounter = 0;
				return true;
			}
		}
		return false;
	}
	
	public boolean removeHoney(){
		if(!worldObj.isRemote){
			if(honeyCounter > 0){
				worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX(), pos.getY() + 1.0, pos.getZ(), new ItemStack(ModItems.honey, honeyCounter)));
				honeyCounter = 0;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setInteger("honeyCounter", honeyCounter);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		this.honeyCounter = compound.getInteger("honeyCounter");
	}
}
