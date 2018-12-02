package com.vies.viesmachines.common.items;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGenericSymbol extends Item {
	
	public ItemGenericSymbol(String unlocalizedNameIn) 
	{
		ItemHelper.setItemName(this, unlocalizedNameIn);
		
		this.setMaxStackSize(1);
	}
}
