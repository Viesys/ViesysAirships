package com.vies.viesmachines.network.server.machine.song;

import com.vies.viesmachines.client.gui.machines.GuiMachineMenuMainSelectMusic;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageGuiMusicSet extends MessageBase<MessageGuiMusicSet> implements IMessage {
	
	public static int setSongId;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.setSongId = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuMainSelectMusic.setSong);
	}
	
	@Override
	public void handleClientSide(MessageGuiMusicSet message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiMusicSet message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.getRidingEntity();
		
		machine.selectedSong = message.setSongId;
	}
}
