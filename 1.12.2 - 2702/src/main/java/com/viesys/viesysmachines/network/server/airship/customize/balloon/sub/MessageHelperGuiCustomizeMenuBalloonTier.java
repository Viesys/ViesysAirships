package com.viesys.viesysmachines.network.server.airship.customize.balloon.sub;

import com.viesys.viesysmachines.api.CostsVC;
import com.viesys.viesysmachines.client.gui.GuiContainerVC;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuBalloonTier extends MessageBase<MessageHelperGuiCustomizeMenuBalloonTier> {
	
	private int metaBalloon;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloon = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaBalloonInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuBalloonTier message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuBalloonTier message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		if(airship.getStoredRedstone() >= CostsVC.BALLOON_PATTERN_TEXTURE_COST
		&& message.metaBalloon != 0
		&& message.metaBalloon != airship.balloonPatternTexture)
		{
			airship.balloonPatternTexture = message.metaBalloon;
			airship.storedRedstone = airship.storedRedstone - CostsVC.BALLOON_PATTERN_TEXTURE_COST;
		}
		
		if(message.metaBalloon == 0)
		{
			airship.balloonPatternTexture = message.metaBalloon;
		}
	}
}
