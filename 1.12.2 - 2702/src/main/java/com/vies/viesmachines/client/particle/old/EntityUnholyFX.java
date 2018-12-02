package com.vies.viesmachines.client.particle.old;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityUnholyFX extends ParticleFlame {
    
    public EntityUnholyFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        //this.particleScale = 10.25F;//.particleScale.particleMaxAge = 2;
        setParticleTextureIndex(65);
        setRBGColorF(0, 135, 0);
    }
    
}