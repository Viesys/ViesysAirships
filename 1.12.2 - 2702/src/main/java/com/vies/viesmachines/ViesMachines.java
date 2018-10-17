package com.vies.viesmachines;

import java.io.File;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.creative.BlocksTab;
import com.vies.viesmachines.api.creative.ItemsTab;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.configs.VMConfiguration;
import com.vies.viesmachines.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = References.MOD_ID, 
		name = References.MOD_NAME, 
		version = References.VERSION, 
		guiFactory = References.CONFIG_GUI,
		acceptedMinecraftVersions = References.ACCEPTED_MINECRAFT_VERSIONS
		)

public class ViesMachines {
    
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	public static final ItemsTab tabItems = new ItemsTab("tabItems");
	public static final BlocksTab tabBlocks = new BlocksTab("tabBlocks");
	
	private static File configDir;
	
	@Mod.Instance(References.MOD_ID)
	public static ViesMachines instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(instance);
		
		configDir = new File(event.getModConfigurationDirectory() + "/" + References.MOD_ID);
		configDir.mkdirs();
		VMConfiguration.init(new File(configDir.getPath(), References.MOD_ID + ".cfg"));
		
		this.proxy.preInit(event);
		LogHelper.info("<<==============================>>");
		LogHelper.info("        Pre-Init Complete.        ");
		LogHelper.info("<<==============================>>");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		this.proxy.init(event);
		LogHelper.info("<<==============================>>");
		LogHelper.info("          Init Complete.          ");
		LogHelper.info("<<==============================>>");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		this.proxy.postInit(event);
		LogHelper.info("<<==============================>>");
		LogHelper.info("   Enforcing Brannigan's Law...   ");
		LogHelper.info("<<==============================>>");
	}
}
