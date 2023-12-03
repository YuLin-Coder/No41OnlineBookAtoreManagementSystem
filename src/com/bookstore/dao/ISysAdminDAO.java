package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.SysAdmin;

//管理员
public interface ISysAdminDAO {
	//总页数
	public int getPageCount(int pageSize);
	//得到当前页的所有数据
	public List<SysAdmin> getNowPage(int nowPage, int pageSize);
	public boolean save(SysAdmin sysadmin);
	public boolean update(SysAdmin sysAdmin);
	public boolean delete(int id);
	public SysAdmin findById(int id);
	public List<SysAdmin> findAll();
	//后台登陆
	public SysAdmin findByNameAndPwd(String name, String pwd);
}
