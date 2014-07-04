package com.imesmuaran.alternatetechnics.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemLoader
{
    //** Item Init **//
    public static Item burgerItem;

    public static void Items()
    {
        burgerItem = new ItemBurger();
        GameRegistry.registerItem(burgerItem, "burgerItem");

    }
}
