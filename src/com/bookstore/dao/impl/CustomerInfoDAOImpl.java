package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.CustomerInfo;
import com.bookstore.dao.ICustomerInfoDAO;
import com.bookstore.db.DBManager;

public class CustomerInfoDAOImpl implements ICustomerInfoDAO {

	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from customerInfo";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			if(rs.next()) {
				rowCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		pageCount = rowCount / pageSize;
		if(rowCount % pageSize != 0) {
			pageCount++;
		}
		return pageCount;
	}

	public List<CustomerInfo> getNowPage(int nowPage, int pageSize) {
		List<CustomerInfo> infos = new Vector<CustomerInfo>();
		String sql = "select * from customerInfo limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		CustomerInfo info = null;
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				info = new CustomerInfo();
				info.setCustId(rs.getInt(1));
				info.setCustName(rs.getString(2));
				info.setPwd(rs.getString(3));
				info.setEmail(rs.getString(4));
				infos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return infos;
	}

	public boolean save(CustomerInfo customerInfo) {
		String sql = "insert into customerInfo(custName,pwd,email) " +
				"values ('"+customerInfo.getCustName()+"','"+customerInfo.getPwd()+"','"+customerInfo.getEmail()+"')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql)==1);
	}

	public boolean update(CustomerInfo customerInfo) {
		String sql = "update customerInfo set " +
				"custName='"+customerInfo.getCustName()+"'," +
				"pwd='"+customerInfo.getPwd()+"'," +
				"email='"+customerInfo.getEmail()+"' " +
					"where custId = "+customerInfo.getCustId()+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql ="delete from customerInfo where custId = "+id+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public CustomerInfo findById(int id) {
		String sql = "select custId,custName,pwd,email from customerInfo where custId = "+id+"";
		DBManager dbManager = new  DBManager();
		ResultSet rs = dbManager.query(sql);
		CustomerInfo info = new CustomerInfo();
		try {
			if(rs.next()) {
				info.setCustId(rs.getInt(1));
				info.setCustName(rs.getString(2));
				info.setPwd(rs.getString(3));
				info.setEmail(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return info;
	}

	public List<CustomerInfo> findAll() {
		List<CustomerInfo> infos = new Vector<CustomerInfo>();
		String sql = "select custId,custName,pwd,email from customerInfo ";
		DBManager dbManager = new DBManager();
		CustomerInfo info = null;
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				info = new CustomerInfo();
				info.setCustId(rs.getInt(1));
				info.setCustName(rs.getString(2));
				info.setPwd(rs.getString(3));
				info.setEmail(rs.getString(4));
				infos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return infos;
	}

	/**
	 * 判断用户名密码是否正确,如果正确返回该用户的详细信息,如果错误返回null
	 */
	public CustomerInfo findByNameAndPwd(String name, String pwd) {
		CustomerInfo customerInfo = null;
		DBManager dbManager = new DBManager();
		String sql = 
			"select custId,custName,pwd,email " +
				"from CustomerInfo " +
				"where " +
				"	custName = '" + name + "' " +
				"	and pwd = '" + pwd + "'";
		ResultSet rs = dbManager.query(sql);
			try {
				while (rs.next()) {
					customerInfo = new CustomerInfo(rs.getInt("custId"),
							rs.getString("custName"),
							rs.getString("pwd"),
							rs.getString("email"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				dbManager.close();
			}
		return customerInfo;
	}
}
