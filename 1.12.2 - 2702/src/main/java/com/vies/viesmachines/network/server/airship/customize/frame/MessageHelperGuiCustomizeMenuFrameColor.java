package com.vies.viesmachines.network.server.airship.customize.frame;

import com.vies.viesmachines.api.CostsVC;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.common.entity.airships.EntityAirshipBaseVC;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameColor extends MessageBase<MessageHelperGuiCustomizeMenuFrameColor> {
	
	private int metaFrameRed;
	private int metaFrameGreen;
	private int metaFrameBlue;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrameRed = buf.readInt();
		metaFrameGreen = buf.readInt();
		metaFrameBlue = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.textRedNumber);
		buf.writeInt(GuiContainerVC.textGreenNumber);
		buf.writeInt(GuiContainerVC.textBlueNumber);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameColor message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.frameSkinColorRed == message.metaFrameRed
		&& airship.frameSkinColorGreen == message.metaFrameGreen
		&& airship.frameSkinColorBlue == message.metaFrameBlue)
		{
			
		}
		else
		{
			if(airship.getStoredRedstone() >= CostsVC.FRAME_SKIN_COLOR_COST)
			{
				airship.frameSkinColor = true;
				airship.frameSkinColorRed = message.metaFrameRed;
				airship.frameSkinColorGreen = message.metaFrameGreen;
				airship.frameSkinColorBlue = message.metaFrameBlue;
				
				airship.storedRedstone = airship.storedRedstone - CostsVC.FRAME_SKIN_COLOR_COST;
			}
		}
	}
}
