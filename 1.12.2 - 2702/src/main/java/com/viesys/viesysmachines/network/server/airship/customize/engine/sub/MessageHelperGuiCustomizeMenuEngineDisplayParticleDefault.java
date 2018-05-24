package com.viesys.viesysmachines.network.server.airship.customize.engine.sub;

import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		
		airship.engineParticleVisual = 0;
	}
}
