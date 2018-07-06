package com.vies.viesmachines.network.server.airship.customize.balloon;

import com.vies.viesmachines.api.CostsVC;
import com.vies.viesmachines.client.gui.airship.customize.balloon.GuiCustomizeMenuBalloonMain;
import com.vies.viesmachines.common.entity.airships.EntityAirshipBaseVC;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuBalloonTransparent extends MessageBase<MessageHelperGuiCustomizeMenuBalloonTransparent> {
	
	private boolean metaBalloonTransparent;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloonTransparent = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(GuiCustomizeMenuBalloonMain.balloonTransparentInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuBalloonTransparent message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuBalloonTransparent message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.balloonPatternTransparent)
		{
			airship.balloonPatternTransparent = message.metaBalloonTransparent;
		}
		else
		{
			if(airship.getStoredRedstone() >= CostsVC.BALLOON_PATTERN_TRANSPARENCY_COST)
			{
				airship.balloonPatternTransparent = message.metaBalloonTransparent;
				
				airship.storedRedstone = airship.storedRedstone - CostsVC.BALLOON_PATTERN_TRANSPARENCY_COST;
			}
		}
	}
}
