package com.vies.viesmachines.network.server.world;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class PlayerMessageMachineBroken extends MessageBase<PlayerMessageMachineBroken> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(PlayerMessageMachineBroken message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(PlayerMessageMachineBroken message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		player.sendMessage(new TextComponentString(TextFormatting.RED + References.Old_I18n.translateToLocalFormatted("viesmachines.message.machinebroken.0")));
	}
}
