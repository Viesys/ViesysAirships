package com.viesys.viesysmachines.network.server.airship.redstone;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.network.GuiHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiRedstoneMenu extends MessageBase<MessageGuiRedstoneMenu> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiRedstoneMenu message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiRedstoneMenu message, EntityPlayer player) 
	{
		player.openGui(ViesysMachines.instance, GuiHandler.GUI_CUSTOMIZE_MENU_REDSTONE, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
