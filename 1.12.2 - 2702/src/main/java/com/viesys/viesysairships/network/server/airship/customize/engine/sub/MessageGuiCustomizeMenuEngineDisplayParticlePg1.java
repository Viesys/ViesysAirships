package com.viesys.viesysairships.network.server.airship.customize.engine.sub;

import com.viesys.viesysairships.ViesysAirships;
import com.viesys.viesysairships.network.GuiHandler;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuEngineDisplayParticlePg1 extends MessageBase<MessageGuiCustomizeMenuEngineDisplayParticlePg1> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuEngineDisplayParticlePg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuEngineDisplayParticlePg1 message, EntityPlayer player) 
	{
		player.openGui(ViesysAirships.instance, GuiHandler.GUI_APPEARANCE_MENU_ENGINE_PARTICLE, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
