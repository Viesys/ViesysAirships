package com.vies.viesmachines.common.blocks.slab;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBlockSlabVM extends ItemSlab {
    /**
     * Initializes a new instance of the ItemBlockSlab class.
     * @param block the block behind the item.
     * @param slab the half height slab.
     * @param doubleSlab the full height slab.
     * @param stacked whether or not the block is the stacked version.
     */
    public ItemBlockSlabVM(final Block block, final BlockHalfSlabVM slab, final BlockDoubleSlabVM doubleSlab, final Boolean stacked) 
    {
        super(block, slab, doubleSlab);
    }
}
