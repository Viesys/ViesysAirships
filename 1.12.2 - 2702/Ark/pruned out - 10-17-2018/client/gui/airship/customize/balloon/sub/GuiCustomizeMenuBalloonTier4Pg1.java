package com.vies.viesmachines.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier4Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier4Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		this.buttonList.add(GuiVM.button43);
		this.buttonList.add(GuiVM.button44);
		this.buttonList.add(GuiVM.button45);
		this.buttonList.add(GuiVM.button46);
		this.buttonList.add(GuiVM.button47);
		this.buttonList.add(GuiVM.button48);

		this.buttonList.add(GuiVM.button49);
		this.buttonList.add(GuiVM.button50);
		this.buttonList.add(GuiVM.button51);
		this.buttonList.add(GuiVM.button52);
		this.buttonList.add(GuiVM.button53);
		this.buttonList.add(GuiVM.button54);
		
		GuiVM.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVM.button44.visible = false;
		GuiVM.button45.visible = false;
		GuiVM.button46.visible = false;
		GuiVM.button47.visible = false;
		GuiVM.button48.visible = false;
		GuiVM.button49.visible = false;
		GuiVM.button50.visible = false;
		GuiVM.button51.visible = false;
		GuiVM.button52.visible = false;
		GuiVM.button53.visible = false;
		GuiVM.button54.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 43)
    	{
    		GuiVM.button43.enabled = false;
    	}
    	else
    	{
    		GuiVM.button43.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 44)
    	{
    		GuiVM.button44.enabled = false;
    	}
    	else
    	{
    		GuiVM.button44.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 45)
    	{
    		GuiVM.button45.enabled = false;
    	}
    	else
    	{
    		GuiVM.button45.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 46)
    	{
    		GuiVM.button46.enabled = false;
    	}
    	else
    	{
    		GuiVM.button46.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 47)
    	{
    		GuiVM.button47.enabled = false;
    	}
    	else
    	{
    		GuiVM.button47.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 48)
    	{
    		GuiVM.button48.enabled = false;
    	}
    	else
    	{
    		GuiVM.button48.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 49)
    	{
    		GuiVM.button49.enabled = false;
    	}
    	else
    	{
    		GuiVM.button49.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 50)
    	{
    		GuiVM.button50.enabled = false;
    	}
    	else
    	{
    		GuiVM.button50.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 51)
    	{
    		GuiVM.button51.enabled = false;
    	}
    	else
    	{
    		GuiVM.button51.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 52)
    	{
    		GuiVM.button52.enabled = false;
    	}
    	else
    	{
    		GuiVM.button52.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 53)
    	{
    		GuiVM.button53.enabled = false;
    	}
    	else
    	{
    		GuiVM.button53.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 54)
    	{
    		GuiVM.button54.enabled = false;
    	}
    	else
    	{
    		GuiVM.button54.enabled = true;
    	}
    }
}
