package com.alienmonster.minecoin.inventory;

import com.alienmonster.minecoin.MineCoin;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUICustomInv extends GuiContainer {
	
	private float oldMouseX;
	private float oldMouseY;

	private static final ResourceLocation INVENTORY_GUI_TEXTURE =
			new ResourceLocation(MineCoin.MOD_ID + ":textures/gui/inventory_gui_custom1.png");

	public GUICustomInv(EntityPlayer player, InventoryPlayer inventoryPlayer, CustomInventory cInventory) {
		super(new ContainerCustomInv(inventoryPlayer, cInventory, player));
	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	    super.drawScreen(mouseX, mouseY, partialTicks);
	    this.oldMouseX = (float)mouseX;
	    this.oldMouseY = (float)mouseY;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	    this.mc.getTextureManager().bindTexture(INVENTORY_GUI_TEXTURE);
	    int i = this.guiLeft;
	    int j = this.guiTop;
	    this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	    // Draw some entity (No need more)
	    /*
		if (drawEntity == null) {
			drawEntity = new EntityZombieHorse(mc.world);
		}

	    GuiInventory.drawEntityOnScreen(i + 55, j + 75, 30, (float)(i + 51) - this.oldMouseX,
				(float)(j + 75 - 50) - this.oldMouseY, drawEntity);
		*/
	}
}
