package com.imesmuaran.alternatetechnics.client.renderer;

import org.lwjgl.opengl.GL11;

import com.imesmuaran.alternatetechnics.client.models.ModelFirepit;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class RenderFirepitItem implements IItemRenderer{
	private ModelFirepit model;

    public RenderFirepitItem(ModelFirepit model) {
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
            	GL11.glTranslatef(0, -1F, 0);
                break;
            case EQUIPPED:
            	GL11.glTranslatef(-0.8F, -0.2F, 0.7F);
                break;
            case EQUIPPED_FIRST_PERSON:
            	GL11.glTranslatef(0, -0.7F, 0.7F);
                break;
            case ENTITY:
            	GL11.glTranslatef(0, -1.25F, 0F);
            	break;
            default:
        }

        Minecraft.getMinecraft().getTextureManager().bindTexture(RenderFirepit.texture);
        model.render(null, 0, 0, 0, 0, 0, 0.0625F);

        GL11.glPopMatrix();
    }
}
