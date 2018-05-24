package com.viesys.viesysairships.network.server.airship.customize.engine.sub;

import com.viesys.viesysairships.api.CostsVC;
import com.viesys.viesysairships.client.gui.GuiContainerVC;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplayHoliday extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplayHoliday> {
	
	private int metaDisplayItemstack;
	private int metaDisplayItemstackMeta;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaDisplayItemstack = buf.readInt();
		metaDisplayItemstackMeta = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.itemstackInfo);
		buf.writeInt(GuiContainerVC.itemstackMetaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplayHoliday message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplayHoliday message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.engineDisplayTypeVisual = 0;
		airship.engineDisplayItemstackVisual = 0;
		airship.engineDisplayItemstackMetaVisual = 0;
		airship.engineDisplayHeadVisual = 0;
		airship.engineDisplaySupporterHeadVisual = 0;
		airship.engineDisplayHolidayVisual = 0;
		
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		//&& message.metaDisplayItemstack != 0
		//&& message.metaDisplayItemstack != airship.engineDisplayItemstackVisual
		//&& message.metaDisplayItemstackMeta != airship.engineDisplayItemstackMetaVisual
				)
		{
			airship.engineDisplayTypeVisual = 1;
			airship.engineDisplayItemstackVisual = message.metaDisplayItemstack;
			airship.engineDisplayItemstackMetaVisual = message.metaDisplayItemstackMeta;
			airship.storedRedstone = airship.storedRedstone - CostsVC.ENGINE_DISPLAY_SYMBOL_COST;
		}
	}
}