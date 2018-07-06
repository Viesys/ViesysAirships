package com.viesys.viesysmachines.network.server.airship.main;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.network.GuiHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageAirshipGuiMainMenu extends MessageBase<MessageAirshipGuiMainMenu> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageAirshipGuiMainMenu message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageAirshipGuiMainMenu message, EntityPlayer player) 
	{
		player.openGui(ViesysMachines.instance, GuiHandler.GUI_AIRSHIP_MAIN_MENU, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
