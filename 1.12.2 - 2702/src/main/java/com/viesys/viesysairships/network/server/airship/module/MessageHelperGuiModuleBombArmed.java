package com.viesys.viesysairships.network.server.airship.module;

import com.viesys.viesysairships.client.gui.airship.main.GuiMainMenu;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageHelperGuiModuleBombArmed extends MessageBase<MessageHelperGuiModuleBombArmed> implements IMessage {
	
	static boolean isArmed;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		isArmed = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(GuiMainMenu.isArmed);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiModuleBombArmed message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiModuleBombArmed message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.bombArmedToggle = message.isArmed;
	}
}