package tech.showierdata.nounkownlogs.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import com.llamalad7.mixinextras.injector.WrapWithCondition;

@Mixin(ClientPlayNetworkHandler.class)
public class ExampleMixin {

	@Unique
	boolean check(String s) {
		String l = s.toLowerCase();
		return !(l.contains("unknown") | l.contains("unknown"));
	}

	@SuppressWarnings("unused")
	@WrapWithCondition(method="*", at=@At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V"))
	boolean  replaceLogCall(Logger ignored, String s, Object o) {
		return check(s);
	}

	@SuppressWarnings("unused")
	@WrapWithCondition(method="*", at=@At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;[Ljava/lang/Object;)V"))
	boolean  replaceLogCall(Logger ignored, String s, Object[] o) {
		return check(s);
	}





}