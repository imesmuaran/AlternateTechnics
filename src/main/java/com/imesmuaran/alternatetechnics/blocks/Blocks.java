package com.imesmuaran.alternatetechnics.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Blocks
{
    //** Block Init **//
    public static Block cheeseBlock;

    public static void Blocks()
    {
        cheeseBlock = new CheeseBlock(Material.ground);
        GameRegistry.registerBlock(cheeseBlock, "cheeseBlock");
    }
}
