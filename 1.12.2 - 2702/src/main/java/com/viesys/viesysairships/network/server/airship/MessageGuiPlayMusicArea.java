package com.viesys.viesysairships.network.server.airship;

import com.viesys.viesysairships.api.EnumsVC;
import com.viesys.viesysairships.client.sound.JukeboxMovingSoundVC;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageGuiPlayMusicArea extends MessageBase<MessageGuiPlayMusicArea> {
	
	private int airshipId;
	private EntityAirshipBaseVC airship;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		airshipId = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(MessageGuiPlayMusic.airshipId);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(MessageGuiPlayMusicArea message, EntityPlayer player) 
	{
		message.airship = (EntityAirshipBaseVC) Minecraft.getMinecraft().world.getEntityByID(message.airshipId);
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		soundHandler.stopSounds();
		
		soundHandler.playSound(new JukeboxMovingSoundVC(message.airship, EnumsVC.AirshipSong.byId(message.airship.metaJukeboxSelectedSong).getSong()));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleServerSide(MessageGuiPlayMusicArea message, EntityPlayer player) 
	{
		
	}
}
