package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.CustomerDetailInfo;

//用户详细信息
public interface ICustomerDetailInfoDAO {
	//总页数
	public int getPageCount(int pageSize);
	//显示当前页的总数据
	public List<CustomerDetailInfo> getNowPage(int nowPage, int pageSize);
	public boolean save(CustomerDetailInfo customerDetailInfo);
	public boolean update(CustomerDetailInfo customerDetailInfo);
	public boolean delete(int id);
	public CustomerDetailInfo findById(int id);
	public List<CustomerDetailInfo> findAll();
}
