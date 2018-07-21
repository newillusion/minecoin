package com.alienmonster.minecoin;


import com.alienmonster.minecoin.inventory.OpenInventoryMessage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	
	public static SimpleNetworkWrapper network;

	public static void init() {
		network = NetworkRegistry.INSTANCE.newSimpleChannel(MineCoin.MOD_ID);
		network.registerMessage(OpenInventoryMessage.Handler.class, OpenInventoryMessage.class, 0, Side.SERVER);
	}	
}
