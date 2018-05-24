package com.viesys.viesysmachines.client.entity.model.engine;

import com.viesys.viesysmachines.api.References;
import com.viesys.viesysmachines.client.InitParticlesVCRender;
import com.viesys.viesysmachines.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEngine0 extends ModelBase
{
    ModelRenderer Engine_Chassis;
    ModelRenderer Engine_Smokestack;

    public ModelEngine0()
    {
        this( 0.0f );
    }

    public ModelEngine0( float par1 )
    {
        Engine_Chassis = new ModelRenderer( this, 0, 16 );
        Engine_Chassis.setTextureSize( 128, 128 );
        Engine_Chassis.addBox( 1F, 1F, 1F, 4, 4, 4);
        Engine_Chassis.setRotationPoint( -3F, -0.5F, 11.5F );
        Engine_Smokestack = new ModelRenderer( this, 12, 16 );
        Engine_Smokestack.setTextureSize( 128, 128 );
        Engine_Smokestack.addBox( 0F, 1F, 0F, 2, 2, 2);
        Engine_Smokestack.setRotationPoint( -1F, -2.5F, 13.5F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
	   EntityAirshipCore airshipIn = (EntityAirshipCore) par1Entity;
	   
	    Engine_Chassis.rotateAngleX = 0F;
        Engine_Chassis.rotateAngleY = 0F;
        Engine_Chassis.rotateAngleZ = 0F;
        Engine_Chassis.renderWithRotation(par7);

        Engine_Smokestack.rotateAngleX = 0F;
        Engine_Smokestack.rotateAngleY = 0F;
        Engine_Smokestack.rotateAngleZ = 0F;
        Engine_Smokestack.renderWithRotation(par7);
        
        //Airship smoke particles while on
        if(airshipIn.getStoredFuel() > 0)
        {
	        int randomTick = References.random.nextInt(100) + 1;
			
			if(randomTick < 20)
			{
				if(!Minecraft.getMinecraft().isGamePaused())
				{
					InitParticlesVCRender.generateAirshipSmokeParticles0(par1Entity, 0, -0.14, 0);
				}
			}
        }
    }
}
