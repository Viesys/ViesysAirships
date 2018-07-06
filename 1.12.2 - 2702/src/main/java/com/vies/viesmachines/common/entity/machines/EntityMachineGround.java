package com.vies.viesmachines.common.entity.machines;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMachineGround extends EntityMachineFuel {
	
	protected static final IAttribute JUMP_STRENGTH = (new RangedAttribute((IAttribute)null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
    
    /** Has this machine jumped in the air? */
	protected boolean machineJumping;
    
	protected float jumpPower;
    
    
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineGround(World worldIn) 
	{
		super(worldIn);
		
		// Sets a base name if there isn't one:
		if(!this.hasCustomName())
		{
			this.setCustomNameTag("Ground Machine");
		}
		
		// Sets width and height:
		this.setWidth = 1.5F;
		this.setHeight = 0.5F;
		
		this.width = this.setWidth;
		this.height = this.setHeight;
		
		this.setSize(this.width, this.height);
		
	}
	
	public EntityMachineGround(World worldIn, double x, double y, double z) 
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
        return 0.15D;
    }
    
    
    
	//==================================================
    // TODO            Movement Logic
	//==================================================
	
    @Override
    public void controlAirship()
    {
    	super.controlAirship();
    	
    	if (this.isBeingRidden())
    	{
    		if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())
        	{
        		if (!this.machineJumping)
        		{
        			this.motionY = 0.2;
        			
        			this.machineJumping = true;
        		}
        	}
    	}
    }
    
    @Override
    public void travel(float strafe, float vertical, float forward)
    {
    	super.travel(strafe, vertical, forward);
    	
    	if(!this.isBlockUnderEntityAir())
    	{
    		if(this.machineJumping)
			{
    			this.machineJumping = false;
			}
    	}
    	
    	if(this.isBeingRidden())
    	{
	    	if(this.isFuelNeeded())
	    	{
	    		if(this.isFuelBurning())
	    		{
	    			
	    			if(this.isBlockUnderEntityAir())
	    	    	{
	    				this.motionY -= 0.005F;
	    	    		
	    	    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	    	    	}
	    			else
	    	    	{
	    				this.motionY += 0.005F;
	    	    		
	    	    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	    	    	}
	    		}
	    		else
	    		{
	    			
	    		}
	    	}
	    	else
	    	{
	    		if(this.isBlockUnderEntityAir())
		    	{
		    		this.motionY -= 0.005F;
		    		
		    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		    	}
				else
		    	{
		    		this.motionY += 0.005F;
		    		
		    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		    	}
	    	}
    	}
    	else
    	{
    		this.motionY -= 0.005F;
    		
    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
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
    public boolean isGroundMachine()
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
	
	
	
	
}
