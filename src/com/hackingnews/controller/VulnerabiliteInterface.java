package com.hackingnews.controller;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public interface VulnerabiliteInterface {
	public void create();
	public void delete();
	public void update();
	public ResultSet listVulnerabilite() throws SQLException;
}
