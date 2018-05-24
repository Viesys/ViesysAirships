package com.viesys.viesysmachines.network.server.airship.customize.balloon;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.network.GuiHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuBalloonColor extends MessageBase<MessageGuiCustomizeMenuBalloonColor> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuBalloonColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuBalloonColor message, EntityPlayer player) 
	{
		player.openGui(ViesysMachines.instance, GuiHandler.GUI_APPEARANCE_MENU_BALLOON_COLOR, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
