package com.imesmuaran.alternatetechnics.client.renderer;

import org.lwjgl.opengl.GL11;

import com.imesmuaran.alternatetechnics.client.models.ModelFirepit;
import com.imesmuaran.alternatetechnics.entities.EntityDroid;
import com.imesmuaran.alternatetechnics.tileentities.TEFirepit;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderFirepit extends TileEntitySpecialRenderer{
	
	// Attribute
	private ModelFirepit model;
	
	public static final ResourceLocation texture = new ResourceLocation("alternatetechnics", "models/Firepit-texturemap.png");
	
	public RenderFirepit(ModelFirepit model) {
		this.model = model;
	}
	
	//Eigener Rendercode
	public void renderFirepit(TEFirepit firepit, double x, double y, double z, float partialTickTime) {
        // Start rendering
		GL11.glPushMatrix();
		// Startpoint of rendering
        	GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        	GL11.glScalef(-1F, -1F, 1F);

        	bindTexture(texture);
        	
        	GL11.glPushMatrix();
        		this.model.render((Entity)null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
        	GL11.glPopMatrix();

        GL11.glPopMatrix();
    }
	
	// Rendercode angewant
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		renderFirepit((TEFirepit)tileentity, x, y, z, f);
	}
}
