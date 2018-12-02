package com.vies.viesmachines.api;

import com.vies.viesmachines.client.InitSoundEventsVC;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;

public class EnumsVM {
	
	
	
	//==================================================
    // TODO            Main Machine Logic
	//==================================================
    
	/** Flying Machine Frame Tier enum - Dictates registry name, localized name, max health, max energy, max durability. */
	public static enum FlyingMachineFrameTier
    {
    	// STRING(meta, registry name, localized name, max health, max energy, max durability):
		BASE(0, "tierbase", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), 8.0F, 100, 250),
		ONE(1, "tier1", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.1"), 16.0F, 200, 500),
		TWO(2, "tier2", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.2"), 24.0F, 300, 750),
		THREE(3, "tier3", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.3"), 32.0F, 500, 1000);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final float maxHealth;
        private final int maxEnergy;
        private final int maxDurability;
        
        private FlyingMachineFrameTier(int metadataIn, String registryNameIn, String localizedNameIn, float maxHealthIn, int maxEnergyIn, int maxDurabilityIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.maxHealth = maxHealthIn;
            this.maxEnergy = maxEnergyIn;
            this.maxDurability = maxDurabilityIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public float getMaxHealthModifier()
        {
            return this.maxHealth;
        }
        
        public int getMaxEnergyModifier()
        {
            return this.maxEnergy;
        }
        
        public int getMaxDurabilityModifier()
        {
            return this.maxDurability;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.FlyingMachineFrameTier byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.FlyingMachineFrameTier getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	/** Flying Machine Engine Tier enum - Dictates registry name, localized name, forward speed, turn speed, energy increase, durability decrease. */
	public static enum FlyingMachineEngineTier
    {
    	// STRING(meta, registry name, localized name, forward speed, turn speed, energy increase in ticks, durability decrease in ticks):
		BASE(0, "tierbase", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), 0.005F, 0.1F, 2400, 600),//2 minutes, 30 seconds
		ONE(1, "tier1", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.1"), 0.010F, 0.2F, 1800, 1200),   //1 minute 30 seconds, 1 minute
		TWO(2, "tier2", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.2"), 0.015F, 0.3F, 1200, 1800),   //1 minute, 1 minute 30 seconds
		THREE(3, "tier3", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.3"), 0.020F, 0.4F, 600, 2400);  //30 seconds, 2 minutes
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final float fowardSpeed;
        private final float turnSpeed;
        private final int energyIncrease;
        private final int durabilityDecrease;
        
        private FlyingMachineEngineTier(int metadataIn, String registryNameIn, String localizedNameIn, float fowardSpeedIn, float turnSpeedIn, int energyIncreaseIn, int durabilityDecreaseIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.fowardSpeed = fowardSpeedIn;
            this.turnSpeed = turnSpeedIn;
            this.energyIncrease = energyIncreaseIn;
            this.durabilityDecrease = durabilityDecreaseIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public float getFowardSpeedModifier()
        {
            return this.fowardSpeed;
        }
        
        public float getTurnSpeedModifier()
        {
            return this.turnSpeed;
        }
        
        public int getEnergyIncreaseModifier()
        {
            return this.energyIncrease;
        }
        
        public int getDurabilityDecreaseModifier()
        {
            return this.durabilityDecrease;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.FlyingMachineEngineTier byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.FlyingMachineEngineTier getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	/** Flying Machine Component Tier enum - Dictates registry name, localized name, max ammo, special stat (max elevation). */
	public static enum FlyingMachineComponentTier
    {
    	// STRING(meta, registry name, localized name, max ammo, ?firing cooldown?, special stat (max elevation)):
		BASE(0, "tierbase", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), 100, 75),
		ONE(1, "tier1", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.1"), 200, 125),
		TWO(2, "tier2", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.2"), 300, 200),
		THREE(3, "tier3", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.3"), 500, 4096);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final int maxAmmo;
        private final int maxElevation;
        
        private FlyingMachineComponentTier(int metadataIn, String registryNameIn, String localizedNameIn, int maxAmmoIn, int maxElevationIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.maxAmmo = maxAmmoIn;
            this.maxElevation = maxElevationIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public int getMaxAmmoModifier()
        {
            return this.maxAmmo;
        }
        
        public int getMaxElevationModifier()
        {
            return this.maxElevation;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.FlyingMachineComponentTier byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.FlyingMachineComponentTier getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	
	
	//==================================================
    // TODO            sdf
	//==================================================

    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** Event enum - Dictates registry name. */
	public static enum EventTrigger
    {
    	// STRING(meta, registry name):
		NONE(0, "none"),
		FALL(1, "fall"),
		BROKEN(2, "broken"),
		DESTRUCTION(3, "destruction"),
		LIGHTNING_STRIKE(4, "lightning_strike"),
		INJURED(5, "injured"),
		
		HEALTH_2(11, "health_2"),
		HEALTH_8(12, "health_8"),
		HEALTH_MAX(13, "health_max"),
		
		ENERGY_25(21, "energy_25"),
		ENERGY_100(22, "energy_100"),
		ENERGY_MAX(23, "energy_max"),
		
		DURABILITY_50(31, "durability_50"),
		DURABILITY_200(32, "durability_200"),
		DURABILITY_MAX(33, "durability_max"),
		
		UPGRADE_TIER1(41, "upgrade_tier1"),
		UPGRADE_TIER2(42, "upgrade_tier2"),
		UPGRADE_TIER3(43, "upgrade_tier3"),
		
		;
		
		private final int metadata;
        private final String registryName;
        
        private EventTrigger(int metadataIn, String registryNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.EventTrigger byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.EventTrigger getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    
	
	//==================================================
    // TODO            Visual Machine
	//==================================================

    /** Visual Primary Skin enum - Represents various primary skin types. */
 /**   public static enum VisualPrimaryTexture
    {
    	//STRING(meta, registry name, localized name)
    	DEFAULT(0, "default", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.0")),
    	
    	//Tier 0
    	COBBLESTONE(1, "cobblestone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.23")),
        SANDSTONE(2, "sandstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.22")),
        SNOW(3, "snow", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.25")),
        HAY_BLOCK(4, "hay_block", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.6")),
        
    	//Tier 1
        PLANK_OAK(5, "plank_oak", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.7")),
        PLANK_SPRUCE(6, "plank_spruce", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.8")),
        PLANK_BIRCH(7, "plank_birch", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.9")),
        PLANK_JUNGLE(8, "plank_jungle", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.10")),
        PLANK_ACACIA(9, "plank_acacia", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.11")),
        PLANK_DARK_OAK(10, "plank_dark_oak", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.12")),
        
    	LOG_OAK(11, "log_oak", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.13")),
    	LOG_SPRUCE(12, "log_spruce", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.14")),
    	LOG_BIRCH(13, "log_birch", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.15")),
    	LOG_JUNGLE(14, "log_jungle", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.16")),
    	LOG_ACACIA(15, "log_acacia", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.17")),
    	LOG_DARK_OAK(16, "log_dark_oak", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.18")),
        
        PODZOL(17, "podzol", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.28")),
        MYCELIUM(18, "mycelium", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.29")),
        ICE(19, "ice", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.48")),
        BRICK(20, "brick", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.36")),
        
        //Tier 2
        ORE_IRON(21, "ore_iron", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.38")),
        ORE_GOLD(22, "ore_gold", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.39")),
        ORE_REDSTONE(23, "ore_redstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.40")),
        ORE_LAPIS_LAZULI(24, "ore_lapis_lazuli", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.41")),
        ORE_DIAMOND(25, "ore_diamond", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.42")),
        ORE_EMERALD(26, "ore_coal", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.37")),
        
        IRON(27, "iron", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.44")),
        GOLD(28, "gold", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.46")),
        REDSTONE(29, "redstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.45")),
        LAPIS_LAZULI(30, "lapis_lazuli", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.47")),
        DIAMOND(31, "diamond", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.55")),
        EMERALD(32, "emerald", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.56")),
        
        //Tier 3
        SLIME(33, "slime", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.49")),
        NETHERBRICK(34, "nether_brick", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.50")),
        SOUL_SAND(35, "soul_sand", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.51")),
        QUARTZ(36, "quartz", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.52")),
        GLOWSTONE(37, "glowstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.53")),
        OBSIDIAN(38, "obsidian", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.54")),
        
        PRISMARINE(39, "prismarine", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.57")),
        END_STONE(40, "end_stone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.58")),
        PURPUR(41, "purpur", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.59")),
    	WATER(42, "water", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.61")), 
    	LAVA(43, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.62")), 
    	ENDER(44, "ender", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.63")); 
    	
    	
    	
    	
    	
    	//ICEPACKED(26, "packed_ice", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.26")),
        //GLASS(30, "glass", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.30")),
        
    	//COAL(43, "coal", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.43")),
    	//STONEBRICKS(31, "stone_brick", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.31")),
        //STONEBRICKSMOSSY(32, "stone_brick_mossy", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.32")),
        //STONEBRICKSCRACK(33, "stone_brick_cracked", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.33")),
        //STONEBRICKSCHISELED(34, "stone_brick_chiseled", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.34")),
        //COBBLESTONEMOSSY(35, "cobblestone_mossy", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.35")),
    	//DIRT(1, "dirt", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.1")),
    	//SAND(2, "sand", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.2")),
    	//REDSAND(3, "redsand", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.3")),
        //GRAVEL(4, "gravel", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.4")),
        //CLAY(5, "clay", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.5")),
    	//NETHERSTAR(60, "netherstar", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.60")),
    	//GRANITE(19, "granite", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.19")),
        //DIORITE(20, "diorite", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.20")),
        //ANDESITE(21, "andesite", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.21")),
        //STONE(24, "stone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.24")),
        
    	
    	
    	//Holiday
    	//New Years
    	//MYTHIC(61, "mythic", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.61")),
    	//WATER(62, "water", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.62")), 
    	//LAVA(63, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.63")), 
    	//ENDER(64, "ender", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.64")), 
    	//ENDER1(65, "ender1", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.65")), 
    	//ENDER2(66, "ender2", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.66"))
    	;
    	
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private VisualPrimaryTexture(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get type by it's enum ordinal
         *
        public static EnumsVM.VisualPrimaryTexture byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.VisualPrimaryTexture getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    /** Visual Secondary Skin enum - Represents various primary skin types. */
/**    public static enum VisualSecondaryTexture
    {
    	//STRING(meta, registry name, localized name)
    	DEFAULT(0, "default", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.0")),
    	
    	//Tier 0
    	COBBLESTONE(23, "cobblestone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.23")),
        SANDSTONE(22, "sandstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.22")),
        SNOW(25, "snow", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.25")),
        HAYBALE(6, "haybale", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.6")),
        
    	//Tier 1
        PLANKOAK(7, "plank_oak", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.7")),
        PLANKSPRUCE(8, "plank_spruce", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.8")),
        PLANKBIRCH(9, "plank_birch", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.9")),
        PLANKJUNGLE(10, "plank_jungle", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.10")),
        PLANKACACIA(11, "plank_acacia", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.11")),
        PLANKDARKOAK(12, "plank_dark_oak", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.12")),
        
    	LOGOAK(13, "log_oak", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.13")),
    	LOGSPRUCE(14, "log_spruce", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.14")),
    	LOGBIRCH(15, "log_birch", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.15")),
    	LOGJUNGLE(16, "log_jungle", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.16")),
    	LOGACACIA(17, "log_acacia", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.17")),
    	LOGDARKOAK(18, "log_dark_oak", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.18")),
        
        PODZOL(28, "podzol", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.28")),
        MYCELIUM(29, "mycelium", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.29")),
        GLASS(30, "glass", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.30")),
        BRICK(36, "brick", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.36")),
        ICEPACKED(26, "packed_ice", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.26")),
        ICE(48, "ice", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.48")),
        
        //Tier 2
        OREIRON(38, "ore_iron", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.38")),
        OREGOLD(39, "ore_gold", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.39")),
        OREREDSTONE(40, "ore_redstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.40")),
        ORELAPISLAZULI(41, "ore_lapislazuli", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.41")),
        OREDIAMOND(42, "ore_diamond", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.42")),
        OREEMERALD(37, "ore_coal", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.37")),
        
        IRON(44, "iron", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.44")),
        GOLD(46, "gold", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.46")),
        REDSTONE(45, "redstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.45")),
        LAPISLAZULI(47, "lapislazuli", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.47")),
        DIAMOND(55, "diamond", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.55")),
        EMERALD(56, "emerald", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.56")),
        
        //Tier 3
        SLIME(49, "slime", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.49")),
        NETHERBRICK(50, "nether_brick", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.50")),
        SOULSAND(51, "soulsand", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.51")),
        QUARTZ(52, "quartz", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.52")),
        GLOWSTONE(53, "glowstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.53")),
        OBSIDIAN(54, "obsidian", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.54")),
        
        PRISMARINE(57, "prismarine", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.57")),
        ENDSTONE(58, "endstone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.58")),
        PURPUR(59, "purpur", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.59")),
    	WATER(61, "water", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.61")), 
    	LAVA(62, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.62")), 
    	ENDER(63, "ender", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.63")); 
    	
    	
    	
    	
    	
    	
    	//COAL(43, "coal", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.43")),
    	//STONEBRICKS(31, "stone_brick", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.31")),
        //STONEBRICKSMOSSY(32, "stone_brick_mossy", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.32")),
        //STONEBRICKSCRACK(33, "stone_brick_cracked", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.33")),
        //STONEBRICKSCHISELED(34, "stone_brick_chiseled", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.34")),
        //COBBLESTONEMOSSY(35, "cobblestone_mossy", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.35")),
    	//DIRT(1, "dirt", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.1")),
    	//SAND(2, "sand", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.2")),
    	//REDSAND(3, "redsand", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.3")),
        //GRAVEL(4, "gravel", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.4")),
        //CLAY(5, "clay", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.5")),
    	//NETHERSTAR(60, "netherstar", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.60")),
    	//GRANITE(19, "granite", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.19")),
        //DIORITE(20, "diorite", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.20")),
        //ANDESITE(21, "andesite", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.21")),
        //STONE(24, "stone", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.24")),
        
    	
    	
    	//Holiday
    	//New Years
    	//MYTHIC(61, "mythic", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.61")),
    	//WATER(62, "water", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.62")), 
    	//LAVA(63, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.63")), 
    	//ENDER(64, "ender", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.64")), 
    	//ENDER1(65, "ender1", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.65")), 
    	//ENDER2(66, "ender2", References.Old_I18n.translateToLocalFormatted("vc.enum.visualframe.66"))
    	;
    	
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private VisualSecondaryTexture(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get type by it's enum ordinal
         *
        public static EnumsVM.VisualSecondaryTexture byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.VisualSecondaryTexture getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    /** Module Type enum - Represents various Module types. *
    public static enum ModuleType
    {
    	// STRING(meta, registry name, localized name):
        BASE(0, "base", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.0")),
        ALTITUDE_LESSER(1, "altitude_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.1")),
        ALTITUDE_NORMAL(2, "altitude_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.2")),
        ALTITUDE_GREATER(3, "altitude_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.3")),
        SPEED_LESSER(4, "speed_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.4")),
        SPEED_NORMAL(5, "speed_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.5")),
        SPEED_GREATER(6, "speed_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.6")),
        STORAGE_LESSER(7, "storage_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.7")),
        STORAGE_NORMAL(8, "storage_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.8")),
        STORAGE_GREATER(9, "storage_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.9")),
        FUEL_LESSER(10, "fuel_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.10")),
        FUEL_NORMAL(11, "fuel_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.11")),
    	FUEL_GREATER(12, "fuel_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.12")),
    	MUSIC_LESSER(13, "music_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.13")),
    	MUSIC_NORMAL(14, "music_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.14")),
    	MUSIC_GREATER(15, "music_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.15")),
    	CRUISE_LESSER(16, "cruise_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.16")),
    	CRUISE_NORMAL(17, "cruise_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.17")),
    	CRUISE_GREATER(18, "cruise_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.18")),
        WATER_LESSER(19, "water_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.19")),
        WATER_NORMAL(20, "water_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.20")),
        WATER_GREATER(21, "water_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.21")),
        INFINITE_FUEL_LESSER(22, "infinite_fuel_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.22")),
    	INFINITE_FUEL_NORMAL(23, "infinite_fuel_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.23")),
    	INFINITE_FUEL_GREATER(24, "infinite_fuel_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.24")),
    	BOMB_LESSER(25, "bomb_lesser", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.25")),
    	BOMB_NORMAL(26, "bomb_normal", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.26")),
    	BOMB_GREATER(27, "bomb_greater", References.Old_I18n.translateToLocalFormatted("vc.item.enum.module.27"));
    	
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private ModuleType(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /** Get type by it's enum ordinal. *
        public static EnumsVM.ModuleType byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.ModuleType getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    /** Song enum - Represents various song types. */
    public static enum AirshipSong
    {
    	// STRING(meta, localized name, soundevent):
    	NONE(0, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.0"), SoundEvents.UI_BUTTON_CLICK),
    	RECORD11(1, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.1"), SoundEvents.RECORD_11),
        RECORD13(2, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.2"), SoundEvents.RECORD_13),
        RECORDBLOCKS(3, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.3"), SoundEvents.RECORD_BLOCKS),
        RECORDMELLOHI(4, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.4"), SoundEvents.RECORD_MELLOHI),
        RECORDCAT(5, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.5"), SoundEvents.RECORD_CAT),
        RECORDSTAL(6, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.6"), SoundEvents.RECORD_STAL),
        RECORDSTRAD(7, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.7"), SoundEvents.RECORD_STRAD),
        RECORDCHIRP(8, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.8"), SoundEvents.RECORD_CHIRP),
        RECORDFAR(9, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.9"), SoundEvents.RECORD_FAR),
        RECORDMALL(10, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.10"), SoundEvents.RECORD_MALL),
        RECORDWAIT(11, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.11"), SoundEvents.RECORD_WAIT),
        RECORDWARD(12, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.12"), SoundEvents.RECORD_WARD),
        RECORDBRAMBLE(13, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.13"), InitSoundEventsVC.BRAMBLE),
        RECORDCASTLE(14, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.14"), InitSoundEventsVC.CASTLE),
        RECORDJUNGLE(15, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.15"), InitSoundEventsVC.JUNGLE),
        RECORDDIRE(16, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.16"), InitSoundEventsVC.DIRE),
        RECORDSTORMS(17, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.17"), InitSoundEventsVC.STORMS),
        RECORDTIMESCAR(18, References.Old_I18n.translateToLocalFormatted("vc.item.enum.song.18"), InitSoundEventsVC.TIMESCAR);
    	
    	private final int metadata;
        private final String registryName;
        private final SoundEvent song;
        
        private AirshipSong(int metadataIn, String registryNameIn, SoundEvent soundIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.song = soundIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public SoundEvent getSong()
        {
            return this.song;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.AirshipSong byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.AirshipSong getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	
    
    
    
    
    
    
    
    
    /**
	 * Visual Balloon Pattern enum - Represents various visual balloon pattern types.
	 */
/**    public static enum VisualBalloonPattern
    {
    	//STRING(meta, registry name, localed name)
    	DEFAULT(0, "default", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.0")),
    	
    	//Common
    	//Tier 1 - 18
    	SPECKLED(1, "speckled", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.1")),
    	CRUMPLED(2, "crumpled", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.2")),
    	CHECKER(3, "checker", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.5")),
    	A11(4, "crumpled_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.6")),
    	A12(5, "checker_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.3")),
    	A13(6, "checker_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.4")),
    	
        A1COLORED(7, "a1_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.7")),
        A1INVERTED(8, "a1_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.8")),
        A2COLORED(9, "a2_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.9")),
        A2INVERTED(10, "a2_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.10")),
        A3COLORED(11, "a3_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.11")),
        A3INVERTED(12, "a3_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.12")),
        
    	A4COLORED(13, "a4_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.13")),
    	A4INVERTED(14, "a4_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.14")),
    	A5COLORED(15, "a5_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.15")),
    	A5INVERTED(16, "a5_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.16")),
    	A6COLORED(17, "a6_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.17")),
    	A6INVERTED(18, "a6_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.18")),
        
        //Uncommon
        //Tier 2 - 12
    	POLKADOTCOLORED(19, "polkadot", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.19")),
    	BASKETWEAVE(20, "basketweave", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.20")),
    	B11(21, "basketweave_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.21")),
    	B12(22, "basketweave_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.22")),
        B1COLORED(23, "b1_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.23")),
        B1INVERTED(24, "b1_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.24")),
        
        B2COLORED(25, "b2_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.25")),
        B2INVERTED(26, "b2_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.26")),
        B3COLORED(27, "b3_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.27")),
    	B3INVERTED(28, "b3_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.28")),
        B4COLORED(29, "b4_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.29")),
        B4INVERTED(30, "b4_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.30")),
        
        //Rare
        //Tier 3 - 12
        ZIGZAG(31, "zigzag", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.31")),
        C11ZIGZAGINVERTED(32, "zigzag_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.32")),
        C1COLORED(33, "c1_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.33")),
        C1INVERTED(34, "c1_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.34")),
        C2COLORED(35, "c2_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.35")),
        C2INVERTED(36, "c2_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.36")),
        
        C3COLORED(37, "c3_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.37")),
        C3INVERTED(38, "c3_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.38")),
        C4COLORED(39, "c4_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.39")),
        C4INVERTED(40, "c4_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.40")),
        C5COLORED(41, "c5_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.41")),
        C5INVERTED(42, "c5_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.42")),
        
        //Epic
        //Tier 4 - 12
        CREEPER(43, "creeper", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.43")),
        D1CREEPERINVERTED(44, "creeper_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.44")),
        D1COLORED(45, "d1_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.45")),
        D1INVERTED(46, "d1_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.46")),
        D2COLORED(47, "d2_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.47")),
        D2INVERTED(48, "d2_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.48")),
        
        D3COLORED(49, "d3_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.49")),
        D3INVERTED(50, "d3_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.50")),
        D4COLORED(51, "d4_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.51")),
        D4INVERTED(52, "d4_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.52")),
        D5COLORED(53, "d5_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.53")),
        D5INVERTED(54, "d5_inverted", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.54")),
        
        //Legendary
    	//Tier 5 - 10
        WATER(55, "water", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.55")),
        LAVA(56, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.56")),
        ENDER(57, "ender", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.57")),
        E1(58, "e1_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.58")),
        E2(59, "e2_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.59")),
        E3(60, "e3_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.60")),
    	
        E4(61, "e4_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.61")),
    	E5(62, "e5_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.62")), 
    	E6(63, "e6_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.63")), 
    	E7(64, "e7_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.64")),
    	E8(65, "e8_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.65")), 
    	E9(66, "e9_colored", References.Old_I18n.translateToLocalFormatted("vc.enum.visualballoon.66")), ; 
    	
    	
    	
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private VisualBalloonPattern(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get type by it's enum ordinal
         *
        public static EnumsVM.VisualBalloonPattern byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.VisualBalloonPattern getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
   */
    
    
    
    
    
    
    
    /**
     * Bomb enum - Dictates registry name, localized name, explosion strength.
     */
/**	public static enum Bombs
    {
    	//STRING(meta, registry name, localized name, explosion strength)
		CASING(0, "casing", References.Old_I18n.translateToLocalFormatted("vc.enum.bomb.0"), 0.0F),
		SMALL(1, "small", References.Old_I18n.translateToLocalFormatted("vc.enum.bomb.1"), 4.0F),
		BIG(2, "big", References.Old_I18n.translateToLocalFormatted("vc.enum.bomb.2"), 8.0F),
		SCATTER(3, "scatter", References.Old_I18n.translateToLocalFormatted("vc.enum.bomb.3"), 0.3F);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final float explosionStrength;
        
        private Bombs(int metadataIn, String registryNameIn, String localizedNameIn, float explosionStrengthIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.explosionStrength = explosionStrengthIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public float getExplosionStrength()
        {
            return this.explosionStrength;
        }
        
        /**
         * Get type by it's enum ordinal
         *
        public static EnumsVM.Bombs byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.Bombs getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	*/
	
	
	
	

    
    /**
	 * Achievement enum - Represents various Achievement types.
	 *
    public static enum Achievement
    {
    	//STRING(meta, registry name)
        CREATEENGINE(0, "create_engine"),
    	CREATEIGNITION(1, "create_ignition"),
        CREATE(2, "create"),
        CREATECOLOR(3, "create_color"),
        CREATEMODULE(4, "create_module"),
        AIRBORN(5, "airborn"),
        WATER(6, "water"),
        LAVA(7, "lava");
        
    	private final int metadata;
        private final String registryName;
        
        private Achievement(int metadataIn, String registryNameIn)
        {
        	this.metadata = metadataIn;
        	this.registryName = registryNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        /**
         * Get type by it's enum ordinal
         *
        public static EnumsVM.Achievement byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.Achievement getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    */
    
    
    /**
	 * Display Symbol enum - Represents various Airship Display Symbol types.
	 */
    public static enum MainDisplaySymbol
    {
    	//STRING(meta, registry name, localized name, explosion strength)
        NONE(0, "none", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
        
        BLOCKITEM(1, "category_blockitem", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.1")),
        HEAD(2, "category_head", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.2")),
        HEADSUPPORTER(3, "category_supporter_head", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.3")),
        HOLIDAY(4, "category_holiday", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.4")),
        UNUSED0(5, "category_1", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.5")),
        UNUSED1(6, "category_2", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.6")),
        UNUSED2(7, "category_3", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.7")),
        UNUSED3(8, "category_4", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.8")),
        UNUSED4(9, "category_5", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.9")),
        
        
        
    	LOGOVIESCRAFT(10, "10", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.10")),
    	LOGOFORGE(11, "11", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.11")),
    	LOGOMINECRAFT(12, "12", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.12")),
    	COINSTACK(13, "13", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.13")),
    	SCROLL(14, "14", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.14")),
    	WRENCH(15, "15", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.15")),
    	KEY(16, "16", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.16")),
    	PADLOCK(17, "17", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.17")),
        BELL(18, "18", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.18")),
        ANCHOR(19, "19", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.19")),
    	BARREL(20, "20", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.20")),
    	GEARS(21, "21", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.21"));
    	
    	
    	
    	/**
    	DOG(9, "animal_dog", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.9")),
    	CAT(10, "animal_cat", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.10")),
    	FOX(11, "animal_squirrel", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.11")),
    	BEAR(12, "animal_bear", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.12")),
    	LION(13, "animal_lion", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.13")),
        WOLF(14, "animal_fox", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.14")),
        SHARK(15, "animal_wolf", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.15")),
    	FISH(9, "animal_dog", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.9")),
    	OCTOPUS(9, "animal_dog", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.9")),
    	PHOENIX(16, "animal_phoenix", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.16")),
        DRAGON(17, "animal_dragon", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.17"));
    	
    	
    	EARTH(18, "element_earth", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.18")),
        WIND(19, "element_wind", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.19")),
        WATER(20, "element_water", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.20")),
        FIRE(21, "element_fire", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.21")),
        NATURE(22, "element_nature", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.22")),
        LIGHTNING(23, "element_lightning", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.23")),
        ICE(24, "element_ice", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.24")),
        POISON(25, "element_poison", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.25")),
        ARCANE(26, "element_arcane", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.26")),
        VOID(27, "element_void", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.27")),
        HOLY(28, "element_holy", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.28")),
        UNHOLY(29, "element_unholy", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.29")),
        
        
        
        SHIELD(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
        HAMMER(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
        FIST(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
        SUN(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
        MOON(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
        
        
        
        CELTIC(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
        YGGDRASIL(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
        MJOLLNIR(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0"));
        
        JACKOLANTERN(15, "animal_wolf", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.15")),
    	THANKSGIVINGTURKEY(16, "animal_phoenix", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.16")),
        CHRISTMASTREE(17, "animal_dragon", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.17"));
    	
        */
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private MainDisplaySymbol(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVM.MainDisplaySymbol byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.MainDisplaySymbol getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    /**
	 * Entity Head Display Symbol enum - Represents various Airship Entity Head types.
	 */
    public static enum EntityHead
    {
    	//STRING(meta, registry name, localized name)
        NONE(0, "none", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.0")),
        
        STEVE(1, "1", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.1")),
        ALEX(2, "2", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.2")),
        CHICKEN(3, "3", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.3")),
        PIG(4, "4", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.4")),
    	COW(5, "5", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.5")),
    	ZOMBIE(6, "6", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.6")),
    	SKELETON(7, "7", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.7")),
    	SPIDER(8, "8", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.8")),
    	CREEPER(9, "9", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.9")),
    	WITHERSKELETON(10, "10", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.10")),
    	DRAGON(11, "11", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.11")),
    	HEROBRINE(12, "12", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.12"));
        
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private EntityHead(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVM.EntityHead byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.EntityHead getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    /**
	 * Patreon Head Display Symbol enum - Represents various Airship Patreon Head types.
	 */
    public static enum PatreonHead
    {
    	// STRING(meta, registry name, localized name):
        NONE(0, "none", "None"),
        VIES(1, "patreonhead_vies", "Vies"),
        SOULFORGE7(2, "patreonhead_soulforge7", "SoulForge7"),
        NEMANOR(3, "patreonhead_nemanor", "Nemanor"),
        VELOURVAULTSUIT(4, "patreonhead_velourvaultsuit", "VelourVaultSuit");
        
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private PatreonHead(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.PatreonHead byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.PatreonHead getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    /**
	 * Holiday Display Symbol enum - Represents various Airship Holiday Display types.
	 */
    public static enum MainHolidaySymbol
    {
    	//STRING(meta, registry name, localized name)
        NONE(0, "none", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.0")),
        
        //New Years
        YEAR2018(1, "1", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.1")),
        YEAR2019(2, "2", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.2")),
        H3(3, "3", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.3")),
        H4(4, "4", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.4")),
    	H5(5, "5", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.5")),
    	H6(6, "6", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.6")),
    	H7(7, "7", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.7")),
    	H8(8, "8", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.8")),
    	H9(9, "9", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.9")),
    	H10(10, "10", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.10")),
    	H11(11, "11", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.11")),
    	H12(12, "12", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.12")),
    	
    	//Valentine's Day
    	ROSE(13, "13", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.13")),
        TEDDYBEAR(14, "14", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.14")),
    	CUPID(15, "15", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.15")),
    	RING(16, "16", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.16")),
    	CARD(17, "17", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.17")),
    	PRESENTHEART(18, "18", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.18")),
    	HEARTMUSIC(19, "19", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.19")),
    	HEARTLOCK(20, "20", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.20")),
    	HEARTBROKEN(21, "21", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.21")),
    	HEART1(22, "22", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.22")),
    	HEART2(23, "23", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.23")),
        HEART3(24, "24", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.24")),
        
        //Easter
    	EGG1(25, "25", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.25")),
    	EGG2(26, "26", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.26")),
    	EGG3(27, "27", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.27")),
    	EGG4(28, "28", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.28")),
    	BASKETEGG(29, "29", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.29")),
    	FLOWER(30, "30", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.30")),
    	BUTTERFLY(31, "31", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.31")),
    	CHICK1(32, "32", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.32")),
    	CHICK2(33, "33", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.33")),
        BUNNY1(34, "34", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.34")),
    	BUNNY2(35, "35", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.35")),
    	BUNNY3(36, "36", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.36")),
    	
    	//4th of July
    	CRACKEDBELL(37, "37", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.37")),
    	TOPHATUSA(38, "38", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.38")),
    	MEDAL(39, "39", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.39")),
    	FLAGUSA(40, "40", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.40")),
    	REPUBLICAN(41, "41", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.41")),
    	DEMOCRAT(42, "42", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.42")),
    	ROCKET1(43, "43", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.43")),
        ROCKET2(44, "44", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.44")),
        FIREWORK1(45, "45", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.45")),
    	FIREWORK2(46, "46", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.46")),
    	FIREWORK3(47, "47", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.47")),
    	LIBERTYTORCH(48, "48", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.48")),
    	
    	//Halloween
    	JACKOLANTERN(49, "49", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.49")),
    	BLACKCAT(50, "50", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.50")),
    	BAT(51, "51", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.51")),
    	SPIDER(52, "52", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.52")),
    	CAULDRON(53, "53", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.53")),
        NIGHTSKYMOON(54, "54", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.54")),
    	TOMBSTONE(55, "55", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.55")),
    	SCYTHE(56, "56", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.56")),
    	JACK(57, "57", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.57")),
    	SALLY(58, "58", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.58")),
    	ZERO(59, "59", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.59")),
    	BOOGEYMAN(60, "60", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.60")),
    	
    	//Thanksgiving
    	PILGRIMHAT(61, "61", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.61")),
    	INDIANHAT(62, "62", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.62")),
    	BOAT(63, "63", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.63")),
    	MAPLELEAF(64, "64", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.64")),
    	MAPLELEAVES(65, "65", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.65")),
    	SUNFLOWER(66, "66", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.66")),
    	CORNSTALK(67, "67", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.67")),
    	WHEAT(68, "68", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.68")),
    	PIESLICE(69, "69", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.69")),
    	PIEWHOLE(70, "70", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.70")),
    	TURKEY(71, "71", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.71")),
    	BASKET(72, "72", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.72")),
    	
    	//Christmas
    	PRESENTSMALL(73, "73", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.73")),
        PRESENTLARGE(74, "74", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.74")),
    	CANDYCANE(75, "75", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.75")),
    	SNOWFLAKE(76, "76", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.76")),
    	ORNAMENT(77, "77", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.77")),
    	MISTLETOE(78, "78", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.78")),
    	WREATH(79, "79", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.79")),
    	STOCKING(80, "80", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.80")),
    	CHRISTMASTREE(81, "81", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.81")),
    	REINDEER(82, "82", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.82")),
    	SLEIGH(83, "83", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.83")),
        SANTA(84, "84", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.84"));
    	
    	
        
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private MainHolidaySymbol(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVM.MainHolidaySymbol byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.MainHolidaySymbol getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * Default name enum - Dictates registry name and localized name.
     *
	public static enum MachineName
    {
    	//STRING(meta, default machine name, category, type, component special stat name, componenet special stat value name)
		NONE(0, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.0"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.0"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.0"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.0"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.0")),
		GROUND1(1, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.1"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.1"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.1"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.1"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.1")),
		GROUND2(2, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.2"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.2"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.2"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.2"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.2")),
		GROUND3(3, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.3"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.3"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.3"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.3"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.3")),
	    WATER1(4, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.4"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.4"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.4"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.4"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.4")),
	    WATER2(5, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.5"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.5"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.5"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.5"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.5")),
	    WATER3(6, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.6"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.6"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.6"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.6"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.6")),
	    FLYING1(7, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.7"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.7"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.7"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.7"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.7")),
	    FLYING2(8, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.8"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.8"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.8"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.8"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.8")),
	    FLYING3(9, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.9"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.category.9"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.type.9"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentname.9"), References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluename.9"));
		
		private final int metadata;
        private final String defaultName;
        private final String categoryName;
        private final String typeName;
        private final String componentName;
        private final String valueName;
        
        private MachineName(int metadataIn, String defaultNameIn, String categoryNameIn, String typeNameIn, String componentNameIn, String valueNameIn)
        {
        	this.metadata = metadataIn;
            this.defaultName = defaultNameIn;
            this.categoryName = categoryNameIn;
            this.typeName = typeNameIn;
            this.componentName = componentNameIn;
            this.valueName = valueNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getDefaultName()
        {
            return this.defaultName;
        }
        
        public String getCategoryName()
        {
            return this.categoryName;
        }
        
        public String getTypeName()
        {
            return this.typeName;
        }
        
        public String getComponentName()
        {
            return this.componentName;
        }
        
        public String getValueName()
        {
            return this.valueName;
        }
        
        /**
         * Get type by it's enum ordinal
         *
        public static EnumsVM.MachineName byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
	
	/** Flying Machine Variant Name enum - Dictates localized name. */
	public static enum FlyingMachineAirshipVariantName
    {
    	// STRING(meta, unlocalized name):
		STANDARD(0, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.0")),
		HINDENBURG(1, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.1")),
		DIRIGIBLE(2, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.2")),
		ZEPPELIN(3, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.3")),
		AKRONUS(4, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.4"));
		
		private final int metadata;
        private final String unlocalizedName;
        
        private FlyingMachineAirshipVariantName(int metadataIn, String unlocalizedNameIn)
        {
        	this.metadata = metadataIn;
            this.unlocalizedName = unlocalizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.FlyingMachineAirshipVariantName byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
	
	
	
	
	
	
	
	
	
	/** Select Color enum - Dictates registry name and localized name. */
	public static enum SelectColor
    {
    	// STRING(meta, registry name, localized name, TextFormatting color):
		BLACK(0, "BLACK", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.BLACK),
	    DARK_BLUE(1, "DARK_BLUE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_BLUE),
	    DARK_GREEN(2, "DARK_GREEN", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_GREEN),
	    DARK_AQUA(3, "DARK_AQUA", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_AQUA),
	    DARK_RED(4, "DARK_RED", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_RED),
	    DARK_PURPLE(5, "DARK_PURPLE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_PURPLE),
	    GOLD(6, "GOLD", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.GOLD),
	    GRAY(7, "GRAY", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.GRAY),
	    DARK_GRAY(8, "DARK_GRAY", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_GRAY),
	    BLUE(9, "BLUE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.BLUE),
	    GREEN(10, "GREEN", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.GREEN),
	    AQUA(11, "AQUA", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.AQUA),
	    RED(12, "RED", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.RED),
	    LIGHT_PURPLE(13, "LIGHT_PURPLE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.LIGHT_PURPLE),
	    YELLOW(14, "YELLOW", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.YELLOW),
	    WHITE(15, "WHITE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.WHITE);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final TextFormatting textColor;
        
        private SelectColor(int metadataIn, String registryNameIn, String localizedNameIn, TextFormatting textColorIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.textColor = textColorIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public TextFormatting getTextColor()
        {
            return this.textColor;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.SelectColor byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
    
    
	
	
	
	
	
	
	
	
	
	/** Visual Primary Texture enum - Dictates registry name. */
	public static enum VisualPrimaryTexture
    {
		// STRING(meta, localized name, block, block meta):
		DEFAULT(0, "default", BlocksVM.XEGONITE_BASIC, 0),
    	
    	// Tier 0:
    	COBBLESTONE(1, "cobblestone", Blocks.COBBLESTONE, 0),
    	SANDSTONE(2, "sandstone", Blocks.SANDSTONE, 0),
        SNOW(3, "snow", Blocks.SNOW, 0),
        HAY_BLOCK(4, "hay_block", Blocks.HAY_BLOCK, 0),
        
    	// Tier 1:
        PLANK_OAK(5, "plank_oak", Blocks.PLANKS, 0),
        PLANK_SPRUCE(6, "plank_spruce", Blocks.PLANKS, 1),
        PLANK_BIRCH(7, "plank_birch", Blocks.PLANKS, 2),
        PLANK_JUNGLE(8, "plank_jungle", Blocks.PLANKS, 3),
        PLANK_ACACIA(9, "plank_acacia", Blocks.PLANKS, 4),
        PLANK_DARK_OAK(10, "plank_dark_oak", Blocks.PLANKS, 5),
        PODZOL(11, "podzol", Blocks.DIRT, 1),
        
    	LOG_OAK(12, "log_oak", Blocks.LOG, 0),
    	LOG_SPRUCE(13, "log_spruce", Blocks.LOG, 1),
    	LOG_BIRCH(14, "log_birch", Blocks.LOG, 2),
    	LOG_JUNGLE(15, "log_jungle", Blocks.LOG, 3),
    	LOG_ACACIA(16, "log_acacia", Blocks.LOG2, 0),
    	LOG_DARK_OAK(17, "log_dark_oak", Blocks.LOG2, 1),
        MYCELIUM(18, "mycelium", Blocks.MYCELIUM, 0),
        
        // Tier 2:
        ORE_QUARTZ(19, "ore_quartz", Blocks.QUARTZ_ORE, 0),
        ORE_IRON(20, "ore_iron", Blocks.IRON_ORE, 0),
        ORE_GOLD(21, "ore_gold", Blocks.GOLD_ORE, 0),
        ORE_REDSTONE(22, "ore_redstone", Blocks.REDSTONE_ORE, 0),
        ORE_LAPIS_LAZULI(23, "ore_lapis_lazuli", Blocks.LAPIS_ORE, 0),
        ORE_DIAMOND(24, "ore_diamond", Blocks.DIAMOND_ORE, 0),
        ORE_EMERALD(25, "ore_emerald", Blocks.EMERALD_ORE, 0),
        
        BRICK(26, "brick", Blocks.BRICK_BLOCK, 0),
        IRON(27, "iron", Blocks.IRON_BLOCK, 0),
        GOLD(28, "gold", Blocks.GOLD_BLOCK, 0),
        REDSTONE(29, "redstone", Blocks.REDSTONE_BLOCK, 0),
        LAPIS_LAZULI(30, "lapis_lazuli", Blocks.LAPIS_BLOCK, 0),
        DIAMOND(31, "diamond", Blocks.DIAMOND_BLOCK, 0),
        EMERALD(32, "emerald", Blocks.EMERALD_BLOCK, 0),
        
        // Tier 3:
        ICE(33, "ice", Blocks.ICE, 0),
        SLIME(34, "slime", Blocks.SLIME_BLOCK, 0),
        NETHER_BRICK(35, "nether_brick", Blocks.NETHER_BRICK, 0),
        SOUL_SAND(36, "soul_sand", Blocks.SOUL_SAND, 0),
        QUARTZ(37, "quartz", Blocks.QUARTZ_BLOCK, 0),
        GLOWSTONE(38, "glowstone", Blocks.GLOWSTONE, 0),
        OBSIDIAN(39, "obsidian", Blocks.OBSIDIAN, 0),
        
        BEDROCK(40, "bedrock", Blocks.BEDROCK, 0),
        PRISMARINE(41, "prismarine", Blocks.PRISMARINE, 0),
        END_STONE(42, "end_stone", Blocks.END_STONE, 0),
        PURPUR(43, "purpur", Blocks.PURPUR_BLOCK, 0),
    	WATER(44, "water", BlocksVM.WATER_BASIC, 0), 
    	LAVA(45, "lava", BlocksVM.LAVA_BASIC, 0), 
    	ENDER(46, "ender", BlocksVM.ENDER_BASIC, 0); 
    	
		;
		
		private final int metadata;
		private final String registryName;
        private final Block block;
		private final int blockMetadata;
        
        private VisualPrimaryTexture(int metadataIn, String registryNameIn, Block blockIn, int blockMetadataIn)
        {
        	this.metadata = metadataIn;
        	this.registryName = registryNameIn;
            this.block = blockIn;
            this.blockMetadata = blockMetadataIn;
        }
        
        public int getMetadata()
        {
        	return this.metadata;
        }
        
        public String getLocalizedName()
        {
        	return References.Old_I18n.translateToLocal(new ItemStack(Item.getItemFromBlock(block), 1, this.blockMetadata).getUnlocalizedName() + ".name");
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public ItemStack getBlock()
        {
            return new ItemStack(Item.getItemFromBlock(block), 1, this.blockMetadata);//this.block; //Block.getBlockFromItem(new ItemStack(Items.DIAMOND, 0).getItem());
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.VisualPrimaryTexture byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
	
	

	/** Visual Secondary Texture enum - Dictates registry name. */
	public static enum VisualSecondaryTexture
    {
		// STRING(meta, localized name, block, block meta):
		DEFAULT(0, "default", BlocksVM.XEGONITE_BASIC, 0),
    	
    	// Tier 0:
    	COBBLESTONE(1, "cobblestone", Blocks.COBBLESTONE, 0),
    	SANDSTONE(2, "sandstone", Blocks.SANDSTONE, 0),
        SNOW(3, "snow", Blocks.SNOW, 0),
        HAY_BLOCK(4, "hay_block", Blocks.HAY_BLOCK, 0),
        
    	// Tier 1:
        PLANK_OAK(5, "plank_oak", Blocks.PLANKS, 0),
        PLANK_SPRUCE(6, "plank_spruce", Blocks.PLANKS, 1),
        PLANK_BIRCH(7, "plank_birch", Blocks.PLANKS, 2),
        PLANK_JUNGLE(8, "plank_jungle", Blocks.PLANKS, 3),
        PLANK_ACACIA(9, "plank_acacia", Blocks.PLANKS, 4),
        PLANK_DARK_OAK(10, "plank_dark_oak", Blocks.PLANKS, 5),
        PODZOL(11, "podzol", Blocks.DIRT, 1),
        
    	LOG_OAK(12, "log_oak", Blocks.LOG, 0),
    	LOG_SPRUCE(13, "log_spruce", Blocks.LOG, 1),
    	LOG_BIRCH(14, "log_birch", Blocks.LOG, 2),
    	LOG_JUNGLE(15, "log_jungle", Blocks.LOG, 3),
    	LOG_ACACIA(16, "log_acacia", Blocks.LOG2, 0),
    	LOG_DARK_OAK(17, "log_dark_oak", Blocks.LOG2, 1),
        MYCELIUM(18, "mycelium", Blocks.MYCELIUM, 0),
        
        // Tier 2:
        ORE_QUARTZ(19, "ore_quartz", Blocks.QUARTZ_ORE, 0),
        ORE_IRON(20, "ore_iron", Blocks.IRON_ORE, 0),
        ORE_GOLD(21, "ore_gold", Blocks.GOLD_ORE, 0),
        ORE_REDSTONE(22, "ore_redstone", Blocks.REDSTONE_ORE, 0),
        ORE_LAPIS_LAZULI(23, "ore_lapis_lazuli", Blocks.LAPIS_ORE, 0),
        ORE_DIAMOND(24, "ore_diamond", Blocks.DIAMOND_ORE, 0),
        ORE_EMERALD(25, "ore_emerald", Blocks.EMERALD_ORE, 0),
        
        BRICK(26, "brick", Blocks.BRICK_BLOCK, 0),
        IRON(27, "iron", Blocks.IRON_BLOCK, 0),
        GOLD(28, "gold", Blocks.GOLD_BLOCK, 0),
        REDSTONE(29, "redstone", Blocks.REDSTONE_BLOCK, 0),
        LAPIS_LAZULI(30, "lapis_lazuli", Blocks.LAPIS_BLOCK, 0),
        DIAMOND(31, "diamond", Blocks.DIAMOND_BLOCK, 0),
        EMERALD(32, "emerald", Blocks.EMERALD_BLOCK, 0),
        
        // Tier 3:
        ICE(33, "ice", Blocks.ICE, 0),
        SLIME(34, "slime", Blocks.SLIME_BLOCK, 0),
        NETHER_BRICK(35, "nether_brick", Blocks.NETHER_BRICK, 0),
        SOUL_SAND(36, "soul_sand", Blocks.SOUL_SAND, 0),
        QUARTZ(37, "quartz", Blocks.QUARTZ_BLOCK, 0),
        GLOWSTONE(38, "glowstone", Blocks.GLOWSTONE, 0),
        OBSIDIAN(39, "obsidian", Blocks.OBSIDIAN, 0),
        
        BEDROCK(40, "bedrock", Blocks.BEDROCK, 0),
        PRISMARINE(41, "prismarine", Blocks.PRISMARINE, 0),
        END_STONE(42, "end_stone", Blocks.END_STONE, 0),
        PURPUR(43, "purpur", Blocks.PURPUR_BLOCK, 0),
    	WATER(44, "water", BlocksVM.WATER_BASIC, 0), 
    	LAVA(45, "lava", BlocksVM.LAVA_BASIC, 0), 
    	ENDER(46, "ender", BlocksVM.ENDER_BASIC, 0); 
    	
		;
		
		private final int metadata;
		private final String registryName;
        private final Block block;
		private final int blockMetadata;
        
        private VisualSecondaryTexture(int metadataIn, String registryNameIn, Block blockIn, int blockMetadataIn)
        {
        	this.metadata = metadataIn;
        	this.registryName = registryNameIn;
            this.block = blockIn;
            this.blockMetadata = blockMetadataIn;
        }
        
        public int getMetadata()
        {
        	return this.metadata;
        }
        
        public String getLocalizedName()
        {
        	return References.Old_I18n.translateToLocal(new ItemStack(Item.getItemFromBlock(block), 1, this.blockMetadata).getUnlocalizedName() + ".name");
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public ItemStack getBlock()
        {
            return new ItemStack(Item.getItemFromBlock(block), 1, this.blockMetadata);//this.block; //Block.getBlockFromItem(new ItemStack(Items.DIAMOND, 0).getItem());
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.VisualSecondaryTexture byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
	
	/** Visual Display Symbol enum - Dictates registry name. */
	public static enum VisualDisplaySymbol
    {
		// STRING(meta, localized name, item):
		// General:
		SYMBOL_LOGOFORGE(0, "forge", ItemsVM.SYMBOL_LOGOFORGE),
		SYMBOL_COINSTACK(1, "coinstack", ItemsVM.SYMBOL_COINSTACK),
		SYMBOL_SCROLL(2, "scroll", ItemsVM.SYMBOL_SCROLL),
		SYMBOL_WRENCH(3, "wrench", ItemsVM.SYMBOL_WRENCH),
		SYMBOL_KEY(4, "key", ItemsVM.SYMBOL_KEY),
		SYMBOL_PADLOCK(5, "padlock", ItemsVM.SYMBOL_PADLOCK),
		SYMBOL_BELL(6, "bell", ItemsVM.SYMBOL_BELL),
		SYMBOL_ANCHOR(7, "anchor", ItemsVM.SYMBOL_ANCHOR),
		SYMBOL_BARREL(8, "barrel", ItemsVM.SYMBOL_BARREL),
		SYMBOL_GEARS(9, "gears", ItemsVM.SYMBOL_GEARS),
        
        /*
        PLANK_DARK_OAK(10, "plank_dark_oak", Blocks.PLANKS, 5),
        PODZOL(11, "podzol", Blocks.DIRT, 1),
        ICE(12, "ice", Blocks.ICE, 0),
        
    	LOG_OAK(13, "log_oak", Blocks.LOG, 0),
    	LOG_SPRUCE(14, "log_spruce", Blocks.LOG, 1),
    	LOG_BIRCH(15, "log_birch", Blocks.LOG, 2),
    	LOG_JUNGLE(16, "log_jungle", Blocks.LOG, 3),
    	LOG_ACACIA(17, "log_acacia", Blocks.LOG2, 0),
    	LOG_DARK_OAK(18, "log_dark_oak", Blocks.LOG2, 1),
        MYCELIUM(19, "mycelium", Blocks.MYCELIUM, 0),
        BRICK(20, "brick", Blocks.BRICK_BLOCK, 0),
        
        // Tier 2:
        ORE_IRON(21, "ore_iron", Blocks.IRON_ORE, 0),
        ORE_GOLD(22, "ore_gold", Blocks.GOLD_ORE, 0),
        ORE_REDSTONE(23, "ore_redstone", Blocks.REDSTONE_ORE, 0),
        ORE_LAPIS_LAZULI(24, "ore_lapis_lazuli", Blocks.LAPIS_ORE, 0),
        ORE_DIAMOND(25, "ore_diamond", Blocks.DIAMOND_ORE, 0),
        ORE_EMERALD(26, "ore_emerald", Blocks.EMERALD_ORE, 0),
        
        IRON(27, "iron", Blocks.IRON_BLOCK, 0),
        GOLD(28, "gold", Blocks.GOLD_BLOCK, 0),
        REDSTONE(29, "redstone", Blocks.REDSTONE_BLOCK, 0),
        LAPIS_LAZULI(30, "lapis_lazuli", Blocks.LAPIS_BLOCK, 0),
        DIAMOND(31, "diamond", Blocks.DIAMOND_BLOCK, 0),
        EMERALD(32, "emerald", Blocks.EMERALD_BLOCK, 0),
        
        // Tier 3:
        SLIME(33, "slime", Blocks.SLIME_BLOCK, 0),
        NETHER_BRICK(34, "nether_brick", Blocks.NETHER_BRICK, 0),
        SOUL_SAND(35, "soul_sand", Blocks.SOUL_SAND, 0),
        QUARTZ(36, "quartz", Blocks.QUARTZ_BLOCK, 0),
        GLOWSTONE(37, "glowstone", Blocks.GLOWSTONE, 0),
        OBSIDIAN(38, "obsidian", Blocks.OBSIDIAN, 0),
        
        PRISMARINE(39, "prismarine", Blocks.PRISMARINE, 0),
        END_STONE(40, "end_stone", Blocks.END_STONE, 0),
        PURPUR(41, "purpur", Blocks.PURPUR_BLOCK, 0),
    	WATER(42, "water", BlocksVM.WATER_BASIC, 0), 
    	LAVA(43, "lava", BlocksVM.LAVA_BASIC, 0), 
    	ENDER(44, "ender", BlocksVM.ENDER_BASIC, 0); 
    	*/
		;
		
		private final int metadata;
		private final String registryName;
        private final Item item;
        
        private VisualDisplaySymbol(int metadataIn, String registryNameIn, Item itemIn)
        {
        	this.metadata = metadataIn;
        	this.registryName = registryNameIn;
            this.item = itemIn;
        }
        
        public int getMetadata()
        {
        	return this.metadata;
        }
        
        public String getLocalizedName()
        {
        	return References.Old_I18n.translateToLocal(new ItemStack(this.item, 1).getUnlocalizedName() + ".name");
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public Item getItem()
        {
            return this.item;//this.block; //Block.getBlockFromItem(new ItemStack(Items.DIAMOND, 0).getItem());
        }
        
        public ItemStack getItemStack()
        {
            return new ItemStack(this.item);//this.block; //Block.getBlockFromItem(new ItemStack(Items.DIAMOND, 0).getItem());
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.VisualDisplaySymbol byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
}
