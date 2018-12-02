package com.vies.viesmachines.network.server.machine.gui.customize.holiday;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.network.GuiHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween extends MessageBase<MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayHalloween message, EntityPlayer player) 
	{
		player.openGui(ViesMachines.instance, GuiHandler.GUI_MACHINE_MENU_CUSTOMIZE_SECONDARY_SKIN_TEXTURE_HOLIDAY_HALLOWEEN, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
