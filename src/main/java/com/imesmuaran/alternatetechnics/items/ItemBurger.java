package com.imesmuaran.alternatetechnics.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBurger extends Item
{
    public ItemBurger()
    {
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabFood);
        setUnlocalizedName("burgerItem");
    }
}
