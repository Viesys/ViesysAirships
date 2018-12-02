package com.vies.viesmachines.network.server.machine;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.particles.EntityBulletElectrical;
import com.vies.viesmachines.common.entity.particles.EntityBulletExplosive;
import com.vies.viesmachines.common.entity.particles.EntityBulletNormal;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;

public class MessageMachineProjectileShoot extends MessageBase<MessageMachineProjectileShoot> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageMachineProjectileShoot message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageMachineProjectileShoot message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			//Normal
			if (machineIn.getAmmoType() == 0)
			{
				EntityBulletNormal entitybulletnormal = new EntityBulletNormal(player.world, 
						player.posX + (double)(MathHelper.sin(-player.rotationYaw * 0.017453292F) * 02.50F), 
						player.posY + 0.95D, 
						player.posZ + (double)(MathHelper.cos(player.rotationYaw * 0.017453292F) * 02.50F));
				
				entitybulletnormal.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.5F, 0.0F);
		        
				machineIn.world.spawnEntity(entitybulletnormal);
			}
			
			//Electrical
			if (machineIn.getAmmoType() == 1
			&& machineIn.getEnergy() >= CostsVM.COST_PROJECTILE_ELECTRICAL)
			{
				EntityBulletElectrical entitybulletelectrical = new EntityBulletElectrical(player.world, 
						player.posX + (double)(MathHelper.sin(-player.rotationYaw * 0.017453292F) * 02.50F), 
						player.posY + 0.95D, 
						player.posZ + (double)(MathHelper.cos(player.rotationYaw * 0.017453292F) * 02.50F));
				
				entitybulletelectrical.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.5F, 0.0F);
		        
				machineIn.world.spawnEntity(entitybulletelectrical);
			}
			
			//Explosive
			if (machineIn.getAmmoType() == 2
			&& machineIn.getEnergy() >= CostsVM.COST_PROJECTILE_EXPLOSIVE)
			{
				EntityBulletExplosive entitybulletexplosive = new EntityBulletExplosive(player.world, 
						player.posX + (double)(MathHelper.sin(-player.rotationYaw * 0.017453292F) * 02.50F), 
						player.posY + 0.95D, 
						player.posZ + (double)(MathHelper.cos(player.rotationYaw * 0.017453292F) * 02.50F));
				
				entitybulletexplosive.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.5F, 0.0F);
				
				machineIn.world.spawnEntity(entitybulletexplosive);
			}
		}
		else if (machineIn.getAmmoAmount() > 0)
		{
			if (machineIn.getAmmoType() == 1 && machineIn.getEnergy() < CostsVM.COST_PROJECTILE_ELECTRICAL
			|| machineIn.getAmmoType() == 2 && machineIn.getEnergy() < CostsVM.COST_PROJECTILE_EXPLOSIVE)
			{
				machineIn.setAmmoType(0);
			}
			
			//Normal
			if (machineIn.getAmmoType() == 0)
			{
				EntityBulletNormal entitybulletnormal = new EntityBulletNormal(player.world, 
						player.posX + (double)(MathHelper.sin(-player.rotationYaw * 0.017453292F) * 02.50F), 
						player.posY + 0.95D, 
						player.posZ + (double)(MathHelper.cos(player.rotationYaw * 0.017453292F) * 02.50F));
				
				entitybulletnormal.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.5F, 0.0F);
		        
				machineIn.world.spawnEntity(entitybulletnormal);
				
				machineIn.setAmmoAmount(machineIn.getAmmoAmount() - 1);
			}
			
			//Electrical
			if (machineIn.getAmmoType() == 1
			&& machineIn.getEnergy() >= CostsVM.COST_PROJECTILE_ELECTRICAL)
			{
				EntityBulletElectrical entitybulletelectrical = new EntityBulletElectrical(player.world, 
						player.posX + (double)(MathHelper.sin(-player.rotationYaw * 0.017453292F) * 02.50F), 
						player.posY + 0.95D, 
						player.posZ + (double)(MathHelper.cos(player.rotationYaw * 0.017453292F) * 02.50F));
				
				entitybulletelectrical.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.5F, 0.0F);
		        
				machineIn.world.spawnEntity(entitybulletelectrical);
				
				machineIn.setAmmoAmount(machineIn.getAmmoAmount() - 1);
				machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_PROJECTILE_ELECTRICAL);
			}
			
			//Explosive
			if (machineIn.getAmmoType() == 2
			&& machineIn.getEnergy() >= CostsVM.COST_PROJECTILE_EXPLOSIVE)
			{
				EntityBulletExplosive entitybulletexplosive = new EntityBulletExplosive(player.world, 
						player.posX + (double)(MathHelper.sin(-player.rotationYaw * 0.017453292F) * 02.50F), 
						player.posY + 0.95D, 
						player.posZ + (double)(MathHelper.cos(player.rotationYaw * 0.017453292F) * 02.50F));
				
				entitybulletexplosive.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.5F, 0.0F);
				
				machineIn.world.spawnEntity(entitybulletexplosive);
				
				machineIn.setAmmoAmount(machineIn.getAmmoAmount() - 1);
				machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_PROJECTILE_EXPLOSIVE);
			}
		}
	}
}
