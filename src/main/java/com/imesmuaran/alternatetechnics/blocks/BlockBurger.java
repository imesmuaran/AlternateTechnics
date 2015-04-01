package com.imesmuaran.alternatetechnics.blocks;

import java.util.Random;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.items.ItemLoader;
import com.imesmuaran.alternatetechnics.reference.Reference;
import com.imesmuaran.alternatetechnics.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCake;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;


public class BlockBurger extends BlockCake
{

    @SideOnly(Side.CLIENT)
    protected IIcon burgerIconTop;
    @SideOnly(Side.CLIENT)
    protected IIcon burgerIconInner;
    @SideOnly(Side.CLIENT)
    protected IIcon burgerIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon burgerIconBottom;

    public BlockBurger()
    {
        super();
        setBlockName("burger");
    }
    
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return ItemLoader.burgerItem;
    }

    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }
    
    @Override
    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return ItemLoader.burgerItem;
    }

    //** Burger Texturen **//

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.burgerIconTop : (side == 0 ? this.burgerIconBottom : (meta > 0 && side == 4 ? this.burgerIconInner : this.burgerIcon));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        burgerIconTop = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5) + "_top");
        burgerIconInner = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5) + "_inner");
        burgerIconBottom = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5) + "_bottom");
        burgerIcon = p_149651_1_.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5) + "_side");
    }

    //** Burger Food Stats **//

    @SideOnly(Side.CLIENT)
    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        this.fuelEat(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_);
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
        this.fuelEat(world, x, y, z, player);
    }

    @SideOnly(Side.CLIENT)
    private void fuelEat(World p_150036_1_, int p_150036_2_, int p_150036_3_, int p_150036_4_, EntityPlayer player)
    {
        if (player.canEat(false))
        {
            LogHelper.info("Methode für Burger ausgeführt!");
            player.getFoodStats().addStats(12, 0.5F);
            int l = p_150036_1_.getBlockMetadata(p_150036_2_, p_150036_3_, p_150036_4_) + 1;

            if (l >= 6)
            {
                p_150036_1_.setBlockToAir(p_150036_2_, p_150036_3_, p_150036_4_);
            }
            else
            {
                p_150036_1_.setBlockMetadataWithNotify(p_150036_2_, p_150036_3_, p_150036_4_, l, 2);
            }
        }
    }
}
