package com.vies.viesmachines.api;

import com.vies.viesmachines.common.items.ItemGeneric;
import com.vies.viesmachines.common.items.ItemGenericParticle;
import com.vies.viesmachines.common.items.ItemGenericSymbol;
import com.vies.viesmachines.common.items.ItemGenericWIP;
import com.vies.viesmachines.common.items.kits.ItemKitAdmin;
import com.vies.viesmachines.common.items.kits.ItemKitDurability;
import com.vies.viesmachines.common.items.kits.ItemKitEnergy;
import com.vies.viesmachines.common.items.kits.ItemKitHealth;
import com.vies.viesmachines.common.items.machines.flying.ItemMachineFlyingAirship;
import com.vies.viesmachines.common.items.misc.ItemMachinePellets;
import com.vies.viesmachines.common.items.parts.ItemComponentFlying;
import com.vies.viesmachines.common.items.parts.ItemComponentGround;
import com.vies.viesmachines.common.items.parts.ItemComponentWater;
import com.vies.viesmachines.common.items.tools.ItemToolDismounting;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeComponent;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeEngine;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeFrame;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;

public class ItemsVM {
	
	public static final Item XEGONITE = new ItemGeneric("item_xegonite", EnumRarity.COMMON);
	public static final Item MACHINE_PELLETS = new ItemMachinePellets("item_machine_pellets", EnumRarity.UNCOMMON);
	public static final Item MACHINE_AMMO = new ItemGeneric("item_machine_ammo", EnumRarity.UNCOMMON);
	
	public static final Item CIRCUIT_LOGIC = new ItemGeneric("item_circuit_logic", EnumRarity.COMMON);
	public static final Item MACHINE_FRAME = new ItemGeneric("item_machine_frame", EnumRarity.COMMON);
	public static final Item MACHINE_ENGINE = new ItemGeneric("item_machine_engine", EnumRarity.COMMON);
	
	public static final Item MACHINE_COMPONENT_GROUND = new ItemComponentGround("item_machine_component_ground");
	public static final Item MACHINE_COMPONENT_WATER = new ItemComponentWater("item_machine_component_water");
	public static final Item MACHINE_COMPONENT_FLYING = new ItemComponentFlying("item_machine_component_flying");
	
	//===============================================================
	
	public static final Item UPGRADE_FRAME_TIER1 = new ItemUpgradeFrame("upgrades/item_upgrade_frame_tier1", EnumRarity.UNCOMMON, 1);
	public static final Item UPGRADE_FRAME_TIER2 = new ItemUpgradeFrame("upgrades/item_upgrade_frame_tier2", EnumRarity.RARE, 2);
	public static final Item UPGRADE_FRAME_TIER3 = new ItemUpgradeFrame("upgrades/item_upgrade_frame_tier3", EnumRarity.EPIC, 3);
	
	public static final Item UPGRADE_ENGINE_TIER1 = new ItemUpgradeEngine("upgrades/item_upgrade_engine_tier1", EnumRarity.UNCOMMON, 1);
	public static final Item UPGRADE_ENGINE_TIER2 = new ItemUpgradeEngine("upgrades/item_upgrade_engine_tier2", EnumRarity.RARE, 2);
	public static final Item UPGRADE_ENGINE_TIER3 = new ItemUpgradeEngine("upgrades/item_upgrade_engine_tier3", EnumRarity.EPIC, 3);
	
	public static final Item UPGRADE_COMPONENT_TIER1 = new ItemUpgradeComponent("upgrades/item_upgrade_component_tier1", EnumRarity.UNCOMMON, 1);
	public static final Item UPGRADE_COMPONENT_TIER2 = new ItemUpgradeComponent("upgrades/item_upgrade_component_tier2", EnumRarity.RARE, 2);
	public static final Item UPGRADE_COMPONENT_TIER3 = new ItemUpgradeComponent("upgrades/item_upgrade_component_tier3", EnumRarity.EPIC, 3);
	
	//===============================================================
	
	public static final Item KIT_HEALTH_2 = new ItemKitHealth("kits/item_kit_health_2", EnumRarity.UNCOMMON, 0);
	public static final Item KIT_HEALTH_8 = new ItemKitHealth("kits/item_kit_health_8", EnumRarity.RARE, 1);
	public static final Item KIT_HEALTH_MAX = new ItemKitHealth("kits/item_kit_health_max", EnumRarity.EPIC, 2);
	
	public static final Item KIT_ENERGY_25 = new ItemKitEnergy("kits/item_kit_energy_25", EnumRarity.UNCOMMON, 0);
	public static final Item KIT_ENERGY_100 = new ItemKitEnergy("kits/item_kit_energy_100", EnumRarity.RARE, 1);
	public static final Item KIT_ENERGY_MAX = new ItemKitEnergy("kits/item_kit_energy_max", EnumRarity.EPIC, 2);
	
	public static final Item KIT_DURABILITY_50 = new ItemKitDurability("kits/item_kit_durability_50", EnumRarity.UNCOMMON, 0);
	public static final Item KIT_DURABILITY_200 = new ItemKitDurability("kits/item_kit_durability_200", EnumRarity.RARE, 1);
	public static final Item KIT_DURABILITY_MAX = new ItemKitDurability("kits/item_kit_durability_max", EnumRarity.EPIC, 2);
	
	//===============================================================

	public static final Item ITEM_MACHINE_GROUND_HOVERCRAFT = new ItemGenericWIP("machines/item_machine_ground_hovercraft", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_GROUND_2 = new ItemGenericWIP("machines/item_machine_ground_2", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_GROUND_3 = new ItemGenericWIP("machines/item_machine_ground_3", EnumRarity.RARE);
	
	public static final Item ITEM_MACHINE_WATER_SUBMARINE = new ItemGenericWIP("machines/item_machine_water_submarine", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_WATER_2 = new ItemGenericWIP("machines/item_machine_water_2", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_WATER_3 = new ItemGenericWIP("machines/item_machine_water_3", EnumRarity.RARE);
	
	public static final Item ITEM_MACHINE_FLYING_AIRSHIP = new ItemMachineFlyingAirship("machines/item_machine_flying_airship", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_FLYING_HELICOPTER = new ItemGenericWIP("machines/item_machine_flying_helicopter", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_FLYING_3 = new ItemGenericWIP("machines/item_machine_flying_3", EnumRarity.RARE);
	
	//===============================================================
	
	public static final Item TOOL_DISMOUNTER = new ItemToolDismounting();
	
	//===============================================================
	
	public static final Item XEGONITE_WATER = new ItemGeneric("item_xegonite_water", EnumRarity.COMMON);
	public static final Item XEGONITE_LAVA = new ItemGeneric("item_xegonite_lava", EnumRarity.COMMON);
	public static final Item XEGONITE_ENDER = new ItemGeneric("item_xegonite_ender", EnumRarity.COMMON);
	
	
	
	public static final Item KIT_RAW = new ItemGeneric("kits/item_kit_raw", EnumRarity.COMMON);
	
	public static final Item KIT_UPGRADE_MAX = new ItemKitAdmin("kits/item_admin_upgrade_max", EnumRarity.EPIC, 0);
	public static final Item KIT_MACHINE_MAX = new ItemKitAdmin("kits/item_admin_machine_max", EnumRarity.EPIC, 1);
	
	public static final Item CIRCUIT_ADAPTIVE = new ItemGeneric("item_circuit_adaptive", EnumRarity.COMMON);
	
	
	
	//==================================================
    // TODO              Particles
	//==================================================
    
	//public static final Item SYMBOL_LOGOVIESMACHINES = new ItemGenericSymbol("symbols/item_symbol_logoviesmachines");
	public static final Item SYMBOL_LOGOFORGE = new ItemGenericSymbol("symbols/item_symbol_logoforge");
	//public static final Item SYMBOL_LOGOMINECRAFT = new ItemGenericSymbol("symbols/item_symbol_logominecraft");
	public static final Item SYMBOL_COINSTACK = new ItemGenericSymbol("symbols/item_symbol_coinstack");
	public static final Item SYMBOL_SCROLL = new ItemGenericSymbol("symbols/item_symbol_scroll");
	public static final Item SYMBOL_WRENCH = new ItemGenericSymbol("symbols/item_symbol_wrench");
	public static final Item SYMBOL_KEY = new ItemGenericSymbol("symbols/item_symbol_key");
	public static final Item SYMBOL_PADLOCK = new ItemGenericSymbol("symbols/item_symbol_padlock");
	public static final Item SYMBOL_BELL = new ItemGenericSymbol("symbols/item_symbol_bell");
	public static final Item SYMBOL_ANCHOR = new ItemGenericSymbol("symbols/item_symbol_anchor");
	public static final Item SYMBOL_BARREL = new ItemGenericSymbol("symbols/item_symbol_barrel");
	public static final Item SYMBOL_GEARS = new ItemGenericSymbol("symbols/item_symbol_gears");
	
	
	
	//==================================================
    // TODO              Particles
	//==================================================
    
	public static final Item PARTICLE_BULLET_NORMAL = new ItemGenericParticle("particles/item_particle_bullet_normal", EnumRarity.COMMON);
	public static final Item PARTICLE_BULLET_ELECTRICAL = new ItemGenericParticle("particles/item_particle_bullet_electrical", EnumRarity.COMMON);
	public static final Item PARTICLE_BULLET_EXPLOSIVE = new ItemGenericParticle("particles/item_particle_bullet_explosive", EnumRarity.COMMON);
	
	public static final Item PARTICLE_STATIC_CHARGE = new ItemGenericParticle("particles/item_particle_static_charge", EnumRarity.COMMON);
	
	//Unused
	//public static final Item GUIDEBOOK = new ItemGuidebook();
	//public static final Item CHARGED_SHARDS = new ItemGeneric("item_charged_shards", EnumRarity.COMMON);
	//public static final Item ADAPTIVE_CIRCUIT = new ItemGeneric("item_adaptive_circuit", EnumRarity.COMMON);
	//public static final Item ENERGIZED_CORE = new ItemGeneric("item_energized_core", EnumRarity.UNCOMMON);
	//public static final Item POWDER_ENERGETIC = new ItemGeneric("item_powder_energetic", EnumRarity.COMMON);
	//public static final Item KIT_RAW = new ItemGeneric("item_kit_raw", EnumRarity.COMMON);
	//public static final Item TOOL_REPAIRING = new ItemToolRepairing();
	//public static final Item TOOL_COMPRESSING = new ItemToolCompressing();
	//public static final Item TOOL_UNIVERSAL = new ItemToolRepairing();
	
		
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
