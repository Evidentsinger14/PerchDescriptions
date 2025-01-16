package dev.ev1dent.perchdescriptions;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerManager {

    private PDMain pdMain() {
        return PDMain.getPlugin(PDMain.class);
    }

    NamespacedKey pronouns = new NamespacedKey(pdMain(), "perchPronouns");
    NamespacedKey timezone = new NamespacedKey(pdMain(), "perchTimezone");

    public void setField(Player player, String field, String value) {
        PersistentDataContainer data = player.getPersistentDataContainer();
        switch (field) {
            case "pronouns" -> {
                data.set(pronouns, PersistentDataType.STRING, value);
            }
            case "timezone" -> {
                data.set(timezone, PersistentDataType.STRING, value);
            }
        }
    }

    public String getField(Player player, String field) {
        PersistentDataContainer container = player.getPersistentDataContainer();
        switch (field) {
            case "pronouns" -> {
                if(container.has(pronouns, PersistentDataType.STRING)) {
                    return container.get(pronouns, PersistentDataType.STRING);
                } else {
                    return "Not Set";
                }

            }
            case "timezone" -> {
                if(container.has(timezone, PersistentDataType.STRING)) {
                    return container.get(timezone, PersistentDataType.STRING);
                } else {
                    return "Not Set";
                }
            }
        }
        return null;
    }
}
