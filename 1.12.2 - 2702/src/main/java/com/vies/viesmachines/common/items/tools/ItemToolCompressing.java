package com.vies.viesmachines.common.items.tools;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemToolCompressing extends Item {
	
	public ItemToolCompressing() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(25);
		ItemHelper.setItemName(this, "item_tool_compressing");
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        stack.damageItem(1, entityLiving);
        return true;
    }
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		if(entity instanceof EntityMachineBase)
        {
			if(((EntityMachineBase) entity).getHealth() == ((EntityMachineBase) entity).getMaxHealth())
        	{
				return true;
        	}
			else if(((EntityMachineBase) entity).getHealth() > 0)
        	{
				((EntityMachineBase) entity).heal(1.0F);
		    	
				if(!player.isCreative())
				{
					stack.damageItem(1, player);
				}
		    	return true;
        	}
        	else
        	{
        		((EntityMachineBase) entity).setHealth(1.0F);
        		
        		if(!player.isCreative())
				{
					stack.damageItem(1, player);
				}
        		return true;
        	}
        }
		
		else if(entity instanceof EntityLiving)
        {
			if (entity.getRidingEntity() != null)
			{
				if (entity.getRidingEntity() instanceof EntityMachineBase)
				{
					if(((EntityMachineBase) entity.getRidingEntity()).getHealth() == ((EntityMachineBase) entity.getRidingEntity()).getMaxHealth())
		        	{
						return true;
		        	}
					else if(((EntityMachineBase) entity.getRidingEntity()).getHealth() > 0)
		        	{
						((EntityMachineBase) entity.getRidingEntity()).heal(1.0F);
				    	
						if(!player.isCreative())
						{
							stack.damageItem(1, player);
						}
				    	return true;
		        	}
		        	else
		        	{
		        		((EntityMachineBase) entity.getRidingEntity()).setHealth(1.0F);
		        		
		        		if(!player.isCreative())
						{
							stack.damageItem(1, player);
						}
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
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(References.localNameVC(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add(References.localNameVC(this.getUnlocalizedName() + ".tt.2"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.COMMON;
    }
}
