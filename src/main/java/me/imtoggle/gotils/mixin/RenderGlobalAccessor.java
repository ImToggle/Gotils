package me.imtoggle.gotils.mixin;

import net.minecraft.client.renderer.RenderGlobal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(RenderGlobal.class)
public interface RenderGlobalAccessor {

    @Accessor
    int getCountEntitiesTotal();

    @Accessor
    int getCountEntitiesRendered();
}