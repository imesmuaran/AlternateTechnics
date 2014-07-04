package com.imesmuaran.alternatetechnics.blocks;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.tileentities.TileEntityVerticalConveyor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class VerticalConveyor extends BlockContainer
{
    public VerticalConveyor(Material material)
    {
        super(material);
        setHardness(2.0F);
        setStepSound(Block.soundTypeMetal);
        setBlockName("verticalConveyor");
        this.setCreativeTab(AlternateTechnics.tabAT);
        setHarvestLevel("pickaxe",0);
        setBlockTextureName("alternatetechnics:steamengineblock");
    }

    public TileEntity createNewTileEntity(World world, int var1)
    {
        return new TileEntityVerticalConveyor();
    }

}
