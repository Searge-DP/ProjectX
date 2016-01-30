package snowpaw.projectx.machine.render;

import java.awt.Color;
import org.lwjgl.opengl.GL11;
import codechicken.lib.vec.Vector3;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import snowpaw.projectx.core.ProjectX;

public class RenderTruncatedIcosahedron {
	
	public static Vector3[] verts = new Vector3[60];
	public static final double phi = 1.618034D;
	public static int listIndex;
	
	public RenderTruncatedIcosahedron(){
		this.generate();
	}
	
	public static enum EnumHedronTexture{
		FILL(new ResourceLocation(ProjectX.INSTANCE, "textures/models/icosa_fill.png")),
		SPACE(new ResourceLocation(ProjectX.INSTANCE, "textures/models/icosa_space.png"));
		
		public final ResourceLocation texture;
		
		private EnumHedronTexture(ResourceLocation texture){
			this.texture = texture;
		}
	}
	
	  public static void render(double size, float r, float g, float b, EnumHedronTexture type){
	    GL11.glDisable(2896);
	    GL11.glDisable(16384);
	    GL11.glDisable(16385);
	    Minecraft.getMinecraft().renderEngine.bindTexture(type.texture);
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    GL11.glScaled(size * 0.1D, size * 0.1D, size * 0.1D);
	    
	    GL11.glColor3f(r - 0.4F, g - 0.4F, b - 0.4F);
	    GL11.glCallList(listIndex);
	    
	    GL11.glColor3f(r, g, b);
	    GL11.glCallList(listIndex + 1);
	    
	    GL11.glScaled(1.0D / (size * 0.1D), 1.0D / (size * 0.1D), 1.0D / (size * 0.1D));
	    GL11.glEnable(2896);
	    GL11.glEnable(16384);
	    GL11.glEnable(16385);
	    GL11.glDisable(3042);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	  }
	
	  public static void generate(){
	    int[] s = { 1, -1 };
	    for (int i = 0; i < 4; i++) {
	      verts[i] = new Vector3(0.0D, s[(i / 2)], s[(i % 2)] * 3 * 1.618034D);
	    }
	    for (int i = 0; i < 8; i++)
	    {
	      verts[(i + 4)] = new Vector3(s[(i / 4)] * 2, s[(i / 2 % 2)] * 4.2360679999999995D, s[(i % 2)] * phi);
	      verts[(i + 12)] = new Vector3(s[(i / 4)], s[(i / 2 % 2)] * 3.6180339999999998D, s[(i % 2)] * 2 * phi);
	    }
	    for (int i = 0; i < 20; i++)
	    {
	      verts[(i + 20)] = new Vector3(verts[i].y, verts[i].z, verts[i].x);
	      verts[(i + 40)] = new Vector3(verts[i].z, verts[i].x, verts[i].y);
	    }
	    listIndex = GL11.glGenLists(2);
	    GL11.glNewList(listIndex, 4864);
	    GL11.glBegin(4);
	    for (int rot = 0; rot < 3; rot++) {
	      for (int i = 0; i < 4; i++) {
	        pentagon(rot, i);
	      }
	    }
	    GL11.glEnd();
	    GL11.glEndList();
	    
	    GL11.glNewList(listIndex + 1, 4864);
	    GL11.glBegin(4);
	    for (int rot = 0; rot < 3; rot++) {
	      for (int i = 0; i < 4; i++) {
	        hexagon1(rot, i);
	      }
	    }
	    for (int i = 0; i < 8; i++) {
	      hexagon2(i);
	    }
	    GL11.glEnd();
	    GL11.glEndList();
	  }
	  
	  public static void renderShape(Vector3[] verts, boolean reverse){
	    Vector3 center = new Vector3();
	    for (int i = 0; i < verts.length; i++) {
	      center.add(verts[i]);
	    }
	    center.multiply(1.0D / verts.length);
	    
	    Vector3 prev = verts[0];
	    int start = reverse ? verts.length : 1;
	    int end = reverse ? -1 : verts.length + 1;
	    int step = reverse ? -1 : 1;
	    for (int i = start; i != end; i += step)
	    {
	      GL11.glTexCoord2d(0.5D, 0.5D);
	      GL11.glVertex3d(center.x, center.y, center.z);
	      GL11.glTexCoord2d(0.0D, 0.0D);
	      GL11.glVertex3d(prev.x, prev.y, prev.z);
	      GL11.glTexCoord2d(1.0D, 0.0D);
	      GL11.glVertex3d(verts[(i % verts.length)].x, verts[(i % verts.length)].y, verts[(i % verts.length)].z);
	      prev = verts[(i % verts.length)];
	    }
	  }
	  
	  public static void hexagon1(int rot, int i){
	    Vector3[] hexagon = new Vector3[6];
	    hexagon[0] = verts[(rot * 20 + i / 2)];
	    hexagon[1] = verts[((rot * 20 + i + 44) % 60)];
	    hexagon[2] = verts[((rot * 20 + i + 52) % 60)];
	    hexagon[3] = verts[((rot * 20 + i + 56) % 60)];
	    hexagon[4] = verts[((rot * 20 + i + 48) % 60)];
	    hexagon[5] = verts[(rot * 20 + i / 2 + 2)];
	    renderShape(hexagon, (i == 0) || (i == 3));
	  }
	  
	  public static void hexagon2(int i){
	    Vector3[] hexagon = new Vector3[6];
	    hexagon[0] = verts[(4 + i)];
	    hexagon[1] = verts[(12 + i)];
	    hexagon[2] = verts[(44 + i / 4 + i % 4 * 2)];
	    hexagon[3] = verts[(52 + i / 4 + i % 4 * 2)];
	    hexagon[4] = verts[(24 + i / 2 + i % 2 * 4)];
	    hexagon[5] = verts[(32 + i / 2 + i % 2 * 4)];
	    renderShape(hexagon, (i % 3 != 0) && (i != 5));
	  }
	  
	  public static void pentagon(int rot, int i){
	    Vector3[] pentagon = new Vector3[5];
	    pentagon[0] = verts[(rot * 20 + i)];
	    pentagon[1] = verts[((rot * 20 + 2 * i + 44) % 60)];
	    pentagon[2] = verts[((rot * 20 + i + 12) % 60)];
	    pentagon[3] = verts[((rot * 20 + i + 16) % 60)];
	    pentagon[4] = verts[((rot * 20 + 2 * i + 45) % 60)];
	    renderShape(pentagon, (i != 0) && (i != 3));
	  }

}
