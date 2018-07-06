package com.vies.viesmachines.network.server.airship.redstone;

import com.vies.viesmachines.client.gui.airship.redstone.GuiCustomizeMenuRedstone;
import com.vies.viesmachines.common.entity.airships.EntityAirshipBaseVC;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiRedstoneMenuConsume extends MessageBase<MessageHelperGuiRedstoneMenuConsume> {
	
	private int storedRedstone;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.storedRedstone = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiCustomizeMenuRedstone.storedRedstone);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiRedstoneMenuConsume message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiRedstoneMenuConsume message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.storedRedstone += message.storedRedstone;
		
		airship.inventory.extractItem(16, message.storedRedstone, false);
	}
}
