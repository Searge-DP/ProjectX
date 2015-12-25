package dca.projectx.lib;

/**
 * Generic FML Logger for Forge. Most code from BluSunrize's 
 * Immersive Engineering Mod !
 * All rights go to him !!!
 * @author BluSunrize
 */

import org.apache.logging.log4j.Level;
import cpw.mods.fml.common.FMLLog;
import dca.projectx.core.ProjectX;

public class XLogger
{
	public static boolean debug = true;
	public static void log(Level logLevel, Object object)
	{
		FMLLog.log(ProjectX.MODID, logLevel, String.valueOf(object), new Object[0]);
	}

	public static void error(Object object)
	{
		log(Level.ERROR, object);
	}

	public static void info(Object object)
	{
		log(Level.INFO, object);
	}

	public static void warn(Object object)
	{
		log(Level.WARN, object);
	}

	public static void debug(Object object)
	{
		if(debug == true)
			log(Level.INFO, "[DEBUG] "+object);
	}
}