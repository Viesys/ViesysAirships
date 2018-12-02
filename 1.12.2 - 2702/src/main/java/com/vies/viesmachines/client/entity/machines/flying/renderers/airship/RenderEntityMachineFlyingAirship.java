package com.vies.viesmachines.client.entity.machines.flying.renderers.airship;

import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.LogHelper;
import com.vies.viesmachines.client.InitParticlesVCRender;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;
import com.vies.viesmachines.configs.VMConfiguration;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityMachineFlyingAirship extends RenderEntityMachineFlyingAirshipBase {
	
  	
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
        
    	// Initial setup:
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
        
        
        
        
        //==================================================
        
        // Create temporary colors:
        float frameRed; // = entity.getVisualFrameColorRed();
        float frameGreen; // = entity.getVisualFrameColorGreen();
        float frameBlue; // = entity.getVisualFrameColorBlue();
        
        
        //this.frameBlackColorFix(entity, frameRed, frameGreen, frameBlue);
        
        
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualFrameColorRed() <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = entity.getVisualFrameColorRed() / 255.0F;
        }
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualFrameColorBlue() <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = entity.getVisualFrameColorBlue() / 255.0F;
        }
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualFrameColorGreen() <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = entity.getVisualFrameColorGreen() / 255.0F;
        }
        
        
        //==================================================
        
        
        
        
        //this.frameTextureColorChecking(entity, frameRed, frameGreen, frameBlue);
        
        // Coloring check:
        if(entity.getVisualFrameColor())
        {
        	// Color logic applied:
        	GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        	
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
        }
        else
        {
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
        }
        
        
     
        //==================================================
        
        // Render the Frame ONLY:
        if (entity.getPreviewPart() == 1)
        {
        	
        	//this.resetColorTransparency();
        	
        	  // Reset the colors:
        	GlStateManager.color(1F, 1F, 1F, 1F);
        	// Turn off transparency:
            GlStateManager.disableBlend();
            
        	this.renderEngineDisplaySymbol(entity, partialTicks);
            
            this.selectedModelControlPanel(entity, partialTicks);
            
            //this.frameTextureColorChecking(entity, frameRed, frameGreen, frameBlue);
            
            
         	// Coloring check:
            if(entity.getVisualFrameColor())
            {
            	// Color logic applied:
            	GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
            	
            	// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
            }
            else
            {
            	// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
            }
            
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
            if (entity.getVisualEngineDisplayType() > 0)
            {
            	this.modelAirshipFrameDisplayBannerStand.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
        	// Render the skids when a machine is on the ground:
            if (entity.status == entity.status.ON_LAND)
            {
            	this.modelAirshipSkids.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
        }
        // Render the Engine ONLY:
        else if (entity.getPreviewPart() == 2)
        {
        	this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the Component ONLY:
        else if (entity.getPreviewPart() == 3)
        {
        	this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
            this.airshipPropellersRegular(entity, frameRed, frameGreen, frameBlue);
        }
        // Regular rendering for machine (Primary):
        else
        {
        	//this.resetColorTransparency();
        	  // Reset the colors:
        	GlStateManager.color(1F, 1F, 1F, 1F);
        	// Reset the colorsTurn off transparency:
            GlStateManager.disableBlend();
            
        	
        	this.renderEngineDisplaySymbol(entity, partialTicks);
            
            this.selectedModelControlPanel(entity, partialTicks);
            
            //this.frameTextureColorChecking(entity, frameRed, frameGreen, frameBlue);
            
            
            // Transparency check:
            if(entity.getVisualFrameTransparent())
            {
            	GlStateManager.enableBlend();
            	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            }
            
            
         	// Coloring check:
            if(entity.getVisualFrameColor())
            {
            	// Color logic applied:
            	GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
            	
            	// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
            }
            else
            {
            	// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
            }
            
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.airshipPropellersRegular(entity, frameRed, frameGreen, frameBlue);
            
            if (entity.getVisualEngineDisplayType() > 0)
            {
            	this.modelAirshipFrameDisplayBannerStand.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
            // Render the skids when a machine is on the ground:
            if (entity.status == entity.status.ON_LAND)
            {
            	this.modelAirshipSkids.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
            
        }
        
        //==================================================
        
        //this.resetColorTransparency();
        
        // Reset the colors:
    	GlStateManager.color(1F, 1F, 1F, 1F);
    	// Turn off transparency:
        GlStateManager.disableBlend();
        
        
        
        //==================================================
        
        
        
        // Create temporary colors:
        float componentRed; // = entity.getVisualComponentColorRed();
        float componentGreen; // = entity.getVisualComponentColorGreen();
        float componentBlue; // = entity.getVisualComponentColorBlue();
        
        //this.componentBlackColorFix(entity, componentRed, componentGreen, componentBlue);
        
        
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualComponentColorRed() <= 30)
        {
        	componentRed = 30 / 255.0F;
        }
        else
        {
        	componentRed = entity.getVisualComponentColorRed() / 255.0F;
        }
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualComponentColorBlue() <= 30)
        {
        	componentBlue = 30 / 255.0F;
        }
        else
        {
        	componentBlue = entity.getVisualComponentColorBlue() / 255.0F;
        }
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualComponentColorGreen() <= 30)
        {
        	componentGreen = 30 / 255.0F;
        }
        else
        {
        	componentGreen = entity.getVisualComponentColorGreen() / 255.0F;
        }
        
        //==================================================
        
        // Transparency check:
        //if(entity.getVisualComponentTransparent())
        //{
        //	GlStateManager.enableBlend();
        //	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        //}
        
        
        
        // Coloring check:
        if(entity.getVisualComponentColor())
        {
        	// Color logic applied:
        	GlStateManager.color(componentRed, componentGreen, componentBlue, 1F);
        	
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/grayscale_bg_" + EnumsVM.VisualSecondaryTexture.byId(entity.getVisualComponentTexture()).getRegistryName() + ".png"));
        }
        else
        {
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/bg_" + EnumsVM.VisualSecondaryTexture.byId(entity.getVisualComponentTexture()).getRegistryName() + ".png"));
        }
        
        //==================================================
        
        // Render the Secondary Frame ONLY:
        if (entity.getPreviewPart() == 1)
        {
        	this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the Secondary Engine ONLY:
        else if (entity.getPreviewPart() == 2)
        {
        	this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the Secondary Component ONLY:
        else if (entity.getPreviewPart() == 3)
        {
        	this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
            //this.airshipPropellersMultipass(entity);
        }
        // Regular rendering for machine (Secondary):
        else
        {
            // Transparency check:
            if(entity.getVisualComponentTransparent())
            {
            	GlStateManager.enableBlend();
            	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            }
            
        	this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            //this.airshipPropellersMultipass(entity);
        }
        
        //==================================================
        
        //this.resetColorTransparency();
        
        // Reset the colors:
    	GlStateManager.color(1F, 1F, 1F, 1F);
    	// Turn off transparency:
        GlStateManager.disableBlend();
        
        
        
        
        
        
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
        			(this.baseitemSpin + 0.1F) 
        			 ;
        			
        			//+ 
        			//(Minecraft.getMinecraft().player.rotationYawHead  % 360);
        	
        	//Minecraft.getMinecraft().player.rotationYawHead = test;
        }
        
        
        
        
        //float bombspin = (((float)entity.getEntityWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
        //GlStateManager.rotate((bombspin), 0F, 1F, 0F);		
    	
        
        
        
        
        int randomTick = References.random.nextInt(100) + 1;
		
        // Renders engine smoke when a machine is on:
        if (entity.isFuelBurning())
        {
        	if (entity.getVisualModelEngine() == 0)
        	{
        		if (randomTick < 20)
        		{
        			if (!Minecraft.getMinecraft().isGamePaused())
        			{
        				InitParticlesVCRender.generateAirshipSmokeParticles0(entity, 0, -0.15, 0);
        			}
        		}
        	}
        	if (entity.getVisualModelEngine() == 1)
        	{
        		if (randomTick < 20)
        		{
        			if (!Minecraft.getMinecraft().isGamePaused())
        			{
        				InitParticlesVCRender.generateAirshipSmokeParticles1(entity, 0, -0.05, 0);
        			}
        		}
        	}
        	if (entity.getVisualModelEngine() == 2)
        	{
        		if (randomTick < 20)
        		{
        			if (!Minecraft.getMinecraft().isGamePaused())
        			{
        				InitParticlesVCRender.generateAirshipSmokeParticles2(entity, 0, 0, 0);
        			}
        		}
        	}
        }
		
        
		
        
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
        
        // Sets all models correctly depending on machine values:
        this.getCurrentModelAirshipFramePrimary(entity);
        this.getCurrentModelAirshipFrameSecondary(entity);
        this.getCurrentModelAirshipEnginePrimary(entity);
        this.getCurrentModelAirshipEngineSecondary(entity);
        this.getCurrentModelAirshipComponentPrimary(entity);
        this.getCurrentModelAirshipComponentSecondary(entity);
        
        
        
        if (entity.getPreviewPart() == 1)
        {
        	//Draws the Main Control Panel Screen
            if (entity.getPoweredOn())
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel_on.png"));
            }
            else
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel_off.png"));
            }
        	
        	this.modelMachineControlPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        	
        	// Render the Frame (Primary/Secondary):
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_frame_primary.png"));
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
            if (entity.getVisualEngineDisplayType() > 0)
            {
            	this.modelAirshipFrameDisplayBannerStand.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
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
        	this.airshipPropellersMultipass(entity);
        }
        else
        {
        	//Draws the Main Control Panel Screen
            if (entity.getPoweredOn())
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel_on.png"));
            }
            else
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel_off.png"));
            }
        	
        	this.modelMachineControlPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        	
        	// Render the Frame (Primary/Secondary):
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_frame_primary.png"));
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
            if (entity.getVisualEngineDisplayType() > 0)
            {
            	this.modelAirshipFrameDisplayBannerStand.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
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
        	this.airshipPropellersMultipass(entity);
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
    
    
    
    
    
    
    
    
    
    
    

    
	/**
	
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
    
    /** Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture. *
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
    
    /** Disables the overhead generic Minecraft name logic. *
    @Override
    protected boolean canRenderName(EntityMachineFlyingAirship entity)
    {
        return false;//super.canRenderName(entity) && (entity.getAlwaysRenderNameTagForRender() || entity.hasCustomName() && entity == this.renderManager.pointedEntity);
    }
    
    
	
	*/
    

    
    protected void airshipPropellersRegular(EntityMachineFlyingAirship entity, float frameRed, float frameGreen, float frameBlue)
    {
    	// Render the Frame / Engine / Component (Primary):
        //this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
    	// Coloring check:
        if(entity.getVisualFrameColor())
        {
        	// Color logic applied:
        	GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        	
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
        }
        else
        {
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
        }
        if (entity.getVisualModelComponent() == 0)
        {
        	//Left
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(0.910F, -0.0675F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            //Right
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-0.910F, -0.0675F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	//Spins Item
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
        
        if (entity.getVisualModelComponent() == 1)
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
        
        if (entity.getVisualModelComponent() == 2)
        {
        	//Left
        	GlStateManager.pushMatrix();
        	
        	GlStateManager.translate(1.125F, -0.131F, 0.2425F);
        	
        	if(entity.isFuelBurning())
        	{
	        	//Spins Item
		        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
        	}
        	
            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	
        	GlStateManager.popMatrix();
            
            //Right
            GlStateManager.pushMatrix();
            
            GlStateManager.translate(-1.125F, -0.131F, 0.2425F);
        	
        	if(entity.isFuelBurning())
        	{
	        	//Spins Item
		        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
        	}
        	
            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            
        	GlStateManager.popMatrix();
        }
    }
    
    protected void airshipPropellersMultipass(EntityMachineFlyingAirship entity)
    {
    	// Render the Frame / Engine / Component (Primary):
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_airship_propeller.png"));
        
        if (entity.getVisualModelComponent() == 0)
        {
        	//Left
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(0.910F, -0.0675F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            //Right
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-0.910F, -0.0675F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	//Spins Item
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
        
        if (entity.getVisualModelComponent() == 1)
        {
        	//Left
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(0.968F, -0.08F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            //Right
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-0.968F, -0.08F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	//Spins Item
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
        
        if (entity.getVisualModelComponent() == 2)
        {
        	//Left
        	GlStateManager.pushMatrix();
        	
        	GlStateManager.translate(1.125F, -0.131F, 0.2425F);
        	
        	if(entity.isFuelBurning())
        	{
	        	//Spins Item
		        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
        	}
        	
            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	
        	GlStateManager.popMatrix();
            
            //Right
            GlStateManager.pushMatrix();
            
            GlStateManager.translate(-1.125F, -0.131F, 0.2425F);
        	
        	if(entity.isFuelBurning())
        	{
	        	//Spins Item
		        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
        	}
        	
            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            
        	GlStateManager.popMatrix();
        }
    }
    
    /** Checks to see if frame coloring should be applied and binds the correct texture. */
    private void frameTextureColorChecking(EntityMachineFlyingAirship entity, float frameRed, float frameGreen, float frameBlue)
    {
    	// Coloring check:
        if(entity.getVisualFrameColor())
        {
        	// Color logic applied:
        	GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        	
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
        }
        else
        {
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVM.VisualPrimaryTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
        }
    }
    
    /** Checks to see if component coloring should be applied and binds the correct texture. */
    private void componentTextureColorChecking(EntityMachineFlyingAirship entity, float componentRed, float componentGreen, float componentBlue)
    {
    	// Coloring check:
        if(entity.getVisualComponentColor())
        {
        	// Color logic applied:
        	GlStateManager.color(componentRed, componentGreen, componentBlue, 1F);
        	
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/grayscale_bg_" + EnumsVM.VisualSecondaryTexture.byId(entity.getVisualComponentTexture()).getRegistryName() + ".png"));
        }
        else
        {
        	// Texture to bind:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/components/bg_" + EnumsVM.VisualSecondaryTexture.byId(entity.getVisualComponentTexture()).getRegistryName() + ".png"));
        }
    }
    
    /** Resets the colors and turns off transparency. */
    private void resetColorTransparency()
    {
    	// Reset the colors:
    	GlStateManager.color(1F, 1F, 1F, 1F);
    	// Turn off transparency:
        GlStateManager.disableBlend();
    }
}