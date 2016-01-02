package dca.projectx.machine.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEngineeringTable extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer plate;
  
  public ModelEngineeringTable()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      base = new ModelRenderer(this, 0, 0);
      base.addBox(0F, 0F, 0F, 16, 6, 16);
      base.setRotationPoint(-8F, 18F, -8F);
      base.setTextureSize(64, 64);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      plate = new ModelRenderer(this, 0, 22);
      plate.addBox(0F, 0F, 0F, 16, 1, 16);
      plate.setRotationPoint(-8F, 12F, -8F);
      plate.setTextureSize(64, 64);
      plate.mirror = true;
      setRotation(plate, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    plate.render(f5);
  }
  
  public void renderModel(float f){
	base.render(f);
	plate.render(f);
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
