package com.imesmuaran.alternatetechnics.items;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.entities.EntityDroid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDroid extends Item {

    public ItemDroid() {
        setCreativeTab(AlternateTechnics.tabAT);
        setUnlocalizedName("droidItem");
    }

    //** Good example for onItemUse **//
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityDroid(world, x + 0.5, y + 1.5, z + 0.5));
            --stack.stackSize;
            return true;
        }else{
            return false;
        }
    }
}
