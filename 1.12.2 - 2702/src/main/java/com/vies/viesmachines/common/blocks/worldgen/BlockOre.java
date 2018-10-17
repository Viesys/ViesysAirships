package com.vies.viesmachines.common.blocks.worldgen;

import java.util.Random;

import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOre extends Block {
	
	public BlockOre(int harvestlevel, float hardness) 
	{
		super(Material.ROCK);
		BlockHelper.setBlockName(this, "ore/test_ore");
		
		this.setHarvestLevel("pickaxe", harvestlevel); //("pickaxe", 2) is iron
		this.setHardness(hardness);
		this.setResistance(5f);
		this.setSoundType(SoundType.STONE);
	}

	//@Override
	//public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) 
	//{
	//	Random rand = new Random();
	//	int d = rand.nextInt(100) + 1;
		
	//	ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		//drops.add(new ItemStack(InitItemsEA.arcanite));
	//	if (d < 10)
		//	drops.add(new ItemStack(InitItemsEA.ebonheart));
	//	return drops;
	//}
    
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }
            return this.quantityDropped(random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) 
    {
		return true;
    }
}
