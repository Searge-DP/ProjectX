package snowpaw.projectx.machine.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPulseNode extends ModelBase
{
  //fields
    ModelRenderer base1;
    ModelRenderer conn1;
  
  public ModelPulseNode()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      base1 = new ModelRenderer(this, 0, 0);
      base1.addBox(0F, 0F, 0F, 10, 2, 10);
      base1.setRotationPoint(-5F, 22F, -5F);
      base1.setTextureSize(64, 64);
      base1.mirror = true;
      setRotation(base1, 0F, 0F, 0F);
      conn1 = new ModelRenderer(this, 0, 12);
      conn1.addBox(0F, 0F, 0F, 4, 3, 4);
      conn1.setRotationPoint(-2F, 19F, -2F);
      conn1.setTextureSize(64, 64);
      conn1.mirror = true;
      setRotation(conn1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base1.render(f5);
    conn1.render(f5);
  }
  
  public void renderModel(float f){
	base1.render(f);
	conn1.render(f);
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
