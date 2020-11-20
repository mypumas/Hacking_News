package com.hackingnews.controller;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public interface VulnerabiliteLogicielInterface {
	public void create();
	public void delete();
	ResultSet listVulnerabiliteLogiciel() throws SQLException;
}
