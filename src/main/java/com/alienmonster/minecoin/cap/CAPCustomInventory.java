package com.alienmonster.minecoin.cap;

import com.alienmonster.minecoin.inventory.CustomInventory;

public class CAPCustomInventory implements ICAPCustomInventory {

	public final CustomInventory inventory = new CustomInventory();

	public CustomInventory getInventory(){
		
		return this.inventory;
	}

	@Override
	public void copyInventory(ICAPCustomInventory inventory) {
		
		this.inventory.copy(inventory.getInventory());
	}

}
