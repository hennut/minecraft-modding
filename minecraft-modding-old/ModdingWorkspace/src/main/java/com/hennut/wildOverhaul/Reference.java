package com.hennut.wildOverhaul;

public class Reference {
    public static final String MODID = "hwo";
    public static final String NAME = "Hennuts Wild Overhaul";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_MINECRAFT_VERSION = "1.11";
    
    public static final String CLIENT_PROXY_CLASS = "com.hennut.wildOverhaul.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.hennut.wildOverhaul.proxy.ServerProxy";
    
    public static enum wildOverhaulItems{
    	HONEY("honey", "ItemHoney"),
    	QUEEN_BEE("queenBee", "ItemQueenBee");
    	
    	private String unlocalizedName, registryName;
    	
    	wildOverhaulItems(String unlocalizedName, String registryName){
    		this.unlocalizedName = unlocalizedName;
    		this.registryName = registryName;
    	}
    	
    	public String getUnlocalizedName(){
    		return unlocalizedName;
    	}
    	
    	public String getRegistryName(){
    		return registryName;
    	}
    }
    
    public static enum wildOverhaulBlocks{
    	BEEHIVE("beehive", "BlockBeehive"),
    	BEENEST("beenest", "BlockBeenest"),
    	STOOL("stool", "BlockStool"),
    	TABLE("table", "BlockTable");

    	private String unlocalizedName, registryName;
    	
    	wildOverhaulBlocks(String unlocalizedName, String registryName){
    		this.unlocalizedName = unlocalizedName;
    		this.registryName = registryName;
    	}
    	
    	public String getUnlocalizedName(){
    		return unlocalizedName;
    	}
    	
    	public String getRegistryName(){
    		return registryName;
    	}
    }
}
