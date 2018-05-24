package com.viesys.viesysairships.common.entity.airships.containers.all;

import com.viesys.viesysairships.common.entity.airships.EntityAirshipCore;
import com.viesys.viesysairships.common.entity.airships.containers.ContainerVC;

import net.minecraft.inventory.IInventory;

public class ContainerCustomizeMenu extends ContainerVC {
	
	private EntityAirshipCore airship;
    
	public ContainerCustomizeMenu(IInventory playerInv, EntityAirshipCore airshipIn) 
	{
		this.airship = airshipIn;
	}
}
