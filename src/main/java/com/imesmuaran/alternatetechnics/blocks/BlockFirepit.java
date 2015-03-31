package com.imesmuaran.alternatetechnics.blocks;

import java.util.Random;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.tileentities.TEFirepit;
import com.imesmuaran.alternatetechnics.items.ItemLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;



public class BlockFirepit extends BlockContainer implements ITileEntityProvider{
	
	public BlockFirepit() {
		super(Material.wood);
		setBlockName("firepit");
		
		setLightLevel(1.0F);
		setLightOpacity(0);
	}
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return ItemLoader.firepitItem;
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TEFirepit();
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	// It is not opaque
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	//It is not rendered normally
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	//Smoke & Fire
	/**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
    	//Sound
    	if (p_149734_5_.nextInt(24) == 0)
        {
            p_149734_1_.playSound((double)((float)p_149734_2_ + 0.5F), (double)((float)p_149734_3_ + 0.5F), (double)((float)p_149734_4_ + 0.5F), "fire.fire", 1.0F + p_149734_5_.nextFloat(), p_149734_5_.nextFloat() * 0.7F + 0.3F, false);
        }
    	
    	//Partikel
    	int l;
        float f;
        float f1;
        float f2;
    	
    	for (l = 0; l < 3; ++l)
        {
    		f = (float)p_149734_2_ + p_149734_5_.nextFloat();
            f1 = (float)p_149734_3_ + p_149734_5_.nextFloat() * 0.5F + 0.5F;
            f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
            p_149734_1_.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
            p_149734_1_.spawnParticle("flame", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
        }
    }
}
