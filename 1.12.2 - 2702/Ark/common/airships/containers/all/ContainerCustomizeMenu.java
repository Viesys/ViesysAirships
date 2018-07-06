package com.viesys.viesysmachines.common.entity.airships.containers.all;

import com.viesys.viesysmachines.common.entity.airships.EntityAirshipCore;
import com.viesys.viesysmachines.common.entity.airships.containers.ContainerVC;

import net.minecraft.inventory.IInventory;

public class ContainerCustomizeMenu extends ContainerVC {
	
	private EntityAirshipCore airship;
    
	public ContainerCustomizeMenu(IInventory playerInv, EntityAirshipCore airshipIn) 
	{
		this.airship = airshipIn;
	}
}
