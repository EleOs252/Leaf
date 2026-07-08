package org.dreeam.leaf.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.end.EnderDragonFight;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginManager;
import org.jspecify.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public final class EnderDragonFightsCommand extends Command {

    public static final String COMMAND_LABEL = "enderdragonfights";
    public static final String PERM = LeafCommands.COMMAND_BASE_PERM + "." + COMMAND_LABEL;
    private static final Permission permission = new Permission(PERM, PermissionDefault.OP);

    public EnderDragonFightsCommand() {
        super(COMMAND_LABEL);
        this.description = "Shows completed ender dragon fight count";
        this.usageMessage = "/" + COMMAND_LABEL;
        this.setPermission(PERM);

        final PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.addPermission(permission);
    }

    @Override
    public boolean execute(final CommandSender sender, final String commandLabel, final String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        final ServerLevel endLevel = MinecraftServer.getServer().getLevel(Level.END);
        final EnderDragonFight fight = endLevel == null ? null : endLevel.getDragonFight();
        final long fightCount = fight == null ? 0L : fight.getDragonFightCount();
        sender.sendMessage(Component.text("Ender dragon fights: ", NamedTextColor.GRAY).append(Component.text(Long.toString(fightCount), NamedTextColor.AQUA)));
        return true;
    }

    @Override
    public List<String> tabComplete(
        final CommandSender sender,
        final String alias,
        final String[] args,
        final @Nullable Location location
    ) throws IllegalArgumentException {
        return Collections.emptyList();
    }
}
