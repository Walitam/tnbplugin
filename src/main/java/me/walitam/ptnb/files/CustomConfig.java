package me.walitam.ptnb.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private static File file;
    private static FileConfiguration customFile;

    public static void setup()
    {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("PTNB").getDataFolder(), "customConfig.yml");

        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e)
            {
                // BRUH
            }

            customFile = YamlConfiguration.loadConfiguration(file);

        }
    }

    public static FileConfiguration get()
    {
        return customFile;
    }

    public static void save()
    {
        try {
            customFile.save(file);
        } catch (IOException e) {
            // BRUH
        }

    }
}
