package dev.ev1dent.perchdescriptions.utilities;

import dev.ev1dent.perchdescriptions.PDMain;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {

    private FileConfiguration config;
    private File configurationFile;

    private PDMain pdMain() {
        return PDMain.getPlugin(PDMain.class);
    }
    public void loadConfig() {
        if(!pdMain().getDataFolder().exists()) {
            pdMain().getDataFolder().mkdirs();
        }

        configurationFile = new File(pdMain().getDataFolder(), "config.yml");
        if (!configurationFile.exists()) {
            pdMain().saveResource("config.yml", false);
            config = YamlConfiguration.loadConfiguration(configurationFile);
        }
        config = YamlConfiguration.loadConfiguration(configurationFile);
    }

    public String getString(String key) {
        return config.getString(key);
    }

    public void setData(String key, Object value){
        config.set(key, value);
    }

    public void saveConfig() {
        try {
            config.save(configurationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
