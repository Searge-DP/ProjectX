package dca.projectx.machine.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import dca.projectx.machine.XMachineBlocks;
import dca.projectx.machine.XMachineItems;
import dca.projectx.machine.block.tile.TilePulsePipe;
import dca.projectx.machine.block.tile.TilePulsePipeT1;
import dca.projectx.machine.block.tile.TilePulsePipeT2;
import dca.projectx.machine.block.tile.TilePulsePipeT3;
import dca.projectx.machine.block.tile.TileEngineeringTable;
import dca.projectx.machine.block.tile.TilePulseNodeT1;
import dca.projectx.machine.block.tile.TilePulseNodeT2;
import dca.projectx.machine.block.tile.TilePulseNodeT3;
import dca.projectx.machine.block.tile.TilePulseRelayT1;
import dca.projectx.machine.block.tile.TilePulseRelayT2;
import dca.projectx.machine.block.tile.TilePulseRelayT3;
import dca.projectx.machine.render.RenderEnergyPipe;
import dca.projectx.machine.render.RenderEngineeringTable;
import dca.projectx.machine.render.RenderPulseNode;
import dca.projectx.machine.render.item.IREnergyCore;
import dca.projectx.machine.render.item.IREnergyPipeT1;
import dca.projectx.machine.render.item.IREnergyPipeT2;
import dca.projectx.machine.render.item.IREnergyPipeT3;
import dca.projectx.machine.render.item.IREngineeringTable;
import dca.projectx.machine.render.item.IRPulseNodeT1;
import dca.projectx.machine.render.item.IRPulseNodeT2;
import dca.projectx.machine.render.item.IRPulseNodeT3;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class MClientProxy extends MCommonProxy {
	
	@Override
	public void preInit(){
		
	}
	
	@Override
	public void init(){
        //Engineering Table
        TileEntitySpecialRenderer renderET = new RenderEngineeringTable();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEngineeringTable.class, renderET);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.engineeringTable), new IREngineeringTable(
		renderET, new TileEngineeringTable()));
		
		//Energy Node's
		TileEntitySpecialRenderer renderENT1 = new RenderPulseNode(0F, 1F, 0F);
		ClientRegistry.bindTileEntitySpecialRenderer(TilePulseNodeT1.class, renderENT1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyNodeT1), new IRPulseNodeT1(
		new TilePulseNodeT1()));
		
		TileEntitySpecialRenderer renderENT2 = new RenderPulseNode(0F, 0F, 1F);
		ClientRegistry.bindTileEntitySpecialRenderer(TilePulseNodeT2.class, renderENT2);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyNodeT2), new IRPulseNodeT2(
		new TilePulseNodeT2()));
		
		TileEntitySpecialRenderer renderENT3 = new RenderPulseNode(1F, 0F, 0F);
		ClientRegistry.bindTileEntitySpecialRenderer(TilePulseNodeT3.class, renderENT3);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyNodeT3), new IRPulseNodeT3(
		new TilePulseNodeT3()));
		
		//Energy Pipe's
		TileEntitySpecialRenderer renderEPT1 = new RenderEnergyPipe(0F, 1F, 0F);
		ClientRegistry.bindTileEntitySpecialRenderer(TilePulsePipeT1.class, renderEPT1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyPipeT1), new IREnergyPipeT1(
		renderEPT1, new TilePulsePipeT1()));
		
		TileEntitySpecialRenderer renderEPT2 = new RenderEnergyPipe(0F, 0F, 1F);
		ClientRegistry.bindTileEntitySpecialRenderer(TilePulsePipeT2.class, renderEPT2);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyPipeT2), new IREnergyPipeT2(
		renderEPT2, new TilePulsePipeT2()));
		
		TileEntitySpecialRenderer renderEPT3 = new RenderEnergyPipe(1F, 0F, 0F);
		ClientRegistry.bindTileEntitySpecialRenderer(TilePulsePipeT3.class, renderEPT3);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(XMachineBlocks.energyPipeT3), new IREnergyPipeT3(
		renderEPT3, new TilePulsePipeT3()));
		
		//Energy Core's
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreT1, new IREnergyCore(0F, 1F, 0F));
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreT2, new IREnergyCore(0F, 0F, 1F));
		MinecraftForgeClient.registerItemRenderer(XMachineItems.energyCoreT3, new IREnergyCore(1F, 0F, 0F));
	}
	
	@Override
	public void postInit(){
		
	}

}
