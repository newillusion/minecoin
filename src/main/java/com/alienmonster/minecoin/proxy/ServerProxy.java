package com.alienmonster.minecoin.proxy;

import com.alienmonster.minecoin.*;
import com.alienmonster.minecoin.cap.CAPCustomInventory;
import com.alienmonster.minecoin.cap.CAPCustomInventoryStorage;
import com.alienmonster.minecoin.cap.CapabilityEventHandler;
import com.alienmonster.minecoin.cap.ICAPCustomInventory;
import com.alienmonster.minecoin.registry.BlockRegistry;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ServerProxy {

	public void preInit(FMLPreInitializationEvent event) {
		BlockRegistry.register();
		NetworkHandler.init();
	}
	
	public void init(FMLInitializationEvent event) {
		CapabilityManager.INSTANCE.register(ICAPCustomInventory.class, new CAPCustomInventoryStorage(), CAPCustomInventory.class);
		NetworkRegistry.INSTANCE.registerGuiHandler(MineCoin.INSTANCE, new GuiHandler());
		CapabilityEventHandler.register();

	}
	
	public void postInit() {
	}
}
