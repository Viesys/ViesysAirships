package com.viesys.viesysmachines.network.server.airship.customize.balloon.sub;

import com.viesys.viesysmachines.client.gui.airship.customize.balloon.sub.GuiCustomizeMenuBalloonTier1Pg1;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuBalloonTier1Pg1 extends MessageBase<MessageHelperGuiCustomizeMenuBalloonTier1Pg1> {
	
	private int metaBalloon;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloon = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiCustomizeMenuBalloonTier1Pg1.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuBalloonTier1Pg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuBalloonTier1Pg1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.balloonPatternTexture = message.metaBalloon;
	}
}
