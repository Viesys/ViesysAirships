package com.vies.viesmachines.api;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class References {
	
	public static final String MOD_ID = "viesmachines";
	
	public static final String MOD_NAME = "Vies Machines";
	public static final String MOD_VERSION_NUMBER = "0.6.7-alpha";
	public static final String MOD_VERSION_MC = "1.12.2";
	public static final String VERSION = MOD_VERSION_NUMBER + " - MC " + MOD_VERSION_MC;
	//public static final String website = "http://lycanitesmobs.com";
	//public static final String websiteAPI = "http://api.lycanitesmobs.com";
	//public static final String websitePatreon = "https://www.patreon.com/lycanite";
	public static final String ACCEPTED_MINECRAFT_VERSIONS = "[1.12,1.13]";
	
	public static final String CONFIG_GUI = "com.vies.viesmachines.api.gui.VCGuiFactory";
	public static final String CLIENT_PROXY_CLASS = "com.vies.viesmachines.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.vies.viesmachines.proxy.ServerProxy";
	
	public static Random random = new Random();
	
	
	
	public static final String CUSTOM_NAME_TAG = "CustomName";
	public static final String MACHINE_SLOTS_TAG = "Slots";
	
	public static final String POWERED_ON_TAG = "PoweredOn";
	public static final String TYPE_TAG = "Type";
	public static final String FORWARD_SPEED_TAG = "ForwardSpeed";
	public static final String TURN_SPEED_TAG = "TurnSpeed";
	
	public static final String HEALTH_TAG = "Health";
	public static final String ENERGY_TAG = "Energy";
	public static final String DURABILITY_TAG = "Durability";
	public static final String DURABILITY_PERCENT_TAG = "DurabilityPercent";
	
	public static final String BROKEN_TAG = "Broken";
	public static final String AUTORUN_TAG = "Autorun";
	public static final String ARMED_TAG = "Armed";
	public static final String AMMO_AMOUNT_TAG = "AmmoAmount";
	public static final String AMMO_TYPE_TAG = "AmmoType";
	public static final String SELECTED_SONG_TAG = "SelectedSong";
	
	public static final String FUEL_TAG = "Fuel";
	public static final String FUEL_TOTAL_TAG = "FuelTotal";
	public static final String ITEMSTACK_FUEL_ITEM_TAG = "ItemstackFuelItem";
	public static final String ITEMSTACK_FUEL_SIZE_TAG = "ItemstackFuelSize";
	public static final String STORED_MICRO_ENERGY_TAG = "StoredMicroEnergy";
	public static final String ENERGY_INCREASE_TAG = "EnergyIncrease";
	public static final String STORED_MICRO_DURABILITY_TAG = "StoredMicroDurability";
	public static final String DURABILITY_DECREASE_TAG = "DurabilityDecrease";
	
	public static final String TIER_FRAME_TAG = "TierFrame";
	public static final String TIER_ENGINE_TAG = "TierEngine";
	public static final String TIER_COMPONENT_TAG = "TierComponent";
	
	
	public static final String MACHINE_ENHANCEMENT_1_TAG = "MachineEnhancement1";
	
	public static final String PRIMED_FOR_LIGHTNING_STRIKE_TAG = "PrimedForLightningStrike";
	public static final String MACHINE_ISSUE_TAG = "MachineIssue";
	public static final String EVENT_TRIGGER_TAG = "EventTrigger";
	
	
	
	public static final String VISUAL_MODEL_FRAME_TAG = "VisualModelFrame";
	public static final String VISUAL_MODEL_ENGINE_TAG = "VisualModelEngine";
	public static final String VISUAL_MODEL_COMPONENT_TAG = "VisualModelComponent";
	
	public static final String VISUAL_FRAME_TEXTURE_TAG = "VisualFrameTexture";
	public static final String VISUAL_FRAME_TRANSPARENT_TAG = "VisualFrameTransparent";
	public static final String VISUAL_FRAME_COLOR_TAG = "VisualFrameColor";
	public static final String VISUAL_FRAME_COLOR_RED_TAG = "VisualFrameColorRed";
	public static final String VISUAL_FRAME_COLOR_GREEN_TAG = "VisualFrameColorGreen";
	public static final String VISUAL_FRAME_COLOR_BLUE_TAG = "VisualFrameColorBlue";
	
	public static final String VISUAL_ENGINE_PARTICLE_TAG = "VisualEngineParticle";
	public static final String VISUAL_ENGINE_DISPLAY_TYPE_TAG = "VisualEngineDisplayType";
	public static final String VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG = "VisualEngineDisplayItemstack";
	public static final String VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG = "VisualEngineDisplayItemstackMeta";
	public static final String VISUAL_ENGINE_DISPLAY_HEAD_TAG = "VisualEngineDisplayHead";
	public static final String VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG = "VisualEngineDisplaySupporterHead";
	public static final String VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG = "VisualEngineDisplayHoliday";
	
	public static final String VISUAL_COMPONENT_TEXTURE_TAG = "VisualComponentTexture";
	public static final String VISUAL_COMPONENT_TRANSPARENT_TAG = "VisualComponentTransparent";
	public static final String VISUAL_COMPONENT_COLOR_TAG = "VisualComponentColor";
	public static final String VISUAL_COMPONENT_COLOR_RED_TAG = "VisualComponentColorRed";
	public static final String VISUAL_COMPONENT_COLOR_GREEN_TAG = "VisualComponentColorGreen";
	public static final String VISUAL_COMPONENT_COLOR_BLUE_TAG = "VisualComponentColorBlue";
	
	public static final String VISUAL_NAME_COLOR_TAG = "VisualNameColor";
	
	/**
	//=============================
	public static final String CUSTOM_NAME_TAG = "CustomName";
	
	public static final String AIRSHIP_SLOTS_TAG = "Slots";
	
	public static final String MAIN_TIER_CORE_TAG = "TierCore";
	public static final String MAIN_TIER_FRAME_TAG = "TierFrame";
	public static final String MAIN_TIER_ENGINE_TAG = "TierEngine";
	public static final String MAIN_TIER_BALLOON_TAG = "TierBalloon";
	
	public static final String CORE_MODEL_VISUAL_FRAME_TAG = "CoreModelVisualFrame";
	public static final String CORE_MODEL_VISUAL_ENGINE_TAG = "CoreModelVisualEngine";
	public static final String CORE_MODEL_VISUAL_BALLOON_TAG = "CoreModelVisualBalloon";
	
	public static final String FRAME_SKIN_TEXTURE_TAG = "FrameSkinTexture";
	public static final String FRAME_SKIN_TRANSPARENT_TAG = "FrameSkinTransparent";
	public static final String FRAME_SKIN_COLOR_TAG = "FrameSkinColor";
	public static final String FRAME_SKIN_COLOR_RED_TAG = "FrameSkinColorRed";
	public static final String FRAME_SKIN_COLOR_GREEN_TAG = "FrameSkinColorGreen";
	public static final String FRAME_SKIN_COLOR_BLUE_TAG = "FrameSkinColorBlue";
	
	public static final String ENGINE_PARTICLE_VISUAL_TAG = "EngineParticleVisual";
	public static final String ENGINE_DISPLAY_TYPE_VISUAL_TAG = "EngineDisplayTypeVisual";
	public static final String ENGINE_DISPLAY_ITEMSTACK_VISUAL_TAG = "EngineDisplayItemstackVisual";
	public static final String ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_TAG = "EngineDisplayItemstackMetaVisual";
	public static final String ENGINE_DISPLAY_HEAD_VISUAL_TAG = "EngineDisplayHeadVisual";
	public static final String ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_TAG = "EngineDisplaySupporterHeadVisual";
	public static final String ENGINE_DISPLAY_HOLIDAY_VISUAL_TAG = "EngineDisplayHolidayVisual";
	
	public static final String BALLOON_PATTERN_TEXTURE_TAG = "BalloonPatternTexture";
	public static final String BALLOON_PATTERN_TRANSPARENT_TAG = "BalloonPatternTransparent";
	public static final String BALLOON_PATTERN_COLOR_TAG = "BalloonPatternColor";
	public static final String BALLOON_PATTERN_COLOR_RED_TAG = "BalloonPatternColorRed";
	public static final String BALLOON_PATTERN_COLOR_GREEN_TAG = "BalloonPatternColorGreen";
	public static final String BALLOON_PATTERN_COLOR_BLUE_TAG = "BalloonPatternColorBlue";
	
	//public static final String STORED_FUEL_TAG = "StoredFuel";
	//public static final String STORED_FUEL_TOTAL_TAG = "StoredFuelTotal";
	public static final String FUEL_ITEMSTACK_TAG = "FuelItemStack";
	public static final String FUEL_ITEMSTACK_SIZE_TAG = "FuelItemStackSize";
	public static final String STORED_REDSTONE_TAG = "StoredRedstone";
	public static final String STORED_REDSTONE_TOTAL_TAG = "StoredRestoneTotal";
	
	public static final String MODULE_ACTIVE_SLOT1_TAG = "ModuleActiveSlot1";
	public static final String JUKEBOX_SELECTED_SONG_TAG = "JukeboxSelectedSong";
	public static final String BOMB_ARMED_TAG = "BombArmed";
	public static final String BOMB_TYPE_1_TAG = "BombType1";
	public static final String BOMB_TYPE_2_TAG = "BombType2";
	public static final String BOMB_TYPE_3_TAG = "BombType3";
	public static final String BOMB_TYPE_ACTIVE_TAG = "BombTypeActive";
	
	public static final String LEARNED_MODULE_ALTITUDE_TAG = "LearnedModuleAltitude";
	public static final String SELECTED_MODULE_ALTITUDE_TAG = "SelectedModuleAltitude";
	public static final String LEARNED_MODULE_SPEED_TAG = "LearnedModuleSpeed";
	public static final String SELECTED_MODULE_SPEED_TAG = "SelectedModuleSpeed";
	public static final String LEARNED_MODULE_STORAGE_TAG = "LearnedModuleStorage";
	public static final String SELECTED_MODULE_STORAGE_TAG = "SelectedModuleStorage";
	public static final String LEARNED_MODULE_FUEL_TAG = "LearnedModuleFuel";
	public static final String SELECTED_MODULE_FUEL_TAG = "SelectedModuleFuel";
	public static final String LEARNED_MODULE_MUSIC_TAG = "LearnedModuleMusic";
	public static final String SELECTED_MODULE_MUSIC_TAG = "SelectedModuleMusic";
	public static final String LEARNED_MODULE_CRUISE_TAG = "LearnedModuleCruise";
	public static final String SELECTED_MODULE_CRUISE_TAG = "SelectedModuleCruise";
	public static final String LEARNED_MODULE_WATER_TAG = "LearnedModuleWater";
	public static final String SELECTED_MODULE_WATER_TAG = "SelectedModuleWater";
	public static final String LEARNED_MODULE_FUELINFINITE_TAG = "LearnedModuleFuelInfinite";
	public static final String SELECTED_MODULE_FUELINFINITE_TAG = "SelectedModuleFuelInfinite";
	public static final String LEARNED_MODULE_BOMB_TAG = "LearnedModuleBomb";
	public static final String SELECTED_MODULE_BOMB_TAG = "SelectedModuleBomb";
	*/
	public static net.minecraft.util.text.translation.I18n Old_I18n;
	
	/**
	 * Check if January 1st is within 3 days before and 3 days after.
	 */
	public static boolean isDateAroundNewYears(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 12 && calendarIn.get(5) >= 29 || calendarIn.get(2) + 1 == 1 && calendarIn.get(5) <= 4;
    }
	
	/**
	 * Check if February 14th is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundValentinesDay(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 2 && calendarIn.get(5) >= 4 || calendarIn.get(2) + 1 == 2 && calendarIn.get(5) <= 17;
    }
	
	/**
	 * Check if April 7th is within 8 days before and 7 days after.
	 */
	public static boolean isDateAroundEaster(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 3 && calendarIn.get(5) >= 29 || calendarIn.get(2) + 1 == 4 && calendarIn.get(5) <= 14;
    }
	
	/**
	 * Check if July 4th is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundIndependenceDay(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 5 && calendarIn.get(5) >= 27 || calendarIn.get(2) + 1 == 6 && calendarIn.get(5) <= 7;
    }
	
	/**
	 * Check if October 31st is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundHalloween(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 10 && calendarIn.get(5) >= 20 || calendarIn.get(2) + 1 == 11 && calendarIn.get(5) <= 3;
    }
	
	/**
	 * Check if November 28th is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundThanksgiving(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 11 && calendarIn.get(5) >= 18 || calendarIn.get(2) + 1 == 11 && calendarIn.get(5) <= 30;
    }
	
	/**
	 * Check if December 25th is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundChristmas(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 12 && calendarIn.get(5) >= 15 || calendarIn.get(2) + 1 == 12 && calendarIn.get(5) <= 28;
    }
	
	/**
	 * Sets the correct Main Toolitp color
	 */
	@SideOnly(Side.CLIENT)
	public static TextFormatting mainColorTooltip(ItemStack stackIn)
	{
		TextFormatting stringColorMain = TextFormatting.WHITE;
		
		if(stackIn.getMetadata() == 0)
		{
			stringColorMain = TextFormatting.WHITE;
		}
		if(stackIn.getMetadata() == 1)
		{
			stringColorMain = TextFormatting.WHITE;
		}
		if(stackIn.getMetadata() == 2)
		{
			stringColorMain = TextFormatting.YELLOW;
		}
		if(stackIn.getMetadata() == 3)
		{
			stringColorMain = TextFormatting.AQUA;
		}
		if(stackIn.getMetadata() == 4)
		{
			stringColorMain = TextFormatting.LIGHT_PURPLE;
		}
		if(stackIn.getMetadata() == 5)
		{
			stringColorMain = TextFormatting.RED;
		}
		
		return stringColorMain;
	}
	
	/**
	 * Sets the correct Text Toolitp color
	 */
	@SideOnly(Side.CLIENT)
	public static TextFormatting textColorTooltip(ItemStack stackIn)
	{
		TextFormatting stringColorText = TextFormatting.GRAY;
		
		if(stackIn.getMetadata() == 0)
		{
			stringColorText = TextFormatting.GRAY;
		}
		if(stackIn.getMetadata() == 1)
		{
			stringColorText = TextFormatting.GRAY;
		}
		if(stackIn.getMetadata() == 2)
		{
			stringColorText = TextFormatting.GOLD;
		}
		if(stackIn.getMetadata() == 3)
		{
			stringColorText = TextFormatting.DARK_AQUA;
		}
		if(stackIn.getMetadata() == 4)
		{
			stringColorText = TextFormatting.DARK_PURPLE;
		}
		if(stackIn.getMetadata() == 5)
		{
			stringColorText = TextFormatting.DARK_RED;
		}
		
		return stringColorText;
	}
	
	/**
	 * A simple wrapper for the new Localization format.
	 * This is Client side only!
	 */
	@SideOnly(Side.CLIENT)
	public static String localNameVC(String stringIn)
	{
		return I18n.format(stringIn, new Object[0]);
	}
	
	
	//=========================================
	
	/**
	 * Used in Rendering Airship textures.
	 *
	public static final ItemStack[] ITEM_DISPLAY_SYMBOL = new ItemStack[] 
	{
		//new ItemStack(ItemsVM.SYMBOL_LOGOVIESMACHINES),
		new ItemStack(ItemsVM.SYMBOL_LOGOFORGE),
		//new ItemStack(ItemsVM.SYMBOL_LOGOMINECRAFT),
		new ItemStack(ItemsVM.SYMBOL_COINSTACK),
		new ItemStack(ItemsVM.SYMBOL_SCROLL),
		new ItemStack(ItemsVM.SYMBOL_WRENCH),
		new ItemStack(ItemsVM.SYMBOL_KEY),
		new ItemStack(ItemsVM.SYMBOL_PADLOCK),
		new ItemStack(ItemsVM.SYMBOL_BELL),
		new ItemStack(ItemsVM.SYMBOL_ANCHOR),
		new ItemStack(ItemsVM.SYMBOL_BARREL),
		new ItemStack(ItemsVM.SYMBOL_GEARS)
		
		
		
	};
	*/
	
	/**
	 * Used in Rendering Airship textures.
	 *
	public static final ResourceLocation[] ENTITY_SCREEN_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/no_module.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_speed_minor.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_speed_major.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_inv_small.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_inv_large.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_fuel_infinite.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_water_landing.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_max_altitude.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_minor_efficiency.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_major_efficiency.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_jukebox.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_cruise_control.png")
	};*/
	
	
	
	
	//For Render<Entity>
	protected TextFormatting getPrimaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel;
		
		switch(stack)
		{
			case 0:
				return stringColorLabel = TextFormatting.GRAY;
			case 1:
				return stringColorLabel = TextFormatting.WHITE;
			case 2:
				return stringColorLabel = TextFormatting.YELLOW;
			case 3:
				return stringColorLabel = TextFormatting.AQUA;
			case 4:
				return stringColorLabel = TextFormatting.LIGHT_PURPLE;
			case 5:
				return stringColorLabel = TextFormatting.RED;
			default:
				return stringColorLabel = TextFormatting.GRAY;
		}
	}
	

    
    
    
    protected FontRenderer getFontRenderer()
    {
        return Minecraft.getMinecraft().fontRenderer;
    }
    

  	public static final ResourceLocation STEVE_TEXTURES = new ResourceLocation("textures/entity/steve.png");
    public static final ResourceLocation ALEX_TEXTURES = new ResourceLocation("textures/entity/alex.png");
    public static final ResourceLocation CHICKEN_TEXTURES = new ResourceLocation("textures/entity/chicken.png");
    public static final ResourceLocation PIG_TEXTURES = new ResourceLocation("textures/entity/pig/pig.png");
    public static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");
    public static final ResourceLocation ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
    public static final ResourceLocation SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    public static final ResourceLocation SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");
    public static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
    public static final ResourceLocation WITHER_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    public static final ResourceLocation DRAGON_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    public static final ResourceLocation HEROBRINE_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/herobrine.png");
    
    public static final ResourceLocation SUPPORTER_VIES_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/vies.png");
    public static final ResourceLocation SUPPORTER_SOULFORGE7_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/soulforge7.png");
    public static final ResourceLocation SUPPORTER_NEMANOR_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/nemanor.png");
    public static final ResourceLocation SUPPORTER_VELOURVAULTSUIT_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/velourvaultsuit.png");
    
    
	
	
	
}
