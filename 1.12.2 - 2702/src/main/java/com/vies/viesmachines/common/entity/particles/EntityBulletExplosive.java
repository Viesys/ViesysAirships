package com.vies.viesmachines.common.entity.particles;

import com.vies.viesmachines.api.ItemsVM;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBulletExplosive extends EntityArrow {
	
	private double damage = 6.0D;
	
	public EntityBulletExplosive(World worldIn)
    {
        super(worldIn);
        this.setDamage(this.damage);
        this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
    }
	
    public EntityBulletExplosive(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
        this.setDamage(this.damage);
        this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
    }
    
    public EntityBulletExplosive(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
        this.setDamage(this.damage);
        this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
    }
    
    @Override
    protected void entityInit()
    {
        super.entityInit();
    }
    
    @Override
    public void onUpdate()
    {
    	if (this.world.isRemote && !this.inGround)
        {
            this.world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    	
        super.onUpdate();
        
    	if (this.timeInGround >= 5)
    	{
    		this.setDead();
    	}
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
    protected void arrowHit(EntityLivingBase living)
    {
        super.arrowHit(living);
    }
    
	@Override
	protected ItemStack getArrowStack() 
	{
		return new ItemStack(ItemsVM.MACHINE_AMMO);
	}
	
	@Override
	protected void onHit(RayTraceResult raytraceResultIn)
    {
		Entity entity = raytraceResultIn.entityHit;
		
		if (entity != null)
        {
			if (this.shootingEntity == entity)
			{
				return;
			}
			else
			{
				super.onHit(raytraceResultIn);
			}
        }
		else
        {
            super.onHit(raytraceResultIn);
        }
		
		this.conjureExplosion();
		this.setDead();
    }
    
    @Override
    public float getBrightness()
    {
        return 1.0F;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }
	
	private void conjureExplosion()
	{
		this.world.createExplosion(this, this.posX, this.posY, this.posZ, 1.5F, true);
	}
}
