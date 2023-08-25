package me.imtoggle.gotils.hud;

import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.hud.SingleTextHud;
import me.imtoggle.gotils.Gotils;
import me.imtoggle.gotils.mixin.RenderGlobalAccessor;

public class ECounter extends SingleTextHud {
    public ECounter() {
        super("E", false);
    }

    @Switch(name = "IngameOnly")
    public static boolean gameonly = false;

    @Switch(name = "Simplified")
    public static boolean simplified = false;

    @Switch(name = "Show yourself")
    public static boolean showme = false;

    @Override
    public String getText(boolean sta) {
        RenderGlobalAccessor rga = ((RenderGlobalAccessor) Gotils.mc.renderGlobal);

        int first = rga.getCountEntitiesRendered();
        if (!showme && Gotils.mc.gameSettings.thirdPersonView != 0) {
            first--;
        }

        int second = rga.getCountEntitiesTotal();
        if (!showme) {
            second--;
        }

        if (simplified) {
            return first + "";
        } else {
            return first + "/" + second;
        }
    }

    @Override
    public boolean shouldShow() {
        return !gameonly || Gotils.ingame;
    }
}
