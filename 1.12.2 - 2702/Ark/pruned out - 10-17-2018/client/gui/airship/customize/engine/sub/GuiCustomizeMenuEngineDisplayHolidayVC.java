package com.vies.viesmachines.client.gui.airship.customize.engine.sub;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VC;
import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;
import com.vies.viesmachines.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.airship.customize.engine.MessageGuiCustomizeMenuEngineMain;
import com.vies.viesmachines.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplaySymbol;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuEngineDisplayHolidayVC extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_3.png");
	
	public int startPlaceLeft = 12;
	public int startPlaceTop = 22;
	
	public GuiCustomizeMenuEngineDisplayHolidayVC(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
		
		this.metaInfo = this.airship.engineDisplayTypeVisual;
		this.itemstackInfo = this.airship.engineDisplayItemstackVisual;
		this.itemstackMetaInfo = this.airship.engineDisplayItemstackMetaVisual;
		this.headInfo = this.airship.engineDisplayHeadVisual;
		this.supporterHeadInfo = this.airship.engineDisplaySupporterHeadVisual;
		this.holidayInfo = this.airship.engineDisplayHolidayVisual;
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
    	
		GuiVM.button502 = new GuiButtonGeneral1VC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.default"), 1);
    	GuiVM.button503 = new GuiButtonGeneral1VC(503, this.guiLeft + 126, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"), 3);
    	GuiVM.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	GuiVM.button501 = new GuiButtonGeneral1VC(501, this.guiLeft + 110, this.guiTop + 125, 48, 14, References.localNameVC("vc.button.apply"), 1);
    	
    	//Heads Pg1
    	GuiVM.button00 = new GuiButtonGeneral1VC( 0, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.10"), 0);
		GuiVM.button01 = new GuiButtonGeneral1VC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.11"), 0);
		GuiVM.button02 = new GuiButtonGeneral1VC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.12"), 0);
		GuiVM.button03 = new GuiButtonGeneral1VC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.13"), 0);
		GuiVM.button04 = new GuiButtonGeneral1VC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.14"), 0);
		GuiVM.button05 = new GuiButtonGeneral1VC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.15"), 0);
		
		GuiVM.button06 = new GuiButtonGeneral1VC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.16"), 0);
		GuiVM.button07 = new GuiButtonGeneral1VC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.17"), 0);
		GuiVM.button08 = new GuiButtonGeneral1VC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.18"), 0);
		GuiVM.button09 = new GuiButtonGeneral1VC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.19"), 0);
		GuiVM.button10 = new GuiButtonGeneral1VC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.20"), 0);
		GuiVM.button11 = new GuiButtonGeneral1VC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.21"), 0);
		
		//--------------------------------------
		
		//Symbols Pg2
		GuiVM.button22 = new GuiButtonGeneral1VC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.22"), 0);
		GuiVM.button23 = new GuiButtonGeneral1VC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.23"), 0);
		GuiVM.button24 = new GuiButtonGeneral1VC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.24"), 0);
		GuiVM.button25 = new GuiButtonGeneral1VC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.25"), 0);
		GuiVM.button26 = new GuiButtonGeneral1VC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.26"), 0);
		GuiVM.button27 = new GuiButtonGeneral1VC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.27"), 0);
		
		GuiVM.button28 = new GuiButtonGeneral1VC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.28"), 0);
		GuiVM.button29 = new GuiButtonGeneral1VC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.29"), 0);
		GuiVM.button30 = new GuiButtonGeneral1VC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.30"), 0);
		GuiVM.button31 = new GuiButtonGeneral1VC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.31"), 0);
		GuiVM.button32 = new GuiButtonGeneral1VC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.32"), 0);
		GuiVM.button33 = new GuiButtonGeneral1VC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.33"), 0);
		
		//--------------------------------------
		
		//Symbols Pg3
		GuiVM.button34 = new GuiButtonGeneral1VC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.34"), 0);
		GuiVM.button35 = new GuiButtonGeneral1VC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.35"), 0);
		GuiVM.button36 = new GuiButtonGeneral1VC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.36"), 0);
		GuiVM.button37 = new GuiButtonGeneral1VC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.37"), 0);
		GuiVM.button38 = new GuiButtonGeneral1VC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.38"), 0);
		GuiVM.button39 = new GuiButtonGeneral1VC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.39"), 0);
		
		GuiVM.button40 = new GuiButtonGeneral1VC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.40"), 0);
		GuiVM.button41 = new GuiButtonGeneral1VC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.41"), 0);
		GuiVM.button42 = new GuiButtonGeneral1VC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.42"), 0);
		GuiVM.button43 = new GuiButtonGeneral1VC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.43"), 0);
		GuiVM.button44 = new GuiButtonGeneral1VC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.44"), 0);
		GuiVM.button45 = new GuiButtonGeneral1VC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.45"), 0);
		
		//--------------------------------------
		
		//Symbols Pg4
		GuiVM.button46 = new GuiButtonGeneral1VC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.46"), 0);
		GuiVM.button47 = new GuiButtonGeneral1VC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.47"), 0);
		
		GuiVM.button48 = new GuiButtonGeneral1VC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.48"), 0);
		GuiVM.button49 = new GuiButtonGeneral1VC(49, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.49"), 0);
		GuiVM.button50 = new GuiButtonGeneral1VC(50, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.50"), 0);
		GuiVM.button51 = new GuiButtonGeneral1VC(51, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.51"), 0);
		GuiVM.button52 = new GuiButtonGeneral1VC(52, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.52"), 0);
		GuiVM.button53 = new GuiButtonGeneral1VC(53, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.53"), 0);
		
		//--------------------------------------
		
		//Holiday Symbols
		//Easter
		GuiVM.buttonEDH01 = new GuiButtonGeneral1VC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.1"), 0);
		GuiVM.buttonEDH02 = new GuiButtonGeneral1VC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.2"), 0);
		GuiVM.buttonEDH03 = new GuiButtonGeneral1VC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.3"), 0);
		GuiVM.buttonEDH04 = new GuiButtonGeneral1VC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.4"), 0);
		GuiVM.buttonEDH05 = new GuiButtonGeneral1VC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.5"), 0);
		GuiVM.buttonEDH06 = new GuiButtonGeneral1VC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.6"), 0);
		GuiVM.buttonEDH07 = new GuiButtonGeneral1VC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.7"), 0);
		GuiVM.buttonEDH08 = new GuiButtonGeneral1VC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.8"), 0);
		GuiVM.buttonEDH09 = new GuiButtonGeneral1VC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.9"), 0);
		GuiVM.buttonEDH10 = new GuiButtonGeneral1VC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.10"), 0);
		GuiVM.buttonEDH11 = new GuiButtonGeneral1VC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.11"), 0);
		GuiVM.buttonEDH12 = new GuiButtonGeneral1VC(12, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.12"), 0);
		//4th of July
		GuiVM.buttonEDH13 = new GuiButtonGeneral1VC(13, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.13"), 0);
		GuiVM.buttonEDH14 = new GuiButtonGeneral1VC(14, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.14"), 0);
		GuiVM.buttonEDH15 = new GuiButtonGeneral1VC(15, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.15"), 0);
		GuiVM.buttonEDH16 = new GuiButtonGeneral1VC(16, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.16"), 0);
		GuiVM.buttonEDH17 = new GuiButtonGeneral1VC(17, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.17"), 0);
		GuiVM.buttonEDH18 = new GuiButtonGeneral1VC(18, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.18"), 0);
		GuiVM.buttonEDH19 = new GuiButtonGeneral1VC(19, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.19"), 0);
		GuiVM.buttonEDH20 = new GuiButtonGeneral1VC(20, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.20"), 0);
		GuiVM.buttonEDH21 = new GuiButtonGeneral1VC(21, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.21"), 0);
		GuiVM.buttonEDH22 = new GuiButtonGeneral1VC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.22"), 0);
		GuiVM.buttonEDH23 = new GuiButtonGeneral1VC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.23"), 0);
		GuiVM.buttonEDH24 = new GuiButtonGeneral1VC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.24"), 0);
		//Halloween
		GuiVM.buttonEDH25 = new GuiButtonGeneral1VC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.25"), 0);
		GuiVM.buttonEDH26 = new GuiButtonGeneral1VC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.26"), 0);
		GuiVM.buttonEDH27 = new GuiButtonGeneral1VC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.27"), 0);
		GuiVM.buttonEDH28 = new GuiButtonGeneral1VC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.28"), 0);
		GuiVM.buttonEDH29 = new GuiButtonGeneral1VC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.29"), 0);
		GuiVM.buttonEDH30 = new GuiButtonGeneral1VC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.30"), 0);
		GuiVM.buttonEDH31 = new GuiButtonGeneral1VC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.31"), 0);
		GuiVM.buttonEDH32 = new GuiButtonGeneral1VC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.32"), 0);
		GuiVM.buttonEDH33 = new GuiButtonGeneral1VC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.33"), 0);
		GuiVM.buttonEDH34 = new GuiButtonGeneral1VC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.34"), 0);
		GuiVM.buttonEDH35 = new GuiButtonGeneral1VC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.35"), 0);
		GuiVM.buttonEDH36 = new GuiButtonGeneral1VC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.36"), 0);
		//Christmas
		GuiVM.buttonEDH37 = new GuiButtonGeneral1VC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.37"), 0);
		GuiVM.buttonEDH38 = new GuiButtonGeneral1VC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.38"), 0);
		GuiVM.buttonEDH39 = new GuiButtonGeneral1VC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.39"), 0);
		GuiVM.buttonEDH40 = new GuiButtonGeneral1VC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.40"), 0);
		GuiVM.buttonEDH41 = new GuiButtonGeneral1VC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.41"), 0);
		GuiVM.buttonEDH42 = new GuiButtonGeneral1VC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.42"), 0);
		GuiVM.buttonEDH43 = new GuiButtonGeneral1VC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.43"), 0);
		GuiVM.buttonEDH44 = new GuiButtonGeneral1VC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.44"), 0);
		GuiVM.buttonEDH45 = new GuiButtonGeneral1VC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.45"), 0);
		GuiVM.buttonEDH46 = new GuiButtonGeneral1VC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.46"), 0);
		GuiVM.buttonEDH47 = new GuiButtonGeneral1VC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.47"), 0);
		GuiVM.buttonEDH48 = new GuiButtonGeneral1VC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.48"), 0);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		if (parButton.id == 502)
	    {
			//this.metaInfo = 0;
			//NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuBalloonTier());
	    }
		if (parButton.id == 503)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuBalloonTier1Pg2());
	    }
		if (parButton.id == 504)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuBalloonTier1Pg1());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineMain());
	    }
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplaySymbol());
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
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
		if(this.airship.storedRedstone >= CostsVM.BALLOON_PATTERN_TEXTURE_COST)
		{
			GuiVM.button501.enabled = true;
		}
		else
		{
			GuiVM.button501.enabled = false;
		}
		
		this.drawRotatingItemStack(new ItemStack(ItemsVM.ITEM_DISPLAY_SYMBOL, 1, metaInfo), this.guiLeft + 134, this.guiTop + 70);
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134, this.guiTop + 105.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.cost"), 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.WHITE;
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25 + 46, this.guiTop + 77+34, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(CostsVM.ENGINE_DISPLAY_SYMBOL_COST), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.fontRenderer.drawString(References.localNameVC("vc.main.preview"), 115, 17, Color.BLACK.getRGB());
		
		//Logic for mouse-over Cost tooltip
		if(mouseX >= this.guiLeft + 12 && mouseX <= this.guiLeft + 87
		&& mouseY >= this.guiTop + 22 && mouseY <= this.guiTop + 189)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs " + CostsVM.FRAME_SKIN_TEXTURE_COST + " Redstone"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Reset tooltip
		if(mouseX >= this.guiLeft + 110 && mouseX <= this.guiLeft + 157
		&& mouseY >= this.guiTop + 143 && mouseY <= this.guiTop + 156)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Default skin, costs nothing!"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 38, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
    }
}
