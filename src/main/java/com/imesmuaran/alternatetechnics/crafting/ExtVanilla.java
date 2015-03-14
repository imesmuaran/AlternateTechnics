package com.imesmuaran.alternatetechnics.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ExtVanilla
{
    public static void recipes()
    {
        ItemStack gravelStack = new ItemStack(Blocks.gravel);
       //ItemStack blackWoolStack = new ItemStack(Blocks.wool, 42, 15);

        ItemStack flintStack = new ItemStack(Items.flint, 1);
        ItemStack diamondStack = new ItemStack(Items.diamond);

        GameRegistry.addShapelessRecipe(flintStack, gravelStack);
        GameRegistry.addRecipe(new ItemStack(Items.ender_pearl, 4),
                "yyy","y y","yyy", 'y',diamondStack);

    }
}
