package com.viesys.viesysairships.client.entity.render;

import com.viesys.viesysairships.api.EnumsVC;
import com.viesys.viesysairships.api.References;
import com.viesys.viesysairships.client.InitParticlesVCRender;
import com.viesys.viesysairships.client.entity.model.frame.ModelFrame0;
import com.viesys.viesysairships.common.entity.EntityMachineBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAirshipTEST extends Render<EntityMachineBase> {
	
	protected ModelBase modelAirship = new ModelFrame0();
	
    public RenderAirshipTEST(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }

    @Override
    public void doRender(EntityMachineBase entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        //float bombspin = (((float)entity.getEntityWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
        //GlStateManager.rotate((bombspin), 0F, 1F, 0F);		
    	
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVC.VisualFrameSkinBackground.byId(1).getRegistryName() + ".png"));
        modelAirship.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        
        int randomTick = References.random.nextInt(100) + 1;
		
		if(randomTick < 20)
		{
			if(!Minecraft.getMinecraft().isGamePaused())
			{
				InitParticlesVCRender.generateBombFuseSmokeParticles(entity);
				InitParticlesVCRender.generateBombFuseFlameParticles(entity);
			}
		}
		
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    public void setupRotation(EntityMachineBase entity, float p_188311_2_, float p_188311_3_)
    {
    	GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
    }
    
    public void setupTranslation(double p_188309_1_, double p_188309_3_, double p_188309_5_)
    {
        GlStateManager.translate((float)p_188309_1_, (float)p_188309_3_ + 0.375F + 0.25F, (float)p_188309_5_);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityMachineBase entity)
    {
        return null;
    }
    
    
    protected TextFormatting getPrimaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel;
		
		switch(stack)
		{
			case 0:
				return stringColorLabel = TextFormatting.GRAY;
			case 1:
				return stringColorLabel = TextFormatting.WHITE;
			case 2:
				return stringColorLabel = TextFormatting.YELLOW;
			case 3:
				return stringColorLabel = TextFormatting.AQUA;
			case 4:
				return stringColorLabel = TextFormatting.LIGHT_PURPLE;
			case 5:
				return stringColorLabel = TextFormatting.RED;
			default:
				return stringColorLabel = TextFormatting.GRAY;
		}
	}
    
    protected FontRenderer getFontRenderer()
    {
        return Minecraft.getMinecraft().fontRenderer;
    }
}
