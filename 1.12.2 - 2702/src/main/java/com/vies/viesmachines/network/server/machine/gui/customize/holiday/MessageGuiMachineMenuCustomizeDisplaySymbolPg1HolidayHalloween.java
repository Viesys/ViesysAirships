package com.vies.viesmachines.network.server.machine.gui.customize.holiday;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.network.GuiHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween extends MessageBase<MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayHalloween message, EntityPlayer player) 
	{
		player.openGui(ViesMachines.instance, GuiHandler.GUI_MACHINE_MENU_CUSTOMIZE_DISPLAY_SYMBOL_PG1_HOLIDAY_HALLOWEEN, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
