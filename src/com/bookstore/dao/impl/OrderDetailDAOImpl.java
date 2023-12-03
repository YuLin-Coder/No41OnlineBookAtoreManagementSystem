package com.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.OrderDetail;
import com.bookstore.dao.IOrderDetailDAO;
import com.bookstore.db.DBManager;

public class OrderDetailDAOImpl implements IOrderDetailDAO{

	public boolean save(OrderDetail orderDetail) {
		String sql = "insert into orderDetail(orderNum, bookId, num) " +
				"values('"+orderDetail.getOrderNum()+"', " +
				""+orderDetail.getBookId()+", "+orderDetail.getNum()+")";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}
	
	public boolean save(List<OrderDetail> orderDetails) {
		DBManager dbManager = new DBManager();
		try {
			for (OrderDetail orderDetail : orderDetails) {
				String sql = "insert into OrderDetail (orderNum,bookId,num) " +
				"values ('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"','"+orderDetail.getNum()+"')";
				dbManager.update(sql);
			}	
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean save(Connection con, List<OrderDetail> orderDetails) {
		DBManager dbManager = new DBManager();
		try {
			for (OrderDetail orderDetail : orderDetails) {
				String sql = "insert into OrderDetail (orderNum,bookId,num) " +
				"values ('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"','"+orderDetail.getNum()+"')";
				dbManager.update(sql);
			}	
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean update(OrderDetail orderDetail) {
		String sql = "update orderDetail set " +
				"detail = "+orderDetail.getDetail()+", orderNum = '"+orderDetail.getOrderNum()+"', " +
				"bookId = "+orderDetail.getBookId()+", num = "+orderDetail.getNum()+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int detail) {
		String sql = "delete from orderDetail where detail = "+detail+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public OrderDetail findById(int detail) {
		String sql = "select detail, orderNum, bookId, num from orderDetail where detail = "+detail+"";
		OrderDetail orderDetail = new OrderDetail();
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			if(rs.next()) {
				orderDetail.setDetail(rs.getInt(1));
				orderDetail.setOrderNum(rs.getString(2));
				orderDetail.setBookId(rs.getInt(3));
				orderDetail.setNum(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetail;
	}

	public List<OrderDetail> findAll() {
		List<OrderDetail> orderDetails = new Vector<OrderDetail>();
		String sql = "select detail, orderNum, bookId, num from orderDetail";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setDetail(rs.getInt(1));
				orderDetail.setOrderNum(rs.getString(2));
				orderDetail.setBookId(rs.getInt(3));
				orderDetail.setNum(rs.getInt(4));
				orderDetails.add(orderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetails;
	}
	
	public int getPageCount(int pageSize) {
		return 0;
	}

	public List<OrderDetail> getNowPage(int nowPage, int pageSize) {
		return null;
	}
}
