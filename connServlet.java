package com.test;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.testDAOImpl;
import com.dao.testDAOInterface;

@SuppressWarnings("serial")
public class connServlet extends HttpServlet{

	//private String name1,type1,name2,type2,name3,type3,tableName;
	private String value1, value2, value3;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Servlet");
		//super.doPost(req, resp);
		
		/*name1 = req.getParameter("name1");
		type1 = req.getParameter("type1");
		name2 = req.getParameter("name2");
		type2 = req.getParameter("type2");
		name3 = req.getParameter("name3");
		type3 = req.getParameter("type3");*/
		
		value1 = req.getParameter("value1");
		value2 = req.getParameter("value2");
		value3 = req.getParameter("value3");
		
		
		testDAOInterface daoInterface = new testDAOImpl();
		
		try {
			daoInterface.dbConn();
			
			//daoInterface.dbSave(value1, value2, value3);
			daoInterface.rule_mine();
			//daoInterface.testIterator();
			daoInterface.disConn();
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
