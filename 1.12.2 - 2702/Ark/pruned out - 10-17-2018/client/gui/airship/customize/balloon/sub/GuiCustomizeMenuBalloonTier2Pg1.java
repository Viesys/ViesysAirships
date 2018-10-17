package com.vies.viesmachines.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier2Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier2Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		this.buttonList.add(GuiVM.button19);
		this.buttonList.add(GuiVM.button20);
		this.buttonList.add(GuiVM.button21);
		this.buttonList.add(GuiVM.button22);
		this.buttonList.add(GuiVM.button23);
		this.buttonList.add(GuiVM.button24);
		
		this.buttonList.add(GuiVM.button25);
		this.buttonList.add(GuiVM.button26);
		this.buttonList.add(GuiVM.button27);
		this.buttonList.add(GuiVM.button28);
		this.buttonList.add(GuiVM.button29);
		this.buttonList.add(GuiVM.button30);
		
		GuiVM.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVM.button21.visible = false;
		GuiVM.button22.visible = false;
		GuiVM.button23.visible = false;
		GuiVM.button24.visible = false;
		GuiVM.button25.visible = false;
		GuiVM.button26.visible = false;
		GuiVM.button27.visible = false;
		GuiVM.button28.visible = false;
		GuiVM.button29.visible = false;
		GuiVM.button30.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 19)
    	{
    		GuiVM.button19.enabled = false;
    	}
    	else
    	{
    		GuiVM.button19.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 20)
    	{
    		GuiVM.button20.enabled = false;
    	}
    	else
    	{
    		GuiVM.button20.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 21)
    	{
    		GuiVM.button21.enabled = false;
    	}
    	else
    	{
    		GuiVM.button21.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 22)
    	{
    		GuiVM.button22.enabled = false;
    	}
    	else
    	{
    		GuiVM.button22.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 23)
    	{
    		GuiVM.button23.enabled = false;
    	}
    	else
    	{
    		GuiVM.button23.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 24)
    	{
    		GuiVM.button24.enabled = false;
    	}
    	else
    	{
    		GuiVM.button24.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 25)
    	{
    		GuiVM.button25.enabled = false;
    	}
    	else
    	{
    		GuiVM.button25.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 26)
    	{
    		GuiVM.button26.enabled = false;
    	}
    	else
    	{
    		GuiVM.button26.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 27)
    	{
    		GuiVM.button27.enabled = false;
    	}
    	else
    	{
    		GuiVM.button27.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 28)
    	{
    		GuiVM.button28.enabled = false;
    	}
    	else
    	{
    		GuiVM.button28.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 29)
    	{
    		GuiVM.button29.enabled = false;
    	}
    	else
    	{
    		GuiVM.button29.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 30)
    	{
    		GuiVM.button30.enabled = false;
    	}
    	else
    	{
    		GuiVM.button30.enabled = true;
    	}
    }
}
