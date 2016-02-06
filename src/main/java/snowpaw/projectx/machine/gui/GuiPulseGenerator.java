package snowpaw.projectx.machine.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.machine.container.ContainerPulseGenerator;
import snowpaw.projectx.machine.tile.TileXPulseGenerator;

public class GuiPulseGenerator extends GuiContainer {
	
	private TileXPulseGenerator tileEntity;
	
    public GuiPulseGenerator(InventoryPlayer invPlayer, TileXPulseGenerator tileEntity) {
        super(new ContainerPulseGenerator(invPlayer, tileEntity));

        this.tileEntity = tileEntity;
    }
    
    protected void drawGuiContainerForegroundLayer(int par1, int par2){
        String name = tileEntity.hasCustomInventoryName() ? tileEntity.getInventoryName() : I18n.format(tileEntity.getInventoryName());

        if (tileEntity.energyOutGui <= TileXPulseGenerator.energyPerTick) {
            String out = tileEntity.energyOutGui + " Pulse/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0x404040);
        }
        else {
            String out = TileXPulseGenerator.energyPerTick + " Pulse/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0xFF0000);
        }

        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 94, 4210752);
        fontRendererObj.drawString("Out:", 111 - fontRendererObj.getStringWidth("Out:"), ySize - 94, 0x404040);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        mc.getTextureManager().bindTexture(new ResourceLocation(ProjectX.INSTANCE, "textures/gui/gui_generator.png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        int i = tileEntity.getEnergyScaled(13);
        if (i > -1)
            drawTexturedModalRect(x + 80, y + 25 + 12 - i, 176, 12 - i, 14, i + 2);
    }

}
