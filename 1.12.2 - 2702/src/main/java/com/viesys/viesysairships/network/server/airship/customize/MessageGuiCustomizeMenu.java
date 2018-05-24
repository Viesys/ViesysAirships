package com.viesys.viesysairships.network.server.airship.customize;

import com.viesys.viesysairships.ViesysAirships;
import com.viesys.viesysairships.network.GuiHandler;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenu extends MessageBase<MessageGuiCustomizeMenu> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenu message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenu message, EntityPlayer player) 
	{
		player.openGui(ViesysAirships.instance, GuiHandler.GUI_CUSTOMIZE_MENU, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
