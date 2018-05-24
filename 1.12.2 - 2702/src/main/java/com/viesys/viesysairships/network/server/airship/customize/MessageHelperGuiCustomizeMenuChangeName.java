package com.viesys.viesysairships.network.server.airship.customize;

import com.viesys.viesysairships.api.CostsVC;
import com.viesys.viesysairships.client.gui.airship.customize.GuiCustomizeMenuChangeName;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysairships.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageHelperGuiCustomizeMenuChangeName extends MessageBase<MessageHelperGuiCustomizeMenuChangeName> {
	
	private String customName;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.customName = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeUTF8String(buf, GuiCustomizeMenuChangeName.textNameStorage);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuChangeName message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuChangeName message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.getStoredRedstone() >= CostsVC.RENAME_COST)
		{
			airship.customName = message.customName;
			
			airship.storedRedstone = airship.storedRedstone - CostsVC.RENAME_COST;
		}
	}
}