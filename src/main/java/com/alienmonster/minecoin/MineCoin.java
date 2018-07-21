package com.alienmonster.minecoin;

import com.alienmonster.minecoin.proxy.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MineCoin.MOD_ID, name = MineCoin.MOD_NAME, version = "1.0.0")
public class MineCoin {
	public static final String MOD_ID = "minecoin";
	public static final String MOD_NAME = "MineCoin";

	@Mod.Instance("minecoin")
	public static MineCoin INSTANCE;

	enum StringResources {

		ONE("one"),
		TWO("two"),
		THREE("three");

		public String value;

		StringResources(String value) {
			this.value = value;
		}
	}

	@SidedProxy(clientSide = "com.alienmonster.minecoin.proxy.ClientProxy", serverSide = "com.alienmonster.minecoin.proxy.ServerProxy")
	public static ServerProxy proxy;

	public MineCoin() {
		System.out.println(StringResources.ONE.value);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
	   proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {

	   proxy.init(e);
	}
}
