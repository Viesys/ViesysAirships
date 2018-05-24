package com.viesys.viesysmachines.common.entity.airships.slots;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class DisplayBlockItemSlotVC extends SlotItemHandler {
	
	public DisplayBlockItemSlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		return true;
    }
}
