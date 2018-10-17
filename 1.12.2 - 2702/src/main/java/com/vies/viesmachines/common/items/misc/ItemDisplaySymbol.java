package com.vies.viesmachines.common.items.misc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDisplaySymbol extends Item {
	
	public ItemDisplaySymbol() 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		ItemHelper.setItemName(this, "symbols/item_display_symbol");
		
		this.setMaxStackSize(1);
		//this.setCreativeTab(ViesCraft.tabViesCraftBlocks);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String itemName = "";
		if(stack.getMetadata() == 0)
        {
        	itemName = References.Old_I18n.translateToLocalFormatted("None");
        }
        else
        {
        	itemName = EnumsVM.MainDisplaySymbol.byId(this.getMetadata(stack)).getLocalizedName();
        }
		
		return itemName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EnumsVM.MainDisplaySymbol.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}
