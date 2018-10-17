package com.vies.viesmachines.network.server.airship.customize.engine.sub;

import com.vies.viesmachines.common.entity.airships.EntityAirshipBaseVC;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplaySupporterHeadDefault extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplaySupporterHeadDefault> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplaySupporterHeadDefault message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplaySupporterHeadDefault message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		
		airship.engineDisplayTypeVisual = 0;
		airship.engineDisplayItemstackVisual = 0;
		airship.engineDisplayItemstackMetaVisual = 0;
		airship.engineDisplayHeadVisual = 0;
		airship.engineDisplaySupporterHeadVisual = 0;
		airship.engineDisplayHolidayVisual = 0;
		
	}
}
