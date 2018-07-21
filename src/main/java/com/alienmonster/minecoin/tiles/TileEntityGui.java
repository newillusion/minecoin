package com.alienmonster.minecoin.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGui extends TileEntity {

	private static int count;
	private int id;

	public TileEntityGui() {
		this.id = count++;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("id", id);
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.id = compound.getInteger("id");
		super.readFromNBT(compound);
	}

	public int getId() {
		return this.id;
	}
}
