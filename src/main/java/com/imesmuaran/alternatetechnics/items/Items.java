package com.imesmuaran.alternatetechnics.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Items
{
    //** Item Init **//
    public static Item burgerItem;
    public static Item dropItem;

    public static void Items()
    {
        burgerItem = new ItemBurger();
        GameRegistry.registerItem(burgerItem, "burgerItem");
        dropItem = new ItemBurger().setMaxStackSize(1).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("dropItem");
        GameRegistry.registerItem(dropItem, "dropItem");
    }
}
