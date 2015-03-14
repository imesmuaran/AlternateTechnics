package com.imesmuaran.alternatetechnics.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Firepit - D_U
 * Created using Tabula 4.1.1
 */
public class ModelFirepit extends ModelBase {
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape15;
    public ModelRenderer shape17;
    public ModelRenderer shape18;

    public ModelFirepit() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape13 = new ModelRenderer(this, 0, 26);
        this.shape13.setRotationPoint(-0.2F, 23.0F, 6.9F);
        this.shape13.addBox(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F);
        this.setRotateAngle(shape13, -0.2686061718819273F, 1.1906636157105317F, -0.4653047785816882F);
        this.shape11 = new ModelRenderer(this, 0, 30);
        this.shape11.setRotationPoint(-5.8F, 23.0F, -4.3F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1, 0.0F);
        this.setRotateAngle(shape11, 0.0F, -0.5969026041820606F, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 0);
        this.shape9.setRotationPoint(5.4F, 24.1F, -0.3F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1, 0.0F);
        this.setRotateAngle(shape9, 0.136659280431156F, 0.136659280431156F, -2.0943951023931953F);
        this.shape8 = new ModelRenderer(this, 0, 2);
        this.shape8.setRotationPoint(-5.5F, 23.5F, 2.7F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1, 0.0F);
        this.setRotateAngle(shape8, 0.0F, 0.29146998508305305F, -0.9471901850573226F);
        this.shape18 = new ModelRenderer(this, 0, 20);
        this.shape18.setRotationPoint(5.3F, 21.7F, 6.1F);
        this.shape18.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1, 0.0F);
        this.setRotateAngle(shape18, 0.22689280275926282F, 2.3556708914167466F, 0.2001892652037496F);
        this.shape17 = new ModelRenderer(this, 0, 18);
        this.shape17.setRotationPoint(4.5F, 23.5F, -6.1F);
        this.shape17.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1, 0.0F);
        this.setRotateAngle(shape17, -0.13788101090755206F, -2.231054382824351F, 0.9105382707654417F);
        this.shape15 = new ModelRenderer(this, 0, 22);
        this.shape15.setRotationPoint(0.5F, 23.0F, 3.9F);
        this.shape15.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        this.setRotateAngle(shape15, 0.0F, 2.367539130330308F, 0.9529497715889039F);
        this.shape14 = new ModelRenderer(this, 0, 24);
        this.shape14.setRotationPoint(-7.3F, 19.8F, 0.0F);
        this.shape14.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1, 0.0F);
        this.setRotateAngle(shape14, 0.008028514559173916F, 0.26546457922833755F, 0.24905848425959082F);
        this.shape10 = new ModelRenderer(this, 0, 4);
        this.shape10.setRotationPoint(-2.7F, 23.0F, -6.7F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 14, 1, 1, 0.0F);
        this.setRotateAngle(shape10, -0.091106186954104F, -0.7775441817634738F, -1.0471975511965976F);
        this.shape12 = new ModelRenderer(this, 0, 28);
        this.shape12.setRotationPoint(1.0F, 23.0F, -5.4F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F);
        this.setRotateAngle(shape12, 0.0F, -2.247460477793098F, 0.27314402793711257F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape13.render(f5);
        this.shape11.render(f5);
        this.shape9.render(f5);
        this.shape8.render(f5);
        this.shape18.render(f5);
        this.shape17.render(f5);
        this.shape15.render(f5);
        this.shape14.render(f5);
        this.shape10.render(f5);
        this.shape12.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
