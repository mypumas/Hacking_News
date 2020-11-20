package com.hackingnews.controller;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public interface CriticiteInterface {
	public void create();
	public ResultSet listCriticite() throws SQLException;
}
