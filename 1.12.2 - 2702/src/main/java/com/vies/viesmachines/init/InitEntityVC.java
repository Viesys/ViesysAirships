package com.vies.viesmachines.init;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineGround;
import com.vies.viesmachines.common.entity.machines.EntityMachineWater;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;
import com.vies.viesmachines.common.entity.particles.EntityBulletElectrical;
import com.vies.viesmachines.common.entity.particles.EntityBulletExplosive;
import com.vies.viesmachines.common.entity.particles.EntityBulletNormal;
import com.vies.viesmachines.common.entity.particles.EntityStaticCharge;
import com.vies.viesmachines.common.entity.thrown.EntityThrownMachineFlyingAirship;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void registerEntity()
	{
		register("particle_bullet_normal", EntityBulletNormal.class, "particle.bullet.normal", 128, 1, true);
		register("particle_bullet_electrical", EntityBulletElectrical.class, "particle.bullet.electrical", 128, 1, true);
		register("particle_bullet_explosive", EntityBulletExplosive.class, "particle.bullet.explosive", 128, 1, true);
		
		register("particle_static_charge", EntityStaticCharge.class, "particle.static.charge", 64, 20, true);
		
		
		
		register("thrown_machine_flying_airship", EntityThrownMachineFlyingAirship.class, "thrown.machine.flying.airship", 64, 20, true);
		
		//register("entity_thrown_airship", EntityThrownAirship.class, "entity.thrown.airship", 64, 20, true);
		
		//===========================================
		
		//register("entity_airship", EntityAirshipCore.class, "entity.airship", 64, 1, true);
		
		register("machine_ground", EntityMachineGround.class, "machine.ground", 128, 1, true);
		register("machine_water", EntityMachineWater.class, "machine.water", 128, 1, true);
		//register("machine_flying", EntityMachineFlying.class, "machine.flying", 128, 1, true);
		
		
		//===========================================
		
		register("machine.flying.airship", EntityMachineFlyingAirship.class, "machine.flying.airship", 128, 1, true);
		
		//register("entity_bomb_small", EntityBombSmall.class, "entity.bomb.small", 64, 1, true);
		//register("entity_bomb_big", EntityBombBig.class, "entity.bomb.big", 64, 1, true);
		//register("entity_bomb_scatter", EntityBombScatter.class, "entity.bomb.scatter", 64, 1, true);
	}
	
	public static void registerEntityTEMP()
	{
		
	}
	
	public static void register(String name, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(References.MOD_ID + ":" + name), entityClass, entityName, entityID++, ViesMachines.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}
