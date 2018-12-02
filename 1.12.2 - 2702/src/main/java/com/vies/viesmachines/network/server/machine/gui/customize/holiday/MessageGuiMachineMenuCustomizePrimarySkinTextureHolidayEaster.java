package com.vies.viesmachines.network.server.machine.gui.customize.holiday;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.network.GuiHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayEaster extends MessageBase<MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayEaster> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayEaster message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayEaster message, EntityPlayer player) 
	{
		player.openGui(ViesMachines.instance, GuiHandler.GUI_MACHINE_MENU_CUSTOMIZE_PRIMARY_SKIN_TEXTURE_HOLIDAY_EASTER, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
