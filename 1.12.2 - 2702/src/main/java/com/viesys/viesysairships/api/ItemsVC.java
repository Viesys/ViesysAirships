package com.viesys.viesysairships.api;

import com.viesys.viesysairships.common.items.ItemBomb;
import com.viesys.viesysairships.common.items.ItemDismounterNormal;
import com.viesys.viesysairships.common.items.ItemDismounterPlayer;
import com.viesys.viesysairships.common.items.ItemEntityAirship;
import com.viesys.viesysairships.common.items.ItemGuidebookMain;
import com.viesys.viesysairships.common.items.achievements.ItemAchievement;
import com.viesys.viesysairships.common.items.airships.ItemAirship;
import com.viesys.viesysairships.common.items.airships.ItemCreativeAirship;
import com.viesys.viesysairships.common.items.parts.ItemModuleCreative;
import com.viesys.viesysairships.common.items.parts.ItemModuleType;
import com.viesys.viesysairships.common.items.parts.ItemViesoline;
import com.viesys.viesysairships.common.items.parts.main.ItemBalloon;
import com.viesys.viesysairships.common.items.parts.main.ItemEngine;
import com.viesys.viesysairships.common.items.parts.main.ItemFrame;
import com.viesys.viesysairships.common.items.parts.main.ItemIgnition;
import com.viesys.viesysairships.common.items.parts.main.ItemLogicChip;
import com.viesys.viesysairships.common.items.symbols.ItemDisplaySymbol;
import com.viesys.viesysairships.common.items.upgrades.ItemUpgradeBalloon;
import com.viesys.viesysairships.common.items.upgrades.ItemUpgradeCore;
import com.viesys.viesysairships.common.items.upgrades.ItemUpgradeEngine;
import com.viesys.viesysairships.common.items.upgrades.ItemUpgradeFrame;

public class ItemsVC {
	
	public static final ItemGuidebookMain GUIDEBOOK_MAIN = new ItemGuidebookMain();
	public static final ItemDismounterNormal DISMOUNTER_NORMAL = new ItemDismounterNormal();
	public static final ItemDismounterPlayer DISMOUNTER_PLAYER = new ItemDismounterPlayer();
	public static final ItemViesoline VIESOLINE_PELLETS = new ItemViesoline();
	public static final ItemLogicChip LOGIC_CHIP = new ItemLogicChip();
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
	
	//================================
}
