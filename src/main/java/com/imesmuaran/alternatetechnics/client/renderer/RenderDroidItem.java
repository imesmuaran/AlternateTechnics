package com.imesmuaran.alternatetechnics.client.renderer;

import com.imesmuaran.alternatetechnics.client.models.ModelDroid;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderDroidItem implements IItemRenderer{

    private ModelDroid model;

    public RenderDroidItem(ModelDroid model) {
        this.model = model;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true; //Controls when the item should be rendered
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true; //Dropped Item effects
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        GL11.glScalef(-1F, -1F, 1F);

        switch (type) {
            case INVENTORY:
                GL11.glTranslatef(0, 0.13F, 0);
                break;
            case EQUIPPED:
                GL11.glTranslatef(-0.8F, -0.2F, 0.7F);
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glTranslatef(0, -0.7F, 0.7F);
                break;
            default:
        }

        Minecraft.getMinecraft().getTextureManager().bindTexture(RenderDroid.texture);
        model.render(null, 0, 0, 0, 0, 0, 0.0625F);

        GL11.glPopMatrix();
    }
}
