package com.vies.viesmachines.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier5Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier5Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		this.buttonList.add(GuiVM.button55);
		this.buttonList.add(GuiVM.button56);
		this.buttonList.add(GuiVM.button57);
		this.buttonList.add(GuiVM.button58);
		this.buttonList.add(GuiVM.button59);
		this.buttonList.add(GuiVM.button60);

		this.buttonList.add(GuiVM.button61);
		this.buttonList.add(GuiVM.button62);
		this.buttonList.add(GuiVM.button63);
		this.buttonList.add(GuiVM.button64);
		this.buttonList.add(GuiVM.button65);
		this.buttonList.add(GuiVM.button66);
		
		GuiVM.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVM.button58.visible = false;
		GuiVM.button59.visible = false;
		GuiVM.button60.visible = false;
		GuiVM.button61.visible = false;
		GuiVM.button62.visible = false;
		GuiVM.button63.visible = false;
		GuiVM.button64.visible = false;
		GuiVM.button65.visible = false;
		GuiVM.button66.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 55)
    	{
    		GuiVM.button55.enabled = false;
    	}
    	else
    	{
    		GuiVM.button55.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 56)
    	{
    		GuiVM.button56.enabled = false;
    	}
    	else
    	{
    		GuiVM.button56.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 57)
    	{
    		GuiVM.button57.enabled = false;
    	}
    	else
    	{
    		GuiVM.button57.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 58)
    	{
    		GuiVM.button58.enabled = false;
    	}
    	else
    	{
    		GuiVM.button58.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 59)
    	{
    		GuiVM.button59.enabled = false;
    	}
    	else
    	{
    		GuiVM.button59.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 60)
    	{
    		GuiVM.button60.enabled = false;
    	}
    	else
    	{
    		GuiVM.button60.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 61)
    	{
    		GuiVM.button61.enabled = false;
    	}
    	else
    	{
    		GuiVM.button61.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 62)
    	{
    		GuiVM.button62.enabled = false;
    	}
    	else
    	{
    		GuiVM.button62.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 63)
    	{
    		GuiVM.button63.enabled = false;
    	}
    	else
    	{
    		GuiVM.button63.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 64)
    	{
    		GuiVM.button64.enabled = false;
    	}
    	else
    	{
    		GuiVM.button64.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 65)
    	{
    		GuiVM.button65.enabled = false;
    	}
    	else
    	{
    		GuiVM.button65.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 66)
    	{
    		GuiVM.button66.enabled = false;
    	}
    	else
    	{
    		GuiVM.button66.enabled = true;
    	}
    }
}
