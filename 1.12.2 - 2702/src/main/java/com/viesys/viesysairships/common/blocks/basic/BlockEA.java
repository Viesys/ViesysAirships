package com.viesys.viesysairships.common.blocks.basic;

import com.viesys.viesysairships.common.blocks.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockEA extends Block {
	
	public BlockEA(String unlocalizedName) 
	{
		super(Material.CLOTH);
		BlockHelper.setBlockName(this, unlocalizedName);
		
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
		this.useNeighborBrightness=true;
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
