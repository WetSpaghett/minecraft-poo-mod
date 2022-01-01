package WetSpaghett.Mods.PooMod.Server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.*;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class ChatHandler {

    public static World world = null;

    @SubscribeEvent
    public static void getWorld(PlayerEvent.PlayerLoggedInEvent event) {
        world = event.player.getEntityWorld();
    }

    public static void chatMessage(String message) {
        MinecraftServer mcServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        PlayerList pl = mcServer.getPlayerList();
        ITextComponent msg = new TextComponentTranslation(message);
        pl.sendMessage(msg, true);
    }
}