package com.viesys.viesysmachines.network.server.airship.customize.frame;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.network.GuiHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuFrameMain extends MessageBase<MessageGuiCustomizeMenuFrameMain> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuFrameMain message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuFrameMain message, EntityPlayer player) 
	{
		player.openGui(ViesysMachines.instance, GuiHandler.GUI_APPEARANCE_MENU_FRAME_MAIN, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
