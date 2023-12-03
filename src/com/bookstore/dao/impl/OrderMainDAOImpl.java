package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.OrderMain;
import com.bookstore.dao.IOrderMainDAO;
import com.bookstore.db.DBManager;

public class OrderMainDAOImpl implements IOrderMainDAO{

	public boolean save(OrderMain orderMain) {
		String sql = 
				"insert into " +
				"	OrderMain (orderNum,customerId,customerName,tel,address," +
				"				status,adminId,context,sumprice)" +
				" values('"+orderMain.getOrderNum()+"'," +
						"'"+orderMain.getCustomerId()+"'," +
						"'"+orderMain.getCustomerName()+"'," +
						"'"+orderMain.getTel()+"'," +
						"'"+orderMain.getAddress()+"',0,null," +
						"'"+orderMain.getContext()+"'," +
						 "'"+orderMain.getSumprice()+"')";
			System.out.println(sql);
			DBManager dbManager = new DBManager();
			return (dbManager.update(sql) == 1);
	}

	public boolean update(OrderMain orderMain) {
		String sql = "update OrderMain set " +
				"orderNum = '"+orderMain.getOrderNum()+"', customerId = "+orderMain.getCustomerId()+", customerName = '"+orderMain.getCustomerName()+"', " +
				"tel = '"+orderMain.getTel()+"', address = '"+orderMain.getAddress()+"', status = '"+orderMain.getStatus()+"', " +
				"adminId = "+orderMain.getAdminId()+", context = '"+orderMain.getContext()+"', sumprice = "+orderMain.getSumprice()+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int orderNum) {
		String sql = "delete from OrderMain where orderNum = '"+orderNum+"'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public OrderMain findById(int orderNum) {
		String sql = "select orderNum, customerId, customerName, tel, address, status, adminId, context, sumprice from OrderMain where orderNum = '"+orderNum+"'";
		DBManager dbManager = new DBManager();
		OrderMain orderMain = new OrderMain();
		ResultSet rs = dbManager.query(sql);
		try {
			if(rs.next()) {
				orderMain.setOrderNum(rs.getString(1));
				orderMain.setCustomerId(rs.getInt(2));
				orderMain.setCustomerName(rs.getString(3));
				orderMain.setTel(rs.getString(4));
				orderMain.setAddress(rs.getString(5));
				orderMain.setStatus(rs.getString(6));
				orderMain.setAdminId(rs.getInt(7));
				orderMain.setContext(rs.getString(8));
				orderMain.setSumprice(rs.getDouble(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderMain;
	}

	public List<OrderMain> findAll() {
		List<OrderMain> orderMains = new Vector<OrderMain>();
		String sql = "select orderNum, customerId, customerName, tel, address, status, adminId, context, sumprice from OrderMain";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				OrderMain orderMain = new OrderMain();
				orderMain.setOrderNum(rs.getString(1));
				orderMain.setCustomerId(rs.getInt(2));
				orderMain.setCustomerName(rs.getString(3));
				orderMain.setTel(rs.getString(4));
				orderMain.setAddress(rs.getString(5));
				orderMain.setStatus(rs.getString(6));
				orderMain.setAdminId(rs.getInt(7));
				orderMain.setContext(rs.getString(8));
				orderMain.setSumprice(rs.getDouble(9));
				orderMains.add(orderMain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderMains;
	}
	
	public int getPageCount(int pageSize) {
		return 0;
	}

	public List<OrderMain> getNowPage(int nowPage, int pageSize) {
		return null;
	}

}
