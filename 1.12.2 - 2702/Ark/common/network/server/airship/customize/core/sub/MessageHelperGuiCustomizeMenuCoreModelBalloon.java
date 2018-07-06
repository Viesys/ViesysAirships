package com.viesys.viesysmachines.network.server.airship.customize.core.sub;

import com.viesys.viesysmachines.api.CostsVC;
import com.viesys.viesysmachines.client.gui.GuiContainerVC;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipBaseVC;
import com.viesys.viesysmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuCoreModelBalloon extends MessageBase<MessageHelperGuiCustomizeMenuCoreModelBalloon> {
	
	private int metaCore;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaCore = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuCoreModelBalloon message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuCoreModelBalloon message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.getStoredRedstone() >= CostsVC.CORE_MODEL_BALLOON_COST
		&& message.metaCore != 0
		&& message.metaCore != airship.coreModelVisualBalloon)
		{
			airship.coreModelVisualBalloon = message.metaCore;
			airship.storedRedstone = airship.storedRedstone - CostsVC.CORE_MODEL_BALLOON_COST;
		}
		
		if(message.metaCore == 0)
		{
			airship.coreModelVisualBalloon = message.metaCore;
		}
	}
}
