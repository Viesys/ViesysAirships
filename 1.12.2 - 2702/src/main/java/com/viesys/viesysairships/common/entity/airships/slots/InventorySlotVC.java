package com.viesys.viesysairships.common.entity.airships.slots;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class InventorySlotVC extends SlotItemHandler {
	
	public InventorySlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	/**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
	@Override
    public boolean isItemValid(@Nullable ItemStack stack)
    {
        return true;
    }
}
