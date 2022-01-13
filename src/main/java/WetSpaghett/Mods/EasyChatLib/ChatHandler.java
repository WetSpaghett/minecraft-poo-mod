package WetSpaghett.Mods.EasyChatLib;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.*;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.ITextComponent;

public class ChatHandler {
    /** Sends a message to all players on the server.
     * Run serverside. */
    public static void chatMessage(String message) {
        MinecraftServer mcServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        PlayerList pl = mcServer.getPlayerList();
        ITextComponent msg = new TextComponentTranslation(message);
        pl.sendMessage(msg, true);
    }


     /** Sends a message to a specific player.*/
    public static void clientChatMessage(String message, EntityPlayer pl) {
        ITextComponent msg = new TextComponentTranslation(message);
        pl.sendMessage(msg);
    }

    /** Makes player send a message. Can make players run commands.
     * Will crash the game if run serverside. */
    public static void playerSendChatMessage(String message, EntityPlayerSP pl) {
        pl.sendChatMessage(message);
    }
}