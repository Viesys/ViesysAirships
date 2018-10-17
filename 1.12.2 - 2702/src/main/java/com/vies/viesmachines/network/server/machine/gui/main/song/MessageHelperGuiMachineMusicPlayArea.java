package com.vies.viesmachines.network.server.machine.gui.main.song;

import com.vies.viesmachines.client.sound.JukeboxMovingSoundVC;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.proxy.ClientProxy;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageHelperGuiMachineMusicPlayArea extends MessageBase<MessageHelperGuiMachineMusicPlayArea> {
	
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
		buf.writeInt(MessageHelperGuiMachineMusicPlay.machineId);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(MessageHelperGuiMachineMusicPlayArea message, EntityPlayer player) 
	{
		message.machine = (EntityMachineBase) Minecraft.getMinecraft().world.getEntityByID(message.machineIdArea);
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		soundHandler.stopSounds();
		
		soundHandler.playSound(new JukeboxMovingSoundVC(message.machine, SoundEvent.REGISTRY.getObject(new ResourceLocation(ClientProxy.musicListRecord.get(message.machine.selectedSong).toString()))));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleServerSide(MessageHelperGuiMachineMusicPlayArea message, EntityPlayer player) 
	{
		
	}
}
