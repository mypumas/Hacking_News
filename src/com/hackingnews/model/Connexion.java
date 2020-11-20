package com.hackingnews.model;

import java.sql.DriverManager; // Pilot de connexion

public class Connexion {
	com.mysql.jdbc.Connection conn; // Attribut de connexion
	{
		String url = "jdbc:mysql://localhost:3306/"; // Machine locale
		String dbName;
		dbName = "hackingnews";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		try {
			Class.forName(driver).newInstance();
			conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("la connexion a reussie");
		} catch (Exception e) {
			System.out.println("la connexion est echoué");
		}
	}
}