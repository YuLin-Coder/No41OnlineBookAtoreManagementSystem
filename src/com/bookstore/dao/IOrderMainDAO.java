package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.OrderMain;

public interface IOrderMainDAO {
	//得到总页数
	public int getPageCount(int pageSize);
	//得到当前页的具体数据
	public List<OrderMain> getNowPage(int nowPage, int pageSize);
	public boolean save(OrderMain orderMain);
	public boolean update(OrderMain orderMain);
	public boolean delete(int orderNum);
	public OrderMain findById(int orderNum);
	public List<OrderMain> findAll();
}
