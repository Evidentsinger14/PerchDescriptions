package dev.ev1dent.perchdescriptions.commands;

import dev.ev1dent.perchdescriptions.utilities.PlayerManager;
import dev.ev1dent.perchdescriptions.utilities.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PerchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        PlayerManager playerManager = new PlayerManager();

        String baseCMD = command.getName();
        Utils Utils = new Utils();
        Player player;
        String field;

        if(args.length == 0) {
            if(sender instanceof Player) {
                player = (Player) sender;
                field = playerManager.getField((Player) sender, baseCMD);
                player.sendMessage(Utils.formatConfigString("messages."+ baseCMD + ".display", field));
                return true;
            }
        }

        if (!sender.hasPermission("perchdescriptions." + baseCMD)) {
            sender.sendMessage(Utils.formatConfigString("messages.no-permissions"));
            return true;
        }

        if(args.length < 2) return false;
        player = Bukkit.getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage(Utils.formatConfigString("messages.player-not-found"));
            return true;
        }
        try {
            playerManager.setField(player, baseCMD, args[1]);
            field = playerManager.getField((Player) sender, baseCMD);

            player.sendMessage(Utils.formatConfigString("messages." + baseCMD + ".set", field, player.getName(), player.getUniqueId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
