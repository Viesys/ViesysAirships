package com.vies.viesmachines.client.gui.machines.visual.holiday;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VC;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.MessageGuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_holiday.png");
	
	public GuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
		this.machineTexture = this.machine.getVisualComponentTexture();
		this.modelRotationHorizontal = 160;
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
		
    	GuiVM.buttonApply = new GuiButtonGeneral1VC(21, this.guiLeft + 7, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.apply"), 1);
		GuiVM.buttonBack = new GuiButtonGeneral1VC(22, this.guiLeft + 61, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		
		//--------------------------------------------------
		
		GuiVM.buttonTexture00 = new GuiButtonGeneral1VC(110, this.guiLeft + 32-14 + (14 * 0), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture01 = new GuiButtonGeneral1VC(111, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture02 = new GuiButtonGeneral1VC(112, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture03 = new GuiButtonGeneral1VC(113, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture04 = new GuiButtonGeneral1VC(114, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture05 = new GuiButtonGeneral1VC(115, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture06 = new GuiButtonGeneral1VC(116, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture07 = new GuiButtonGeneral1VC(117, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture08 = new GuiButtonGeneral1VC(118, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture09 = new GuiButtonGeneral1VC(119, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7, 14, 14, "", 3);
		
		//--------------------------------------------------
		
		this.buttonList.add(GuiVM.buttonTexture00);
		this.buttonList.add(GuiVM.buttonTexture01);
		this.buttonList.add(GuiVM.buttonTexture02);
		this.buttonList.add(GuiVM.buttonTexture03);
		this.buttonList.add(GuiVM.buttonTexture04);
		this.buttonList.add(GuiVM.buttonTexture05);
		this.buttonList.add(GuiVM.buttonTexture06);
		this.buttonList.add(GuiVM.buttonTexture07);
		this.buttonList.add(GuiVM.buttonTexture08);
		this.buttonList.add(GuiVM.buttonTexture09);
		
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
		this.buttonList.add(GuiVM.buttonRotateLeft);
    	this.buttonList.add(GuiVM.buttonRotateRight);
    	this.buttonList.add(GuiVM.buttonRidingPlayerTrue);
    	this.buttonList.add(GuiVM.buttonRidingPlayerFalse);
    	this.buttonList.add(GuiVM.buttonUndo);
    	
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		
		GuiVM.buttonMM3.enabled = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		// Apply:
		if (parButton.id == 21)
		{
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture());
		}
		// Back:
		if (parButton.id == 22)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizePrimarySkinTexture());
		}
		// All main texture buttons:
		if (parButton.id >= 100
		&& parButton.id <= 199)
		{
			this.machineTexture = (parButton.id - 100);
		}
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Draws a gray box behind the main background texture:
		this.drawRect(this.guiLeft +8, this.guiTop + 6, this.guiLeft +168, this.guiTop + 64, Color.GRAY.getRGB());
		
		// Current texture:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55, 43, 0);
			
			this.drawStillItemStack(EnumsVM.VisualSecondaryTexture.byId(this.machine.getVisualComponentTexture()).getBlock(), this.guiLeft , this.guiTop);
		}
		GlStateManager.popMatrix();
		
		// Colors, binds, and draws the background texture:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		// Renders the 'Preview Entity' for the current machine:
		this.drawEntityOnScreen(this.guiLeft + 139, this.guiTop + 58, this.modelRotationHorizontal, 13, this.machine, this.modelRidingEntity);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// 'Secondary Texture':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.5, 11, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.halloween"), false), 0, 0, Color.BLACK.getRGB());
		}
		GlStateManager.popMatrix();
		
		// 'Current Texture':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.25, 53, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.currenttexture.0"), 0, 0, Color.BLUE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// 'Preview':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(138.5, 10, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.main.preview"), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// 'Holiday':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(39, 83, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.holiday"), false), 0, 0, Color.CYAN.getRGB());
		}
		GlStateManager.popMatrix();
		
		//--------------------------------------------------
		
		// Renders the default row blocks over buttons:
		GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
			
	    	GlStateManager.translate(39-28, 98.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawItemStack(EnumsVM.VisualSecondaryTexture.DEFAULT.getBlock(), ((14 * 1) * 2), 0, "");
			this.drawItemStack(EnumsVM.VisualSecondaryTexture.COBBLESTONE.getBlock(), ((14 * 2) * 2), 0, "");
			this.drawItemStack(EnumsVM.VisualSecondaryTexture.SANDSTONE.getBlock(), ((14 * 3) * 2), 0, "");
			this.drawItemStack(EnumsVM.VisualSecondaryTexture.SNOW.getBlock(), ((14 * 4) * 2), 0, "");
			this.drawItemStack(EnumsVM.VisualSecondaryTexture.HAY_BLOCK.getBlock(), ((14 * 5) * 2), 0, "");
		}
		GlStateManager.popMatrix();
		
		// Draws a black line under the machine preview options buttons:
		this.drawRect(130, 75, 168, 76, Color.BLACK.getRGB());
		
		// Colors and binds the background texture:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Preview Left Arrow symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(110, 67.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 16, 12, 12);
		}
		GlStateManager.popMatrix();
		// Preview Right Arrow symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(122, 67.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 28, 12, 12);
		}
		GlStateManager.popMatrix();
		// Preview Steve head symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(132, 67.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 40, 12, 12);
		}
		GlStateManager.popMatrix();
		// Preview Steve head 'X' symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(142, 67.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 52, 12, 12);
		}
		GlStateManager.popMatrix();
		// Preview Undo symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(161, 69, 0);
			GlStateManager.scale(0.25F, 0.25F, 0.25F);
			
			this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
		
		
		
		this.mouseOverTooltipHandler(mouseX, mouseY);
		
		
		
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
					int textNumber = text.toString().length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
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
					int textNumber = text.toString().length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
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
					int textNumber = text.toString().length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
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
					int textNumber = text.toString().length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		
		
		// Logic for mouse-over tooltip - Apply:
		if (mouseX >= this.guiLeft + 7 && mouseX <= this.guiLeft + 7+41
		&& mouseY >= this.guiTop +63 && mouseY <= this.guiTop +63+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (!GuiVM.buttonApply.enabled)
			{
				
			}
			else
			{
				text.add(this.stringToRainbow(References.localNameVC("viesmachines.button.holiday.cost"), false));
			}
			
			GlStateManager.pushMatrix();
			{
				int textNumber = References.localNameVC("viesmachines.button.holiday.cost").length();
				
				GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop - 13, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
    }
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		if (keyCode == 1 
        ||	keyCode == Keybinds.openGuiMenu.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.player.closeScreen();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        
        // Handles when the 'Apply' button is enabled:
        if (this.machine.getControllingPassenger() instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
    		
    		if (this.machineTexture == this.machine.getVisualComponentTexture())
    		{
    			GuiVM.buttonApply.enabled = false;
    		}
    		else if (this.machineTexture == 0)
    		{
    			GuiVM.buttonApply.enabled = true;
    		}
    		else if (player.isCreative())
    		{
    			GuiVM.buttonApply.enabled = true;
    		}
    		else if (this.machine.getEnergy() >= CostsVM.COST_COMPONENT_TEXTURE)
    		{
    			GuiVM.buttonApply.enabled = true;
    		}
    		else
    		{
    			GuiVM.buttonApply.enabled = false;
    		}
    	}
        
        //--------------------------------------------------
        
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
        
        // Turns machine preview left with shift down:
        if (GuiVM.buttonRotateLeft.isMouseOver() 
		&& this.isShiftKeyDown())
 	    {
 			this.modelRotationHorizontal = this.modelRotationHorizontal - 2;
 		}
 		// Turns machine preview right with shift down:
 		if (GuiVM.buttonRotateRight.isMouseOver()
 		&& this.isShiftKeyDown())
 	    {
 			this.modelRotationHorizontal = this.modelRotationHorizontal + 2;
 		}
 		
 		this.buttonHandler();
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException 
	{
        super.mouseClicked(x, y, btn);
    }
	
	/** Handles spacing/name of texture mouseover tooltips. */
	protected void mouseOverTooltipNames(int mouseX, int mouseY, int xIn, int yIn, int enumIn) 
	{
		// Logic for mouse-over tooltip - Default Row:
		if(mouseX >= this.guiLeft + xIn && mouseX <= this.guiLeft + xIn + 13
		&& mouseY >= this.guiTop + yIn && mouseY <= this.guiTop + yIn + 13)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.GREEN + "" + TextFormatting.BOLD + References.Old_I18n.translateToLocal(EnumsVM.VisualSecondaryTexture.byId(enumIn).getLocalizedName()));
			
			GlStateManager.pushMatrix();
			{
				int textNumber = References.Old_I18n.translateToLocal(EnumsVM.VisualSecondaryTexture.byId(enumIn).getLocalizedName()).length();
				
				GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 11, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
	}
	
	/** Deals with visibility and enabled texture buttons: */
	protected void buttonHandler()
	{
		// Tier 1:
		if (this.machine.getTierComponent() >= 1)
		{
			GuiVM.buttonTexture05.visible = true;
			GuiVM.buttonTexture06.visible = true;
			GuiVM.buttonTexture07.visible = true;
			GuiVM.buttonTexture08.visible = true;
			GuiVM.buttonTexture09.visible = true;
			GuiVM.buttonTexture10.visible = true;
			GuiVM.buttonTexture11.visible = true;
			
			GuiVM.buttonTexture12.visible = true;
			GuiVM.buttonTexture13.visible = true;
			GuiVM.buttonTexture14.visible = true;
			GuiVM.buttonTexture15.visible = true;
			GuiVM.buttonTexture16.visible = true;
			GuiVM.buttonTexture17.visible = true;
			GuiVM.buttonTexture18.visible = true;
		}
		else
		{
			GuiVM.buttonTexture05.visible = false;
			GuiVM.buttonTexture06.visible = false;
			GuiVM.buttonTexture07.visible = false;
			GuiVM.buttonTexture08.visible = false;
			GuiVM.buttonTexture09.visible = false;
			GuiVM.buttonTexture10.visible = false;
			GuiVM.buttonTexture11.visible = false;
			
			GuiVM.buttonTexture12.visible = false;
			GuiVM.buttonTexture13.visible = false;
			GuiVM.buttonTexture14.visible = false;
			GuiVM.buttonTexture15.visible = false;
			GuiVM.buttonTexture16.visible = false;
			GuiVM.buttonTexture17.visible = false;
			GuiVM.buttonTexture18.visible = false;
		}
		
		// Tier 2:
		if (this.machine.getTierComponent() >= 2)
		{
			GuiVM.buttonTexture19.visible = true;
			GuiVM.buttonTexture20.visible = true;
			GuiVM.buttonTexture21.visible = true;
			GuiVM.buttonTexture22.visible = true;
			GuiVM.buttonTexture23.visible = true;
			GuiVM.buttonTexture24.visible = true;
			GuiVM.buttonTexture25.visible = true;
			
			GuiVM.buttonTexture26.visible = true;
			GuiVM.buttonTexture27.visible = true;
			GuiVM.buttonTexture28.visible = true;
			GuiVM.buttonTexture29.visible = true;
			GuiVM.buttonTexture30.visible = true;
			GuiVM.buttonTexture31.visible = true;
			GuiVM.buttonTexture32.visible = true;
		}
		else
		{
			GuiVM.buttonTexture19.visible = false;
			GuiVM.buttonTexture20.visible = false;
			GuiVM.buttonTexture21.visible = false;
			GuiVM.buttonTexture22.visible = false;
			GuiVM.buttonTexture23.visible = false;
			GuiVM.buttonTexture24.visible = false;
			GuiVM.buttonTexture25.visible = false;
			
			GuiVM.buttonTexture26.visible = false;
			GuiVM.buttonTexture27.visible = false;
			GuiVM.buttonTexture28.visible = false;
			GuiVM.buttonTexture29.visible = false;
			GuiVM.buttonTexture30.visible = false;
			GuiVM.buttonTexture31.visible = false;
			GuiVM.buttonTexture32.visible = false;
		}
		
		// Tier 3:
		if (this.machine.getTierComponent() >= 3)
		{
			GuiVM.buttonTexture33.visible = true;
			GuiVM.buttonTexture34.visible = true;
			GuiVM.buttonTexture35.visible = true;
			GuiVM.buttonTexture36.visible = true;
			GuiVM.buttonTexture37.visible = true;
			GuiVM.buttonTexture38.visible = true;
			GuiVM.buttonTexture39.visible = true;
			
			GuiVM.buttonTexture40.visible = true;
			GuiVM.buttonTexture41.visible = true;
			GuiVM.buttonTexture42.visible = true;
			GuiVM.buttonTexture43.visible = true;
			GuiVM.buttonTexture44.visible = true;
			GuiVM.buttonTexture45.visible = true;
			GuiVM.buttonTexture46.visible = true;
		}
		else
		{
			GuiVM.buttonTexture33.visible = false;
			GuiVM.buttonTexture34.visible = false;
			GuiVM.buttonTexture35.visible = false;
			GuiVM.buttonTexture36.visible = false;
			GuiVM.buttonTexture37.visible = false;
			GuiVM.buttonTexture38.visible = false;
			GuiVM.buttonTexture39.visible = false;
			
			GuiVM.buttonTexture40.visible = false;
			GuiVM.buttonTexture41.visible = false;
			GuiVM.buttonTexture42.visible = false;
			GuiVM.buttonTexture43.visible = false;
			GuiVM.buttonTexture44.visible = false;
			GuiVM.buttonTexture45.visible = false;
			GuiVM.buttonTexture46.visible = false;
		}
		
		//==================================================
		
		if(this.machine.getVisualComponentTexture() == 0)
		{
			GuiVM.buttonTexture00.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture00.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 1)
		{
			GuiVM.buttonTexture01.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture01.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 2)
		{
			GuiVM.buttonTexture02.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture02.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 3)
		{
			GuiVM.buttonTexture03.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture03.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 4)
		{
			GuiVM.buttonTexture04.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture04.enabled = true;
		}
		
		//--------------------------------------------------
		
		if(this.machine.getVisualComponentTexture() == 5)
		{
			GuiVM.buttonTexture05.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture05.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 6)
		{
			GuiVM.buttonTexture06.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture06.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 7)
		{
			GuiVM.buttonTexture07.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture07.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 8)
		{
			GuiVM.buttonTexture08.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture08.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 9)
		{
			GuiVM.buttonTexture09.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture09.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 10)
		{
			GuiVM.buttonTexture10.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture10.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 11)
		{
			GuiVM.buttonTexture11.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture11.enabled = true;
		}
		
		if(this.machine.getVisualComponentTexture() == 12)
		{
			GuiVM.buttonTexture12.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture12.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 13)
		{
			GuiVM.buttonTexture13.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture13.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 14)
		{
			GuiVM.buttonTexture14.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture14.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 15)
		{
			GuiVM.buttonTexture15.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture15.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 16)
		{
			GuiVM.buttonTexture16.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture16.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 17)
		{
			GuiVM.buttonTexture17.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture17.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 18)
		{
			GuiVM.buttonTexture18.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture18.enabled = true;
		}
		
		//--------------------------------------------------
		
		if(this.machine.getVisualComponentTexture() == 19)
		{
			GuiVM.buttonTexture19.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture19.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 20)
		{
			GuiVM.buttonTexture20.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture20.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 21)
		{
			GuiVM.buttonTexture21.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture21.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 22)
		{
			GuiVM.buttonTexture22.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture22.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 23)
		{
			GuiVM.buttonTexture23.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture23.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 24)
		{
			GuiVM.buttonTexture24.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture24.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 25)
		{
			GuiVM.buttonTexture25.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture25.enabled = true;
		}
		
		if(this.machine.getVisualComponentTexture() == 26)
		{
			GuiVM.buttonTexture26.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture26.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 27)
		{
			GuiVM.buttonTexture27.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture27.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 28)
		{
			GuiVM.buttonTexture28.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture28.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 29)
		{
			GuiVM.buttonTexture29.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture29.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 30)
		{
			GuiVM.buttonTexture30.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture30.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 31)
		{
			GuiVM.buttonTexture31.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture31.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 32)
		{
			GuiVM.buttonTexture32.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture32.enabled = true;
		}
		
		//--------------------------------------------------
		
		if(this.machine.getVisualComponentTexture() == 33)
		{
			GuiVM.buttonTexture33.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture33.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 34)
		{
			GuiVM.buttonTexture34.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture34.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 35)
		{
			GuiVM.buttonTexture35.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture35.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 36)
		{
			GuiVM.buttonTexture36.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture36.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 37)
		{
			GuiVM.buttonTexture37.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture37.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 38)
		{
			GuiVM.buttonTexture38.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture38.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 39)
		{
			GuiVM.buttonTexture39.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture39.enabled = true;
		}
		
		if(this.machine.getVisualComponentTexture() == 40)
		{
			GuiVM.buttonTexture40.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture40.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 41)
		{
			GuiVM.buttonTexture41.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture41.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 42)
		{
			GuiVM.buttonTexture42.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture42.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 43)
		{
			GuiVM.buttonTexture43.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture43.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 44)
		{
			GuiVM.buttonTexture44.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture44.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 45)
		{
			GuiVM.buttonTexture45.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture45.enabled = true;
		}
		if(this.machine.getVisualComponentTexture() == 46)
		{
			GuiVM.buttonTexture46.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture46.enabled = true;
		}
	}
	
	/** Handles all of the mouseover tooltip names for all texture buttons. */
	protected void mouseOverTooltipHandler(int mouseX, int mouseY) 
	{
		// Default Row:
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 86, EnumsVM.VisualSecondaryTexture.DEFAULT.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 86, EnumsVM.VisualSecondaryTexture.COBBLESTONE.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 86, EnumsVM.VisualSecondaryTexture.SANDSTONE.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 86, EnumsVM.VisualSecondaryTexture.SNOW.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 86, EnumsVM.VisualSecondaryTexture.HAY_BLOCK.getMetadata());
		
		//--------------------------------------------------
		
		// Tier 1 Row:
		if (this.machine.getTierComponent() >= 1)
		{
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 106, EnumsVM.VisualSecondaryTexture.PLANK_OAK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 106, EnumsVM.VisualSecondaryTexture.PLANK_SPRUCE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 106, EnumsVM.VisualSecondaryTexture.PLANK_BIRCH.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 106, EnumsVM.VisualSecondaryTexture.PLANK_JUNGLE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 106, EnumsVM.VisualSecondaryTexture.PLANK_ACACIA.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 106, EnumsVM.VisualSecondaryTexture.PLANK_DARK_OAK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 106, EnumsVM.VisualSecondaryTexture.PODZOL.getMetadata());
			
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 106 + (14 * 1), EnumsVM.VisualSecondaryTexture.LOG_OAK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 106 + (14 * 1), EnumsVM.VisualSecondaryTexture.LOG_SPRUCE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 106 + (14 * 1), EnumsVM.VisualSecondaryTexture.LOG_BIRCH.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 106 + (14 * 1), EnumsVM.VisualSecondaryTexture.LOG_JUNGLE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 106 + (14 * 1), EnumsVM.VisualSecondaryTexture.LOG_ACACIA.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 106 + (14 * 1), EnumsVM.VisualSecondaryTexture.LOG_DARK_OAK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 106 + (14 * 1), EnumsVM.VisualSecondaryTexture.MYCELIUM.getMetadata());
		}
		
		//--------------------------------------------------
		
		// Tier 2 Row:
		if (this.machine.getTierComponent() >= 2)
		{
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 136, EnumsVM.VisualSecondaryTexture.ORE_QUARTZ.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 136, EnumsVM.VisualSecondaryTexture.ORE_IRON.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 136, EnumsVM.VisualSecondaryTexture.ORE_GOLD.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 136, EnumsVM.VisualSecondaryTexture.ORE_REDSTONE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 136, EnumsVM.VisualSecondaryTexture.ORE_LAPIS_LAZULI.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 136, EnumsVM.VisualSecondaryTexture.ORE_DIAMOND.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 136, EnumsVM.VisualSecondaryTexture.ORE_EMERALD.getMetadata());
	
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 136 + (14 * 1), EnumsVM.VisualSecondaryTexture.BRICK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 136 + (14 * 1), EnumsVM.VisualSecondaryTexture.IRON.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 136 + (14 * 1), EnumsVM.VisualSecondaryTexture.GOLD.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 136 + (14 * 1), EnumsVM.VisualSecondaryTexture.REDSTONE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 136 + (14 * 1), EnumsVM.VisualSecondaryTexture.LAPIS_LAZULI.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 136 + (14 * 1), EnumsVM.VisualSecondaryTexture.DIAMOND.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 136 + (14 * 1), EnumsVM.VisualSecondaryTexture.EMERALD.getMetadata());
		}
		
		//--------------------------------------------------
		
		// Tier 3 Row:
		if (this.machine.getTierComponent() >= 3)
		{
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 166, EnumsVM.VisualSecondaryTexture.ICE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 166, EnumsVM.VisualSecondaryTexture.SLIME.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 166, EnumsVM.VisualSecondaryTexture.NETHER_BRICK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 166, EnumsVM.VisualSecondaryTexture.SOUL_SAND.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 166, EnumsVM.VisualSecondaryTexture.QUARTZ.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 166, EnumsVM.VisualSecondaryTexture.GLOWSTONE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 166, EnumsVM.VisualSecondaryTexture.OBSIDIAN.getMetadata());
	
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 166 + (14 * 1), EnumsVM.VisualSecondaryTexture.BEDROCK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 166 + (14 * 1), EnumsVM.VisualSecondaryTexture.PRISMARINE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 166 + (14 * 1), EnumsVM.VisualSecondaryTexture.END_STONE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 166 + (14 * 1), EnumsVM.VisualSecondaryTexture.PURPUR.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 166 + (14 * 1), EnumsVM.VisualSecondaryTexture.WATER.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 166 + (14 * 1), EnumsVM.VisualSecondaryTexture.LAVA.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 166 + (14 * 1), EnumsVM.VisualSecondaryTexture.ENDER.getMetadata());
		}
	}
	
	@Override
	protected void drawEntityOnScreen(int posX, int posY, int horizontalIn, int scale, Entity entityIn, boolean ridingEntityIn)
    {
		int oldTexture = this.machine.getVisualComponentTexture();
		
		this.machine.setVisualComponentTexture(this.machineTexture);
		
		super.drawEntityOnScreen(posX, posY, horizontalIn, scale, entityIn, ridingEntityIn);
		
		this.machine.setVisualComponentTexture(oldTexture);
    }
}
