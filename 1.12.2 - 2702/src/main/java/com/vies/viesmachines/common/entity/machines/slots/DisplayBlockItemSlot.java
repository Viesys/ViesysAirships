package com.vies.viesmachines.common.entity.machines.slots;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class DisplayBlockItemSlot extends SlotItemHandler {
	
	public DisplayBlockItemSlot(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		//Item item = stack.getItem();
        
		//if (item == ItemsVM.MACHINE_PELLETS) return true;
        
		return true;//EntityMachineFuel.isItemFuel(stack) || isBucket(stack);
    }
}
