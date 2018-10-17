package com.vies.viesmachines.client.gui.airship.customize.engine.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuEngineDisplaySupporterHeadPg1 extends GuiCustomizeMenuEngineDisplaySupporterHeadVC {
	
	public GuiCustomizeMenuEngineDisplaySupporterHeadPg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	this.buttonList.add(GuiVM.button502);
		//this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVM.button505);
		this.buttonList.add(GuiVM.button501);
		
		this.buttonList.add(GuiVM.button01);
		this.buttonList.add(GuiVM.button02);
		this.buttonList.add(GuiVM.button03);
		this.buttonList.add(GuiVM.button04);
/**		this.buttonList.add(GuiVC.button05);
		this.buttonList.add(GuiVC.button06);
		this.buttonList.add(GuiVC.button07);
		this.buttonList.add(GuiVC.button08);
		this.buttonList.add(GuiVC.button09);
		this.buttonList.add(GuiVC.button10);
		this.buttonList.add(GuiVC.button11);
		this.buttonList.add(GuiVC.button12);*/
		
		GuiVM.buttonMM3.enabled = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
    	
		if(airship.getStoredRedstone() >= CostsVM.ENGINE_DISPLAY_SYMBOL_COST
		&& this.supporterHeadInfo != this.airship.engineDisplaySupporterHeadVisual)
		{
			GuiVM.button501.enabled = true;
		}
		else
		{
			GuiVM.button501.enabled = false;
		}
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.supporterHeadInfo == 1)
    	{
    		GuiVM.button01.enabled = false;
    	}
    	else
    	{
    		GuiVM.button01.enabled = true;
    	}
    	if(this.supporterHeadInfo == 2)
    	{
    		GuiVM.button02.enabled = false;
    	}
    	else
    	{
    		GuiVM.button02.enabled = true;
    	}
    	if(this.supporterHeadInfo == 3)
    	{
    		GuiVM.button03.enabled = false;
    	}
    	else
    	{
    		GuiVM.button03.enabled = true;
    	}
    	if(this.supporterHeadInfo == 4)
    	{
    		GuiVM.button04.enabled = false;
    	}
    	else
    	{
    		GuiVM.button04.enabled = true;
    	}
    	if(this.supporterHeadInfo == 5)
    	{
    		GuiVM.button05.enabled = false;
    	}
    	else
    	{
    		GuiVM.button05.enabled = true;
    	}
    	if(this.supporterHeadInfo == 6)
    	{
    		GuiVM.button06.enabled = false;
    	}
    	else
    	{
    		GuiVM.button06.enabled = true;
    	}
    	if(this.supporterHeadInfo == 7)
    	{
    		GuiVM.button07.enabled = false;
    	}
    	else
    	{
    		GuiVM.button07.enabled = true;
    	}
    	if(this.supporterHeadInfo == 8)
    	{
    		GuiVM.button08.enabled = false;
    	}
    	else
    	{
    		GuiVM.button08.enabled = true;
    	}
    	if(this.supporterHeadInfo == 9)
    	{
    		GuiVM.button09.enabled = false;
    	}
    	else
    	{
    		GuiVM.button09.enabled = true;
    	}
    	if(this.supporterHeadInfo == 10)
    	{
    		GuiVM.button10.enabled = false;
    	}
    	else
    	{
    		GuiVM.button10.enabled = true;
    	}
    	if(this.supporterHeadInfo == 11)
    	{
    		GuiVM.button11.enabled = false;
    	}
    	else
    	{
    		GuiVM.button11.enabled = true;
    	}
    	if(this.supporterHeadInfo == 12)
    	{
    		GuiVM.button12.enabled = false;
    	}
    	else
    	{
    		GuiVM.button12.enabled = true;
    	}
    }
}
