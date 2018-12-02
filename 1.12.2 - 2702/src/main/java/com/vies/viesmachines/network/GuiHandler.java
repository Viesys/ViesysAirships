package com.vies.viesmachines.network;

import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMain;
import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMainSelectMusic;
import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMainSelectName;
import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMainSelectProjectile;
import com.vies.viesmachines.client.gui.machines.stats.GuiMachineMenuStats;
import com.vies.viesmachines.client.gui.machines.visual.GuiMachineMenuCustomize;
import com.vies.viesmachines.client.gui.machines.visual.GuiMachineMenuCustomizeActiveModels;
import com.vies.viesmachines.client.gui.machines.visual.GuiMachineMenuCustomizeDisplayBanner;
import com.vies.viesmachines.client.gui.machines.visual.GuiMachineMenuCustomizePrimarySkinColor;
import com.vies.viesmachines.client.gui.machines.visual.GuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.client.gui.machines.visual.GuiMachineMenuCustomizeSecondarySkinColor;
import com.vies.viesmachines.client.gui.machines.visual.GuiMachineMenuCustomizeSecondarySkinTexture;
import com.vies.viesmachines.client.gui.machines.visual.display.GuiMachineMenuCustomizeDisplayBlockItemPg1;
import com.vies.viesmachines.client.gui.machines.visual.display.GuiMachineMenuCustomizeDisplayHeadPg1;
import com.vies.viesmachines.client.gui.machines.visual.display.GuiMachineMenuCustomizeDisplaySupporterHeadPg1;
import com.vies.viesmachines.client.gui.machines.visual.display.GuiMachineMenuCustomizeDisplaySymbolPg1;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeDisplaySymbolPg1Holiday4thofJuly;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeDisplaySymbolPg1HolidayChristmas;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeDisplaySymbolPg1HolidayEaster;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeDisplaySymbolPg1HolidayNewYears;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeDisplaySymbolPg1HolidayThanksgiving;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeDisplaySymbolPg1HolidayValentinesDay;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizePrimarySkinTextureHoliday4thofJuly;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizePrimarySkinTextureHolidayChristmas;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizePrimarySkinTextureHolidayEaster;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizePrimarySkinTextureHolidayHalloween;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizePrimarySkinTextureHolidayNewYears;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizePrimarySkinTextureHolidayThanksgiving;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizePrimarySkinTextureHolidayValentinesDay;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeSecondarySkinTextureHoliday4thofJuly;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeSecondarySkinTextureHolidayChristmas;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeSecondarySkinTextureHolidayEaster;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeSecondarySkinTextureHolidayNewYears;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeSecondarySkinTextureHolidayThanksgiving;
import com.vies.viesmachines.client.gui.machines.visual.holiday.GuiMachineMenuCustomizeSecondarySkinTextureHolidayValentinesDay;
import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityExtractor;
import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityKitFabricator;
import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityMachineBeacon;
import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityMachineTransmogrifier;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineMenuCustomizeDisplayBanner;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineMenuMain;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineMenuMainSelectProjectile;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.common.tileentity.TileEntityExtractor;
import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;
import com.vies.viesmachines.common.tileentity.TileEntityMachineBeacon;
import com.vies.viesmachines.common.tileentity.TileEntityMachineTransmogrifier;
import com.vies.viesmachines.common.tileentity.containers.ContainerExtractor;
import com.vies.viesmachines.common.tileentity.containers.ContainerKitFabricator;
import com.vies.viesmachines.common.tileentity.containers.ContainerMachineBeacon;
import com.vies.viesmachines.common.tileentity.containers.ContainerMachineTransmogrifier;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	
	public static final int GUI_MACHINE_MENU_MAIN = 11;
	public static final int GUI_MACHINE_MENU_MAIN_SELECT_MUSIC = 12;
	public static final int GUI_MACHINE_MENU_MAIN_CHANGE_NAME = 14;
	public static final int GUI_MACHINE_MENU_MAIN_SELECT_PROJECTILE = 15;
	
	public static final int GUI_MACHINE_MENU_STATS = 13;
	//public static final int GUI_MAIN_MENU = 12;
	
	public static final int GUI_MACHINE_MENU_CUSTOMIZE = 16;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_ACTIVE_MODELS = 17;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_BANNER = 18;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE = 19;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_COLOR = 20;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE = 21;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_COLOR = 22;
	
	
	
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1 = 23;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_BLOCKITEM_PG1 = 24;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_HEAD_PG1 = 25;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SUPPORTERHEAD_PG1 = 26;
	

	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_NEWYEARS = 101;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_VALENTINESDAY = 102;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_EASTER = 103;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_4THOFJULY = 104;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_HALLOWEEN = 105;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_THANKSGIVING = 106;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_CHRISTMAS = 107;
	
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_NEWYEARS = 111;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_VALENTINESDAY = 112;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_EASTER = 113;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_4THOFJULY = 114;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_HALLOWEEN = 115;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_THANKSGIVING = 116;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_CHRISTMAS = 117;
	
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_NEWYEARS = 121;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_VALENTINESDAY = 122;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_EASTER = 123;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_4THOFJULY = 124;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_HALLOWEEN = 125;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_THANKSGIVING = 126;
	public static final int GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_CHRISTMAS = 127;
	
	
	public static final int GUI_APPLIANCE_EXTRACTOR= 32;
	public static final int GUI_APPLIANCE_KIT_FABRICATOR= 33;
	public static final int GUI_APPLIANCE_MACHINE_TRANSMOGRIFIER= 34;
	public static final int GUI_APPLIANCE_MACHINE_BEACON= 35;
	
	
	/**
	public static final int GUI_AIRSHIP_WORKBENCH = 50;
	public static final int GUI_BATTERY_CHARGER = 51;

	//public static final int GUI_ITEM_POUCH_MODULE = 52;
	//public static final int GUI_ITEM_POUCH_ALL = 53;
	
	public static final int GUI_MAIN_MENU = 11;
	public static final int GUI_UPGRADE_MENU = 16;
	public static final int GUI_CUSTOMIZE_MENU = 17;
	public static final int GUI_MODULE_MENU = 18;
	
	
	public static final int GUI_CUSTOMIZE_MENU_CHANGE_NAME = 171;
	public static final int GUI_CUSTOMIZE_MENU_REDSTONE = 172;
	
	public static final int GUI_APPEARANCE_MENU_CORE_MAIN = 402;
	public static final int GUI_APPEARANCE_MENU_CORE_MODEL_FRAME_PG1 = 403;
	public static final int GUI_APPEARANCE_MENU_CORE_MODEL_ENGINE_PG1 = 404;
	public static final int GUI_APPEARANCE_MENU_CORE_MODEL_BALLOON_PG1 = 405;
	
	public static final int GUI_APPEARANCE_MENU_FRAME_MAIN = 102;
	public static final int GUI_APPEARANCE_MENU_FRAME_COLOR = 109;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER1_PG1 = 103;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER1_PG2 = 104;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER2_PG1 = 105;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER3_PG1 = 106;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER4_PG1 = 107;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER5_PG1 = 108;
	
	public static final int GUI_APPEARANCE_MENU_ENGINE_MAIN = 302;
	public static final int GUI_APPEARANCE_MENU_ENGINE_SYMBOLS_PG1 = 303;
	public static final int GUI_APPEARANCE_MENU_ENGINE_BLOCKITEM = 304;
	public static final int GUI_APPEARANCE_MENU_ENGINE_HEADS = 306;
	public static final int GUI_APPEARANCE_MENU_ENGINE_SUPPORTER_HEADS = 307;
	public static final int GUI_APPEARANCE_MENU_ENGINE_PARTICLE = 308;
	
	public static final int GUI_APPEARANCE_MENU_BALLOON_MAIN = 202;
	public static final int GUI_APPEARANCE_MENU_BALLOON_COLOR = 209;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1 = 203;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER1_PG2 = 204;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1 = 205;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1 = 206;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1 = 207;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1 = 208;
	
	
	public static final int GUI_MUSIC_PG1 = 31;
	*/
	public GuiHandler() 
	{
    	instance = this;
    }
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		// Machine container:
		if (ID == GUI_MACHINE_MENU_MAIN)
		{
			return new ContainerMachineMenuMain(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container with no slots:
		if (ID == GUI_MACHINE_MENU_MAIN_SELECT_MUSIC)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container with no slots:
		if (ID == GUI_MACHINE_MENU_MAIN_CHANGE_NAME)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container with no slots:
		if (ID == GUI_MACHINE_MENU_MAIN_SELECT_PROJECTILE)
		{
			return new ContainerMachineMenuMainSelectProjectile(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine container:
		if (ID == GUI_MACHINE_MENU_STATS)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_ACTIVE_MODELS)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_BANNER)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_BLOCKITEM_PG1)
		{
			return new ContainerMachineMenuCustomizeDisplayBanner(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_HEAD_PG1)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SUPPORTERHEAD_PG1)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_COLOR)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_COLOR)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		

		
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_NEWYEARS
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_VALENTINESDAY
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_EASTER
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_4THOFJULY
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_HALLOWEEN
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_THANKSGIVING
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_CHRISTMAS)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_NEWYEARS
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_VALENTINESDAY
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_EASTER
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_4THOFJULY
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_HALLOWEEN
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_THANKSGIVING
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_CHRISTMAS)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_NEWYEARS
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_VALENTINESDAY
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_EASTER
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_4THOFJULY
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_HALLOWEEN
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_THANKSGIVING
		|| ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_CHRISTMAS)
		{
			return new ContainerMachineNoSlots(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		
		// Extractor Container
		if (ID == GUI_APPLIANCE_EXTRACTOR)
		{
			return new ContainerExtractor(player.inventory, world, (TileEntityExtractor)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		// Kit Fabricator Container
		if (ID == GUI_APPLIANCE_KIT_FABRICATOR)
		{
			return new ContainerKitFabricator(player.inventory, world, (TileEntityKitFabricator)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		// Machine Transmogrifier Container
		if (ID == GUI_APPLIANCE_MACHINE_TRANSMOGRIFIER)
		{
			return new ContainerMachineTransmogrifier(player.inventory, world, (TileEntityMachineTransmogrifier)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		// Machine Beacon Container
		if (ID == GUI_APPLIANCE_MACHINE_BEACON)
		{
			return new ContainerMachineBeacon(player.inventory, world, (TileEntityMachineBeacon)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		/**
		//Airship Workbench Container
		if (ID == GUI_AIRSHIP_WORKBENCH)
		{
			return new ContainerAirshipWorkbench(player.inventory, world, (TileEntityAirshipWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Airship Workbench Container
		if (ID == GUI_BATTERY_CHARGER)
		{
			return new ContainerBatteryCharger(player.inventory, world, (TileEntityBatteryCharger)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Module Pouch
		//if (ID == GUI_ITEM_POUCH_MODULE)
		//{
		//	return new ContainerPouchModule(player, new InventoryPouch(player.getHeldItem(EnumHand.MAIN_HAND)));
		//}
		//if (ID == GUI_ITEM_POUCH_ALL)
		//{
		//	return new ContainerPouchAll(player, new InventoryPouch(player.getHeldItem(EnumHand.MAIN_HAND)));
		//}
		
		
		
		//Airship Container with no module
		if (ID == GUI_MAIN_MENU)
		{
			return new ContainerMenuMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Upgrade Container
		if (ID == GUI_UPGRADE_MENU)
		{
			return new ContainerUpgradeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Appearance Containers
		if (ID == GUI_CUSTOMIZE_MENU)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		//Airship Appearance Change Name Containers
		if(ID == GUI_CUSTOMIZE_MENU_CHANGE_NAME)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		//Airship Appearance Change Name Containers
		if(ID == GUI_CUSTOMIZE_MENU_REDSTONE)
		{
			return new ContainerMenuRedstone(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_CORE_MAIN)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_FRAME_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_ENGINE_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_BALLOON_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_FRAME_MAIN)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_COLOR)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG2)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER2_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER3_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER4_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER5_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_ENGINE_MAIN)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_SYMBOLS_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_BLOCKITEM)
		{
			return new ContainerCustomizeEngineBlock(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_HEADS)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_SUPPORTER_HEADS)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_PARTICLE)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_BALLOON_MAIN)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_COLOR)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG2)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		//Airship Module Container
		if (ID == GUI_MODULE_MENU)
		{
			return new ContainerMainModule(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Music Containers
		if (ID == GUI_MUSIC_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		*/
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		// Machine gui for the main menu:
		if (ID == GUI_MACHINE_MENU_MAIN)
		{
			return new GuiMachineMenuMain(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for selecting music:
		if (ID == GUI_MACHINE_MENU_MAIN_SELECT_MUSIC)
		{
			return new GuiMachineMenuMainSelectMusic(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for selecting names:
		if (ID == GUI_MACHINE_MENU_MAIN_CHANGE_NAME)
		{
			return new GuiMachineMenuMainSelectName(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for selecting projectiles:
		if (ID == GUI_MACHINE_MENU_MAIN_SELECT_PROJECTILE)
		{
			return new GuiMachineMenuMainSelectProjectile(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine gui for the stats menu:
		if (ID == GUI_MACHINE_MENU_STATS)
		{
			return new GuiMachineMenuStats(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE)
		{
			return new GuiMachineMenuCustomize(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_ACTIVE_MODELS)
		{
			return new GuiMachineMenuCustomizeActiveModels(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_BANNER)
		{
			return new GuiMachineMenuCustomizeDisplayBanner(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1)
		{
			return new GuiMachineMenuCustomizeDisplaySymbolPg1(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_BLOCKITEM_PG1)
		{
			return new GuiMachineMenuCustomizeDisplayBlockItemPg1(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_HEAD_PG1)
		{
			return new GuiMachineMenuCustomizeDisplayHeadPg1(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SUPPORTERHEAD_PG1)
		{
			return new GuiMachineMenuCustomizeDisplaySupporterHeadPg1(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		

		
		
		
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE)
		{
			return new GuiMachineMenuCustomizePrimarySkinTexture(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_COLOR)
		{
			return new GuiMachineMenuCustomizePrimarySkinColor(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE)
		{
			return new GuiMachineMenuCustomizeSecondarySkinTexture(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine gui for the customize menu:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_COLOR)
		{
			return new GuiMachineMenuCustomizeSecondarySkinColor(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		

		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_NEWYEARS)
		{
			return new GuiMachineMenuCustomizeDisplaySymbolPg1HolidayNewYears(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_VALENTINESDAY)
		{
			return new GuiMachineMenuCustomizeDisplaySymbolPg1HolidayValentinesDay(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_EASTER)
		{
			return new GuiMachineMenuCustomizeDisplaySymbolPg1HolidayEaster(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_4THOFJULY)
		{
			return new GuiMachineMenuCustomizeDisplaySymbolPg1Holiday4thofJuly(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_HALLOWEEN)
		{
			return new GuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_THANKSGIVING)
		{
			return new GuiMachineMenuCustomizeDisplaySymbolPg1HolidayThanksgiving(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_CHRISTMAS)
		{
			return new GuiMachineMenuCustomizeDisplaySymbolPg1HolidayChristmas(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_NEWYEARS)
		{
			return new GuiMachineMenuCustomizePrimarySkinTextureHolidayNewYears(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_VALENTINESDAY)
		{
			return new GuiMachineMenuCustomizePrimarySkinTextureHolidayValentinesDay(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_EASTER)
		{
			return new GuiMachineMenuCustomizePrimarySkinTextureHolidayEaster(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_4THOFJULY)
		{
			return new GuiMachineMenuCustomizePrimarySkinTextureHoliday4thofJuly(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_HALLOWEEN)
		{
			return new GuiMachineMenuCustomizePrimarySkinTextureHolidayHalloween(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_THANKSGIVING)
		{
			return new GuiMachineMenuCustomizePrimarySkinTextureHolidayThanksgiving(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_CHRISTMAS)
		{
			return new GuiMachineMenuCustomizePrimarySkinTextureHolidayChristmas(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_NEWYEARS)
		{
			return new GuiMachineMenuCustomizeSecondarySkinTextureHolidayNewYears(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_VALENTINESDAY)
		{
			return new GuiMachineMenuCustomizeSecondarySkinTextureHolidayValentinesDay(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_EASTER)
		{
			return new GuiMachineMenuCustomizeSecondarySkinTextureHolidayEaster(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_4THOFJULY)
		{
			return new GuiMachineMenuCustomizeSecondarySkinTextureHoliday4thofJuly(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_HALLOWEEN)
		{
			return new GuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_THANKSGIVING)
		{
			return new GuiMachineMenuCustomizeSecondarySkinTextureHolidayThanksgiving(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		// Machine container:
		if (ID == GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_CHRISTMAS)
		{
			return new GuiMachineMenuCustomizeSecondarySkinTextureHolidayChristmas(player.inventory, (EntityMachineBase)player.getRidingEntity());
		}
		
		
		// Extractor GUI
		if (ID == GUI_APPLIANCE_EXTRACTOR)
		{
			return new GuiTileEntityExtractor(player.inventory, world, (TileEntityExtractor)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		// Kit Fabricator GUI
		if (ID == GUI_APPLIANCE_KIT_FABRICATOR)
		{
			return new GuiTileEntityKitFabricator(player.inventory, world, (TileEntityKitFabricator)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		// Kit Fabricator GUI
		if (ID == GUI_APPLIANCE_MACHINE_TRANSMOGRIFIER)
		{
			return new GuiTileEntityMachineTransmogrifier(player.inventory, world, (TileEntityMachineTransmogrifier)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		// Kit Fabricator GUI
		if (ID == GUI_APPLIANCE_MACHINE_BEACON)
		{
			return new GuiTileEntityMachineBeacon(player.inventory, world, (TileEntityMachineBeacon)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		/**
		//Airship Workbench GUI
		if (ID == GUI_AIRSHIP_WORKBENCH)
		{
			return new GuiTileEntityAirshipWorkbench(player.inventory, world, (TileEntityAirshipWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Airship Workbench GUI
		if (ID == GUI_BATTERY_CHARGER)
		{
			return new GuiTileEntityBatteryCharger(player.inventory, world, (TileEntityBatteryCharger)world.getTileEntity(new BlockPos(x, y, z)));
		}

		//Module Pouch
		//if (ID == GUI_ITEM_POUCH_MODULE)
		//{
		//	return new GuiPouchModule(player, new InventoryPouch(player.getHeldItem(EnumHand.MAIN_HAND)));
		//}
		//if (ID == GUI_ITEM_POUCH_ALL)
		//{
		//	return new GuiPouchAll(player, new InventoryPouch(player.getHeldItem(EnumHand.MAIN_HAND)));
		//}
		
		
		//Airship GUI with no module
		if (ID == GUI_MAIN_MENU)
		{
			return new GuiMainMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Module GUI
		if (ID == GUI_MODULE_MENU)
		{
			return new GuiModuleMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		//Airship Upgrade GUI
		if (ID == GUI_UPGRADE_MENU)
		{
			return new GuiUpgradeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Appearance GUI
		if (ID == GUI_CUSTOMIZE_MENU)
		{
			return new GuiCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		//Airship Appearance Change Name GUI
		if (ID == GUI_CUSTOMIZE_MENU_CHANGE_NAME)
		{
			return new GuiCustomizeMenuChangeName(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		//Airship Appearance Change Name GUI
		if (ID == GUI_CUSTOMIZE_MENU_REDSTONE)
		{
			return new GuiCustomizeMenuRedstone(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_CORE_MAIN)
		{
			return new GuiCustomizeMenuCoreMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_FRAME_PG1)
		{
			return new GuiCustomizeMenuCoreModelFramePg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_ENGINE_PG1)
		{
			return new GuiCustomizeMenuCoreModelEnginePg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_BALLOON_PG1)
		{
			return new GuiCustomizeMenuCoreModelBalloonPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_FRAME_MAIN)
		{
			return new GuiCustomizeMenuFrameMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_COLOR)
		{
			return new GuiCustomizeMenuFrameColor(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG1)
		{
			return new GuiCustomizeMenuFrameTier1Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG2)
		{
			return new GuiCustomizeMenuFrameTier1Pg2(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER2_PG1)
		{
			return new GuiCustomizeMenuFrameTier2Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER3_PG1)
		{
			return new GuiCustomizeMenuFrameTier3Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER4_PG1)
		{
			return new GuiCustomizeMenuFrameTier4Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER5_PG1)
		{
			return new GuiCustomizeMenuFrameTier5Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_ENGINE_MAIN)
		{
			return new GuiCustomizeMenuEngineMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_SYMBOLS_PG1)
		{
			return new GuiCustomizeMenuEngineDisplaySymbolPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_BLOCKITEM)
		{
			return new GuiCustomizeMenuEngineDisplayBlockItemPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_HEADS)
		{
			return new GuiCustomizeMenuEngineDisplayHeadPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_SUPPORTER_HEADS)
		{
			return new GuiCustomizeMenuEngineDisplaySupporterHeadPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_PARTICLE)
		{
			return new GuiCustomizeMenuEngineParticlePg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		if (ID == GUI_APPEARANCE_MENU_BALLOON_MAIN)
		{
			return new GuiCustomizeMenuBalloonMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_COLOR)
		{
			return new GuiCustomizeMenuBalloonColor(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1)
		{
			return new GuiCustomizeMenuBalloonTier1Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG2)
		{
			return new GuiCustomizeMenuBalloonTier1Pg2(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1)
		{
			return new GuiCustomizeMenuBalloonTier2Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1)
		{
			return new GuiCustomizeMenuBalloonTier3Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1)
		{
			return new GuiCustomizeMenuBalloonTier4Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1)
		{
			return new GuiCustomizeMenuBalloonTier5Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		//Airship Music GUI
		if (ID == GUI_MUSIC_PG1)
		{
			return new GuiAirshipMusicPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		*/
		
		return null;
	}
}
