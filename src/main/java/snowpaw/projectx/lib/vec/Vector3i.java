package snowpaw.projectx.lib.vec;

public class Vector3i {
	private int x, y, z;
	public Vector3i(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
    
    public Vector3i getDistance(Vector3i vec)
    {
    	return new Vector3i(getX() - vec.getX(), getY() - vec.getY(), getZ() - vec.getZ());
    }
    
    @Override
    public String toString()
    {
		return "xPos:"+getX()+","+"yPos:"+getY()+","+"zPos:"+getZ();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Vector3i))
            return false;
        Vector3i other = (Vector3i) obj;
        return other.getX() == getX() && other.getY() == getY() && other.getZ() == getZ();
    }
    
    @Override
    public int hashCode() {
        int hash = 23;
        hash = hash * 31 + getX();
        hash = hash * 31 + getY();
        hash = hash * 31 + getZ();
        return hash;
    }
    
}
