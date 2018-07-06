package com.vies.viesmachines.common.items.parts;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIgnition extends Item {
	
	public ItemIgnition() 
	{
		ItemHelper.setItemName(this, "item_airship_ignition");
		this.setMaxStackSize(16);
		this.setCreativeTab(ViesMachines.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(TextFormatting.DARK_AQUA + References.localNameVC("vc.item.tt.ignition.1"));
		tooltip.add(TextFormatting.DARK_AQUA + References.localNameVC("vc.item.tt.ignition.2"));
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
}
