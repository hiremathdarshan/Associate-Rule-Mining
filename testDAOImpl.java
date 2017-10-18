package com.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testDAOImpl implements testDAOInterface{

	
	Connection connection;
	@Override
	public void dbConn() throws SQLException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/dbproject";
			String username = "root";
			String password = "password";
			connection = DriverManager.getConnection(url, username, password);
			
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void dbSave(String value1, String value2, String value3) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement statement;	
		
		String sql = "insert into rule_mine (value1,value2,value3)"+"values(?,?,?)";
		
		statement = connection.prepareStatement(sql);
		
		statement.setString(1,value1);
		statement.setString(2, value2);
		statement.setString(3, value3);
		
		statement.executeUpdate();
		
		System.out.println("Inserted");
		
	}

	@Override
	public void disConn() throws SQLException {
		// TODO Auto-generated method stub
		
		connection.close();
		
	}

	@Override
	public void dbselect() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		
		//String sql = "select"
		
		
	}

	@Override
	public void rule_mine() throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Interface##");
		java.sql.Statement statement1 = null;
		java.sql.Statement statement2 = null;
		java.sql.Statement statement3 = null;
		String sql = "select distinct value1, value2 from rule_test where value3 is NULL";
		statement1 = connection.createStatement();
		System.out.println("####"+statement1);
		//statement = connection.prepareStatement(sql);
		
		//System.out.println("####"+resultSet);
		
		//int i=0;
		
		while(true){
			ResultSet resultSet = statement1.executeQuery(sql);
			//System.out.println("");
			while(resultSet.next()){
				System.out.println("#####First "+resultSet.getString("value1"));
				String value1= resultSet.getString("value1");
				System.out.println("#####Second "+resultSet.getString("value2"));
				String value2= resultSet.getString("value2");
				//System.out.println("#####Second "+resultSet.getString(2));
				String sql1 = "select value1,value2,value3,count(*) as count from rule_test where value1='"+value1+"' and value2='"+value2+"' and value3 is not null group by value3 order by count desc limit 1";
				statement2 = connection.createStatement();
				ResultSet rsdistinct = statement2.executeQuery(sql1);
				
				while(rsdistinct.next()){
					
					String insVal = rsdistinct.getString("value3");
					//select all tuples with nulls.//insert insVal into the columns that have a null.
					String sql2 = "update rule_test set value3='"+insVal+"' where value1='"+value1+"' and value2=+'"+value2+"' and value3 is null";
					statement3 = connection.createStatement();
					statement3.executeUpdate(sql2);
										
					//reiterate the loop. The next time the value is not going to be null so it will be eliminated.
					//continue the process for the remaining tuples
					
					
				}
			}
		}
		
		
		
		
		/*int j=0;
		while(resultSet.next()){*/
			
			//String a = resultSet.getString(1);
			//System.out.println("####"+a);
			//String b = resultSet.getString(2);
			//System.out.println("a = "+a);
			//System.out.println("b = "+b);
		//}j++;
		
		
		/*String sql2 = "select value1,value2,value3,count(*) as count from sample123 where value1='"+a+"' and value2='"+b+"' and value3 is not null group by value3 order by count desc limit 1";
		ResultSet resultSet2 = statement.executeQuery(sql2);
		
		int i=0;
		while(resultSet2.next()){
			
			System.out.println("###"+resultSet.getString(i));
			
		}i++;
		*/
		
		//resultSet.getString();
		
		//ResultSet resultSet = statement.getResultSet().getRow();
		//System.out.println("Result Set#####"+resultSet);
		
		
		
	}

	@Override
	public void testIterator() throws SQLException {
		// TODO Auto-generated method stub
		/*
		java.sql.Statement statement1 = null;		
		String sql = "select distinct value1, value2 from rule_test where value3 is NULL";
		statement1 = connection.createStatement();
		ResultSet resultSet = statement1.executeQuery(sql);
		
		while(resultSet.next()){
			System.out.println("##"+resultSet.getString("value1"));
			String sql1 = "select * from rule_test";
			ResultSet rs = sts
		}
		
		System.out.println("####"+statement1);*/
		
	}

	
	
	
}
