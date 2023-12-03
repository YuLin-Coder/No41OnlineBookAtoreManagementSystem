package com.bookstore.dao;
//书评
import java.util.List;

import com.bookstore.bean.BookDiscuss;

public interface IBookDiscussDAO {
	//总页数
	public int getPageCount(int pageSize);
	//得到当前页的所有数据
	public List<BookDiscuss> getNowPage(int nowPage, int pageSize);
	public boolean save(BookDiscuss bookDiscuss);
	public boolean update(BookDiscuss bookDiscuss);
	public boolean delete(int id);
	public BookDiscuss findById(int id);
	public List<BookDiscuss> findAll();
	public List<BookDiscuss> findByBookId(int bookId);
}
