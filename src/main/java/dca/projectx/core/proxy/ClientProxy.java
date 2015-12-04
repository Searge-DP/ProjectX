package dca.projectx.core.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import dca.projectx.core.ProjectX;
import dca.projectx.core.render.RenderEngineeringTable;
import dca.projectx.core.render.RenderGlow;
import dca.projectx.core.render.item.IREnergyCore;
import dca.projectx.core.render.item.IREngineeringTable;
import dca.projectx.machine.XMachineBlocks;
import dca.projectx.machine.XMachineItems;
import dca.projectx.machine.block.tile.TileEngineeringTable;
import dca.projectx.util.ItemUtil;
import dca.projectx.util.XColors;
import dca.projectx.world.XWorldItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
    public static int renderID[] = new int[ProjectX.countBlocks];
    public static int renderPass[] = new int[ProjectX.countBlocks];
	
	@Override
	public void preInit(){

	}
	
	@Override
	public void init(){
		ProjectX.idCounter = 0;
		
		//Ores
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Storage Blocks
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Bricks
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Glass Viewer - Dummy
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Small Bricks
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Structures
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBrownR, XColors.colorBrownG, XColors.colorBrownB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPurpleR, XColors.colorPurpleG, XColors.colorPurpleB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorCyanR, XColors.colorCyanG, XColors.colorCyanB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightGrayR, XColors.colorLightGrayG, XColors.colorLightGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGrayR, XColors.colorGrayG, XColors.colorGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPinkR, XColors.colorPinkG, XColors.colorPinkB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLimeR, XColors.colorLimeG, XColors.colorLimeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorYellowR, XColors.colorYellowG, XColors.colorYellowB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightBlueR, XColors.colorLightBlueG, XColors.colorLightBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorMagentaR, XColors.colorMagentaG, XColors.colorMagentaB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorOrangeR, XColors.colorOrangeG, XColors.colorOrangeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Platforms
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBrownR, XColors.colorBrownG, XColors.colorBrownB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPurpleR, XColors.colorPurpleG, XColors.colorPurpleB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorCyanR, XColors.colorCyanG, XColors.colorCyanB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightGrayR, XColors.colorLightGrayG, XColors.colorLightGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGrayR, XColors.colorGrayG, XColors.colorGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPinkR, XColors.colorPinkG, XColors.colorPinkB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLimeR, XColors.colorLimeG, XColors.colorLimeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorYellowR, XColors.colorYellowG, XColors.colorYellowB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightBlueR, XColors.colorLightBlueG, XColors.colorLightBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorMagentaR, XColors.colorMagentaG, XColors.colorMagentaB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorOrangeR, XColors.colorOrangeG, XColors.colorOrangeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Shields
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlackR, XColors.colorBlackG, XColors.colorBlackB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorRedR, XColors.colorRedG, XColors.colorRedB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGreenR, XColors.colorGreenG, XColors.colorGreenB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBrownR, XColors.colorBrownG, XColors.colorBrownB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorBlueR, XColors.colorBlueG, XColors.colorBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPurpleR, XColors.colorPurpleG, XColors.colorPurpleB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorCyanR, XColors.colorCyanG, XColors.colorCyanB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightGrayR, XColors.colorLightGrayG, XColors.colorLightGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorGrayR, XColors.colorGrayG, XColors.colorGrayB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorPinkR, XColors.colorPinkG, XColors.colorPinkB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLimeR, XColors.colorLimeG, XColors.colorLimeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorYellowR, XColors.colorYellowG, XColors.colorYellowB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorLightBlueR, XColors.colorLightBlueG, XColors.colorLightBlueB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorMagentaR, XColors.colorMagentaG, XColors.colorMagentaB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorOrangeR, XColors.colorOrangeG, XColors.colorOrangeB));
        
        renderID[ProjectX.idCounter] = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderGlow(renderID[ProjectX.idCounter],
        XColors.colorWhiteR, XColors.colorWhiteG, XColors.colorWhiteB));
        
        //Engineering Table
        TileEntitySpecialRenderer renderET = new RenderEngineeringTable();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEngineeringTable.class, renderET);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.engineeringTable), new IREngineeringTable(
		renderET, new TileEngineeringTable()));
		
		//Energy Core's
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreMK1, new IREnergyCore(0F, 1F, 0F));
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreMK2, new IREnergyCore(0F, 0F, 1F));
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreMK3, new IREnergyCore(1F, 0F, 0F));
	}
	
	@Override
	public void postInit(){
		
	}

}
