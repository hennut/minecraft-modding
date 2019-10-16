package com.hennut.wildOverhaul.proxy;

import com.hennut.wildOverhaul.init.ModBlocks;
import com.hennut.wildOverhaul.init.ModItems;

public class ClientProxy implements CommonProxy{

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}

}
