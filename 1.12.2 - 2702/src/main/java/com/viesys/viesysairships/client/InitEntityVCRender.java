package com.viesys.viesysairships.client;

import com.viesys.viesysairships.api.ItemsVC;
import com.viesys.viesysairships.client.entity.render.RenderAirship;
import com.viesys.viesysairships.client.entity.render.RenderAirshipTEST;
import com.viesys.viesysairships.client.entity.render.RenderBombBig;
import com.viesys.viesysairships.client.entity.render.RenderBombScatter;
import com.viesys.viesysairships.client.entity.render.RenderBombSmall;
import com.viesys.viesysairships.client.entity.render.RenderThrownAirship;
import com.viesys.viesysairships.common.entity.EntityBombBig;
import com.viesys.viesysairships.common.entity.EntityBombScatter;
import com.viesys.viesysairships.common.entity.EntityBombSmall;
import com.viesys.viesysairships.common.entity.EntityMachineBase;
import com.viesys.viesysairships.common.entity.EntityThrownAirship;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipCore;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public final class InitEntityVCRender extends ItemsVC {
	
	public static void registerEntityRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBombSmall.class, renderManager -> new RenderBombSmall(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBombBig.class, renderManager -> new RenderBombBig(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBombScatter.class, renderManager -> new RenderBombScatter(renderManager));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityThrownAirship.class, renderManager -> new RenderThrownAirship(renderManager));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineBase.class, renderManager -> new RenderAirshipTEST(renderManager));
		
		//===========================================
		
		RenderingRegistry.registerEntityRenderingHandler(EntityAirshipCore.class, renderManager -> new RenderAirship(renderManager));
		
		
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
