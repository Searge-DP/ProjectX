package snowpaw.projectx.machine.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import snowpaw.projectx.machine.tile.TileEngineeringTable;

public class GuiEngineeringTable extends GuiContainer {
	
	private TileEngineeringTable tile;

	public GuiEngineeringTable(Container container) {
		super(container);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y){
		String name = I18n.format("projectx.container.engineeringTable");
		
		fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
		fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 94, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int x, int y) {
		
	}

}
