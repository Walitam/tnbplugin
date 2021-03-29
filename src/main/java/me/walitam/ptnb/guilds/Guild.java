package me.walitam.ptnb.guilds;

import java.util.List;

public class Guild {
	
	
	private String owner;
	private String name;
	private final List<String> members;
	
	
	public Guild(String owner, String name, List<String> members) {
		this.owner = owner;
		this.name = name;
		this.members = members;
	}
	
	
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getMembers() {
		return members;
	}
	

}
