package com.bookstore.dao;

import java.sql.Connection;
import java.util.List;

import com.bookstore.bean.OrderDetail;

public interface IOrderDetailDAO {
	//得到总页数
	public int getPageCount(int pageSize);
	//得到当前页的具体数据
	public List<OrderDetail> getNowPage(int nowPage, int pageSize);
	public boolean save(OrderDetail orderDetail);
	public boolean save(List<OrderDetail> orderDetails);
	public boolean save(Connection con, List<OrderDetail> orderDetails);
	public boolean update(OrderDetail orderDetail);
	public boolean delete(int detail);
	public OrderDetail findById(int detail);
	public List<OrderDetail> findAll();
}
