package dca.projectx.machine.gui;

import dca.projectx.machine.block.tile.TileEngineeringTable;
import dca.projectx.machine.container.ContainerEngineeringTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import snowpaw.projectx.core.ProjectX;

public class GuiEngineeringTable extends GuiContainer {
	
	public static final int guiSizeX = 0;
	public static final int guiSizeY = 0;
	public TileEngineeringTable tile;

	public GuiEngineeringTable(InventoryPlayer invPlayer, TileEngineeringTable tile) {
		super(new ContainerEngineeringTable());
		this.tile = tile;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		mc.getTextureManager().bindTexture(new ResourceLocation(ProjectX.INSTANCE, "textures/gui/guiEngineeringTable.png"));
		int x = (width - guiSizeX) / 2;
		int y = (height - guiSizeY) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, guiSizeX, guiSizeY);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = "Engineering Table";
		fontRendererObj.drawString(name, guiSizeX / 2 - fontRendererObj.getStringWidth(name), guiSizeY - 94, 0x404040);
	}

}
