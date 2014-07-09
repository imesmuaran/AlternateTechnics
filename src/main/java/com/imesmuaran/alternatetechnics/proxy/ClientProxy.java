package com.imesmuaran.alternatetechnics.proxy;


import com.imesmuaran.alternatetechnics.client.renderer.RenderDroid;
import com.imesmuaran.alternatetechnics.entities.EntityDroid;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.audio.SoundHandler;

public class ClientProxy extends CommonProxy {

    //@Override
    public void initSounds() {
       //new SoundHandler();
    }

    @Override
    public void initRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid());
    }

}
