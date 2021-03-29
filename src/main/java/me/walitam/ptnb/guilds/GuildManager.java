package me.walitam.ptnb.guilds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.walitam.ptnb.files.CustomConfig;

public class GuildManager {  //GESTION DES GUILDES
	
	
	private final Map<String, Guild> guilds = new HashMap<String, Guild>(); //loaded guilds

	
	
	public Guild getGuildByName(String name) {
		Guild guild = guilds.get(name);
		
		if (guild == null) guild = loadGuild(name);
		
		return guild;
	}
	
	
	public Guild getGuildMember(String name) {
		return null;
	}
	
	
	
	public Guild loadGuild(String name) {
		String owner = CustomConfig.getGuildConfig().getString("guilds."+name+".owner"); //load owner name
		if (owner != null) { // check if guild exists
			
			List<String> members = CustomConfig.getGuildConfig().getStringList("guilds."+name+".members"); //load members list
			
			Guild guild =  new Guild(owner, name, members); //create guild
		
		
			guilds.put(name, guild); //add guild to loaded guilds
			
			return guild;
		}
		
		
		return null;
	}
	
	
	public void saveGuild(Guild guild) {
		
		CustomConfig.getGuildConfig().set("guilds."+guild.getName()+".owner", guild.getOwner()); //save guild owner
		CustomConfig.getGuildConfig().set("guilds."+guild.getName()+".members", guild.getMembers()); //save guild members
		
		CustomConfig.saveGuildConfig(); //update file config
		
	}
	
	
	public Guild createGuild(String name, String owner) {
		Guild guild = new Guild(owner, name, Arrays.asList(owner)); //create guild
		saveGuild(guild);
		loadGuild(name);
		return guild;
	}
	
	
	public void deleteGuild(Guild guild) {
		guilds.remove(guild.getName()); //remove guild from loaded guilds
		
		//remove from config
		CustomConfig.getGuildConfig().set("guilds"+guild.getName(), null);
		CustomConfig.saveGuildConfig();
	}
	

}
