package com.vies.viesmachines.common.entity.machines.containers;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.slots.FuelSlot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerMachineMenuMain extends ContainerVC {
	
	private EntityMachineBase machine;
    
	public ContainerMachineMenuMain(IInventory playerInv, EntityMachineBase machineIn) 
	{
		
		this.machine = machineIn;
        
		
		
		
		//LogHelper.info(nums.toString()..equals("vie")//.contains("record")
		//		);
		
		
		//Slot 0 - Fuel
		this.addSlotToContainer(new FuelSlot(this.machine.inventory, 0, 141, 38));
		
		
		//if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		//|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		//{
		//	this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 500, 500));
		//}
		//else
		//{
			//this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 147, 22));
		//}
		
		//Storage Lesser
		//if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
		//{
			//Slot 20-29 - Inventory Small
//			for (int y = 0; y < 3; ++y) 
///			{
//				for (int x = 0; x < 3; ++x) 
//				{
//					this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, (x + y * 3) + 20, 17 + x * 18, 78 + y * 18));
//				}
//			}
		//}
		
		//Storage Normal
		//if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
		//{
			//Slot 20-37 = Inventory Large
			//for (int y = 0; y < 3; ++y) 
			//{
			//	for (int x = 0; x < 3; ++x) 
			//	{
			//		this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, (x + y * 3) + 20, 35 + x * 18, 62 + y * 18));
			//		this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, ((x + y * 3) + 20) + 9, 89 + x * 18, 62 + y * 18));
			//	}
			//}
		//}
		
		//Storage Greater
		//if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
		//{
			//Slot 20-37 = Inventory Large
			//for (int y = 0; y < 3; ++y) 
			//{
			//	for (int x = 0; x < 3; ++x) 
			//	{
			//		this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, (x + y * 3) + 20, 8 + x * 18, 62 + y * 18));
			//		this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, ((x + y * 3) + 20) + 9, 62 + x * 18, 62 + y * 18));
			//		this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, ((x + y * 3) + 20) + 18, 116 + x * 18, 62 + y * 18));
			//	}
			//}
		//}
		
		
		//Bombing
		//if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
		//|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
		//|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
		//{
			//Bomb Slots
		//	this.addSlotToContainer(new ModuleBombSlotVC(this.airship.inventory, 51, 53, 89));
		//}
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 198));
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 9; ++x) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 140 + y * 18));
			}
		}
	}
}
