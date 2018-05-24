package com.viesys.viesysairships.network.server.airship.customize.frame;

import com.viesys.viesysairships.ViesysAirships;
import com.viesys.viesysairships.network.GuiHandler;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuFrameColor extends MessageBase<MessageGuiCustomizeMenuFrameColor> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuFrameColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuFrameColor message, EntityPlayer player) 
	{
		player.openGui(ViesysAirships.instance, GuiHandler.GUI_APPEARANCE_MENU_FRAME_COLOR, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
