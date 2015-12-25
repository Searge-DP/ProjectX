package dca.projectx.machine.render;

import org.lwjgl.opengl.GL11;
import dca.projectx.core.ProjectX;
import dca.projectx.machine.block.tile.TileEnergyPipe;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

public class RenderEnergyPipe extends TileEntitySpecialRenderer {
	
	public static ResourceLocation texture;
	public static float pixel = 1F/16F;
	public static float texturePixel = 1F/32F;
	public static boolean drawInside = true;
	public float r;
	public float g;
	public float b;
	
	public RenderEnergyPipe(float r, float g, float b){
		this.texture = new ResourceLocation(ProjectX.INSTANCE, "textures/models/pipe.png");
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
		TileEnergyPipe pipe = (TileEnergyPipe)tile;
		
		GL11.glTranslated(x, y, z);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(texture);
		
		if(!pipe.onlyOneOpposite(pipe.connections)){
			drawCore(tile);
			for(int i = 0; i < pipe.connections.length; i++){
				if(pipe.connections[i] != null){
					drawConnection(pipe.connections[i]);
				}
			}
		}
		
		else{
			for(int i = 0; i < pipe.connections.length; i++){
				if(pipe.connections[i] != null){
					drawStraight(pipe.connections[i]);
					break;
				}
			}
		}
		
		for(int i = 0; i < pipe.connections.length; i++){
			if(pipe.connections[i] != null){
				drawConnection(pipe.connections[i]);
			}
		}
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-x, -y, -z);
	}
	
	public void drawCore(TileEntity tile){
		Tessellator tess = Tessellator.instance;
		
		tess.startDrawing(GL11.GL_QUADS);
		tess.setBrightness(0x00F000F0);
		tess.setColorOpaque_F(this.r+0.1F, this.g+0.1F, this.b+0.1F);
		
		tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
		
		tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
		
		tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
		
		tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
		
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
		
		tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
		
		if(drawInside = true){
			tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 1-11*pixel/2, 0*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 11*pixel/2, 11*pixel/2, 0*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		}
		
		tess.draw();
	}
	
	public void drawConnection(ForgeDirection direction){
		Tessellator tess = Tessellator.instance;
		
		tess.startDrawing(GL11.GL_QUADS);
		tess.setBrightness(0x00F000F0);
		tess.setColorOpaque_F(this.r, this.g, this.b);
		
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if(direction.equals(ForgeDirection.UP)){
			//ROTATE
		}
		else if(direction.equals(ForgeDirection.DOWN)){
			GL11.glRotatef(180, 1, 0, 0);
		}
		else if(direction.equals(ForgeDirection.SOUTH)){
			GL11.glRotatef(90, 1, 0, 0);
		}
		else if(direction.equals(ForgeDirection.NORTH)){
			GL11.glRotatef(270, 1, 0, 0);
		}
		else if(direction.equals(ForgeDirection.WEST)){
			GL11.glRotatef(90, 0, 0, 1);
		}
		else if(direction.equals(ForgeDirection.EAST)){
			GL11.glRotatef(270, 0, 0, 1);
		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
		
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
		
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
		
		if(drawInside = true){
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 11*pixel/2, 5*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 10*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 5*texturePixel, 5*texturePixel);
		}
		
		tess.draw();
		
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if(direction.equals(ForgeDirection.UP)){
			//ROTATE
		}
		else if(direction.equals(ForgeDirection.DOWN)){
			GL11.glRotatef(-180, 1, 0, 0);
		}
		else if(direction.equals(ForgeDirection.SOUTH)){
			GL11.glRotatef(-90, 1, 0, 0);
		}
		else if(direction.equals(ForgeDirection.NORTH)){
			GL11.glRotatef(-270, 1, 0, 0);
		}
		else if(direction.equals(ForgeDirection.WEST)){
			GL11.glRotatef(-90, 0, 0, 1);
		}
		else if(direction.equals(ForgeDirection.EAST)){
			GL11.glRotatef(-270, 0, 0, 1);
		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	}
	
	public void drawStraight(ForgeDirection direction){
		Tessellator tess = Tessellator.instance;
		
		tess.startDrawing(GL11.GL_QUADS);
		tess.setBrightness(0x00F000F0);
		tess.setColorOpaque_F(this.r, this.g, this.b);
		
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if(direction.equals(ForgeDirection.SOUTH)||direction.equals(ForgeDirection.NORTH)){
			GL11.glRotatef(90, 1, 0, 0);
		}
		else if(direction.equals(ForgeDirection.WEST)||direction.equals(ForgeDirection.EAST)){
			GL11.glRotatef(90, 0, 0, 1);
		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		tess.addVertexWithUV(1-11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
		
		tess.addVertexWithUV(11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 0*texturePixel);
		
		tess.addVertexWithUV(1-11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(1-11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
		
		tess.addVertexWithUV(11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 5*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 0*texturePixel);
		tess.addVertexWithUV(11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 0*texturePixel);
		
		if(drawInside = true){
			tess.addVertexWithUV(11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(1-11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(1-11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(1-11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 5*texturePixel);
			
			tess.addVertexWithUV(11*pixel/2, 0, 11*pixel/2, 10*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1, 11*pixel/2, 26*texturePixel, 0*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 1, 1-11*pixel/2, 26*texturePixel, 5*texturePixel);
			tess.addVertexWithUV(11*pixel/2, 0, 1-11*pixel/2, 10*texturePixel, 5*texturePixel);
		}
		
		tess.draw();
		
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if(direction.equals(ForgeDirection.SOUTH)||direction.equals(ForgeDirection.NORTH)){
			GL11.glRotatef(-90, 1, 0, 0);
		}
		else if(direction.equals(ForgeDirection.WEST)||direction.equals(ForgeDirection.EAST)){
			GL11.glRotatef(-90, 0, 0, 1);
		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	}

}
