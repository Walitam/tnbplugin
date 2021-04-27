package me.walitam.ptnb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



//By Smato
//Last modification: 27/04/2021


public class SqlConnection {
	
	private Connection connection;
	
	private final String urlbase,host,database,user,pass;
	
	public SqlConnection(String urlbase, String host, String database, String user, String pass) {
		
		this.urlbase = urlbase;
		this.host = host;
		this.database = database;
		this.user = user;
		this.pass = pass;
	}

	public void connection() {
		if(!isConnected()){
		try {
			connection = DriverManager.getConnection(urlbase + host + "/" + database, user, pass);
			System.out.println(PTNB.TAG + " Connection à la base de donnée reussie");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(PTNB.TAG + " Connection impossible !");
		}
		}
	}
	
	
	public void disconnect() {
		if(isConnected()){
		try {
			connection.close();
			connection = null;
			System.out.println(PTNB.TAG + " Deconnection avec succes");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public boolean isConnected() {
		
		try {
			
			return connection.isValid(60);
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
