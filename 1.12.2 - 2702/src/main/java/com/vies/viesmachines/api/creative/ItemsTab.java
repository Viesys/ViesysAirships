package com.vies.viesmachines.api.creative;

import com.vies.viesmachines.api.ItemsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsTab extends CreativeTabs {
	
	public ItemsTab(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemsVC.MACHINE_PELLETS
				//.ITEM_AIRSHIP_CREATIVE
				, 1);
	}
}
