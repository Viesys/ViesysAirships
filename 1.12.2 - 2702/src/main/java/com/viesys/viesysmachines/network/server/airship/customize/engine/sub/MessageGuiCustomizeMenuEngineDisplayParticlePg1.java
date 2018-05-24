package com.viesys.viesysmachines.network.server.airship.customize.engine.sub;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.network.GuiHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

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
		player.openGui(ViesysMachines.instance, GuiHandler.GUI_APPEARANCE_MENU_ENGINE_PARTICLE, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}