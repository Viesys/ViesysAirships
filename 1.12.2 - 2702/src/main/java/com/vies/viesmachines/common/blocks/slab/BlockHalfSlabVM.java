package com.vies.viesmachines.common.blocks.slab;

import com.vies.viesmachines.ViesMachines;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockHalfSlabVM extends BlockSlabVM {
	
	public BlockHalfSlabVM(String unlocalnameIn, Material materialIn, SoundType soundTypeIn) 
	{
		super(unlocalnameIn, unlocalnameIn, materialIn, soundTypeIn);
		
		this.setCreativeTab(ViesMachines.tabBlocks);
	}
	
	@Override
	public boolean isDouble() 
	{
		return false;
	}
}
