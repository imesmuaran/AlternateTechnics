package com.imesmuaran.alternatetechnics.proxy;


import com.imesmuaran.alternatetechnics.client.models.ModelDroid;
import com.imesmuaran.alternatetechnics.client.renderer.RenderDroid;
import com.imesmuaran.alternatetechnics.client.renderer.RenderDroidItem;
import com.imesmuaran.alternatetechnics.client.renderer.RendererBucketBlock;
import com.imesmuaran.alternatetechnics.entities.EntityDroid;
import com.imesmuaran.alternatetechnics.items.ItemLoader;
import com.imesmuaran.alternatetechnics.reference.Reference;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.audio.SoundHandler;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    //@Override
    public void initSounds() {
       //new SoundHandler();
    }

    @Override
    public void initRenderers() {
        ModelDroid model = new ModelDroid();
        RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid(model));
        MinecraftForgeClient.registerItemRenderer(ItemLoader.droidItem, new RenderDroidItem(model));

        RendererBucketBlock bucketRender = new RendererBucketBlock();
        RenderingRegistry.registerBlockHandler(bucketRender);
        Reference.RENDER_BUCKET_BLOCK_ID = bucketRender.getRenderId();

    }

}
