package com.vies.viesmachines.network.server.airship.main;

import com.vies.viesmachines.client.gui.airship.main.GuiMainMenu;
import com.vies.viesmachines.common.entity.airships.EntityAirshipBaseVC;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMainMenuConsumeBomb2 extends MessageBase<MessageHelperGuiMainMenuConsumeBomb2> {
	
	private int storedBomb;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.storedBomb = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMainMenu.bombslotCount);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMainMenuConsumeBomb2 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMainMenuConsumeBomb2 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.storedBombType2 += message.storedBomb;
		
		airship.inventory.extractItem(51, message.storedBomb, false);
	}
}
