package com.alienmonster.minecoin.block;

import com.alienmonster.minecoin.KeyHandler;
import com.alienmonster.minecoin.tiles.TileEntityGui;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class InterfaceBlock extends BlockTileEntity<TileEntityGui> {
	public InterfaceBlock(String name, Material material, float hardness, float resistanse, SoundType soundType) {
		super(name, material, hardness, resistanse, soundType);
		// setRegistryName(name);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			TileEntityGui tileEntity = getTileEntity(worldIn, pos);
			KeyHandler.openInventory();
		}

		return true;
	}

	@Override
	public Class<TileEntityGui> getTileEntityClass() {
		return TileEntityGui.class;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityGui();
	}
}
