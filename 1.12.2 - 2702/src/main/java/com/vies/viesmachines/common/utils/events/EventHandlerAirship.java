package com.vies.viesmachines.common.utils.events;

import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.EntityMachineFlying;
import com.vies.viesmachines.common.entity.machines.EntityMachineGround;
import com.vies.viesmachines.common.entity.machines.EntityMachineWater;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventHandlerAirship {
	
	@SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
		/**
		
		Entity machineRidden = event.player.getRidingEntity();
		
		//LogHelper.info(Minecraft.getMinecraft().gameSettings.gammaSetting);
		
		if (machineRidden instanceof EntityMachineBase)
		{
			if (machineRidden instanceof EntityMachineGround)
			{
				LogHelper.info("Is Ground");
			}
			
			if (machineRidden instanceof EntityMachineWater)
			{
				//if (machineRidden.s)
				if(event.player.world.isRemote)
				{
					Minecraft.getMinecraft().gameSettings.gammaSetting = 100.0F;
					
				}
				
				/*
				if (!event.player.isPotionActive(Potion.getPotionById(16))
						|| event.player.getActivePotionEffect(Potion.getPotionById(16)).getDuration() <= 240)
				{
					event.player.addPotionEffect(((EntityMachineWater) machineRidden).passiveAbility());
					
					//event.player.;
				}
				*
				//if (event.player.)
				
				LogHelper.info("Is Water");
			}
			
			if (machineRidden instanceof EntityMachineFlying)
			{
				LogHelper.info("Is Flying");
			}
			
			
			
			//LogHelper.info("TESTTTT");
			
			//if (machineRidden.hitByEntity(machineRidden.canRiderInteract()))
			//{
			//	LogHelper.info("2");
			//}
    		
    		
		}
		else
		{
			if(event.player.world.isRemote)
			{
				Minecraft.getMinecraft().gameSettings.gammaSetting = 0.0F;
				
			}
		}
    	*/
    }
	
	/**
	@SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
		Entity machineRidden = event.player.getRidingEntity();
		
		if (machineRidden instanceof EntityMachineBase)
		{
			event.player.canRiderInteract();
			
			
			LogHelper.info(machineRidden.hitByEntity(machineRidden.getRidingEntity()));
			
			//if (machineRidden.hitByEntity(machineRidden.canRiderInteract()))
			//{
			//	LogHelper.info("2");
			//}
    		
    		
		}
    	
    }
	
	
	/**
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) 
	{
		LogHelper.info("Pressed 1");
        if(Keybinds.vcForward.isKeyDown())
        {  
        	LogHelper.info("Pressed 222222222222222222222");
        	
        	//KeyBinding bind = FMLClientHandler.instance().getClient().gameSettings.keyBindForward;
            //if (bind.isKeyDown()) 
            //{ //Player is going forwards, make them stop
            //    KeyBinding.setKeyBindState(bind.getKeyCode(), false);
            //} 
            //else 
            //{ //Player is not going forwards, make them start
            //    KeyBinding.setKeyBindState(bind.getKeyCode(), true);
            //}
        	Keybinds.vcForward.unPressAllKeys();
        }
    }
	*/
	/**
	public static boolean creativeBurn;
	public static int playerRidingEntity;
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRiding = false;
    	
    	if(event.player.getRidingEntity() instanceof EntityAirshipBaseVC)
		{
			isRiding = true;
		}
    	else
		{
    		isRiding = false;
		}
    	
		//===================================================================
    	
    	if(isRiding) 
    	{
    		//EntityAirshipBaseVC test = (EntityAirshipBaseVC) event.player.getRidingEntity();
    		
    		//test.getAmbientSound();
    		
    		//NetworkHandler.sendToServer(new MessageGuiPlayEngineSound());
    		/**
    		playerRidingEntity = event.player.getRidingEntity().getEntityId();
			
			if(event.player.isCreative())
			{
				creativeBurn = true;
			}
			else
			{
				creativeBurn = false;
			}
			
		}
    	//else
		//{
		//	creativeBurn = false;
		//}*/
    //}
}
