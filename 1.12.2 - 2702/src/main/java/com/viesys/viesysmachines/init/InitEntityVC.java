package com.viesys.viesysmachines.init;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.api.References;
import com.viesys.viesysmachines.common.entity.EntityBombBig;
import com.viesys.viesysmachines.common.entity.EntityBombScatter;
import com.viesys.viesysmachines.common.entity.EntityBombSmall;
import com.viesys.viesysmachines.common.entity.EntityMachineBase;
import com.viesys.viesysmachines.common.entity.EntityThrownAirship;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void registerEntity()
	{
		register("entity_thrown_airship", EntityThrownAirship.class, "entity.thrown.airship", 64, 20, true);
		
		//===========================================
		
		register("entity_airship", EntityAirshipCore.class, "entity.airship", 64, 1, true);
		
		register("entity_test", EntityMachineBase.class, "entity.test", 64, 1, true);
		
		//===========================================
		
		register("entity_bomb_small", EntityBombSmall.class, "entity.bomb.small", 64, 1, true);
		register("entity_bomb_big", EntityBombBig.class, "entity.bomb.big", 64, 1, true);
		register("entity_bomb_scatter", EntityBombScatter.class, "entity.bomb.scatter", 64, 1, true);
	}
	
	public static void registerEntityTEMP()
	{
		
	}
	
	public static void register(String name, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(References.MOD_ID_COLON + name), entityClass, entityName, entityID++, ViesysMachines.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}
