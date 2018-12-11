package com.hennut.hennutsmod.init;

import com.hennut.hennutsmod.util.creativetabs.CropTab;
import com.hennut.hennutsmod.util.creativetabs.DebugTab;
import com.hennut.hennutsmod.util.creativetabs.ToolTab;
import com.hennut.hennutsmod.util.creativetabs.NatureTab;
import com.hennut.hennutsmod.util.creativetabs.PotTab;

import net.minecraft.creativetab.CreativeTabs;

public class ModTabs {

	public static CreativeTabs debugTab = new DebugTab();
	public static CreativeTabs potTab = new PotTab();
	public static CreativeTabs toolTab = new ToolTab();
	public static CreativeTabs cropTab = new CropTab();
	public static CreativeTabs natureTab = new NatureTab();
}
