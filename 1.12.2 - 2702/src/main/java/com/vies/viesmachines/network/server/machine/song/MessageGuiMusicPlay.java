package com.vies.viesmachines.network.server.machine.song;

import com.vies.viesmachines.client.gui.machines.GuiMachineMenuMain;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageGuiMusicPlay extends MessageBase<MessageGuiMusicPlay> implements IMessage {
	
	public static int machineId;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.machineId = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuMain.machineId);
	}
	
	@Override
	public void handleClientSide(MessageGuiMusicPlay message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiMusicPlay message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.getRidingEntity();
		
		NetworkHandler.sendToAllAround(new MessageGuiMusicPlayArea(), 
    	new TargetPoint(machine.dimension, machine.posX, machine.posY, machine.posZ, 32));
	}
}
