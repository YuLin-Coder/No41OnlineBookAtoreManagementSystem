package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.News;
import com.bookstore.common.DateConvert;
import com.bookstore.dao.INewsDAO;
import com.bookstore.db.DBManager;

//新闻
public class NewsDAOImpl implements INewsDAO{

	public boolean save(News news) {
		//将时间格式转换为字符串
		String dateStr = DateConvert.convertToString(news.getCreateTime());
		String sql = "insert into News(newsId, newTitle, context, createTime)" +
				"values (" + news.getNewsId() + ", '" + news.getNewTitle() + "', " +
				"'" + news.getContext() + "', '" + dateStr + "')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(News news) {
		//将时间格式转换为字符串
		String dateStr = DateConvert.convertToString(news.getCreateTime());
		String sql = "update News set " +
				"newTitle = '" + news.getNewTitle() + "', context = '" + news.getContext() + "', " +
				"createTime = '" + dateStr + "' where newsId = " + news.getNewsId() + "";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from News where newsId = " + id + "";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public News findById(int id) {
		String sql = "select newsId, newTitle, context, createTime from News where newsId = " + id + "";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		News news = new News();
		try {
			if(rs.next()) {
				news.setNewsId(rs.getInt(1));
				news.setNewTitle(rs.getString(2));
				news.setContext(rs.getString(3));
				news.setCreateTime(rs.getDate(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return news;
	}

	public List<News> findAll() {
		List<News> news = new Vector<News>();
		String sql = "select newsId, newTitle, context, createTime from News";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				News news2 = new News();
				news2.setNewsId(rs.getInt(1));
				news2.setNewTitle(rs.getString(2));
				news2.setContext(rs.getString(3));
				news2.setCreateTime(rs.getDate(4));
				news.add(news2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return news;
	}

	//得到总页数
	public int getPageCount(int pageSize) {
		//定义一个总行数
		int rowCount = 0;
		//定义一个总页数
		int pageCount = 0;
		String sql = "select count(*) from News";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			if(rs.next()) {
				rowCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		pageCount = rowCount / pageSize;
		if(rowCount % pageSize != 0) {
			pageCount ++;
		}
		return pageCount;
	}
	//得到当前页数的具体内容
	public List<News> getNowPage(int nowPage, int pageSize) {
		List<News> news = new Vector<News>();
		String sql = "select * from News limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				News news2 = new News();
				news2.setNewsId(rs.getInt(1));
				news2.setNewTitle(rs.getString(2));
				news2.setContext(rs.getString(3));
				news2.setCreateTime(rs.getDate(4));
				news.add(news2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return news;
	}

	public List<News> findTopNine(int num) {
		List<News> news = new Vector<News>();
		/*String sql = "select top "+num+" newsId, newTitle, context, createTime from News";*/
		String sql = "select * from News limit "+num+"";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				News news2 = new News();
				news2.setNewsId(rs.getInt(1));
				news2.setNewTitle(rs.getString(2));
				news2.setContext(rs.getString(3));
				news2.setCreateTime(rs.getDate(4));
				news.add(news2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return news;
	}
}
