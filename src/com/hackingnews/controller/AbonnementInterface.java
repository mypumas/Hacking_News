package com.hackingnews.controller;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public interface AbonnementInterface 
{
	void create();
	void update();
	void delete();
	ResultSet listAbonnement() throws SQLException;

}