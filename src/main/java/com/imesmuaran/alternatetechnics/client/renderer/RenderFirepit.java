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
	
	private ModelFirepit model;
	public static final ResourceLocation texture = new ResourceLocation("alternatetechnics", "models/Firepit-texturemap.png");
	
	public RenderFirepit(ModelFirepit model) {
		this.model = model;
	}
	
	public void renderFirepit(TEFirepit firepit, double x, double y, double z, float yaw, float partialTickTime) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glScalef(-1F, -1F, 1F);

        bindTexture(texture);

        model.render(firepit, 0F, 0F, 0F, 0F, 0F, 0.0625F);

        GL11.glPopMatrix();
    }

	@Override
	public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_,
			double p_147500_4_, double p_147500_6_, float p_147500_8_) {
		// TODO Auto-generated method stub
		
	}
}
