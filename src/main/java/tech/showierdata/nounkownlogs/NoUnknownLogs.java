package tech.showierdata.nounkownlogs;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Unique;

public class NoUnknownLogs implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("nounknownlogs");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("No Logs that contain `Unknown` Should show up now! (Other then this one)");
	}

	@Unique

	public static boolean check(String s) {
		String l = s.toLowerCase();
		return !(l.contains("unknown") | l.contains("unknown"));
	}

}