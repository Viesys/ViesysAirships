package com.viesys.viesysmachines.network.server.airship.upgrade;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.network.GuiHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiUpgradeMenu extends MessageBase<MessageGuiUpgradeMenu> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiUpgradeMenu message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiUpgradeMenu message, EntityPlayer player) 
	{
		player.openGui(ViesysMachines.instance, GuiHandler.GUI_UPGRADE_MENU, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
