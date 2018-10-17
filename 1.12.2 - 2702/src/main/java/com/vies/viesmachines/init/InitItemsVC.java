package com.vies.viesmachines.init;

import java.util.HashSet;
import java.util.Set;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(References.MOD_ID)
public class InitItemsVC extends ItemsVM {
	
	public static void registerItemTEMP()
	{
		//========================
		//    To be deleted
		//========================
		
		
		
	}
	
	@Mod.EventBusSubscriber(modid = References.MOD_ID)
	public static class RegistrationHandler 
	{
		public static final Set<Item> ITEMS = new HashSet<>();
		
		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			final Item[] items = {
					//GUIDEBOOK,
					//ADAPTIVE_CIRCUIT,
					//ENERGIZED_CORE,
					
					CHARGED_SHARD,
					MACHINE_PELLETS,
					MACHINE_AMMO,
					
					LOGIC_CHIP,
					MACHINE_FRAME,
					MACHINE_ENGINE,
					
					MACHINE_COMPONENT_GROUND,
					MACHINE_COMPONENT_WATER,
					MACHINE_COMPONENT_FLYING,
					
					//--------------------------------------------------
					
					UPGRADE_FRAME_TIER1,
					UPGRADE_FRAME_TIER2,
					UPGRADE_FRAME_TIER3,
					
					UPGRADE_ENGINE_TIER1,
					UPGRADE_ENGINE_TIER2,
					UPGRADE_ENGINE_TIER3,
					
					UPGRADE_COMPONENT_TIER1,
					UPGRADE_COMPONENT_TIER2,
					UPGRADE_COMPONENT_TIER3,
					
					//--------------------------------------------------
					
					KIT_RAW,
					KIT_HEALTH_2,
					KIT_HEALTH_8,
					
					KIT_HEALTH_MAX,
					KIT_ENERGY_25,
					KIT_ENERGY_100,
					
					KIT_ENERGY_MAX,
					KIT_UPGRADE_MAX,
					KIT_MACHINE_MAX,
					
					//--------------------------------------------------
					
					ITEM_MACHINE_GROUND_HOVERCRAFT,
					ITEM_MACHINE_GROUND_2,
					ITEM_MACHINE_GROUND_3,
					
					ITEM_MACHINE_WATER_SUBMARINE,
					ITEM_MACHINE_WATER_2,
					ITEM_MACHINE_WATER_3,
					
					ITEM_MACHINE_FLYING_AIRSHIP,
					ITEM_MACHINE_FLYING_HELICOPTER,
					ITEM_MACHINE_FLYING_3,
					
					//--------------------------------------------------
					
					TOOL_DISMOUNTING,
					
					//--------------------------------------------------
					//--------------------------------------------------
					//--------------------------------------------------
					
					PARTICLE_BULLET_NORMAL,
					PARTICLE_BULLET_ELECTRICAL,
					PARTICLE_BULLET_EXPLOSIVE,
					
					PARTICLE_STATIC_CHARGE,
					
					/**
					
					
					AIRSHIP_IGNITION,
					AIRSHIP_FRAME,
					AIRSHIP_ENGINE,
					AIRSHIP_BALLOON,
					
					UPGRADE_CORE,
					UPGRADE_FRAME,
					UPGRADE_ENGINE,
					UPGRADE_BALLOON,
					
					BOMB,
					
					MODULE_TYPE,
					MODULE_CREATIVE,
					
					MACHINE_REPAIR_TOOL,
					
					ITEM_AIRSHIP,
					ITEM_AIRSHIP_CREATIVE,
					
					ACHIEVEMENT_AIRSHIP,
					ITEM_ENTITY_AIRSHIP,
					
					ITEM_DISPLAY_SYMBOL*/
					//================================
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) 
			{
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
