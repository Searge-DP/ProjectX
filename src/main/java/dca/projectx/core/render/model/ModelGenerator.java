package dca.projectx.core.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGenerator extends ModelBase
{
  //fields
    ModelRenderer base1;
    ModelRenderer front1;
    ModelRenderer front2;
    ModelRenderer front3;
    ModelRenderer front4;
    ModelRenderer panel1;
    ModelRenderer panel2;
  
  public ModelGenerator()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      base1 = new ModelRenderer(this, 0, 0);
      base1.addBox(0F, 0F, 0F, 16, 16, 13);
      base1.setRotationPoint(-8F, 8F, -8F);
      base1.setTextureSize(64, 64);
      base1.mirror = true;
      setRotation(base1, 0F, 0F, 0F);
      front1 = new ModelRenderer(this, 0, 29);
      front1.addBox(0F, 0F, 0F, 1, 16, 3);
      front1.setRotationPoint(-8F, 8F, 5F);
      front1.setTextureSize(64, 64);
      front1.mirror = true;
      setRotation(front1, 0F, 0F, 0F);
      front2 = new ModelRenderer(this, 0, 29);
      front2.addBox(0F, 0F, 0F, 1, 16, 3);
      front2.setRotationPoint(7F, 8F, 5F);
      front2.setTextureSize(64, 64);
      front2.mirror = true;
      setRotation(front2, 0F, 0F, 0F);
      front3 = new ModelRenderer(this, 8, 29);
      front3.addBox(0F, 0F, 0F, 14, 1, 3);
      front3.setRotationPoint(-7F, 8F, 5F);
      front3.setTextureSize(64, 64);
      front3.mirror = true;
      setRotation(front3, 0F, 0F, 0F);
      front4 = new ModelRenderer(this, 8, 29);
      front4.addBox(0F, 0F, 0F, 14, 1, 3);
      front4.setRotationPoint(-7F, 23F, 5F);
      front4.setTextureSize(64, 64);
      front4.mirror = true;
      setRotation(front4, 0F, 0F, 0F);
      panel1 = new ModelRenderer(this, 8, 33);
      panel1.addBox(0F, 0F, 0F, 10, 5, 2);
      panel1.setRotationPoint(-5F, 11F, 5F);
      panel1.setTextureSize(64, 64);
      panel1.mirror = true;
      setRotation(panel1, 0F, 0F, 0F);
      panel2 = new ModelRenderer(this, 8, 40);
      panel2.addBox(0F, 0F, 0F, 4, 4, 2);
      panel2.setRotationPoint(1F, 17F, 5F);
      panel2.setTextureSize(64, 64);
      panel2.mirror = true;
      setRotation(panel2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base1.render(f5);
    front1.render(f5);
    front2.render(f5);
    front3.render(f5);
    front4.render(f5);
    panel1.render(f5);
    panel2.render(f5);
  }
  
  public void renderModel(float f){
	base1.render(f);
	front1.render(f);
	front2.render(f);
	front3.render(f);
	front4.render(f);
	panel1.render(f);
	panel2.render(f);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
