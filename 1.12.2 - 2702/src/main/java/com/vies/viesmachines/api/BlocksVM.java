package com.vies.viesmachines.api;

import com.vies.viesmachines.common.blocks.tileentity.BlockExtractor;
import com.vies.viesmachines.common.blocks.tileentity.BlockKitFabricator;
import com.vies.viesmachines.common.blocks.tileentity.BlockMachineBeacon;
import com.vies.viesmachines.common.blocks.tileentity.BlockMachineTransmogrifier;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlocksVM {
	
	
	//public static final BlockGeneric CHARGED_STONE_BASIC = new BlockGeneric("block_charged_stone_block", Material.ROCK, SoundType.STONE);
	//public static final BlockDoubleSlabVM CHARGED_STONE_DOUBLESLAB = new BlockDoubleSlabVM("block_charged_stone_doubleslab", Material.ROCK, SoundType.STONE);
	//public static final BlockHalfSlabVM CHARGED_STONE_HALFSLAB = new BlockHalfSlabVM("block_charged_stone_halfslab", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric CHARGED_STONE_STAIRS = new BlockGeneric("charged_stone_stairs", Material.ROCK, SoundType.STONE);
	//public static final BlockFenceVM CHARGED_STONE_FENCE = new BlockFenceVM("block_charged_stone_fence", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric CHARGED_STONE_GATE = new BlockGeneric("charged_stone_gate", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric CHARGED_STONE_WALL = new BlockGeneric("charged_stone_wall", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric CHARGED_STONE_TORCH = new BlockGeneric("charged_stone_torch", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric CHARGED_STONE_LADDER = new BlockGeneric("charged_stone_ladder", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric CHARGED_STONE_PILLAR = new BlockGeneric("charged_stone_pillar", Material.ROCK, SoundType.STONE);
	
	
	
	//==================================================
    // TODO             Appliances
	//==================================================
    
	public static final BlockExtractor EXTRACTOR = new BlockExtractor("appliance_extractor", Material.ROCK, SoundType.STONE);
	
	public static final BlockKitFabricator KIT_FABRICATOR = new BlockKitFabricator("appliance_kit_fabricator", Material.ROCK, SoundType.STONE);
	
	public static final BlockMachineTransmogrifier MACHINE_TRANSMOGRIFIER = new BlockMachineTransmogrifier("appliance_machine_transmogrifier", Material.ROCK, SoundType.STONE);
	
	public static final BlockMachineBeacon MACHINE_BEACON = new BlockMachineBeacon("appliance_machine_beacon", Material.ROCK, SoundType.STONE);
	
	
	
	
	
	
	//public static final BlockMachineTransmogrifier MACHINE_CHARGE_STATION = new BlockMachineTransmogrifier("block_fabricator");
	//public static final BlockAirshipWorkbench AIRSHIP_WORKBENCH = new BlockAirshipWorkbench("airship_workbench");
	
	
	
	//Unused
	//public static Block onyxius_ore;
	//public static Block carnelian_ore;
	//public static Block velium_ore;
	//public static Block amplimet_ore;
	//public static Block enstatite_ore;
	//public static Block velium_ore;
	//public static Block infernus_ore;
	//public static Block norn_stone;
	//public static Block mystalite_ore;
	
	/////public static Block airship_workbench;
	/////public static Block battery_charger;
	
}
