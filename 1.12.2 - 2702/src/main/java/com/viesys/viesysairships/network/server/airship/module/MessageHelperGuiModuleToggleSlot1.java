package com.viesys.viesysairships.network.server.airship.module;

import com.viesys.viesysairships.api.CostsVC;
import com.viesys.viesysairships.client.gui.airship.module.GuiModuleMenu;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiModuleToggleSlot1 extends MessageBase<MessageHelperGuiModuleToggleSlot1> {
	
	private int metaToggleModule;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaToggleModule = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiModuleMenu.toggleModule);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiModuleToggleSlot1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiModuleToggleSlot1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.getStoredRedstone() >= CostsVC.MODULE_CHANGE_COST
		&& message.metaToggleModule != 0)	
		{
			airship.moduleActiveSlot1 = message.metaToggleModule;
			airship.storedRedstone = airship.storedRedstone - CostsVC.MODULE_CHANGE_COST;
    	}
		
		if(message.metaToggleModule == 0)	
		{
			airship.moduleActiveSlot1 = message.metaToggleModule;
    	}
		
		airship.bombArmedToggle = false;
	}
}
