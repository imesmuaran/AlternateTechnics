package com.imesmuaran.alternatetechnics.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CheeseBlock extends Block
{
    public CheeseBlock (Material material)
    {
        super(material);
        setHardness(0.5F);
        setStepSound(Block.soundTypeGravel);
        setBlockName("cheeseBlock");
        setCreativeTab(CreativeTabs.tabBlock);
        setHarvestLevel("pickaxe",0);
    }
}
