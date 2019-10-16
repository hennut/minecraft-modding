package com.hennut.hennutsmod;

import org.apache.logging.log4j.Logger;

import com.hennut.hennutsmod.proxy.CommonProxy;
import com.hennut.hennutsmod.util.Reference;
import com.hennut.hennutsmod.util.handlers.RegistryHandler;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class HennutsMod {
	
    @Instance
    public static HennutsMod instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event){
    	RegistryHandler.registerGenerators();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event){
    }
    
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event){
    }
}
