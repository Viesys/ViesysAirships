package com.viesys.viesysairships.common.entity.airships.slots;

import com.viesys.viesysairships.api.ItemsVC;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class FuelSlotVC extends SlotItemHandler {
	
	public FuelSlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		Item item = stack.getItem();
        
		if (item == ItemsVC.VIESOLINE_PELLETS) return true;
        
		return EntityAirshipBaseVC.isItemFuel(stack) || isBucket(stack);
    }
	
	public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack)
    {
        return stack.getItem() == Items.BUCKET;
    }
}
