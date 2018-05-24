package com.viesys.viesysairships.network.server.airship.customize.core.sub;

import com.viesys.viesysairships.api.CostsVC;
import com.viesys.viesysairships.client.gui.GuiContainerVC;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuCoreModelFrame extends MessageBase<MessageHelperGuiCustomizeMenuCoreModelFrame> {
	
	private int metaCore;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaCore = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuCoreModelFrame message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuCoreModelFrame message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.getStoredRedstone() >= CostsVC.CORE_MODEL_FRAME_COST
		&& message.metaCore != 0
		&& message.metaCore != airship.coreModelVisualFrame)
		{
			airship.coreModelVisualFrame = message.metaCore;
			airship.storedRedstone = airship.storedRedstone - CostsVC.CORE_MODEL_FRAME_COST;
		}
		
		if(message.metaCore == 0)
		{
			airship.coreModelVisualFrame = message.metaCore;
		}
	}
}