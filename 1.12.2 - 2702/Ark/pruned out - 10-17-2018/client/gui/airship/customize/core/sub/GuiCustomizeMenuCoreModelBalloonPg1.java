package com.vies.viesmachines.client.gui.airship.customize.core.sub;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.airship.customize.core.MessageGuiCustomizeMenuCoreMain;
import com.vies.viesmachines.network.server.airship.customize.core.sub.MessageHelperGuiCustomizeMenuCoreModelBalloon;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuCoreModelBalloonPg1 extends GuiCustomizeMenuCoreModelVC {
	
	public GuiCustomizeMenuCoreModelBalloonPg1(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(playerInv, airshipIn);
		
		this.metaInfo = this.airship.coreModelVisualBalloon;
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
		
		this.buttonList.add(GuiVM.buttonC00);
		this.buttonList.add(GuiVM.buttonC01);
		this.buttonList.add(GuiVM.buttonC02);
		this.buttonList.add(GuiVM.buttonC03);
		this.buttonList.add(GuiVM.buttonC04);
		
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
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelBalloon());
	    }
		if (parButton.id == 502)
	    {
			this.metaInfo = 0;
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelBalloon());
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
    	
		if(airship.getStoredRedstone() >= CostsVM.CORE_MODEL_BALLOON_COST
		&& this.metaInfo != this.airship.coreModelVisualBalloon)
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
    	if(this.airship.coreModelVisualBalloon == 0)
    	{
    		GuiVM.buttonC00.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonC00.enabled = true;
    	}
    	if(this.airship.coreModelVisualBalloon == 1)
    	{
    		GuiVM.buttonC01.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonC01.enabled = true;
    	}
    	if(this.airship.coreModelVisualBalloon == 2)
    	{
    		GuiVM.buttonC02.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonC02.enabled = true;
    	}
    	if(this.airship.coreModelVisualBalloon == 3)
    	{
    		GuiVM.buttonC03.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonC03.enabled = true;
    	}
    	if(this.airship.coreModelVisualBalloon == 4)
    	{
    		GuiVM.buttonC04.enabled = false;
    	}
    	else
    	{
    		GuiVM.buttonC04.enabled = true;
    	}
    }
    
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    @Override
    protected void drawEntityOnScreen(int posX, int posY, int scale, EntityAirshipCore entityIn)
    {
    	int current = entityIn.coreModelVisualBalloon;
        entityIn.coreModelVisualBalloon = metaInfo;
        
        super.drawEntityOnScreen(posX, posY, scale, entityIn);
    	
		entityIn.coreModelVisualBalloon = current;
    }
}
