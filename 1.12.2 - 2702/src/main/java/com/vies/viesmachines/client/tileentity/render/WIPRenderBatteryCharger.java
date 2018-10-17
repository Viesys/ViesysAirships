package com.vies.viesmachines.client.tileentity.render;

import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.tileentity.model.WIPModelBatteryCharger;
import com.vies.viesmachines.common.tileentity.WIPTileEntityBatteryCharger;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class WIPRenderBatteryCharger extends TileEntitySpecialRenderer<WIPTileEntityBatteryCharger> {
	
	ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/models/airship_workbench.png");
	private WIPModelBatteryCharger model;
	
	public WIPRenderBatteryCharger() 
	{
		this.model = new WIPModelBatteryCharger();
	}
	
	@Override
	public void render(WIPTileEntityBatteryCharger te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		
		this.model.renderModel(0.0625f);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
