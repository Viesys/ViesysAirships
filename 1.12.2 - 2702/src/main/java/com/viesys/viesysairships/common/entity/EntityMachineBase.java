package com.viesys.viesysairships.common.entity;

import java.util.List;

import javax.annotation.Nullable;

import com.viesys.viesysairships.api.EnumsVC;
import com.viesys.viesysairships.api.util.Keybinds;
import com.viesys.viesysairships.api.util.LogHelper;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class EntityMachineBase extends EntityLiving {
	
	public static final IAttribute DEFENSE = (new RangedAttribute(null, "generic.defense", 4.0D, 0.0D, 1024.0D)).setShouldWatch(true);
	public static final IAttribute RANGED_SPEED = (new RangedAttribute(null, "generic.rangedSpeed", 4.0D, 0.0D, 1024.0D)).setShouldWatch(true);

	
	/** How much of current speed to retain. Value zero to one. */
	protected float momentum;
	
	/**
	 * SLOTS: <br> <br>
	 *
	 * Slot  0 = Fuel <br>
	 * Slot  1 = Upgrade Core <br>
	 * Slot  2 = Upgrade Frame <br>
	 * Slot  3 = Upgrade Engine <br>
	 * Slot  4 = Upgrade Balloon <br>
	 * Slot 11 = Module Slot1 <br>
	 * Slot 12 = Module Slot2 <br>
	 * Slot 16 = Redstone Slot <br>
	 * Slot 18 = Block/Item to Display <br>
	 * Slot 20-28 = Inventory Small <br>
	 * Slot 20-37 = Inventory Large <br>
	 * Slot 51 = Bomb Slot1 <br>
	 */
    public ItemStackHandler inventory;
    protected int size = 64;
    
    protected float deltaRotation;
    
  //Movement
    public boolean leftInputDown;
    public boolean rightInputDown;
    public boolean forwardInputDown;
    public boolean backInputDown;
    protected boolean upInputDown;
    protected boolean downInputDown;
    protected boolean openInputDown;
    protected boolean dropBombInputDown;
    
	public EntityMachineBase(World worldIn) 
	{
		super(worldIn);

        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        
        this.setSize(0.9F, 0.4F);
        
        this.inventory = new ItemStackHandler(size);
	}
	
	public EntityMachineBase(World worldIn, double x, double y, double z) 
	{
		this(worldIn);
        this.setPosition(x, y + 0.5D, z);
        
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        
        
	}
	
	
	
	@Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }
	
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) inventory;
        return super.getCapability(capability, facing);
    }
    
    
	
	@Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
    	
    }
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
    }
	
	@Override
    protected void entityInit()
    {
        super.entityInit();
        
    }
	
	@Override
	public void onEntityUpdate()
    {
        super.onEntityUpdate();
        
    }
	
	@Override
	public void onUpdate()
    {
		
		this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        
        super.onUpdate();

        //this.setNoGravity(true);
        
        
        if (this.canPassengerSteer())
        {
        	this.updateMotion();
        	this.controlAirship();
        	//this.dropBomb();
        	
        	if (this.world.isRemote)
            {
        		this.updateInputs();
        		//this.controlAirshipGui();
            }
        	
        	this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        }
        else
        {
        	this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
        }
        
        this.doBlockCollisions();
        List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(0.20000000298023224D, -0.009999999776482582D, 0.20000000298023224D), EntitySelectors.<Entity>getTeamCollisionPredicate(this));
        
        if (!list.isEmpty())
        {
            boolean flag = !this.world.isRemote && !(this.getControllingPassenger() instanceof EntityPlayer);
            
            for (int j = 0; j < list.size(); ++j)
            {
                Entity entity = (Entity)list.get(j);
                
                if (!entity.isPassenger(this))
                {
                	if (flag && this.getPassengers().size() < 2 && !entity.isRiding() && entity.width < this.width && entity instanceof EntityLivingBase && !(entity instanceof EntityWaterMob) && !(entity instanceof EntityPlayer))
                    if (flag && this.getPassengers().size() < 1 && !entity.isRiding() && entity.width < this.width && entity instanceof EntityLivingBase && !(entity instanceof EntityWaterMob) && !(entity instanceof EntityPlayer))
                    {
                        entity.startRiding(this);
                    }
                    else
                    {
                        this.applyEntityCollision(entity);
                    }
                }
            }
        }
        
    }
	
	@Override
	public void onLivingUpdate()
    {
        //super.onLivingUpdate();
        
    }
	
	@Override
	protected boolean canDespawn()
    {
        return false;
    }
    
    @Override
    @Nullable
    public Entity getControllingPassenger()
    {
        List<Entity> list = this.getPassengers();
        return list.isEmpty() ? null : (Entity)list.get(0);
    }
    
    
    @Override
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }
    
    @Override
    @Nullable
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return entityIn.canBePushed() ? entityIn.getEntityBoundingBox() : null;
    }
    
    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox()
    {
        return this.getEntityBoundingBox();
    }
    
    @Override
    public boolean canBePushed()
    {
        return false;
    }
    
    @Override
    public double getMountedYOffset()
    {
        return 0.15D;
    }
	
	@Override
	@Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        return super.onInitialSpawn(difficulty, livingdata);
        
    }
	
	@Override
	public boolean canBeSteered()
    {
        return true;
    }
	
	@Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand)
    {
		if(this.world.isRemote)
    	{
    		Keybinds.vcInventory.unPressAllKeys();
    	}
    	
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            if (!this.world.isRemote 
            		//&& this.outOfControlTicks < 60.0F
            		)
            {
                player.startRiding(this);
            }
            
            return true;
        }
    }
    
    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
	/*
	@Override
	public int getMaxFallHeight()
    {
        return 0;
    }
	*/
	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
        //super.updateFallState(y, onGroundIn, state, pos);
    }
	/**
	@Override
	public void fall(float distance, float damageMultiplier)
    {
		
    }
	*/
	@Override
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
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
	
	@Override
	@Nullable
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_GENERIC_HURT;
    }

	@Override
	@Nullable
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GENERIC_DEATH;
    }

	@Override
	protected SoundEvent getFallSound(int heightIn)
    {
        return heightIn > 4 ? SoundEvents.ENTITY_GENERIC_BIG_FALL : SoundEvents.ENTITY_GENERIC_SMALL_FALL;
    }
    
	@Override
	public void onDeath(DamageSource cause)
    {
    	super.onDeath(cause);
    	
    }
	
	@Override
	public boolean canBeHitWithPotion()
    {
        return false;
    }
    
    @Override
    public boolean attackable()
    {
        return false;
    }
    

    
    @Override
    protected boolean canFitPassenger(Entity passenger)
    {
        return this.getPassengers().size() < 2;
    }
    
    

    
    @Override
    public void updatePassenger(Entity passenger)
    {
        if (this.isPassenger(passenger))
        {
            float f = 0.0F;
            float f1 = (float)((this.isDead ? 0.009999999776482582D : this.getMountedYOffset()) + passenger.getYOffset());
            
            if (this.getPassengers().size() > 1)
            {
                int i = this.getPassengers().indexOf(passenger);
                
                if (i == 0)
                {
                    f = 0.2F;
                }
                else
                {
                    f = -0.6F;
                }
                
                if (passenger instanceof EntityAnimal)
                {
                    f = (float)((double)f + 0.2D);
                }
            }
            
            Vec3d vec3d = (new Vec3d((double)f, 0.0D, 0.0D)).rotateYaw(-this.rotationYaw * 0.017453292F - ((float)Math.PI / 2F));
            passenger.setPosition(this.posX + vec3d.x, this.posY + (double)f1, this.posZ + vec3d.z);
            passenger.rotationYaw += this.deltaRotation;
            passenger.setRotationYawHead(passenger.getRotationYawHead() + this.deltaRotation);
            this.applyYawToEntity(passenger);
            
            if (passenger instanceof EntityAnimal && this.getPassengers().size() > 1)
            {
                int j = passenger.getEntityId() % 2 == 0 ? 90 : 270;
                passenger.setRenderYawOffset(((EntityAnimal)passenger).renderYawOffset + (float)j);
                passenger.setRotationYawHead(passenger.getRotationYawHead() + (float)j);
            }
        }
    }
    
    /**
     * Applies this boat's yaw to the given entity. Used to update the orientation of its passenger.
     */
    protected void applyYawToEntity(Entity entityToUpdate)
    {
        entityToUpdate.setRenderYawOffset(this.rotationYaw);
        float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);
        float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
        entityToUpdate.prevRotationYaw += f1 - f;
        entityToUpdate.rotationYaw += f1 - f;
        entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void applyOrientationToEntity(Entity entityToUpdate)
    {
        this.applyYawToEntity(entityToUpdate);
    }
    
    
    @Override
    public EnumFacing getAdjustedHorizontalFacing()
    {
        return this.getHorizontalFacing().rotateY();
    }
    
    

	//==================================//
    // TODO     Input Updates           //
	//==================================//
    
    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, Boats, and Airships are generally "steered" by the controlling passenger.
     */
    @SideOnly(Side.CLIENT)
    public void updateInputs()
    {
    	this.leftInputDown = Keybinds.vcLeft.isKeyDown();
        this.rightInputDown = Keybinds.vcRight.isKeyDown();
        this.forwardInputDown = Keybinds.vcForward.isKeyDown();
        this.backInputDown = Keybinds.vcBack.isKeyDown();
        this.upInputDown = Keybinds.vcUp.isKeyDown();
        this.downInputDown = Keybinds.vcDown.isKeyDown();
        this.openInputDown = Keybinds.vcInventory.isPressed();
        this.dropBombInputDown = Keybinds.vcDropBomb.isPressed();
    }
    
    
    
    
    
    //@Override
    public void controlAirship()
    {
    	if(this.isBeingRidden())
        {
            float f = 0.0F;
            float f1 = 0.0F;
            
            //Turning Left
            if(this.leftInputDown)
            {
            	/**if(isFuelBurning())
            	{
            		if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 4));
                    }
            		else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 8));
                    }
            		else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 12));
                    }
            		else
            		{
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() * 2));
            		}
            	}
            	else
            	*/{
            		this.deltaRotation -= 0.05;//(finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() * 4)) * 0.5F;
            	}
            }
            
            //Turning Right
            if (this.rightInputDown)
            {
            	/**if(isFuelBurning())
            	{
            		if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 4));
                    }
            		else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 8));
                    }
            		else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 12));
                    }
            		else
            		{
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() * 2));
            		}
            	}
            	else
            	*/{
            		this.deltaRotation += 0.05;
            				//(finalAirshipSpeedTurn + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() * 4)) * 0.5F;
            	}
            }
            
            if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
            {
                f += 0.005F;
            }
            
            this.rotationYaw += this.deltaRotation;
            /**
            //Move Forward
            //Cruise Control
            if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
            {
            	if(this.forwardInputDown)
	            {
            		if(this.metaCruiseControlSelectedSpeed < 3)
	            	{
	            		this.metaCruiseControlSelectedSpeed++;
	            	}
	            	else
	            	{
	            		this.metaCruiseControlSelectedSpeed = 3;
	            	}
            		
            		this.setCruiseControlSelectedSpeed(this.metaCruiseControlSelectedSpeed);
	            	
	            	if(isFuelBurning())
	        		{
	        			
	        		}
	            	else
	            	{
	            		f += 0.003F;
	            	}
	            }
            }
            else
            *{
            	*/
            	if(this.forwardInputDown)
	            {
	            	/**if(isFuelBurning())
	        		{
	        			f += finalAirshipSpeedForward + EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier;
	        		}
	            	else
	            	*/
            		{
	            		f += this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue();//0.03F;
	            	}
	            }
            //}
            
            	
            	LogHelper.info("Speed = " + this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue());
            //Moving Backwards
            //Cruise Control
           /** if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
            {
            	if(this.backInputDown)
	            {
	            	if(this.metaCruiseControlSelectedSpeed > 0)
	            	{
	            		this.metaCruiseControlSelectedSpeed--;
	            	}
	            	else
	            	{
	            		this.metaCruiseControlSelectedSpeed = 0;
	            	}
	            	
            		this.setCruiseControlSelectedSpeed(this.metaCruiseControlSelectedSpeed);
	            	
		            if(isFuelBurning())
	        		{
	        			f -= (finalAirshipSpeedForward + EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier) * 0.5;
	        		}
	            	else
	            	{
	            		f -= 0.003F * 0.5;
	            	}
	            }
            }
            else
            *{
	         */   if (this.backInputDown)
	            {
	            	/**if(isFuelBurning())
	        		{
	        			f -= (finalAirshipSpeedForward + EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier) * 0.5;
	        		}
	            	else
	            	*/{
	            		f -= 0.003F * 0.5;
	            	}
	            }
            //}
            
            //Handles forward movement with the Cruise Control Module
            /**if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
            {
            	if(isFuelBurning()
            	&& this.getControllingPassenger() != null)
        		{
            		switch(this.metaCruiseControlSelectedSpeed)
	            	{
		            	case 0:
		            		f += 0F;
		            		break;
		            	case 1:
		            		f += (finalAirshipSpeedForward + EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier) / 4;
		            		break;
		            	case 2:
		            		f += (finalAirshipSpeedForward + EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier) / 2;
		            		break;
		            	case 3:
		            		f += finalAirshipSpeedForward + EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier;
		            		break;
	            	}
        		}
            	else
            	{
            		f += 0F;
            	*}*/
            //}
            
            //Moving Up
            if (this.upInputDown)
            {
            	/**if(isFuelBurning())
        		{
        			if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
                    {
        				f1 += finalAirshipSpeedUp + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 14);
                    }
                	else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
                    {
                		f1 += finalAirshipSpeedUp + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 8);
                    }
                	else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
                    {
                		f1 += finalAirshipSpeedUp + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 4);
                    }
                	else if(!this.airshipHeightLimit())
	    			*/{
                		f1 += 0.05
                				//finalAirshipSpeedUp + 
                				//(EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 32)
                				;
	    			}
        		//}
            }
            
            //Moving down
            if (this.downInputDown)
            {
                f1 -= 0.05;//finalAirshipSpeedDown + (EnumsVC.MainTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 4) + (this.speedModifier / 4);
            }
            
            this.motionX += (double)(MathHelper.sin(-this.rotationYaw * 0.017453292F) * f);
            this.motionZ += (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * f);
            this.motionY += (double)(3.017453292F * f1);
            
            this.rotationPitch += 10;
        }
    }
    
    
    //@Override
    public void updateMotion()
    {
        double d0 = 0.0D;
        double d5 = -0.0005D;
        this.momentum = 0.05F;
        
        /**if(this.previousStatus == EntityAirshipBaseVC.Status.IN_AIR 
		&& this.status != EntityAirshipBaseVC.Status.IN_AIR 
		&& this.status != EntityAirshipBaseVC.Status.ON_LAND)
        {
            this.waterLevel = this.getEntityBoundingBox().minY + (double)this.height;
            this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
            this.motionY = 0.0D;
            this.lastYd = 0.0D;
            this.status = EntityAirshipBaseVC.Status.IN_WATER;
        }
        else
        {
            if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_LESSER.getMetadata())
            {
            	this.momentum = 0.45F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata())
            {
            	this.momentum = 0.67F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
            	this.momentum = 0.9F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER 
        	  || this.status == EntityAirshipBaseVC.Status.UNDER_WATER)
            {
            	if(this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_LESSER.getMetadata()
        		|| this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
        		|| this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            	{
            		this.waterPartsDrop();
            	}
            }
            else if (this.status == EntityAirshipBaseVC.Status.IN_AIR
            	  || this.status == EntityAirshipBaseVC.Status.ON_LAND)
            {
            	this.momentum = 0.9F;
            }
            */
            this.motionX *= (double)this.momentum;
            this.motionY *= (double)this.momentum;
            this.motionZ *= (double)this.momentum;
            
            this.deltaRotation *= this.momentum;
            
  /**          if(this.getControllingPassenger() == null)
            {
            	if(this.motionY < -0.060D)
        		{
            		this.motionY = -0.060D;
        		}
        		
            	this.motionY += d5;
            }
            //else if(isFuelBurning())
        	//{
            //	this.motionY *= (double)this.momentum;
        	//}
            //else
            {
            	if(this.motionY < -0.060D)
        		{
            		this.motionY = -0.060D;
        		}
        		
            	this.motionY += d5;
            }
            
            //if(this.fallenInGround())
    		//{
        	//	this.motionY = 0;
    		//}
            
            
            /**
            if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
            	if(this.status == EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER 
				|| this.status == EntityAirshipBaseVC.Status.UNDER_WATER)
				{
            		this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
				}
            	if(this.status == EntityAirshipBaseVC.Status.IN_WATER)
	            {
	            	this.motionY = 0;
	            }
            }
            
            //Max altitude Module
            if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
            {
            	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
            	{
            		//Lesser Altitude
                	if(this.getPosition().getY() > 225)
    	            {
    	            	this.motionY = -0.1D;
    	            }
            	}
            	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
            	{
            		//Altitude
                	if(this.getPosition().getY() > 250)
    	            {
    	            	this.motionY = -0.1D;
    	            }
            	}
            	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
            	{
            		//Greater Altitude
                	if(this.getPosition().getY() > 500)
    	            {
    	            	this.motionY = -0.1D;
    	            }
            	}
        	}
        	//Default Altitude logic.
            else
        	*{
            	//if(this.getPosition().getY() > EnumsVC.MainTierBalloon.byId(this.mainTierBalloon).getMaxAltitude())
	            //{
            		this.motionY = -0.1D;
	            //}
        	//}
        }*/
    }
    
    //@Override
    //public void travel(float strafe, float vertical, float forward)
    //{
    	
    //}
    
}
