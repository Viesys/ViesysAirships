package com.viesys.viesysairships.network.server.airship.customize.frame.sub;

import com.viesys.viesysairships.api.CostsVC;
import com.viesys.viesysairships.client.gui.GuiContainerVC;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameTier extends MessageBase<MessageHelperGuiCustomizeMenuFrameTier> {
	
	private int metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaFrameInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameTier message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameTier message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		if(airship.getStoredRedstone() >= CostsVC.FRAME_SKIN_TEXTURE_COST
		&& message.metaFrame != 0
		&& message.metaFrame != airship.frameSkinTexture)
		{
			airship.frameSkinTexture = message.metaFrame;
			airship.storedRedstone = airship.storedRedstone - CostsVC.FRAME_SKIN_TEXTURE_COST;
		}
		
		if(message.metaFrame == 0)
		{
			airship.frameSkinTexture = message.metaFrame;
		}
	}
}
