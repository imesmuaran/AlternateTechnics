package com.imesmuaran.alternatetechnics.items;

import java.util.List;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.blocks.BlockBurger;
import com.imesmuaran.alternatetechnics.blocks.BlockLoader;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;


public class ItemBurger extends Item
{
	public IIcon[] icons = new IIcon[6];
	
    public ItemBurger()
    {
        setCreativeTab(AlternateTechnics.tabAT);
        setUnlocalizedName("burgerItem");
        setMaxDamage(6);
        setMaxStackSize(1);
        setHasSubtypes(true);
    }  
    
    @Override
    public void registerIcons(IIconRegister reg) {
    	for (int i = 0; i < 6; i++) {
    		this.icons[i] = reg.registerIcon("alternatetechnics:burger" + i);
    	}
    }
    
    @Override
    public IIcon getIconFromDamage(int meta) {
    	if (meta > 5)
    		meta = 0;
    	return this.icons[meta];
    }
    
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < 6; i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
    @Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        return false;
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
