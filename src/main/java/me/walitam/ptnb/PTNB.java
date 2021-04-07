package me.walitam.ptnb;

import me.walitam.ptnb.commands.TNBCommand;
import me.walitam.ptnb.files.CustomConfig;
import me.walitam.ptnb.horse.HorseItemManagager;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PTNB extends JavaPlugin {

	public final static String TAG = "[TNB]";
	
	
    @Override
    public void onEnable() {
        getCommand("tnbtruc").setExecutor(new TNBCommand());
        
        
        
        //loading configs
        getConfig().options().copyDefaults(true);
		saveConfig();	//basic
        CustomConfig.init();	//customs
      
        
        
        //register event listeners
        PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new HorseItemManagager(), this);
        
        System.out.println(TAG+ " enabled !");
    }

    @Override
    public void onDisable() {
    	System.out.println(TAG+ " disabled !");
    }

}
