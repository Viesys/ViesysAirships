package com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplaySymbol extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplaySymbol> {
	
	private int metaDisplayID;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaDisplayID = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplaySymbol message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplaySymbol message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.getRidingEntity();
		//LogHelper.info(message.metaDisplayID);
		
		//LogHelper.info("TTT - " + message.metaDisplayID);
		if (player.isCreative())
		{
			machine.setVisualEngineDisplayType(message.metaDisplayID);
			
			machine.setVisualEngineDisplayItemstack(0);
			machine.setVisualEngineDisplayItemstackMeta(0);
			machine.setVisualEngineDisplayHead(0);
			machine.setVisualEngineDisplaySupporterHead(0);
			machine.setVisualEngineDisplayHoliday(0);
		}
		else if(message.metaDisplayID == 0)
		{
			machine.setVisualEngineDisplayType(0);
			
			machine.setVisualEngineDisplayItemstack(0);
			machine.setVisualEngineDisplayItemstackMeta(0);
			machine.setVisualEngineDisplayHead(0);
			machine.setVisualEngineDisplaySupporterHead(0);
			machine.setVisualEngineDisplayHoliday(0);
		}
		else if (machine.getEnergy() >= CostsVM.COST_ENGINE_DISPLAY_SYMBOL
		&& message.metaDisplayID != machine.getVisualEngineDisplayType())
		{
			machine.setVisualEngineDisplayType(message.metaDisplayID);
			
			machine.setVisualEngineDisplayItemstack(0);
			machine.setVisualEngineDisplayItemstackMeta(0);
			machine.setVisualEngineDisplayHead(0);
			machine.setVisualEngineDisplaySupporterHead(0);
			machine.setVisualEngineDisplayHoliday(0);
			
			machine.setEnergy(machine.getEnergy() - CostsVM.COST_ENGINE_DISPLAY_SYMBOL);
		}
		
		
		
		/*
		airship..engineDisplayTypeVisual = 0;
		airship.engineDisplayItemstackVisual = 0;
		airship.engineDisplayItemstackMetaVisual = 0;
		airship.engineDisplayHeadVisual = 0;
		airship.engineDisplaySupporterHeadVisual = 0;
		airship.engineDisplayHolidayVisual = 0;
		
		/**
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		&& message.metaDisplayID != 0
		&& message.metaDisplayID != airship.engineDisplayIDVisual)
		{
			airship.engineDisplayTypeVisual = 1;
			airship.engineDisplayIDVisual = message.metaDisplayID;
			airship.storedRedstone = airship.storedRedstone - CostsVC.ENGINE_DISPLAY_SYMBOL_COST;
		}
		
		if(message.metaDisplayID == 0)
		{
			airship.engineDisplayTypeVisual = 0;
			airship.engineDisplayIDVisual = 0;
		}
		*/
		
		/*
		
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		&& message.metaDisplayID != 0
		&& message.metaDisplayID != airship.engineDisplayTypeVisual)
		{
			airship.engineDisplayTypeVisual = message.metaDisplayID;
			airship.storedRedstone = airship.storedRedstone - CostsVC.ENGINE_DISPLAY_SYMBOL_COST;
		}
		
		if(message.metaDisplayID == 0)
		{
			airship.engineDisplayTypeVisual = 0;
		}
		*/
	}
}
