package com.vies.viesmachines.common.entity.machines;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.client.InitParticlesVCRender;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.MessageMachineGuiMenuMain;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class EntityMachineBase extends EntityLiving {
	
	/** Shortcut to References. */
    References rf;
    
	// Attribute:
	/** Mimics Health in EntityLivingBase. Went with this approach to prevent code deviation. */
	public static final IAttribute MAX_MACHINE_POINTS = (new RangedAttribute(null, References.MOD_ID + ".maxMachinePoints", 100.0D, 0.0D, 1000.0D)).setShouldWatch(true);
	//public static final IAttribute DEFENSE = (new RangedAttribute(null, "generic.defense", 4.0D, 0.0D, 1024.0D)).setShouldWatch(true);
	//public static final IAttribute RANGED_SPEED = (new RangedAttribute(null, "generic.rangedSpeed", 4.0D, 0.0D, 1024.0D)).setShouldWatch(true);
	
	// Data Manager:
	/** Keeps track of the machine points. */
	private static final DataParameter<Float> MACHINE_POINTS = EntityDataManager.<Float>createKey(EntityMachineBase.class, DataSerializers.FLOAT);
    /** Keeps track of the broken state. */
	private static final DataParameter<Boolean> BROKEN = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the autorun. */
	private static final DataParameter<Boolean> AUTORUN = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the frame tier. */
	private static final DataParameter<Integer> FRAME_TIER = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the engine tier. */
	private static final DataParameter<Integer> ENGINE_TIER = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the component tier. */
	private static final DataParameter<Integer> COMPONENT_TIER = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
  	/** Keeps track of the current active ability of the machine. */
	private static final DataParameter<Integer> ACTIVE_ABILITY = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
  	
	
	
	/** Used to sync what animation states this creature is in. **
	protected static final DataParameter<Byte> ANIMATION_STATE = EntityDataManager.createKey(EntityMachineBase.class, DataSerializers.BYTE);
	
	
	/** Used for the ANIMATION_STATE watcher bitmap, bitmaps save on many packets and make network performance better! **
	public enum FRAME_COLOR_BITS {
		REDCOLOR((byte)1), GREENCOLOR((byte)2), BLUECOLOR((byte)4);//, BLOCKING((byte)8), MINION((byte)16), EXTRA01((byte)32);
		public final byte id;
		FRAME_COLOR_BITS(byte value) { this.id = value; }
	    public byte getValue() { return id; }
	}
	
	
	
	/** Used for the ANIMATION_STATE watcher bitmap, bitmaps save on many packets and make network performance better! **/
	//public enum ANIMATION_STATE_BITS {
	//	ATTACKED((byte)1), POWERED((byte)2), GROUNDED((byte)2), IN_WATER((byte)4), BLOCKING((byte)8), MINION((byte)16), EXTRA01((byte)32);
	//	public final byte id;
	//    ANIMATION_STATE_BITS(byte value) { this.id = value; }
	//    public byte getValue() { return id; }
	//}
	
	// Status:
	/** Current machine status. */
	protected EntityMachineBase.Status status;
	/** Previous machine status. */
    protected EntityMachineBase.Status previousStatus;
    
    // Upgrade Tier:
    /** Machine frame tier. */
    public int frameTier;
    /** Machine engine tier. */
    public int engineTier;
    /** Machine component tier. */
    public int componentTier;
    
    /** Amount of machine points. */
    public static float machinePoints;
    /** Is this machine broken? */
    public boolean broken;
    /** Is this machine set for autorun? */
    public boolean autorun;
    /** Has autorun been triggered? */
    public boolean autorunTrigger;
    /** The ability currently active in a machine. */
    public int activeAbility;
    
    /** The living update tick. **/
    public long updateTick = 0;
    /** Used to signal a player when enough control is lost. */
    protected float outOfControlTicks;
    
    // Size:
    /** The width of this mob. XZ axis. **/
	public float setWidth;
    /** The height of this mob. Y axis. **/
	public float setHeight;
	
    /** The left/right turn yaw. */
    protected float deltaRotation;
    /** Uses hitbox to check the water level. */
    protected double waterLevel;
    /** How much the airship should glide given the slippery blocks it's currently gliding over.
     * Halved every tick. 
     * NOT USED YET THANKS TO TRAVEL() FRICTION!!! */
    private float machineGlide;
    /** Stores previous motion, mainly for momentum.
     * NOT USED YET */
    protected double lastYd;
    /** How much of current speed to retain. Value zero to one. */
	protected double momentum;
    
	// Inventory:
	/**
	 * SLOTS: <br> <br>
	 *
	 * Slot  0 = Fuel Slot<br>
	 * Slot  1 = Machine Point Slot <br>
	 * Slot  2 = Fuel <br>
	 //* Slot  1 = Upgrade Core <br>
	 //* Slot  2 = Upgrade Frame <br>
	 //* Slot  3 = Upgrade Engine <br>
	 //* Slot  4 = Upgrade Balloon <br>
	 * Slot 11 = Module Slot1 <br>
	 * Slot 12 = Module Slot2 <br>
	 //* Slot 16 = Redstone Slot <br>
	 * Slot 18 = Block/Item to Display <br>
	 * Slot 20-28 = Inventory Small <br>
	 * Slot 20-37 = Inventory Large <br>
	 * Slot 51 = Bomb Slot1 <br>
	 */
    public ItemStackHandler inventory;
    /** The amount of slots the machine has for storage. */
    protected int size = 64;
    
    // Movement:
    protected boolean leftInputDown;
    protected boolean rightInputDown;
    protected boolean forwardInputDown;
    protected boolean backInputDown;
    protected boolean upInputDown;
    protected boolean downInputDown;
    protected boolean openGuiMenuInputDown;
    protected boolean toggleAbilityInputDown;
    
    // Radio:
    /** Stores the selected song using the int position of the musicListRecord array. */
    public static int selectedSong;
	
    public int frameColorRed;
    public int frameColorGreen;
    public int frameColorBlue;
    
    //To debug...
	private BlockPos homePosition = BlockPos.ORIGIN;
    /** If -1 there is no maximum distance */
    private float maximumHomeDistance = -1.0F;
    
    
	
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineBase(World worldIn) 
	{
		super(worldIn);
		
		// This is a metal machine after all:
		this.isImmuneToFire = true;
		this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        
        // Sets up the inventory:
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
	
	
	
	//==================================================
    // TODO         Inventory Capability
	//==================================================
    
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
    
    
    
	//==================================================
    // TODO              Core Inits
	//==================================================
    
    /** 
     * Initiates the entity AI tasks to run. 
     */
	@Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
    }
	
	/** 
	 * Creates and sets all the entity attributes with default values.
	 */
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getAttributeMap().registerAttribute(MAX_MACHINE_POINTS);
        
        this.getEntityAttribute(MAX_MACHINE_POINTS).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.01D);
    }
	
	/** 
	 * Initiates the entity, setting all the values to be watched by the data watcher. 
	 */
	@Override
    protected void entityInit()
    {
        super.entityInit();
        
        this.dataManager.register(MACHINE_POINTS, Float.valueOf(this.machinePoints));
        this.dataManager.register(BROKEN, Boolean.valueOf(this.broken));
        this.dataManager.register(AUTORUN, Boolean.valueOf(false));
        this.dataManager.register(FRAME_TIER, Integer.valueOf(this.frameTier));
        this.dataManager.register(ENGINE_TIER, Integer.valueOf(this.engineTier));
        this.dataManager.register(COMPONENT_TIER, Integer.valueOf(this.componentTier));
        this.dataManager.register(ACTIVE_ABILITY, Integer.valueOf(this.activeAbility));
        
        //this.dataManager.register(ANIMATION_STATE, (byte) 0);
    }
	
	
	
	//==================================================
    // TODO            Read/Write Logic
	//==================================================
    
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
    {
		super.writeEntityToNBT(compound);
		
		compound.setTag(rf.MACHINE_SLOTS_TAG, this.inventory.serializeNBT());
		
		compound.setFloat(rf.MACHINE_POINTS_TAG, this.machinePoints);
		compound.setBoolean(rf.BROKEN_MACHINE_TAG, this.broken);
		compound.setBoolean(rf.AUTORUN_MACHINE_TAG, this.autorun);
		compound.setInteger(rf.SELECTED_SONG_TAG, this.selectedSong);
		
		compound.setInteger(rf.FRAME_TIER_TAG, this.frameTier);
		compound.setInteger(rf.ENGINE_TIER_TAG, this.engineTier);
		compound.setInteger(rf.COMPONENT_TIER_TAG, this.componentTier);
		
		compound.setInteger(rf.ACTIVE_ABILITY_TAG, this.activeAbility);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
		super.readEntityFromNBT(compound);
		
		this.inventory.deserializeNBT(compound.getCompoundTag(rf.MACHINE_SLOTS_TAG));
    	
		this.machinePoints = compound.getFloat(rf.MACHINE_POINTS_TAG);
		this.broken = compound.getBoolean(rf.BROKEN_MACHINE_TAG);
		this.autorun = compound.getBoolean(rf.AUTORUN_MACHINE_TAG);
		this.selectedSong = compound.getInteger(rf.SELECTED_SONG_TAG);
		
		this.frameTier = compound.getInteger(rf.FRAME_TIER_TAG);
		this.engineTier = compound.getInteger(rf.ENGINE_TIER_TAG);
		this.componentTier = compound.getInteger(rf.COMPONENT_TIER_TAG);
		
		this.activeAbility = compound.getInteger(rf.ACTIVE_ABILITY_TAG);
    }
	
	
	
	//==================================================
    // TODO           Main update logic
	//==================================================
    
	/**
     * The main update method, all the important updates go here.
     */
	@Override
	public void onUpdate()
    {
		//Used to clear out all test machines for testing purposes:
        //	this.isDead = true;
		
		this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        
        super.onUpdate();
        
        this.frameTier = 0;
        
        LogHelper.info("Frame = " + this.frameTier);
        this.applyFrameUpgrade();
        
        /**
        int test = 1888777666;
        
        String test1 = String.valueOf(test);
        
        
        String testbool = test1.substring(0, 1);
        String testr = test1.substring(1, 4);
        String testg = test1.substring(4, 7);
        String testb = test1.substring(7, 10);
        
        String testfbool = String.valueOf(testbool);
        String testfr = String.valueOf(testr);
        String testfg = String.valueOf(testg);
        String testfb = String.valueOf(testb);
        
        
        LogHelper.info("Boolean = " + testfbool);
        LogHelper.info("Red = " + testfr);
        LogHelper.info("Green = " + testfg);
        LogHelper.info("Blue = " + testfb);
        */
        
        this.previousStatus = this.status;
        this.status = this.getMachineStatus();
        
        if (this.canPassengerSteer())
        {
        	this.controlAirship();
        	
        	if (this.world.isRemote)
            {
        		this.updateInputs();
        		this.controlMachineGui();
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
        
        this.dataSync();
        

        

        /**
        LogHelper.info(this.status);
        
        
        *
        
        
        
        // Animations Server:
        //if(this.getEntityWorld().isRemote) 
        {
        	byte colorRed = 0;
        	byte colorGreen = 0;
        	byte colorBlue = 0;
        	byte animations = 0;
        	
        	// Attack Cooldown:
        	if(this.status == this.status.IN_AIR) 
        	{
        		animations += FRAME_COLOR_BITS.REDCOLOR.id;
        		
        		colorRed = (byte) (FRAME_COLOR_BITS.REDCOLOR.id + 5);

        		colorGreen = (byte) (FRAME_COLOR_BITS.GREENCOLOR.id + 10);

        		colorBlue = (byte) (FRAME_COLOR_BITS.BLUECOLOR.id + 15);
        	}
        	else
        	{
        		//colorRed = (byte) (FRAME_COLOR_BITS.REDCOLOR.id );

        		//colorGreen = (byte) (FRAME_COLOR_BITS.GREENCOLOR.id );

        		//colorBlue = (byte) (FRAME_COLOR_BITS.BLUECOLOR.id );
        	}

        	if(this.status == this.status.IN_AIR) 
        	{
        		//colorRed = (byte) (FRAME_COLOR_BITS.REDCOLOR.id + 0);

        		//colorGreen = (byte) (FRAME_COLOR_BITS.REDCOLOR.id + 0);
        	}
        	
        	/**
        	// Airborne Animation:
        	if(this.onGround)
        		animations += ANIMATION_STATE_BITS.GROUNDED.id;

            // Swimming Animation:
            if(this.inWater)
                animations += ANIMATION_STATE_BITS.IN_WATER.id;

        	// Blocking Animation:
        	if(this.isBlocking())
        		animations += ANIMATION_STATE_BITS.BLOCKING.id;

        	// Blocking Animation:
        	if(this.isMinion())
        		animations += ANIMATION_STATE_BITS.MINION.id;

        	// Extra Animation 01:
        	if(this.extraAnimation01())
        		animations += ANIMATION_STATE_BITS.EXTRA01.id;
*
        	
       	
        	
        	this.dataManager.set(ANIMATION_STATE, colorRed);
        	this.dataManager.set(ANIMATION_STATE, colorGreen);
        	this.dataManager.set(ANIMATION_STATE, colorBlue);
        	
        	this.frameColorRed = colorRed - 1 & 0xFF;
        	this.frameColorGreen = colorGreen - 2 & 0xFF;
        	this.frameColorBlue = colorBlue - 4 & 0xFF;
        	
        	LogHelper.info("test = " + animations);
        	
        	//LogHelper.info("===============================");
        	//LogHelper.info(" Byte info   RED = " + colorRed);
        	//LogHelper.info(" Byte info GREEN = " + colorGreen);
        	//LogHelper.info(" Byte info  BLUE = " + colorBlue);
        	//LogHelper.info("===============================");
        }
        
        
        /**
    	LogHelper.info("===============================");
    	LogHelper.info(" Byte/Int info   RED = " + this.frameColorRed);
    	LogHelper.info(" Byte/Int info GREEN = " + this.frameColorGreen);
    	LogHelper.info(" Byte/Int info  BLUE = " + this.frameColorBlue);
    	LogHelper.info("===============================");
        */
    }
	
	/**
     * The main update method, upgrades and enhancements get applied here.
     */
	@Override
	public void onEntityUpdate()
    {
        super.onEntityUpdate();
        
        // Sets the machine to be fixed if broken and above 0 HP:
        if (this.getHealth() > 0
        && this.getBroken())
        {
        	this.broken = false;
        	this.isDead = false;
        }
        
        // Makes a broken machine smoke/bubble:
        if (this.world.isRemote)
        {
        	if (this.broken)
            {
        		this.spawnBrokenParticles();
            }
        }
        
        // Damages machines from environment:
        if (!this.world.isRemote)
        {
        	this.damageMachineByStatus();
        }
    }
	
	/**
     * The main update method, behavior and custom update logic should go here.
     */
	@Override
	public void onLivingUpdate()
    {
        super.onLivingUpdate();
		
		this.updateTick++;
    }
	
	
	
	//==================================================
    // TODO       Overrides from EntityLiving
	//==================================================
	
	/**
	 * Action performed when right-clicking a machine.
	 */
	@Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand)
    {
		//Needed to fix the auto pop up machine GUI bug:
		Keybinds.openGuiMenu.unPressAllKeys();
    	
		super.processInteract(player, hand);
		
		// Saving this for a later feature???:
        if (player.isSneaking())
        {
        	return false;
        }
        else
        {
            if (!this.world.isRemote)// && this.outOfControlTicks < 60.0F)
            {
                player.startRiding(this);
            }
            
            return true;
        }
    }
	
	@Override
	@Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        return super.onInitialSpawn(difficulty, livingdata);
    }
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
    {
		// THIS NEEDS TO BE WORKED ON!:
		if (this.getHealth() <= amount)
        {
			for (int i = 1; i < 80; i++)
	    	{
				this.spawnInitialBrokenParticles();
	    	}
        }
		
        Entity entity = source.getTrueSource();
        return this.isBeingRidden() && entity != null && this.isRidingOrBeingRiddenBy(entity) ? false : super.attackEntityFrom(source, amount);
    }
	
	@Override
	public boolean canRiderInteract()
    {
        return false;
    }
	
	@Override
	public boolean shouldDismountInWater(Entity rider)
    {
        return false;
    }
	
	@Override
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	@Override
	protected boolean canDespawn()
    {
        return false;
    }
    
    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
    
    @Override
    public boolean canBePushed()
    {
        return false;
    }
    
    @Override
	public boolean isPushedByWater() 
    {
        return true;
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
	public boolean canBeSteered()
    {
        return this.getControllingPassenger() instanceof EntityLivingBase;
    }
    
    @Override
    @Nullable
    public Entity getControllingPassenger()
    {
        List<Entity> list = this.getPassengers();
        
        return list.isEmpty() ? null : (Entity)list.get(0);
    }
    
    @Override
    protected boolean canFitPassenger(Entity passenger)
    {
        return this.getPassengers().size() < 1;
    }
    
    @Override
    public void updatePassenger(Entity passenger)
    {
    	super.updatePassenger(passenger);
    	
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
    
	@Override
	public boolean canBeHitWithPotion()
    {
        return false;
    }
    
    @Override
    public boolean attackable()
    {
        return true;
    }
    
	@Override
	public int getMaxFallHeight()
    {
        return 0;
    }
    
	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
        
    }
	
	@Override
	public void fall(float distance, float damageMultiplier)
    {
		
    }
	
	
	
	//==================================================
    // TODO              Sound Events
	//==================================================
	
	/**
	 * Gets the sound to be triggered when a machine is healed.
	 */
	@Nullable
    protected SoundEvent getHealSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SHULKER_BULLET_HIT
        		
        		
        		//.ENTITY_EXPERIENCE_ORB_PICKUP
        		
        		
        		//.BLOCK_BREWING_STAND_BREW
        		
        		
        		//.ENTITY_FIREWORK_TWINKLE
        		
        		//.BLOCK_END_PORTAL_FRAME_FILL
        		;
        		//.ENTITY_BLAZE_SHOOT;
    }
	
	protected void playHealSound(DamageSource source)
    {
        SoundEvent soundevent = this.getHealSound(source);

        if (soundevent != null)
        {
            this.playSound(soundevent, this.getSoundVolume(), this.getSoundPitch());
        }
    }
	
	/**
	 * Gets the sound to be triggered when a machine is damaged.
	 */
	@Override
	@Nullable
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
		SoundEvent soundIn = SoundEvents.BLOCK_ANVIL_BREAK;
		
		if (this.status == this.status.ON_LAND
    	|| this.status == this.status.IN_AIR)
    	{
			soundIn = SoundEvents.BLOCK_PISTON_CONTRACT;
    	}
    	
		if (this.status == this.status.IN_WATER
    	|| this.status == this.status.UNDER_WATER
    	|| this.status == this.status.UNDER_FLOWING_WATER)
    	{
			soundIn = SoundEvents.ENTITY_BOBBER_SPLASH;
    	}
		
		return soundIn;
    }

	/**
	 * Gets the sound to be triggered when a machine is broken.
	 */
	@Override
	@Nullable
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GENERIC_EXPLODE;
    }

	/**
	 * Gets the sound to be triggered when a machine hits the ground while falling.
	 */
	@Override
	protected SoundEvent getFallSound(int heightIn)
    {
        return heightIn > 4 ? SoundEvents.ENTITY_GENERIC_BIG_FALL : SoundEvents.ENTITY_GENERIC_SMALL_FALL;
    }
    
    
    
	//==================================================
    // TODO             Death Events
	//==================================================
	
	@Override
	public void onDeath(DamageSource cause)
    {
    	super.onDeath(cause);
    	
    	this.broken = true;
    }
	
	@Override
	public void onKillCommand()
    {
        
    }
	
	@Override
	public void setDead()
    {
		// Remove the thing that caused a dead entity to be removed:
        //this.isDead = true;
    }
	
	
	
	//==================================================
    // TODO              Leash Events
	//==================================================
	
	/**
     * Applies logic related to leashes, for example dragging the entity or breaking the leash.
     */
    @Override
    protected void updateLeashedState()
    {
        super.updateLeashedState();

        if (this.getLeashed() && this.getLeashHolder() != null && this.getLeashHolder().world == this.world)
        {
            Entity entity = this.getLeashHolder();
            this.setHomePosAndDistance(new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ), 5);
            float f = this.getDistance(entity);

            //if (this instanceof EntityTameable && ((EntityTameable)this).isSitting())
            //{
            //    if (f > 10.0F)
            //    {
            //        this.clearLeashed(true, true);
            //    }
            //
            //    return;
            //}

            this.onLeashDistance(f);

            if (f > 10.0F)
            {
                this.clearLeashed(true, true);
                this.tasks.disableControlFlag(1);
            }
            else if (f > 6.0F)
            {
                double d0 = (entity.posX - this.posX) / (double)f;
                double d1 = (entity.posY - this.posY) / (double)f;
                double d2 = (entity.posZ - this.posZ) / (double)f;
                this.motionX += d0 * Math.abs(d0) * 0.4D;
                this.motionY += d1 * Math.abs(d1) * 0.4D;
                this.motionZ += d2 * Math.abs(d2) * 0.4D;
            }
            else
            {
                this.tasks.enableControlFlag(1);
                float f1 = 2.0F;
                Vec3d vec3d = (new Vec3d(entity.posX - this.posX, entity.posY - this.posY, entity.posZ - this.posZ)).normalize().scale((double)Math.max(f - 2.0F, 0.0F));
                this.getNavigator().tryMoveToXYZ(this.posX + vec3d.x, this.posY + vec3d.y, this.posZ + vec3d.z, this.followLeashSpeed());
            }
        }
    }
    
    /**
     * if the entity got a PathEntity it returns true, else false
     */
    public boolean hasPath()
    {
        return !this.navigator.noPath();
    }

    public boolean isWithinHomeDistanceCurrentPosition()
    {
        return this.isWithinHomeDistanceFromPosition(new BlockPos(this));
    }

    public boolean isWithinHomeDistanceFromPosition(BlockPos pos)
    {
        if (this.maximumHomeDistance == -1.0F)
        {
            return true;
        }
        else
        {
            return this.homePosition.distanceSq(pos) < (double)(this.maximumHomeDistance * this.maximumHomeDistance);
        }
    }

    /**
     * Sets home position and max distance for it
     */
    public void setHomePosAndDistance(BlockPos pos, int distance)
    {
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }

    public BlockPos getHomePosition()
    {
        return this.homePosition;
    }

    public float getMaximumHomeDistance()
    {
        return this.maximumHomeDistance;
    }

    public void detachHome()
    {
        this.maximumHomeDistance = -1.0F;
    }

    /**
     * Returns whether a home area is defined for this entity.
     */
    public boolean hasHome()
    {
        return this.maximumHomeDistance != -1.0F;
    }

    protected double followLeashSpeed()
    {
        return 1.0D;
    }

    protected void onLeashDistance(float distanceIn)
    {
    }
    
    public boolean canBeLeashedTo(EntityPlayer player)
    {
        return super.canBeLeashedTo(player) && this.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
    }
    
    
    
	//==================================================
    // TODO            Input Updates
	//==================================================
    
    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, Boats, and Machines are generally "steered" by the controlling passenger.
     */
    @SideOnly(Side.CLIENT)
    public void updateInputs()
    {
    	this.leftInputDown = Keybinds.moveLeft.isKeyDown();
        this.rightInputDown = Keybinds.moveRight.isKeyDown();
        this.forwardInputDown = Keybinds.moveForward.isKeyDown();
        this.backInputDown = Keybinds.moveBack.isKeyDown();
        this.upInputDown = Keybinds.moveUp.isKeyDown();
        this.downInputDown = Keybinds.moveDown.isKeyDown();
        this.openGuiMenuInputDown = Keybinds.openGuiMenu.isPressed();
        this.toggleAbilityInputDown = Keybinds.toggleAbility.isPressed();
    }
    
    
    
	//==================================================
    // TODO            Movement Logic
	//==================================================
    
    /**
     * Translates inputs to motion modifiers.
     */
    public void controlAirship()
    {
    	if (this.isBeingRidden())
        {
            float f = 0.0F;
            
            if (this.broken)
    		{
        		
    		}
    		else
			{
    			// Turn Left:
	            if (this.leftInputDown)
	            {
	            	if (this.isFuelNeeded())
    				{
    					if (this.isFuelBurning())
    					{
    						this.deltaRotation -= (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 15;
						}
    					else
    					{
    						this.deltaRotation -= 0.05D;
    					}
            		}
    				else
    				{
    					this.deltaRotation -= (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 15;
    				}
	            }
	            
	            // Turn Right:
	            if (this.rightInputDown)
	            {
	            	if (this.isFuelNeeded())
    				{
	            		if (this.isFuelBurning())
    					{
    						this.deltaRotation += (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 15;
    					}
    					else
    					{
    						this.deltaRotation += 0.05D;
    					}
            		}
    				else
    				{
    					this.deltaRotation += (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 15;
    				}
	            }
	            
	            // Left or Right, with Forward and no Backward:
	            if (this.rightInputDown != this.leftInputDown 
        		&& this.forwardInputDown 
        		&& !this.backInputDown)
	            {
	            	if (this.isFuelNeeded())
    				{
    					if (this.isFuelBurning())
    					{
    						f += (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    					}
    					else
    					{
    						
    					}
            		}
    				else
    				{
    					f += (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    				}
	            }
	            
	            // Left or Right, with Backward and no Forward:
	            if (this.rightInputDown != this.leftInputDown 
        		&& !this.forwardInputDown 
        		&& this.backInputDown)
	            {
		            if (this.isFuelNeeded())
					{
						if (this.isFuelBurning())
						{
							f -= (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.5;
						}
						else
						{
							
						}
	        		}
					else
					{
						f -= (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.5;
					}
	            }
	            
	            this.rotationYaw += this.deltaRotation;
	            
	            // Move Forwards with no left and no right:
	        	if (this.forwardInputDown 
        		&& !this.rightInputDown 
        		&& !this.leftInputDown)
	            {
	        		if (this.isFuelNeeded())
    				{
        				if (this.isFuelBurning())
    					{
        					// Initiates the autorun trigger.
            				if (this.autorun)
            				{
            					this.autorunTrigger = true;
            				}
            				else
            				{
            					f += (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
            				}
    					}
    					else
    					{
    						
    					}
            		}
    				else
    				{
    					// Initiates the autorun trigger.
    					if (this.autorun)
        				{
        					this.autorunTrigger = true;
        				}
    					else
    					{
    						f += (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    					}
    				}
	            }
	        	
	        	// Applies autorun:
	        	if (this.autorun
	        	&& this.autorunTrigger)
				{
					f += (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
				}
	        	
	        	// Move Backwards with no left and no right:
	        	if (this.backInputDown 
        		&& !this.rightInputDown 
        		&& !this.leftInputDown)
	            {
	        		// Handles canceling autorun:
	        		if (this.autorunTrigger)
	        		{
	        			this.autorunTrigger = false;
	        		}
	        		
	        		if (this.isFuelNeeded())
    				{
    					if (this.isFuelBurning())
    					{
    						f -= (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.5;
    					}
    					else
    					{
    						
    					}
            		}
    				else
    				{
    					f -= (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.5;
    				}
	            }
			}
            
            
            
            this.motionX += (double)(MathHelper.sin(-this.rotationYaw * 0.017453292F) * f);
            this.motionZ += (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * f);
            
            this.rotationPitch += 10;
        }
    }
    
    /**
     * Main movement logic. Responsible for applying motion to move machines. Used with all EntityLiving AI.
     */
    @Override
    public void travel(float strafe, float vertical, float forward)
    {
    	// Main movement logic:
    	if (this.canPassengerSteer()) 
        {
    		if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(MachineModifier.DASHING_SPEED_BOOST))
    		{
    			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(MachineModifier.DASHING_SPEED_BOOST);
    		}
    		
    		this.momentum = 0.8999999761581421D;
    		this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
            
	    	this.moveRelative(strafe, vertical, forward, 0.0000001F);
	        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	        this.motionX *= this.momentum;
	        this.motionY *= this.momentum;
	        this.motionZ *= this.momentum;
	        this.deltaRotation *= this.momentum;
        }
    	
    	// Keep for reference:
    	if (this.isBeingRidden() && this.canBeSteered())
        {
    		
        }
    	
/**
    	// Machine upward motion while in water:
    	if (this.status == this.status.UNDER_WATER
		|| this.status == this.status.UNDER_FLOWING_WATER)
		{
    		this.motionY = 0.05D;
	        	
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		}
    	*/
    	
    	// Machine upward motion while in lava:
    	if (this.status == this.status.UNDER_LAVA
		|| this.status == this.status.UNDER_FLOWING_LAVA)
		{
    		this.motionY = 0.015D;
	        	
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		}
    }
    
    
    
	//==================================================
    // TODO               Data Logic
	//==================================================
    
    /** 
     * Syncs the data managers 
     */
    protected void dataSync()
    {
    	if (this.world.isRemote)
        {
        	this.machinePoints = this.getMachinePoints();
        	this.broken = this.getBroken();
        	this.autorun = this.getAutorun();
        	
        	this.frameTier = this.getFrameTier();
        	this.engineTier = this.getEngineTier();
        	this.componentTier = this.getComponentTier();
        	
        	this.activeAbility = this.getActiveAbility();
        }
        else
        {
        	this.setMachinePoints(this.machinePoints);
        	this.setBroken(this.broken);
        	this.setAutorun(this.autorun);
        	
        	this.setFrameTier(this.frameTier);
        	this.setEngineTier(this.engineTier);
        	this.setComponentTier(this.componentTier);
        	
        	this.setActiveAbility(this.activeAbility);
        }
    }
    
    @Override
    public void heal(float healAmount)
    {
        super.heal(healAmount);
        
        this.playHealSound(null);
    }
    
    /** Sets the Machine Points float. */
    protected void setMachinePoints(float floatIn)
    {
        this.dataManager.set(MACHINE_POINTS, Float.valueOf(floatIn));
    }
    /** Gets the Machine Points float. */
    protected float getMachinePoints()
    {
        return ((Float)this.dataManager.get(MACHINE_POINTS)).floatValue();
    }
    /**
     * Returns the maximum machine points of the machine. (What it is able to rise up to, what it spawned with, etc.)
     */
    public final float getMaxMachinePoints()
    {
        return (float)this.getEntityAttribute(MAX_MACHINE_POINTS).getAttributeValue();
    }
    /**
     * Replenished machine points.
     */
    public void replenishMachinePoints(float healAmount)
    {
        if (healAmount <= 0)
    	{
    		return;
    	}
        
        float f = this.getMachinePoints();

        if ((f + healAmount) <= this.getMaxMachinePoints())
        {
        	this.setMachinePoints(f + healAmount);
        }
    }
    
    //--------------------------------------------------
    
    /** Sets the Broken Machine boolean. */
    protected void setBroken(boolean booleanIn)
    {
        this.dataManager.set(BROKEN, Boolean.valueOf(booleanIn));
    }
    /** Gets the Broken Machine boolean. */
    protected boolean getBroken()
    {
        return ((Boolean)this.dataManager.get(BROKEN)).booleanValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Autorun Machine boolean. */
    protected void setAutorun(boolean booleanIn)
    {
        this.dataManager.set(AUTORUN, Boolean.valueOf(booleanIn));
    }
    /** Gets the Autorun Machine boolean. */
    protected boolean getAutorun()
    {
        return ((Boolean)this.dataManager.get(AUTORUN)).booleanValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the frame tier. */
    protected void setFrameTier(int intIn)
    {
        this.dataManager.set(FRAME_TIER, Integer.valueOf(intIn));
    }
    /** Gets the frame tier. */
    protected int getFrameTier()
    {
        return ((Integer)this.dataManager.get(FRAME_TIER)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the engine tier. */
    protected void setEngineTier(int intIn)
    {
        this.dataManager.set(ENGINE_TIER, Integer.valueOf(intIn));
    }
    /** Gets the engine tier. */
    protected int getEngineTier()
    {
        return ((Integer)this.dataManager.get(ENGINE_TIER)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Component tier. */
    protected void setComponentTier(int intIn)
    {
        this.dataManager.set(COMPONENT_TIER, Integer.valueOf(intIn));
    }
    /** Gets the Component tier. */
    protected int getComponentTier()
    {
        return ((Integer)this.dataManager.get(COMPONENT_TIER)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Active Ability. */
    protected void setActiveAbility(int intIn)
    {
        this.dataManager.set(ACTIVE_ABILITY, Integer.valueOf(intIn));
    }
    /** Gets the Active Ability. */
    protected int getActiveAbility()
    {
        return ((Integer)this.dataManager.get(ACTIVE_ABILITY)).intValue();
    }
    
    
    
	//==================================================
    // TODO           Particles Logic
	//==================================================
    
    /**
     * Particles that spawn when a machine changes to broken.
     */
    protected void spawnInitialBrokenParticles()
    {
    	if (this.status == this.status.ON_LAND
    	|| this.status == this.status.IN_AIR)
    	{
    		this.world.spawnParticle(EnumParticleTypes.LAVA, true, this.posX, this.posY, this.posZ, 0, 0, 0, new int[0]);
    	}
    	
    	if (this.status == this.status.IN_WATER
    	|| this.status == this.status.UNDER_WATER
    	|| this.status == this.status.UNDER_FLOWING_WATER)
    	{
    		this.world.spawnParticle(EnumParticleTypes.LAVA, true, this.posX, this.posY, this.posZ, 0, 0, 0, new int[0]);
    	}
    }
    
    /**
     * Particles that spawn when a machine is broken.
     */
    protected void spawnBrokenParticles()
    {
    	if (this.status == this.status.ON_LAND
    	|| this.status == this.status.IN_AIR)
    	{
			InitParticlesVCRender.generateParticleBrokenSmoke(this);
    	}
    	
    	if (this.status == this.status.IN_WATER)
    	{
    		InitParticlesVCRender.generateParticleBrokenSmoke(this);
    		InitParticlesVCRender.generateParticleBrokenBubbles(this);
    		InitParticlesVCRender.generateParticleBrokenWakes(this);
    	}
    	
    	if (this.status == this.status.UNDER_WATER
    	|| this.status == this.status.UNDER_FLOWING_WATER)
    	{
    		InitParticlesVCRender.generateParticleBrokenBubbles(this);
    		InitParticlesVCRender.generateParticleBrokenWakes(this);
    	}
    }
    
    
    
	//==================================================
    // TODO         Machine Status Logic
	//==================================================
    
    /**
     * Determines whether the machine is in water, gliding on land, or in air
     */
    protected EntityMachineBase.Status getMachineStatus()
    {
        EntityMachineBase.Status EntityMachineBase$status = this.getUnderwaterStatus();
        
        if (EntityMachineBase$status != null)
        {
            this.waterLevel = this.getEntityBoundingBox().maxY;
            return EntityMachineBase$status;
        }
        else if (this.checkInWater())
        {
            return EntityMachineBase.Status.IN_WATER;
        }
        else if (this.checkInLava())
        {
            return EntityMachineBase.Status.IN_LAVA;
        }
        else
        {
            float f = this.getMachineGlide();
            
            if (f > 0.0F)
            {
                this.machineGlide = f;
                return EntityMachineBase.Status.ON_LAND;
            }
            else
            {
                return EntityMachineBase.Status.IN_AIR;
            }
        }
    }
    
    /**
     * Gets the water above a machine based on the bounding box.
     */
    public float getWaterLevelAbove()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.maxY);
        int l = MathHelper.ceil(axisalignedbb.maxY - this.lastYd);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();
        
        try
        {
            label78:

            for (int k1 = k; k1 < l; ++k1)
            {
                float f = 0.0F;
                int l1 = i;

                while (true)
                {
                    if (l1 >= j)
                    {
                        if (f < 1.0F)
                        {
                            float f2 = (float)blockpos$pooledmutableblockpos.getY() + f;
                            return f2;
                        }

                        break;
                    }

                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(l1, k1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER)
                        {
                            f = Math.max(f, getBlockLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos));
                        }

                        if (f >= 1.0F)
                        {
                            continue label78;
                        }
                    }

                    ++l1;
                }
            }

            float f1 = (float)(l + 1);
            return f1;
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }
    }
    
    /**
     * Get the height of the water/lava above the machine.
     */
    public static float getBlockLiquidHeight(IBlockState blockStateIn, IBlockAccess blockAccessIn, BlockPos posIn)
    {
        int i = ((Integer)blockStateIn.getValue(BlockLiquid.LEVEL)).intValue();
        return (i & 7) == 0 && blockAccessIn.getBlockState(posIn.up()).getMaterial() == Material.WATER ? 1.0F :
        	   (i & 7) == 0 && blockAccessIn.getBlockState(posIn.up()).getMaterial() == Material.LAVA ? 1.0F :
        		   1.0F - BlockLiquid.getLiquidHeightPercent(i);
    }
    
    /**
     * Gets if the machine is on land and the gliding factor (based on any slippery blocks).
     */
    
    public float getMachineGlide()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY - 0.001D, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        int i = MathHelper.floor(axisalignedbb1.minX) - 1;
        int j = MathHelper.ceil(axisalignedbb1.maxX) + 1;
        int k = MathHelper.floor(axisalignedbb1.minY) - 1;
        int l = MathHelper.ceil(axisalignedbb1.maxY) + 1;
        int i1 = MathHelper.floor(axisalignedbb1.minZ) - 1;
        int j1 = MathHelper.ceil(axisalignedbb1.maxZ) + 1;
        List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
        float f = 0.0F;
        int k1 = 0;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int l1 = i; l1 < j; ++l1)
            {
                for (int i2 = i1; i2 < j1; ++i2)
                {
                    int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);

                    if (j2 != 2)
                    {
                        for (int k2 = k; k2 < l; ++k2)
                        {
                            if (j2 <= 0 || k2 != k && k2 != l - 1)
                            {
                                blockpos$pooledmutableblockpos.setPos(l1, k2, i2);
                                IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);
                                iblockstate.addCollisionBoxToList(this.world, blockpos$pooledmutableblockpos, axisalignedbb1, list, this, false);

                                if (!list.isEmpty())
                                {
                                    f += iblockstate.getBlock().slipperiness;
                                    ++k1;
                                }

                                list.clear();
                            }
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return f / (float)k1;
    }
    
    /**
     * A check to see if the machine is in water.
     */
    private boolean checkInWater()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.minY);
        int l = MathHelper.ceil(axisalignedbb.minY + 0.001D);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag = false;
        this.waterLevel = Double.MIN_VALUE;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int k1 = i; k1 < j; ++k1)
            {
                for (int l1 = k; l1 < l; ++l1)
                {
                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER)
                        {
                            float f = getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos);
                            this.waterLevel = Math.max((double)f, this.waterLevel);
                            flag |= axisalignedbb.minY < (double)f;
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return flag;
    }
    
    /**
     * A check to see if the machine is in lava.
     */
    private boolean checkInLava()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.minY);
        int l = MathHelper.ceil(axisalignedbb.minY + 0.001D);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag = false;
        this.waterLevel = Double.MIN_VALUE;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int k1 = i; k1 < j; ++k1)
            {
                for (int l1 = k; l1 < l; ++l1)
                {
                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.LAVA)
                        {
                            float f = getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos);
                            this.waterLevel = Math.max((double)f, this.waterLevel);
                            flag |= axisalignedbb.minY < (double)f;
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return flag;
    }
    
    /**
     * Get the height of the liquid.
     */
    public static float getLiquidHeight(IBlockState blockStateIn, IBlockAccess blockAccessIn, BlockPos posIn)
    {
        return (float)posIn.getY() + getBlockLiquidHeight(blockStateIn, blockAccessIn, posIn);
    }
    
    /**
     * Decides whether the machine is currently under water/lava.
     */
    @Nullable
    private EntityMachineBase.Status getUnderwaterStatus()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        double d0 = axisalignedbb.maxY + 0.001D;
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.maxY);
        int l = MathHelper.ceil(d0);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag1 = false;
        boolean flag2 = false;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int k1 = i; k1 < j; ++k1)
            {
                for (int l1 = k; l1 < l; ++l1)
                {
                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);
                        
                        // Under Water:
                        if (iblockstate.getMaterial() == Material.WATER && d0 < (double)getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos))
                        {
                            if (((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() != 0)
                            {
                                EntityMachineBase.Status EntityMachineBase$status = EntityMachineBase.Status.UNDER_FLOWING_WATER;
                                return EntityMachineBase$status;
                            }

                            flag1 = true;
                        }
                        
                        // Under Lava:
                        if (iblockstate.getMaterial() == Material.LAVA && d0 < (double)getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos))
                        {
                            if (((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() != 0)
                            {
                                EntityMachineBase.Status EntityMachineBase$status = EntityMachineBase.Status.UNDER_FLOWING_LAVA;
                                return EntityMachineBase$status;
                            }

                            flag2 = true;
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return flag1 ? EntityMachineBase.Status.UNDER_WATER : flag2 ? EntityMachineBase.Status.UNDER_LAVA :null;
    }
    
    /**
     * Enum responsible for determining the status of a machine.
     */
    public static enum Status
    {
        IN_WATER,
        UNDER_WATER,
        UNDER_FLOWING_WATER,
        IN_LAVA,
        UNDER_LAVA,
        UNDER_FLOWING_LAVA,
        ON_LAND,
        IN_AIR;
    }
    
    
    
    //==================================================
    // TODO              Custom Logic
	//==================================================
	
    /**
     * Is this a Ground Machine?
     */
	public boolean isGroundMachine()
    {
		return false;
    }
    
	/**
     * Is this a Water Machine?
     */
	public boolean isWaterMachine()
    {
		return false;
    }
    
    /**
     * Is this a Flying Machine?
     */
	public boolean isFlyingMachine()
    {
		return false;
    }
    
    /**
     * Does this machine need fuel to run?
     */
	protected boolean isFuelNeeded()
	{
		return false;
	}
	
	/**
     * Is this machine burning fuel?
     */
	public boolean isFuelBurning()
    {
		return false;
    }
	
	/**
     * Get the damage done by the status of a machine.
     */
	protected void damageMachineByStatus()
    {
		if (this.getHealth() > 0.0F)
    	{
			if (this.status == this.status.UNDER_LAVA
			|| this.status == this.status.UNDER_FLOWING_LAVA)
			{
				this.attackEntityFrom(DamageSource.DROWN, 0.5F);
			}
    	}
    }
	
	/**
	 * This gets the block that is -0.25 below the entity.
	 */
    private IBlockState findBlockUnderEntity(Entity parEntity)
    {
    	return parEntity.world.getBlockState(new BlockPos(this.posX, this.posY- 0.25D, this.posZ));
    }
    
    /**
	 * This checks if the block -0.25 below the entity is an air block.
	 */
    protected boolean isBlockUnderEntityAir()
    {
    	if (this.findBlockUnderEntity(this) == Blocks.AIR.getDefaultState())
    	{
    		return true;
    	}
    	
    	return false;
    }
    
    
    
	//==================================================
    // TODO              GUI Logic
	//==================================================
	
    /**
     * Opens the machine GUI on button press.
     */
    protected void controlMachineGui()
    {
    	if (this.openGuiMenuInputDown 
    	&& this.getControllingPassenger() != null)
		{
    		NetworkHandler.sendToServer(new MessageMachineGuiMenuMain());
        	Minecraft.getMinecraft().setIngameFocus();
        }
    }
    
    
    
    protected void applyFrameUpgrade()
    {
    	if(!this.world.isRemote)
    	{
    		
	    	if(this.frameTier == 1)
	    	{
	    		if(!this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(MachineModifier.HEALTH_UPGRADE_FRAME_TIER_1))
	    		{
					this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(MachineModifier.HEALTH_UPGRADE_FRAME_TIER_1);
					this.heal(getMaxHealth());
	    		}
	    		//.getAttributeValue()
	    		//Increase HP
	    		
	    		//Increase MP
	    		
	    	}
	    	else
	    	{
	    		//this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeAllModifiers();
	    		
	    		//if(this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(MachineModifier.HEALTH_UPGRADE_FRAME_TIER_1))
	    		//{
				//	this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(MachineModifier.HEALTH_UPGRADE_FRAME_TIER_1);
				//	this.setHealth(getMaxHealth());
	    		//}
	    	}
	    	
	    	if(this.frameTier == 2)
	    	{
	    		//Increase HP
	    		
	    		//Increase MP
	    		
	    	}
	    	
	    	if(this.frameTier == 3)
	    	{
	    		//Increase HP
	    		
	    		//Increase MP
	    		
	    	}
    	}
    }
}
