package com.vies.viesmachines.client.gui.airship.customize.core.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.airship.customize.core.MessageGuiCustomizeMenuCoreMain;
import com.vies.viesmachines.network.server.airship.customize.core.sub.MessageHelperGuiCustomizeMenuCoreModelEngine;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuCoreModelEnginePg1 extends GuiCustomizeMenuCoreModelVC {
	
	public GuiCustomizeMenuCoreModelEnginePg1(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(playerInv, airshipIn);
		
		this.metaInfo = this.airship.coreModelVisualEngine;
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
		
		this.buttonList.add(GuiVM.buttonB00);
		this.buttonList.add(GuiVM.buttonB01);
		this.buttonList.add(GuiVM.buttonB02);
		//this.buttonList.add(GuiVC.buttonB03);
		//this.buttonList.add(GuiVC.buttonB04);
		
		GuiVM.buttonMM3.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelEngine());
	    }
		if (parButton.id == 502)
	    {
			this.metaInfo = 0;
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelEngine());
	    }
		if (parButton.id == 503)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier1Pg2());
	    }
		if (parButton.id == 504)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier1Pg1());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuCoreMain());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
    	
		if(airship.getStoredRedstone() >= CostsVM.CORE_MODEL_ENGINE_COST
		&& this.metaInfo != this.airship.coreModelVisualEngine)
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
    	if(this.airship.coreModelVisualEngine == 0)
    	{
    		GuiVM.buttonB00.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonB00.enabled = true;
    	}
    	if(this.airship.coreModelVisualEngine == 1)
    	{
    		GuiVM.buttonB01.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonB01.enabled = true;
    	}
    	if(this.airship.coreModelVisualEngine == 2)
    	{
    		GuiVM.buttonB02.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonB02.enabled = true;
    	}
    	if(this.airship.coreModelVisualEngine == 3)
    	{
    		GuiVM.buttonB03.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonB03.enabled = true;
    	}
    	if(this.airship.coreModelVisualEngine == 4)
    	{
    		GuiVM.buttonB04.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonB04.enabled = true;
    	}
    }
    
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    @Override
    protected void drawEntityOnScreen(int posX, int posY, int scale, EntityAirshipCore entityIn)
    {
    	int current = entityIn.coreModelVisualEngine;
        entityIn.coreModelVisualEngine = metaInfo;
        
        super.drawEntityOnScreen(posX, posY, scale, entityIn);
    	
		entityIn.coreModelVisualEngine = current;
    }
}
