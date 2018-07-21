package com.alienmonster.minecoin.inventory;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ContainerCustomInv  extends Container
{
    private static final EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[]
			{ EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET };

    private final EntityPlayer thePlayer;

    public ContainerCustomInv(InventoryPlayer playerInventory, CustomInventory cInventory, EntityPlayer player)
	{
        
        this.thePlayer = player;

        // Add my custom slots.
        this.addSlotToContainer(new StandartSlot(player, cInventory, 0, 53,  23));
		this.addSlotToContainer(new StandartSlot(player, cInventory, 1, 71,  23));
		this.addSlotToContainer(new StandartSlot(player, cInventory, 2, 89,  23));
		this.addSlotToContainer(new StandartSlot(player, cInventory, 3, 107, 23));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 4, 53,  45));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 5, 71,  45));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 6, 89,  45));
        this.addSlotToContainer(new StandartSlot(player, cInventory, 7, 107, 45));

        // Main inventory slots.
        for (int l = 0; l < 3; ++l)
        {
            for (int j1 = 0; j1 < 9; ++j1)
            {
                this.addSlotToContainer(new Slot(playerInventory, (j1 + (l + 1) * 9) - 0, 8 + j1 * 18, 84 + l * 18));
            }
        }

        // Bottom slots. Hotbar.
        for (int i = 0; i < 9; ++i)
        {
			this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
    }

    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            
            itemstack = itemstack1.copy();

            if (index < 12) {

                if (!this.mergeItemStack(itemstack1, 12, 48, true)) {
                	
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index > 11)
            {
            	if (itemstack1.getItem() instanceof ItemArmor)
            	{
            		if (!this.mergeItemStack(itemstack1, 8, 12, false)){
                        return ItemStack.EMPTY;
                    }
            		
            	}
            	else
            		if (index >= 12 && index < 39)
            		{
	                    if (!this.mergeItemStack(itemstack1, 39, 48, false))
	                    {
	                        return ItemStack.EMPTY;
	                    }
                	}
                	else
					{
						if (index >= 39 && index < 48 && !this.mergeItemStack(itemstack1, 12, 39, false)) {
							return ItemStack.EMPTY;
						}
					}
            }        

            if (itemstack1.getCount() == 0){
                slot.putStack(ItemStack.EMPTY);
            }
            else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()){
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {

    	// playerIn.inventory.
		return true;
	}
}
