package com.viesys.viesysmachines.network.server.airship.customize.frame;

import com.viesys.viesysmachines.api.CostsVC;
import com.viesys.viesysmachines.client.gui.GuiContainerVC;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameTransparent extends MessageBase<MessageHelperGuiCustomizeMenuFrameTransparent> {
	
	private boolean metaFrameTransparent;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrameTransparent = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(GuiContainerVC.frameTransparentInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameTransparent message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameTransparent message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.frameSkinTransparent)
		{
			airship.frameSkinTransparent = message.metaFrameTransparent;
		}
		else
		{
			if(airship.getStoredRedstone() >= CostsVC.FRAME_SKIN_TRANSPARENCY_COST)
			{
				airship.frameSkinTransparent = message.metaFrameTransparent;
				
				airship.storedRedstone = airship.storedRedstone - CostsVC.FRAME_SKIN_TRANSPARENCY_COST;
			}
		}
	}
}
