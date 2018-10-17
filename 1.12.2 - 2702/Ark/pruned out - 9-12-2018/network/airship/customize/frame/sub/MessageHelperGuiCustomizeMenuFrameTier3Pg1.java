package com.vies.viesmachines.network.server.airship.customize.frame.sub;

import com.vies.viesmachines.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier3Pg1;
import com.vies.viesmachines.common.entity.airships.EntityAirshipBaseVC;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameTier3Pg1 extends MessageBase<MessageHelperGuiCustomizeMenuFrameTier3Pg1> {
	
	private int metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiCustomizeMenuFrameTier3Pg1.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameTier3Pg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameTier3Pg1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.frameSkinTexture = message.metaFrame;
	}
}
