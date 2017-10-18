package com.dao;

import java.sql.SQLException;

public interface testDAOInterface {

	public void dbConn() throws SQLException, InstantiationException, IllegalAccessException;
	public void dbSave(String value1, String value2, String value3) throws SQLException;
	public void disConn() throws SQLException;
	public void dbselect() throws SQLException;
	public void rule_mine() throws SQLException;
	public void testIterator() throws SQLException;
	
}
