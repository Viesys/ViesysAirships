package com.vies.viesmachines.network.server.machine.gui.customize.activemodels;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.machines.visual.GuiMachineMenuCustomizeActiveModels;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class MessageHelperGuiMachineMenuCustomizeActiveModelDefault extends MessageBase<MessageHelperGuiMachineMenuCustomizeActiveModelDefault> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizeActiveModelDefault message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizeActiveModelDefault message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		machineIn.setVisualModelFrame(0);
		machineIn.setVisualModelEngine(0);
		machineIn.setVisualModelComponent(0);
	}
}
