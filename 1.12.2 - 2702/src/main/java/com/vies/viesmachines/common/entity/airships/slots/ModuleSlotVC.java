package com.vies.viesmachines.common.entity.airships.slots;

import javax.annotation.Nullable;

import com.vies.viesmachines.api.ItemsVC;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModuleSlotVC extends SlotItemHandler {
	
	public ModuleSlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
    public boolean isItemValid(@Nullable ItemStack stack)
    {
		Item item = stack.getItem();
        
        if (item == ItemsVC.MODULE_TYPE)
        {
        	if(stack.getMetadata() != 0)
        	{
        		return true;
        	}
        }
        if(item == ItemsVC.MODULE_CREATIVE)
        {
        	return true;
        }
        
        return false;
    }
}
