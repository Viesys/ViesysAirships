package com.vies.viesmachines.client.tileentity.render;

import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.InitParticlesVCRender;
import com.vies.viesmachines.client.tileentity.model.ModelExtractor;
import com.vies.viesmachines.client.tileentity.model.ModelExtractorPowered;
import com.vies.viesmachines.common.tileentity.TileEntityExtractor;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class RenderExtractor extends TileEntitySpecialRenderer<TileEntityExtractor> {
	
	private final ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/blocks/appliances/model_extractor.png");
	private final ResourceLocation texture_on = new ResourceLocation(References.MOD_ID + ":" + "textures/blocks/appliances/model_extractor_on.png");
	private final ResourceLocation texture_off = new ResourceLocation(References.MOD_ID + ":" + "textures/blocks/appliances/model_extractor_off.png");
	private ModelExtractor model;
	private ModelExtractorPowered modelpowered;
	
	public RenderExtractor() 
	{
		this.model = new ModelExtractor();
		this.modelpowered = new ModelExtractorPowered();
	}
	
	@Override
	public void render(TileEntityExtractor te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		// Push the matrix - Renders items to find and process:
		GL11.glPushMatrix();
		
		// Handles positioning and rotation of items:
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.05F, (float)z + 0.5F);
		GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
		
		this.renderItemToFind(te, x, y, z, partialTicks, destroyStage);
		this.renderItemToProcess(te, x, y, z, partialTicks, destroyStage);
		
		// Pop the matrix:
		GL11.glPopMatrix();
		
		//--------------------------------------------------
		
		// Push the matrix - Renders the Extractor:
		GL11.glPushMatrix();
		
		// Needed to fix the texture overlap clipping:
    	GL11.glEnable(GL11.GL_CULL_FACE);
        
    	// Turn semi-transparent texture use on:
    	GlStateManager.enableBlend();
    	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    	
    	// Handles positioning and rotation of the Extractor:
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180F, 0F, 0F, 1F);
		
		// Player facing North on placement, Extractor facing South:
		if (te.getBlockMetadata() == 2)
		{
			GL11.glRotatef(0F, 0F, 1F, 0F);
		}
		// Player facing West on placement, Extractor facing East:
		if (te.getBlockMetadata() == 5)
		{
			GL11.glRotatef(90F, 0F, 1F, 0F);
		}
		// Player facing South on placement, Extractor facing North:
		if (te.getBlockMetadata() == 3)
		{
			GL11.glRotatef(180F, 0F, 1F, 0F);
		}
		// Player facing East on placement, Extractor facing West:
		if (te.getBlockMetadata() == 4)
		{
			GL11.glRotatef(270F, 0F, 1F, 0F);
		}
		
		//GlStateManager.color(0, 0, 0, 0);
		// Binds the texture to use:
		//this.bindTexture(texture);
		// Render the model:
		//this.model.render(te, 0, 0, 0, 0, 0, 0.0625F);
		
		if (te.isOn)
		{
			// Binds the texture to use:
			//this.bindTexture(texture_on);
		}
		else
		{
			// Binds the texture to use:
			//this.bindTexture(texture_off);
		}
		// Render the model:
		//this.modelpowered.render(te, 0, 0, 0, 0, 0, 0.0625F);
		
		// Turn semi-transparent texture use bck off:
    	GlStateManager.disableBlend();
        
        // Needed to remove the fix at the end.
    	GL11.glDisable(GL11.GL_CULL_FACE);
    	// Pop the matrix:
		GL11.glPopMatrix();
		
		//--------------------------------------------------
		
		// Generates particles when the extractor is on and processing blocks/items:
		if(!te.inventory.getStackInSlot(0).isEmpty()
		&& te.isOn
		&& !Minecraft.getMinecraft().isGamePaused()
		&& te.processTime >= 1)
		{
			int d = References.random.nextInt(100) + 1;
			
			if (d <= 50)
			{
				InitParticlesVCRender.generateParticlesExtractor(te);
			}
		}
		
		//--------------------------------------------------
		
		EntityPlayerSP playerIn = Minecraft.getMinecraft().player;
    	
		// Renders name plates:
		if (playerIn.isSneaking())
		{
			if (te.getName() != null 
			&& this.rendererDispatcher.cameraHitResult != null 
			&& te.getPos().equals(this.rendererDispatcher.cameraHitResult.getBlockPos()))
	        {

				int rotationByPos = 0;
				float newX = 0;
				float newZ = 0;
				
				// Player facing North on placement, Extractor facing South:
				if (te.getBlockMetadata() == 2)
				{
					rotationByPos = 0;
					newX = (float)x + 0.5F;
					newZ = (float)z;
				}
				// Player facing West on placement, Extractor facing East:
				if (te.getBlockMetadata() == 5)
				{
					rotationByPos = 90;
					newX = (float)x + 1.0F;
					newZ = (float)z + 0.5F;
				}
				// Player facing South on placement, Extractor facing North:
				if (te.getBlockMetadata() == 3)
				{
					rotationByPos = 180;
					newX = (float)x + 0.5F;
					newZ = (float)z + 1.0F;
				}
				// Player facing East on placement, Extractor facing West:
				if (te.getBlockMetadata() == 4)
				{
					rotationByPos = 270;
					newX = (float)x;
					newZ = (float)z + 0.5F;
				}
				
				//Disables using light levels, makes text easier to read:
				this.setLightmapDisabled(true);
				
				if(te.isOn)
				{
					if(te.inventory.getStackInSlot(1).getCount() > 63)
		        	{
		        		
		        	}
					else
					{
		            	if(te.processTime >= 180)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.AQUA + " |||||||||||||||||||| ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 160)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.AQUA + " ||||||||||||||||||  ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 140)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.GREEN + " ||||||||||||||||   ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 120)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.GREEN + " ||||||||||||||    ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 100)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.YELLOW + " ||||||||||||     ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 80)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.YELLOW + " ||||||||||      ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 60)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.GOLD + " ||||||||       ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 40)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.GOLD + " ||||||        ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 20)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.DARK_RED + " ||||         ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
		            	else if(te.processTime >= 1)
		            	{
		            		EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.DARK_RED + " ||          ", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
		            	}
			            
		            	EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.WHITE + "[          ]", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
					}
				}
				
				if(te.inventory.getStackInSlot(1).getCount() > 63)
	        	{
					EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.LIGHT_PURPLE + "< " + "Full" + " >", newX, (float)y + 1.0F, newZ, 0, rotationByPos, 0, false, false);
	        	}
				
				
				if (te.isOn)
				{
					EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.LIGHT_PURPLE + "On", newX, (float)y + 0.75F, newZ, 0, rotationByPos, 0, false, false);
				}
				else
				{
					EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.LIGHT_PURPLE + "Off", newX, (float)y + 0.75F, newZ, 0, rotationByPos, 0, false, false);
				}
				
				
				//EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.LIGHT_PURPLE + "< " + "====" + " >", newX, (float)y + 0.50F, newZ, 0, 0, 0, false, false);
				//EntityRenderer.drawNameplate(getFontRenderer(), TextFormatting.LIGHT_PURPLE + "< " + "====" + " >", newX, (float)y + 0.25F, newZ - 0.01F, 0, 0, 0, false, false);
				
				
				
				
				
				//Enables using light levels:
				this.setLightmapDisabled(false);
	        }
		}
		/**
		if (te.getName() != null 
				&& this.rendererDispatcher.cameraHitResult != null 
				&& te.getPos().equals(this.rendererDispatcher.cameraHitResult.getBlockPos()))
		        {
					if(te.isOn)
					{
						this.setLightmapDisabled(true);
						
						
						if(te.inventory.getStackInSlot(1).getCount() > 63)
		            	{
		            		this.drawNameplate(te, TextFormatting.LIGHT_PURPLE + "Full", x, y + 0.5D, z, 16);
		            	}
						else
						{
			            	if(te.processTime >= 180)
			            	{
			            		this.drawNameplate(te, TextFormatting.AQUA + " |||||||||||||||||||| ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 160)
			            	{
			            		this.drawNameplate(te, TextFormatting.AQUA + " ||||||||||||||||||  ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 140)
			            	{
			            		this.drawNameplate(te, TextFormatting.GREEN + " ||||||||||||||||   ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 120)
			            	{
			            		this.drawNameplate(te, TextFormatting.GREEN + " ||||||||||||||    ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 100)
			            	{
			            		this.drawNameplate(te, TextFormatting.YELLOW + " ||||||||||||     ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 80)
			            	{
			            		this.drawNameplate(te, TextFormatting.YELLOW + " ||||||||||      ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 60)
			            	{
			            		this.drawNameplate(te, TextFormatting.GOLD + " ||||||||       ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 40)
			            	{
			            		this.drawNameplate(te, TextFormatting.GOLD + " ||||||        ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 20)
			            	{
			            		this.drawNameplate(te, TextFormatting.DARK_RED + " ||||         ", x, y + 0.5D, z, 16);
			            	}
			            	else if(te.processTime >= 1)
			            	{
			            		this.drawNameplate(te, TextFormatting.DARK_RED + " ||          ", x, y + 0.5D, z, 16);
			            	}
				            
				            this.drawNameplate(te, TextFormatting.WHITE + "[          ]", x, y + 0.5D, z, 16);
						}
						
				        //this.drawNameplate(te, TextFormatting.WHITE + "Gem: " + TextFormatting.YELLOW + 
				        		//GemstoneTypeItemV1.byMetadata(te.gemstoneMeta).getLocalizedName()
				        //		"nullllll"
				        //		, x, y + 0.25D, z, 16);
			            this.drawNameplate(te, TextFormatting.WHITE + "Power: " + TextFormatting.GREEN + "On", x, y, z, 16);
			            this.setLightmapDisabled(false);
					}
					else
					{
						if(te.inventory.getStackInSlot(1).getCount() > 63)
		            	{
		            		this.drawNameplate(te, TextFormatting.LIGHT_PURPLE + "Full", x, y + 0.5D, z, 16);
		            	}
						
						this.setLightmapDisabled(true);
			            //this.drawNameplate(te, TextFormatting.WHITE + "Gem: " + TextFormatting.YELLOW + 
			            		//GemstoneTypeItemV1.byMetadata(te.gemstoneMeta).getLocalizedName()
			            //		"nullllll"
			            //		, x, y + 0.25D, z, 16);
			            this.drawNameplate(te, TextFormatting.WHITE + "Power: " + TextFormatting.RED + "Off", x, y, z, 16);
			            this.setLightmapDisabled(false);
					}
		        }
		*/
	}
	
	public boolean isGlobalRenderer(TileEntityExtractor te) 
	{
        return true;
    }
	
	/** Renders the item the Extractor is looking for. */
	private void renderItemToFind(TileEntityExtractor te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack = new ItemStack(ItemsVM.XEGONITE);
        //InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, te.gemstoneMeta
        
        if(itemstack.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        //GlStateManager.translate(0.0F, -0.525F, -0.8145F);
        //GlStateManager.rotate(180F, 0F, 1F, 0F);
        
        
        if (te.getBlockMetadata() == 2)
		{
        	GlStateManager.translate(0.0F, -0.665F, -0.875F);
        	//GlStateManager.translate(0.0F, -0.525F, -0.8145F);
            GlStateManager.rotate(180F, 0F, 1F, 0F);
		}
		if (te.getBlockMetadata() == 5)
		{
			GlStateManager.translate(0.875F, -0.665F, 0.0F);
	        GlStateManager.rotate(90F, 0F, 1F, 0F);
		}
		if (te.getBlockMetadata() == 3)
		{
			GlStateManager.translate(0.0F, -0.665F, 0.875F);
            GlStateManager.rotate(0F, 0F, 1F, 0F);
		}
		if (te.getBlockMetadata() == 4)
		{
			GlStateManager.translate(-0.875F, -0.665F, 0.0F);
	        GlStateManager.rotate(270F, 0F, 1F, 0F);
		}
        
        
		
		//float angle = (((float)te.getWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
		//GlStateManager.rotate(angle + angle, 0F, 1F, 0F);
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	/** Renders the item the Extractor is deconstructing. */
	private void renderItemToProcess(TileEntityExtractor te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack = te.inventory.getStackInSlot(0);
        
        if(itemstack.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        
        if(itemstack.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack.getItem()) != Blocks.AIR)
        {
            Block block = Block.getBlockFromItem(itemstack.getItem());
            GL11.glTranslatef(0, - 0.925f, 0);
        }
        else
        {
        	GL11.glTranslatef(0, - 0.8f, 0);
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
        }
        
		float angle = (((float)te.getWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
		GlStateManager.rotate(angle, 0F, 1F, 0F);
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
}
