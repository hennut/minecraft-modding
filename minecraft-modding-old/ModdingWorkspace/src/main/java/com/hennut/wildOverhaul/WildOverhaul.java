package com.hennut.wildOverhaul;

import com.hennut.wildOverhaul.init.ModBlocks;
import com.hennut.wildOverhaul.init.ModCrafting;
import com.hennut.wildOverhaul.init.ModItems;
import com.hennut.wildOverhaul.init.ModTab;
import com.hennut.wildOverhaul.proxy.CommonProxy;
import com.hennut.wildOverhaul.tileentity.TileEntityBeehive;
import com.hennut.wildOverhaul.worldgen.ModWorldGenerator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSION)
public class WildOverhaul{
    
	@Instance
	public static WildOverhaul instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs CREATIVE_TAB = new ModTab();
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	System.out.println("pre Init");

    	ModItems.init();
    	ModItems.register();
    	
    	ModBlocks.init();
    	ModBlocks.register();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	System.out.println("Init");
    	
    	proxy.init();
    	ModCrafting.register();
    	
    	GameRegistry.registerTileEntity(TileEntityBeehive.class, Reference.MODID + "TileEntityBeehive");
    	GameRegistry.registerWorldGenerator(new ModWorldGenerator(), 0);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	System.out.println("post Init");
    }
}