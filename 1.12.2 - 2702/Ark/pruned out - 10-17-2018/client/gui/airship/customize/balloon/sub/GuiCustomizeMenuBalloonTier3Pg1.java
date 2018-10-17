package com.vies.viesmachines.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier3Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier3Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(playerInv, airshipIn);
	}
	
	/**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		this.buttonList.add(GuiVM.buttonMM4);
		this.buttonList.add(GuiVM.buttonMM5);
    	
    	this.buttonList.add(GuiVM.button501);
		this.buttonList.add(GuiVM.button502);
		//this.buttonList.add(GuiVC.button503);
		//this.buttonList.add(GuiVC.button504);
		this.buttonList.add(GuiVM.button505);
		
		this.buttonList.add(GuiVM.button31);
		this.buttonList.add(GuiVM.button32);
		this.buttonList.add(GuiVM.button33);
		this.buttonList.add(GuiVM.button34);
		this.buttonList.add(GuiVM.button35);
		this.buttonList.add(GuiVM.button36);
		
		this.buttonList.add(GuiVM.button37);
		this.buttonList.add(GuiVM.button38);
		this.buttonList.add(GuiVM.button39);
		this.buttonList.add(GuiVM.button40);
		this.buttonList.add(GuiVM.button41);
		this.buttonList.add(GuiVM.button42);
		
		GuiVM.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVM.button32.visible = false;
		GuiVM.button33.visible = false;
		GuiVM.button34.visible = false;
		GuiVM.button35.visible = false;
		GuiVM.button36.visible = false;
		GuiVM.button37.visible = false;
		GuiVM.button38.visible = false;
		GuiVM.button39.visible = false;
		GuiVM.button40.visible = false;
		GuiVM.button41.visible = false;
		GuiVM.button42.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 31)
    	{
    		GuiVM.button31.enabled = false;
    	}
    	else
    	{
    		GuiVM.button31.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 32)
    	{
    		GuiVM.button32.enabled = false;
    	}
    	else
    	{
    		GuiVM.button32.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 33)
    	{
    		GuiVM.button33.enabled = false;
    	}
    	else
    	{
    		GuiVM.button33.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 34)
    	{
    		GuiVM.button34.enabled = false;
    	}
    	else
    	{
    		GuiVM.button34.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 35)
    	{
    		GuiVM.button35.enabled = false;
    	}
    	else
    	{
    		GuiVM.button35.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 36)
    	{
    		GuiVM.button36.enabled = false;
    	}
    	else
    	{
    		GuiVM.button36.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 37)
    	{
    		GuiVM.button37.enabled = false;
    	}
    	else
    	{
    		GuiVM.button37.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 38)
    	{
    		GuiVM.button38.enabled = false;
    	}
    	else
    	{
    		GuiVM.button38.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 39)
    	{
    		GuiVM.button39.enabled = false;
    	}
    	else
    	{
    		GuiVM.button39.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 40)
    	{
    		GuiVM.button40.enabled = false;
    	}
    	else
    	{
    		GuiVM.button40.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 41)
    	{
    		GuiVM.button41.enabled = false;
    	}
    	else
    	{
    		GuiVM.button41.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 42)
    	{
    		GuiVM.button42.enabled = false;
    	}
    	else
    	{
    		GuiVM.button42.enabled = true;
    	}
    }
}
