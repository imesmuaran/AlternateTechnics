package com.imesmuaran.alternatetechnics.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blockloader
{
    //** Block Init **//
    public static Block cheeseBlock;
    public static Block saladCrop;

    public static void Blocks()
    {
        cheeseBlock = new CheeseBlock(Material.ground);
        GameRegistry.registerBlock(cheeseBlock, "cheeseBlock");

        saladCrop = new SaladCrop(Material.plants);

    }
}
