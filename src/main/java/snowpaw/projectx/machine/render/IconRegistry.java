package snowpaw.projectx.machine.render;

import java.util.ArrayList;

import codechicken.lib.render.TextureUtils.IIconSelfRegister;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import snowpaw.projectx.core.ProjectX;

public class IconRegistry implements IIconSelfRegister {
	
	public static ArrayList<CustomTexture> toRegister = new ArrayList<CustomTexture>();
	public static ArrayList<IIcon> iconRegistry = new ArrayList<IIcon>();
	
	@Override
	public int atlasIndex() {
		return 0;
	}
	
	public static void addIcon(String textureName)
	{
		toRegister.add(new CustomTexture(textureName));
	}
	
	public static CustomTexture getIconByArray(int array)
	{
		return toRegister.get(array);
	}
	
	public static IIcon getIIcon(String textureLocation)
	{
		for(int ix = 0; ix < iconRegistry.size(); ix++)
		{
			if(iconRegistry.get(ix).getIconName().replace(ProjectX.INSTANCE + ":/overlay/" , "") == textureLocation )
			{
				return iconRegistry.get(ix);
			}
		}
		return null;
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
		for(int ix = 0; ix < toRegister.size(); ix++)
		{
			IIcon ic = reg.registerIcon(ProjectX.MODID + ":/overlay/" + toRegister.get(ix).getTextureName());
			iconRegistry.add(ic);
		}
		
	}

	}

	class CustomTexture
	{
	private String textureName;
	public CustomTexture(String textureName)
	{
		this.textureName = textureName; 
	}
	
	public String getTextureName()
	{
		return textureName;
	}

}
