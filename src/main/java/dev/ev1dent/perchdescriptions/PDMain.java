package dev.ev1dent.perchdescriptions;

import dev.ev1dent.perchdescriptions.papi.PDExpansion;
import dev.ev1dent.perchdescriptions.utilities.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PDMain extends JavaPlugin {

    @Override
    public void onEnable() {
        initializeDependencies();
        initializeConfig();
        registerCommands();
    }

    private void registerCommands(){
        Objects.requireNonNull(this.getCommand("pronouns")).setExecutor(new PerchCommand());
        Objects.requireNonNull(this.getCommand("timezone")).setExecutor(new PerchCommand());

    }

    private void initializeDependencies(){
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PDExpansion().register();
        }
    }

    private void initializeConfig(){
        ConfigManager cm = new ConfigManager();
        cm.loadConfig();
    }
}
