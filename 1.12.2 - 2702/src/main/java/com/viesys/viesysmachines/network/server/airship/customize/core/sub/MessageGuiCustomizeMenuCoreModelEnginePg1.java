package com.viesys.viesysmachines.network.server.airship.customize.core.sub;

import com.viesys.viesysmachines.ViesysMachines;
import com.viesys.viesysmachines.network.GuiHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuCoreModelEnginePg1 extends MessageBase<MessageGuiCustomizeMenuCoreModelEnginePg1> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuCoreModelEnginePg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuCoreModelEnginePg1 message, EntityPlayer player) 
	{
		player.openGui(ViesysMachines.instance, GuiHandler.GUI_APPEARANCE_MENU_CORE_MODEL_ENGINE_PG1, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
