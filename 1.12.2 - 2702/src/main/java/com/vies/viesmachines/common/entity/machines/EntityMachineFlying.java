package com.vies.viesmachines.common.entity.machines;

import com.vies.viesmachines.api.EnumsVC;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.LogHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityMachineFlying extends EntityMachineFuel {
	
	protected static final IAttribute MAX_ALTITUDE = (new RangedAttribute((IAttribute)null, References.MOD_ID + ".maxAltitude", 0.7D, 0.0D, 2.0D)).setDescription("Max Altitude").setShouldWatch(true);
    
	
	
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineFlying(World worldIn) 
	{
		super(worldIn);
		
		// Sets a base name if there isn't one:
		if(!this.hasCustomName())
		{
			this.setCustomNameTag("Flying Machine");
		}
		
		// Sets width and height:
		this.setWidth = 1.5F;
		this.setHeight = 0.75F;
		
		this.width = this.setWidth;
		this.height = this.setHeight;
		
		this.setSize(this.width, this.height);
	}
	
	public EntityMachineFlying(World worldIn, double x, double y, double z) 
	{
		this(worldIn);
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
    public double getMountedYOffset()
    {
        return 0.25D;//0.15D;
    }
    
    
    
	//==================================================
    // TODO            Movement Logic
	//==================================================
    
    @Override
    public void controlAirship()
    {
    	super.controlAirship();
    	
    	
    	
    	if(this.isBeingRidden())
        {
	        float f1 = 0.0F;
	        
	        if(this.broken)
			{
	    		
			}
			else
			{
				// Move Up:
		        if (this.upInputDown)
		        {
		        	// Do nothing if the elevation limit is mixed:
		        	if (this.flyingElevationLimit())
		        	{
		        		LogHelper.info("Here!");
		        	}
		        	else
		        	{
		        		
		        		if (this.isFuelNeeded())
						{
							if (this.isFuelBurning())
							{
								f1 += this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
							}
							else
							{
								
							}
			    		}
						else
						{
							f1 += this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
						}
		        	}
		        }
		        
		        // Move down:
		        if (this.downInputDown)
		        {
		        	// Stops the flying machine down input if in liquid:
		        	if(this.status == this.status.IN_WATER
					|| this.status == this.status.UNDER_WATER
					|| this.status == this.status.UNDER_FLOWING_WATER
					|| this.status == this.status.IN_LAVA
					|| this.status == this.status.UNDER_LAVA
					|| this.status == this.status.UNDER_FLOWING_LAVA)
	        		{
	            		
	        		}
	            	else
	            	{
	            		f1 -= this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
	            	}
		        }
			}
	        
	        // Stops the flying machine Y motion if in liquid or max elevation is exceeded.:
	        if(this.status == this.status.IN_WATER
			|| this.status == this.status.UNDER_WATER
			|| this.status == this.status.UNDER_FLOWING_WATER
			|| this.status == this.status.IN_LAVA
			|| this.status == this.status.UNDER_LAVA
			|| this.status == this.status.UNDER_FLOWING_LAVA
			|| this.flyingElevationLimit())
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
    	if(this.broken)
    	{
    		if(this.status == this.status.IN_AIR)
			{
				this.motionY = -0.25D;
	    		
    			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			}
    	}
    	// Machine downward motion while in above the max elevation:
    	else if (this.flyingElevationLimit())
    	{
    		if(this.status == this.status.IN_AIR)
			{
				this.motionY = -0.025D;
	    		
    			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			}
    	}
    	// Machine downward motion while no being ridden:
    	else if(!this.isBeingRidden())
    	{
    		if(this.status == this.status.IN_AIR)
			{
				this.motionY = -0.01D;
	    		
    			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			}
    	}
    	// Machine downward motion while there is no fuel when the fuel system is enabled:
    	else if(this.isFuelNeeded())
    	{
    		if(!this.isFuelBurning())
    		{
    			if(this.status == this.status.IN_AIR)
    			{
    				this.motionY = -0.01D;
    	    		
        			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
    			}
    		}
    	}
    	
    	
    	
    	// Machine upward motion while in water:
    	if(this.status == this.status.UNDER_WATER
		|| this.status == this.status.UNDER_FLOWING_WATER)
		{
    		this.motionY = 0.05D;
	        	
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
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
    public boolean isFlyingMachine()
    {
		return true;
    }
	
	@Override
	protected void damageMachineByStatus()
    {
		super.damageMachineByStatus();
		
		if(this.getHealth() > 0.0F)
    	{
			if(this.status == this.status.UNDER_WATER
			|| this.status == this.status.UNDER_FLOWING_WATER)
			{
				this.attackEntityFrom(DamageSource.DROWN, 0.5F);
			}
    	}
    }
    
    /**
     * Flying elevation restrictions.
     */
    protected boolean flyingElevationLimit()
    {
    	Boolean maxHeightReached;
    	
    	int airshipHeight = this.getPosition().getY();
    	if(airshipHeight > //EnumsVC.MainTierBalloon.byId(
    			75//this.getMainTierBalloon()
    			//).getMaxAltitude()
    			)
    	{
    		maxHeightReached = true;
    	}
    	else
    	{
    		maxHeightReached = false;
    	}
		
		return maxHeightReached;
    }
}
