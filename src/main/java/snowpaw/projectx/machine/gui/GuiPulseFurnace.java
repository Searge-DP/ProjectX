package snowpaw.projectx.machine.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import snowpaw.projectx.core.ProjectX;
import snowpaw.projectx.machine.container.ContainerPulseFurnace;
import snowpaw.projectx.machine.tile.TileXPulseFurnace;

public class GuiPulseFurnace extends GuiContainer {
	
	private TileXPulseFurnace tileEntity;
	
    public GuiPulseFurnace(InventoryPlayer invPlayer, TileXPulseFurnace tileEntity) {
        super(new ContainerPulseFurnace(invPlayer, tileEntity));

        this.tileEntity = tileEntity;
    }
    
    protected void drawGuiContainerForegroundLayer(int par1, int par2){
        String name = tileEntity.hasCustomInventoryName() ? tileEntity.getInventoryName() : I18n.format(tileEntity.getInventoryName());

        if (tileEntity.energyInGui > 0 && tileEntity.energyInGui < TileXPulseFurnace.energyPerTick) {
            String out = tileEntity.energyInGui + " Pulse/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0xFF0000);
        }
        else if (tileEntity.energyInGui == -1) {
            String out = "0 HEX/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0xFF0000);
        }
        else if (tileEntity.energyInGui == TileXPulseFurnace.energyPerTick) {
            String out = tileEntity.energyInGui + " Pulse/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0x00FF00);
        }
        else {
            String out = tileEntity.energyInGui + " Pulse/t";
            fontRendererObj.drawString(out, 142 - fontRendererObj.getStringWidth(out) / 2, ySize - 94, 0x404040);
        }

        fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 94, 0x404040);
        fontRendererObj.drawString("In:", 111 - fontRendererObj.getStringWidth("In:"), ySize - 94, 0x404040);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        mc.getTextureManager().bindTexture(new ResourceLocation(ProjectX.INSTANCE, "textures/gui/gui_furnace.png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        int i = tileEntity.getEnergyScaled(35);
        drawTexturedModalRect(x + 70, y + 35, 176, 0, i + 1, 16);
    }

}
