package com.vies.viesmachines.network.server.airship.customize.engine;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.network.GuiHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuEngineMain extends MessageBase<MessageGuiCustomizeMenuEngineMain> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuEngineMain message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuEngineMain message, EntityPlayer player) 
	{
		player.openGui(ViesMachines.instance, GuiHandler.GUI_APPEARANCE_MENU_ENGINE_MAIN, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}