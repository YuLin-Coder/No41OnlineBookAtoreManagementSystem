package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.Favorite;

//收藏夹
public interface IFavoriteDAO {
	//得到总页数
	public int getPageCount(int pageSize);
	//得到当前页的具体数据
	public List<Favorite> getNowPage(int nowPage, int pageSize);
	public boolean save(Favorite favorite);
	public boolean update(Favorite favorite);
	public boolean delete(int id);
	public Favorite findById(int id);
	public List<Favorite> findAll();
}
