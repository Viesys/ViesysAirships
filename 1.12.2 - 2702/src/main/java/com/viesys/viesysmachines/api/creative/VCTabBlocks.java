package com.viesys.viesysmachines.api.creative;

import com.viesys.viesysmachines.api.BlocksVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VCTabBlocks extends CreativeTabs {
	
	public VCTabBlocks(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(BlocksVC.AIRSHIP_WORKBENCH));
	}
}
