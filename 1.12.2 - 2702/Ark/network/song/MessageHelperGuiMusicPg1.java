package com.viesys.viesysmachines.network.server.song;

import com.viesys.viesysmachines.client.gui.airship.music.GuiAirshipMusicPg1;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMusicPg1 extends MessageBase<MessageHelperGuiMusicPg1> {
	
	private int metaSong;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaSong = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiAirshipMusicPg1.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMusicPg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMusicPg1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaJukeboxSelectedSong = message.metaSong;
	}
}
