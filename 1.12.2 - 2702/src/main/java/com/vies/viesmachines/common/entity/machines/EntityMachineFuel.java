package com.vies.viesmachines.common.entity.machines;

import javax.annotation.Nullable;

import com.vies.viesmachines.api.FuelVC;
import com.vies.viesmachines.api.ItemsVC;
import com.vies.viesmachines.api.SoundsVC;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.configs.VMConfiguration;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityMachineFuel extends EntityMachineBase {
	
	// Data Manager:
	/** Keeps track of the stored fuel. */
	private static final DataParameter<Integer> STORED_FUEL = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the total stored fuel. */
	private static final DataParameter<Integer> STORED_FUEL_TOTAL = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the item in the fuel slot. */
	private static final DataParameter<Integer> ITEMSTACK_FUEL_ITEM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the stack size in the fuel slot. */
	private static final DataParameter<Integer> ITEMSTACK_FUEL_SIZE = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
  	
	// Fuel:
	/** Stored fuel. */
	public int storedFuel;
	/** Total stored fuel. */
	public int storedFuelTotal;
	
    /** The int ID of the item in the fuel slot. */
    public int itemstackFuelItem;
    /** The stack size of the itemstack in the fuel slot. */
    public int itemstackFuelSize;
    
	
	
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineFuel(World worldIn) 
	{
		super(worldIn);
	}
	
	public EntityMachineFuel(World worldIn, double x, double y, double z) 
	{
		this(worldIn);
	}
    
    
    
	//==================================================
    // TODO              Core Inits
	//==================================================
    
	@Override
    protected void entityInit()
    {
        super.entityInit();
        
        this.dataManager.register(STORED_FUEL, Integer.valueOf(this.storedFuel));
        this.dataManager.register(STORED_FUEL_TOTAL, Integer.valueOf(this.storedFuelTotal));
        
        this.dataManager.register(ITEMSTACK_FUEL_ITEM, Integer.valueOf(this.itemstackFuelItem));
        this.dataManager.register(ITEMSTACK_FUEL_SIZE, Integer.valueOf(this.itemstackFuelSize));
    }
	
	
	
	//==================================================
    // TODO            Read/Write Logic
	//==================================================
    
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
    {
		super.writeEntityToNBT(compound);
		
		compound.setInteger(rf.STORED_FUEL_TAG, this.storedFuel);
		compound.setInteger(rf.STORED_FUEL_TOTAL_TAG, this.storedFuelTotal);
		compound.setInteger(rf.ITEMSTACK_FUEL_ITEM_TAG, this.itemstackFuelItem);
		compound.setInteger(rf.ITEMSTACK_FUEL_SIZE_TAG, this.itemstackFuelSize);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
		super.readEntityFromNBT(compound);

		this.storedFuel = compound.getInteger(rf.STORED_FUEL_TAG);
		this.storedFuelTotal = compound.getInteger(rf.STORED_FUEL_TOTAL_TAG);
		this.itemstackFuelItem = compound.getInteger(rf.ITEMSTACK_FUEL_ITEM_TAG);
		this.itemstackFuelSize = compound.getInteger(rf.ITEMSTACK_FUEL_SIZE_TAG);
    }
	
	
	
	//==================================================
    // TODO           Main update logic
	//==================================================
    
	@Override
	public void onUpdate()
    {
		super.onUpdate();
        
		if (this.isFuelNeeded())
		{
			this.fuelSystem();
		}
		
		if (!this.world.isRemote)
		{
			if (!this.inventory.getStackInSlot(0).isEmpty())
			{
				this.itemstackFuelSize = this.inventory.getStackInSlot(0).getCount();
			}
			else
			{
				this.itemstackFuelSize = 0;
			}
		}
    }
	
	@Override
	public void onEntityUpdate()
    {
        super.onEntityUpdate();
    }
	
	@Override
	public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }
	
	
	
	//==================================================
    // TODO              Sound Events
	//==================================================
	
	/**
	 * Gets the sound to be triggered when a machine is on/powered.
	 */
	@Nullable
    protected SoundEvent getOnSound(DamageSource damageSourceIn)
    {
        return SoundsVC.ENGINEON;
    }
	

	/**
	 * Plays the on/powered sound.
	 */
	protected void playOnSound(DamageSource source)
    {
        SoundEvent soundevent = this.getOnSound(source);

        if (soundevent != null)
        {
            this.playSound(soundevent, this.getSoundVolume(), this.getSoundPitch());
        }
    }
    
    
    
	//==================================================
    // TODO               Data Logic
	//==================================================
    
    @Override
	protected void dataSync()
    {
		super.dataSync();
		
    	if(this.world.isRemote)
        {
        	this.storedFuel = this.getStoredFuel();
        	this.storedFuelTotal = this.getStoredFuelTotal();
        	this.itemstackFuelItem = this.getItemstackFuelItem();
        	this.itemstackFuelSize = this.getItemstackFuelSize();
        }
        else
        {
        	this.setStoredFuel(this.storedFuel);
        	this.setStoredFuelTotal(this.storedFuelTotal);
        	this.setItemstackFuelItem(this.itemstackFuelItem);
        	this.setItemstackFuelSize(this.itemstackFuelSize);
        }
    }
	
    
	
	/**
     * Sets the machine stored fuel.
     */
    public void setStoredFuel(int intIn)
    {
        this.dataManager.set(STORED_FUEL, Integer.valueOf(intIn));
    }
    /**
     * Gets the machine stored fuel.
     */
    public int getStoredFuel()
    {
        return ((Integer)this.dataManager.get(STORED_FUEL)).intValue();
    }
    
    //--------------------------------------------------
    
    /**
     * Sets the machine total stored fuel.
     */
    public void setStoredFuelTotal(int intIn)
    {
        this.dataManager.set(STORED_FUEL_TOTAL, Integer.valueOf(intIn));
    }
    /**
     * Gets the machine total stored fuel.
     */
    public int getStoredFuelTotal()
    {
        return ((Integer)this.dataManager.get(STORED_FUEL_TOTAL)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Itemstack Fuel Item. */
    protected void setItemstackFuelItem(int intIn)
    {
        this.dataManager.set(ITEMSTACK_FUEL_ITEM, Integer.valueOf(intIn));
    }
    /** Gets the Itemstack Fuel Item. */
    protected int getItemstackFuelItem()
    {
        return ((Integer)this.dataManager.get(ITEMSTACK_FUEL_ITEM)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Itemstack Fuel Size. */
    protected void setItemstackFuelSize(int intIn)
    {
        this.dataManager.set(ITEMSTACK_FUEL_SIZE, Integer.valueOf(intIn));
    }
    /** Gets the Itemstack Fuel Size. */
    protected int getItemstackFuelSize()
    {
        return ((Integer)this.dataManager.get(ITEMSTACK_FUEL_SIZE)).intValue();
    }
    
    
    
    //==================================================
    // TODO              Fuel Logic
	//==================================================
    
    /**
     * Core fuel logic responsible for machine movement.
     */
	public void fuelSystem()
    {
    	boolean flag = this.isFuelBurning();
        boolean flag1 = false;
        
        // Sets burn time to 0 so a fraction isn't left:
        if(this.storedFuel <= this.getBaseFuelTick())
        {
        	this.storedFuel = 0;
        }
        
        // Handles how stored fuel is ticked down:
        if(this.isFuelBurning())
        {
        	// Creative players don't consume fuel:
        	if (this.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.getControllingPassenger();
        		
        		if (player.isCreative())
        		{
        			
        		}
            	else 
            	{
            		this.storedFuel = this.storedFuel - this.getBaseFuelTick();
            	}
        	}
        	else 
        	{
        		this.storedFuel = this.storedFuel - this.getBaseFuelTick();
        	}
        }
        
        // Handles when the airship is off:
        if(!this.isFuelBurning())
        {
        	this.storedFuel = 0;
        }
        
        // Clears stored fuel if the machine is broken:
        if (this.broken)
        {
        	this.storedFuel = 0;
        }
        
        // Server side fuel logic:
        if(!this.world.isRemote)
        {
        	ItemStack fuelSlot = this.inventory.getStackInSlot(0);
        	
	        // Core fuel slot logic:
	        if(this.isFuelBurning() || !fuelSlot.isEmpty())
	        {
	            if(!this.isFuelBurning()
	            && this.getControllingPassenger() != null)
	            {
	                this.storedFuel = getItemBurnTime(fuelSlot);
	                this.storedFuelTotal = getItemBurnTime(fuelSlot);
	                
	                if(this.isFuelBurning())
	                {
	                    flag1 = true;
	                    
	                    // Consumes the fuel item:
	                    if(!fuelSlot.isEmpty())
	                    {
	                    	if (!this.broken)
	                    	{
	                    		this.itemstackFuelItem = this.inventory.getStackInSlot(0).getItem().getIdFromItem(this.inventory.getStackInSlot(0).getItem());
	                    		
	                    		this.inventory.extractItem(0, 1, false);
	                    		
	                    		this.itemstackFuelSize = this.inventory.getStackInSlot(0).getCount();
	                    	}
	                    }
	                }
	            }
	        }
        }
        
        if(flag != this.isFuelBurning())
        {
            flag1 = true;
        }
        
        if (!this.world.isRemote
        && this.isFuelBurning()
        && !this.broken
        //&& this.engineOnSoundSpeed > 0 
        && this.ticksExisted % 5 == 0)
        {
        	this.playOnSound(null);
        }
    }
    
    /**
     * Is the machine burning fuel?
     */
	@Override
    public boolean isFuelBurning()
    {
		if (this.getControllingPassenger() instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) this.getControllingPassenger();
    		
    		if (player.isCreative())
    		{
    			return true;
    		}
    	}
    	
    	if(this.storedFuel > 0)
    	{
    		return true;
    	}
    	
    	return super.isFuelBurning();
    }
    
    /**
     * Returns the number of ticks that the supplied item will keep the machine on for, or 0 if the item isn't fuel.
     */
    public static int getItemBurnTime(ItemStack stack)
    {
        if(stack.isEmpty())
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            //KEEP FOR ENERGY SYSTEM EVENTUALLY:
            //DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER , null);
            
            if(VMConfiguration.vanillaFuel)
    		{
	            if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
	            {
	                Block block = Block.getBlockFromItem(item);
	                
	                if(block == Blocks.WOODEN_SLAB)
	                {
	                    return FuelVC.wooden_slab;
	                }
	                
	                if(block.getDefaultState().getMaterial() == Material.WOOD)
	                {
	                    return FuelVC.wood_block_material;
	                }
	                
	                if(block == Blocks.COAL_BLOCK)
	                {
	                    return FuelVC.coal_block;
	                }
	            }
	            
	            if(item == Items.STICK) return FuelVC.stick;
	            if(item == Item.getItemFromBlock(Blocks.SAPLING)) return FuelVC.sapling;
	            if(item == Items.COAL) return FuelVC.coal;
	            if(item == Items.BLAZE_ROD) return FuelVC.blaze_rod;
	            
	            if(item == Items.LAVA_BUCKET) return 20000;
    		}
            
            if(item == ItemsVC.MACHINE_PELLETS) return (VMConfiguration.machinePelletsBurnTime * 20
            		//ViesCraftConfig.viesolineBurnTime
            		//* 20
            		);
            
            //KEEP FOR ENERGY SYSTEM EVENTUALLY:
            //if (item == InitItemsVC.airship_battery) return cap.getEnergyStored();
            
            if(VMConfiguration.outsideModFuel)
    		{
            	return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
    		}
            else
            {
            	return 0;
            }
        }
    }
    
    /**
     * Simple check to see if an item is fuel.
     */
    public static boolean isItemFuel(ItemStack stack)
    {
        return getItemBurnTime(stack) > 0;
    }
    
    /**
     * Calculates total fuel burn time by stack size for GUI.
     *
    public void getTotalFuelSlotBurnTime()
    {
    	if(this.getControllingPassenger() != null)
    	{
    		if(this.isFuelBurning())
            {
    			ItemStack itemFuel = this.inventory.getStackInSlot(0);
    			
    			if(!itemFuel.isEmpty())
    			{
    				this.fuelItemStackSize = this.inventory.getStackInSlot(0).getCount();
    					
    				this.fuelItemStack = this.fuelItemStackSize * this.getItemBurnTime(this.inventory.getStackInSlot(0));
    			}
    			else
    			{
    				this.fuelItemStack = 0;
    				this.fuelItemStackSize = 0;
    			}
            }
    		else
    		{
    			this.fuelItemStack = 0;
    			this.fuelItemStackSize = 0;
    		}
    	}
    }
    
    /**
     * This calculates how much fuel is used per tick.
     * This is just currently 1 and can change in the future.
     */
    protected int getBaseFuelTick()
    {
    	int fuelTick;
    	
    	fuelTick = 1;
    	
    	return fuelTick;
    }
    
    
    
	//==================================================
    // TODO              GUI Logic
	//==================================================
	
    /**
     * Set variables to pass through fields, used in the CLIENT GUI.
     */
    public void setField(int id, int value)
    {
        switch (id)
        {
        	case 0:
                this.storedFuel = value;
                break;
            case 1:
            	this.storedFuelTotal = value;
                break;
            default:
            	break;
        }
    }
    
    /**
     * Gets variables to pass through fields, used in the CLIENT GUI.
     */
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.storedFuel;
            case 1:
                return this.storedFuelTotal;
            default:
                return 0;
        }
    }
}
