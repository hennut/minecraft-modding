package com.hennut.hennutsmod.blocks.pot;

import com.hennut.hennutsmod.blocks.BlockAdjustable;
import com.hennut.hennutsmod.blocks.BlockWithModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class PotBase extends BlockWithModel {
	
	public enum Pots {WOODEN_POT, CLAY_POT, IRON_POT}

	public PotBase(String name, Pots type) {
		super (
				name,
				(type == Pots.WOODEN_POT ? Material.WOOD : (type == Pots.CLAY_POT ? Material.CLAY : (type == Pots.IRON_POT ? Material.CLAY : Material.CLAY))),
				(type == Pots.WOODEN_POT ? SoundType.WOOD : (type == Pots.CLAY_POT ? SoundType.STONE : (type == Pots.IRON_POT ? SoundType.METAL : SoundType.STONE))),
				(type == Pots.WOODEN_POT ? 0.0f : (type == Pots.CLAY_POT ? 0.0f : (type == Pots.IRON_POT ? 1.0f : 0.0f))),
				5.0f,
				"",
				0,
				0,
				false,
				new AxisAlignedBB(0, 0, 0, 1, 1, 1)
			);
	}
}
