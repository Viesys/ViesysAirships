package com.vies.viesmachines.client.gui.machines.stats;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VC;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuStats extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_stats.png");
	
	public GuiMachineMenuStats(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
		this.modelRotationHorizontal = 45;
		this.modelRidingEntity = false;
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVM.buttonRotateLeft = new GuiButtonGeneral2VC(10, this.guiLeft + 110, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRotateRight = new GuiButtonGeneral2VC(10, this.guiLeft + 122, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRidingPlayerTrue = new GuiButtonGeneral1VC(12, this.guiLeft + 130, this.guiTop + 66, 10, 10, "", 1);
    	GuiVM.buttonRidingPlayerFalse = new GuiButtonGeneral1VC(13, this.guiLeft + 140, this.guiTop + 66, 10, 10, "", 2);
    	GuiVM.buttonUndo = new GuiButtonGeneral2VC(11, this.guiLeft + 158, this.guiTop + 66, 10, 10, "", 1);
		
    	this.buttonList.add(GuiVM.buttonRotateLeft);
    	this.buttonList.add(GuiVM.buttonRotateRight);
    	this.buttonList.add(GuiVM.buttonRidingPlayerTrue);
    	this.buttonList.add(GuiVM.buttonRidingPlayerFalse);
    	this.buttonList.add(GuiVM.buttonUndo);
    	
    	this.buttonList.add(GuiVM.buttonMM1);
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		this.buttonList.add(GuiVM.buttonMM4);
		this.buttonList.add(GuiVM.buttonMM5);
		
		GuiVM.buttonMM2.enabled = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Binds the texture to use:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Draws the background texture:
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.drawEntityOnScreen(this.guiLeft + 139, this.guiTop + 58, this.modelRotationHorizontal, 11, this.machine, this.modelRidingEntity);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// Draws a black line under the machine preview options buttons:
		this.drawRect(130, 75, 168, 76, Color.BLACK.getRGB());
		
		// Main labels:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			
			this.centeredString(fontRenderer, References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.statsinfo.0"), 74, 10, Color.BLACK.getRGB());
			this.centeredString(fontRenderer, References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.upgrades.0"),118, 110, Color.BLACK.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Sub labels:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			// Category- Ground, Flying, Water:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.category.0"), 110, 40, 11111111);
			this.centeredString(fontRenderer, this.machine.getCategoryName(), 110, 60, Color.WHITE.getRGB());
			
			// Type - Airship, Helicopter, etc:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.type.0"), 62, 80, 11111111);
			this.centeredString(fontRenderer, this.machine.getTypeName(), 62, 100, Color.WHITE.getRGB());
			
			// Variant - Hindenburg, Dirigible, etc:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.variant.0"), 158, 80, 11111111);
			this.centeredString(fontRenderer, this.machine.getVariantName(), 158, 100, Color.WHITE.getRGB());
			
			// Draws a white background so that black text can be read in the gui:
			if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.BLACK.getMetadata()) 
			{
				this.drawRect(17, 137, 203, 151, Color.WHITE.getRGB());
			}
			
			// Name:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.name.0"), 110, 120, 11111111);
			this.centeredString(fontRenderer, EnumsVM.SelectColor.byId(this.machine.getVisualNameColor()).getTextColor() + this.machine.getCustomNameTag(), 110, 140, Color.WHITE.getRGB());
			
			//"================================" - 32 digits
			
			
			
			// Upgrades:
			
			// Frame Tier:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.frame.0"), 68, 190, 11111111);
			if (this.machine.getTierFrame() == 0)
			{
				this.centeredString(fontRenderer, References.Old_I18n.translateToLocalFormatted("viesmachines.main.base"), 68, 210, Color.GRAY.getRGB());
			}
			else if (this.machine.getTierFrame() == 1)
			{
				this.centeredString(fontRenderer, TextFormatting.YELLOW + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierFrame()), 68, 210, Color.WHITE.getRGB());
			}
			else if (this.machine.getTierFrame() == 2)
			{
				this.centeredString(fontRenderer, TextFormatting.AQUA + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierFrame()), 68, 210, Color.WHITE.getRGB());
			}
			else if (this.machine.getTierFrame() == 3)
			{
				this.centeredString(fontRenderer, TextFormatting.LIGHT_PURPLE + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierFrame()), 68, 210, Color.WHITE.getRGB());
			}
			
			// Health:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.health.0"), 68, 230, 11111111);
			this.centeredString(fontRenderer, Integer.toString((int)this.machine.getHealth()) + " / " + Integer.toString((int)this.machine.getMachineMaxHealth()), 68, 250, Color.WHITE.getRGB());
			
			// Energy:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.energy.0"), 68, 270, 11111111);
			this.centeredString(fontRenderer, Integer.toString((int)this.machine.getEnergy()) + " / " + Integer.toString((int)this.machine.getMaxEnergy()), 68, 290, Color.WHITE.getRGB());
			
			// Engine Tier:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.engine.0"), 176, 190, 11111111);
			if (this.machine.getTierEngine() == 0)
			{
				this.centeredString(fontRenderer, References.Old_I18n.translateToLocalFormatted("viesmachines.main.base"), 176, 210, Color.GRAY.getRGB());
			}
			else if (this.machine.getTierEngine() == 1)
			{
				this.centeredString(fontRenderer, TextFormatting.YELLOW + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierEngine()), 176, 210, Color.WHITE.getRGB());
			}
			else if (this.machine.getTierEngine() == 2)
			{
				this.centeredString(fontRenderer, TextFormatting.AQUA + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierEngine()), 176, 210, Color.WHITE.getRGB());
			}
			else if (this.machine.getTierEngine() == 3)
			{
				this.centeredString(fontRenderer, TextFormatting.LIGHT_PURPLE + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierEngine()), 176, 210, Color.WHITE.getRGB());
			}
			
			// Forward Speed:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.speed.0"), 176, 230, 11111111);
			this.centeredString(fontRenderer, 
					//Integer.toString(
					Float.toString(EnumsVM.FlyingMachineEngineTier.byId(this.machine.getTierEngine()).getFowardSpeedModifier() * 1000)
					//)
					, 176, 250, Color.WHITE.getRGB());
			//LogHelper.info(
					//Integer.toString((int) 
			//				EnumsVC.FlyingMachineEngineTier.byId(this.machine.getTierEngine()).getFowardSpeedModifier()
			//				* 1000//)
			//);
			// Fuel Efficiency:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.energyregen.0"), 176, 270, 11111111);
			this.centeredString(fontRenderer, "+1" + " " + References.Old_I18n.translateToLocalFormatted("viesmachines.main.per") + " " + Integer.toString(EnumsVM.FlyingMachineEngineTier.byId(this.machine.getTierEngine()).getEnergyRegenModifier() / 20) + " " + References.Old_I18n.translateToLocalFormatted("viesmachines.main.seconds") + ".", 176, 290, Color.WHITE.getRGB());
			
			// Component Tier:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.component.0"), 284, 190, 11111111);
			if (this.machine.getTierComponent() == 0)
			{
				this.centeredString(fontRenderer, References.Old_I18n.translateToLocalFormatted("viesmachines.main.base"), 284, 210, Color.GRAY.getRGB());
			}
			else if (this.machine.getTierComponent() == 1)
			{
				this.centeredString(fontRenderer, TextFormatting.YELLOW + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierComponent()), 284, 210, Color.WHITE.getRGB());
			}
			else if (this.machine.getTierComponent() == 2)
			{
				this.centeredString(fontRenderer, TextFormatting.AQUA + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierComponent()), 284, 210, Color.WHITE.getRGB());
			}
			else if (this.machine.getTierComponent() == 3)
			{
				this.centeredString(fontRenderer, TextFormatting.LIGHT_PURPLE + References.Old_I18n.translateToLocalFormatted("viesmachines.main.tier") + " " + Integer.toString(this.machine.getTierComponent()), 284, 210, Color.WHITE.getRGB());
			}
			
			// Ammo:
			this.centeredString(fontRenderer, TextFormatting.BOLD + References.Old_I18n.translateToLocalFormatted("viesmachines.gui.tt.stats.ammo.0"), 284, 230, 11111111);
			this.centeredString(fontRenderer, Integer.toString(this.machine.getAmmoAmount()) + " / "+ Integer.toString(this.machine.getMaxAmmoAmount()), 284, 250, Color.WHITE.getRGB());
			// Special Stat:
			this.centeredString(fontRenderer, TextFormatting.BOLD + this.machine.getComponentName(), 284, 270, 11111111);
			this.centeredString(fontRenderer, "+1" + " " + References.Old_I18n.translateToLocalFormatted("viesmachines.main.per") + " " + Integer.toString(EnumsVM.FlyingMachineEngineTier.byId(this.machine.getTierEngine()).getEnergyRegenModifier()) + " " + References.Old_I18n.translateToLocalFormatted("viesmachines.main.seconds") + ".", 284, 290, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		
		
		// Binds the texture to use:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Left Arrow symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(110, 67.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 16, 12, 12);
		}
		GlStateManager.popMatrix();
		
		// Right Arrow symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(122, 67.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 28, 12, 12);
		}
		GlStateManager.popMatrix();
		
		// Steve head symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(132, 67.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 40, 12, 12);
		}
		GlStateManager.popMatrix();
		
		// Steve head 'X' symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(142, 67.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 52, 12, 12);
		}
		GlStateManager.popMatrix();
		
		// Undo symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(161, 69, 0);
			GlStateManager.scale(0.25F, 0.25F, 0.25F);
			
			this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
		
		
		
		// Logic for mouse-over tooltip - Turn Left:
		if(mouseX >= this.guiLeft + 110 && mouseX <= this.guiLeft + 115
		&& mouseY >= this.guiTop + 68 && mouseY <= this.guiTop + 73)
		{
			if(this.isShiftKeyDown())
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.general.previewturnleft.0"));
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 20, mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.general.previewturn.0"));
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 20, mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			
		}
		
		// Logic for mouse-over tooltip - Turn Right:
		if(mouseX >= this.guiLeft + 122 && mouseX <= this.guiLeft + 127
		&& mouseY >= this.guiTop + 68 && mouseY <= this.guiTop + 73)
		{
			if(this.isShiftKeyDown())
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.general.previewturnright.0"));
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 20, mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.general.previewturn.0"));
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 20, mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
	}
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        
        // Deals with the Preview player buttons toggle:
        if(!this.modelRidingEntity)
		{
        	GuiVM.buttonRidingPlayerTrue.enabled = true;
			GuiVM.buttonRidingPlayerFalse.enabled = false;
		}
		else
		{
			GuiVM.buttonRidingPlayerTrue.enabled = false;
			GuiVM.buttonRidingPlayerFalse.enabled = true;
		}
        
        // Deals with the Power buttons toggle:
        if(this.machine.getPoweredOn())
		{
			GuiVM.buttonMachineOnTrue.visible = true;
			GuiVM.buttonMachineOnFalse.visible = false;
		}
		else
		{
			GuiVM.buttonMachineOnTrue.visible = false;
			GuiVM.buttonMachineOnFalse.visible = true;
		}
        
        // Deals with the Autorun buttons toggle:
        if(this.machine.getAutorun())
		{
			GuiVM.buttonMachineAutorunTrue.visible = true;
			GuiVM.buttonMachineAutorunFalse.visible = false;
		}
		else
		{
			GuiVM.buttonMachineAutorunTrue.visible = false;
			GuiVM.buttonMachineAutorunFalse.visible = true;
		}
        
        // Deals with the Broken affected buttons:
        if (this.machine.getBroken())
        {
        	GuiVM.buttonMusicSelect.enabled = false;
        	GuiVM.buttonMusicStop.enabled = false;
        	GuiVM.buttonMusicPlay.enabled = false;
        	GuiVM.buttonMusicRandom.enabled = false;
        }
        else
        {
        	GuiVM.buttonMusicSelect.enabled = true;
        	GuiVM.buttonMusicStop.enabled = true;
        	GuiVM.buttonMusicPlay.enabled = true;
        	GuiVM.buttonMusicRandom.enabled = true;
        }
        
        // Turn machine preview left with shift down:
        if (GuiVM.buttonRotateLeft.isMouseOver() 
		&& this.isShiftKeyDown())
 	    {
 			this.modelRotationHorizontal = this.modelRotationHorizontal - 2;
 		}
 		
 		// Turn machine preview right with shift down:
 		if (GuiVM.buttonRotateRight.isMouseOver()
 		&& this.isShiftKeyDown())
 	    {
 			this.modelRotationHorizontal = this.modelRotationHorizontal + 2;
 		}
    }
}
