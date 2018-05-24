package com.viesys.viesysmachines;

import java.io.File;

import com.viesys.viesysmachines.api.References;
import com.viesys.viesysmachines.api.creative.VCTabBlocks;
import com.viesys.viesysmachines.api.creative.VCTabItems;
import com.viesys.viesysmachines.api.util.LogHelper;
import com.viesys.viesysmachines.configs.ViesCraftConfig;
import com.viesys.viesysmachines.proxy.CommonProxy;

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

public class ViesysMachines {
    
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	public static final VCTabItems tabViesCraftItems = new VCTabItems("tabViesCraftItems");
	public static final VCTabBlocks tabViesCraftBlocks = new VCTabBlocks("tabViesCraftBlocks");
	
	private static File configDir;
	
	@Mod.Instance(References.MOD_ID)
	public static ViesysMachines instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(instance);
		
		configDir = new File(event.getModConfigurationDirectory() + "/" + References.MOD_ID);
		configDir.mkdirs();
		ViesCraftConfig.init(new File(configDir.getPath(), References.MOD_ID + ".cfg"));
		
		this.proxy.preInit(event);
		LogHelper.info("<<==============================>>");
		LogHelper.info("        Pre Init Complete.        ");
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
