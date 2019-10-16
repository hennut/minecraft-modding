package com.hennut.hennutsmod.util.handlers;

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
		ZERO("zero", 0), ONE("one", 1), TWO("two", 2), THREE("three", 3), FOUR("four", 4), FIVE("five", 5), SIX("six", 6), SEVEN("seven", 7);

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
	
	public static enum TableDirection implements IStringSerializable {
		NONE("none", 0), ALL("all", 1), N("n", 2), S("s", 3), W("w", 4), E("e", 5), NW("nw", 6), NE("ne", 7), SW("sw", 8), SE("se", 9);

		private int ID;
		private String name;

		private TableDirection(String name, int ID) {
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
	
	public static enum Status implements IStringSerializable {
		OFF("off", 0), ON("on", 1);

		private int ID;
		private String name;

		private Status(String name, int ID) {
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