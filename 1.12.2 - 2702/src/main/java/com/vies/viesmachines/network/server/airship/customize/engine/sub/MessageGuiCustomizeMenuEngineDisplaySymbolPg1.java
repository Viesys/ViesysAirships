package com.vies.viesmachines.network.server.airship.customize.engine.sub;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.network.GuiHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuEngineDisplaySymbolPg1 extends MessageBase<MessageGuiCustomizeMenuEngineDisplaySymbolPg1> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuEngineDisplaySymbolPg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuEngineDisplaySymbolPg1 message, EntityPlayer player) 
	{
		player.openGui(ViesMachines.instance, GuiHandler.GUI_APPEARANCE_MENU_ENGINE_SYMBOLS_PG1, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
