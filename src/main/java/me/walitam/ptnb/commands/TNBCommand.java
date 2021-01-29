package me.walitam.ptnb.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TNBCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            Inventory inv = Bukkit.createInventory(p, 9, "TNB Menu thingy lol xd sex");

            //ITEM DECLARATIONS
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
            ItemStack pickaxe = new ItemStack(Material.NETHERITE_PICKAXE);

            ItemMeta sword_meta = sword.getItemMeta();
            ItemMeta pickaxe_meta = pickaxe.getItemMeta();

            //DECLARING ARRAYS FOR ITEM LORE'S
            ArrayList<String> sword_lore = new ArrayList<>();
            sword_lore.add(ChatColor.RED + "Kill Tool Funny");

            ArrayList<String> pickaxe_lore = new ArrayList<>();
            pickaxe_lore.add(ChatColor.RED + "Ah vraiment la c'est la");
            pickaxe_lore.add(ChatColor.RED + "CREUSAISON");

            //SETTING METAS
            sword_meta.setLore(sword_lore);
            pickaxe_meta.setLore(pickaxe_lore);
            sword_meta.setDisplayName(ChatColor.AQUA + "sword tool");
            pickaxe_meta.setDisplayName(ChatColor.AQUA + "pickaxe tool");

            //ADDING METAS TO ITEMS
            sword.setItemMeta(sword_meta);
            pickaxe.setItemMeta(pickaxe_meta);

            //ADDING ITEMS TO INVENTORY !
            inv.addItem(sword, pickaxe);

            //OPEN INVENTORY FOR PLAYER
            p.openInventory(inv);
        } else {
            sender.sendMessage("You're not a player, get the fuck out of here !");
        }

        return true;
    }
}
