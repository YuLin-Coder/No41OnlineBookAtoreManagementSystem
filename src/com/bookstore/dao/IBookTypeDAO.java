package com.bookstore.dao;

//图书类别
import java.util.List;

import com.bookstore.bean.BookType;

//接口类
public interface IBookTypeDAO {
	//得到总页数
	public int getPageCount(int pageSize);
	//得到当前页的具体数据
	public List<BookType> getNowPage(int nowPage, int pageSize);
	public boolean save(BookType bookType);
	public boolean update(BookType bookType);
	public boolean delete(int id);
	public BookType findById(int id);
	public List<BookType> findAll();
	public List<BookType> findByParentId(int parentId);
}
