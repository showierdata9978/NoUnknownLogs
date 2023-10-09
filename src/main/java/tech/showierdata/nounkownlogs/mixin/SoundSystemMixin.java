package tech.showierdata.nounkownlogs.mixin;

import net.minecraft.client.sound.SoundSystem;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import com.llamalad7.mixinextras.injector.WrapWithCondition;
import tech.showierdata.nounkownlogs.NoUnknownLogs;

@Mixin(SoundSystem.class)
public class SoundSystemMixin {
    @WrapWithCondition(method = "play", at= @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Lorg/slf4j/Marker;Ljava/lang/String;Ljava/lang/Object;)V"))
    boolean replaceLog(Logger l, Marker m, String s, Object o) {
        return NoUnknownLogs.check(s);
    }
}
