package dev.ev1dent.perchdescriptions;

import dev.ev1dent.perchdescriptions.papi.PDExpansion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PDMain extends JavaPlugin {

    @Override
    public void onEnable() {
        initializeDependencies();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands(){
        this.getCommand("pronouns").setExecutor(new PerchCommand());
        this.getCommand("timezone").setExecutor(new PerchCommand());

    }

    public void initializeDependencies(){
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new PDExpansion().register();
        }
    }
}
