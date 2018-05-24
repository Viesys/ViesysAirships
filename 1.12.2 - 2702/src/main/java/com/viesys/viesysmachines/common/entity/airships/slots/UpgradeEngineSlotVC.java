package com.viesys.viesysmachines.common.entity.airships.slots;

import javax.annotation.Nullable;

import com.viesys.viesysmachines.api.ItemsVC;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class UpgradeEngineSlotVC extends SlotItemHandler {
	
	public UpgradeEngineSlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
    public boolean isItemValid(@Nullable ItemStack stack)
    {
		Item item = stack.getItem();
        
        if (item == ItemsVC.UPGRADE_ENGINE)
        {
        	if(stack.getMetadata() != 0)
        	{
        		return true;
        	}
        }
        
        return false;
    }
}
