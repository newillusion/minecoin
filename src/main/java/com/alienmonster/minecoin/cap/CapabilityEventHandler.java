package com.alienmonster.minecoin.cap;

import com.alienmonster.minecoin.inventory.CustomInventory;
import com.alienmonster.minecoin.MineCoin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityEventHandler {
	
	public static void register(){
		MinecraftForge.EVENT_BUS.register(new CapabilityEventHandler());
	}
	
	public static final ResourceLocation INVENTORY_CAP = new ResourceLocation(MineCoin.MOD_ID, "inventory");

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayer){
			event.addCapability(INVENTORY_CAP, new CAPCustomInventoryProvider());
		}
	}

	@SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
		
        EntityPlayer player = event.getEntityPlayer();
        ICAPCustomInventory newCap = player.getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);
        ICAPCustomInventory oldCap = event.getOriginal().getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);

        newCap.copyInventory(oldCap);

    }

	@SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
		
		if(event.getEntity() instanceof EntityPlayer) {

			EntityPlayer player = (EntityPlayer)event.getEntity();
			ICAPCustomInventory cap = player.getCapability(CAPCustomInventoryProvider.INVENTORY_CAP, null);
			CustomInventory inv = cap.getInventory();

			dropAllItems(player, inv);
			inv.clear();
		}	 
    }
	
	private static void dropAllItems(EntityPlayer player, CustomInventory inventory){
		NonNullList<ItemStack> aitemstack = inventory.getStacks();
		for (ItemStack anAitemstack : aitemstack) {
			if (!anAitemstack.isEmpty()) {
				player.dropItem(anAitemstack, true, false);
			}
		}
	}
}
