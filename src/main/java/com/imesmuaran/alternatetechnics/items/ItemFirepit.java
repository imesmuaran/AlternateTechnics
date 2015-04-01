package com.imesmuaran.alternatetechnics.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.blocks.BlockLoader;

public class ItemFirepit extends Item {

    public ItemFirepit() {
        setCreativeTab(AlternateTechnics.tabAT);
        setUnlocalizedName("firepitItem");
        setMaxStackSize(1);
    }

    //** Good example for onItemUse **//
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
        	world.setBlock(x, y + 1, z, BlockLoader.firepitBlock);
            --stack.stackSize;
            return true;
        }else{
            return false;
        }
    }
}
