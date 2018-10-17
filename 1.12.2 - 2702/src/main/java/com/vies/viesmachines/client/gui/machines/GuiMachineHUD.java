package com.vies.viesmachines.client.gui.machines;

import java.awt.Color;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.common.entity.machines.EntityMachineFlying;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiMachineHUD extends Gui {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	private static FontRenderer fontRenderer;
	private static final ResourceLocation FLYING_HUD_TEXTURE = new ResourceLocation(References.MOD_ID, "textures/gui/hud_machine_flying.png");
	
	private final int hudWidth;
	private final int hudHeight;
	private float speedMod;
	
	private EntityMachineFlying flyingMachine;
	
	public GuiMachineHUD()
	{
		super();
		
		hudWidth = 108;
        hudHeight = 26;
        
        fontRenderer = mc.fontRenderer;
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderFlyingMachineBarPre(RenderGameOverlayEvent.Pre event) 
	{
		if(event.getType() == ElementType.ALL) 
		{
			if(mc.player.getRidingEntity() instanceof EntityMachineFlying)
		    {
				GuiIngameForge.renderHealthMount = false;
		    }
			else
			{
				if(GuiIngameForge.renderHealthMount == false)
				{
					GuiIngameForge.renderHealthMount = true;
				}
			}
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderFlyingMachineBar(RenderGameOverlayEvent.Post event) 
	{
		
		if(event.getType() == ElementType.ALL) 
		{
			if(mc.player.getRidingEntity() instanceof EntityMachineFlying)
		    {
				this.flyingMachine = (EntityMachineFlying) Minecraft.getMinecraft().player.getRidingEntity();
				
				GlStateManager.enableRescaleNormal();
	            GlStateManager.enableBlend();
	            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
	            
	            //Add this block of code before you draw the section of your texture containing transparency
	 			GlStateManager.pushAttrib();
	 			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	 			GlStateManager.disableLighting();
	 			
	 			//Alpha test and blend needed due to vanilla or Forge rendering bug
	 			GlStateManager.enableAlpha();
	 			GlStateManager.enableBlend();
	         	
	            Minecraft.getMinecraft().getTextureManager().bindTexture(FLYING_HUD_TEXTURE);
				
	            //Screen resolution
				ScaledResolution sr = new ScaledResolution(mc);
	            int hudX = sr.getScaledWidth() / 2 - (this.hudWidth / 2); // left edge of GUI
	            
	            int hudY = sr.getScaledHeight() - 56; //2; // top edge of GUI
	            
	            //int hudYtest = sr.getScaledHeight() - 56;
	            
	            //int textX = hudX + 30; // xcoord for text
	            //int textY = hudY + 22; // ycoord for text
	            //int ledX = 1;
				
	            int hudXDefault = hudX + 45;//+ this.hudWidth;
	            int hudYDefault = hudY;
	            //LogHelper.info("X = " + hudX);
	            //LogHelper.info("Y = " + (hudYtest - (hudYtest/2)));
	            
	            GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXDefault, hudYDefault, 0);
					//GlStateManager.scale(0.5F, 0.5F, 0.5F);
					
					//Draw the background static texture.
					drawTexturedModalRect(0, 0, 0, 0, 108, 26
							//hudWidth, hudHeight
							);
				}
				GlStateManager.popMatrix();
				
				//Bottom lower fuel bar
				//Creates a solid green bar
				//if(this.machine.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
				//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
				//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
				//{
				//	drawTexturedModalRect(hudX + 36, hudY + 31, 36, 72, hudX, 6);
				//}
				//else
				{
					int fuelbarwidth1 = (int)(((float) this.flyingMachine.getFuel() / (this.flyingMachine.getFuelTotal())) * 101);
					
					drawTexturedModalRect(hudXDefault, hudYDefault + 9, 128, 9, fuelbarwidth1, 10);
				}
				
				//Top bigger stack bar
				//Creates a solid green bar
				//if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
				//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
				//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
				//{
				//	drawTexturedModalRect(hudX + 2, hudY + 14, 2, 66, 177, 6);
				//}
				//else
				//{
				//	int fuelbarwidth2 = (int)(((float) this.flyingMachine.fuelItemStackSize / 64) * 178);
				//	drawTexturedModalRect(hudX + 2, hudY + 14, 2, 53, fuelbarwidth2, 6);
				//}
				
				//Airship lights on
				//if(this.flyingMachine.getStoredFuel() >= 1)
				//{
				//	drawTexturedModalRect(hudX + 16, hudY, 16, 44, 150, 7);
				//}
				
				//Draw Module Icon
				//GlStateManager.pushMatrix();
				//{
				//	GlStateManager.translate(hudX + 85, hudY + 2, 0);
				//	GlStateManager.scale(1.5, 1.5, 1.5);
					
				//	if(this.flyingMachine.getModuleActiveSlot1() > 0)
				//	{
				//		this.drawModuleIcon(this.flyingMachine.getModuleActiveSlot1());
				//	}
				//}
				//GlStateManager.popMatrix();
				
				//Draw Yellow Border over Module Icon
				//if(this.airship.getModuleActiveSlot1() > 0)
				//{
				//	this.drawTexturedModalRect(hudX + 83, hudY + 0, 0, 224, 16, 16);
				//}
				
				//Altitude Logic
				//this.renderHUDAltitude(hudX, hudY);
				
				//Timer Logic
				//this.renderHUDFuelTimer(hudXDefault, hudYDefault);
				
				
				
				this.renderHUDMachineHP(hudXDefault, hudYDefault);
				
				this.renderHUDMachineEP(hudXDefault, hudYDefault);
				
				//
				this.drawItemStack(Item.getItemById(this.flyingMachine.getItemstackFuelItem()).getDefaultInstance(), hudXDefault, hudYDefault);
				
				
				//Shows the Item in the fuel slot regardless of creative or survival.
				if (!this.flyingMachine.inventory.getStackInSlot(0).isEmpty())
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault+88, hudYDefault+2.5, 0);
						GlStateManager.scale(0.5, 0.5, 0.5);
						
						this.drawCenteredString(fontRenderer, "x", 0, 0, Color.WHITE.getRGB());
					}
					GlStateManager.popMatrix();
					
					
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault+95, hudYDefault+3, 0);
						GlStateManager.scale(0.5, 0.5, 0.5);
						
						this.drawCenteredString(fontRenderer, Integer.toString(this.flyingMachine.getItemstackFuelSize()), 0, 0, Color.WHITE.getRGB());
					}
					GlStateManager.popMatrix();
				}
				
				//GlStateManager.pushMatrix();
				//{
				//	GlStateManager.translate(hudXDefault+95, hudYDefault+3, 0);
				//	GlStateManager.scale(0.5, 0.5, 0.5);
					
				//	this.drawCenteredString(fontRenderer, Integer.toString(0), 0, 0, Color.WHITE.getRGB());
				//}
				//GlStateManager.popMatrix();
				
				
				GlStateManager.popAttrib();
		    }
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderMachineBar(RenderGameOverlayEvent.Post event) 
	{
		if(event.getType() == ElementType.ALL) 
		{
			GuiIngameForge.renderFood = true;
			
			this.isMachine = mc.player.getRidingEntity() instanceof EntityMachineBase;
			
			if(this.isMachine)
		    {
				this.machine = (EntityMachineBase) Minecraft.getMinecraft().player.getRidingEntity();
				
				GlStateManager.enableRescaleNormal();
	            GlStateManager.enableBlend();
	            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
	            
	            //Add this block of code before you draw the section of your texture containing transparency
	 			GlStateManager.pushAttrib();
	 			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	 			GlStateManager.disableLighting();
	 			
	 			//Alpha test and blend needed due to vanilla or Forge rendering bug
	 			GlStateManager.enableAlpha();
	 			GlStateManager.enableBlend();
	         	
	            Minecraft.getMinecraft().getTextureManager().bindTexture(HUD_TEXTURE);
				
	            //Screen resolution
				ScaledResolution sr = new ScaledResolution(mc);
	            int hudX = sr.getScaledWidth() / 2 - (hudWidth / 2); // left edge of GUI
	            int hudY = 2; // top edge of GUI
	            int textX = hudX + 30; // xcoord for text
	            int textY = hudY + 22; // ycoord for text
	            int ledX = 1;
				
				//Draw the background static texture.
				drawTexturedModalRect(hudX, hudY, 0, 0, hudWidth, hudHeight + 2);
				
				//Bottom lower fuel bar
				//Creates a solid green bar
				//if(this.machine.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
				//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
				//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
				//{
				//	drawTexturedModalRect(hudX + 36, hudY + 31, 36, 72, hudX, 6);
				//}
				//else
				{
					int fuelbarwidth1 = (int)(((float) this.machine.getStoredFuel() / (this.machine.getStoredFuelTotal())) * 110);
					
					drawTexturedModalRect(hudX + 36, hudY + 31, 36, 59, fuelbarwidth1, 6);
				}
				
				//Top bigger stack bar
				//Creates a solid green bar
				//if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
				//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
				//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
				//{
				//	drawTexturedModalRect(hudX + 2, hudY + 14, 2, 66, 177, 6);
				//}
				//else
				{
					int fuelbarwidth2 = (int)(((float) this.machine.getFuelItemStackSizePowered() / 64) * 178);
					drawTexturedModalRect(hudX + 2, hudY + 14, 2, 53, fuelbarwidth2, 6);
				}
				
				//Airship lights on
				if(this.machine.getStoredFuel() >= 1)
				{
					drawTexturedModalRect(hudX + 16, hudY, 16, 44, 150, 7);
				}
				
				//Draw Module Icon
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudX + 85, hudY + 2, 0);
					GlStateManager.scale(1.5, 1.5, 1.5);
					
					if(this.airship.getModuleActiveSlot1() > 0)
					{
						this.drawModuleIcon(this.airship.getModuleActiveSlot1());
					}
				}
				GlStateManager.popMatrix();
				
				//Draw Yellow Border over Module Icon
				if(this.airship.getModuleActiveSlot1() > 0)
				{
					this.drawTexturedModalRect(hudX + 83, hudY + 0, 0, 224, 16, 16);
				}
				
				//Altitude Logic
				this.renderHUDAltitude(hudX, hudY);
				
				//Timer Logic
				this.renderHUDFuelTimer(hudX, hudY);
				
				GlStateManager.popAttrib();
		    }
		}
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void drawModuleIcon(int metaIn)
	{
		if(metaIn == EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 0, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 8, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 16, 248, 8, 8);
		}
		
		if(metaIn == EnumsVM.ModuleType.SPEED_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 24, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.SPEED_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 32, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.SPEED_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 40, 248, 8, 8);
		}
		
		if(metaIn == EnumsVM.ModuleType.STORAGE_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 48, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 56, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.STORAGE_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 64, 248, 8, 8);
		}
		
		if(metaIn == EnumsVM.ModuleType.FUEL_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 72, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.FUEL_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 80, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.FUEL_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 88, 248, 8, 8);
		}
		
		if(metaIn == EnumsVM.ModuleType.MUSIC_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 96, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 104, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.MUSIC_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 112, 248, 8, 8);
		}
		
		if(metaIn == EnumsVM.ModuleType.CRUISE_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 120, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 128, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.CRUISE_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 136, 248, 8, 8);
		}
		
		if(metaIn == EnumsVM.ModuleType.WATER_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 144, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.WATER_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 152, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.WATER_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 160, 248, 8, 8);
		}
		
		if(metaIn == EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 168, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 176, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 184, 248, 8, 8);
		}
		
		if(metaIn == EnumsVM.ModuleType.BOMB_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 192, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.BOMB_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 200, 248, 8, 8);
		}
		if(metaIn == EnumsVM.ModuleType.BOMB_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 208, 248, 8, 8);
		}
	}
	
	
	/**
	private void renderHUDAltitude(int hudXIn, int hudYIn)
	{
		//Altitude Current
		//Check if Altitude module is in.
		if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(hudXIn + 74, hudYIn + 6, 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getPosition().getY()), 0, 0, 60155);
			}
			GlStateManager.popMatrix();
		}
		else
		{
			//Makes Current Altitude color Red
			if(this.airship.getPosition().getY() >= (int)EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude() - 5)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 74, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getPosition().getY()), 0, 0, 16711680);
				}
				GlStateManager.popMatrix();
			}
			//Makes Current Altitude color Yellow
			else if(this.airship.getPosition().getY() >= (int)EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude() - 15)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 74, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getPosition().getY()), 0, 0, 16187136);
				}
				GlStateManager.popMatrix();
			}
			//Makes Current Altitude color Green
			else
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 74, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getPosition().getY()), 0, 0, 196352);
				}
				GlStateManager.popMatrix();
			}
		}
		
		
		
		//Altitude Max
		//Check if Altitude module is in.
		if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
		{
			if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, "225", 0, 0, 60155);
				}
				GlStateManager.popMatrix();
			}
			else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, "250", 0, 0, 60155);
				}
				GlStateManager.popMatrix();
			}
			else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, "\u221e", 0, 0, 60155);
				}
				GlStateManager.popMatrix();
			}
		}
		else
		{
			//Makes Current Altitude color Red
			if(this.airship.getPosition().getY() >= (int)EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude() - 5)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude()), 0, 0, 16711680);
				}
				GlStateManager.popMatrix();
			}
			//Makes Current Altitude color Yellow
			else if(this.airship.getPosition().getY() >= (int)EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude() - 15)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude()), 0, 0, 16187136);
				}
				GlStateManager.popMatrix();
			}
			//Makes Current Altitude color Green
			else
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude()), 0, 0, 196352);
				}
				GlStateManager.popMatrix();
			}
		}
	}
	
	*/
	
	private void renderHUDFuelTimer(int hudXIn, int hudYIn)
	{
		//Timer logic
		int timer;
		int remainder;
		int minutes;
		int seconds;
		int hours;
		/**
		//Calculation from ticks to seconds.
		if(this.flyingMachine.storedFuel == 0)
		{
			timer = ((((this.flyingMachine.getStoredFuel() / 10) + 18) + (this.flyingMachine.fuelItemStack / 10)) / 20);
		}
		else
		{
			timer = ((((this.flyingMachine.getStoredFuel() / this.flyingMachine.storedFuel) + 18) + (this.flyingMachine.fuelItemStack / this.flyingMachine.storedFuel)) / 20);
		}
		*/
		
		
		timer = 0;
				
		if(this.flyingMachine.getFuel() > 0)
		{
			timer = 
					(int) ((
							//(float)(this.flyingMachine.storedFuel) / 
							(float)(this.flyingMachine.getItemBurnTime(Item.getItemById(this.flyingMachine.getItemstackFuelItem()).getDefaultInstance()))
							/
							(float)(this.flyingMachine.getFuel())
					)*100);
		}
		
		//else
		//{
		//	timer = 0;
		//}
				//((((this.flyingMachine.storedFuel / this.flyingMachine.storedFuel) + 18) + (this.flyingMachine.fuelItemStack / this.flyingMachine.storedFuel)) / 20);
		
		
		remainder = (timer % 3600);
		minutes = remainder / 60;
		seconds = remainder % 60;
		hours = timer / 3600;
		
		//Converts time to normal standards
		String hrs = (hours < 10 ? "0" : "") + hours;
		String mins = (minutes < 10 ? "0" : "") + minutes;
		String secs = (seconds < 10 ? "0" : "") + seconds;
		
		//if(this.flyingMachine.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		//|| this.flyingMachine.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		//|| this.flyingMachine.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		//{
			//Time "infinite" to display
		//	String s1 = "\u221e" + ":" + "\u221e" + ":" + "\u221e";
			
		//	GlStateManager.pushMatrix();
		//	{
		//		GlStateManager.translate(hudXIn + 91, hudYIn + 22.5, 0);
		//		GlStateManager.scale(0.75, 0.75, 0.75);
				
		//		this.drawCenteredString(fontRenderer, s1, 0, 0, 196352);
		//	}
		//	GlStateManager.popMatrix();
		//}
		//else
		
		
		LogHelper.info(
				
				this.flyingMachine.getFuel() 
				+ "  -  " +
				this.flyingMachine.getItemBurnTime(Item.getItemById(this.flyingMachine.getItemstackFuelItem()).getDefaultInstance())
				+ "  -  " +
				
				(
						(float)this.flyingMachine.getFuel() / 
						(float)this.flyingMachine.getItemBurnTime(Item.getItemById(this.flyingMachine.getItemstackFuelItem()).getDefaultInstance())
				)*100
				
				+ "  -  " +
				
				//(float)this.flyingMachine.storedFuel / this.flyingMachine.getItemBurnTime(Item.getItemById(this.flyingMachine.itemstackFuelItem).getDefaultInstance()) * 100
				//+ "  -  " +
				timer 
				
				
				);
		
		{
			//Time in seconds to display
			String s = hrs + ":" + mins + ":" + secs;
			String s2 = "*" + References.localNameVC("vm.hud.nofuel") + "*";
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(hudXIn + 72.5, hudYIn + 3, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				//Aqua timer
				if(hours > 0)
				{
					this.drawCenteredString(fontRenderer, s, 0, 0, 60155);
				}
				else if(minutes >= 15 && seconds >= 0)
				{
					this.drawCenteredString(fontRenderer, s, 0, 0, 60155);
				}
				//Green timer
				else if(minutes >= 5 && seconds >= 0)
				{
					this.drawCenteredString(fontRenderer, s, 0, 0, 1571584);
				}
				//Yellow timer
				else if(minutes >= 2 && seconds >= 0)
				{
					this.drawCenteredString(fontRenderer, s, 0, 0, 15596288);
				}
				//Orange timer
				else if(minutes >= 1 && seconds >= 0)
				{
					this.drawCenteredString(fontRenderer, s, 0, 0, 16493312);
				}
				//Red timer
				else if(seconds >= 1)
				{
					this.drawCenteredString(fontRenderer, s, 0, 0, 16449536);
				}
				//Timer Off
				else if(seconds >= 0)
				{
					this.drawCenteredString(fontRenderer, s2, 0, 0, 16449536);
				}
			}
			GlStateManager.popMatrix();
		}
	}
	
	private void renderHUDMachineHP(int hudXIn, int hudYIn)
	{
		int HPcolor = Color.CYAN.getRGB();
		
		if ((int)this.flyingMachine.getHealth() < (int)this.flyingMachine.getMaxHealth())
		{
			HPcolor = Color.RED.getRGB();
		}
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(hudXIn + 7, hudYIn + 3, 0);
			GlStateManager.scale(0.5, 0.5, 0.5);
			
			this.drawCenteredString(fontRenderer, Integer.toString((int)this.flyingMachine.getHealth())
					, 0, 0, HPcolor);
		}
		GlStateManager.popMatrix();
	}
	
	private void renderHUDMachineEP(int hudXIn, int hudYIn)
	{
		int EPcolor = Color.CYAN.getRGB();
		
		if ((int)this.flyingMachine.getHealth() < (int)this.flyingMachine.getMaxHealth())
		{
			EPcolor = Color.YELLOW.getRGB();
		}
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(hudXIn + 19.5, hudYIn + 3, 0);
			GlStateManager.scale(0.5, 0.5, 0.5);
			
			this.drawCenteredString(fontRenderer, Integer.toString((int)this.flyingMachine.getEnergy())
					, 0, 0, EPcolor);
		}
		GlStateManager.popMatrix();
	}
	

	/** Holds a instance of RenderItem, used to draw the achievement icons on screen (is based on ItemStack) */
    //protected RenderItem itemRender;
    
	/**
     * Draws an ItemStack.
     */
    private void drawItemStack(ItemStack stack, int xIn, int yIn)
    {
    	//Minecraft.getMinecraft().getRenderItem().renderItem(stack, TransformType.GROUND);
        
    	GlStateManager.pushMatrix();
		{
			GlStateManager.translate(xIn + 76.35, yIn + 1.5, 0);
			
			//GlStateManager.translate(x + 0, y + 0, 0);
			GlStateManager.scale(0.41, 0.41, 0.41);
			
			
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(stack, 0, 0);
		}
		GlStateManager.popMatrix();
		
		
    	//GlStateManager.translate(0.0F, 0.0F, 32.0F);
        //this.zLevel = 200.0F;
        ////this.itemRender.zLevel = 200.0F;
        //net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        //if (font == null) font = fontRenderer;
        //this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
       //t//his.zLevel = 0.0F;
        //this.itemRender.zLevel = 0.0F;
    }
}
