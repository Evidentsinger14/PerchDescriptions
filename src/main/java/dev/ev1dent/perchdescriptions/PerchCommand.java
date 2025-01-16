package dev.ev1dent.perchdescriptions;

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
        Utils Utils = new Utils();
        Player player;

        if(args.length == 0) {
            if(sender instanceof Player) {
                player = (Player) sender;
                player.sendMessage(Utils.sendPerchMsg(String.format("Your %s: %s",
                        command.getName(), playerManager.getField((Player) sender, command.getName()))));
                return true;
            }
        }

        if (!sender.hasPermission("perchdescriptions." + command.getName())) {
            sender.sendMessage(Utils.sendPerchError("You are not permitted to use this command!"));
            return true;
        }

        if(args.length < 2) return false;
        player = Bukkit.getPlayer(args[0]);
        if (player == null) {
            sender.sendMessage(Utils.sendPerchError("Player not found!"));
            return true;
        }
        try {
            playerManager.setField(player, command.getName(), args[1]);
            player.sendMessage(Utils.sendPerchMsg(String.format("%s (%s) set for %s",
                    command.getName(), args[1], player.getName())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
