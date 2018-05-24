package com.viesys.viesysairships.api.creative;

import com.viesys.viesysairships.api.ItemsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VCTabItems extends CreativeTabs {
	
	public VCTabItems(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemsVC.ITEM_AIRSHIP_CREATIVE, 1);
	}
}
