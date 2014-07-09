package com.imesmuaran.alternatetechnics.crafting;

import com.imesmuaran.alternatetechnics.utility.LogHelper;

public class RecipeLoader {

    public static void recipes() {
        ExtVanilla.recipes();
        ShapedRecipes.shapedRecipes();
        ShapelessRecipes.shapelessRecipes();

        LogHelper.info("Recipes loaded!");
    }

}
