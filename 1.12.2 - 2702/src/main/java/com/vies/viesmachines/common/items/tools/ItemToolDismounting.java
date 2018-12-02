package com.vies.viesmachines.common.items.tools;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
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

public class ItemToolDismounting extends Item {
	
	private String procName;
	
	public ItemToolDismounting() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(25);
		
		this.procName = "ToolsProc";
		
		ItemHelper.setItemName(this, "item_tool_dismounter");
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        stack.damageItem(1, entityLiving);
        return true;
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		return true;
    }
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, net.minecraft.entity.player.EntityPlayer player, EntityLivingBase entity, net.minecraft.util.EnumHand hand)
    {
        if (entity.world.isRemote)
        {
            return false;
        }
        
        if (entity.getRidingEntity() != null)
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
		tooltip.add(TextFormatting.WHITE + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.1") 
		+ " " + TextFormatting.GRAY + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.2"));
		tooltip.add(References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.3"));
		tooltip.add("");
		tooltip.add(References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.4"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.COMMON;
    }

    /** Return the name for this gem proc. */
	public String getGemProcName()
    {
        return this.procName.toString();
    }
}
