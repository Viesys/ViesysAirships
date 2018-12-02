package com.vies.viesmachines.client.particle.old;

import net.minecraft.client.particle.ParticleEnchantmentTable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityRunicWhiteFX extends ParticleEnchantmentTable {
	
	public EntityRunicWhiteFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        particleScale = 0.5F;
        //setRBGColorF(1, 1, 1);
    }
}
