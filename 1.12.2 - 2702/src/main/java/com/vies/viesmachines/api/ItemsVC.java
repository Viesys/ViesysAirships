package com.vies.viesmachines.api;

import com.vies.viesmachines.common.items.ItemGeneric;
import com.vies.viesmachines.common.items.misc.ItemGuidebook;
import com.vies.viesmachines.common.items.tools.ItemToolCompressing;
import com.vies.viesmachines.common.items.tools.ItemToolDismounting;
import com.vies.viesmachines.common.items.tools.ItemToolRepairing;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;

public class ItemsVC {
	
	public static final Item GUIDEBOOK = new ItemGuidebook();
	
	public static final Item MACHINE_PELLETS = new ItemGeneric("item_machine_pellets", EnumRarity.COMMON);
	
	public static final Item LOGIC_CHIP = new ItemGeneric("item_logic_chip", EnumRarity.COMMON);
	public static final Item ADAPTIVE_CIRCUIT = new ItemGeneric("item_adaptive_circuit", EnumRarity.COMMON);
	
	public static final Item MACHINE_FRAME = new ItemGeneric("item_machine_frame", EnumRarity.COMMON);
	public static final Item MACHINE_ENGINE = new ItemGeneric("item_machine_engine", EnumRarity.COMMON);
	public static final Item MACHINE_COMPONENT_GROUND = new ItemGeneric("item_machine_component_ground", EnumRarity.COMMON);
	public static final Item MACHINE_COMPONENT_WATER = new ItemGeneric("item_machine_component_water", EnumRarity.COMMON);
	public static final Item MACHINE_COMPONENT_FLYING = new ItemGeneric("item_machine_component_flying", EnumRarity.COMMON);
	
	
	
	public static final Item UPGRADE_FRAME_TIER1 = new ItemGeneric("item_upgrade_frame_tier1", EnumRarity.UNCOMMON);
	public static final Item UPGRADE_FRAME_TIER2 = new ItemGeneric("item_upgrade_frame_tier2", EnumRarity.RARE);
	public static final Item UPGRADE_FRAME_TIER3 = new ItemGeneric("item_upgrade_frame_tier3", EnumRarity.EPIC);
	public static final Item UPGRADE_ENGINE_TIER1 = new ItemGeneric("item_upgrade_engine_tier1", EnumRarity.UNCOMMON);
	public static final Item UPGRADE_ENGINE_TIER2 = new ItemGeneric("item_upgrade_engine_tier2", EnumRarity.RARE);
	public static final Item UPGRADE_ENGINE_TIER3 = new ItemGeneric("item_upgrade_engine_tier3", EnumRarity.EPIC);
	public static final Item UPGRADE_COMPONENT_TIER1 = new ItemGeneric("item_upgrade_component_tier1", EnumRarity.UNCOMMON);
	public static final Item UPGRADE_COMPONENT_TIER2 = new ItemGeneric("item_upgrade_component_tier2", EnumRarity.RARE);
	public static final Item UPGRADE_COMPONENT_TIER3 = new ItemGeneric("item_upgrade_component_tier3", EnumRarity.EPIC);
	
	

	public static final Item TOOL_DISMOUNTING = new ItemToolDismounting();
	public static final Item TOOL_COMPRESSING = new ItemToolCompressing();
	public static final Item TOOL_REPAIRING = new ItemToolRepairing();
	
	
	
	//public static final Item UPGRADE_COMPONENT_TIER1 = new ItemComponentFlying();
	//public static final Item UPGRADE_COMPONENT_TIER2 = new ItemComponentFlying();
	//public static final Item UPGRADE_COMPONENT_TIER3 = new ItemComponentFlying();
	
	
	
	
	
	/**
	
	
	//=================================================================
	
	public static final ItemDismounterNormal DISMOUNTER_NORMAL = new ItemDismounterNormal();
	public static final ItemDismounterPlayer DISMOUNTER_PLAYER = new ItemDismounterPlayer();
	public static final ItemIgnition AIRSHIP_IGNITION = new ItemIgnition();
	public static final ItemFrame AIRSHIP_FRAME = new ItemFrame();
	public static final ItemEngine AIRSHIP_ENGINE = new ItemEngine();
	public static final ItemBalloon AIRSHIP_BALLOON = new ItemBalloon();
	
	public static final ItemUpgradeCore UPGRADE_CORE = new ItemUpgradeCore();
	public static final ItemUpgradeFrame UPGRADE_FRAME = new ItemUpgradeFrame();
	public static final ItemUpgradeEngine UPGRADE_ENGINE = new ItemUpgradeEngine();
	public static final ItemUpgradeBalloon UPGRADE_BALLOON = new ItemUpgradeBalloon();
	
	public static final ItemBomb BOMB = new ItemBomb();
	
	public static final ItemModuleType MODULE_TYPE = new ItemModuleType();
	public static final ItemModuleCreative MODULE_CREATIVE = new ItemModuleCreative();
	
	
	//================================
	
	public static final ItemAirship ITEM_AIRSHIP = new ItemAirship("airships/item_airship");
	public static final ItemCreativeAirship ITEM_AIRSHIP_CREATIVE = new ItemCreativeAirship("airships/item_airship_creative");
	
	//================================
	//Hidden Items
	public static final ItemEntityAirship ITEM_ENTITY_AIRSHIP = new ItemEntityAirship();
	
	public static final ItemAchievement ACHIEVEMENT_AIRSHIP = new ItemAchievement();
	
	public static final ItemDisplaySymbol ITEM_DISPLAY_SYMBOL = new ItemDisplaySymbol();
	*/
	//================================
}
