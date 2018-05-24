package com.viesys.viesysairships.client.sound;

import com.viesys.viesysairships.api.EnumsVC;
import com.viesys.viesysairships.common.entity.airships.EntityAirshipBaseVC;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class JukeboxMovingSoundVC extends MovingSound {
	
	private final EntityAirshipBaseVC airship;
    private float distance = 0.0F;
    private SoundEvent sound;
    
    public JukeboxMovingSoundVC(EntityAirshipBaseVC airshipIn, SoundEvent soundIn)
    {
        super(soundIn, SoundCategory.RECORDS);
        this.airship = airshipIn;
        this.repeat = false;
        this.repeatDelay = 0;
        this.sound = soundIn;
    }
    
    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update()
    {
    	SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
    	
    	if (this.airship.isDead)
        {
        	this.donePlaying = true;
    		Minecraft.getMinecraft().gameSettings.setSoundLevel(SoundCategory.MUSIC, 1.0F);
        }
    	else if(this.airship.getModuleActiveSlot1() != EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
			 && this.airship.getModuleActiveSlot1() != EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
			 && this.airship.getModuleActiveSlot1() != EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
		{
    		this.donePlaying = true;
    		Minecraft.getMinecraft().gameSettings.setSoundLevel(SoundCategory.MUSIC, 1.0F);
		}
        else
        {
        	this.xPosF = (float)this.airship.posX;
            this.yPosF = (float)this.airship.posY;
            this.zPosF = (float)this.airship.posZ;
            float f = MathHelper.sqrt(this.airship.motionX * this.airship.motionX + this.airship.motionZ * this.airship.motionZ);
            
            if ((double)f >= 0.01D)
            {
                this.distance = MathHelper.clamp(this.distance + 0.0025F, 0.0F, 1.0F);
                this.volume = 0.5F + MathHelper.clamp(f, 0.0F, 0.5F) * 0.7F;
            }
            else
            {
                this.distance = 0.0F;
                this.volume = 0.5F;
            }
            
            if(Minecraft.getMinecraft().gameSettings.getSoundLevel(SoundCategory.MUSIC) != 0.0F)
            {
            	//LogHelper.info("Set to 0 - David.");
            	Minecraft.getMinecraft().gameSettings.setSoundLevel(SoundCategory.MUSIC, 0.0F);
            }
        }
    }
}
