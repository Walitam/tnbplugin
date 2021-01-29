package me.walitam.ptnb;

import me.walitam.ptnb.commands.TNBCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PTNB extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("tnbtruc").setExecutor(new TNBCommand());
        System.out.println("Le plugin est là !");
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

        System.out.println("Le plugin n'est plus là !");
    }

}
