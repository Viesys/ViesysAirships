package com.viesys.viesysairships.client.gui;

import org.lwjgl.input.Keyboard;

import com.viesys.viesysairships.api.References;
import com.viesys.viesysairships.api.util.LogHelper;
import com.viesys.viesysairships.configs.ViesCraftConfig;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigGui extends GuiConfig {
	
	public ConfigGui(GuiScreen screen) 
	{
		super(screen, new ConfigElement(ViesCraftConfig.config.getCategory(ViesCraftConfig.CATEGORY_VC)).getChildElements(), References.MOD_NAME, true, true, GuiConfig.getAbridgedConfigPath(ViesCraftConfig.config.toString()));
	}
	
	@Override
	public void onGuiClosed()
	{
		this.entryList.onGuiClosed();
		
		if(this.configID != null && this.parentScreen instanceof GuiConfig)
		{
			GuiConfig parentGuiConfig = (GuiConfig) this.parentScreen;
			parentGuiConfig.needsRefresh = true;
			parentGuiConfig.initGui();
		}
		
		if(!(this.parentScreen instanceof GuiConfig))
		{
			Keyboard.enableRepeatEvents(false);
		}
		
		ViesCraftConfig.config.save();
		ViesCraftConfig.config.load();
		LogHelper.info("Configuration saved.");
	}
}
