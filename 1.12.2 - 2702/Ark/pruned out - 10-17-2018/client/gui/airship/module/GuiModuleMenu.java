package com.vies.viesmachines.client.gui.airship.module;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VC;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;
import com.vies.viesmachines.common.entity.airships.containers.all.ContainerMainModule;
import com.vies.viesmachines.init.InitItemsVC;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.airship.module.MessageHelperGuiModuleLearn;
import com.vies.viesmachines.network.server.airship.module.MessageHelperGuiModuleToggleSlot1;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiModuleMenu extends GuiContainerVC {
	
	public static int learnModule;
	public static int toggleModule;
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_module.png");
	
	public GuiModuleMenu(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerMainModule(playerInv, airshipIn), playerInv, airshipIn);
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
    	
    	GuiVM.buttonModuleReset = new GuiButtonGeneral2VC(501, this.guiLeft + 11 + (20 * 0), this.guiTop + 11 + (19 * 0), 14, 14, "", 1);
		
    	GuiVM.buttonModuleLesserAltitude = new GuiButtonGeneral2VC(EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalAltitude = new GuiButtonGeneral2VC(EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterAltitude = new GuiButtonGeneral2VC(EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLesserSpeed = new GuiButtonGeneral2VC(EnumsVM.ModuleType.SPEED_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 2), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalSpeed = new GuiButtonGeneral2VC(EnumsVM.ModuleType.SPEED_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 2), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterSpeed = new GuiButtonGeneral2VC(EnumsVM.ModuleType.SPEED_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 2), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLesserStorage = new GuiButtonGeneral2VC(EnumsVM.ModuleType.STORAGE_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 3), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalStorage = new GuiButtonGeneral2VC(EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 3), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterStorage = new GuiButtonGeneral2VC(EnumsVM.ModuleType.STORAGE_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 3), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLesserFuel = new GuiButtonGeneral2VC(EnumsVM.ModuleType.FUEL_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 4), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalFuel = new GuiButtonGeneral2VC(EnumsVM.ModuleType.FUEL_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 4), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterFuel = new GuiButtonGeneral2VC(EnumsVM.ModuleType.FUEL_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 4), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLesserMusic = new GuiButtonGeneral2VC(EnumsVM.ModuleType.MUSIC_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 5), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalMusic = new GuiButtonGeneral2VC(EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 5), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterMusic = new GuiButtonGeneral2VC(EnumsVM.ModuleType.MUSIC_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 5), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLesserCruise = new GuiButtonGeneral2VC(EnumsVM.ModuleType.CRUISE_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 6), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalCruise = new GuiButtonGeneral2VC(EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 6), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterCruise = new GuiButtonGeneral2VC(EnumsVM.ModuleType.CRUISE_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 6), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLesserWater = new GuiButtonGeneral2VC(EnumsVM.ModuleType.WATER_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 7), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalWater = new GuiButtonGeneral2VC(EnumsVM.ModuleType.WATER_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 7), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterWater = new GuiButtonGeneral2VC(EnumsVM.ModuleType.WATER_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 7), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLesserInfiniteFuel = new GuiButtonGeneral2VC(EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 0), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalInfiniteFuel = new GuiButtonGeneral2VC(EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 0), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterInfiniteFuel = new GuiButtonGeneral2VC(EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 0), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLesserBomb = new GuiButtonGeneral2VC(EnumsVM.ModuleType.BOMB_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	GuiVM.buttonModuleNormalBomb = new GuiButtonGeneral2VC(EnumsVM.ModuleType.BOMB_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	GuiVM.buttonModuleGreaterBomb = new GuiButtonGeneral2VC(EnumsVM.ModuleType.BOMB_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	
    	GuiVM.buttonModuleLearn = new GuiButtonGeneral1VC(550, this.guiLeft + 128, this.guiTop + 94, 36, 14, References.localNameVC("vc.button.learn"), 1);
		
    	
    	
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		this.buttonList.add(GuiVM.buttonMM4);
		this.buttonList.add(GuiVM.buttonMM5);
		
		this.buttonList.add(GuiVM.buttonModuleLesserAltitude);
		this.buttonList.add(GuiVM.buttonModuleNormalAltitude);
		this.buttonList.add(GuiVM.buttonModuleGreaterAltitude);
		
		this.buttonList.add(GuiVM.buttonModuleLesserSpeed);
		this.buttonList.add(GuiVM.buttonModuleNormalSpeed);
		this.buttonList.add(GuiVM.buttonModuleGreaterSpeed);
		
		this.buttonList.add(GuiVM.buttonModuleLesserStorage);
		this.buttonList.add(GuiVM.buttonModuleNormalStorage);
		this.buttonList.add(GuiVM.buttonModuleGreaterStorage);
		
		this.buttonList.add(GuiVM.buttonModuleLesserFuel);
		this.buttonList.add(GuiVM.buttonModuleNormalFuel);
		this.buttonList.add(GuiVM.buttonModuleGreaterFuel);
		
		this.buttonList.add(GuiVM.buttonModuleLesserMusic);
		this.buttonList.add(GuiVM.buttonModuleNormalMusic);
		this.buttonList.add(GuiVM.buttonModuleGreaterMusic);
		
		this.buttonList.add(GuiVM.buttonModuleLesserCruise);
		this.buttonList.add(GuiVM.buttonModuleNormalCruise);
		this.buttonList.add(GuiVM.buttonModuleGreaterCruise);
		
		this.buttonList.add(GuiVM.buttonModuleLesserWater);
		this.buttonList.add(GuiVM.buttonModuleNormalWater);
		this.buttonList.add(GuiVM.buttonModuleGreaterWater);
		
		this.buttonList.add(GuiVM.buttonModuleLesserInfiniteFuel);
		this.buttonList.add(GuiVM.buttonModuleNormalInfiniteFuel);
		this.buttonList.add(GuiVM.buttonModuleGreaterInfiniteFuel);
		
		this.buttonList.add(GuiVM.buttonModuleLesserBomb);
		this.buttonList.add(GuiVM.buttonModuleNormalBomb);
		this.buttonList.add(GuiVM.buttonModuleGreaterBomb);
		
		this.buttonList.add(GuiVM.buttonModuleLearn);
		this.buttonList.add(GuiVM.buttonModuleReset);
		
		
		
		GuiVM.buttonModuleLesserAltitude.visible = false;
		GuiVM.buttonModuleNormalAltitude.visible = false;
		GuiVM.buttonModuleGreaterAltitude.visible = false;
		
		GuiVM.buttonModuleLesserSpeed.visible = false;
		GuiVM.buttonModuleNormalSpeed.visible = false;
		GuiVM.buttonModuleGreaterSpeed.visible = false;
		
		GuiVM.buttonModuleLesserStorage.visible = false;
		GuiVM.buttonModuleNormalStorage.visible = false;
		GuiVM.buttonModuleGreaterStorage.visible = false;
		
		GuiVM.buttonModuleLesserFuel.visible = false;
		GuiVM.buttonModuleNormalFuel.visible = false;
		GuiVM.buttonModuleGreaterFuel.visible = false;
		
		GuiVM.buttonModuleLesserMusic.visible = false;
		GuiVM.buttonModuleNormalMusic.visible = false;
		GuiVM.buttonModuleGreaterMusic.visible = false;
		
		GuiVM.buttonModuleLesserCruise.visible = false;
		GuiVM.buttonModuleNormalCruise.visible = false;
		GuiVM.buttonModuleGreaterCruise.visible = false;
		
		GuiVM.buttonModuleLesserWater.visible = false;
		GuiVM.buttonModuleNormalWater.visible = false;
		GuiVM.buttonModuleGreaterWater.visible = false;
		
		GuiVM.buttonModuleLesserInfiniteFuel.visible = false;
		GuiVM.buttonModuleNormalInfiniteFuel.visible = false;
		GuiVM.buttonModuleGreaterInfiniteFuel.visible = false;
		
		GuiVM.buttonModuleLesserBomb.visible = false;
		GuiVM.buttonModuleNormalBomb.visible = false;
		GuiVM.buttonModuleGreaterBomb.visible = false;
		
		
		
		GuiVM.buttonMM4.enabled = false;
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
			this.toggleModule = 0;
			
			NetworkHandler.sendToServer(new MessageHelperGuiModuleToggleSlot1());
	    }
		
		if (parButton.id <= 400)
	    {
			this.toggleModule = parButton.id;
			
			NetworkHandler.sendToServer(new MessageHelperGuiModuleToggleSlot1());
	    }
		
		
		
		if (parButton.id == 550)
	    {
			if(!this.airship.inventory.getStackInSlot(11).isEmpty())
			{
				if(this.airship.inventory.getStackInSlot(11).getItem() == InitItemsVC.MODULE_CREATIVE)
				{
					this.learnModule = 550;
				}
				else
				{
					this.learnModule = this.airship.inventory.getStackInSlot(11).getMetadata();
				}
				
				NetworkHandler.sendToServer(new MessageHelperGuiModuleLearn());
				this.airship.moduleActiveSlot1 = 0;
				this.airship.inventory.extractItem(11, 1, false);
			}
	    }
		
		
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//On indicator if any Module is in learn slot
		if(!this.airship.inventory.getStackInSlot(11).isEmpty())
		{
			//Draws the box overlay around module slot
			this.drawTexturedModalRect(this.guiLeft + 108, this.guiTop + 92, 176, 18, 18, 18);
		}
		
		
		
		String nameIn = "";
		String pros1 = "";
		String pros2 = "";
		String cons1 = "";
		String cons2 = "";
		
		//Logic for mouse-over Altitude tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 1) && mouseX <= this.guiLeft + 24 + (20 * 1)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleAltitude == 1)
			{
				nameIn = EnumsVM.ModuleType.ALTITUDE_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleAltitude == 2)
			{
				nameIn = EnumsVM.ModuleType.ALTITUDE_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleAltitude == 3)
			{
				nameIn = EnumsVM.ModuleType.ALTITUDE_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Speed tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 2) && mouseX <= this.guiLeft + 24 + (20 * 2)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleSpeed == 1)
			{
				nameIn = EnumsVM.ModuleType.SPEED_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleSpeed == 2)
			{
				nameIn = EnumsVM.ModuleType.SPEED_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleSpeed == 3)
			{
				nameIn = EnumsVM.ModuleType.SPEED_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.SPEED_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Storage tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 3) && mouseX <= this.guiLeft + 24 + (20 * 3)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleStorage == 1)
			{
				nameIn = EnumsVM.ModuleType.STORAGE_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleStorage == 2)
			{
				nameIn = EnumsVM.ModuleType.STORAGE_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleStorage == 3)
			{
				nameIn = EnumsVM.ModuleType.STORAGE_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.STORAGE_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Fuel tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 4) && mouseX <= this.guiLeft + 24 + (20 * 4)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleFuel == 1)
			{
				nameIn = EnumsVM.ModuleType.FUEL_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleFuel == 2)
			{
				nameIn = EnumsVM.ModuleType.FUEL_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleFuel == 3)
			{
				nameIn = EnumsVM.ModuleType.FUEL_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.FUEL_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Music tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 5) && mouseX <= this.guiLeft + 24 + (20 * 5)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleMusic == 1)
			{
				nameIn = EnumsVM.ModuleType.MUSIC_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleMusic == 2)
			{
				nameIn = EnumsVM.ModuleType.MUSIC_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleMusic == 3)
			{
				nameIn = EnumsVM.ModuleType.MUSIC_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.MUSIC_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Cruise tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 6) && mouseX <= this.guiLeft + 24 + (20 * 6)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleCruise == 1)
			{
				nameIn = EnumsVM.ModuleType.CRUISE_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleCruise == 2)
			{
				nameIn = EnumsVM.ModuleType.CRUISE_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleCruise == 3)
			{
				nameIn = EnumsVM.ModuleType.CRUISE_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.CRUISE_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Water tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 7) && mouseX <= this.guiLeft + 24 + (20 * 7)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleWater == 1)
			{
				nameIn = EnumsVM.ModuleType.WATER_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleWater == 2)
			{
				nameIn = EnumsVM.ModuleType.WATER_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleWater == 3)
			{
				nameIn = EnumsVM.ModuleType.WATER_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.WATER_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Fuel Infinite tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 0) && mouseX <= this.guiLeft + 24 + (20 * 0)
		&& mouseY >= this.guiTop + 11 + (20 * 1) && mouseY <= this.guiTop + 24 + (20 * 1))
		{
			if(this.airship.selectedModuleFuelInfinite == 1)
			{
				nameIn = EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleFuelInfinite == 2)
			{
				nameIn = EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleFuelInfinite == 3)
			{
				nameIn = EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Bomb tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 1) && mouseX <= this.guiLeft + 24 + (20 * 1)
		&& mouseY >= this.guiTop + 11 + (20 * 1) && mouseY <= this.guiTop + 24 + (20 * 1))
		{
			if(this.airship.selectedModuleBomb == 1)
			{
				nameIn = EnumsVM.ModuleType.BOMB_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleBomb == 2)
			{
				nameIn = EnumsVM.ModuleType.BOMB_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleBomb == 3)
			{
				nameIn = EnumsVM.ModuleType.BOMB_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVM.ModuleType.BOMB_GREATER.getMetadata() + ".cons2");
			}
		}
		
		
		
		//Module name
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 77, 0);
			GlStateManager.scale(0.45, 0.45, 0.45);
			
			this.drawCenteredString(fontRenderer, TextFormatting.LIGHT_PURPLE + "" + TextFormatting.UNDERLINE + "" + TextFormatting.BOLD + nameIn, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		//Pros1
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 88, 0);
			GlStateManager.scale(0.4, 0.4, 0.4);
			
			this.drawCenteredString(fontRenderer, TextFormatting.GREEN + pros1, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		//Pros2
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 93, 0);
			GlStateManager.scale(0.4, 0.4, 0.4);
			
			this.drawCenteredString(fontRenderer, TextFormatting.GREEN + pros2, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		//Cons1
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 103, 0);
			GlStateManager.scale(0.4, 0.4, 0.4);
			
			this.drawCenteredString(fontRenderer, TextFormatting.RED + cons1, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		//Cons2
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 108, 0);
			GlStateManager.scale(0.4, 0.4, 0.4);
			
			this.drawCenteredString(fontRenderer, TextFormatting.RED + cons2, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		
		//Draws the top menu extension for the main label
		this.drawRect(this.guiLeft + 49-1, this.guiTop - 17, this.guiLeft + 127+1, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-1, this.guiTop - 16, this.guiLeft + 126+1, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-1, this.guiTop - 14, this.guiLeft + 124+1, this.guiTop, Color.BLACK.getRGB());
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88+50.25, this.guiTop + 72-16.25, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.cost"), 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88+50.25, this.guiTop + 77-16.25, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(CostsVM.MODULE_CHANGE_COST), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		if(this.airship.getStoredRedstone() < CostsVM.MODULE_CHANGE_COST)
		{
			GuiVM.buttonModuleLesserAltitude.visible = false;
			GuiVM.buttonModuleNormalAltitude.visible = false;
			GuiVM.buttonModuleGreaterAltitude.visible = false;
			
			GuiVM.buttonModuleLesserSpeed.visible = false;
			GuiVM.buttonModuleNormalSpeed.visible = false;
			GuiVM.buttonModuleGreaterSpeed.visible = false;
			
			GuiVM.buttonModuleLesserStorage.visible = false;
			GuiVM.buttonModuleNormalStorage.visible = false;
			GuiVM.buttonModuleGreaterStorage.visible = false;
			
			GuiVM.buttonModuleLesserFuel.visible = false;
			GuiVM.buttonModuleNormalFuel.visible = false;
			GuiVM.buttonModuleGreaterFuel.visible = false;
			
			GuiVM.buttonModuleLesserMusic.visible = false;
			GuiVM.buttonModuleNormalMusic.visible = false;
			GuiVM.buttonModuleGreaterMusic.visible = false;
			
			GuiVM.buttonModuleLesserCruise.visible = false;
			GuiVM.buttonModuleNormalCruise.visible = false;
			GuiVM.buttonModuleGreaterCruise.visible = false;
			
			GuiVM.buttonModuleLesserWater.visible = false;
			GuiVM.buttonModuleNormalWater.visible = false;
			GuiVM.buttonModuleGreaterWater.visible = false;
			
			GuiVM.buttonModuleLesserInfiniteFuel.visible = false;
			GuiVM.buttonModuleNormalInfiniteFuel.visible = false;
			GuiVM.buttonModuleGreaterInfiniteFuel.visible = false;
			
			GuiVM.buttonModuleLesserBomb.visible = false;
			GuiVM.buttonModuleNormalBomb.visible = false;
			GuiVM.buttonModuleGreaterBomb.visible = false;
		}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		//Undo buttons Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(27, 27, 176, 0, 18, 18);
		}
		GlStateManager.popMatrix();
		
		if(this.airship.getStoredRedstone() < CostsVM.MODULE_CHANGE_COST)
		{
			if(this.airship.learnedModuleAltitude)
			{
				this.drawTexturedModalRect(11 + (20 * 1), 11 + (20 * 0), 176, 36, 18, 18);
			}
			if(this.airship.learnedModuleSpeed)
			{
				this.drawTexturedModalRect(11 + (20 * 2), 11 + (20 * 0), 176, 36, 18, 18);
			}
			if(this.airship.learnedModuleStorage)
			{
				this.drawTexturedModalRect(11 + (20 * 3), 11 + (20 * 0), 176, 36, 18, 18);
			}
			if(this.airship.learnedModuleFuel)
			{
				this.drawTexturedModalRect(11 + (20 * 4), 11 + (20 * 0), 176, 36, 18, 18);
			}
			if(this.airship.learnedModuleMusic)
			{
				this.drawTexturedModalRect(11 + (20 * 5), 11 + (20 * 0), 176, 36, 18, 18);
			}
			if(this.airship.learnedModuleCruise)
			{
				this.drawTexturedModalRect(11 + (20 * 6), 11 + (20 * 0), 176, 36, 18, 18);
			}
			if(this.airship.learnedModuleWater)
			{
				this.drawTexturedModalRect(11 + (20 * 7), 11 + (20 * 0), 176, 36, 18, 18);
			}
			if(this.airship.learnedModuleFuelInfinite)
			{
				this.drawTexturedModalRect(11 + (20 * 0), 11 + (20 * 1), 176, 36, 18, 18);
			}
			if(this.airship.learnedModuleBomb)
			{
				this.drawTexturedModalRect(11 + (20 * 1), 11 + (20 * 1), 176, 36, 18, 18);
			}
		}
		
		this.fontRenderer.drawString(References.localNameVC("vc.main.modulemenu"), 58, -10, Color.CYAN.getRGB());
		
		//Altitude Icons
		if(this.airship.getModuleLearnedAltitude())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 1), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedAltitude() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedAltitude() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedAltitude() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Speed Icons
		if(this.airship.getModuleLearnedSpeed())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 2), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedSpeed() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.SPEED_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedSpeed() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.SPEED_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedSpeed() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.SPEED_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Storage Icons
		if(this.airship.getModuleLearnedStorage())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 3), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedStorage() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.STORAGE_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedStorage() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedStorage() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.STORAGE_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Fuel Icons
		if(this.airship.getModuleLearnedFuel())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 4), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedFuel() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.FUEL_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedFuel() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.FUEL_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedFuel() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.FUEL_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Music Icons
		if(this.airship.getModuleLearnedMusic())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 5), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedMusic() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.MUSIC_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedMusic() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedMusic() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.MUSIC_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Cruise Icons
		if(this.airship.getModuleLearnedCruise())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 6), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedCruise() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.CRUISE_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedCruise() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedCruise() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.CRUISE_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Water Icons
		if(this.airship.getModuleLearnedWater())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 7), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedWater() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.WATER_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedWater() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.WATER_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedWater() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.WATER_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Infinite Fuel Icons
		if(this.airship.getModuleLearnedFuelInfinite())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 0), 11.03 + (20 * 1), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedFuelInfinite() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedFuelInfinite() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedFuelInfinite() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Bomb Icons
		if(this.airship.getModuleLearnedBomb())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 1), 11.03 + (20 * 1), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedBomb() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.BOMB_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedBomb() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.BOMB_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedBomb() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVM.ModuleType.BOMB_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Default tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 0) && mouseX <= this.guiLeft + 24 + (20 * 0)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.main.default"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 23, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
	}
	
	@Override
	public void updateScreen()
    {
		super.updateScreen();
        
        //Module Restrictions
		if(!this.airship.inventory.getStackInSlot(11).isEmpty())
		{
			//Altitude
			if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata()
			&& this.airship.getModuleSelectedAltitude() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedAltitude() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata()
			&& this.airship.getModuleSelectedAltitude() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//Speed
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.SPEED_LESSER.getMetadata()
			&& this.airship.getModuleSelectedSpeed() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.SPEED_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedSpeed() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.SPEED_GREATER.getMetadata()
			&& this.airship.getModuleSelectedSpeed() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//Storage
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.STORAGE_LESSER.getMetadata()
			&& this.airship.getModuleSelectedStorage() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedStorage() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.STORAGE_GREATER.getMetadata()
			&& this.airship.getModuleSelectedStorage() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//Fuel
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.FUEL_LESSER.getMetadata()
			&& this.airship.getModuleSelectedFuel() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.FUEL_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedFuel() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.FUEL_GREATER.getMetadata()
			&& this.airship.getModuleSelectedFuel() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//Music
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.MUSIC_LESSER.getMetadata()
			&& this.airship.getModuleSelectedMusic() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedMusic() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.MUSIC_GREATER.getMetadata()
			&& this.airship.getModuleSelectedMusic() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//Cruise
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.CRUISE_LESSER.getMetadata()
			&& this.airship.getModuleSelectedCruise() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedCruise() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.CRUISE_GREATER.getMetadata()
			&& this.airship.getModuleSelectedCruise() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//Water
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.WATER_LESSER.getMetadata()
			&& this.airship.getModuleSelectedWater() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.WATER_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedWater() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.WATER_GREATER.getMetadata()
			&& this.airship.getModuleSelectedWater() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//Infinite Fuel
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			&& this.airship.getModuleSelectedFuelInfinite() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedFuelInfinite() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata()
			&& this.airship.getModuleSelectedFuelInfinite() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//Bomb
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.BOMB_LESSER.getMetadata()
			&& this.airship.getModuleSelectedBomb() != 0)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.BOMB_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedBomb() != 1)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVM.ModuleType.BOMB_GREATER.getMetadata()
			&& this.airship.getModuleSelectedBomb() != 2)
			{
				GuiVM.buttonModuleLearn.enabled = false;
			}
			//On status
			else
	        {
	        	GuiVM.buttonModuleLearn.enabled = true;
	        }
		}
        else
        {
        	GuiVM.buttonModuleLearn.enabled = false;
        }
		
		
		GuiVM.buttonModuleLesserAltitude.visible = false;
		GuiVM.buttonModuleNormalAltitude.visible = false;
		GuiVM.buttonModuleGreaterAltitude.visible = false;
		
		GuiVM.buttonModuleLesserSpeed.visible = false;
		GuiVM.buttonModuleNormalSpeed.visible = false;
		GuiVM.buttonModuleGreaterSpeed.visible = false;
		
		GuiVM.buttonModuleLesserStorage.visible = false;
		GuiVM.buttonModuleNormalStorage.visible = false;
		GuiVM.buttonModuleGreaterStorage.visible = false;
		
		GuiVM.buttonModuleLesserFuel.visible = false;
		GuiVM.buttonModuleNormalFuel.visible = false;
		GuiVM.buttonModuleGreaterFuel.visible = false;
		
		GuiVM.buttonModuleLesserMusic.visible = false;
		GuiVM.buttonModuleNormalMusic.visible = false;
		GuiVM.buttonModuleGreaterMusic.visible = false;
		
		GuiVM.buttonModuleLesserCruise.visible = false;
		GuiVM.buttonModuleNormalCruise.visible = false;
		GuiVM.buttonModuleGreaterCruise.visible = false;
		
		GuiVM.buttonModuleLesserWater.visible = false;
		GuiVM.buttonModuleNormalWater.visible = false;
		GuiVM.buttonModuleGreaterWater.visible = false;
		
		GuiVM.buttonModuleLesserInfiniteFuel.visible = false;
		GuiVM.buttonModuleNormalInfiniteFuel.visible = false;
		GuiVM.buttonModuleGreaterInfiniteFuel.visible = false;
		
		GuiVM.buttonModuleLesserBomb.visible = false;
		GuiVM.buttonModuleNormalBomb.visible = false;
		GuiVM.buttonModuleGreaterBomb.visible = false;
		
		
		
		//What Altitude button is enabled
		if(this.airship.getModuleLearnedAltitude())
		{
			if(this.airship.getModuleSelectedAltitude() == 1)
			{
				GuiVM.buttonModuleLesserAltitude.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.ALTITUDE_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserAltitude.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserAltitude.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedAltitude() == 2)
			{
				GuiVM.buttonModuleNormalAltitude.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.ALTITUDE_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalAltitude.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalAltitude.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedAltitude() == 3)
			{
				GuiVM.buttonModuleGreaterAltitude.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.ALTITUDE_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterAltitude.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterAltitude.enabled = true;
				}
			}
		}
		//What Speed button is enabled
		if(this.airship.getModuleLearnedSpeed())
		{
			if(this.airship.getModuleSelectedSpeed() == 1)
			{
				GuiVM.buttonModuleLesserSpeed.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.SPEED_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserSpeed.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserSpeed.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedSpeed() == 2)
			{
				GuiVM.buttonModuleNormalSpeed.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.SPEED_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalSpeed.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalSpeed.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedSpeed() == 3)
			{
				GuiVM.buttonModuleGreaterSpeed.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.SPEED_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterSpeed.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterSpeed.enabled = true;
				}
			}
		}
		//What Storage button is enabled
		if(this.airship.getModuleLearnedStorage())
		{
			if(this.airship.getModuleSelectedStorage() == 1)
			{
				GuiVM.buttonModuleLesserStorage.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.STORAGE_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserStorage.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserStorage.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedStorage() == 2)
			{
				GuiVM.buttonModuleNormalStorage.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.STORAGE_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalStorage.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalStorage.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedStorage() == 3)
			{
				GuiVM.buttonModuleGreaterStorage.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.STORAGE_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterStorage.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterStorage.enabled = true;
				}
			}
		}
		//What Fuel button is enabled
		if(this.airship.getModuleLearnedFuel())
		{
			if(this.airship.getModuleSelectedFuel() == 1)
			{
				GuiVM.buttonModuleLesserFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.FUEL_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserFuel.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserFuel.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedFuel() == 2)
			{
				GuiVM.buttonModuleNormalFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.FUEL_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalFuel.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalFuel.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedFuel() == 3)
			{
				GuiVM.buttonModuleGreaterFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.FUEL_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterFuel.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterFuel.enabled = true;
				}
			}
		}
		//What Music button is enabled
		if(this.airship.getModuleLearnedMusic())
		{
			if(this.airship.getModuleSelectedMusic() == 1)
			{
				GuiVM.buttonModuleLesserMusic.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.MUSIC_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserMusic.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserMusic.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedMusic() == 2)
			{
				GuiVM.buttonModuleNormalMusic.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.MUSIC_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalMusic.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalMusic.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedMusic() == 3)
			{
				GuiVM.buttonModuleGreaterMusic.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.MUSIC_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterMusic.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterMusic.enabled = true;
				}
			}
		}
		//What Cruise button is enabled
		if(this.airship.getModuleLearnedCruise())
		{
			if(this.airship.getModuleSelectedCruise() == 1)
			{
				GuiVM.buttonModuleLesserCruise.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.CRUISE_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserCruise.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserCruise.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedCruise() == 2)
			{
				GuiVM.buttonModuleNormalCruise.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.CRUISE_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalCruise.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalCruise.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedCruise() == 3)
			{
				GuiVM.buttonModuleGreaterCruise.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.CRUISE_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterCruise.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterCruise.enabled = true;
				}
			}
		}
		//What Water button is enabled
		if(this.airship.getModuleLearnedWater())
		{
			if(this.airship.getModuleSelectedWater() == 1)
			{
				GuiVM.buttonModuleLesserWater.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.WATER_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserWater.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserWater.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedWater() == 2)
			{
				GuiVM.buttonModuleNormalWater.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.WATER_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalWater.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalWater.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedWater() == 3)
			{
				GuiVM.buttonModuleGreaterWater.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.WATER_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterWater.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterWater.enabled = true;
				}
			}
		}
		//What InfiniteFuel button is enabled
		if(this.airship.getModuleLearnedFuelInfinite())
		{
			if(this.airship.getModuleSelectedFuelInfinite() == 1)
			{
				GuiVM.buttonModuleLesserInfiniteFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.INFINITE_FUEL_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserInfiniteFuel.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserInfiniteFuel.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedFuelInfinite() == 2)
			{
				GuiVM.buttonModuleNormalInfiniteFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalInfiniteFuel.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalInfiniteFuel.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedFuelInfinite() == 3)
			{
				GuiVM.buttonModuleGreaterInfiniteFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterInfiniteFuel.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterInfiniteFuel.enabled = true;
				}
			}
		}
		//What Bomb button is enabled
		if(this.airship.getModuleLearnedBomb())
		{
			if(this.airship.getModuleSelectedBomb() == 1)
			{
				GuiVM.buttonModuleLesserBomb.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.BOMB_LESSER.getMetadata())
				{
					GuiVM.buttonModuleLesserBomb.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleLesserBomb.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedBomb() == 2)
			{
				GuiVM.buttonModuleNormalBomb.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.BOMB_NORMAL.getMetadata())
				{
					GuiVM.buttonModuleNormalBomb.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleNormalBomb.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedBomb() == 3)
			{
				GuiVM.buttonModuleGreaterBomb.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVM.ModuleType.BOMB_GREATER.getMetadata())
				{
					GuiVM.buttonModuleGreaterBomb.enabled = false;
				}
				else
				{
					GuiVM.buttonModuleGreaterBomb.enabled = true;
				}
			}
		}
    }
}
