package snowpaw.projectx.lib.model;

import codechicken.lib.render.Vertex5;
import codechicken.lib.vec.Quat;
import codechicken.lib.vec.Vector3;
import net.minecraft.client.renderer.Tessellator;
import snowpaw.projectx.lib.render.Vertex5UV;

public class ModelSection {
	
	public double textureWidth;
	public double textureHeight;
	public int tilesU;
	public int tilesV;
	public double offU;
	public double offV;
	public Quat rotation;
	public Vector3 vec = new Vector3();
	
	public ModelSection(int width, int height){
		this.textureWidth = width;
		this.textureHeight = height;
	}
	
	public ModelSection(int tileWidth, int tileHeight, int tilesX, int tilesY){
		this.textureWidth = (tileWidth * tilesX);
		this.textureHeight = (tileHeight * tilesY);
		this.tilesU = tilesX;
		this.tilesV = tilesY;
	}
	
	public void setTile(int x, int y){
		this.offU = (this.textureWidth * x / this.tilesU);
		this.offV = (this.textureHeight * y / this.tilesV);
	}
	
	public void addVertex(double x, double y, double z, double u, double v){
		Tessellator tess = Tessellator.instance;
		
		this.vec.set(x, y, z);
		
		if(this.rotation != null){
			this.rotation.rotate(this.vec);
		}
		
		tess.addVertexWithUV(this.vec.x, this.vec.y, this.vec.z, (this.offU + u) / this.textureWidth, (this.offV + v) / this.textureHeight);
	}
	
	public ModelSection transform(Quat quat){
		this.rotation = quat;
		return this;
	}
	
	public void addVertex(Vertex5UV vert){
	    addVertex(vert.vec.x, vert.vec.y, vert.vec.z, vert.u, vert.v);
	}

}
