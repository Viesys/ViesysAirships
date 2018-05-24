package com.viesys.viesysmachines.network.server.airship.customize.frame.sub;

import com.viesys.viesysmachines.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier1Pg2;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameTier1Pg2 extends MessageBase<MessageHelperGuiCustomizeMenuFrameTier1Pg2> {
	
	private int metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiCustomizeMenuFrameTier1Pg2.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameTier1Pg2 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameTier1Pg2 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.frameSkinTexture = message.metaFrame;
	}
}
