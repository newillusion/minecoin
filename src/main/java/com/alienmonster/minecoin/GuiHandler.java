package com.alienmonster.minecoin;

import com.alienmonster.minecoin.cap.CAPCustomInventoryProvider;
import com.alienmonster.minecoin.cap.ICAPCustomInventory;
import com.alienmonster.minecoin.inventory.ContainerCustomInv;
import com.alienmonster.minecoin.inventory.GUICustomInv;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import java.util.ArrayList;

public class GuiHandler implements IGuiHandler {
	
	public static final int INVENTORY_GUI_ID = 0;

	ArrayList<Integer> ids = new ArrayList<Integer>();

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		ICAPCustomInventory inv = player.getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);

		if (ids.contains(ID)) {
		} else {
		}

		if(ID == INVENTORY_GUI_ID) {
			return new ContainerCustomInv(player.inventory, inv.getInventory(), player);
		}
		return null;
	}

	private void register(int id) {
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ICAPCustomInventory inv = player.getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);
		
		if (ID == INVENTORY_GUI_ID) {
			return new GUICustomInv(player, player.inventory, inv.getInventory());
		}
		return null;
	}

}
