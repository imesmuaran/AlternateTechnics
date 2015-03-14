package com.imesmuaran.alternatetechnics.blocks;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCheese extends Block
{
    public BlockCheese(Material material)
    {
        super(material);
        setHardness(0.5F);
        setStepSound(Block.soundTypeGravel);
        setBlockName("cheeseBlock");
        this.setCreativeTab(AlternateTechnics.tabAT);
        setHarvestLevel("pickaxe",0);
        setBlockTextureName("alternatetechnics:cheese");
    }
}
