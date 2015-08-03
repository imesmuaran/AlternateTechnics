package com.imesmuaran.alternatetechnics.proxy;


import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;

import com.imesmuaran.alternatetechnics.client.models.ModelBucket;
import com.imesmuaran.alternatetechnics.client.models.ModelBucketT;
import com.imesmuaran.alternatetechnics.client.models.ModelDroid;
import com.imesmuaran.alternatetechnics.client.models.ModelFirepit;
import com.imesmuaran.alternatetechnics.client.renderer.RenderBucket;
import com.imesmuaran.alternatetechnics.client.renderer.RenderDroid;
import com.imesmuaran.alternatetechnics.client.renderer.RenderDroidItem;
import com.imesmuaran.alternatetechnics.client.renderer.RenderFirepit;
import com.imesmuaran.alternatetechnics.client.renderer.RenderFirepitItem;
import com.imesmuaran.alternatetechnics.entities.EntityDroid;
import com.imesmuaran.alternatetechnics.items.ItemLoader;
import com.imesmuaran.alternatetechnics.tileentities.TEBucket;
import com.imesmuaran.alternatetechnics.tileentities.TEFirepit;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

public class ClientProxy extends CommonProxy {

    //@Override
    public void initSounds() {
       //new SoundHandler();
    }

    @Override
    public void initRenderers() {
    	// pahimar tut droid
        ModelDroid modelDroid = new ModelDroid();
        RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid(modelDroid));
        MinecraftForgeClient.registerItemRenderer(ItemLoader.droidItem, new RenderDroidItem(modelDroid));
        
        // Bucket
        /*
         *	ModelBucketT modelBucket= new ModelBucketT();
         *	ClientRegistry.bindTileEntitySpecialRenderer(TEBucket.class, new RenderBucket(modelBucket));
        */
        ModelBucket modelBucket = new ModelBucket();
        ClientRegistry.bindTileEntitySpecialRenderer(TEBucket.class, new RenderBucket(modelBucket));
        //MinecraftForgeClient.registerItemRenderer(ItemLoader.bucketItem, new RenderBucketItem(modelBucket));
        
        // Firepit
        ModelFirepit modelFirepit = new ModelFirepit();
        ClientRegistry.bindTileEntitySpecialRenderer(TEFirepit.class, new RenderFirepit(modelFirepit));
        MinecraftForgeClient.registerItemRenderer(ItemLoader.firepitItem, new RenderFirepitItem(modelFirepit));
        
        /* Methode ohne Itemrender (renderklassenkonstruktor ohne param)
         * TileEntitySpecialRenderer modelFirepit = new RenderFirepit();
         *ClientRegistry.bindTileEntitySpecialRenderer(TEFirepit.class, modelFirepit);
        */

    }
    /**
    @Override
    public void doNEICheck(ItemStack item) {
    	if (Minecraft.getMinecraft().thePlayer != null) {
    		Iterator modsIT = Loader.instance().getModList().iterator();
    		ModContainer modc;
    		
    		while (modsIT.hasNext()) {
    			modc = (ModContainer) modsIT.next();
    			if ("Not Enough Items".equals(modc.getName().trim())) {
    				codechicken.nei.api.API.hideItem(item);
    				return;
    			}
    		}
    	}
    }
    **/
}
