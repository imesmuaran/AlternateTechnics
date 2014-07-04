package com.imesmuaran.alternatetechnics.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLoader
{



    //** Block Init **//
    public static Block cheeseBlock;
    public static Block burgerBlock;
    public static Block verticalConveyor;

    public static void Blocks()
    {
        cheeseBlock = new CheeseBlock(Material.ground);
        GameRegistry.registerBlock(cheeseBlock, "cheeseBlock");
        burgerBlock = new BurgerBlock();
        GameRegistry.registerBlock(burgerBlock, "burger");
        verticalConveyor = new VerticalConveyor(Material.iron);
        GameRegistry.registerBlock(verticalConveyor, "verticalConveyor");
    }
}
