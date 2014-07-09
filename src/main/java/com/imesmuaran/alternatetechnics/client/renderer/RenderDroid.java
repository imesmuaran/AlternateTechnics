package com.imesmuaran.alternatetechnics.client.renderer;

import com.imesmuaran.alternatetechnics.client.models.ModelDroid;
import com.imesmuaran.alternatetechnics.entities.EntityDroid;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderDroid extends Render{

    private ModelDroid model;

    public RenderDroid(ModelDroid model) {
        this.model = model;
        shadowSize = 0.5F;
    }

    public static final ResourceLocation texture = new ResourceLocation("alternatetechnics", "models/droid.png");

    public void renderDroid(EntityDroid droid, double x, double y, double z, float yaw, float partialTickTime) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glScalef(-1F, -1F, 1F);

        bindEntityTexture(droid);

        model.render(droid, 0F, 0F, 0F, 0F, 0F, 0.0625F);

        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
        renderDroid((EntityDroid)entity,x,y,z,yaw,partialTickTime);
    }
}
