package com.viesys.viesysmachines.network.server.airship;

import com.viesys.viesysmachines.client.gui.airship.main.GuiMainMenu;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.NetworkHandler;
import com.viesys.viesysmachines.network.packet.MessageBase;

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
