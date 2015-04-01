package com.imesmuaran.alternatetechnics.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.imesmuaran.alternatetechnics.blocks.BlockLoader;
import com.imesmuaran.alternatetechnics.items.ItemLoader;

import cpw.mods.fml.common.registry.GameRegistry;

public class ShapedRecipes {

    public static void shapedRecipes() {
    		
    	//Itemstacks
    	
    	//Burger
    	ItemStack burger = new ItemStack(ItemLoader.burgerItem, 1);
    	ItemStack bread = new ItemStack(Items.bread, 1);
    	ItemStack cheese = new ItemStack(BlockLoader.cheeseBlock, 1);
    	ItemStack steak = new ItemStack(Items.cooked_beef, 1);
    	
    	//Firepit
    	ItemStack firepit = new ItemStack(ItemLoader.firepitItem, 1);
    	ItemStack stick = new ItemStack(Items.stick, 1);
    	ItemStack straw = new ItemStack(Items.wheat, 1);
    	ItemStack cobble = new ItemStack(Blocks.cobblestone, 1);
    	
    	//Rezepte
    	GameRegistry.addRecipe(burger, 
    			"bbb", "fkf", "bbb", 'b', bread, 'f',steak, 'k', cheese);
    	GameRegistry.addRecipe(firepit,
    			" s ", "sss", "cwc", 's', stick, 'c', cobble, 'w', straw);
    }

}
