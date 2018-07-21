package com.alienmonster.minecoin.proxy;

import com.alienmonster.minecoin.KeyHandler;
import com.alienmonster.minecoin.registry.BlockRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ServerProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
	    super.preInit(event);
	    BlockRegistry.registerRender();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);

		KeyHandler.register();
	}

	@Override
	public void postInit() {
	   
		super.postInit();
	}
}
