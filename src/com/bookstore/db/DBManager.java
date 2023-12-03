package com.bookstore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private Connection con;
	private Statement sta;
	private ResultSet rs;
	
	/**
	 * ??????в?????
	 */
	public ResultSet query(String sql) {
		String url = "jdbc:mysql://localhost:3306/no41_bookstore";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root", "123456");
			sta = con.createStatement();
			rs = sta.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	


	/**
	 * ???????insert,update,delete SQL???
	 * @param sql ???е?SQL???
	 * @return sql???????????
	 */
	public int update(String sql) {
		System.out.println(sql);
		int rows = 0;
		//String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=BookStore";
		String url = "jdbc:mysql://localhost:3306/no41_bookstore";
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "123456");
			sta = con.createStatement();
			rows = sta.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return rows;
	}
	/**
	 * ??????
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (sta != null) {
				sta.close();
				sta = null;
			}	
			if (con != null) {
				con.close();
				con = null;
			}	
		} catch (Exception e) {
			System.out.println("?????????????");
			e.printStackTrace();
		}
	}
}

