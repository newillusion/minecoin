package com.alienmonster.minecoin.inventory;

import com.alienmonster.minecoin.GuiHandler;
import com.alienmonster.minecoin.MineCoin;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class OpenInventoryMessage implements IMessage {
    public OpenInventoryMessage() { }

    @Override
    public void fromBytes(ByteBuf buf) {
      
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<OpenInventoryMessage, IMessage> {

        @Override
        public IMessage onMessage(OpenInventoryMessage message, MessageContext ctx) {
        	EntityPlayerMP player = ctx.getServerHandler().player;
        	player.openGui(MineCoin.INSTANCE, GuiHandler.INVENTORY_GUI_ID, player.getEntityWorld(), (int)player.posX, (int)player.posY, (int)player.posZ);
            return null; 
        }
    }
}