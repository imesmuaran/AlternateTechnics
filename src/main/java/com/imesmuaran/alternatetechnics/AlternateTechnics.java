package com.imesmuaran.alternatetechnics;

import com.imesmuaran.alternatetechnics.blocks.Blocks;
import com.imesmuaran.alternatetechnics.crafting.ExtVanilla;
import com.imesmuaran.alternatetechnics.handler.ConfigurationHandler;
import com.imesmuaran.alternatetechnics.items.ItemBurger;
import com.imesmuaran.alternatetechnics.items.Items;
import com.imesmuaran.alternatetechnics.proxy.IProxy;
import com.imesmuaran.alternatetechnics.reference.Reference;
import com.imesmuaran.alternatetechnics.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


@Mod(modid= Reference.MOD_ID, name= Reference.MOD_NAME, version= Reference.VERSION)
public class AlternateTechnics
{
    @Mod.Instance (Reference.MOD_ID)
    public static AlternateTechnics instance;

    @SidedProxy (clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;


    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event)
    {
        //** Network, Config, New Blocks, New Items **//

        //** Items **//
        Items.Items();
        LogHelper.info("Costume Items loaded!");

        //** Blocks **//
        Blocks.Blocks();
        LogHelper.info("Costume Blocks loaded!");

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        LogHelper.info("Pre Initialization complete!");
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event)
    {
        //** Recipes **//
        ExtVanilla.recipes();
        LogHelper.info("Costume Recipes loaded!");
        LogHelper.info("Initialization complete!");
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization complete!");
    }
}
