package com.imesmuaran.alternatetechnics.items;

import com.imesmuaran.alternatetechnics.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemLoader
{
    //** Item Init **//
    public static Item burgerItem;
    public static Item droidItem;
    public static Item firepitItem;

    public static void Items()
    {
        burgerItem = new ItemBurger();
        GameRegistry.registerItem(burgerItem, "burgerItem");
        droidItem = new ItemDroid();
        GameRegistry.registerItem(droidItem, "droidItem");
        firepitItem =new ItemFirepit();
        GameRegistry.registerItem(firepitItem, "firepitItem");
        
        
        LogHelper.info("Items loaded!");

    }
}
