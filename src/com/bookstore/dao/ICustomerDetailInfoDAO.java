package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.CustomerDetailInfo;

//�û���ϸ��Ϣ
public interface ICustomerDetailInfoDAO {
	//��ҳ��
	public int getPageCount(int pageSize);
	//��ʾ��ǰҳ��������
	public List<CustomerDetailInfo> getNowPage(int nowPage, int pageSize);
	public boolean save(CustomerDetailInfo customerDetailInfo);
	public boolean update(CustomerDetailInfo customerDetailInfo);
	public boolean delete(int id);
	public CustomerDetailInfo findById(int id);
	public List<CustomerDetailInfo> findAll();
}
