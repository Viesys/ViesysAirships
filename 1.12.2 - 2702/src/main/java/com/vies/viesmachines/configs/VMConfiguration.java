package com.vies.viesmachines.configs;

import java.io.File;

import com.vies.viesmachines.api.util.LogHelper;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Configuration;

public class VMConfiguration {
	
	public static Configuration config;
	public static final String CATEGORY_VM = "Vies Machines Configuration";
	/**
	public static boolean v1AirshipEnabled;
	public static boolean v2AirshipEnabled;
	public static boolean v3AirshipEnabled;
	
	public static boolean v4AirshipEnabled;
	public static boolean v5AirshipEnabled;
	public static boolean v6AirshipEnabled;
	
	public static int v1AirshipSpeed;
	public static int v2AirshipSpeed;
	public static int v3AirshipSpeed;
	
	public static int v4AirshipSpeed;
	public static int v5AirshipSpeed;
	public static int v6AirshipSpeed;
	*/
	public static boolean vanillaFuel;
	public static boolean outsideModFuel;
	public static int machinePelletsBurnTime;
	/**
	public static String v1AirshipName;
	public static String v2AirshipName;
	public static String v3AirshipName;
	
	public static String v4AirshipName;
	public static String v5AirshipName;
	public static String v6AirshipName;
	*/
	public static boolean recipeDismounterPlayer;
	public static boolean engineSounds;
	public static boolean renderNameplates;
	/**
	public static final boolean V1AIRSHIPENABLED_DEFAULT = true;
	public static final String V1AIRSHIPENABLED_NAME = "Enable V1 Viesdenburg Airships?";
	public static final String V1AIRSHIPENABLED_COMMENT = "Should Viesdenburg airships be globally enabled?";
	public static final boolean V2AIRSHIPENABLED_DEFAULT = true;
	public static final String V2AIRSHIPENABLED_NAME = "Enable V2 Viesigible Airships?";
	public static final String V2AIRSHIPENABLED_COMMENT = "Should Viesigible airships be globally enabled?";
	public static final boolean V3AIRSHIPENABLED_DEFAULT = true;
	public static final String V3AIRSHIPENABLED_NAME = "Enable V3 Viesepelin Airships?";
	public static final String V3AIRSHIPENABLED_COMMENT = "Should Viesepelin airships be globally enabled?";
	
	public static final boolean V4AIRSHIPENABLED_DEFAULT = true;
	public static final String V4AIRSHIPENABLED_NAME = "Enable V4 Viesakron Airships?";
	public static final String V4AIRSHIPENABLED_COMMENT = "Should Viesakron airships be globally enabled?";
	public static final boolean V5AIRSHIPENABLED_DEFAULT = true;
	public static final String V5AIRSHIPENABLED_NAME = "Enable V5 Viesindus Airships?";
	public static final String V5AIRSHIPENABLED_COMMENT = "Should Viesindus airships be globally enabled?";
	public static final boolean V6AIRSHIPENABLED_DEFAULT = true;
	public static final String V6AIRSHIPENABLED_NAME = "Enable V6 Viesamune Airships?";
	public static final String V6AIRSHIPENABLED_COMMENT = "Should Viesamune airships be globally enabled?";
	
	public static final int V1AIRSHIPSPEED_DEFAULT = 100;
	public static final String V1AIRSHIPSPEED_NAME = "Airship Speed - Viesdenburg";
	public static final String V1AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	public static final int V2AIRSHIPSPEED_DEFAULT = 100;
	public static final String V2AIRSHIPSPEED_NAME = "Airship Speed - Viesigible";
	public static final String V2AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	public static final int V3AIRSHIPSPEED_DEFAULT = 100;
	public static final String V3AIRSHIPSPEED_NAME = "Airship Speed - Viesepelin";
	public static final String V3AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	
	public static final int V4AIRSHIPSPEED_DEFAULT = 100;
	public static final String V4AIRSHIPSPEED_NAME = "Airship Speed - Viesakron";
	public static final String V4AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	public static final int V5AIRSHIPSPEED_DEFAULT = 100;
	public static final String V5AIRSHIPSPEED_NAME = "Airship Speed - Viesindus";
	public static final String V5AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	public static final int V6AIRSHIPSPEED_DEFAULT = 100;
	public static final String V6AIRSHIPSPEED_NAME = "Airship Speed - Viesamune";
	public static final String V6AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	
	public static final String V1AIRSHIPNAME_DEFAULT = "Viesdenburg";
	public static final String V1AIRSHIPNAME_NAME = "Airship Name - Viesdenburg";
	public static final String V1AIRSHIPNAME_COMMENT = "Change the name of Viesdenburg Airships?";
	public static final String V2AIRSHIPNAME_DEFAULT = "Viesigible";
	public static final String V2AIRSHIPNAME_NAME = "Airship Name - Viesigible";
	public static final String V2AIRSHIPNAME_COMMENT = "Change the name of Viesigible Airships?";
	public static final String V3AIRSHIPNAME_DEFAULT = "Viesepelin";
	public static final String V3AIRSHIPNAME_NAME = "Airship Name - Viesepelin";
	public static final String V3AIRSHIPNAME_COMMENT = "Change the name of Viespelin Airships?";
	
	public static final String V4AIRSHIPNAME_DEFAULT = "Viesakron";
	public static final String V4AIRSHIPNAME_NAME = "Airship Name - Viesakron";
	public static final String V4AIRSHIPNAME_COMMENT = "Change the name of Viesakron Airships?";
	public static final String V5AIRSHIPNAME_DEFAULT = "Viesindus";
	public static final String V5AIRSHIPNAME_NAME = "Airship Name - Viesindus";
	public static final String V5AIRSHIPNAME_COMMENT = "Change the name of Viesindus Airships?";
	public static final String V6AIRSHIPNAME_DEFAULT = "Viesamune";
	public static final String V6AIRSHIPNAME_NAME = "Airship Name - Viesamune";
	public static final String V6AIRSHIPNAME_COMMENT = "Change the name of Viesamune Airships?";
	*/
	public static final boolean VANILLAFUEL_DEFAULT = true;
	public static final String VANILLAFUEL_NAME = "Enable using vanilla fuel?";
	public static final String VANILLAFUEL_COMMENT = "Should airships be able to use vanilla fuel?";
	
	public static final boolean OUTSIDEMODFUEL_DEFAULT = true;
	public static final String OUTSIDEMODFUEL_NAME = "Enable using other mod's fuel?";
	public static final String OUTSIDEMODFUEL_COMMENT = "Should airships be able to use other mod's fuel?";
	
	public static final int MACHINEPELLETSBURNTIME_DEFAULT = 60;
	public static final String MACHINEPELLETSBURNTIME_NAME = "Machine Pellets Burn Time?";
	public static final String MACHINEPELLETSBURNTIME_COMMENT = "How long does Machine Pellets burn for in seconds? ";

	public static final boolean RECIPEDISMOUNTERPLAYER_DEFAULT = true;
	public static final String RECIPEDISMOUNTERPLAYER_NAME = "Enable Player Dismounter Recipe?";
	public static final String RECIPEDISMOUNTERPLAYER_COMMENT = "Should Player Dismounter be craftable?";

	public static final boolean ENGINESOUND_DEFAULT = true;
	public static final String ENGINESOUND_NAME = "Enable airship engine sounds?";
	public static final String ENGINESOUND_COMMENT = "Should airships have engine sounds when powered?";
	
	public static final boolean RENDERNAMEPLATES_DEFAULT = true;
	public static final String RENDERNAMEPLATES_NAME = "Enable airship overhead nameplates?";
	public static final String RENDERNAMEPLATES_COMMENT = "Should airships display their overhead nameplates?";
	
	public static void init(File file)
	{
		config = new Configuration(file);
		syncConfig();
		LogHelper.info("Good news everyone! The config has been loaded!");
	}
	
	public static void syncConfig()
	{
		//Main settings
		//final String category1 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.LIGHT_PURPLE + "Global";
		//config.addCustomCategoryComment(category1, "Global Airship settings.");
		
		//v1AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V1AIRSHIPENABLED_NAME, category1, V1AIRSHIPENABLED_DEFAULT, V1AIRSHIPENABLED_COMMENT);
		//v2AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V2AIRSHIPENABLED_NAME, category1, V2AIRSHIPENABLED_DEFAULT, V2AIRSHIPENABLED_COMMENT);
		//v3AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V3AIRSHIPENABLED_NAME, category1, V3AIRSHIPENABLED_DEFAULT, V3AIRSHIPENABLED_COMMENT);
		
		//v4AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V4AIRSHIPENABLED_NAME, category1, V4AIRSHIPENABLED_DEFAULT, V4AIRSHIPENABLED_COMMENT);
		///////v5AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V5AIRSHIPENABLED_NAME, category1, V5AIRSHIPENABLED_DEFAULT, V5AIRSHIPENABLED_COMMENT);
		///////v6AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V6AIRSHIPENABLED_NAME, category1, V6AIRSHIPENABLED_DEFAULT, V6AIRSHIPENABLED_COMMENT);
		
		//General settings
		final String category2 = CATEGORY_VM + config.CATEGORY_SPLITTER + TextFormatting.GREEN + "General";
		config.addCustomCategoryComment(category2, "General airship options.");
		
		//v1AirshipSpeed = config.getInt(TextFormatting.WHITE + V1AIRSHIPSPEED_NAME, category2, V1AIRSHIPSPEED_DEFAULT, 100, 400, V1AIRSHIPSPEED_COMMENT);
		//v2AirshipSpeed = config.getInt(TextFormatting.WHITE + V2AIRSHIPSPEED_NAME, category2, V2AIRSHIPSPEED_DEFAULT, 100, 400, V2AIRSHIPSPEED_COMMENT);
		//v3AirshipSpeed = config.getInt(TextFormatting.WHITE + V3AIRSHIPSPEED_NAME, category2, V3AIRSHIPSPEED_DEFAULT, 100, 400, V3AIRSHIPSPEED_COMMENT);
		
		//v4AirshipSpeed = config.getInt(TextFormatting.WHITE + V4AIRSHIPSPEED_NAME, category2, V4AIRSHIPSPEED_DEFAULT, 100, 400, V4AIRSHIPSPEED_COMMENT);
		///////v5AirshipSpeed = config.getInt(TextFormatting.WHITE + V5AIRSHIPSPEED_NAME, category2, V5AIRSHIPSPEED_DEFAULT, 100, 400, V5AIRSHIPSPEED_COMMENT);
		///////v6AirshipSpeed = config.getInt(TextFormatting.WHITE + V6AIRSHIPSPEED_NAME, category2, V6AIRSHIPSPEED_DEFAULT, 100, 400, V6AIRSHIPSPEED_COMMENT);
		
		recipeDismounterPlayer = config.getBoolean(TextFormatting.WHITE + RECIPEDISMOUNTERPLAYER_NAME, category2, RECIPEDISMOUNTERPLAYER_DEFAULT, RECIPEDISMOUNTERPLAYER_COMMENT);
		
		//Fuel settings
		final String category3 = CATEGORY_VM + config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Fuel";
		config.addCustomCategoryComment(category3, "Airship fuel options.");
		
		vanillaFuel = config.getBoolean(TextFormatting.WHITE + VANILLAFUEL_NAME, category3, VANILLAFUEL_DEFAULT, VANILLAFUEL_COMMENT);
		outsideModFuel = config.getBoolean(TextFormatting.WHITE + OUTSIDEMODFUEL_NAME, category3, OUTSIDEMODFUEL_DEFAULT, OUTSIDEMODFUEL_COMMENT);
		
		machinePelletsBurnTime = config.getInt(TextFormatting.WHITE + MACHINEPELLETSBURNTIME_NAME, category3, MACHINEPELLETSBURNTIME_DEFAULT, 1, 500, MACHINEPELLETSBURNTIME_COMMENT);
		
		//General settings
		final String category4 = CATEGORY_VM + config.CATEGORY_SPLITTER + TextFormatting.GOLD + "Client";
		config.addCustomCategoryComment(category4, "Client airship options.");

		//v1AirshipName = config.getString(TextFormatting.WHITE + V1AIRSHIPNAME_NAME, category4, V1AIRSHIPNAME_DEFAULT, V1AIRSHIPNAME_COMMENT);
		//v2AirshipName = config.getString(TextFormatting.WHITE + V2AIRSHIPNAME_NAME, category4, V2AIRSHIPNAME_DEFAULT, V2AIRSHIPNAME_COMMENT);
		//v3AirshipName = config.getString(TextFormatting.WHITE + V3AIRSHIPNAME_NAME, category4, V3AIRSHIPNAME_DEFAULT, V3AIRSHIPNAME_COMMENT);
		
		//v4AirshipName = config.getString(TextFormatting.WHITE + V4AIRSHIPNAME_NAME, category4, V4AIRSHIPNAME_DEFAULT, V4AIRSHIPNAME_COMMENT);
		///////v5AirshipName = config.getString(TextFormatting.WHITE + V5AIRSHIPNAME_NAME, category4, V5AIRSHIPNAME_DEFAULT, V5AIRSHIPNAME_COMMENT);
		///////v6AirshipName = config.getString(TextFormatting.WHITE + V6AIRSHIPNAME_NAME, category4, V6AIRSHIPNAME_DEFAULT, V6AIRSHIPNAME_COMMENT);
		
		engineSounds = config.getBoolean(TextFormatting.WHITE + ENGINESOUND_NAME, category4, ENGINESOUND_DEFAULT, ENGINESOUND_COMMENT);
		renderNameplates = config.getBoolean(TextFormatting.WHITE + RENDERNAMEPLATES_NAME, category4, RENDERNAMEPLATES_DEFAULT, RENDERNAMEPLATES_COMMENT);
		
		//Save the config
		config.save();
		config.load();
	}
}
