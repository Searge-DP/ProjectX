package snowpaw.projectx.lib.render;

import codechicken.lib.vec.Vector3;

public class Vertex5UV {
	
	public Vector3 vec;
	public double u;
	public double v;
	
	public Vertex5UV(Vector3 vert, double u, double v){
		this.vec = vert;
		this.u = u;
		this.v = v;
	}
	
	public Vertex5UV(double x, double y, double z, double u, double v){
	    this(new Vector3(x, y, z), u, v);
	}
	
	public Vertex5UV(Vertex5UV vertex5UV){
	    this(vertex5UV.vec.copy(), vertex5UV.u, vertex5UV.v);
	}
	
	public void setUV(int u, int v){
	    this.u = u;
	    this.v = v;
	}
	
	public Vertex5UV copy(){
	    return new Vertex5UV(this);
	}

}
