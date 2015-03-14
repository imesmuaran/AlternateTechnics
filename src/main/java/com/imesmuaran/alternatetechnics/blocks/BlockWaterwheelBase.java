package com.imesmuaran.alternatetechnics.blocks;

import com.imesmuaran.alternatetechnics.AlternateTechnics;
import com.imesmuaran.alternatetechnics.tileentities.TEWaterwheelBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockWaterwheelBase extends BlockContainer {

    public BlockWaterwheelBase (Material material) {
        super(material);
        setHardness(2.0F);
        setStepSound(Block.soundTypeMetal);
        setBlockName("waterwheelBase");
        this.setCreativeTab(AlternateTechnics.tabAT);
        setHarvestLevel("pickaxe",0);
        setBlockTextureName("alternatetechnics:WIPBlock");
    }


    public TileEntity createNewTileEntity(World world, int var1)
    {
        return new TEWaterwheelBase();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float xActive, float yActive, float zActive)
    {
        return true;
    }

}
