package com.vies.viesmachines.client.gui.airship.customize.engine.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuEngineDisplaySymbolPg1 extends GuiCustomizeMenuEngineDisplaySymbolVC {
	
	public GuiCustomizeMenuEngineDisplaySymbolPg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		this.buttonList.add(GuiVM.button10);
		this.buttonList.add(GuiVM.button11);
		this.buttonList.add(GuiVM.button12);
		this.buttonList.add(GuiVM.button13);
		this.buttonList.add(GuiVM.button14);
		this.buttonList.add(GuiVM.button15);
		
		this.buttonList.add(GuiVM.button16);
		this.buttonList.add(GuiVM.button17);
		this.buttonList.add(GuiVM.button18);
		this.buttonList.add(GuiVM.button19);
		this.buttonList.add(GuiVM.button20);
		this.buttonList.add(GuiVM.button21);
		
		GuiVM.buttonMM3.enabled = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
    	
		if(airship.getStoredRedstone() >= CostsVM.ENGINE_DISPLAY_SYMBOL_COST
		&& this.metaInfo != this.airship.engineDisplayTypeVisual)
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
    	if(this.metaInfo == 10)
    	{
    		GuiVM.button10.enabled = false;
    	}
    	else
    	{
    		GuiVM.button10.enabled = true;
    	}
    	if(this.metaInfo == 11)
    	{
    		GuiVM.button11.enabled = false;
    	}
    	else
    	{
    		GuiVM.button11.enabled = true;
    	}
    	if(this.metaInfo == 12)
    	{
    		GuiVM.button12.enabled = false;
    	}
    	else
    	{
    		GuiVM.button12.enabled = true;
    	}
    	if(this.metaInfo == 13)
    	{
    		GuiVM.button13.enabled = false;
    	}
    	else
    	{
    		GuiVM.button13.enabled = true;
    	}
    	if(this.metaInfo == 14)
    	{
    		GuiVM.button14.enabled = false;
    	}
    	else
    	{
    		GuiVM.button14.enabled = true;
    	}
    	if(this.metaInfo == 15)
    	{
    		GuiVM.button15.enabled = false;
    	}
    	else
    	{
    		GuiVM.button15.enabled = true;
    	}
    	if(this.metaInfo == 16)
    	{
    		GuiVM.button16.enabled = false;
    	}
    	else
    	{
    		GuiVM.button16.enabled = true;
    	}
    	if(this.metaInfo == 17)
    	{
    		GuiVM.button17.enabled = false;
    	}
    	else
    	{
    		GuiVM.button17.enabled = true;
    	}
    	if(this.metaInfo == 18)
    	{
    		GuiVM.button18.enabled = false;
    	}
    	else
    	{
    		GuiVM.button18.enabled = true;
    	}
    	if(this.metaInfo == 19)
    	{
    		GuiVM.button19.enabled = false;
    	}
    	else
    	{
    		GuiVM.button19.enabled = true;
    	}
    	if(this.metaInfo == 20)
    	{
    		GuiVM.button20.enabled = false;
    	}
    	else
    	{
    		GuiVM.button20.enabled = true;
    	}
    	if(this.metaInfo == 21)
    	{
    		GuiVM.button21.enabled = false;
    	}
    	else
    	{
    		GuiVM.button21.enabled = true;
    	}
    }
}
