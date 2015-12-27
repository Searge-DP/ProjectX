package dca.projectx.world;

import cpw.mods.fml.common.registry.GameRegistry;
import dca.projectx.world.block.XBlockBrick;
import dca.projectx.world.block.XBlockBrickSmall;
import dca.projectx.world.block.XBlockOreAluminum;
import dca.projectx.world.block.XBlockOreXycronium;
import dca.projectx.world.block.XBlockPlatform;
import dca.projectx.world.block.XBlockShield;
import dca.projectx.world.block.XBlockStorageAluminum;
import dca.projectx.world.block.XBlockStructure;
import dca.projectx.world.block.XBlockViewer;
import dca.projectx.world.block.XCropCorn;
import dca.projectx.world.block.ctm.XBlockStorageB;
import dca.projectx.world.block.ctm.XBlockStorageD;
import dca.projectx.world.block.ctm.XBlockStorageG;
import dca.projectx.world.block.ctm.XBlockStorageL;
import dca.projectx.world.block.ctm.XBlockStorageR;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class XWorldBlocks {
	
	public static Block oreBlue;
	public static Block oreGreen;
	public static Block oreRed;
	public static Block oreDark;
	public static Block oreLight;
	public static Block oreAluminum;
	public static Block storageBlue;
	public static Block storageGreen;
	public static Block storageRed;
	public static Block storageDark;
	public static Block storageLight;
	public static Block storageAluminum;
	public static Block brickBlue;
	public static Block brickGreen;
	public static Block brickRed;
	public static Block brickDark;
	public static Block brickLight;
	public static Block glassViewer;
	public static Block brickSmallBlue;
	public static Block brickSmallGreen;
	public static Block brickSmallRed;
	public static Block brickSmallDark;
	public static Block brickSmallLight;
	public static Block strucBlack;
	public static Block strucRed;
	public static Block strucGreen;
	public static Block strucBrown;
	public static Block strucBlue;
	public static Block strucPurple;
	public static Block strucCyan;
	public static Block strucLightGray;
	public static Block strucGray;
	public static Block strucPink;
	public static Block strucLime;
	public static Block strucYellow;
	public static Block strucLightBlue;
	public static Block strucMagenta;
	public static Block strucOrange;
	public static Block strucWhite;
	public static Block platBlack;
	public static Block platRed;
	public static Block platGreen;
	public static Block platBrown;
	public static Block platBlue;
	public static Block platPurple;
	public static Block platCyan;
	public static Block platLightGray;
	public static Block platGray;
	public static Block platPink;
	public static Block platLime;
	public static Block platYellow;
	public static Block platLightBlue;
	public static Block platMagenta;
	public static Block platOrange;
	public static Block platWhite;
	public static Block shieldBlack;
	public static Block shieldRed;
	public static Block shieldGreen;
	public static Block shieldBrown;
	public static Block shieldBlue;
	public static Block shieldPurple;
	public static Block shieldCyan;
	public static Block shieldLightGray;
	public static Block shieldGray;
	public static Block shieldPink;
	public static Block shieldLime;
	public static Block shieldYellow;
	public static Block shieldLightBlue;
	public static Block shieldMagenta;
	public static Block shieldOrange;
	public static Block shieldWhite;
	public static Block cropCorn;
	
	public static void preInit(){
		GameRegistry reg = null;
		reg.registerBlock(oreBlue = (new XBlockOreXycronium(Material.rock, "oreBlue")), "oreBlue");
		reg.registerBlock(oreGreen = (new XBlockOreXycronium(Material.rock, "oreGreen")), "oreGreen");
		reg.registerBlock(oreRed = (new XBlockOreXycronium(Material.rock, "oreRed")), "oreRed");
		reg.registerBlock(oreDark = (new XBlockOreXycronium(Material.rock, "oreDark")), "oreDark");
		reg.registerBlock(oreLight = (new XBlockOreXycronium(Material.rock, "oreLight")), "oreLight");
		reg.registerBlock(oreAluminum = (new XBlockOreAluminum(Material.rock, "oreAluminum")), "oreAluminum");
		reg.registerBlock(storageBlue = (new XBlockStorageB(Material.iron, "storageBlue")), "storageBlue");
		reg.registerBlock(storageGreen = (new XBlockStorageG(Material.iron, "storageGreen")), "storageGreen");
		reg.registerBlock(storageRed = (new XBlockStorageR(Material.iron, "storageRed")), "storageRed");
		reg.registerBlock(storageDark = (new XBlockStorageD(Material.iron, "storageDark")), "storageDark");
		reg.registerBlock(storageLight = (new XBlockStorageL(Material.iron, "storageLight")), "storageLight");
		reg.registerBlock(storageAluminum = (new XBlockStorageAluminum(Material.iron, "storageAluminum")), "storageAluminum");
		reg.registerBlock(brickBlue = (new XBlockBrick(Material.iron, "brickBlue")), "brickBlue");
		reg.registerBlock(brickGreen = (new XBlockBrick(Material.iron, "brickGreen")), "brickGreen");
		reg.registerBlock(brickRed = (new XBlockBrick(Material.iron, "brickRed")), "brickRed");
		reg.registerBlock(brickDark = (new XBlockBrick(Material.iron, "brickDark")), "brickDark");
		reg.registerBlock(brickLight = (new XBlockBrick(Material.iron, "brickLight")), "brickLight");
		reg.registerBlock(glassViewer = (new XBlockViewer(Material.glass, "glassViewer")), "glassViewer");
		reg.registerBlock(brickSmallBlue = (new XBlockBrickSmall(Material.iron, "brickSmallBlue")), "brickSmallBlue");
		reg.registerBlock(brickSmallGreen = (new XBlockBrickSmall(Material.iron, "brickSmallGreen")), "brickSmallGreen");
		reg.registerBlock(brickSmallRed = (new XBlockBrickSmall(Material.iron, "brickSmallRed")), "brickSmallRed");
		reg.registerBlock(brickSmallDark = (new XBlockBrickSmall(Material.iron, "brickSmallDark")), "brickSmallDark");
		reg.registerBlock(brickSmallLight = (new XBlockBrickSmall(Material.iron, "brickSmallLight")), "brickSmallLight");
		reg.registerBlock(strucBlack = (new XBlockStructure(Material.iron, "strucBlack")), "strucBlack");
		reg.registerBlock(strucRed = (new XBlockStructure(Material.iron, "strucRed")), "strucRed");
		reg.registerBlock(strucGreen = (new XBlockStructure(Material.iron, "strucGreen")), "strucGreen");
		reg.registerBlock(strucBrown = (new XBlockStructure(Material.iron, "strucBrown")), "strucBrown");
		reg.registerBlock(strucBlue = (new XBlockStructure(Material.iron, "strucBlue")), "strucBlue");
		reg.registerBlock(strucPurple = (new XBlockStructure(Material.iron, "strucPurple")), "strucPurple");
		reg.registerBlock(strucCyan = (new XBlockStructure(Material.iron, "strucCyan")), "strucCyan");
		reg.registerBlock(strucLightGray = (new XBlockStructure(Material.iron, "strucLightGray")), "strucLightGray");
		reg.registerBlock(strucGray = (new XBlockStructure(Material.iron, "strucGray")), "strucGray");
		reg.registerBlock(strucPink = (new XBlockStructure(Material.iron, "strucPink")), "strucPink");
		reg.registerBlock(strucLime = (new XBlockStructure(Material.iron, "strucLime")), "strucLime");
		reg.registerBlock(strucYellow = (new XBlockStructure(Material.iron, "strucYellow")), "strucYellow");
		reg.registerBlock(strucLightBlue = (new XBlockStructure(Material.iron, "strucLightBlue")), "strucLightBlue");
		reg.registerBlock(strucMagenta = (new XBlockStructure(Material.iron, "strucMagenta")), "strucMagenta");
		reg.registerBlock(strucOrange = (new XBlockStructure(Material.iron, "strucOrange")), "strucOrange");
		reg.registerBlock(strucWhite = (new XBlockStructure(Material.iron, "strucWhite")), "strucWhite");
		reg.registerBlock(platBlack = (new XBlockPlatform(Material.iron, "platBlack")), "platBlack");
		reg.registerBlock(platRed = (new XBlockPlatform(Material.iron, "platRed")), "platRed");
		reg.registerBlock(platGreen = (new XBlockPlatform(Material.iron, "platGreen")), "platGreen");
		reg.registerBlock(platBrown = (new XBlockPlatform(Material.iron, "platBrown")), "platBrown");
		reg.registerBlock(platBlue = (new XBlockPlatform(Material.iron, "platBlue")), "platBlue");
		reg.registerBlock(platPurple = (new XBlockPlatform(Material.iron, "platPurple")), "platPurple");
		reg.registerBlock(platCyan = (new XBlockPlatform(Material.iron, "platCyan")), "platCyan");
		reg.registerBlock(platLightGray = (new XBlockPlatform(Material.iron, "platLightGray")), "platLightGray");
		reg.registerBlock(platGray = (new XBlockPlatform(Material.iron, "platGray")), "platGray");
		reg.registerBlock(platPink = (new XBlockPlatform(Material.iron, "platPink")), "platPink");
		reg.registerBlock(platLime = (new XBlockPlatform(Material.iron, "platLime")), "platLime");
		reg.registerBlock(platYellow = (new XBlockPlatform(Material.iron, "platYellow")), "platYellow");
		reg.registerBlock(platLightBlue = (new XBlockPlatform(Material.iron, "platLightBlue")), "platLightBlue");
		reg.registerBlock(platMagenta = (new XBlockPlatform(Material.iron, "platMagenta")), "platMagenta");
		reg.registerBlock(platOrange = (new XBlockPlatform(Material.iron, "platOrange")), "platOrange");
		reg.registerBlock(platWhite = (new XBlockPlatform(Material.iron, "platWhite")), "platWhite");
		reg.registerBlock(shieldBlack = (new XBlockShield(Material.iron, "shieldBlack")), "shieldBlack");
		reg.registerBlock(shieldRed = (new XBlockShield(Material.iron, "shieldRed")), "shieldRed");
		reg.registerBlock(shieldGreen = (new XBlockShield(Material.iron, "shieldGreen")), "shieldGreen");
		reg.registerBlock(shieldBrown = (new XBlockShield(Material.iron, "shieldBrown")), "shieldBrown");
		reg.registerBlock(shieldBlue = (new XBlockShield(Material.iron, "shieldBlue")), "shieldBlue");
		reg.registerBlock(shieldPurple = (new XBlockShield(Material.iron, "shieldPurple")), "shieldPurple");
		reg.registerBlock(shieldCyan = (new XBlockShield(Material.iron, "shieldCyan")), "shieldCyan");
		reg.registerBlock(shieldLightGray = (new XBlockShield(Material.iron, "shieldLightGray")), "shieldLightGray");
		reg.registerBlock(shieldGray = (new XBlockShield(Material.iron, "shieldGray")), "shieldGray");
		reg.registerBlock(shieldPink = (new XBlockShield(Material.iron, "shieldPink")), "shieldPink");
		reg.registerBlock(shieldLime = (new XBlockShield(Material.iron, "shieldLime")), "shieldLime");
		reg.registerBlock(shieldYellow = (new XBlockShield(Material.iron, "shieldYellow")), "shieldYellow");
		reg.registerBlock(shieldLightBlue = (new XBlockShield(Material.iron, "shieldLightBlue")), "shieldLightBlue");
		reg.registerBlock(shieldMagenta = (new XBlockShield(Material.iron, "shieldMagenta")), "shieldMagenta");
		reg.registerBlock(shieldOrange = (new XBlockShield(Material.iron, "shieldOrange")), "shieldOrange");
		reg.registerBlock(shieldWhite = (new XBlockShield(Material.iron, "shieldWhite")), "shieldWhite");
		reg.registerBlock(cropCorn = (new XCropCorn("corn", "0B", "1B", "2B", "3B", "4B", "0T")), "corn");
	}

}
