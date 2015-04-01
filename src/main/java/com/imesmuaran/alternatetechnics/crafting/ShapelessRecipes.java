package com.imesmuaran.alternatetechnics.crafting;

import com.imesmuaran.alternatetechnics.blocks.BlockLoader;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ShapelessRecipes {

    public static void shapelessRecipes() {
    	
    	// ItemStacks
    	ItemStack milkBucket = new ItemStack(Items.milk_bucket, 1);
    	ItemStack cheese = new ItemStack(BlockLoader.cheeseBlock, 1);
    	
    	//Rezepte
    	GameRegistry.addShapelessRecipe(cheese, milkBucket);
    	
    }

}
