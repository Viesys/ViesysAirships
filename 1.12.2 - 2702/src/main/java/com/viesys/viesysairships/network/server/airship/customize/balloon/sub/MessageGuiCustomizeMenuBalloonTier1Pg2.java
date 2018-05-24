package com.viesys.viesysairships.network.server.airship.customize.balloon.sub;

import com.viesys.viesysairships.ViesysAirships;
import com.viesys.viesysairships.network.GuiHandler;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuBalloonTier1Pg2 extends MessageBase<MessageGuiCustomizeMenuBalloonTier1Pg2> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuBalloonTier1Pg2 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuBalloonTier1Pg2 message, EntityPlayer player) 
	{
		player.openGui(ViesysAirships.instance, GuiHandler.GUI_APPEARANCE_MENU_BALLOON_TIER1_PG2, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}