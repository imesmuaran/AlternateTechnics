package com.imesmuaran.alternatetechnics.tileentities;

import com.imesmuaran.alternatetechnics.blocks.BlockLoader;
import com.imesmuaran.alternatetechnics.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityLoader extends BlockLoader
{
    public static void TileEntities()
    {
        GameRegistry.registerTileEntity(TEVerticalConveyor.class, "verticalConveyor");
        GameRegistry.registerTileEntity(TEWaterwheelBase.class, "waterwheelBase");
        LogHelper.info("TileEntities loaded!");
    }
}
