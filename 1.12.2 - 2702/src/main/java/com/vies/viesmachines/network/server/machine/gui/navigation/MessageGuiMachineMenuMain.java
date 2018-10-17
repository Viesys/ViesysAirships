package com.vies.viesmachines.network.server.machine.gui.navigation;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.network.GuiHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiMachineMenuMain extends MessageBase<MessageGuiMachineMenuMain> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiMachineMenuMain message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiMachineMenuMain message, EntityPlayer player) 
	{
		player.openGui(ViesMachines.instance, GuiHandler.GUI_MACHINE_MENU_MAIN, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
