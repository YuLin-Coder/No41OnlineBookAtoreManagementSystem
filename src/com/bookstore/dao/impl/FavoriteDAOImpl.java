package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.Favorite;
import com.bookstore.common.DateConvert;
import com.bookstore.dao.IFavoriteDAO;
import com.bookstore.db.DBManager;

public class FavoriteDAOImpl implements IFavoriteDAO{

	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from favorite";
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
			pageCount++;
		}
		return pageCount;
	}

	public List<Favorite> getNowPage(int nowPage, int pageSize) {
		List<Favorite> favorites = new Vector<Favorite>();
		String sql = "select * from favorite limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				Favorite favorite = new Favorite();
				favorite.setFavoriteId(rs.getInt(1));
				favorite.setBookId(rs.getInt(2));
				favorite.setCustId(rs.getInt(3));
				favorite.setScdate(rs.getDate(4));
				favorite.setContext(rs.getString(5));
				favorites.add(favorite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return favorites;
	}

	public boolean save(Favorite favorite) {
		String dateStr = DateConvert.convertToString(favorite.getScdate());
		String sql = "insert into favorite(bookid,custid,scdate,context) " +
				"values("+favorite.getBookId()+","+favorite.getCustId()+"," +
				"'"+dateStr+"','"+favorite.getContext()+"')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(Favorite favorite) {
		String dateStr = DateConvert.convertToString(favorite.getScdate());
		String sql = "update favorite set " +
				"bookid = "+favorite.getBookId()+",custid = "+favorite.getCustId()+"," +
				"scdate = '"+dateStr+"',context = '"+favorite.getContext()+"' " +
						"where favoriteId = "+favorite.getFavoriteId()+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from favorite where favoriteId = "+id+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public Favorite findById(int id) {
		String sql = "select favoriteId,bookid,custid,scdate,context from favorite where favoriteId = "+id+"";
		DBManager dbManager = new DBManager();
		Favorite favorite = new Favorite();
		ResultSet rs = dbManager.query(sql);
		try {
			if(rs.next()) {
				favorite.setFavoriteId(rs.getInt(1));
				favorite.setBookId(rs.getInt(2));
				favorite.setCustId(rs.getInt(3));
				favorite.setScdate(rs.getDate(4));
				favorite.setContext(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return favorite;
	}

	public List<Favorite> findAll() {
		List<Favorite> favorites = new Vector<Favorite>();
		String sql = "select favoriteId,bookid,custid,scdate,context from favorite";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				Favorite favorite = new Favorite();
				favorite.setFavoriteId(rs.getInt(1));
				favorite.setBookId(rs.getInt(2));
				favorite.setCustId(rs.getInt(3));
				favorite.setScdate(rs.getDate(4));
				favorite.setContext(rs.getString(5));
				favorites.add(favorite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return favorites;
	}
}
