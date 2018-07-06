package com.vies.viesmachines.proxy;

import java.util.ArrayList;
import java.util.Collections;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.client.InitEntityVCRender;
import com.vies.viesmachines.client.InitTileEntityVCRender;
import com.vies.viesmachines.client.gui.machines.GuiMachineHUD;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.animation.AnimationModelBase;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	/** The initial array that collects all registered music. Used to move records only to the musicListRecord array. Cleared after musicListRecord is created. */
    public static ArrayList<ResourceLocation> musicListFull = new ArrayList<ResourceLocation>();
	/** MAIN ARRAY - A collection of all records from all mods. Only pulls anything with 'record.' in the name. */
    public static ArrayList<ResourceLocation> musicListRecord = new ArrayList<ResourceLocation>();
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
		
		//Allows the loading of .obj files
		OBJLoader.INSTANCE.addDomain(References.MOD_ID.toLowerCase());
		AnimationModelBase test;
		//InitSoundEventsVC.registerSounds();
		//InitItemsVCRender.registerItemRender();
		//InitBlocksVCRender.registerBlockRender();
		InitEntityVCRender.registerEntityRender();
		InitTileEntityVCRender.registerTileEntityRender();
		
		Keybinds.init();
		//NetworkHandler.preInitClient();
		//InitItemsVCRender.registerItemRenderTEMP();
		//InitBlocksVCRender.registerBlockRenderTEMP();
		//InitEntityVCRender.registerEntityRenderTEMP();
		//InitTileEntityVCRender.registerTileEntityRenderTEMP();
	}
	
	@Override
	public void init(FMLInitializationEvent event) 
	{
		super.init(event);
		
		MinecraftForge.EVENT_BUS.register(new GuiMachineHUD());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) 
	{
		super.postInit(event);
		
		this.setupMusic();
	}
	

	
	/**
	 * Creates the initial music record array upon spawning.
	 * NOTE: Moved to ClientProxy.postInit for efficiency and syncing.
	 */
	private void setupMusic() 
	{
		musicListFull.clear();
        musicListRecord.clear();
        
        musicListFull.addAll(SoundEvent.REGISTRY.getKeys());
		
		for(int i = 0; i < musicListFull.size(); i++)
		{
			if(musicListFull.get(i).toString().toLowerCase().contains("record.".toLowerCase()))
		    {
				musicListRecord.add(musicListFull.get(i));
		    }
		}
		
		musicListFull.clear();
        
		Collections.sort(musicListRecord);
	}
}
