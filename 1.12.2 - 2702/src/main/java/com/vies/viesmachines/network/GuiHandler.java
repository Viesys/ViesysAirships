package com.vies.viesmachines.network;

import com.vies.viesmachines.client.gui.machines.GuiMachineMenuMain;
import com.vies.viesmachines.client.gui.machines.GuiMachineMenuMainSelectMusic;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineMenuMain;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	
	public static final int GUI_MACHINE_MENU_MAIN = 11;
	public static final int GUI_MACHINE_MENU_MAIN_SELECT_MUSIC = 12;
	//public static final int GUI_MAIN_MENU = 12;
	
	
	
	
	
	
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
