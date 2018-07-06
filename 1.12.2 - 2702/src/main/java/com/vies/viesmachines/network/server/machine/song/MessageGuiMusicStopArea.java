package com.vies.viesmachines.network.server.machine.song;

import com.vies.viesmachines.client.sound.JukeboxMovingSoundVC;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageGuiMusicStopArea extends MessageBase<MessageGuiMusicStopArea> {
	
	private int machineIdArea;
	private EntityMachineBase machine;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.machineIdArea = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(MessageGuiMusicStop.machineId);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(MessageGuiMusicStopArea message, EntityPlayer player) 
	{
		message.machine = (EntityMachineBase) Minecraft.getMinecraft().world.getEntityByID(message.machineIdArea);
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		soundHandler.stopSounds();
		
		soundHandler.playSound(new JukeboxMovingSoundVC(message.machine, SoundEvents.UI_BUTTON_CLICK));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleServerSide(MessageGuiMusicStopArea message, EntityPlayer player) 
	{
		
	}
}
