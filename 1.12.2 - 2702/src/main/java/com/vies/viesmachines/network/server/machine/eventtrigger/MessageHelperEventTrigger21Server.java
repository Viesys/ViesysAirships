package com.vies.viesmachines.network.server.machine.eventtrigger;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger21Client;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;

public class MessageHelperEventTrigger21Server extends MessageBase<MessageHelperEventTrigger21Server> {
	
	public static int machineID;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		machineID = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(EntityMachineBase.entityID);
	}
	
	@Override
	public void handleClientSide(MessageHelperEventTrigger21Server message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperEventTrigger21Server message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.world.getEntityByID(message.machineID);
		
		// Sends a packet to nearby players to render trigger events:
		NetworkHandler.sendToAllAround(new MessageHelperEventTrigger21Client(), 
				new TargetPoint(machine.dimension, machine.posX, machine.posY, machine.posZ, 32));
	}
}
