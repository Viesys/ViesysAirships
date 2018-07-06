package com.vies.viesmachines.proxy;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.utils.events.EventHandlerAirship;
import com.vies.viesmachines.common.utils.events.EventHandlerConfig;
import com.vies.viesmachines.init.InitEntityVC;
import com.vies.viesmachines.network.GuiHandler;
import com.vies.viesmachines.network.NetworkHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) 
	{
		//SoundEventsEA.registerSounds();
		
		//InitItemsVC.registerItem();
		//InitBlocksVC.registerBlock();
		//InitTileEntitiesVC.registerTileEntity();
		InitEntityVC.registerEntity();
		
		NetworkHandler.preInit();
		
		//InitItemsVC.registerItemTEMP();
		//InitBlocksVC.registerBlockTEMP();
		//InitTileEntitiesVC.registerTileEntityTEMP();
		//InitEntityVC.registerEntityTEMP();
	}
	
	public void init(FMLInitializationEvent event) 
	{
		//InitRecipesVC.initShapedRecipe();
		//InitAchievementsVC.init();
		
		//MinecraftForge.EVENT_BUS.register(new AchievementTriggersVC());
		//MinecraftForge.EVENT_BUS.register(new EventHandlerAchievement());
		MinecraftForge.EVENT_BUS.register(new EventHandlerConfig());
		MinecraftForge.EVENT_BUS.register(new EventHandlerAirship());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(References.MOD_ID, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		//ResourceLocation group = null;
		
		//GameRegistry.addShapedRecipe(new ResourceLocation(References.MOD_ID + ":recipes/airship_balloon"), 
		//		group, 
		//		new ItemStack(InitItemsVC.AIRSHIP_BALLOON, 1), 
		//		new Object[]{"LLL", "L#L", "LLL", 'L', Items.LEATHER, '#', Items.STRING}
		//);
		
		//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.viesoline_pellets), new ItemStack(Items.COAL), new ItemStack(Items.REDSTONE));
		
		//RecipeRemoverVC.removeRecipe();
	}
}
