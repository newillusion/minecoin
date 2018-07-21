package com.alienmonster.minecoin.registry;

import com.alienmonster.minecoin.block.InterfaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRegistry {
	public static final Block INTERFACE_BLOCK = new InterfaceBlock("interface_block",
			Material.ROCK, 5.0f, 5.0f, SoundType.STONE);

	public static void register() {
		setBlockRegister(INTERFACE_BLOCK);
		setItemBlockRegister(INTERFACE_BLOCK);

		GameRegistry.registerTileEntity(((InterfaceBlock)INTERFACE_BLOCK).getTileEntityClass(),
				INTERFACE_BLOCK.getRegistryName().toString());
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender() {

		setItemBlockRender(INTERFACE_BLOCK);
	}

	private static void setBlockRegister(Block block) {

		ForgeRegistries.BLOCKS.register(block);
	}

	private static void setItemBlockRegister(Block block) {

		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	private static void setItemBlockRender(Block block) {

		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
