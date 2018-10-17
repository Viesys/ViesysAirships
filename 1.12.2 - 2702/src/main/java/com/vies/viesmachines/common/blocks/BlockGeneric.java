package com.vies.viesmachines.common.blocks;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGeneric extends Block {
	
	public BlockGeneric(String unlocalizedNameIn, Material materialIn, SoundType soundTypeIn) 
	{
		super(materialIn);
		BlockHelper.setBlockName(this, unlocalizedNameIn);
		
		this.setHardness(1.0F);
		this.setSoundType(soundTypeIn);
		this.useNeighborBrightness=true;
		
		this.setCreativeTab(ViesMachines.tabBlocks);
	}
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
    	return false;
    }
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
}
