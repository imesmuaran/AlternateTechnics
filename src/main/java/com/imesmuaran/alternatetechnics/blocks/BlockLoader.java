package com.imesmuaran.alternatetechnics.blocks;

import com.imesmuaran.alternatetechnics.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLoader
{



    //** Block Init **//
    public static Block cheeseBlock;
    public static Block burgerBlock;
    public static Block verticalConveyor;
    public static Block waterwheelBase;
    public static Block bucketBlock;
    public static Block firepitBlock;

    public static void Blocks()
    {
        cheeseBlock = new BlockCheese(Material.ground);
        GameRegistry.registerBlock(cheeseBlock, "cheeseBlock");
        burgerBlock = new BlockBurger(0);
        GameRegistry.registerBlock(burgerBlock, "burger");
        verticalConveyor = new VerticalConveyor(Material.iron);
        GameRegistry.registerBlock(verticalConveyor, "verticalConveyor");
        waterwheelBase = new BlockWaterwheelBase(Material.iron);
        GameRegistry.registerBlock(waterwheelBase, "waterwheelBase");
        bucketBlock = new BlockBucket(Material.iron);
        GameRegistry.registerBlock(bucketBlock, "bucketBlock");
        firepitBlock = new BlockFirepit();
        GameRegistry.registerBlock(firepitBlock, "firepit");

        LogHelper.info("Blocks loaded!");
    }
}
