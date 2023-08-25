package me.imtoggle.gotils.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import me.imtoggle.gotils.Gotils;


@cc.polyfrost.oneconfig.utils.commands.annotations.Command(value = Gotils.MODID, description = "Access the " + Gotils.NAME + " GUI.")
public class Command {
    @Main
    private static void main() {
        Gotils.INSTANCE.config.openGui();
    }
}