package com.vies.viesmachines.client;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.client.entity.machines.flying.renderers.airship.RenderEntityMachineFlyingAirship;
import com.vies.viesmachines.client.entity.machines.ground.renderers.hovercraft.RenderEntityMachineGround;
import com.vies.viesmachines.client.entity.machines.water.renderers.submarine.RenderEntityMachineWater;
import com.vies.viesmachines.client.entity.model.frame.ModelFrame0;
import com.vies.viesmachines.client.entity.model.frame.ModelFrame1;
import com.vies.viesmachines.client.entity.particles.renderers.RenderBulletElectrical;
import com.vies.viesmachines.client.entity.particles.renderers.RenderBulletExplosive;
import com.vies.viesmachines.client.entity.particles.renderers.RenderBulletNormal;
import com.vies.viesmachines.client.entity.particles.renderers.RenderStaticCharge;
import com.vies.viesmachines.client.entity.thrown.RenderThrownMachineFlying;
import com.vies.viesmachines.common.entity.machines.EntityMachineGround;
import com.vies.viesmachines.common.entity.machines.EntityMachineWater;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;
import com.vies.viesmachines.common.entity.particles.EntityBulletElectrical;
import com.vies.viesmachines.common.entity.particles.EntityBulletExplosive;
import com.vies.viesmachines.common.entity.particles.EntityBulletNormal;
import com.vies.viesmachines.common.entity.particles.EntityStaticCharge;
import com.vies.viesmachines.common.entity.thrown.EntityThrownMachineFlyingAirship;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public final class InitEntityVCRender extends ItemsVM {
	
	public static void registerEntityRender()
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntityBombSmall.class, renderManager -> new RenderBombSmall(renderManager));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBombBig.class, renderManager -> new RenderBombBig(renderManager));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBombScatter.class, renderManager -> new RenderBombScatter(renderManager));
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityThrownAirship.class, renderManager -> new RenderThrownAirship(renderManager));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBulletNormal.class, renderManager -> new RenderBulletNormal(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBulletElectrical.class, renderManager -> new RenderBulletElectrical(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBulletExplosive.class, renderManager -> new RenderBulletExplosive(renderManager));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityStaticCharge.class, renderManager -> new RenderStaticCharge(renderManager));
		
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityThrownMachineFlyingAirship.class, renderManager -> new RenderThrownMachineFlying(renderManager));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineGround.class, renderManager -> new RenderEntityMachineGround(renderManager, new ModelFrame0(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineWater.class, renderManager -> new RenderEntityMachineWater(renderManager, new ModelFrame1(), 1));
		//RenderingRegistry.registerEntityRenderingHandler(EntityMachineFlying.class, renderManager -> new RenderEntityMachineFlyingAirship(renderManager, new ModelFrame0(), 1));
		
		//===========================================
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineFlyingAirship.class, renderManager -> new RenderEntityMachineFlyingAirship(renderManager, new ModelFrame0(), 1));
		
		
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityAirshipCore.class, renderManager -> new RenderAirship(renderManager));
		
		
		/**
		registerRender1(EntityAirshipV1.class,  renderManager -> new RenderAirshipV1(renderManager));
		registerRender(EntityAirshipV2.class,  new RenderAirshipV2(VCRender));
		*/
	}
	
	public static void registerEntityRenderTEMP()
	{
		
	}
	
	//public static void registerRender1(Class<? extends Entity> classIn, Object renderItem)
	//{
	//	RenderingRegistry.registerEntityRenderingHandler(classIn, renderItem);
	//}
}
