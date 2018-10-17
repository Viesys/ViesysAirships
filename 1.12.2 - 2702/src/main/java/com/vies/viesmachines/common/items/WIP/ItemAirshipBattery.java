package com.vies.viesmachines.common.items.WIP;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.item.Item;

public class ItemAirshipBattery extends Item {
	
	private int capacity;
	private int maxReceive;
	private int maxExtract;
	
	public ItemAirshipBattery(int capacityIn, int maxReceiveIn, int maxExtractIn) 
	{
		ItemHelper.setItemName(this, "item_airship_battery");
		
		this.capacity = capacityIn;
		this.maxReceive = maxReceiveIn;
		this.maxExtract = maxExtractIn;
		
		this.setMaxDamage(capacity);
		this.setMaxStackSize(1);
		//this.setCreativeTab(ViesMachines.tabViesCraftItems);
		
	}
	/**
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.UNCOMMON;
    }
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER , null);
		
		this.setDamage(stack, (cap.getMaxEnergyStored() + 1) - cap.getEnergyStored());
    }
	
	@Override
    public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) 
	{
		return new CapabilityProviderVC(new DualEnergyStorageVC(capacity, maxReceive, maxExtract));
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return ("Airship Battery");
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		DualEnergyStorageVC cap = (DualEnergyStorageVC) itemstack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER, null);
		
		if(playerIn.isSneaking())
		{
		//	if (!worldIn.isRemote)
		//	{
				cap.receiveEnergy(100, false);
				
				LogHelper.info("+Stored energy: " + cap.getEnergyStored());
				LogHelper.info("+Max energy = " + cap.getMaxEnergyStored());
		//	}
		}
		else
		{
		//if (!worldIn.isRemote)
		//	{
				cap.extractEnergy(10, false);
				
				LogHelper.info("-Stored energy: " + cap.getEnergyStored());
				LogHelper.info("-Max energy = " + cap.getMaxEnergyStored());
		//	}
		}
		
		
        return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER, null);
		
		toolTip.add(TextFormatting.DARK_PURPLE + "Forge Stored energy: " + cap.getEnergyStored());
		toolTip.add(TextFormatting.DARK_PURPLE + "Tesla Stored energy: " + cap.getStoredPower());
		toolTip.add("");
		toolTip.add(TextFormatting.DARK_PURPLE + "Max energy = " + cap.getMaxEnergyStored());
	}

	*/
	
	
	
}
