package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.CustomerInfo;

//用户基本信息
public interface ICustomerInfoDAO {
	//总页数
	public int getPageCount(int pageSize);
	//显示当前页的总数据
	public List<CustomerInfo> getNowPage(int nowPage, int pageSize);
	public boolean save(CustomerInfo customerInfo);
	public boolean update(CustomerInfo customerInfo);
	public boolean delete(int id);
	public CustomerInfo findById(int id);
	public List<CustomerInfo> findAll();
	public CustomerInfo findByNameAndPwd(String name, String pwd);
}
