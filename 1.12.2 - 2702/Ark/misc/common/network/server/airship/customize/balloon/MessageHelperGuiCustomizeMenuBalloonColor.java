package com.viesys.viesysmachines.network.server.airship.customize.balloon;

import com.viesys.viesysmachines.api.CostsVC;
import com.viesys.viesysmachines.client.gui.airship.customize.balloon.GuiCustomizeMenuBalloonColor;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuBalloonColor extends MessageBase<MessageHelperGuiCustomizeMenuBalloonColor> {
	
	private int metaBalloonRed;
	private int metaBalloonGreen;
	private int metaBalloonBlue;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloonRed = buf.readInt();
		metaBalloonGreen = buf.readInt();
		metaBalloonBlue = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiCustomizeMenuBalloonColor.textRedNumber);
		buf.writeInt(GuiCustomizeMenuBalloonColor.textGreenNumber);
		buf.writeInt(GuiCustomizeMenuBalloonColor.textBlueNumber);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuBalloonColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuBalloonColor message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.balloonPatternColorRed == message.metaBalloonRed
		&& airship.balloonPatternColorGreen == message.metaBalloonGreen
		&& airship.balloonPatternColorBlue == message.metaBalloonBlue)
		{
			
		}
		else
		{
			if(airship.getStoredRedstone() >= CostsVC.BALLOON_PATTERN_COLOR_COST)
			{
				airship.balloonPatternColor = true;
				airship.balloonPatternColorRed = message.metaBalloonRed;
				airship.balloonPatternColorGreen = message.metaBalloonGreen;
				airship.balloonPatternColorBlue = message.metaBalloonBlue;
				
				airship.storedRedstone = airship.storedRedstone - CostsVC.BALLOON_PATTERN_COLOR_COST;
			}
		}
	}
}
