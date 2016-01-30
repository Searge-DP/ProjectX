package snowpaw.projectx.lib.helper;

import codechicken.lib.colour.ColourRGBA;

public class BlockColorHelper {
	
	public static ColourRGBA setColor5(int meta){
    	switch(meta){
    	case 0: return new ColourRGBA(0D, 0D, 1D, 1D);
    	case 1: return new ColourRGBA(0D, 1D, 0D, 1D);
    	case 2: return new ColourRGBA(1D, 0D, 0D, 1D);
    	case 3: return new ColourRGBA(0.1D, 0.1D, 0.1D, 1D);
    	case 4: return new ColourRGBA(1D, 1D, 1D, 1D);
    	}
    	
    	return null;
	}
	
	public static ColourRGBA setColor16(int meta){
    	switch(meta){
    	case 0: return new ColourRGBA(0.1D, 0.1D, 0.1D, 1D);
    	case 1: return new ColourRGBA(1D, 0D, 0D, 1D);
    	case 2: return new ColourRGBA(0D, 1D, 0D, 1D);
    	case 3: return new ColourRGBA(0.7D, 0.3D, 0D, 1D);
    	case 4: return new ColourRGBA(0D, 0D, 1D, 1D);
    	case 5: return new ColourRGBA(0.9D, 0D, 1D, 1D);
    	case 6: return new ColourRGBA(0D, 0.7D, 1D, 1D);
    	case 7: return new ColourRGBA(0.8D, 0.8D, 0.8D, 1D);
    	case 8: return new ColourRGBA(0.5D, 0.5D, 0.5D, 1D);
    	case 9: return new ColourRGBA(1D, 0D, 0.3D, 1D);
    	case 10: return new ColourRGBA(0.5D, 1D, 0D, 1D);
    	case 11: return new ColourRGBA(1D, 1D, 0D, 1D);
    	case 12: return new ColourRGBA(0D, 0.5D, 1D, 1D);
    	case 13: return new ColourRGBA(1D, 0D, 0.8D, 1D);
    	case 14: return new ColourRGBA(1D, 0.4D, 0D, 1D);
    	case 15: return new ColourRGBA(1D, 1D, 1D, 1D);
    	}
    	
    	return null;
	}

}
