package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.CustomerInfo;

//�û�������Ϣ
public interface ICustomerInfoDAO {
	//��ҳ��
	public int getPageCount(int pageSize);
	//��ʾ��ǰҳ��������
	public List<CustomerInfo> getNowPage(int nowPage, int pageSize);
	public boolean save(CustomerInfo customerInfo);
	public boolean update(CustomerInfo customerInfo);
	public boolean delete(int id);
	public CustomerInfo findById(int id);
	public List<CustomerInfo> findAll();
	public CustomerInfo findByNameAndPwd(String name, String pwd);
}
