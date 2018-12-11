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
	
	public static enum BeehiveStage implements IStringSerializable {
		UNFILLED("unfilled", 0), ONE("one", 1), TWO("two", 2), THREE("three", 3), FOUR("four", 4);

		private int ID;
		private String name;

		private BeehiveStage(String name, int ID) {
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
	
	public static enum CropAge implements IStringSerializable {
		ZERO("ZERO", 0), ONE("one", 1), TWO("two", 2), THREE("three", 3), FOUR("four", 4), FIVE("five", 5), SIX("six", 6), SEVEN("seven", 7);

		private int ID;
		private String name;

		private CropAge(String name, int ID) {
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