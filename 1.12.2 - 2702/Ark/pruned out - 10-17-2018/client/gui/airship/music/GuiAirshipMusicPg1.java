package com.vies.viesmachines.client.gui.airship.music;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VC;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;
import com.vies.viesmachines.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.airship.main.MessageGuiMainMenu;
import com.vies.viesmachines.network.server.song.MessageHelperGuiMusicPg1;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiAirshipMusicPg1 extends GuiContainerVC {
	
	public GuiAirshipMusicPg1(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
		
		this.xSize = 176;
		this.ySize = 166;
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
    	int startPlace = 16;
    	
    	GuiVM.button501 = new GuiButton(501, this.guiLeft + 40, this.guiTop + 156, 96, 20, References.localNameVC("vc.button.done"));
    	
    	GuiVM.buttonR01 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORD11.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 0), 62, 14, References.localNameVC("vc.item.enum.song.1"), 0);
		GuiVM.buttonR02 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORD13.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 1), 62, 14, References.localNameVC("vc.item.enum.song.2"), 0);
    	GuiVM.buttonR03 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDBLOCKS.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 2), 62, 14, References.localNameVC("vc.item.enum.song.3"), 0);

		GuiVM.buttonR04 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDSTRAD.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 0), 62, 14, References.localNameVC("vc.item.enum.song.7"), 0);
		GuiVM.buttonR05 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDCHIRP.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 1), 62, 14, References.localNameVC("vc.item.enum.song.8"), 0);
		GuiVM.buttonR06 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDFAR.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 2), 62, 14, References.localNameVC("vc.item.enum.song.9"), 0);
		
		//======================================
		
    	GuiVM.buttonR07 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDMELLOHI.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 3), 62, 14, References.localNameVC("vc.item.enum.song.4"), 0);
		GuiVM.buttonR08 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDCAT.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 4), 62, 14, References.localNameVC("vc.item.enum.song.5"), 0);
		GuiVM.buttonR09 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDSTAL.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 5), 62, 14, References.localNameVC("vc.item.enum.song.6"), 0);

		GuiVM.buttonR10 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDMALL.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 3), 62, 14, References.localNameVC("vc.item.enum.song.10"), 0);
		GuiVM.buttonR11 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDWAIT.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 4), 62, 14, References.localNameVC("vc.item.enum.song.11"), 0);
		GuiVM.buttonR12 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDWARD.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 5), 62, 14, References.localNameVC("vc.item.enum.song.12"), 0);
		
		//======================================
		
		GuiVM.buttonR13 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDBRAMBLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 6), 62, 14, References.localNameVC("vc.item.enum.song.13"), 0);
		GuiVM.buttonR14 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDCASTLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 7), 62, 14, References.localNameVC("vc.item.enum.song.14"), 0);
		GuiVM.buttonR15 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDJUNGLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 8), 62, 14, References.localNameVC("vc.item.enum.song.15"), 0);
		
		GuiVM.buttonR16 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDDIRE.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 6), 62, 14, References.localNameVC("vc.item.enum.song.16"), 0);
		GuiVM.buttonR17 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDSTORMS.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 7), 62, 14, References.localNameVC("vc.item.enum.song.17"), 0);
		GuiVM.buttonR18 = new GuiButtonGeneral1VC(EnumsVM.AirshipSong.RECORDTIMESCAR.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 8), 62, 14, References.localNameVC("vc.item.enum.song.18"), 0);
    	
		
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		this.buttonList.add(GuiVM.buttonMM4);
		this.buttonList.add(GuiVM.buttonMM5);
		
		this.buttonList.add(GuiVM.button501);
		
		this.buttonList.add(GuiVM.buttonR01);
		this.buttonList.add(GuiVM.buttonR02);
		this.buttonList.add(GuiVM.buttonR03);
		this.buttonList.add(GuiVM.buttonR04);
		this.buttonList.add(GuiVM.buttonR05);
		this.buttonList.add(GuiVM.buttonR06);
		
		this.buttonList.add(GuiVM.buttonR07);
		this.buttonList.add(GuiVM.buttonR08);
		this.buttonList.add(GuiVM.buttonR09);
		this.buttonList.add(GuiVM.buttonR10);
		this.buttonList.add(GuiVM.buttonR11);
		this.buttonList.add(GuiVM.buttonR12);
		
		this.buttonList.add(GuiVM.buttonR13);
		this.buttonList.add(GuiVM.buttonR14);
		this.buttonList.add(GuiVM.buttonR15);
		this.buttonList.add(GuiVM.buttonR16);
		this.buttonList.add(GuiVM.buttonR17);
		this.buttonList.add(GuiVM.buttonR18);
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
			NetworkHandler.sendToServer(new MessageGuiMainMenu());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
			NetworkHandler.sendToServer(new MessageHelperGuiMusicPg1());
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
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_music.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 29, this.guiTop - 17, this.guiLeft + 147, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 30, this.guiTop - 16, this.guiLeft + 146, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 32, this.guiTop - 14, this.guiLeft + 144, this.guiTop, Color.BLACK.getRGB());
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 117, this.guiTop + -9, 0);
			GlStateManager.scale(.75, 0.75, 0.75);
			
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(EnumsVM.AirshipSong.byId(this.airship.metaJukeboxSelectedSong).getRegistryName(), 0, false, TextFormatting.GREEN), 0, 0, 255);
		}
		GlStateManager.popMatrix();
		
		GuiVM.buttonR07.visible = false;
		GuiVM.buttonR08.visible = false;
		GuiVM.buttonR09.visible = false;
		GuiVM.buttonR10.visible = false;
		GuiVM.buttonR11.visible = false;
		GuiVM.buttonR12.visible = false;
		
		GuiVM.buttonR13.visible = false;
		GuiVM.buttonR14.visible = false;
		GuiVM.buttonR15.visible = false;
		GuiVM.buttonR16.visible = false;
		GuiVM.buttonR17.visible = false;
		GuiVM.buttonR18.visible = false;
		
		if(this.airship.getModuleSelectedMusic() == 2)
		{
			GuiVM.buttonR07.visible = true;
			GuiVM.buttonR08.visible = true;
			GuiVM.buttonR09.visible = true;
			GuiVM.buttonR10.visible = true;
			GuiVM.buttonR11.visible = true;
			GuiVM.buttonR12.visible = true;
		}
		if(this.airship.getModuleSelectedMusic() == 3)
		{
			GuiVM.buttonR07.visible = true;
			GuiVM.buttonR08.visible = true;
			GuiVM.buttonR09.visible = true;
			GuiVM.buttonR10.visible = true;
			GuiVM.buttonR11.visible = true;
			GuiVM.buttonR12.visible = true;
			
			GuiVM.buttonR13.visible = true;
			GuiVM.buttonR14.visible = true;
			GuiVM.buttonR15.visible = true;
			GuiVM.buttonR16.visible = true;
			GuiVM.buttonR17.visible = true;
			GuiVM.buttonR18.visible = true;
		}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		this.fontRenderer.drawString(References.localNameVC("vc.main.selected") + " :", 41, -10, 11111111);
	}
}
