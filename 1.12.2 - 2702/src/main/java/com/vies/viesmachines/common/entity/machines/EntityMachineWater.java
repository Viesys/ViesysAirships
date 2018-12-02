package com.vies.viesmachines.common.entity.machines;

import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.init.LootTableHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

public class EntityMachineWater extends EntityMachineFuel {
	
	//protected static final IAttribute MAX_OXYGEN = (new RangedAttribute((IAttribute)null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
    
	
	
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineWater(World worldIn) 
	{
		super(worldIn);
		
		// Sets a base name if there isn't one:
		if(!this.hasCustomName())
		{
			this.setCustomNameTag("Water Machine");
		}
		
		// Sets width and height:
		this.setWidth = 1.5F;
		this.setHeight = 1.5F;
		
		this.width = this.setWidth;
		this.height = this.setHeight;
		
		this.setSize(this.width, this.height);
	}
	
	public EntityMachineWater(World worldIn, double x, double y, double z,
			
			int frameTierIn, int engineTierIn, int componentTierIn, int typeIn, 
			float healthIn, int energyIn, int durabilityIn, 
			boolean brokenIn, int currentFuelIn, int totalFuelIn, 
			//int itemstackFuelItemIn, int itemstackFuelSizeIn, 
			int ammoAmountIn, int ammoTypeIn, 
			int machineEnhancement1In, 
			
			
			
			int visualModelFrameIn, int visualModelEngineIn, int visualModelComponentIn, 
			
			int visualFrameTextureIn, 
			boolean visualFrameTransparentIn, boolean visualFrameColorIn, 
			int visualFrameColorRedIn, 
			int visualFrameColorGreenIn, 
			int visualFrameColorBlueIn, 
			
			int visualEngineParticleIn, 
			int visualEngineDisplayTypeIn, 
			int visualEngineDisplayItemstackIn, 
			int visualEngineDisplayItemstackMetaIn, 
			int visualEngineDisplayHeadIn, 
			int visualEngineDisplaySupporterHeadIn, 
			int visualEngineDisplayHolidayIn, 
			
			int visualComponentTextureIn, 
			boolean visualComponentTransparentIn, boolean visualComponentColorIn, 
			int visualComponentColorRedIn, 
			int visualComponentColorGreenIn, 
			int visualComponentColorBlueIn, 
			
    		NBTTagCompound compoundIn, String customNameIn, int customNameColorIn)
	{
		this(worldIn);
        this.setPosition(x, y, z);
        
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
		/**
		this.frameTier = frameTierIn;
		this.engineTier = engineTierIn;
		this.componentTier = componentTierIn;
		this.setHealth(currentHPIn);
		this.storedEnergy = currentEPIn;
		this.storedFuel = currentFuelIn;
		this.storedFuelTotal = totalFuelIn;
		this.itemstackFuelItem = itemstackFuelItemIn;
		this.itemstackFuelSize = itemstackFuelSizeIn;
		this.broken = brokenIn;
		this.machineEnhancement1 = machineEnhancement1In;
		
		this.visualTypeModel = visualTypeModelIn;
		this.visualVariantModel = visualVariantModelIn;
		
		this.visualFrameTexture = visualFrameTextureIn;
		this.visualFrameTransparent = visualFrameTransparentIn;
		this.visualFrameColor = visualFrameColorIn;
		this.visualFrameColorRed = visualFrameColorRedIn;
		this.visualFrameColorGreen = visualFrameColorGreenIn;
		this.visualFrameColorBlue = visualFrameColorBlueIn;
		
		this.visualEngineParticle = visualEngineParticleIn;
		this.visualEngineDisplayType = visualEngineDisplayTypeIn;
		this.visualEngineDisplayItemstack = visualEngineDisplayItemstackIn;
		this.visualEngineDisplayItemstackMeta = visualEngineDisplayItemstackMetaIn;
		this.visualEngineDisplayHead = visualEngineDisplayHeadIn;
		this.visualEngineDisplaySupporterHead = visualEngineDisplaySupporterHeadIn;
		this.visualEngineDisplayHoliday = visualEngineDisplayHolidayIn;
		
		this.visualComponentTexture = visualComponentTextureIn;
		this.visualComponentTransparent = visualComponentTransparentIn;
		this.visualComponentColor = visualComponentColorIn;
		this.visualComponentColorRed = visualComponentColorRedIn;
		this.visualComponentColorGreen = visualComponentColorGreenIn;
		this.visualComponentColorBlue = visualComponentColorBlueIn;
		
        this.inventory = new ItemStackHandler(size);
        this.inventory.deserializeNBT(compoundIn);
        
        this.setCustomNameTag(customNameIn);
		this.visualNameColor = visualNameColorIn;
		*/
	}
	
	
	
	//==================================================
    // TODO              Core Inits
	//==================================================
    
	@Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
    }
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
    }
	
	@Override
    protected void entityInit()
    {
        super.entityInit();
    }
	
	
	
	//==================================================
    // TODO            Read/Write Logic
	//==================================================
    
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
    {
		super.writeEntityToNBT(compound);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
		super.readEntityFromNBT(compound);
    }
	
	
	
	//==================================================
    // TODO           Main update logic
	//==================================================
    
	@Override
	public void onUpdate()
    {
		super.onUpdate();
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
    // TODO       Overrides from EntityLiving
	//==================================================
	
	@Override
    protected ResourceLocation getLootTable()
    {
    	return LootTableHandler.MACHINE_WATER;
    }
	
	@Override
    public double getMountedYOffset()
    {
        return 0.15D;
    }
    
    @Override
	public boolean isPushedByWater() 
    {
        return false;
    }
    
    
    
	//==================================================
    // TODO            Movement Logic
	//==================================================
    
    @Override
    public void initiateControlAirship()
    {
    	super.initiateControlAirship();
    	
    	if(this.isBeingRidden())
        {
	        float f1 = 0.0F;
	        
	        if(this.getBroken())//.broken)
			{
	    		
			}
			else
			{
				// Move Up:
		        if (this.upInputDown)
		        {
		        	if(this.status == this.status.IN_AIR
					|| this.status == this.status.ON_LAND
					|| this.status == this.status.IN_WATER)
	        		{
	            		
	        		}
	            	else
	            	{
	            		f1 += this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
	            	}
		        }
		        
		        // Move down:
		        if (this.downInputDown)
		        {
		        	if (this.isFuelNeeded())
					{
						if (this.isFuelBurning())
						{
							f1 -= this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
						}
						else
						{
							
						}
		    		}
					else
					{
						f1 -= this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
					}
		        }
			}
	        
	        // Stops the flying machine Y motion if in liquid:
	        if(this.status == this.status.IN_AIR
			|| this.status == this.status.ON_LAND
			|| this.status == this.status.IN_WATER)
			{
	    		this.motionY = 0;
			}
	        
	        this.motionY += (double)(1.017453292F * f1);
        }
    }
    
    @Override
    public void travel(float strafe, float vertical, float forward)
    {
    	super.travel(strafe, vertical, forward);
    	
    	// Machine downward motion while in the air:
		if(this.status == this.status.IN_AIR)
		{
			this.motionY = -0.25D;
    		
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		}
		
		if(this.isFuelNeeded())
    	{
    		if(!this.isFuelBurning())
    		{
    			if(this.status == this.status.UNDER_WATER
				|| this.status == this.status.UNDER_FLOWING_WATER)
				{
					this.motionY = +0.01D;
		    		
	    			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
				}
    		}
    	}
		
		// Machine upward motion while in lava:
    	if(this.status == this.status.UNDER_LAVA
		|| this.status == this.status.UNDER_FLOWING_LAVA)
		{
    		this.motionY = 0.015D;
	        	
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		}
    	
    	
    	// Animate Limbs:
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d0 = this.posX - this.prevPosX;
        double d1 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt(d0 * d0 + d1 * d1) * 4.0F;
        if (f4 > 1.0F)
            f4 = 1.0F;
        this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
		
    	if (this.isWaterMachine())
    	{
    		
    		
    		
    		// Machine upward motion while broken:
	    	//if(this.broken)
	    	//{
	    	//	if(this.status == this.status.IN_WATER
			//	|| this.status == this.status.UNDER_WATER
			//	|| this.status == this.status.UNDER_FLOWING_WATER)
			//	{
			//		this.motionY = +0.25D;
		    		
	    	//		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			//	}
	    	//}
	    	//else 
	    	//	if(!this.isBeingRidden())
	    	//{
	    	//	if(this.status == this.status.IN_WATER
			//	|| this.status == this.status.UNDER_WATER
			//	|| this.status == this.status.UNDER_FLOWING_WATER)
			//	{
			//		this.motionY = +0.01D;
		    		
	    	//		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			//	}
	    	//}
	    	//else 
	    	
	    	
	    	
	    	
	    	
	    	
	    	
    	}
    }
    
	//==================================================
    // TODO              Custom Logic
	//==================================================
	
    @Override
    protected boolean isFuelNeeded()
	{
		return true;
	}
    
    @Override
    public boolean isWaterMachine()
    {
		return true;
    }
	
	@Override
	protected void damageMachineByStatus()
    {
		super.damageMachineByStatus();
		
		if(this.getHealth() > 0.0F)
    	{
			
    	}
    }
	
	public PotionEffect passiveAbility()
	{
		LogHelper.info("here0");
		/**
		if (this.getRidingEntity() instanceof Entity)
		{
			EntityPlayer player = (EntityPlayer) this.getRidingEntity();
			LogHelper.info("here1");
			
			if (!player.isPotionActive(Potion.getPotionById(16)))
			{
				LogHelper.info("here2");
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 1, 1, true, false));
			}
		}
		
		*/
		return new PotionEffect(Potion.getPotionById(16), 500, 10, true, false);
	}
}
