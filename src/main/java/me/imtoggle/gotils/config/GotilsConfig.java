package me.imtoggle.gotils.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.ConfigUtils;
import cc.polyfrost.oneconfig.config.data.OptionType;
import cc.polyfrost.oneconfig.config.data.PageLocation;
import cc.polyfrost.oneconfig.config.elements.OptionPage;
import me.imtoggle.gotils.Gotils;
import me.imtoggle.gotils.hud.ECounter;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;


public class GotilsConfig extends Config {

    @HUD(name = "Entities Counter", category = "ECounter")
    public static ECounter hud = new ECounter();

    @Switch(name = "Auto GG", category = "Auto Text")
    public static boolean autoGG = false;

    @Text(name = "Game Over Text", category = "Auto Text")
    public static String autoGGText = "gg";


        @Switch(name = "Victory Message", category = "Auto Text")
    public static boolean victory = false;
    @Text(name = "Victory Text", category = "Auto Text")
    public static String victorytext = "ez";

    public GotilsConfig() {
        super(new Mod(Gotils.NAME, ModType.UTIL_QOL, "/gotils.png"), Gotils.MODID + ".json");
        initialize();
    }
}

