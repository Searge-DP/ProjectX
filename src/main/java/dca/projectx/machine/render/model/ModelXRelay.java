package dca.projectx.machine.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelXRelay extends ModelBase
{
  //fields
    ModelRenderer base1;
    ModelRenderer conn1;
    ModelRenderer conn2;
    ModelRenderer conn3;
    ModelRenderer conn4;
    ModelRenderer conn5;
    ModelRenderer circ1;
    ModelRenderer circ2;
    ModelRenderer circ3;
    ModelRenderer circ4;
  
  public ModelXRelay()
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
      conn2 = new ModelRenderer(this, 16, 12);
      conn2.addBox(0F, 0F, 0F, 2, 2, 1);
      conn2.setRotationPoint(-1F, 18F, -3F);
      conn2.setTextureSize(64, 64);
      conn2.mirror = true;
      setRotation(conn2, 0F, 0F, 0F);
      conn3 = new ModelRenderer(this, 16, 12);
      conn3.addBox(0F, 0F, 0F, 2, 2, 1);
      conn3.setRotationPoint(-1F, 18F, 2F);
      conn3.setTextureSize(64, 64);
      conn3.mirror = true;
      setRotation(conn3, 0F, 0F, 0F);
      conn4 = new ModelRenderer(this, 16, 15);
      conn4.addBox(0F, 0F, 0F, 1, 2, 2);
      conn4.setRotationPoint(2F, 18F, -1F);
      conn4.setTextureSize(64, 64);
      conn4.mirror = true;
      setRotation(conn4, 0F, 0F, 0F);
      conn5 = new ModelRenderer(this, 16, 15);
      conn5.addBox(0F, 0F, 0F, 1, 2, 2);
      conn5.setRotationPoint(-3F, 18F, -1F);
      conn5.setTextureSize(64, 64);
      conn5.mirror = true;
      setRotation(conn5, 0F, 0F, 0F);
      circ1 = new ModelRenderer(this, 22, 12);
      circ1.addBox(0F, 0F, 0F, 1, 2, 1);
      circ1.setRotationPoint(-4F, 20F, 3F);
      circ1.setTextureSize(64, 64);
      circ1.mirror = true;
      setRotation(circ1, 0F, 0F, 0F);
      circ2 = new ModelRenderer(this, 22, 12);
      circ2.addBox(0F, 0F, 0F, 1, 2, 1);
      circ2.setRotationPoint(3F, 20F, 3F);
      circ2.setTextureSize(64, 64);
      circ2.mirror = true;
      setRotation(circ2, 0F, 0F, 0F);
      circ3 = new ModelRenderer(this, 22, 12);
      circ3.addBox(0F, 0F, 0F, 1, 2, 1);
      circ3.setRotationPoint(-4F, 20F, -4F);
      circ3.setTextureSize(64, 64);
      circ3.mirror = true;
      setRotation(circ3, 0F, 0F, 0F);
      circ4 = new ModelRenderer(this, 22, 12);
      circ4.addBox(0F, 0F, 0F, 1, 2, 1);
      circ4.setRotationPoint(3F, 20F, -4F);
      circ4.setTextureSize(64, 64);
      circ4.mirror = true;
      setRotation(circ4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base1.render(f5);
    conn1.render(f5);
    conn2.render(f5);
    conn3.render(f5);
    conn4.render(f5);
    conn5.render(f5);
    circ1.render(f5);
    circ2.render(f5);
    circ3.render(f5);
    circ4.render(f5);
  }
  
  public void renderModel(float f){
	base1.render(f);
	conn1.render(f);
	conn2.render(f);
	conn3.render(f);
	conn4.render(f);
	conn5.render(f);
	circ1.render(f);
	circ2.render(f);
	circ3.render(f);
	circ4.render(f);
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
