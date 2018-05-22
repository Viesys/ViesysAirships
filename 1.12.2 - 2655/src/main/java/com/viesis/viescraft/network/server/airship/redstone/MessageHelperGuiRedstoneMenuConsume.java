package com.viesis.viescraft.network.server.airship.redstone;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.airship.redstone.GuiCustomizeMenuRedstone;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;

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
