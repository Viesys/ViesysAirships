package com.vies.viesmachines.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuFrameTier4Pg1 extends GuiCustomizeMenuFrameTierVC {
	
	public GuiCustomizeMenuFrameTier4Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.frameSkinTexture == 43)
    	{
    		GuiVM.button43.enabled = false;
    	}
    	else
    	{
    		GuiVM.button43.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 44)
    	{
    		GuiVM.button44.enabled = false;
    	}
    	else
    	{
    		GuiVM.button44.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 45)
    	{
    		GuiVM.button45.enabled = false;
    	}
    	else
    	{
    		GuiVM.button45.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 46)
    	{
    		GuiVM.button46.enabled = false;
    	}
    	else
    	{
    		GuiVM.button46.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 47)
    	{
    		GuiVM.button47.enabled = false;
    	}
    	else
    	{
    		GuiVM.button47.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 48)
    	{
    		GuiVM.button48.enabled = false;
    	}
    	else
    	{
    		GuiVM.button48.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 49)
    	{
    		GuiVM.button49.enabled = false;
    	}
    	else
    	{
    		GuiVM.button49.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 50)
    	{
    		GuiVM.button50.enabled = false;
    	}
    	else
    	{
    		GuiVM.button50.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 51)
    	{
    		GuiVM.button51.enabled = false;
    	}
    	else
    	{
    		GuiVM.button51.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 52)
    	{
    		GuiVM.button52.enabled = false;
    	}
    	else
    	{
    		GuiVM.button52.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 53)
    	{
    		GuiVM.button53.enabled = false;
    	}
    	else
    	{
    		GuiVM.button53.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 54)
    	{
    		GuiVM.button54.enabled = false;
    	}
    	else
    	{
    		GuiVM.button54.enabled = true;
    	}
    }
}
