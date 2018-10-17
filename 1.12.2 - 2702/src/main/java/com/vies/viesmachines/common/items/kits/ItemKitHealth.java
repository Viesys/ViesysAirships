package com.vies.viesmachines.common.items.kits;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKitHealth extends Item {
	
	private int repairItem;
	private EnumRarity rarity;
	
	public ItemKitHealth(String unlocalizedName, EnumRarity rarityIn, int repairItemIn) 
	{
		this.setMaxStackSize(64);
		this.repairItem = repairItemIn;
		this.rarity = rarityIn;
		
		ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		if (entity instanceof EntityMachineBase)
        {
			// If this machine is fully healed, ignore all below code:
			if (((EntityMachineBase) entity).getHealth() == ((EntityMachineBase) entity).getMachineMaxHealth())
        	{
				return true;
        	}
			
			// If this machine is broken, fix it:
			if (((EntityMachineBase) entity).getBroken())
			{
				((EntityMachineBase) entity).setBroken(false);
			}
			
			// Sets the max health attribute:
			((EntityMachineBase) entity).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVM.FlyingMachineFrameTier.byId(((EntityMachineBase) entity).getTierFrame()).getMaxHealthModifier());
	        
			// Heals the machine for 2 HP:
			if(this.repairItem == 0)
			{
				((EntityMachineBase) entity).heal(2.0F);
		    	
				if(!player.isCreative())
				{
					stack.shrink(1);
				}
				
				((EntityMachineBase) entity).setEventTrigger(4);
				
		    	return true;
			}
			
			// Heals the machine for 8 HP:
			if(this.repairItem == 1)
			{
				((EntityMachineBase) entity).heal(8.0F);
		    	
				if(!player.isCreative())
				{
					stack.shrink(1);
				}
				
				((EntityMachineBase) entity).setEventTrigger(4);
				
		    	return true;
			}
			
			// Heals the machine for Max HP:
			if(this.repairItem == 2)
			{
				((EntityMachineBase) entity).heal(((EntityMachineBase) entity).getMachineMaxHealth());
				
				if (((EntityMachineBase) entity).getHealth() > ((EntityMachineBase) entity).getMachineMaxHealth())
				{
					((EntityMachineBase) entity).heal(((EntityMachineBase) entity).getMachineMaxHealth());
				}
		    	
				if(!player.isCreative())
				{
					stack.shrink(1);
				}
				
				((EntityMachineBase) entity).setEventTrigger(4);
				
		    	return true;
			}
        }
		else if(entity instanceof EntityLiving)
        {
			if (entity.getRidingEntity() != null)
			{
				if (entity.getRidingEntity() instanceof EntityMachineBase)
				{
					// If this machine is fully healed, ignore all below code:
					if (((EntityMachineBase) entity.getRidingEntity()).getHealth() == ((EntityMachineBase) entity.getRidingEntity()).getMachineMaxHealth())
		        	{
						return true;
		        	}
					
					// If this machine is broken, fix it:
					if (((EntityMachineBase) entity.getRidingEntity()).getBroken())
					{
						((EntityMachineBase) entity.getRidingEntity()).setBroken(false);
					}
					
					// Sets the max health attribute:
					((EntityMachineBase) entity.getRidingEntity()).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVM.FlyingMachineFrameTier.byId(((EntityMachineBase) entity.getRidingEntity()).getTierFrame()).getMaxHealthModifier());
			        
					// Heals the machine for 2 HP:
					if(this.repairItem == 0)
					{
						((EntityMachineBase) entity.getRidingEntity()).heal(2.0F);
				    	
						if(!player.isCreative())
						{
							stack.shrink(1);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(4);
						
				    	return true;
					}
					
					// Heals the machine for 8 HP:
					if(this.repairItem == 1)
					{
						((EntityMachineBase) entity.getRidingEntity()).heal(8.0F);
				    	
						if(!player.isCreative())
						{
							stack.shrink(1);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(4);
						
				    	return true;
					}
					
					// Heals the machine for Max HP:
					if(this.repairItem == 2)
					{
						((EntityMachineBase) entity.getRidingEntity()).setHealth(((EntityMachineBase) entity.getRidingEntity()).getMachineMaxHealth());
				    	
						if(!player.isCreative())
						{
							stack.shrink(1);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(4);
						
				    	return true;
					}
				}
			}
        }
		else
		{
			return true;
		}
		
		return true;
    }
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, net.minecraft.entity.player.EntityPlayer player, EntityLivingBase entity, net.minecraft.util.EnumHand hand)
    {
        if(entity.world.isRemote)
        {
            return false;
        }
        
        if(entity instanceof EntityMachineBase)
        {
        	return true;
        }
        
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		TextFormatting color = TextFormatting.GOLD;
		
		if (this.rarity == EnumRarity.RARE)
		{
			color = TextFormatting.DARK_AQUA;
		}
		
		if (this.rarity == EnumRarity.EPIC)
		{
			color = TextFormatting.DARK_PURPLE;
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(color + References.localNameVC(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add("");
		tooltip.add(color + References.localNameVC(this.getUnlocalizedName() + ".tt.2"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return this.rarity;
    }
}
