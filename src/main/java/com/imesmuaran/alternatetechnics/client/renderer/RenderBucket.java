package com.imesmuaran.alternatetechnics.client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.imesmuaran.alternatetechnics.client.models.ModelBucket;
import com.imesmuaran.alternatetechnics.client.models.ModelBucketT;
import com.imesmuaran.alternatetechnics.tileentities.TEBucket;

public class RenderBucket extends TileEntitySpecialRenderer {

	// Attribute
	private ModelBucket model;
	
	public static final ResourceLocation texture = new ResourceLocation("alternatetechnics", "models/Bucket-texturemap.png");
	
	public RenderBucket(ModelBucket model) {
		this.model = model;
	}
	
	//Eigener Rendercode
	public void renderBucket(TEBucket bucket, double x, double y, double z, float partialTickTime) {
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
		renderBucket((TEBucket)tileentity, x, y, z, f);
	}
}
