package com.hackingnews.controller;

import java.sql.SQLException;
import com.mysql.jdbc.ResultSet;

public interface MesureInterface {
	void create();
	void update();
	void delete();
	ResultSet listMesure() throws SQLException;
}
