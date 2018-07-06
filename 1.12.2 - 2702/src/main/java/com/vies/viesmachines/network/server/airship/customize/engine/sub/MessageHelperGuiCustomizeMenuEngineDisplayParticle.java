package com.vies.viesmachines.network.server.airship.customize.engine.sub;

import com.vies.viesmachines.api.CostsVC;
import com.vies.viesmachines.client.gui.GuiContainerVC;
import com.vies.viesmachines.common.entity.airships.EntityAirshipBaseVC;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplayParticle extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplayParticle> {
	
	private int metaDisplayParticle;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaDisplayParticle = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplayParticle message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplayParticle message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_PARTICLES_COST)
		{
			airship.engineParticleVisual = message.metaDisplayParticle;
			airship.storedRedstone = airship.storedRedstone - CostsVC.ENGINE_PARTICLES_COST;
		}
	}
}
