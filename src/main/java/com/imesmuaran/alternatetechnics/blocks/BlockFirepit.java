package com.imesmuaran.alternatetechnics.blocks;

import java.util.Random;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.items.ItemLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;



public class BlockFirepit extends Block {

	public BlockFirepit() {
		super(Material.wood);
		setBlockName("firepit");
		setLightLevel(1.0F);
		setLightOpacity(0);
		this.setTickRandomly(true);
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return ItemLoader.firepitItem;
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
    	if (p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_) == 1) {
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
	        float offset = 0.2F;
	    	
	    	for (l = 0; l < 3; ++l)
	        {
	    		f = (float)p_149734_2_ + p_149734_5_.nextFloat();
	            f1 = (float)p_149734_3_ + p_149734_5_.nextFloat() * 0.5F + 0.5F;
	            f2 = (float)p_149734_4_ + p_149734_5_.nextFloat() - offset;
	            p_149734_1_.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
	            p_149734_1_.spawnParticle("flame", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
	        }
    	}
    }
    
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    @Override
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return p_149742_3_ >= p_149742_1_.getHeight() - 1 ? false : World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) && super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
    }
    
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    @Override
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
    	boolean flag = false;
    	
    	if (!World.doesBlockHaveSolidTopSurface(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_))
        {
            p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
            flag = true;
        }
    	
    	if (flag)
        {
            if (!p_149695_1_.isRemote)
            {
                this.dropBlockAsItem(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 0, 0);
            }
        }
    }
    
    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random p_149674_5_) {
    	if (world.getGameRules().getGameRuleBooleanValue("doFireTick"))
        {
    		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + p_149674_5_.nextInt(10));
    		
    		if(world.getBlock(x, y + 1, z).isFlammable(world, x, y, z, ForgeDirection.UP)){
    			world.setBlock(x, y + 1, z, Blocks.fire, 15, 3);
    		}
        }
    }
    
    // Lit the Fire!
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {	
    	if((player.getEquipmentInSlot(0) != null) && (player.getEquipmentInSlot(0).getItem() == Items.flint_and_steel)) {
    		player.getEquipmentInSlot(0).damageItem(1, player);
    		world.setBlockMetadataWithNotify(x, y, z, 1, 2);
    		this.randomDisplayTick(world, x, y, z, new Random());
    	}
    	return true;
    }
    
    /**
     * Get a light value for the block at the specified coordinates, normal ranges are between 0 and 15
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @return The light value
     */
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z) == 1 ? 15 : 0;
    }
    
    /**
     * Determines if this block should set fire and deal fire damage
     * to entities coming into contact with it.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @return True if the block should deal damage
     */
    @Override
    public boolean isBurning(IBlockAccess world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z) == 1 ? true : false;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer)
    {
        return true;
    }
}
