package com.imesmuaran.alternatetechnics.blocks;

import java.util.Random;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.items.ItemLoader;
import com.imesmuaran.alternatetechnics.reference.Reference;
import com.imesmuaran.alternatetechnics.tileentities.TEBucket;
import com.imesmuaran.alternatetechnics.tileentities.TEFirepit;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBucket extends BlockContainer implements ITileEntityProvider{

    public BlockBucket() {
        super(Material.iron);
        setBlockName("bucketBlock");
        //setBlockBounds(0.125F, 0F, 0.125F, 0.875F, 0.875F, 0.875F);
        setHardness(0.1F);
        setHarvestLevel("pickaxe",0);
        this.setCreativeTab(AlternateTechnics.tabAT);
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return ItemLoader.bucketItem;
	}
    
    @Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TEBucket();
	}
    
    @Override
    public int getRenderType() {
        return -1;
    }
    
    //And this tell it that you can see through this block, and neighbor blocks should be rendered.
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    /*
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }
	*/
    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0.125F, 0F, 0.125F, 0.875F, 0.875F, 0.875F);
    }
}
