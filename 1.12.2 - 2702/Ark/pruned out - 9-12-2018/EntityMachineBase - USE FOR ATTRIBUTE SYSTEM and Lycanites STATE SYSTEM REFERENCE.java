package com.vies.viesmachines.common.entity.machines;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.vies.viesmachines.api.EnumsVC;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.client.InitParticlesVCRender;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.MessageMachineProjectileBulletDamage;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;

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
import net.minecraft.item.ItemStack;
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
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
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
	//public static final IAttribute MAX_ENERGY = (new RangedAttribute(null, References.MOD_ID + ".maxEnergy", 100.0D, Float.MIN_VALUE, 1024.0D)).setShouldWatch(true);
	//public static final IAttribute DEFENSE = (new RangedAttribute(null, "generic.defense", 4.0D, 0.0D, 1024.0D)).setShouldWatch(true);
	
	// Data Manager:
	/** Keeps track of the frame tier. */
	private static final DataParameter<Integer> FRAME_TIER_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the engine tier. */
	private static final DataParameter<Integer> ENGINE_TIER_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the component tier. */
	private static final DataParameter<Integer> COMPONENT_TIER_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the special stat, part of Component Tier. (Flying = Max Altitude / Ground = Jump Height / Water = Max Oxygen) */
	private static final DataParameter<Integer> SPECIAL_STAT_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
  	
	/** Keeps track of the machine "on" toggle. */
	private static final DataParameter<Boolean> TURNED_ON_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the machine armed toggle. */
	private static final DataParameter<Boolean> ARMED_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the machine ammo amount. */
	private static final DataParameter<Integer> AMMO_AMOUNT_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the machine ammo type. */
	private static final DataParameter<Integer> AMMO_TYPE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	
	/** Keeps track of a machine's energy value. */
	private static final DataParameter<Integer> ENERGY_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the forward speed. */
	private static final DataParameter<Float> FORWARD_SPEED_DM = EntityDataManager.<Float>createKey(EntityMachineBase.class, DataSerializers.FLOAT);
	/** Keeps track of the turn speed. */
	private static final DataParameter<Float> TURN_SPEED_DM = EntityDataManager.<Float>createKey(EntityMachineBase.class, DataSerializers.FLOAT);
	/** Keeps track of the broken state. */
	private static final DataParameter<Boolean> BROKEN_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the autorun. */
	private static final DataParameter<Boolean> AUTORUN_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the current active machine Enhancement slot 1. */
	private static final DataParameter<Integer> MACHINE_ENHANCEMENT_1_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the primed for lightning strike in ticks. */
	private static final DataParameter<Integer> PRIMED_FOR_LIGHTNING_STRIKE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
  	
	
	
	/** Keeps track of what machine type is active. (Airship, Helicopter, etc) */
    protected static final DataParameter<Integer> VISUAL_TYPE_MODEL_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of what machine variant is active. (Hindenburg, dirigible, etc) */
    protected static final DataParameter<Integer> VISUAL_VARIANT_MODEL_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of the frame texture. */
    protected static final DataParameter<Integer> VISUAL_FRAME_TEXTURE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the frame texture transparency. */
    protected static final DataParameter<Boolean> VISUAL_FRAME_TRANSPARENT_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
    /** Keeps track of the frame texture color. */
    protected static final DataParameter<Boolean> VISUAL_FRAME_COLOR_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
    /** Keeps track of the frame red color value. */
    protected static final DataParameter<Integer> VISUAL_FRAME_COLOR_RED_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the frame green color value. */
    protected static final DataParameter<Integer> VISUAL_FRAME_COLOR_GREEN_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the frame blue color value. */
    protected static final DataParameter<Integer> VISUAL_FRAME_COLOR_BLUE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of the particle texture. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_PARTICLE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display type. (Block, Item, Head, etc...) */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_TYPE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display itemstack id. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_ITEMSTACK_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display itemstack metadata value. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display head value. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_HEAD_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display supporter head value. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display holiday value. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_HOLIDAY_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of the component texture. */
    protected static final DataParameter<Integer> VISUAL_COMPONENT_TEXTURE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the component texture transparency. */
    protected static final DataParameter<Boolean> VISUAL_COMPONENT_TRANSPARENT_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
    /** Keeps track of the component texture color. */
    protected static final DataParameter<Boolean> VISUAL_COMPONENT_COLOR_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
    /** Keeps track of the component red color value. */
    protected static final DataParameter<Integer> VISUAL_COMPONENT_COLOR_RED_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the component green color value. */
    protected static final DataParameter<Integer> VISUAL_COMPONENT_COLOR_GREEN_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the component blue color value. */
    protected static final DataParameter<Integer> VISUAL_COMPONENT_COLOR_BLUE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of the customName color value. */
    protected static final DataParameter<Integer> VISUAL_NAME_COLOR_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    
    
    //===============================================================
	
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
    
    //===============================================================
    
    
    
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
    /** The special stat (component). (Flying = Max Altitude / Ground = Jump Height / Water = Max Oxygen) */
    public int specialStat;
    
    /** Is this machine turned on? */
    public boolean machineTurnedOn;
    //** Amount of energy points. */
    //public static int storedEnergy;
    /** Forward speed of the machine. */
    public static float forwardSpeed;
    /** Turn speed of the machine. */
    public static float turnSpeed;
    /** Is this machine broken? */
    public boolean broken;
    /** Is this machine set for autorun? */
    public boolean autorun;
    /** Has autorun been triggered? */
    public boolean autorunTrigger;
    /** The currently active machine enhancement slot 1. */
    public int machineEnhancement1;
    
    /** Is this machine armed? */
    public boolean armed;
    /** Amount of ammo. */
    public int ammoAmount;
    /** Type of ammo. */
    public int ammoType;
    
    
    
    /** What machine type is active. (Airship, Helicopter, etc) */
    public int visualTypeModel;
    /** What machine variant is active. (Hindenburg, Dirigible, etc) */
    public int visualVariantModel;
    
    /** Current frame texture. */
    public int visualFrameTexture;
    /** Is the frame texture semi-transparent? */
    public boolean visualFrameTransparent;
    /** Is the frame being colored? */
    public boolean visualFrameColor;
    /** Current frame color value. (Red) */
    public int visualFrameColorRed;
    /** Current frame color value. (Green) */
    public int visualFrameColorGreen;
    /** Current frame color value. (Blue) */
    public int visualFrameColorBlue;
    
    /** Current particle texture. */
    public int visualEngineParticle;
    /** Current display type. (Block, Item, Head, etc...) */
    public int visualEngineDisplayType;
    /** Current display itemstack id. */
    public int visualEngineDisplayItemstack;
    /** Current display itemstack metadata value. */
    public int visualEngineDisplayItemstackMeta;
    /** Current display head value. */
    public int visualEngineDisplayHead;
    /** Current display supporter head value. */
    public int visualEngineDisplaySupporterHead;
    /** Current display holiday value. */
    public int visualEngineDisplayHoliday;
    
    /** Current component texture. */
    public int visualComponentTexture;
    /** Is the component texture semi-transparent? */
    public boolean visualComponentTransparent;
    /** Is the component being colored? */
    public boolean visualComponentColor;
    /** Current component color value. (Red) */
    public int visualComponentColorRed;
    /** Current component color value. (Green) */
    public int visualComponentColorGreen;
    /** Current component color value. (Blue) */
    public int visualComponentColorBlue;
    /** Current name color value. */
    public int visualNameColor;
    
    
    
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
	
	/** Stores the entity ID for passing into lightning strikes.  */
	public static int entityID;
    
	/** Keeps count of the number of charges before a lightning strike happens. 20 charges equals 1 strike.*/
	protected int primedForLightningStrike;
	
	/** Keeps count of the firing cooldown. */
	protected int weaponCooldown;
	
	
	
	// Inventory:
	/**
	 * SLOTS: <br> <br>
	 *
	 * Slot  0 = Fuel Slot<br>
	 * Slot  1 = Ammo Slot <br>
	 //* Slot  2 = Ammo Slot <br>
	 //* Slot  1 = Upgrade Core <br>
	 //* Slot  2 = Upgrade Frame <br>
	 //* Slot  3 = Upgrade Engine <br>
	 //* Slot  4 = Upgrade Balloon <br>
	 //* Slot 11 = Module Slot1 <br>
	 //* Slot 12 = Module Slot2 <br>
	 //* Slot 16 = Redstone Slot <br>
	 * Slot 18 = Block/Item to Display <br>
	 * Slot 20-28 = Inventory Small <br>
	 * Slot 20-37 = Inventory Large <br>
	 //* Slot 51 = Bomb Slot1 <br>
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
    protected boolean shootProjectileInputDown;
    protected boolean toggleAbilityInputDown;
    
    // Radio:
    /** Stores the selected song using the int position of the musicListRecord array. */
    public static int selectedSong;
	
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

	public EntityMachineBase(World worldIn, double x, double y, double z,
			
			int frameTierIn, int engineTierIn, int componentTierIn,
			float currentHPIn, int currentEPIn, 
			int currentFuelIn, int totalFuelIn,
			int itemstackFuelItemIn, int itemstackFuelSizeIn,
			boolean brokenIn, int machineEnhancement1In,
			
			int ammoAmountIn, int ammoTypeIn,
			
			int visualTypeModelIn, int visualVariantModelIn,
			
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
        
        //this.getAttributeMap().registerAttribute(MAX_ENERGY);
        
        //this.getEntityAttribute(MAX_ENERGY).setBaseValue(EnumsVC.FlyingMachineFrameTier.byId(this.frameTier).getMaxEnergyModifier());
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVC.FlyingMachineFrameTier.byId(this.frameTier).getMaxHealthModifier());
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EnumsVC.FlyingMachineEngineTier.byId(this.engineTier).getFowardSpeedModifier());
    }
	
	/** 
	 * Initiates the entity, setting all the values to be watched by the data watcher. 
	 */
	@Override
    protected void entityInit()
    {
        super.entityInit();
        
        this.dataManager.register(TURNED_ON_DM, Boolean.valueOf(this.machineTurnedOn));
        this.dataManager.register(ENERGY_DM, Integer.valueOf(0)
        		//Integer.valueOf(this.storedEnergy)
        		);
        this.dataManager.register(FORWARD_SPEED_DM, Float.valueOf(this.forwardSpeed));
        this.dataManager.register(TURN_SPEED_DM, Float.valueOf(this.turnSpeed));
        this.dataManager.register(BROKEN_DM, Boolean.valueOf(this.broken));
        this.dataManager.register(AUTORUN_DM, Boolean.valueOf(false));
        this.dataManager.register(ARMED_DM, Boolean.valueOf(false));
        this.dataManager.register(AMMO_AMOUNT_DM, Integer.valueOf(this.ammoAmount));
        this.dataManager.register(AMMO_TYPE_DM, Integer.valueOf(this.ammoType));
        this.dataManager.register(MACHINE_ENHANCEMENT_1_DM, Integer.valueOf(this.machineEnhancement1));
        this.dataManager.register(PRIMED_FOR_LIGHTNING_STRIKE_DM, Integer.valueOf(this.primedForLightningStrike));
        
        this.dataManager.register(FRAME_TIER_DM, Integer.valueOf(this.frameTier));
        this.dataManager.register(ENGINE_TIER_DM, Integer.valueOf(this.engineTier));
        this.dataManager.register(COMPONENT_TIER_DM, Integer.valueOf(this.componentTier));
        this.dataManager.register(SPECIAL_STAT_DM, Integer.valueOf(this.specialStat));
        
        this.dataManager.register(VISUAL_TYPE_MODEL_DM, Integer.valueOf(this.visualTypeModel));
        this.dataManager.register(VISUAL_VARIANT_MODEL_DM, Integer.valueOf(this.visualVariantModel));
        
        this.dataManager.register(VISUAL_FRAME_TEXTURE_DM, Integer.valueOf(this.visualFrameTexture));
        this.dataManager.register(VISUAL_FRAME_TRANSPARENT_DM, Boolean.valueOf(this.visualFrameTransparent));
        this.dataManager.register(VISUAL_FRAME_COLOR_DM, Boolean.valueOf(this.visualFrameColor));
        this.dataManager.register(VISUAL_FRAME_COLOR_RED_DM, Integer.valueOf(this.visualFrameColorRed));
        this.dataManager.register(VISUAL_FRAME_COLOR_GREEN_DM, Integer.valueOf(this.visualFrameColorGreen));
        this.dataManager.register(VISUAL_FRAME_COLOR_BLUE_DM, Integer.valueOf(this.visualFrameColorBlue));
        
        this.dataManager.register(VISUAL_ENGINE_PARTICLE_DM, Integer.valueOf(this.visualEngineParticle));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_TYPE_DM, Integer.valueOf(this.visualEngineDisplayType));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_ITEMSTACK_DM, Integer.valueOf(this.visualEngineDisplayItemstack));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_DM, Integer.valueOf(this.visualEngineDisplayItemstackMeta));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_HEAD_DM, Integer.valueOf(this.visualEngineDisplayHead));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_DM, Integer.valueOf(this.visualEngineDisplaySupporterHead));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_HOLIDAY_DM, Integer.valueOf(this.visualEngineDisplayHoliday));
        
        this.dataManager.register(VISUAL_COMPONENT_TEXTURE_DM, Integer.valueOf(this.visualComponentTexture));
        this.dataManager.register(VISUAL_COMPONENT_TRANSPARENT_DM, Boolean.valueOf(this.visualComponentTransparent));
        this.dataManager.register(VISUAL_COMPONENT_COLOR_DM, Boolean.valueOf(this.visualComponentColor));
        this.dataManager.register(VISUAL_COMPONENT_COLOR_RED_DM, Integer.valueOf(this.visualComponentColorRed));
        this.dataManager.register(VISUAL_COMPONENT_COLOR_GREEN_DM, Integer.valueOf(this.visualComponentColorGreen));
        this.dataManager.register(VISUAL_COMPONENT_COLOR_BLUE_DM, Integer.valueOf(this.visualComponentColorBlue));
        
        this.dataManager.register(VISUAL_NAME_COLOR_DM, Integer.valueOf(this.visualNameColor));
        
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
		
		compound.setFloat(rf.ENERGY_TAG, this.getEnergy());
		//compound.setInteger(rf.ENERGY_POINTS_TAG, this.storedEnergy);
		compound.setBoolean(rf.MACHINE_TURNED_ON_TAG, this.machineTurnedOn);
		compound.setFloat(rf.FORWARD_SPEED_TAG, this.forwardSpeed);
		compound.setFloat(rf.TURN_SPEED_TAG, this.turnSpeed);
		compound.setBoolean(rf.BROKEN_MACHINE_TAG, this.broken);
		compound.setBoolean(rf.AUTORUN_MACHINE_TAG, this.autorun);
		compound.setBoolean(rf.ARMED_MACHINE_TAG, this.armed);
		compound.setInteger(rf.AMMO_AMOUNT_TAG, this.ammoAmount);
		compound.setInteger(rf.AMMO_TYPE_TAG, this.ammoType);
		compound.setInteger(rf.SELECTED_SONG_TAG, this.selectedSong);
		compound.setInteger(rf.MACHINE_ENHANCEMENT_1_TAG, this.machineEnhancement1);
		compound.setInteger(rf.PRIMED_FOR_LIGHTNING_STRIKE_TAG, this.primedForLightningStrike);
		
		compound.setInteger(rf.FRAME_TIER_TAG, this.frameTier);
		compound.setInteger(rf.ENGINE_TIER_TAG, this.engineTier);
		compound.setInteger(rf.COMPONENT_TIER_TAG, this.componentTier);
		compound.setInteger(rf.SPECIAL_STAT_TAG, this.specialStat);
		
		compound.setInteger(rf.VISUAL_TYPE_MODEL_TAG, this.visualTypeModel);
		compound.setInteger(rf.VISUAL_VARIANT_MODEL_TAG, this.visualVariantModel);
    	
    	compound.setInteger(rf.VISUAL_FRAME_TEXTURE_TAG, this.visualFrameTexture);
    	compound.setBoolean(rf.VISUAL_FRAME_TRANSPARENT_TAG, this.visualFrameTransparent);
    	compound.setBoolean(rf.VISUAL_FRAME_COLOR_TAG, this.visualFrameColor);
    	compound.setInteger(rf.VISUAL_FRAME_COLOR_RED_TAG, this.visualFrameColorRed);
    	compound.setInteger(rf.VISUAL_FRAME_COLOR_GREEN_TAG, this.visualFrameColorGreen);
    	compound.setInteger(rf.VISUAL_FRAME_COLOR_BLUE_TAG, this.visualFrameColorBlue);
    	
    	compound.setInteger(rf.VISUAL_ENGINE_PARTICLE_TAG, this.visualEngineParticle);
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_TYPE_TAG, this.visualEngineDisplayType);
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG, this.visualEngineDisplayItemstack);
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG, this.visualEngineDisplayItemstackMeta);
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_HEAD_TAG, this.visualEngineDisplayHead);
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG, this.visualEngineDisplaySupporterHead);
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG, this.visualEngineDisplayHoliday);
    	
    	compound.setInteger(rf.VISUAL_COMPONENT_TEXTURE_TAG, this.visualComponentTexture);
    	compound.setBoolean(rf.VISUAL_COMPONENT_TRANSPARENT_TAG, this.visualComponentTransparent);
    	compound.setBoolean(rf.VISUAL_COMPONENT_COLOR_TAG, this.visualComponentColor);
    	compound.setInteger(rf.VISUAL_COMPONENT_COLOR_RED_TAG, this.visualComponentColorRed);
    	compound.setInteger(rf.VISUAL_COMPONENT_COLOR_GREEN_TAG, this.visualComponentColorGreen);
    	compound.setInteger(rf.VISUAL_COMPONENT_COLOR_BLUE_TAG, this.visualComponentColorBlue);
    	
    	compound.setInteger(rf.VISUAL_NAME_COLOR_TAG, this.visualNameColor);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
		super.readEntityFromNBT(compound);
		
		this.inventory.deserializeNBT(compound.getCompoundTag(rf.MACHINE_SLOTS_TAG));
    	
		
		
		if (compound.hasKey(rf.ENERGY_TAG, 99))
        {
            this.setEnergy(compound.getInteger(rf.ENERGY_TAG));
        }
		//this.storedEnergy = compound.getInteger(rf.ENERGY_POINTS_TAG);
		this.machineTurnedOn = compound.getBoolean(rf.MACHINE_TURNED_ON_TAG);
		this.forwardSpeed = compound.getFloat(rf.FORWARD_SPEED_TAG);
		this.turnSpeed = compound.getFloat(rf.TURN_SPEED_TAG);
		this.broken = compound.getBoolean(rf.BROKEN_MACHINE_TAG);
		this.autorun = compound.getBoolean(rf.AUTORUN_MACHINE_TAG);
		this.armed = compound.getBoolean(rf.ARMED_MACHINE_TAG);
		this.ammoAmount = compound.getInteger(rf.AMMO_AMOUNT_TAG);
		this.ammoType = compound.getInteger(rf.AMMO_TYPE_TAG);
		this.selectedSong = compound.getInteger(rf.SELECTED_SONG_TAG);
		this.machineEnhancement1 = compound.getInteger(rf.MACHINE_ENHANCEMENT_1_TAG);
		this.primedForLightningStrike = compound.getInteger(rf.PRIMED_FOR_LIGHTNING_STRIKE_TAG);
		
		this.frameTier = compound.getInteger(rf.FRAME_TIER_TAG);
		this.engineTier = compound.getInteger(rf.ENGINE_TIER_TAG);
		this.componentTier = compound.getInteger(rf.COMPONENT_TIER_TAG);
		this.specialStat = compound.getInteger(rf.SPECIAL_STAT_TAG);
		
		this.visualTypeModel = compound.getInteger(rf.VISUAL_TYPE_MODEL_TAG);
		this.visualVariantModel = compound.getInteger(rf.VISUAL_VARIANT_MODEL_TAG);
    	
    	this.visualFrameTexture = compound.getInteger(rf.VISUAL_FRAME_TEXTURE_TAG);
    	this.visualFrameTransparent = compound.getBoolean(rf.VISUAL_FRAME_TRANSPARENT_TAG);
    	this.visualFrameColor = compound.getBoolean(rf.VISUAL_FRAME_COLOR_TAG);
    	this.visualFrameColorRed = compound.getInteger(rf.VISUAL_FRAME_COLOR_RED_TAG);
    	this.visualFrameColorGreen = compound.getInteger(rf.VISUAL_FRAME_COLOR_GREEN_TAG);
    	this.visualFrameColorBlue = compound.getInteger(rf.VISUAL_FRAME_COLOR_BLUE_TAG);
    	
    	this.visualEngineParticle = compound.getInteger(rf.VISUAL_ENGINE_PARTICLE_TAG);
    	this.visualEngineDisplayType = compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_TYPE_TAG);
    	this.visualEngineDisplayItemstack = compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG);
    	this.visualEngineDisplayItemstackMeta = compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG);
    	this.visualEngineDisplayHead = compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_HEAD_TAG);
    	this.visualEngineDisplaySupporterHead = compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG);
    	this.visualEngineDisplayHoliday = compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG);
    	
    	this.visualComponentTexture = compound.getInteger(rf.VISUAL_COMPONENT_TEXTURE_TAG);
    	this.visualComponentTransparent = compound.getBoolean(rf.VISUAL_COMPONENT_TRANSPARENT_TAG);
    	this.visualComponentColor = compound.getBoolean(rf.VISUAL_COMPONENT_COLOR_TAG);
    	this.visualComponentColorRed = compound.getInteger(rf.VISUAL_COMPONENT_COLOR_RED_TAG);
    	this.visualComponentColorGreen = compound.getInteger(rf.VISUAL_COMPONENT_COLOR_GREEN_TAG);
    	this.visualComponentColorBlue = compound.getInteger(rf.VISUAL_COMPONENT_COLOR_BLUE_TAG);
    	
    	this.visualNameColor = compound.getInteger(rf.VISUAL_NAME_COLOR_TAG);
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
        
		//----------------------------------

        //this.frameTier = 0;
        //LogHelper.info(this.getEntityId() + "Is On = " + this.machineTurnedOn);
        //LogHelper.info(this.getEntityId() + "Energy = " + this.energyPoints);

        //LogHelper.info(this.getEntityId() + "player = " + this.getControllingPassenger());
        //if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(MachineModifier.DASHING_SPEED_BOOST))
		//{
		//	this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(MachineModifier.DASHING_SPEED_BOOST);
		//}
        
        //----------------------------------
		
        this.entityID = this.getEntityId();
        
		this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        
        super.onUpdate();
        
        this.previousStatus = this.status;
        this.status = this.getMachineStatus();
        
        if (this.canPassengerSteer())
        {
        	this.controlAirship();
        	
        	if (this.world.isRemote)
            {
        		this.updateInputs();
        		this.controlMachineGui();
        		this.weaponMachineGui();
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
        this.applyFrameUpgrade();
        this.weaponFiringCooldown();

        //////////////LogHelper.info(this.getEnergy());
        
        /**
        LogHelper.info(this.status);
        
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
        
        if (this.broken && this.machineTurnedOn)
        {
        	this.machineTurnedOn = false;
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
	@SideOnly(Side.CLIENT)
    protected SoundEvent getHealSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SHULKER_BULLET_HIT;
    }
	
	@SideOnly(Side.CLIENT)
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
	@SideOnly(Side.CLIENT)
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
	@SideOnly(Side.CLIENT)
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GENERIC_EXPLODE;
    }

	/**
	 * Gets the sound to be triggered when a machine hits the ground while falling.
	 */
	@Override
	@SideOnly(Side.CLIENT)
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
    	this.machineTurnedOn = false;
    	this.autorun = false;
    	this.armed = false;
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
        this.shootProjectileInputDown = Keybinds.shootProjectile.isPressed();
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
            
            if (this.broken 
            || !this.machineTurnedOn)
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
    						this.deltaRotation -= (float) this.turnSpeed;
						}
    					else
    					{
    						this.deltaRotation -= 0.05D;
    					}
            		}
    				else
    				{
    					this.deltaRotation -= (float) this.turnSpeed;
    				}
	            }
	            
	            // Turn Right:
	            if (this.rightInputDown)
	            {
	            	if (this.isFuelNeeded())
    				{
	            		if (this.isFuelBurning())
    					{
    						this.deltaRotation += (float) this.turnSpeed;
    					}
    					else
    					{
    						this.deltaRotation += 0.05D;
    					}
            		}
    				else
    				{
    					this.deltaRotation += (float) this.turnSpeed;
    				}
	            }
	            
	            // Left or Right, with Forward and no Backward:
	            if (//this.rightInputDown != this.leftInputDown 
        		//&& 
        		this.forwardInputDown 
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
	            if (//this.rightInputDown != this.leftInputDown 
        		//&& 
	            !this.forwardInputDown 
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
        	//this.storedEnergy = this.getStoredEnergy();
        	this.forwardSpeed = this.getForwardSpeed();
        	this.turnSpeed = this.getTurnSpeed();
        	this.machineTurnedOn = this.getMachineTurnedOn();
        	this.broken = this.getBroken();
        	this.autorun = this.getAutorun();
        	this.armed = this.getArmed();
        	this.ammoAmount = this.getAmmoAmount();
        	this.ammoType = this.getAmmoType();
        	this.machineEnhancement1 = this.getMachineEnhancement1();
        	this.primedForLightningStrike = this.getPrimedForLightningStrike();
        	
        	this.frameTier = this.getFrameTier();
        	this.engineTier = this.getEngineTier();
        	this.componentTier = this.getComponentTier();
        	this.specialStat = this.getSpecialStat();
        	
        	this.visualTypeModel = this.getVisualTypeModel();
        	this.visualVariantModel = this.getVisualVariantModel();
        	
            this.visualFrameTexture = this.getVisualFrameTexture();
            this.visualFrameTransparent = this.getVisualFrameTransparent();
            this.visualFrameColor = this.getVisualFrameColor();
            this.visualFrameColorRed = this.getVisualFrameColorRed();
            this.visualFrameColorGreen = this.getVisualFrameColorGreen();
            this.visualFrameColorBlue = this.getVisualFrameColorBlue();
            
            this.visualEngineParticle = this.getVisualEngineParticle();
            this.visualEngineDisplayType = this.getVisualEngineDisplayType();
            this.visualEngineDisplayItemstack = this.getVisualEngineDisplayItemstack();
            this.visualEngineDisplayItemstackMeta = this.getVisualEngineDisplayItemstackMeta();
            this.visualEngineDisplayHead = this.getVisualEngineDisplayHead();
            this.visualEngineDisplaySupporterHead = this.getVisualEngineDisplaySupporterHead();
            this.visualEngineDisplayHoliday = this.getVisualEngineDisplayHoliday();
            
            this.visualComponentTexture = this.getVisualComponentTexture();
            this.visualComponentTransparent = this.getVisualComponentTransparent();
            this.visualComponentColor = this.getVisualComponentColor();
            this.visualComponentColorRed = this.getVisualComponentColorRed();
            this.visualComponentColorGreen = this.getVisualComponentColorGreen();
            this.visualComponentColorBlue = this.getVisualComponentColorBlue();
            
            this.visualNameColor = this.getVisualNameColor();
        }
        else
        {
        	//this.setStoredEnergy(this.storedEnergy);
        	this.setForwardSpeed(this.forwardSpeed);
        	this.setTurnSpeed(this.turnSpeed);
        	this.setMachineTurnedOn(this.machineTurnedOn);
        	this.setBroken(this.broken);
        	this.setAutorun(this.autorun);
        	this.setArmed(this.armed);
        	this.setAmmoAmount(this.ammoAmount);
        	this.setAmmoType(this.ammoType);
        	this.setMachineEnhancement1(this.machineEnhancement1);
        	this.setPrimedForLightningStrike(this.primedForLightningStrike);
        	
        	this.setFrameTier(this.frameTier);
        	this.setEngineTier(this.engineTier);
        	this.setComponentTier(this.componentTier);
        	this.setSpecialStat(this.specialStat);
        	
        	this.setVisualTypeModel(this.visualTypeModel);
        	this.setVisualVariantModel(this.visualVariantModel);
            
            this.setVisualFrameTexture(this.visualFrameTexture);
            this.setVisualFrameTransparent(this.visualFrameTransparent);
            this.setVisualFrameColor(this.visualFrameColor);
            this.setVisualFrameColorRed(this.visualFrameColorRed);
            this.setVisualFrameColorGreen(this.visualFrameColorGreen);
            this.setVisualFrameColorBlue(this.visualFrameColorBlue);
            
            this.setVisualEngineParticle(this.visualEngineParticle);
            this.setVisualEngineDisplayType(this.visualEngineDisplayType);
            this.setVisualEngineDisplayItemstack(this.visualEngineDisplayItemstack);
            this.setVisualEngineDisplayItemstackMeta(this.visualEngineDisplayItemstackMeta);
            this.setVisualEngineDisplayHead(this.visualEngineDisplayHead);
            this.setVisualEngineDisplaySupporterHead(this.visualEngineDisplaySupporterHead);
            this.setVisualEngineDisplayHoliday(this.visualEngineDisplayHoliday);
            
            this.setVisualComponentTexture(this.visualComponentTexture);
            this.setVisualComponentTransparent(this.visualComponentTransparent);
            this.setVisualComponentColor(this.visualComponentColor);
            this.setVisualComponentColorRed(this.visualComponentColorRed);
            this.setVisualComponentColorGreen(this.visualComponentColorGreen);
            this.setVisualComponentColorBlue(this.visualComponentColorBlue);
            
            this.setVisualNameColor(this.visualNameColor);
        }
    }
    
    @Override
    public void heal(float healAmount)
    {
        super.heal(healAmount);
        
        this.playHealSound(null);
    }
    
    
    
    /** Gets the energy value of a machine. */
    public final int getEnergy()
    {
        return ((Integer)this.dataManager.get(ENERGY_DM)).intValue();
    }
    /** Sets the energy value of a machine. */
    public void setEnergy(int intIn)
    {
        this.dataManager.set(ENERGY_DM, MathHelper.clamp(intIn, 0, this.getMaxEnergy()));
    }
    
    /** Gets the max energy value of a machine. */
    public int getMaxEnergy()
    {
        return EnumsVC.FlyingMachineFrameTier.byId(this.getFrameTier()).getMaxEnergyModifier();
    }
    
    /**
     * Returns the maximum energy points of the machine. (What it is able to rise up to, what it spawned with, etc.)
     */
    //public final int getMaxEnergyPoints()
    //{
    //    return (int)this.getEntityAttribute(MAX_ENERGY).getAttributeValue();
    //}
    
    /** Replenish a machine's energy points. */
    public void replenishEnergy(int healAmount)
    {
        if (healAmount <= 0)
    	{
    		return;
    	}
        
        int f = this.getEnergy();

        if ((f + healAmount) <= this.getMaxEnergy())
        {
        	this.setEnergy(f + healAmount);
        }
    }
    
    //--------------------------------------------------
    
    /** Sets the special stat (component). (Flying = Max Altitude / Ground = Jump Height / Water = Max Oxygen) */
    protected void setSpecialStat(int intIn)
    {
        this.dataManager.set(SPECIAL_STAT_DM, Integer.valueOf(intIn));
    }
    /** Gets the special stat (component). (Flying = Max Altitude / Ground = Jump Height / Water = Max Oxygen) */
    protected int getSpecialStat()
    {
        return ((Integer)this.dataManager.get(SPECIAL_STAT_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Machine Turned On boolean. */
    protected void setMachineTurnedOn(boolean booleanIn)
    {
        this.dataManager.set(TURNED_ON_DM, Boolean.valueOf(booleanIn));
    }
    /** Gets the Machine Turned On boolean. */
    protected boolean getMachineTurnedOn()
    {
        return ((Boolean)this.dataManager.get(TURNED_ON_DM)).booleanValue();
    }
    
    /** Sets the Broken Machine boolean. */
    protected void setBroken(boolean booleanIn)
    {
        this.dataManager.set(BROKEN_DM, Boolean.valueOf(booleanIn));
    }
    /** Gets the Broken Machine boolean. */
    protected boolean getBroken()
    {
        return ((Boolean)this.dataManager.get(BROKEN_DM)).booleanValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Autorun Machine boolean. */
    protected void setAutorun(boolean booleanIn)
    {
        this.dataManager.set(AUTORUN_DM, Boolean.valueOf(booleanIn));
    }
    /** Gets the Autorun Machine boolean. */
    protected boolean getAutorun()
    {
        return ((Boolean)this.dataManager.get(AUTORUN_DM)).booleanValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Armed Machine boolean. */
    protected void setArmed(boolean booleanIn)
    {
        this.dataManager.set(ARMED_DM, Boolean.valueOf(booleanIn));
    }
    /** Gets the Armed Machine boolean. */
    protected boolean getArmed()
    {
        return ((Boolean)this.dataManager.get(ARMED_DM)).booleanValue();
    }
    
    /** Sets the ammo amount. */
    protected void setAmmoAmount(int intIn)
    {
        this.dataManager.set(AMMO_AMOUNT_DM, Integer.valueOf(intIn));
    }
    /** Gets the ammo amount. */
    protected int getAmmoAmount()
    {
        return ((Integer)this.dataManager.get(AMMO_AMOUNT_DM)).intValue();
    }
    
    /** Sets the ammo type. */
    protected void setAmmoType(int intIn)
    {
        this.dataManager.set(AMMO_TYPE_DM, Integer.valueOf(intIn));
    }
    /** Gets the ammo type. */
    protected int getAmmoType()
    {
        return ((Integer)this.dataManager.get(AMMO_TYPE_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the frame tier. */
    protected void setFrameTier(int intIn)
    {
        this.dataManager.set(FRAME_TIER_DM, Integer.valueOf(intIn));
    }
    /** Gets the frame tier. */
    protected int getFrameTier()
    {
        return ((Integer)this.dataManager.get(FRAME_TIER_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the engine tier. */
    protected void setEngineTier(int intIn)
    {
        this.dataManager.set(ENGINE_TIER_DM, Integer.valueOf(intIn));
    }
    /** Gets the engine tier. */
    protected int getEngineTier()
    {
        return ((Integer)this.dataManager.get(ENGINE_TIER_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Component tier. */
    protected void setComponentTier(int intIn)
    {
        this.dataManager.set(COMPONENT_TIER_DM, Integer.valueOf(intIn));
    }
    /** Gets the Component tier. */
    protected int getComponentTier()
    {
        return ((Integer)this.dataManager.get(COMPONENT_TIER_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the Forward Speed. */
    protected void setForwardSpeed(float floatIn)
    {
        this.dataManager.set(FORWARD_SPEED_DM, Float.valueOf(floatIn));
    }
    /** Gets the Forward Speed. */
    protected float getForwardSpeed()
    {
        return ((Float)this.dataManager.get(FORWARD_SPEED_DM)).floatValue();
    }
    
    /** Sets the Turn Speed. */
    protected void setTurnSpeed(float floatIn)
    {
        this.dataManager.set(TURN_SPEED_DM, Float.valueOf(floatIn));
    }
    /** Gets the Turn Speed. */
    protected float getTurnSpeed()
    {
        return ((Float)this.dataManager.get(TURN_SPEED_DM)).floatValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the machine enhancement 1. */
    protected void setMachineEnhancement1(int intIn)
    {
        this.dataManager.set(MACHINE_ENHANCEMENT_1_DM, Integer.valueOf(intIn));
    }
    /** Gets the machine enhancement 1. */
    protected int getMachineEnhancement1()
    {
        return ((Integer)this.dataManager.get(MACHINE_ENHANCEMENT_1_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /** Sets the primed for lightning strike in ticks. */
    protected void setPrimedForLightningStrike(int intIn)
    {
        this.dataManager.set(PRIMED_FOR_LIGHTNING_STRIKE_DM, Integer.valueOf(intIn));
    }
    /** Gets the primed for lightning strike in ticks. */
    protected int getPrimedForLightningStrike()
    {
        return ((Integer)this.dataManager.get(PRIMED_FOR_LIGHTNING_STRIKE_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    
    
    //--------------------------------------------------
    
    /**
     * Sets the Visual Type Model.
     */
    public void setVisualTypeModel(int intIn)
    {
        this.dataManager.set(VISUAL_TYPE_MODEL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Type Model.
     */
    public int getVisualTypeModel()
    {
        return ((Integer)this.dataManager.get(VISUAL_TYPE_MODEL_DM)).intValue();
    }
    
    /**
     * Sets the Visual Variant Model.
     */
    public void setVisualVariantModel(int intIn)
    {
        this.dataManager.set(VISUAL_VARIANT_MODEL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Variant Model.
     */
    public int getVisualVariantModel()
    {
        return ((Integer)this.dataManager.get(VISUAL_VARIANT_MODEL_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /**
     * Sets the Visual Frame Texture.
     */
    public void setVisualFrameTexture(int intIn)
    {
        this.dataManager.set(VISUAL_FRAME_TEXTURE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Frame Texture.
     */
    public int getVisualFrameTexture()
    {
        return ((Integer)this.dataManager.get(VISUAL_FRAME_TEXTURE_DM)).intValue();
    }
    
    /**
     * Sets the Visual Frame Transparent.
     */
    public void setVisualFrameTransparent(boolean booleanIn)
    {
        this.dataManager.set(VISUAL_FRAME_TRANSPARENT_DM, Boolean.valueOf(booleanIn));
    }
    /**
     * Gets the Visual Frame Transparent.
     */
    public boolean getVisualFrameTransparent()
    {
        return ((Boolean)this.dataManager.get(VISUAL_FRAME_TRANSPARENT_DM)).booleanValue();
    }
    
    /**
     * Sets the Visual Frame Color.
     */
    public void setVisualFrameColor(boolean booleanIn)
    {
        this.dataManager.set(VISUAL_FRAME_COLOR_DM, Boolean.valueOf(booleanIn));
    }
    /**
     * Gets the Visual Frame Color.
     */
    public boolean getVisualFrameColor()
    {
        return ((Boolean)this.dataManager.get(VISUAL_FRAME_COLOR_DM)).booleanValue();
    }
    
    /**
     * Sets the Visual Frame Color Red.
     */
    public void setVisualFrameColorRed(int intIn)
    {
        this.dataManager.set(VISUAL_FRAME_COLOR_RED_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Frame Color Red.
     */
    public int getVisualFrameColorRed()
    {
        return ((Integer)this.dataManager.get(VISUAL_FRAME_COLOR_RED_DM)).intValue();
    }
    
    /**
     * Sets the Visual Frame Color Green.
     */
    public void setVisualFrameColorGreen(int intIn)
    {
        this.dataManager.set(VISUAL_FRAME_COLOR_GREEN_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Frame Color Green.
     */
    public int getVisualFrameColorGreen()
    {
        return ((Integer)this.dataManager.get(VISUAL_FRAME_COLOR_GREEN_DM)).intValue();
    }
    
    /**
     * Sets the Visual Frame Color Blue.
     */
    public void setVisualFrameColorBlue(int intIn)
    {
        this.dataManager.set(VISUAL_FRAME_COLOR_BLUE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Frame Color Blue.
     */
    public int getVisualFrameColorBlue()
    {
        return ((Integer)this.dataManager.get(VISUAL_FRAME_COLOR_BLUE_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /**
     * Sets the Visual Engine Particle.
     */
    public void setVisualEngineParticle(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_PARTICLE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Particle.
     */
    public int getVisualEngineParticle()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_PARTICLE_DM)).intValue();
    }
    
    /**
     * Sets the Visual Engine Display Type.
     */
    public void setVisualEngineDisplayType(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_TYPE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Type.
     */
    public int getVisualEngineDisplayType()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_TYPE_DM)).intValue();
    }
    
    /**
     * Sets the Visual Engine Display Itemstack.
     */
    public void setVisualEngineDisplayItemstack(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_ITEMSTACK_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Itemstack.
     */
    public int getVisualEngineDisplayItemstack()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_ITEMSTACK_DM)).intValue();
    }
    
    /**
     * Sets the Visual Engine Display Itemstack Meta.
     */
    public void setVisualEngineDisplayItemstackMeta(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Itemstack Meta.
     */
    public int getVisualEngineDisplayItemstackMeta()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_DM)).intValue();
    }
    
    /**
     * Sets the Visual Engine Display Head.
     */
    public void setVisualEngineDisplayHead(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_HEAD_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Head.
     */
    public int getVisualEngineDisplayHead()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_HEAD_DM)).intValue();
    }
    
    /**
     * Sets the Visual Engine Display Supporter Head.
     */
    public void setVisualEngineDisplaySupporterHead(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Supporter Head.
     */
    public int getVisualEngineDisplaySupporterHead()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_DM)).intValue();
    }
    
    /**
     * Sets the Visual Engine Display Holiday.
     */
    public void setVisualEngineDisplayHoliday(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_HOLIDAY_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Holiday.
     */
    public int getVisualEngineDisplayHoliday()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_HOLIDAY_DM)).intValue();
    }
    
    //--------------------------------------------------
    
    /**
     * Sets the Visual Component Texture.
     */
    public void setVisualComponentTexture(int intIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_TEXTURE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Component Texture.
     */
    public int getVisualComponentTexture()
    {
        return ((Integer)this.dataManager.get(VISUAL_COMPONENT_TEXTURE_DM)).intValue();
    }
    
    /**
     * Sets the Visual Component Transparent.
     */
    public void setVisualComponentTransparent(boolean booleanIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_TRANSPARENT_DM, Boolean.valueOf(booleanIn));
    }
    /**
     * Gets the Visual Component Transparent.
     */
    public boolean getVisualComponentTransparent()
    {
        return ((Boolean)this.dataManager.get(VISUAL_COMPONENT_TRANSPARENT_DM)).booleanValue();
    }
    
    /**
     * Sets the Visual Component Color.
     */
    public void setVisualComponentColor(boolean booleanIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_COLOR_DM, Boolean.valueOf(booleanIn));
    }
    /**
     * Gets the Visual Component Color.
     */
    public boolean getVisualComponentColor()
    {
        return ((Boolean)this.dataManager.get(VISUAL_COMPONENT_COLOR_DM)).booleanValue();
    }
    
    /**
     * Sets the Visual Component Color Red.
     */
    public void setVisualComponentColorRed(int intIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_COLOR_RED_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Component Color Red.
     */
    public int getVisualComponentColorRed()
    {
        return ((Integer)this.dataManager.get(VISUAL_COMPONENT_COLOR_RED_DM)).intValue();
    }
    
    /**
     * Sets the Visual Component Color Green.
     */
    public void setVisualComponentColorGreen(int intIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_COLOR_GREEN_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Component Color Green.
     */
    public int getVisualComponentColorGreen()
    {
        return ((Integer)this.dataManager.get(VISUAL_COMPONENT_COLOR_GREEN_DM)).intValue();
    }
    
    /**
     * Sets the Visual Component Color Blue.
     */
    public void setVisualComponentColorBlue(int intIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_COLOR_BLUE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Component Color Blue.
     */
    public int getVisualComponentColorBlue()
    {
        return ((Integer)this.dataManager.get(VISUAL_COMPONENT_COLOR_BLUE_DM)).intValue();
    }
    
    /**
     * Sets the Visual Name Color.
     */
    public void setVisualNameColor(int intIn)
    {
        this.dataManager.set(VISUAL_NAME_COLOR_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Name Color.
     */
    public int getVisualNameColor()
    {
        return ((Integer)this.dataManager.get(VISUAL_NAME_COLOR_DM)).intValue();
    }
    
    
    
	//==================================================
    // TODO           Particles Logic
	//==================================================
    
    /**
     * Particles that spawn when a machine changes to broken.
     */
    @SideOnly(Side.CLIENT)
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
    @SideOnly(Side.CLIENT)
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
    
    /**
     * Particles that spawn when a machine is upgraded.
     */
    @SideOnly(Side.CLIENT)
    protected void upgradeParticles()
    {
	    if (this.world.isRemote)
		{
			for (int i = 0; i < 20; i++)
			{
				InitParticlesVCRender.generateExplosions(this);
			}
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
    // TODO              GUI Logic
	//==================================================
	
    /**
     * Opens the machine GUI on button press.
     */
    @SideOnly(Side.CLIENT)
    protected void controlMachineGui()
    {
    	if (this.openGuiMenuInputDown 
    	&& this.getControllingPassenger() != null)
		{
    		NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
        	Minecraft.getMinecraft().setIngameFocus();
        }
    }
    
    /**
     * Shoots a projectile on button press.
     */
    @SideOnly(Side.CLIENT)
    protected void weaponMachineGui()
    {
    	if (this.shootProjectileInputDown 
    	&& this.getControllingPassenger() != null
    	&& this.weaponCooldown >= this.weaponFiringCooldownTicks(this.ammoType))
		{
    		if (this.armed)
    		{
    			NetworkHandler.sendToServer(new MessageMachineProjectileBulletDamage());
    			
    			this.weaponCooldown = 0;
    		}
    		else
    		{
    			if (this.getRidingEntity() instanceof EntityPlayer)
    			{
    				EntityPlayer playerShooting = (EntityPlayer) this.getRidingEntity();
        			
        			playerShooting.sendMessage(new TextComponentString("This is sendmessage example string."));
    			}
    		}
        }
    }
    
    
    
    //==================================================
    // TODO              Custom Logic
	//==================================================
	
    /**
     * Get the Item form of the current Machine.
     */
    public ItemStack getItemMachine()
    {
		return null;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        if (this instanceof EntityMachineBase)
        {
        	return this.getItemMachine();
        }
        
        return null;
    }
    
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
    
    
    /**
     * Check to make sure stats are correct based on Tiers
     */
    protected void applyFrameUpgrade()
    {
    	//Frame
    	//Checks Max Health.
    	if (this.getMaxHealth() != EnumsVC.FlyingMachineFrameTier.byId(this.frameTier).getMaxHealthModifier())
    	{
    		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVC.FlyingMachineFrameTier.byId(this.frameTier).getMaxHealthModifier());
    		this.heal(((float) EnumsVC.FlyingMachineFrameTier.byId(this.frameTier).getMaxHealthModifier()) - this.getHealth());
    		this.upgradeParticles();
    	}
    	//Checks Max Machine Points.
    	//if (EnumsVC.FlyingMachineFrameTier.byId(this.frameTier).getMaxEnergyModifier()!= (int)EnumsVC.FlyingMachineFrameTier.byId(this.frameTier).getMaxEnergyModifier())
    	//{
    	//	this.getEntityAttribute(MAX_ENERGY).setBaseValue(EnumsVC.FlyingMachineFrameTier.byId(this.frameTier).getMaxEnergyModifier());
    	//	this.upgradeParticles();
    	//}
    	
    	//Engine
    	//Checks Forward Speed.
    	if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue() != EnumsVC.FlyingMachineEngineTier.byId(this.engineTier).getFowardSpeedModifier())
    	{
    		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EnumsVC.FlyingMachineEngineTier.byId(this.engineTier).getFowardSpeedModifier());
    		this.upgradeParticles();
    	}
    	
    	//Component
    	//Checks Turn Speed.
    	if (this.turnSpeed != EnumsVC.FlyingMachineEngineTier.byId(this.engineTier).getTurnSpeedModifier())
    	{
    		this.turnSpeed = (float) EnumsVC.FlyingMachineEngineTier.byId(this.engineTier).getTurnSpeedModifier();
    		//this.upgradeParticles();
    	}
    	//Checks special stat
    	if (this.specialStat != EnumsVC.FlyingMachineComponentTier.byId(this.componentTier).getSpecialStatModifier())
    	{
    		this.specialStat = EnumsVC.FlyingMachineComponentTier.byId(this.componentTier).getSpecialStatModifier();
    		this.upgradeParticles();
    	}
    }
    
    /**
     * Returns the string machine category name. (Used in GUI)
     */
	public String getCategoryName()
	{
		String machineCategoryName = "None";
		
		if(this.isGroundMachine())
		{
			machineCategoryName = "Ground";
		}
		if(this.isWaterMachine())
		{
			machineCategoryName = "Water";
		}
		if(this.isFlyingMachine())
		{
			machineCategoryName = "Flying";
		}
    	
		return machineCategoryName;
	}
	
	/**
     * Returns the string machine type name. (Used in GUI)
     */
	public String getTypeName()
	{
		String machineTypeName = "None";
		
		if(this.isGroundMachine())
		{
			if(this.visualTypeModel == 0)
			{
				machineTypeName = "Hovercraft";
			}
			if(this.visualTypeModel == 1)
			{
				machineTypeName = "Ground1";
			}
			if(this.visualTypeModel == 2)
			{
				machineTypeName = "Ground2";
			}
		}
		if(this.isWaterMachine())
		{
			if(this.visualTypeModel == 0)
			{
				machineTypeName = "Submarine";
			}
			if(this.visualTypeModel == 1)
			{
				machineTypeName = "Water1";
			}
			if(this.visualTypeModel == 2)
			{
				machineTypeName = "Water2";
			}
		}
		if(this.isFlyingMachine())
		{
			if(this.visualTypeModel == 0)
			{
				machineTypeName = "Airship";
			}
			if(this.visualTypeModel == 1)
			{
				machineTypeName = "Flying1";
			}
			if(this.visualTypeModel == 2)
			{
				machineTypeName = "Flying2";
			}
		}
    	
		return machineTypeName;
	}
	
	/**
     * Returns the string machine variant name. (Used in GUI)
     */
	public String getVariantName()
	{
		String machineVariantName = "None";
		
		if(this.isGroundMachine())
		{
			if(this.visualTypeModel == 0)
			{
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "0 G1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "0 G2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "0 G3";
				}
			}
			if(this.visualTypeModel == 1)
			{
				
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "1 G1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "1 G2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "1 G3";
				}
			}
			if(this.visualTypeModel == 2)
			{
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "2 G1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "2 G2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "2 G3";
				}
			}
		}
		if(this.isWaterMachine())
		{
			if(this.visualTypeModel == 0)
			{
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "0 W1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "0 W2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "0 W3";
				}
			}
			if(this.visualTypeModel == 1)
			{
				
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "1 W1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "1 W2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "1 W3";
				}
			}
			if(this.visualTypeModel == 2)
			{
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "2 W1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "2 W2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "2 W3";
				}
			}
		}
		if(this.isFlyingMachine())
		{
			if(this.visualTypeModel == 0)
			{
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "0 F1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "0 F2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "0 F3";
				}
			}
			if(this.visualTypeModel == 1)
			{
				
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "1 F1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "1 F2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "1 F3";
				}
			}
			if(this.visualTypeModel == 2)
			{
				if (this.visualVariantModel == 1)
				{
					machineVariantName = "2 F1";
				}
				if (this.visualVariantModel == 2)
				{
					machineVariantName = "2 F2";
				}
				if (this.visualVariantModel == 3)
				{
					machineVariantName = "2 F3";
				}
			}
		}
		
		if (this.visualVariantModel == 0)
		{
			machineVariantName = "Standard";
		}
    	
		return machineVariantName;
	}
    
    /**
     * Returns the string machine component name. (Used in GUI)
     */
	public String getComponentName()
	{
		String machineComponentName = "None";
		
		if(this.isGroundMachine())
		{
			machineComponentName = "Jump Height";
		}
		if(this.isWaterMachine())
		{
			machineComponentName = "Max Oxygen";
		}
		if(this.isFlyingMachine())
		{
			machineComponentName = "Max Elevation";
		}
    	
		return machineComponentName;
	}
    
    /**
     * Returns the string machine component name. (Used in GUI)
     */
	public String getComponentNameValue()
	{
		String machineComponentNameValue = "None";
		
		if(this.isGroundMachine())
		{
			machineComponentNameValue = "Blocks";
		}
		if(this.isWaterMachine())
		{
			machineComponentNameValue = "Seconds";
		}
		if(this.isFlyingMachine())
		{
			machineComponentNameValue = "Y Coord.";
		}
    	
		return machineComponentNameValue;
	}
    
    /**
     * Returns the string machine default name. (Used in GUI)
     */
	public String getMachineDefaultName()
	{
		String machineDefaultName = "None";
		
		if(this.isGroundMachine())
		{
			machineDefaultName = "Ground Machine";
		}
		if(this.isWaterMachine())
		{
			machineDefaultName = "Water Machine";
		}
		if(this.isFlyingMachine())
		{
			machineDefaultName = "Flying Machine";
		}
    	
		return machineDefaultName;
	}
	
    /**
     * Sets the weapon firing cooldown depending on type in ticks.
     */
    protected int weaponFiringCooldownTicks(int ammoTypeIn)
    {
		int amount = 20;
    	
		if (ammoTypeIn == 1)
		{
			amount = 60;
		}
		
		if (ammoTypeIn == 2)
		{
			amount = 120;
		}
		
    	return amount;
    }
    
    /**
     * Sets the weapon firing cooldown depending on type in ticks.
     */
    protected void weaponFiringCooldown()
    {
    	this.weaponFiringCooldownTicks(this.ammoType);
    	
    	if (this.weaponCooldown <= this.weaponFiringCooldownTicks(this.ammoType))
    	{
    		this.weaponCooldown++;
    	}
    }
}
