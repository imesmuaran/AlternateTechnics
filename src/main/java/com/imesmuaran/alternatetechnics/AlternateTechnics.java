package com.imesmuaran.alternatetechnics;

import com.imesmuaran.alternatetechnics.blocks.BlockLoader;
import com.imesmuaran.alternatetechnics.client.renderer.RenderDroid;
import com.imesmuaran.alternatetechnics.crafting.RecipeLoader;
import com.imesmuaran.alternatetechnics.entities.EntityDroid;
import com.imesmuaran.alternatetechnics.entities.EntityLoader;
import com.imesmuaran.alternatetechnics.handler.ConfigurationHandler;
import com.imesmuaran.alternatetechnics.items.ItemLoader;
import com.imesmuaran.alternatetechnics.proxy.ClientProxy;
import com.imesmuaran.alternatetechnics.proxy.IProxy;
import com.imesmuaran.alternatetechnics.reference.Reference;
import com.imesmuaran.alternatetechnics.tileentities.TileEntityLoader;
import com.imesmuaran.alternatetechnics.utility.LogHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


@Mod(modid= Reference.MOD_ID, name= Reference.MOD_NAME, version= Reference.VERSION)
public class AlternateTechnics
{
    @Mod.Instance (Reference.MOD_ID)
    public static AlternateTechnics instance;

    @SidedProxy (clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    //** Creative Tab **//
    public static CreativeTabs tabAT = new CreativeTabs("tabAT") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return ItemLoader.burgerItem;
        }
    };
    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event)
    {
        //** Network, Config, New Blocks, New Items **//

        //** Items **//
        ItemLoader.Items();

        //** Blocks **//
        BlockLoader.Blocks();

        //** Tile- & Entity Loader **//
        TileEntityLoader.TileEntities();
        EntityLoader.EntityLoader();

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        LogHelper.info("Pre Initialization complete!");
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event)
    {
        //** Recipes **//
        RecipeLoader.recipes();

        LogHelper.info("Initialization complete!");
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
        //ClientProxy.initRenderers();
        RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid());
        LogHelper.info("Post Initialization complete!");
    }
}
