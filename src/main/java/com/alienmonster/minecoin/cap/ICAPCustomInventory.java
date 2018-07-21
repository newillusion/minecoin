package com.alienmonster.minecoin.cap;

import com.alienmonster.minecoin.inventory.CustomInventory;

public interface ICAPCustomInventory {
	void copyInventory(ICAPCustomInventory inventory);
	CustomInventory getInventory();
}
