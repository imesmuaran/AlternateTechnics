package com.imesmuaran.alternatetechnics.tileentities;

import com.imesmuaran.alternatetechnics.blocks.BlockLoader;
import com.imesmuaran.alternatetechnics.blocks.VerticalConveyor;
import com.imesmuaran.alternatetechnics.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TileEntityLoader extends BlockLoader
{
    public static void TileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityVerticalConveyor.class, "verticalConveyor");
        LogHelper.info("Vertical Conveyor loaded!");
    }
}
