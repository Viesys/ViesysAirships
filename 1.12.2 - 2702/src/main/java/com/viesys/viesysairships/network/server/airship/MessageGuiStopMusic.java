package com.viesys.viesysairships.network.server.airship;

import com.viesys.viesysairships.client.gui.airship.main.GuiMainMenu;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.NetworkHandler;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageGuiStopMusic extends MessageBase<MessageGuiStopMusic> implements IMessage {
	
	static int airshipId;
	static int selectedSong;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		airshipId = buf.readInt();
		selectedSong = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMainMenu.airshipId);
		buf.writeInt(GuiMainMenu.selectedSong);
	}
	
	@Override
	public void handleClientSide(MessageGuiStopMusic message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiStopMusic message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		NetworkHandler.sendToAllAround(new MessageGuiStopMusicArea(), 
    	new TargetPoint(airship.dimension, airship.posX, airship.posY, airship.posZ, 30));
	}
}
