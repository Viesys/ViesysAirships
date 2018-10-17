package com.vies.viesmachines.common.blocks.slab;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockDoubleSlabVM extends BlockSlabVM {
	
	public BlockDoubleSlabVM(String unlocalnameIn, Material materialIn, SoundType soundTypeIn) 
	{
		super(unlocalnameIn, unlocalnameIn, materialIn, soundTypeIn);
	}
	
	@Override
	public boolean isDouble() 
	{
		return true;
	}
}
