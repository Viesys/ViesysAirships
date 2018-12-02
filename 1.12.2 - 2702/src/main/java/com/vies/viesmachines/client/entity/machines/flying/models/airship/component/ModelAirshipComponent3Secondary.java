package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipComponent3Secondary extends ModelBase
{
    //ModelRenderer Floor_Top;
    ModelRenderer BalloonTR1;
    ModelRenderer BalloonTL1;
    ModelRenderer BalloonBL1;
    ModelRenderer BalloonBL2;
    ModelRenderer BalloonBR1;
    ModelRenderer BalloonBR2;

    public ModelAirshipComponent3Secondary()
    {
        this( 0.0f );
    }

    public ModelAirshipComponent3Secondary( float par1 )
    {
        //Floor_Top = new ModelRenderer( this, 180, 0 );
        //Floor_Top.setTextureSize( 256, 256 );
        //Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        //Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
        BalloonTR1 = new ModelRenderer( this, 0, 42 );
        BalloonTR1.setTextureSize( 256, 256 );
        BalloonTR1.addBox( 0F, 0F, 0F, 8, 8, 27);
        BalloonTR1.setRotationPoint( -21F, -14F, -10F );
        BalloonTL1 = new ModelRenderer( this, 0, 77 );
        BalloonTL1.setTextureSize( 256, 256 );
        BalloonTL1.addBox( 0F, 0F, 0F, 8, 8, 27);
        BalloonTL1.setRotationPoint( 13F, -14F, -10F );
        BalloonBL1 = new ModelRenderer( this, 44, 20 );
        BalloonBL1.setTextureSize( 256, 256 );
        BalloonBL1.addBox( 0F, 0F, 0F, 6, 6, 16);
        BalloonBL1.setRotationPoint( 14F, -2F, -2F );
        BalloonBL2 = new ModelRenderer( this, 40, 0 );
        BalloonBL2.setTextureSize( 256, 256 );
        BalloonBL2.addBox( 0F, 0F, 0F, 4, 4, 16);
        BalloonBL2.setRotationPoint( 15F, -1F, -3F );
        BalloonBR1 = new ModelRenderer( this, 0, 20 );
        BalloonBR1.setTextureSize( 256, 256 );
        BalloonBR1.addBox( 0F, 0F, 0F, 6, 6, 16);
        BalloonBR1.setRotationPoint( -20F, -2F, -2F );
        BalloonBR2 = new ModelRenderer( this, 0, 0 );
        BalloonBR2.setTextureSize( 256, 256 );
        BalloonBR2.addBox( 0F, 0F, 0F, 4, 4, 16);
        BalloonBR2.setRotationPoint( -19F, -1F, -3F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        //Floor_Top.rotateAngleX = 0F;
        //Floor_Top.rotateAngleY = 0F;
        //Floor_Top.rotateAngleZ = 0F;
        //Floor_Top.renderWithRotation(par7);

        BalloonTR1.rotateAngleX = 0F;
        BalloonTR1.rotateAngleY = 0F;
        BalloonTR1.rotateAngleZ = 0F;
        BalloonTR1.renderWithRotation(par7);

        BalloonTL1.rotateAngleX = 0F;
        BalloonTL1.rotateAngleY = 0F;
        BalloonTL1.rotateAngleZ = 0F;
        BalloonTL1.renderWithRotation(par7);

        BalloonBL1.rotateAngleX = 0F;
        BalloonBL1.rotateAngleY = 0F;
        BalloonBL1.rotateAngleZ = 0F;
        BalloonBL1.renderWithRotation(par7);

        BalloonBL2.rotateAngleX = 0F;
        BalloonBL2.rotateAngleY = 0F;
        BalloonBL2.rotateAngleZ = 0F;
        BalloonBL2.renderWithRotation(par7);

        BalloonBR1.rotateAngleX = 0F;
        BalloonBR1.rotateAngleY = 0F;
        BalloonBR1.rotateAngleZ = 0F;
        BalloonBR1.renderWithRotation(par7);

        BalloonBR2.rotateAngleX = 0F;
        BalloonBR2.rotateAngleY = 0F;
        BalloonBR2.rotateAngleZ = 0F;
        BalloonBR2.renderWithRotation(par7);

    }

}
