package com.vies.viesmachines.common.entity.airships.containers.all;

import com.vies.viesmachines.common.entity.airships.EntityAirshipCore;
import com.vies.viesmachines.common.entity.machines.containers.ContainerVC;

import net.minecraft.inventory.IInventory;

public class ContainerCustomizeMenu extends ContainerVC {
	
	private EntityAirshipCore airship;
    
	public ContainerCustomizeMenu(IInventory playerInv, EntityAirshipCore airshipIn) 
	{
		this.airship = airshipIn;
	}
}
