package com.vies.viesmachines.common.entity.machines.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerVC extends Container {
	
	/**
	 * SLOTS: <br> <br>
	 *
	 * Slot  0 = Fuel <br>
	 * Slot  1 = Upgrade Core <br>
	 * Slot  2 = Upgrade Frame <br>
	 * Slot  3 = Upgrade Engine <br>
	 * Slot  4 = Upgrade Balloon <br>
	 * Slot 11 = Module Slot1 <br>
	 * Slot 12 = Module Slot2 <br>
	 * Slot 16 = Redstone Slot <br>
	 * Slot 18 = Block/Item to Display <br>
	 * Slot 20-28 = Inventory Small <br>
	 * Slot 20-37 = Inventory Large <br>
	 * Slot 51 = Bomb Slot1 <br>
	 */
	public ContainerVC() 
	{
		
	}
	
	@Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
    	return true;
    }
	
    /**
     * Take a stack from the specified inventory slot.
     */
	@Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if (index == 0)
            {
            	if (!this.mergeItemStack(itemstack1, 1, 37, true))
                {
                    return ItemStack.EMPTY;
                }
            	
            	slot.onSlotChange(itemstack1, itemstack);
            }
            else
            {
            	if (!this.mergeItemStack(itemstack1, 0, 1, false))
				{
					return ItemStack.EMPTY;
				}
            }
            
            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
            
            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }
            
            slot.onTake(playerIn, itemstack1);
        }
        
        return itemstack;
    }
}
