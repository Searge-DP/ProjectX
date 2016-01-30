package snowpaw.projectx.machine.energy;

public class PulseNode {
	
    public int x;
    public int y;
    public int z;
    public boolean master;

    public PulseNode(int x, int y, int z, boolean master) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.master = master;
    }

    public PulseNode(int x, int y, int z, int master) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.master = master == 1;
    }

    public int getMasterAsInt() {
        if (master)
            return 1;
        else
            return 0;
    }

}
