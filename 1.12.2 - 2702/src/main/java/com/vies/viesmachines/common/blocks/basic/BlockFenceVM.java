package com.vies.viesmachines.common.blocks.basic;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockFenceVM extends BlockFence {
	
	public BlockFenceVM(String unlocalizedNameIn, Material materialIn, SoundType soundTypeIn) 
	{
		super(materialIn, null);
		BlockHelper.setBlockName(this, unlocalizedNameIn);
		
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setSoundType(soundTypeIn);
		this.useNeighborBrightness=true;
		this.setCreativeTab(ViesMachines.tabBlocks);
	}
}
