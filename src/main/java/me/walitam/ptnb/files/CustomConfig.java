package me.walitam.ptnb.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig {

    private static File guildFile;
    private static FileConfiguration guildConfigurationFile;
    

    public static void init() {
    	
    	Object[] guildFiles = createFile("guilds_save");
    	guildFile = (File) guildFiles[0];
    	guildConfigurationFile = (FileConfiguration) guildFiles[1];
    	
    }

    public static Object[] createFile(String fileName)
    {
    	File file = new File(Bukkit.getServer().getPluginManager().getPlugin("PTNB").getDataFolder(), fileName+".yml");

        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e)
            {
                // BRUH
            }

        }

        FileConfiguration customFile = YamlConfiguration.loadConfiguration(file);
        
        
        return new Object[]{file, customFile};
    }

    public static FileConfiguration getGuildConfig()
    {
        return guildConfigurationFile;
    }

    public static void saveGuildConfig()
    {
        try {
            guildConfigurationFile.save(guildFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
