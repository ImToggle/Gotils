package me.imtoggle.gotils;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import me.imtoggle.gotils.command.Command;
import me.imtoggle.gotils.config.GotilsConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;


@Mod(modid = Gotils.MODID, name = Gotils.NAME, version = Gotils.VERSION)
public class Gotils {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static boolean ingnw, ingame;
    @Mod.Instance(MODID)
    public static Gotils INSTANCE;
    public static GotilsConfig config;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new GotilsConfig();
        CommandManager.INSTANCE.registerCommand(new Command());
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onJoin(FMLNetworkEvent.ClientConnectedToServerEvent e) {
        if (!e.isLocal && mc.getCurrentServerData().serverIP.contains("gonetwork.lol")) ingnw = true;
    }

    @SubscribeEvent
    public void onQuit(FMLNetworkEvent.ClientDisconnectionFromServerEvent e) {
        ingnw = ingame = false;
    }
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent e) throws InterruptedException {
        if (!ingnw) return;

        String join = e.message.getUnformattedText();
        if (!ingame) {
            if (join.contains("GO » 倒數 1 秒"))
                ingame = true;
        } else if ( join.contains("GO » 你已退出") || join.contains("GO » 取消倒數...")) {
            ingame = false;
        } else if (join.contains("GO » 贏家 -")) {
            if (GotilsConfig.autoGG) {
                mc.thePlayer.sendChatMessage(GotilsConfig.autoGGText);
                if (join.contains(mc.thePlayer.getName()) && GotilsConfig.victory) {
                    Thread.sleep(200);
                    mc.thePlayer.sendChatMessage(GotilsConfig.victorytext);
                }
            }
            ingame = false;
        }
    }
}
