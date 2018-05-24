package com.viesys.viesysmachines.network.server.airship.main;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.network.GuiHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiMainMenu extends MessageBase<MessageGuiMainMenu> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiMainMenu message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiMainMenu message, EntityPlayer player) 
	{
		player.openGui(ViesysMachines.instance, GuiHandler.GUI_MAIN_MENU, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
