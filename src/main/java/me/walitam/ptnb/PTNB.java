package me.walitam.ptnb;

import me.walitam.ptnb.commands.TNBCommand;
import me.walitam.ptnb.files.CustomConfig;

import org.bukkit.plugin.java.JavaPlugin;

public final class PTNB extends JavaPlugin {

	public final static String TAG = "[TNB]";
	
	
    @Override
    public void onEnable() {
        getCommand("tnbtruc").setExecutor(new TNBCommand());
        
        
        //loading configs
        saveDefaultConfig();	//basic
        CustomConfig.init();	//customs
      
        
        System.out.println(TAG+ " enabled !");
    }

    @Override
    public void onDisable() {
    	System.out.println(TAG+ " disabled !");
    }

}
