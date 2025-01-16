package dev.ev1dent.perchdescriptions.papi;

import dev.ev1dent.perchdescriptions.utilities.PlayerManager;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PDExpansion extends PlaceholderExpansion {

    PlayerManager playerManager = new PlayerManager();

    @Override
    public @NotNull String getIdentifier() {
        return "perchdescriptions";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Evident";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }
    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, String params) {
        return playerManager.getField(player, params);
    }
}
