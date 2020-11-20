package com.hackingnews.controller;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public interface LogicielInterface {
	public void create();
	public ResultSet listLogiciel() throws SQLException;
}
