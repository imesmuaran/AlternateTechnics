package com.imesmuaran.alternatetechnics.blocks;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBucket extends Block {

    public BlockBucket(Material material) {
        super(material);
        setBlockBounds(0.125F, 0F, 0.125F, 0.875F, 0.875F, 0.875F);
        setHardness(0.1F);
        setHarvestLevel("pickaxe",0);
        setBlockName("bucketBlock");
        this.setCreativeTab(AlternateTechnics.tabAT);
    }


    //This will tell Minecraft not to render any side of our cube.
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return false;
    }

    //And this tell it that you can see through this block, and neighbor blocks should be rendered.
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0.125F, 0F, 0.125F, 0.875F, 0.875F, 0.875F);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return Reference.RENDER_BUCKET_BLOCK_ID;
    }
}
