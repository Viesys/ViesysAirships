package com.vies.viesmachines.common.items.machines.flying;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.common.entity.thrown.EntityThrownMachineFlyingAirship;
import com.vies.viesmachines.common.items.ItemHelper;
import com.vies.viesmachines.common.items.machines.ItemMachineBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMachineFlyingAirship extends ItemMachineBase {
	
	private EnumRarity rarity;
	
	public ItemMachineFlyingAirship(String unlocalizedName, EnumRarity rarityIn) 
	{
		ItemHelper.setItemName(this, unlocalizedName);
		
		this.rarity = rarityIn;
		
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItemMainhand();
        
		this.frameTier = 0;
		this.engineTier = 0;
		this.componentTier = 0;
		
		// Airship
		this.type = 0;
		this.health = (float) EnumsVM.FlyingMachineFrameTier.byId(this.frameTier).getMaxHealthModifier();
		this.energy = 0;
		
		this.broken = false;
		this.fuel = 0;
		this.fuelTotal = 0;
		
		//this.itemstackFuelItem = 0;
		//this.itemstackFuelSize = 0;
		
		this.ammoAmount = 0;
		this.ammoType = 0;
		
		this.machineEnhancement1 = 0;
		
		
		
		this.visualModelFrame = 0;
		this.visualModelEngine = 0;
		this.visualModelComponent = 0;
		
		this.visualFrameTexture = 0;
		this.visualFrameTransparent = false;
		this.visualFrameColor = false;
		this.visualFrameColorRed = 0;
		this.visualFrameColorGreen = 0;
		this.visualFrameColorBlue = 0;
		
		this.visualEngineParticle = 0;
		this.visualEngineDisplayType = 0;
		this.visualEngineDisplayItemstack = 0;
		this.visualEngineDisplayItemstackMeta = 0;
		this.visualEngineDisplayHead = 0;
		this.visualEngineDisplaySupporterHead = 0;
		this.visualEngineDisplayHoliday = 0;
		
		this.visualComponentTexture = 0;
		this.visualComponentTransparent = false;
		this.visualComponentColor = false;
		this.visualComponentColorRed = 0;
		this.visualComponentColorGreen = 0;
		this.visualComponentColorBlue = 0;
		
		this.storedInventory = new NBTTagCompound();
		this.customName = "Airship";
		this.visualNameColor = EnumsVM.SelectColor.WHITE.getMetadata();
		
        if(playerIn.isSneaking())
		{
        	if(itemstack.hasTagCompound())
        	{
        		this.frameTier = itemstack.getTagCompound().getInteger(rf.TIER_FRAME_TAG);
        		this.engineTier = itemstack.getTagCompound().getInteger(rf.TIER_ENGINE_TAG);
        		this.componentTier = itemstack.getTagCompound().getInteger(rf.TIER_COMPONENT_TAG);
        		
        		this.type = itemstack.getTagCompound().getInteger(rf.TYPE_TAG);
        		this.health = itemstack.getTagCompound().getFloat(rf.HEALTH_TAG);
        		this.energy = itemstack.getTagCompound().getInteger(rf.ENERGY_TAG);
        		
        		this.broken = itemstack.getTagCompound().getBoolean(rf.BROKEN_TAG);
        		this.fuel = itemstack.getTagCompound().getInteger(rf.FUEL_TAG);
        		this.fuelTotal = itemstack.getTagCompound().getInteger(rf.FUEL_TOTAL_TAG);
        		
        		//this.itemstackFuelItem = itemstack.getTagCompound().getInteger(rf.ITEMSTACK_FUEL_ITEM_TAG);
        		//this.itemstackFuelSize = itemstack.getTagCompound().getInteger(rf.ITEMSTACK_FUEL_SIZE_TAG);
        		
        		this.ammoAmount = itemstack.getTagCompound().getInteger(rf.AMMO_AMOUNT_TAG);
        		this.ammoType = itemstack.getTagCompound().getInteger(rf.AMMO_TYPE_TAG);
        		
        		this.machineEnhancement1 = itemstack.getTagCompound().getInteger(rf.MACHINE_ENHANCEMENT_1_TAG);
        		
        		
        		
        		this.visualModelFrame = itemstack.getTagCompound().getInteger(rf.VISUAL_MODEL_FRAME_TAG);
        		this.visualModelEngine = itemstack.getTagCompound().getInteger(rf.VISUAL_MODEL_ENGINE_TAG);
        		this.visualModelComponent = itemstack.getTagCompound().getInteger(rf.VISUAL_MODEL_COMPONENT_TAG);
        		
        		this.visualFrameTexture = itemstack.getTagCompound().getInteger(rf.VISUAL_FRAME_TEXTURE_TAG);
        		this.visualFrameTransparent = itemstack.getTagCompound().getBoolean(rf.VISUAL_FRAME_TRANSPARENT_TAG);
        		this.visualFrameColor = itemstack.getTagCompound().getBoolean(rf.VISUAL_FRAME_COLOR_TAG);
        		this.visualFrameColorRed = itemstack.getTagCompound().getInteger(rf.VISUAL_FRAME_COLOR_RED_TAG);
        		this.visualFrameColorGreen = itemstack.getTagCompound().getInteger(rf.VISUAL_FRAME_COLOR_GREEN_TAG);
        		this.visualFrameColorBlue = itemstack.getTagCompound().getInteger(rf.VISUAL_FRAME_COLOR_BLUE_TAG);
        		
        		this.visualEngineParticle = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_PARTICLE_TAG);
        		this.visualEngineDisplayType = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_TYPE_TAG);
        		this.visualEngineDisplayItemstack = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG);
        		this.visualEngineDisplayItemstackMeta = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG);
        		this.visualEngineDisplayHead = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_HEAD_TAG);
        		this.visualEngineDisplaySupporterHead = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG);
        		this.visualEngineDisplayHoliday = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG);
        		
        		this.visualComponentTexture = itemstack.getTagCompound().getInteger(rf.VISUAL_COMPONENT_TEXTURE_TAG);
        		this.visualComponentTransparent = itemstack.getTagCompound().getBoolean(rf.VISUAL_COMPONENT_TRANSPARENT_TAG);
        		this.visualComponentColor = itemstack.getTagCompound().getBoolean(rf.VISUAL_COMPONENT_COLOR_TAG);
        		this.visualComponentColorRed = itemstack.getTagCompound().getInteger(rf.VISUAL_COMPONENT_COLOR_RED_TAG);
        		this.visualComponentColorGreen = itemstack.getTagCompound().getInteger(rf.VISUAL_COMPONENT_COLOR_GREEN_TAG);
        		this.visualComponentColorBlue = itemstack.getTagCompound().getInteger(rf.VISUAL_COMPONENT_COLOR_BLUE_TAG);
        		
        		
        		
        		this.storedInventory = itemstack.getTagCompound().getCompoundTag(rf.MACHINE_SLOTS_TAG);
        		
        		this.customName = itemstack.getTagCompound().getString(rf.CUSTOM_NAME_TAG);
        		this.visualNameColor = itemstack.getTagCompound().getInteger(rf.VISUAL_NAME_COLOR_TAG);
	        }
        	
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		playerIn.inventory.decrStackSize(playerIn.inventory.currentItem, 1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if(!worldIn.isRemote)
			{
				EntityThrownMachineFlyingAirship entityairship = new EntityThrownMachineFlyingAirship(worldIn, playerIn, 
						
						this.frameTier, this.engineTier, this.componentTier, 
	    				this.type, this.health, this.energy, 
	    				this.broken, this.fuel, this.fuelTotal, 
	    				//this.itemstackFuelItem, this.itemstackFuelSize, 
	    				this.ammoAmount, this.ammoType, 
	    				this.machineEnhancement1, 
	    				
	    				
	    				
	    				this.visualModelFrame, this.visualModelEngine, this.visualModelComponent,
	    				
	    				this.visualFrameTexture, 
	    				this.visualFrameTransparent, this.visualFrameColor,
	    				this.visualFrameColorRed, 
	    				this.visualFrameColorGreen, 
	    				this.visualFrameColorBlue,
	    				
	    				this.visualEngineParticle,
	    				this.visualEngineDisplayType,
	    				this.visualEngineDisplayItemstack,
	    				this.visualEngineDisplayItemstackMeta,
	    				this.visualEngineDisplayHead,
	    				this.visualEngineDisplaySupporterHead,
	    				this.visualEngineDisplayHoliday,
	    				
	    				this.visualComponentTexture, 
	    				this.visualComponentTransparent, this.visualComponentColor,
	    				this.visualComponentColorRed, 
	    				this.visualComponentColorGreen, 
	    				this.visualComponentColorBlue,
	    				
	    	    		this.storedInventory, this.customName, this.visualNameColor
				
	    		);
				
				entityairship.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntity(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}
        
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String colorName = " ";
		
		String itemName = References.localNameVC("item.viesmachines:item_machine_flying_airship.name");
				//this.getUnlocalizedName() + ".name";
		
		
		this.customName = "Airship";
		
		if(stack.hasTagCompound())
    	{
    		this.customName = stack.getTagCompound().getString(rf.CUSTOM_NAME_TAG);
    	}
		
		if(stack.getMetadata() == 0)
		{
			colorName = TextFormatting.GRAY + this.customName;
		}
		if(stack.getMetadata() == 1)
		{
			colorName = TextFormatting.WHITE + this.customName;
		}
		if(stack.getMetadata() == 2)
		{
			colorName = TextFormatting.YELLOW + this.customName;
		}
		if(stack.getMetadata() == 3)
		{
			colorName = TextFormatting.AQUA + this.customName;
		}
		if(stack.getMetadata() == 4)
		{
			colorName = TextFormatting.LIGHT_PURPLE + this.customName;
		}
		if(stack.getMetadata() == 5)
		{
			colorName = TextFormatting.RED + this.customName;
		}
		
		if (stack.hasTagCompound())
		{
			this.broken = stack.getTagCompound().getBoolean(rf.BROKEN_TAG);
		}
		
		String isBroken = "";
		if (this.broken)
		{
			isBroken = "Broken";
		}
		
		
		return 
				itemName
				//this.getPrimaryLabelColor(stack.getMetadata()) + References.Old_I18n.translateToLocalFormatted("vc.main.airship") + TextFormatting.GREEN + " - \'" + colorName + TextFormatting.GREEN + "\'" 
		
		+ " " + isBroken;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		int mainTierCoreInfo = stack.getMetadata();
		int mainTierFrameInfo = 0;
		int mainTierEngineInfo = 0;
		int mainTierBalloonInfo = 0;
		
		int currentRedstoneInfo = 0;
		int currentModuleSlot1Info = 0;
		
		if(stack.hasTagCompound())
    	{
			//mainTierFrameInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_FRAME_TAG);
    		//mainTierEngineInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_ENGINE_TAG);
    		//mainTierBalloonInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_BALLOON_TAG);
    		//currentRedstoneInfo = stack.getTagCompound().getInteger(rf.STORED_REDSTONE_TAG);
    		//currentModuleSlot1Info = stack.getTagCompound().getInteger(rf.MODULE_ACTIVE_SLOT1_TAG);
    	}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//[Hold Shift + Right-Click] to throw this
		tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.airship.1") + this.getSecondaryLabelColor(stack.getMetadata()) + " " + References.localNameVC("vc.item.tt.airship.2"));
		//item and unleash the airship within.
		tooltip.add(this.getSecondaryLabelColor(stack.getMetadata()) + References.localNameVC("vc.item.tt.airship.3"));
		
		if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			//Core : 
			//tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.core") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierCoreInfo) + EnumsVC.MainTierCore.byId(mainTierCoreInfo).getLocalizedName() + TextFormatting.GRAY + ")"
			//		+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.redstone") + TextFormatting.DARK_BLUE + " : "
			//		+ this.getPrimaryLabelColor(mainTierCoreInfo) + EnumsVC.MainTierCore.byId(mainTierCoreInfo).getStoredRedstone());
			////Frame : 
			//tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.frame") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierFrameInfo) + EnumsVC.MainTierFrame.byId(mainTierFrameInfo).getLocalizedName() + TextFormatting.GRAY + ")"
			//		+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.speed") + TextFormatting.DARK_BLUE + " : "
			//		+ this.getPrimaryLabelColor(mainTierFrameInfo) + "+" + mainTierFrameInfo);
			//Engine : 
			//tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.engine") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getLocalizedName() + TextFormatting.GRAY + ")"
			//		+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.fuel") + TextFormatting.DARK_BLUE + " : "
			//		+ this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getFuelPerTick());
			//Balloon : 
			////tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.balloon") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getLocalizedName() + TextFormatting.GRAY + ")"
			//		+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.altitude") + TextFormatting.DARK_BLUE + " : " + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getMaxAltitude());
			
			tooltip.add("");
			//Stored Redstone : 
			if(currentRedstoneInfo == 0)
			{
				tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.storedredstone") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + currentRedstoneInfo);
			}
			else
			{
				tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.storedredstone") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GREEN + currentRedstoneInfo);
			}
			//Current Module : 
			if(currentModuleSlot1Info == 0)
			{
				tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.current") + " " + References.localNameVC("vc.item.module.#") + TextFormatting.DARK_BLUE + " : " + this.getPrimaryLabelColor(currentRedstoneInfo) + "None");
			}
			else
			{
				tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.current") + " " + References.localNameVC("vc.item.module.#") + TextFormatting.DARK_BLUE + " : " + this.getPrimaryLabelColor(currentRedstoneInfo) + TextFormatting.GREEN + EnumsVM.ModuleType.byId(currentModuleSlot1Info).getLocalizedName());
			}
		}
		else
		{
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.shifthelper.0"));
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return this.rarity;
    }
}
