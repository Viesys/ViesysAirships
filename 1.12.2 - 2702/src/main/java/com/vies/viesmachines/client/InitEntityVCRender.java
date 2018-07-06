package com.vies.viesmachines.client;

import com.vies.viesmachines.api.ItemsVC;
import com.vies.viesmachines.client.entity.model.frame.ModelFrame0;
import com.vies.viesmachines.client.entity.model.frame.ModelFrame1;
import com.vies.viesmachines.client.entity.render.RenderEntityMachineFlying;
import com.vies.viesmachines.client.entity.render.RenderEntityMachineGround;
import com.vies.viesmachines.client.entity.render.RenderEntityMachineWater;
import com.vies.viesmachines.common.entity.machines.EntityMachineFlying;
import com.vies.viesmachines.common.entity.machines.EntityMachineGround;
import com.vies.viesmachines.common.entity.machines.EntityMachineWater;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public final class InitEntityVCRender extends ItemsVC {
	
	public static void registerEntityRender()
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntityBombSmall.class, renderManager -> new RenderBombSmall(renderManager));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBombBig.class, renderManager -> new RenderBombBig(renderManager));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBombScatter.class, renderManager -> new RenderBombScatter(renderManager));
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityThrownAirship.class, renderManager -> new RenderThrownAirship(renderManager));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineGround.class, renderManager -> new RenderEntityMachineGround(renderManager, new ModelFrame0(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineWater.class, renderManager -> new RenderEntityMachineWater(renderManager, new ModelFrame1(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineFlying.class, renderManager -> new RenderEntityMachineFlying(renderManager, new ModelFrame0(), 1));
		
		//===========================================
		
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
