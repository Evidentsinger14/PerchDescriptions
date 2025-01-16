package dev.ev1dent.perchdescriptions.utilities;

import dev.ev1dent.perchdescriptions.PDMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Utils {

    private PDMain pdMain() {
        return PDMain.getPlugin(PDMain.class);
    }

    FileConfiguration config = pdMain().getConfig();

    public @NotNull Component formatMM(String s) {
        return MiniMessage.miniMessage().deserialize(s).decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
    }

    public Component formatConfigString (String string, Object... args) {
        return formatMM(String.format(Objects.requireNonNull(config.getString(string)), args));
    }




}
