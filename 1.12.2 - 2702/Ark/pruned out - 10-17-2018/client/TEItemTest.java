package com.vies.viesmachines.client.tileentity;

import com.vies.viesmachines.client.tileentity.render.RenderExtractor;
import com.vies.viesmachines.common.tileentity.TileEntityExtractor;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;

public class TEItemTest extends TileEntityItemStackRenderer {
	
	private final TileEntityExtractor banner = new TileEntityExtractor();
    
    @Override
    public void renderByItem(ItemStack stack) {
        //EnumGraves graveType = EnumGraves.getById(stack.getItemDamage());
        //boolean isEnchanted = false;
        //boolean isMossy = false;
        //boolean isSwordGrave = false;
        //ItemStack sword = null;

        //if (stack.hasTagCompound()) {
        //    NBTTagCompound nbt = stack.getTagCompound();
        //    isEnchanted = nbt.hasKey("Enchanted") && nbt.getBoolean("Enchanted");
        //    isMossy = nbt.hasKey("Mossy") && nbt.getBoolean("Mossy");
        //    if (nbt.hasKey("Sword")) {
        //        isSwordGrave = true;
         //       sword = new ItemStack(nbt.getCompoundTag("Sword"));
         //   }
        //}
    	
    	
    	
    	TileEntityRendererDispatcher.instance.render(this.banner, 0.0D, 0.0D, 0.0D, 0.0F, 0.7F);
    	
    	
    	
    	//RenderExtractor.instance.
        //TileEntityGraveStoneRenderer.instance.renderGraveAsItem(graveType, isEnchanted, isMossy, isSwordGrave, sword);
    }
}