package com.vies.viesmachines.api;

import com.vies.viesmachines.common.blocks.BlockGeneric;
import com.vies.viesmachines.common.blocks.basic.BlockFenceVM;
import com.vies.viesmachines.common.blocks.basic.BlockGateVM;
import com.vies.viesmachines.common.blocks.basic.BlockLadderVM;
import com.vies.viesmachines.common.blocks.basic.BlockPillarVM;
import com.vies.viesmachines.common.blocks.basic.BlockStairsVM;
import com.vies.viesmachines.common.blocks.basic.BlockTorchVM;
import com.vies.viesmachines.common.blocks.basic.BlockWallVM;
import com.vies.viesmachines.common.blocks.slab.BlockDoubleSlabVM;
import com.vies.viesmachines.common.blocks.slab.BlockHalfSlabVM;
import com.vies.viesmachines.common.blocks.tileentity.BlockExtractor;
import com.vies.viesmachines.common.blocks.tileentity.BlockKitFabricator;
import com.vies.viesmachines.common.blocks.tileentity.BlockMachineBeacon;
import com.vies.viesmachines.common.blocks.tileentity.BlockMachineTransmogrifier;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlocksVM {
	
	public static final BlockGeneric XEGONITE_BASIC = new BlockGeneric("block_xegonite_basic", Material.ROCK, SoundType.STONE);
	public static final BlockStairsVM XEGONITE_STAIRS = new BlockStairsVM("block_xegonite_stairs", Material.ROCK, SoundType.STONE, XEGONITE_BASIC);
	public static final BlockFenceVM XEGONITE_FENCE = new BlockFenceVM("block_xegonite_fence", Material.ROCK, SoundType.STONE);
	public static final BlockGateVM XEGONITE_GATE = new BlockGateVM("block_xegonite_gate", Material.ROCK, SoundType.STONE);
	public static final BlockWallVM XEGONITE_WALL = new BlockWallVM("block_xegonite_wall", Material.ROCK, SoundType.STONE, XEGONITE_BASIC);
	public static final BlockTorchVM XEGONITE_TORCH = new BlockTorchVM("block_xegonite_torch", Material.ROCK, SoundType.STONE);
	public static final BlockLadderVM XEGONITE_LADDER = new BlockLadderVM("block_xegonite_ladder", Material.ROCK, SoundType.STONE);
	public static final BlockPillarVM XEGONITE_PILLAR = new BlockPillarVM("block_xegonite_pillar", Material.ROCK, SoundType.STONE);
	public static final BlockGeneric XEGONITE_CHISELED = new BlockGeneric("block_xegonite_chiseled", Material.ROCK, SoundType.STONE);
	
	public static final BlockGeneric WATER_BASIC = new BlockGeneric("block_water_basic", Material.ROCK, SoundType.STONE);
	public static final BlockStairsVM WATER_STAIRS = new BlockStairsVM("block_water_stairs", Material.ROCK, SoundType.STONE, WATER_BASIC);
	public static final BlockFenceVM WATER_FENCE = new BlockFenceVM("block_water_fence", Material.ROCK, SoundType.STONE);
	public static final BlockGateVM WATER_GATE = new BlockGateVM("block_water_gate", Material.ROCK, SoundType.STONE);
	public static final BlockWallVM WATER_WALL = new BlockWallVM("block_water_wall", Material.ROCK, SoundType.STONE, WATER_BASIC);
	public static final BlockTorchVM WATER_TORCH = new BlockTorchVM("block_water_torch", Material.ROCK, SoundType.STONE);
	public static final BlockLadderVM WATER_LADDER = new BlockLadderVM("block_water_ladder", Material.ROCK, SoundType.STONE);
	public static final BlockPillarVM WATER_PILLAR = new BlockPillarVM("block_water_pillar", Material.ROCK, SoundType.STONE);
	public static final BlockGeneric WATER_CHISELED = new BlockGeneric("block_water_chiseled", Material.ROCK, SoundType.STONE);
	
	public static final BlockGeneric LAVA_BASIC = new BlockGeneric("block_lava_basic", Material.ROCK, SoundType.STONE);
	public static final BlockStairsVM LAVA_STAIRS = new BlockStairsVM("block_lava_stairs", Material.ROCK, SoundType.STONE, LAVA_BASIC);
	public static final BlockFenceVM LAVA_FENCE = new BlockFenceVM("block_lava_fence", Material.ROCK, SoundType.STONE);
	public static final BlockGateVM LAVA_GATE = new BlockGateVM("block_lava_gate", Material.ROCK, SoundType.STONE);
	public static final BlockWallVM LAVA_WALL = new BlockWallVM("block_lava_wall", Material.ROCK, SoundType.STONE, LAVA_BASIC);
	public static final BlockTorchVM LAVA_TORCH = new BlockTorchVM("block_lava_torch", Material.ROCK, SoundType.STONE);
	public static final BlockLadderVM LAVA_LADDER = new BlockLadderVM("block_lava_ladder", Material.ROCK, SoundType.STONE);
	public static final BlockPillarVM LAVA_PILLAR = new BlockPillarVM("block_lava_pillar", Material.ROCK, SoundType.STONE);
	public static final BlockGeneric LAVA_CHISELED = new BlockGeneric("block_lava_chiseled", Material.ROCK, SoundType.STONE);
	
	public static final BlockGeneric ENDER_BASIC = new BlockGeneric("block_ender_basic", Material.ROCK, SoundType.STONE);
	public static final BlockStairsVM ENDER_STAIRS = new BlockStairsVM("block_ender_stairs", Material.ROCK, SoundType.STONE, ENDER_BASIC);
	public static final BlockFenceVM ENDER_FENCE = new BlockFenceVM("block_ender_fence", Material.ROCK, SoundType.STONE);
	public static final BlockGateVM ENDER_GATE = new BlockGateVM("block_ender_gate", Material.ROCK, SoundType.STONE);
	public static final BlockWallVM ENDER_WALL = new BlockWallVM("block_ender_wall", Material.ROCK, SoundType.STONE, ENDER_BASIC);
	public static final BlockTorchVM ENDER_TORCH = new BlockTorchVM("block_ender_torch", Material.ROCK, SoundType.STONE);
	public static final BlockLadderVM ENDER_LADDER = new BlockLadderVM("block_ender_ladder", Material.ROCK, SoundType.STONE);
	public static final BlockPillarVM ENDER_PILLAR = new BlockPillarVM("block_ender_pillar", Material.ROCK, SoundType.STONE);
	public static final BlockGeneric ENDER_CHISELED = new BlockGeneric("block_ender_chiseled", Material.ROCK, SoundType.STONE);
	
	
	
	
	
	
	
	//--------------------------------------------------
	//public static final BlockDoubleSlabVM XEGONITE_SLAB_DOUBLE = new BlockDoubleSlabVM("block_xegonite_slab_double", Material.ROCK, SoundType.STONE);
	//public static final BlockHalfSlabVM XEGONITE_SLAB_HALF = new BlockHalfSlabVM("block_xegonite_slab_half", Material.ROCK, SoundType.STONE);
	
	//public static final BlockGeneric XEGONITE_BRICK = new BlockGeneric("block_xegonite_brick", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric XEGONITE_CHISELED = new BlockGeneric("block_xegonite_chiseled", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric XEGONITE_BARS = new BlockGeneric("block_xegonite_bars", Material.ROCK, SoundType.STONE);
	
	//public static final BlockGeneric XEGONITE_ROAD = new BlockGeneric("block_xegonite_road", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric XEGONITE_TRAPDOOR = new BlockGeneric("block_xegonite_trapdoor", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric XEGONITE_DOOR = new BlockGeneric("block_xegonite_door", Material.ROCK, SoundType.STONE);
	
	//public static final BlockGeneric XEGONITE_GLASS = new BlockGeneric("block_xegonite_glass", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric XEGONITE_GLASS_PANE = new BlockGeneric("block_xegonite_glass_pane", Material.ROCK, SoundType.STONE);
	//public static final BlockGeneric XEGONITE_CRAFTING_TABLE = new BlockGeneric("block_xegonite_crafting_table", Material.ROCK, SoundType.STONE);
	
	//==================================================
    // TODO             Appliances
	//==================================================
    
	public static final BlockExtractor EXTRACTOR = new BlockExtractor("appliance/extractor", Material.GLASS, SoundType.STONE);
	public static final BlockKitFabricator KIT_FABRICATOR = new BlockKitFabricator("appliance/kit_fabricator", Material.GLASS, SoundType.STONE);
	public static final BlockMachineTransmogrifier MACHINE_TRANSMOGRIFIER = new BlockMachineTransmogrifier("appliance/machine_transmogrifier", Material.GLASS, SoundType.STONE);
	public static final BlockMachineBeacon MACHINE_BEACON = new BlockMachineBeacon("appliance/machine_beacon", Material.GLASS, SoundType.STONE);
	
	
	
	//==================================================
    // TODO             Decorations
	//==================================================
    
	public static final BlockGeneric ITEM_DISPLAY = new BlockGeneric("decoration/item_display", Material.ROCK, SoundType.STONE);
	
	
	
	
	
	
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
