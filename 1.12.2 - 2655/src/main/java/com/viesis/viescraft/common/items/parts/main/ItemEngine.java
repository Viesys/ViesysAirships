package com.viesis.viescraft.common.items.parts.main;

import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEngine extends Item {
	
	public ItemEngine() 
	{
		ItemHelper.setItemName(this, "item_airship_engine");
		this.setMaxStackSize(32);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(TextFormatting.GOLD + References.localNameVC("vc.item.tt.engine.1"));
		tooltip.add(TextFormatting.GOLD + References.localNameVC("vc.item.tt.engine.2"));
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}
