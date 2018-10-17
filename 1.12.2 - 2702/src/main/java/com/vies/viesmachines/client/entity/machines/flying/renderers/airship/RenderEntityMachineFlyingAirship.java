package com.vies.viesmachines.client.entity.machines.flying.renderers.airship;

import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.ModelAirshipFrameSkids;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent0Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent0Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent1Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent1Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine0Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine0Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine1Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine1Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine2Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine2Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame0Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame0Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame1Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame1Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame2Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame2Secondary;
import com.vies.viesmachines.client.entity.model.ModelAirshipPanel;
import com.vies.viesmachines.client.entity.model.ModelAirshipPropeller;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.types.EntityMachineFlyingAirship;
import com.vies.viesmachines.configs.VMConfiguration;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityMachineFlyingAirship extends RenderLiving<EntityMachineFlyingAirship> {
	
	protected ModelBase modelAirshipSkids = new ModelAirshipFrameSkids();
	
	
	/** Instance of Panel Screen Model for rendering. */
  	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
  	/** Instance of Propeller Model for rendering. */
  	protected ModelBase modelAirshipPropeller = new ModelAirshipPropeller();
  	
	protected ModelBase modelAirshipFrame0Primary = new ModelAirshipFrame0Primary();
	protected ModelBase modelAirshipFrame0Secondary = new ModelAirshipFrame0Secondary();
	protected ModelBase modelAirshipFrame1Primary = new ModelAirshipFrame1Primary();
	protected ModelBase modelAirshipFrame1Secondary = new ModelAirshipFrame1Secondary();
	protected ModelBase modelAirshipFrame2Primary = new ModelAirshipFrame2Primary();
	protected ModelBase modelAirshipFrame2Secondary = new ModelAirshipFrame2Secondary();
	
	protected ModelBase modelAirshipEngine0Primary = new ModelAirshipEngine0Primary();
	protected ModelBase modelAirshipEngine0Secondary = new ModelAirshipEngine0Secondary();
	protected ModelBase modelAirshipEngine1Primary = new ModelAirshipEngine1Primary();
	protected ModelBase modelAirshipEngine1Secondary = new ModelAirshipEngine1Secondary();
	protected ModelBase modelAirshipEngine2Primary = new ModelAirshipEngine2Primary();
	protected ModelBase modelAirshipEngine2Secondary = new ModelAirshipEngine2Secondary();
	
	protected ModelBase modelAirshipComponent0Primary = new ModelAirshipComponent0Primary();
	protected ModelBase modelAirshipComponent0Secondary = new ModelAirshipComponent0Secondary();
	protected ModelBase modelAirshipComponent1Primary = new ModelAirshipComponent1Primary();
	protected ModelBase modelAirshipComponent1Secondary = new ModelAirshipComponent1Secondary();
	protected ModelBase modelAirshipComponent2Primary = new ModelAirshipComponent1Primary();
	protected ModelBase modelAirshipComponent2Secondary = new ModelAirshipComponent1Secondary();
	
	
  	
  	protected ModelBase currentModelFramePrimary;
  	protected ModelBase currentModelFrameSecondary;
  	protected ModelBase currentModelEnginePrimary;
  	protected ModelBase currentModelEngineSecondary;
  	protected ModelBase currentModelComponentPrimary;
  	protected ModelBase currentModelComponentSecondary;
	
  	
  	
	//==================================================
    // TODO             Constructor
	//==================================================
	
	public RenderEntityMachineFlyingAirship(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn)
    {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
        this.shadowSize = 1.0F;
    }
    
	
	
	//==================================================
    // TODO            Render Logic
	//==================================================
    
	/** Enable multiple textures on one model. */
    @Override
    public boolean isMultipass()
    {
        return true;
    }
    
	@Override
    public void doRender(EntityMachineFlyingAirship entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();
        
    	// Needed to fix the texture overlap clipping:
    	GL11.glEnable(GL11.GL_CULL_FACE);
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        
        // Sets all models correctly depending on machine values:
        this.getCurrentModelAirshipFramePrimary(entity);
        this.getCurrentModelAirshipFrameSecondary(entity);
        this.getCurrentModelAirshipEnginePrimary(entity);
        this.getCurrentModelAirshipEngineSecondary(entity);
        this.getCurrentModelAirshipComponentPrimary(entity);
        this.getCurrentModelAirshipComponentSecondary(entity);
        
        
        
        
        
        
        // Render the Frame / Engine / Component (Primary):
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVM.VisualPrimaryTexture.byId(0).getRegistryName() + ".png"));
        
        if (entity.getPreviewPart() == 1)
        {
        	this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
        	// Render the skids when a machine is on the ground:
            if (entity.status == entity.status.ON_LAND)
            {
            	this.modelAirshipSkids.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
        }
        else if (entity.getPreviewPart() == 2)
        {
        	this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        else if (entity.getPreviewPart() == 3)
        {
        	this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.airshipPropellers(entity);
        }
        else
        {
        	this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            this.airshipPropellers(entity);
        }
        
        
        
        
        
        
        

        // Render the Frame / Component (Secondary):
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/bg_"+ EnumsVM.VisualBalloonPattern.byId(0).getRegistryName() +".png"));
        
        if (entity.getPreviewPart() == 1)
        {
        	this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        else if (entity.getPreviewPart() == 2)
        {
        	this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        else if (entity.getPreviewPart() == 3)
        {
        	this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.airshipPropellers(entity);
        }
        else
        {
        	this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            this.airshipPropellers(entity);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        //float bombspin = (((float)entity.getEntityWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
        //GlStateManager.rotate((bombspin), 0F, 1F, 0F);		
    	
        
        
        
        
       // int randomTick = References.random.nextInt(100) + 1;
		
		//if(randomTick < 20)
		//{
		//	if(!Minecraft.getMinecraft().isGamePaused())
		//	{
		//		InitParticlesVCRender.generateBombFuseSmokeParticles(entity);
		//		InitParticlesVCRender.generateBombFuseFlameParticles(entity);
		//	}
		//}
		
        
        //Messes up for some reason? May have to fix but could just ditch.
        //if (!this.renderOutlines)
        //{
        //    this.renderLeash(entity, x, y, z, entityYaw, partialTicks);
        //}
        
        // Needed to remove the fix at the end.
    	GL11.glDisable(GL11.GL_CULL_FACE);
        
        
        
        if(VMConfiguration.renderNameplates)
    	{
        	this.renderMachineInfo(entity);
    	}
        
        
        /**
        if(this.baseitemSpin >= 360)
        {
        	this.baseitemSpin = 0;
        }
        else
        {
        	//float test = Minecraft.getMinecraft().player.rotationYawHead % 360;
        	//Minecraft.getMinecraft().player.rotationYawHead = 0;
        	this.baseitemSpin = 
        			
        			//(baseitemSpin % Minecraft.getMinecraft().player.rotationYawHead)
        			//(Minecraft.getMinecraft().player.rotationYawHead % (baseitemSpin +1))
        			//+
        			(this.baseitemSpin + 5.0F) 
        			 ;
        			
        			//+ 
        			//(Minecraft.getMinecraft().player.rotationYawHead  % 360);
        	
        	//Minecraft.getMinecraft().player.rotationYawHead = test;
        }
        
        LogHelper.info(this.baseitemSpin);
        */
        GlStateManager.popMatrix();
        
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
    public void renderMultipass(EntityMachineFlyingAirship entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();

    	// Needed to fix the texture overlap clipping.
    	GL11.glEnable(GL11.GL_CULL_FACE);
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        
        
        this.getCurrentModelAirshipFramePrimary(entity);
        this.getCurrentModelAirshipFrameSecondary(entity);
        this.getCurrentModelAirshipEnginePrimary(entity);
        this.getCurrentModelAirshipEngineSecondary(entity);
        this.getCurrentModelAirshipComponentPrimary(entity);
        this.getCurrentModelAirshipComponentSecondary(entity);
        
        
        
        if (entity.getPreviewPart() == 1)
        {
        	// Render the Frame (Primary/Secondary):
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_frame_primary.png"));
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_frame_secondary.png"));
            this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        else if (entity.getPreviewPart() == 2)
        {
        	// Render the Engine (Primary/Secondary):
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/engines/overlay_airship_engine_primary.png"));
            this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/engines/overlay_airship_engine_secondary.png"));
            this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        else if (entity.getPreviewPart() == 3)
        {
        	// Render the Component (Primary/Secondary):
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/overlay_airship_component_primary.png"));
            this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/overlay_airship_component_secondary.png"));
            this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_propeller.png"));
        	this.airshipPropellers(entity);
        }
        else
        {
        	// Render the Frame (Primary/Secondary):
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_frame_primary.png"));
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_frame_secondary.png"));
            this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Render skids when a machine in on the ground:
            if (entity.status == entity.status.ON_LAND)
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_frame_primary.png"));
                modelAirshipSkids.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
            // Render the Engine (Primary/Secondary):
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/engines/overlay_airship_engine_primary.png"));
            this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/engines/overlay_airship_engine_secondary.png"));
            this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Render the Component (Primary/Secondary):
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/overlay_airship_component_primary.png"));
            this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/overlay_airship_component_secondary.png"));
            this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_propeller.png"));
        	this.airshipPropellers(entity);
        }
        
        
        
        
        
        

        
        
        
        
        
        
        
        
        
        
        
        
        //this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/overlay.png"));
        //modelFrameComponent0.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        
        
        
        
        
        //this.getCurrentModel(entity);
        
        //this.selectedModelMultiFrame(entity, partialTicks);
    	//this.selectedModelMultiEngine(entity, partialTicks);
        //this.selectedModelMultiBalloonF(entity, partialTicks);
    	//this.selectedModelMultiBalloonB(entity, partialTicks);
    	//this.selectedModelMultiPropeller(entity, partialTicks, entity.coreModelVisualBalloon);

    	//if(entity.getEngineDisplayTypeVisual() != 0)
    	//{
    	//	this.selectedModelMultiBalloonDS(entity, partialTicks);
    	//}
    	
    	GL11.glDisable(GL11.GL_CULL_FACE);
    	
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        
    }
    
    
    
    
    
    
    
    
    
    
    

    
	
	
	//==================================================
    // TODO         Overrides in Renderer
	//==================================================
    
    public void setupRotation(EntityMachineFlyingAirship entity, float p_188311_2_, float p_188311_3_)
    {
    	GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
    }
    
    public void setupTranslation(double p_188309_1_, double p_188309_3_, double p_188309_5_)
    {
        GlStateManager.translate((float)p_188309_1_, (float)p_188309_3_ + 0.375F + 0.25F, (float)p_188309_5_);
    }
    
    /** Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture. */
    @Override
    protected ResourceLocation getEntityTexture(EntityMachineFlyingAirship entity)
    {
        return null;
    }
    
    public boolean shouldRender(EntityMachineFlyingAirship livingEntity, ICamera camera, double camX, double camY, double camZ)
    {
        if (super.shouldRender(livingEntity, camera, camX, camY, camZ))
        {
            return true;
        }
        else if (livingEntity.getLeashed() && livingEntity.getLeashHolder() != null)
        {
            Entity entity = livingEntity.getLeashHolder();
            return camera.isBoundingBoxInFrustum(entity.getRenderBoundingBox());
        }
        else
        {
            return false;
        }
    }
    
    private double interpolateValue(double start, double end, double pct)
    {
        return start + (end - start) * pct;
    }
    
    protected void renderLeash(EntityMachineFlyingAirship entityLivingIn, double x, double y, double z, float entityYaw, float partialTicks)
    {
        Entity entity = entityLivingIn.getLeashHolder();

        if (entity != null)
        {
            y = y - (1.6D - (double)entityLivingIn.height) * 0.5D;
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            double d0 = this.interpolateValue((double)entity.prevRotationYaw, (double)entity.rotationYaw, (double)(partialTicks * 0.5F)) * 0.01745329238474369D;
            double d1 = this.interpolateValue((double)entity.prevRotationPitch, (double)entity.rotationPitch, (double)(partialTicks * 0.5F)) * 0.01745329238474369D;
            double d2 = Math.cos(d0);
            double d3 = Math.sin(d0);
            double d4 = Math.sin(d1);

            if (entity instanceof EntityHanging)
            {
                d2 = 0.0D;
                d3 = 0.0D;
                d4 = -1.0D;
            }

            double d5 = Math.cos(d1);
            double d6 = this.interpolateValue(entity.prevPosX, entity.posX, (double)partialTicks) - d2 * 0.7D - d3 * 0.5D * d5;
            double d7 = this.interpolateValue(entity.prevPosY + (double)entity.getEyeHeight() * 0.7D, entity.posY + (double)entity.getEyeHeight() * 0.7D, (double)partialTicks) - d4 * 0.5D - 0.25D;
            double d8 = this.interpolateValue(entity.prevPosZ, entity.posZ, (double)partialTicks) - d3 * 0.7D + d2 * 0.5D * d5;
            double d9 = this.interpolateValue((double)entityLivingIn.prevRenderYawOffset, (double)entityLivingIn.renderYawOffset, (double)partialTicks) * 0.01745329238474369D + (Math.PI / 2D);
            d2 = Math.cos(d9) * (double)entityLivingIn.width * 0.4D;
            d3 = Math.sin(d9) * (double)entityLivingIn.width * 0.4D;
            double d10 = this.interpolateValue(entityLivingIn.prevPosX, entityLivingIn.posX, (double)partialTicks) + d2;
            double d11 = this.interpolateValue(entityLivingIn.prevPosY, entityLivingIn.posY, (double)partialTicks);
            double d12 = this.interpolateValue(entityLivingIn.prevPosZ, entityLivingIn.posZ, (double)partialTicks) + d3;
            x = x + d2;
            z = z + d3;
            double d13 = (double)((float)(d6 - d10));
            double d14 = (double)((float)(d7 - d11));
            double d15 = (double)((float)(d8 - d12));
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            int i = 24;
            double d16 = 0.025D;
            bufferbuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);

            for (int j = 0; j <= 24; ++j)
            {
                float f = 0.5F;
                float f1 = 0.4F;
                float f2 = 0.3F;

                if (j % 2 == 0)
                {
                    f *= 0.7F;
                    f1 *= 0.7F;
                    f2 *= 0.7F;
                }

                float f3 = (float)j / 24.0F;
                bufferbuilder.pos(x + d13 * (double)f3 + 0.0D, y + d14 * (double)(f3 * f3 + f3) * 0.5D + (double)((24.0F - (float)j) / 18.0F + 0.125F), z + d15 * (double)f3).color(f, f1, f2, 1.0F).endVertex();
                bufferbuilder.pos(x + d13 * (double)f3 + 0.025D, y + d14 * (double)(f3 * f3 + f3) * 0.5D + (double)((24.0F - (float)j) / 18.0F + 0.125F) + 0.025D, z + d15 * (double)f3).color(f, f1, f2, 1.0F).endVertex();
            }

            tessellator.draw();
            bufferbuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);

            for (int k = 0; k <= 24; ++k)
            {
                float f4 = 0.5F;
                float f5 = 0.4F;
                float f6 = 0.3F;

                if (k % 2 == 0)
                {
                    f4 *= 0.7F;
                    f5 *= 0.7F;
                    f6 *= 0.7F;
                }

                float f7 = (float)k / 24.0F;
                bufferbuilder.pos(x + d13 * (double)f7 + 0.0D, y + d14 * (double)(f7 * f7 + f7) * 0.5D + (double)((24.0F - (float)k) / 18.0F + 0.125F) + 0.025D, z + d15 * (double)f7).color(f4, f5, f6, 1.0F).endVertex();
                bufferbuilder.pos(x + d13 * (double)f7 + 0.025D, y + d14 * (double)(f7 * f7 + f7) * 0.5D + (double)((24.0F - (float)k) / 18.0F + 0.125F), z + d15 * (double)f7 + 0.025D).color(f4, f5, f6, 1.0F).endVertex();
            }

            tessellator.draw();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.enableCull();
        }
    }
    
    /** Disables the overhead generic Minecraft name logic. */
    @Override
    protected boolean canRenderName(EntityMachineFlyingAirship entity)
    {
        return false;//super.canRenderName(entity) && (entity.getAlwaysRenderNameTagForRender() || entity.hasCustomName() && entity == this.renderManager.pointedEntity);
    }
    
    
	
	//==================================================
    // TODO             Custom Logic
	//==================================================
    
	
    /** Gets the Font Renderer. */
    protected FontRenderer getFontRenderer()
    {
        return Minecraft.getMinecraft().fontRenderer;
    }
    
    /** Renders all of the machine info over the entity. */
    private void renderMachineInfo(EntityMachineFlyingAirship entity)
    {
    	if(entity.isBeingRidden())
        {
        	
        }
        else
        {
        	EntityPlayerSP playerIn = Minecraft.getMinecraft().player;
        	float prevAirshipYaw = playerIn.rotationYaw;
        	float nameplateYaw = (prevAirshipYaw%360) - entity.rotationYaw;
        	Entity raytraceHitTarget = Minecraft.getMinecraft().objectMouseOver.entityHit;
        	
        	if (raytraceHitTarget instanceof EntityMachineBase)
        	{
        		if(raytraceHitTarget == entity)
        		{
        			if (!playerIn.isSneaking())
		    		{
        				// Custom Name:
	        			GlStateManager.pushMatrix();
	    		    	{
	    		    		GlStateManager.scale(0.75F, 0.75F, 0.75F);
	    		    		GlStateManager.rotate(180, 1, 0, 0);
	    		    		
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), EnumsVM.SelectColor.byId(entity.getVisualNameColor()).getTextColor() + entity.getCustomNameTag(), 0F, 1.07F, 0F, 0, nameplateYaw, 0F, false, false);
	    		        }
	    		    	GlStateManager.popMatrix();
	    		    	
	    		    	this.renderFuelGauge(entity, nameplateYaw);
    		    		
	    		    	// Health and Energy and Shift info:
	    		    	GlStateManager.pushMatrix();
	    		    	{
	    		    		GlStateManager.scale(0.5F, 0.5F, 0.5F);
	    		    		GlStateManager.rotate(180, 1, 0, 0);
	    		    		
	    		    		if (entity.getBroken())
	    		    		{
	    			    		EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.RED + "Broken", 0F, 1.00F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.RED + "Health : " + TextFormatting.WHITE + (int)entity.getHealth() + " / " + (int)EnumsVM.FlyingMachineFrameTier.byId(entity.getTierFrame()).getMaxHealthModifier(), 0F, 1.00F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.YELLOW + "Energy : " + TextFormatting.WHITE + entity.getEnergy() + " / " + EnumsVM.FlyingMachineFrameTier.byId(entity.getTierFrame()).getMaxEnergyModifier(), 0F, 0.75F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "Hold [Shift] for more info.", 0F, 0.50F, 0F, 0, nameplateYaw, 0F, false, false);
	    		        }
	    		    	GlStateManager.popMatrix();
		    		}
		    		else
		    		{
		    			// Health and Energy and Shift info:
	    		    	GlStateManager.pushMatrix();
	    		    	{
	    		    		GlStateManager.scale(0.5F, 0.5F, 0.5F);
	    		    		GlStateManager.rotate(180, 1, 0, 0);
	    		    		
	    		    		String ammoType = "Normal";
	    		    		
	    		    		if (entity.getAmmoType() == 1)
	    		    		{
	    		    			ammoType = "Electrical";
	    		    		}
	    		    		if (entity.getAmmoType() == 2)
	    		    		{
	    		    			ammoType = "Explosive";
	    		    		}
	    		    		
	    		    		// Frame info:
	    		    		if (entity.getTierFrame() == 0)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Frame : " + "None", 0F, 1.50F, 0F, 0, nameplateYaw, playerIn.rotationPitch, false, false);
	    		    		}
	    		    		else
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Frame : " + "Tier " + entity.getTierFrame(), 0F, 1.50F, 0F, 0, nameplateYaw, playerIn.rotationPitch, false, false);
	    		    		}
	    		    		
	    		    		// Engine info:
	    		    		if (entity.getTierEngine() == 0)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Engine : " + "None", 0F, 1.25F, 0F, 0, nameplateYaw, playerIn.rotationPitch, false, false);
	    		    		}
	    		    		else
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Engine : " + "Tier " + entity.getTierEngine(), 0F, 1.25F, 0F, 0, nameplateYaw, playerIn.rotationPitch, false, false);
	    		    		}
	    		    		
	    		    		// Component info:
	    		    		if (entity.getTierComponent() == 0)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Component : " + "None", 0F, 1.00F, 0F, 0, nameplateYaw, playerIn.rotationPitch, false, false);
	    		    		}
	    		    		else
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Component : " + "Tier " + entity.getTierComponent(), 0F, 1.00F, 0F, 0, nameplateYaw, playerIn.rotationPitch, false, false);
	    		    		}
	    		    		
	    		    		// Ammo Type info:
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Ammo Type : " + ammoType, 0F, 0.75F, 0F, 0, nameplateYaw, playerIn.rotationPitch, false, false);
	    		    		
	    		    		// Ammo Amount info:
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Ammo Amount : " + entity.getAmmoAmount() + "/" + EnumsVM.FlyingMachineComponentTier.byId(entity.getTierComponent()).getMaxAmmoModifier(), 0F, 0.50F, 0F, 0, nameplateYaw, playerIn.rotationPitch, false, false);
	    		        }
	    		    	GlStateManager.popMatrix();
		    		}
        		}
        	}
        }
    }
    
    /** Fuel bar name plate logic. */
    private void renderFuelGauge(EntityMachineFlyingAirship entity, float nameplateYaw)
    {
    	// Render airship fuel bar:
    	GlStateManager.pushMatrix();
		{
			int percentFive = (int) (entity.getFuelTotal() * 0.05);
    		
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.rotate(180, 1, 0, 0);
			
			if(entity.getFuel() == 0)
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "          "+ "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 19))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA+ "||||||||||||||||||||" + "||||||||||||||||||||" + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 18))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA+ "||||||||||||||||||||" + "|||||||||||||||||| " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 17))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA+ "||||||||||||||||||||" + "||||||||||||||||  " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 16))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA+ "||||||||||||||||||||" + "||||||||||||||   " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 15))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN+ "||||||||||||||||||||" + "||||||||||||    " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 14))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN+ "||||||||||||||||||||" + "||||||||||     " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 13))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN+ "||||||||||||||||||||" + "||||||||      " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 12))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN+ "||||||||||||||||||||" + "||||||       " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 11))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW+ "||||||||||||||||||||" + "||||        " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 10))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW+ "||||||||||||||||||||" + "||         " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 9))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW + "||||||||||||||||||||" + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 8))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW + "|||||||||||||||||| " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 7))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||||||||||  " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 6))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||||||||   " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 5))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||||||    " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 4))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||||     " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 3))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||||||||      " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 2))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||||||       " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 1))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||||        " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 0) + 1)
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||         " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
		}
		GlStateManager.popMatrix();
    }
    
    
    
    
    
    
    
    
    
    
    
    private void airshipPropellers(EntityMachineFlyingAirship entity)
    {
    	//Default
        if(entity.getType() == 0)
        {
        	GlStateManager.pushMatrix();
        	
            GlStateManager.popMatrix();
        }
        //Viesdenburg
        if(entity.getType() == 1)
        {
        	//Left
        	GlStateManager.pushMatrix();
        	
        	GlStateManager.translate(0.968F, -0.08F, 0F);
        	
        	if(entity.isFuelBurning())
        	{
	        	//Spins Item
		        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
        	}
        	
            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	
        	GlStateManager.popMatrix();
            
            //Right
            GlStateManager.pushMatrix();
            
            GlStateManager.translate(-0.968F, -0.08F, 0F);
        	
        	if(entity.isFuelBurning())
        	{
	        	//Spins Item
		        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
        	}
        	
            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            
        	GlStateManager.popMatrix();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /** Returns the correct Primary Frame to render based on getVisualModelFrame(). */
    protected ModelBase getCurrentModelAirshipFramePrimary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelFrame())
    	{
	    	case 0:
	    		return this.currentModelFramePrimary = this.modelAirshipFrame0Primary;
	    	case 1:
	    		return this.currentModelFramePrimary = this.modelAirshipFrame1Primary;
	    	case 2:
	    		return this.currentModelFramePrimary = this.modelAirshipFrame2Primary;
	    	default:
	    		return this.currentModelFramePrimary = this.modelAirshipFrame0Primary;
    	}
    }
    /** Returns the correct Secondary Frame to render based on getVisualModelFrame(). */
    protected ModelBase getCurrentModelAirshipFrameSecondary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelFrame())
    	{
	    	case 0:
	    		return this.currentModelFrameSecondary = this.modelAirshipFrame0Secondary;
	    	case 1:
	    		return this.currentModelFrameSecondary = this.modelAirshipFrame1Secondary;
	    	case 2:
	    		return this.currentModelFrameSecondary = this.modelAirshipFrame2Secondary;
	    	default:
	    		return this.currentModelFrameSecondary = this.modelAirshipFrame0Secondary;
    	}
    }
    
    /** Returns the correct Primary Engine to render based on getVisualModelEngine(). */
    protected ModelBase getCurrentModelAirshipEnginePrimary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelEngine())
    	{
	    	case 0:
	    		return this.currentModelEnginePrimary = this.modelAirshipEngine0Primary;
	    	case 1:
	    		return this.currentModelEnginePrimary = this.modelAirshipEngine1Primary;
	    	case 2:
	    		return this.currentModelEnginePrimary = this.modelAirshipEngine2Primary;
	    	default:
	    		return this.currentModelEnginePrimary = this.modelAirshipEngine0Primary;
    	}
    }
    /** Returns the correct Secondary Engine to render based on getVisualModelEngine(). */
    protected ModelBase getCurrentModelAirshipEngineSecondary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelEngine())
    	{
	    	case 0:
	    		return this.currentModelEngineSecondary = this.modelAirshipEngine0Secondary;
	    	case 1:
	    		return this.currentModelEngineSecondary = this.modelAirshipEngine1Secondary;
	    	case 2:
	    		return this.currentModelEngineSecondary = this.modelAirshipEngine2Secondary;
	    	default:
	    		return this.currentModelEngineSecondary = this.modelAirshipEngine0Secondary;
    	}
    }
    
    /** Returns the correct Primary Component to render based on getVisualModelComponent(). */
    protected ModelBase getCurrentModelAirshipComponentPrimary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelComponent())
    	{
	    	case 0:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent0Primary;
	    	case 1:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent1Primary;
	    	case 2:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent2Primary;
	    	default:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent0Primary;
    	}
    }
    /** Returns the correct Secondary Component to render based on getVisualModelComponent(). */
    protected ModelBase getCurrentModelAirshipComponentSecondary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelComponent())
    	{
	    	case 0:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent0Secondary;
	    	case 1:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent1Secondary;
	    	case 2:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent2Secondary;
	    	default:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent0Secondary;
    	}
    }
}
