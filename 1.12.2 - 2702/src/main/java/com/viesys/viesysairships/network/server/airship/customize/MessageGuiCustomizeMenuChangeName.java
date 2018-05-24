package com.viesys.viesysairships.network.server.airship.customize;

import com.viesys.viesysairships.ViesysAirships;
import com.viesys.viesysairships.network.GuiHandler;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuChangeName extends MessageBase<MessageGuiCustomizeMenuChangeName> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuChangeName message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuChangeName message, EntityPlayer player) 
	{
		player.openGui(ViesysAirships.instance, GuiHandler.GUI_CUSTOMIZE_MENU_CHANGE_NAME, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
