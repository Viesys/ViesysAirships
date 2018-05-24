package com.viesys.viesysairships.client;

import com.viesys.viesysairships.client.tileentity.render.RenderAirshipWorkbench;
import com.viesys.viesysairships.common.tileentity.TileEntityAirshipWorkbench;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public final class InitTileEntityVCRender {
	
	public static void registerTileEntityRender()
	{
		registerRender(TileEntityAirshipWorkbench.class, new RenderAirshipWorkbench());
		//registerRender(TileEntityBatteryCharger.class, new RenderBatteryCharger());
	}
	
	public static void registerTileEntityRenderTEMP()
	{
		
	}
	
	public static <T extends TileEntity> void registerRender(Class<T> classIn, TileEntitySpecialRenderer<? super T> renderItem)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(classIn, renderItem);
	}
}