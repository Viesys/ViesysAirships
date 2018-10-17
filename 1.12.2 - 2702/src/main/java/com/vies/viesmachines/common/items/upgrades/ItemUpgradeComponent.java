package com.vies.viesmachines.common.items.upgrades;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUpgradeComponent extends Item {
	
	private EnumRarity rarity;
	private int upgradeTier;
	
	public ItemUpgradeComponent(String unlocalizedNameIn, EnumRarity rarityIn, int upgradeTierIn) 
	{
		this.setMaxStackSize(1);
		
		this.rarity = rarityIn;
		this.upgradeTier = upgradeTierIn;
		
		ItemHelper.setItemName(this, unlocalizedNameIn);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		if (entity instanceof EntityMachineBase)
        {
			if (!((EntityMachineBase) entity).getBroken())
			{
				if (((EntityMachineBase) entity).getTierComponent() < (this.upgradeTier)
				&& ((EntityMachineBase) entity).getTierComponent() == (this.upgradeTier - 1))
				{
					((EntityMachineBase) entity).setTierComponent(this.upgradeTier);
					
					if (!player.isCreative())
					{
						stack.shrink(1);
					}
					
					((EntityMachineBase) entity).setEventTrigger(3);
	        	}
			}
        }
		else if(entity instanceof EntityLiving)
        {
			if (entity.getRidingEntity() != null)
			{
				if (entity.getRidingEntity() instanceof EntityMachineBase)
				{
					if (!((EntityMachineBase) entity.getRidingEntity()).getBroken())
					{
						if (((EntityMachineBase) entity.getRidingEntity()).getTierComponent() < (this.upgradeTier)
						&& ((EntityMachineBase) entity.getRidingEntity()).getTierComponent() == (this.upgradeTier - 1))
						{
							((EntityMachineBase) entity.getRidingEntity()).setTierComponent(this.upgradeTier);
							
							if (!player.isCreative())
							{
								stack.shrink(1);
							}
							
							((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(3);
			        	}
					}
				}
			}
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
		TextFormatting textColor = TextFormatting.GRAY;
		
		if (this.rarity == EnumRarity.UNCOMMON)
		{
			textColor = TextFormatting.GOLD;
		}
		
		if (this.rarity == EnumRarity.RARE)
		{
			textColor = TextFormatting.DARK_AQUA;
		}
		
		if (this.rarity == EnumRarity.EPIC)
		{
			textColor = TextFormatting.DARK_PURPLE;
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(textColor + References.localNameVC(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add("");
		tooltip.add(textColor + References.localNameVC(this.getUnlocalizedName() + ".tt.2"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return this.rarity;
    }
}
