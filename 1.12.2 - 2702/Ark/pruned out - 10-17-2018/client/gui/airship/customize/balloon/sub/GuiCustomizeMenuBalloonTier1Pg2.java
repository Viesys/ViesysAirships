package com.vies.viesmachines.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier1Pg2 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier1Pg2(IInventory playerInv, EntityAirshipCore airshipIn)
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
		this.buttonList.add(GuiVM.button504);
		this.buttonList.add(GuiVM.button505);
		
		this.buttonList.add(GuiVM.button13);
		this.buttonList.add(GuiVM.button14);
		this.buttonList.add(GuiVM.button15);
		this.buttonList.add(GuiVM.button16);
		this.buttonList.add(GuiVM.button17);
		this.buttonList.add(GuiVM.button18);
		
		GuiVM.buttonMM3.enabled = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 13)
    	{
    		GuiVM.button13.enabled = false;
    	}
    	else
    	{
    		GuiVM.button13.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 14)
    	{
    		GuiVM.button14.enabled = false;
    	}
    	else
    	{
    		GuiVM.button14.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 15)
    	{
    		GuiVM.button15.enabled = false;
    	}
    	else
    	{
    		GuiVM.button15.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 16)
    	{
    		GuiVM.button16.enabled = false;
    	}
    	else
    	{
    		GuiVM.button16.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 17)
    	{
    		GuiVM.button17.enabled = false;
    	}
    	else
    	{
    		GuiVM.button17.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 18)
    	{
    		GuiVM.button18.enabled = false;
    	}
    	else
    	{
    		GuiVM.button18.enabled = true;
    	}
    }
}
