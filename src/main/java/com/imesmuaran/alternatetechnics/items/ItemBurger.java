package com.imesmuaran.alternatetechnics.items;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import net.minecraft.item.Item;



public class ItemBurger extends Item
{
    public ItemBurger()
    {
        //super(BlockLoader.burgerBlock);
        setMaxStackSize(1);
        setCreativeTab(AlternateTechnics.tabAT);
        setUnlocalizedName("burgerItem");
        setTextureName("alternatetechnics:burger0");
    }
}
