package com.imesmuaran.alternatetechnics.items;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.blocks.BlockBurger;
import com.imesmuaran.alternatetechnics.blocks.BlockLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ItemBurger extends Item
{
    public ItemBurger()
    {
        setMaxStackSize(1);
        setCreativeTab(AlternateTechnics.tabAT);
        setUnlocalizedName("burgerItem");
        setTextureName("alternatetechnics:burger0");
    }


    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
        if (par7 != 1) {
            return false;
        } else {
            if (player.canPlayerEdit(x,y,z,par7,stack)) {
                world.setBlock(x,y+1,z, BlockLoader.burgerBlock);
                --stack.stackSize;
                return true;
            } else {
                return false;
            }
        }
    }
}
