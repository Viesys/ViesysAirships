package com.vies.viesmachines.client.gui;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.configs.VMConfiguration;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigGui extends GuiConfig {
	
	public ConfigGui(GuiScreen screen) 
	{
		super(screen, new ConfigElement(VMConfiguration.config.getCategory(VMConfiguration.CATEGORY_VM)).getChildElements(), References.MOD_NAME, true, true, GuiConfig.getAbridgedConfigPath(VMConfiguration.config.toString()));
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
		
		VMConfiguration.config.save();
		VMConfiguration.config.load();
		LogHelper.info("Configuration saved.");
	}
}
