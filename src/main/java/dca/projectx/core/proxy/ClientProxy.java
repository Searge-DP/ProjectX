package dca.projectx.core.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import dca.projectx.core.ProjectX;
import dca.projectx.core.render.RenderEnergyPipe;
import dca.projectx.core.render.RenderEngineeringTable;
import dca.projectx.core.render.RenderGenerator;
import dca.projectx.core.render.RenderGlow;
import dca.projectx.core.render.RenderXNode;
import dca.projectx.core.render.RenderXRelay;
import dca.projectx.core.render.item.IREnergyCore;
import dca.projectx.core.render.item.IREnergyPipe;
import dca.projectx.core.render.item.IREngineeringTable;
import dca.projectx.core.render.item.IRGenerator;
import dca.projectx.core.render.item.IRXNodeT1;
import dca.projectx.core.render.item.IRXNodeT2;
import dca.projectx.core.render.item.IRXNodeT3;
import dca.projectx.core.render.item.IRXRelayT1;
import dca.projectx.core.render.item.IRXRelayT2;
import dca.projectx.core.render.item.IRXRelayT3;
import dca.projectx.machine.XMachineBlocks;
import dca.projectx.machine.XMachineItems;
import dca.projectx.machine.block.tile.TileEnergyPipe;
import dca.projectx.machine.block.tile.TileEngineeringTable;
import dca.projectx.machine.block.tile.TileGenerator;
import dca.projectx.machine.block.tile.TileXNodeT1;
import dca.projectx.machine.block.tile.TileXNodeT2;
import dca.projectx.machine.block.tile.TileXNodeT3;
import dca.projectx.machine.block.tile.TileXRelayT1;
import dca.projectx.machine.block.tile.TileXRelayT2;
import dca.projectx.machine.block.tile.TileXRelayT3;
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
		
		//Energy Node's
		TileEntitySpecialRenderer renderENT1 = new RenderXNode(0F, 1F, 0F);
		ClientRegistry.bindTileEntitySpecialRenderer(TileXNodeT1.class, renderENT1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyNodeT1), new IRXNodeT1(
		renderENT1, new TileXNodeT1()));
		
		TileEntitySpecialRenderer renderENT2 = new RenderXNode(0F, 0F, 1F);
		ClientRegistry.bindTileEntitySpecialRenderer(TileXNodeT2.class, renderENT2);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyNodeT2), new IRXNodeT2(
		renderENT2, new TileXNodeT2()));
		
		TileEntitySpecialRenderer renderENT3 = new RenderXNode(1F, 0F, 0F);
		ClientRegistry.bindTileEntitySpecialRenderer(TileXNodeT3.class, renderENT3);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyNodeT3), new IRXNodeT3(
		renderENT3, new TileXNodeT3()));
		
		//Energy Relay's
		TileEntitySpecialRenderer renderERT1 = new RenderXRelay(0F, 1F, 0F);
		ClientRegistry.bindTileEntitySpecialRenderer(TileXRelayT1.class, renderERT1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyRelayT1), new IRXRelayT1(
	    renderERT1, new TileXRelayT1()));
		
		TileEntitySpecialRenderer renderERT2 = new RenderXRelay(0F, 0F, 1F);
		ClientRegistry.bindTileEntitySpecialRenderer(TileXRelayT2.class, renderERT2);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyRelayT2), new IRXRelayT2(
	    renderERT2, new TileXRelayT2()));
		
		TileEntitySpecialRenderer renderERT3 = new RenderXRelay(1F, 0F, 0F);
		ClientRegistry.bindTileEntitySpecialRenderer(TileXRelayT3.class, renderERT3);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyRelayT3), new IRXRelayT3(
		renderERT3, new TileXRelayT3()));
		
		//Energy Pipe's
		TileEntitySpecialRenderer renderEP = new RenderEnergyPipe();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEnergyPipe.class, renderEP);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyPipe), new IREnergyPipe(
		renderEP, new TileEnergyPipe()));
		
		//Generator
		TileEntitySpecialRenderer renderG = new RenderGenerator();
		ClientRegistry.bindTileEntitySpecialRenderer(TileGenerator.class, renderG);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.generator), new IRGenerator(
		renderG, new TileGenerator()));
		
		//Energy Core's
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreT1, new IREnergyCore(0F, 1F, 0F));
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreT2, new IREnergyCore(0F, 0F, 1F));
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreT3, new IREnergyCore(1F, 0F, 0F));
	}
	
	@Override
	public void postInit(){
		
	}

}
