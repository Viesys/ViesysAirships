package com.viesys.viesysairships.network.server.airship.customize.frame.sub;

import com.viesys.viesysairships.ViesysAirships;
import com.viesys.viesysairships.network.GuiHandler;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuFrameTier1Pg1 extends MessageBase<MessageGuiCustomizeMenuFrameTier1Pg1> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuFrameTier1Pg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuFrameTier1Pg1 message, EntityPlayer player) 
	{
		player.openGui(ViesysAirships.instance, GuiHandler.GUI_APPEARANCE_MENU_FRAME_TIER1_PG1, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
