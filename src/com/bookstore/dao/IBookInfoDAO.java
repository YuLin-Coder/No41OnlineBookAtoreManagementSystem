package com.bookstore.dao;
//图书基本信息
import java.util.List;

import com.bookstore.bean.BookInfo;

public interface IBookInfoDAO {
	//总页数
	public int getPageCount(int pageSize);
	//得到当前页的所有数据
	public List<BookInfo> getNowPage(int nowPage, int pageSize);
	public boolean save(BookInfo bookInfo);
	public boolean update(BookInfo bookInfo);
	public boolean delete(int id);
	public BookInfo findById(int id);
	public List<BookInfo> findAll();
	//根据上架时间进行降序排序，找出最新商品
	public List<BookInfo> findBySjdate(int num);
	//根据图书销售量进行降序排序，找出热销商品
	public List<BookInfo> findBySaleCount(int num);
	//获取推荐商品
	public List<BookInfo> findTjbooks(int num);
	public List<BookInfo> findByTypeId(int typeId);
}
