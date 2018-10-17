package com.vies.viesmachines.common.items.tools;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDismounterNormal extends Item {
	
	public ItemDismounterNormal() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(25);
		ItemHelper.setItemName(this, "item_dismounter_normal");
		this.setCreativeTab(ViesMachines.tabViesCraftItems);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        stack.damageItem(1, entityLiving);
        return true;
    }
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, net.minecraft.entity.player.EntityPlayer player, EntityLivingBase entity, net.minecraft.util.EnumHand hand)
    {
        if(entity.world.isRemote)
        {
            return false;
        }
        
        if(entity.getRidingEntity() != null
        &&(entity.getRidingEntity() != null))
        {
        	itemstack.damageItem(1, entity);
        	
        	entity.dismountRidingEntity();
        	
            return true;
        }
        
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.dismounter.1") + " " + TextFormatting.GRAY + References.localNameVC("vc.item.tt.dismounternormal.1"));
		tooltip.add(TextFormatting.GRAY + References.localNameVC("vc.item.tt.dismounternormal.2"));
		tooltip.add(TextFormatting.GRAY + "");
		tooltip.add(TextFormatting.GRAY + References.localNameVC("vc.item.tt.dismounter.2"));
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.COMMON;
    }
}
