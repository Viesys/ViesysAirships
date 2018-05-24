package com.viesys.viesysairships.network.server.airship.upgrade;

import com.viesys.viesysairships.client.gui.GuiContainerVC;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiUpgradeFrameVC extends MessageBase<MessageHelperGuiUpgradeFrameVC> {
	
	private int metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiUpgradeFrameVC message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiUpgradeFrameVC message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.mainTierFrame = message.metaFrame;
		airship.inventory.extractItem(2, 1, false);
	}
}
