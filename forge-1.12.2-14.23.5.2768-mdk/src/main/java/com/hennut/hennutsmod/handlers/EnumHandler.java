package com.hennut.hennutsmod.handlers;

import net.minecraft.util.IStringSerializable;

/**
 * Handles all of our enums which me use for meta data blocks and items
 * 
 * @author CJMinecraft
 *
 */
public class EnumHandler {

	/**
	 * This is used by the {@link BlockBreaker} and the {@link ItemChip}
	 * 
	 * @author CJMinecraft
	 *
	 */
	public static enum CheeseStage implements IStringSerializable {
		ZERO("zero", 0), ONE("one", 1), BUTTER("butter", 2), THREE("three", 3), FOUR("four", 4), FIFE("fife", 5), CHEESE("cheese", 6);

		private int ID;
		private String name;

		private CheeseStage(String name, int ID) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public int getID() {
			return ID;
		}

		@Override
		public String toString() {
			return getName();
		}

	}
}