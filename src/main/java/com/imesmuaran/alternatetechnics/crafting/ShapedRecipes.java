package com.imesmuaran.alternatetechnics.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.imesmuaran.alternatetechnics.blocks.BlockLoader;
import com.imesmuaran.alternatetechnics.items.ItemLoader;

import cpw.mods.fml.common.registry.GameRegistry;

public class ShapedRecipes {

    public static void shapedRecipes() {
    		
    	/** Itemstacks **/
    	
    	//Burger
    	ItemStack burger 	= new ItemStack(ItemLoader.burgerItem, 1);
    	ItemStack bread 	= new ItemStack(Items.bread, 1);
    	ItemStack cheese 	= new ItemStack(BlockLoader.cheeseBlock, 1);
    	ItemStack steak 	= new ItemStack(Items.cooked_beef, 1);
    	
    	//Firepit
    	ItemStack firepit 	= new ItemStack(ItemLoader.firepitItem, 1);
    	ItemStack stick 	= new ItemStack(Items.stick, 1);
    		// Zunder
    	ItemStack straw = new ItemStack(Items.wheat, 1);
    	ItemStack paper = new ItemStack(Items.paper, 1);
    	ItemStack coal = new ItemStack(Items.coal, 1);
    	ItemStack charcoal = new ItemStack(Items.coal, 1, 1);
    	
    	ItemStack cobble = new ItemStack(Blocks.cobblestone, 1);
    	
    	/** Rezepte **/
    	// Burger
    	GameRegistry.addRecipe(burger, 
    			"bbb", "fkf", "bbb", 'b', bread, 'f',steak, 'k', cheese);
    	// Firepit
    	GameRegistry.addRecipe(firepit,
    			" s ", "sss", "cwc", 's', stick, 'c', cobble, 'w', straw);
    	GameRegistry.addRecipe(firepit,
    			" s ", "sss", "cwc", 's', stick, 'c', cobble, 'w', paper);
    	GameRegistry.addRecipe(firepit,
    			" s ", "sss", "cwc", 's', stick, 'c', cobble, 'w', coal);
    	GameRegistry.addRecipe(firepit,
    			" s ", "sss", "cwc", 's', stick, 'c', cobble, 'w', charcoal);
    	GameRegistry.addRecipe(new ShapedOreRecipe(firepit, 
    			new Object[]{" s ", "sss", "cwc", 's', stick, 'c', cobble, 'w', "treeWood"}));
    	GameRegistry.addRecipe(new ShapedOreRecipe(firepit, 
    			new Object[]{" s ", "sss", "cwc", 's', stick, 'c', cobble, 'w', "plankWood"}));
    }

}
