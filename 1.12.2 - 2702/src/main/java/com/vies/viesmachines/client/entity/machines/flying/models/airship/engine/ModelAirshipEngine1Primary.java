package com.vies.viesmachines.client.entity.machines.flying.models.airship.engine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipEngine1Primary extends ModelBase
{
    ModelRenderer Primary_Engine_Chassis;
    ModelRenderer Primary_Engine_Smokestack;
    ModelRenderer Primary_Engine_Pipe;

    public ModelAirshipEngine1Primary()
    {
        this( 0.0f );
    }

    public ModelAirshipEngine1Primary( float par1 )
    {
        Primary_Engine_Chassis = new ModelRenderer( this, 0, 18 );
        Primary_Engine_Chassis.setTextureSize( 128, 128 );
        Primary_Engine_Chassis.addBox( 0F, 0F, 0F, 6, 6, 6);
        Primary_Engine_Chassis.setRotationPoint( -3F, -0.6000004F, 11.1F );
        Primary_Engine_Smokestack = new ModelRenderer( this, 24, 21 );
        Primary_Engine_Smokestack.setTextureSize( 128, 128 );
        Primary_Engine_Smokestack.addBox( -0.5F, -1F, -0.5F, 3, 6, 3);
        Primary_Engine_Smokestack.setRotationPoint( -1F, -2.5F, 15.6F );
        Primary_Engine_Pipe = new ModelRenderer( this, 36, 25 );
        Primary_Engine_Pipe.setTextureSize( 128, 128 );
        Primary_Engine_Pipe.addBox( 0F, -0.5F, 0F, 12, 3, 2);
        Primary_Engine_Pipe.setRotationPoint( -6F, 1.9F, 14.1F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Primary_Engine_Chassis.rotateAngleX = 0F;
        Primary_Engine_Chassis.rotateAngleY = 0F;
        Primary_Engine_Chassis.rotateAngleZ = 0F;
        Primary_Engine_Chassis.renderWithRotation(par7);

        Primary_Engine_Smokestack.rotateAngleX = 0F;
        Primary_Engine_Smokestack.rotateAngleY = 0F;
        Primary_Engine_Smokestack.rotateAngleZ = 0F;
        Primary_Engine_Smokestack.renderWithRotation(par7);

        Primary_Engine_Pipe.rotateAngleX = 0F;
        Primary_Engine_Pipe.rotateAngleY = 0F;
        Primary_Engine_Pipe.rotateAngleZ = 0F;
        Primary_Engine_Pipe.renderWithRotation(par7);

    }

}
