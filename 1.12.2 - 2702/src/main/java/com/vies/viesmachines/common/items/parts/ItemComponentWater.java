package com.vies.viesmachines.common.items.parts;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemComponentWater extends Item {
	
	public ItemComponentWater() 
	{
		ItemHelper.setItemName(this, "item_machine_component_water");
		
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(References.localNameVC(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add(References.localNameVC(this.getUnlocalizedName() + ".tt.2"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}
