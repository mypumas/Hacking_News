package com.hackingnews.controller;

import java.sql.SQLException;

import com.hackingnews.model.Abonnes;
import com.mysql.jdbc.ResultSet;

public interface AbonnesInterface {
	void create();
	void delete();
	ResultSet listAbonnes();
	void update();
	public Abonnes authentification() throws SQLException;
}
