package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.BookDiscuss;
import com.bookstore.dao.IBookDiscussDAO;
import com.bookstore.db.DBManager;

// È∆¿
public class BookDiscussDAOImpl implements IBookDiscussDAO{

	//disId bookId custId context states
	public boolean save(BookDiscuss bookDiscuss) {
		String sql = "insert into bookDiscuss(bookId, custId, context, states)" +
				" values " +
				"(" + bookDiscuss.getBookId() + ", " + bookDiscuss.getCustId()
				+ ", '" + bookDiscuss.getContext()+ "', '" + bookDiscuss.getStates() + "')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(BookDiscuss bookDiscuss) {
		String sql = 
				"update bookDiscuss set " +
				" bookId = " + bookDiscuss.getBookId() + ", custId = " + bookDiscuss.getCustId() + ", " +
				"context = '" + bookDiscuss.getContext() + "', states = 1 where disId = " + bookDiscuss.getDisId() + "";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from bookDiscuss where disId = " + id + "";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public BookDiscuss findById(int id) {
		String sql = "select disId, bookId, custId, context, states " +
				"from bookDiscuss where disId = " + id + "";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		BookDiscuss discuss = new BookDiscuss();
		try {
			if(rs.next()) {
				discuss.setDisId(rs.getInt(1));
				discuss.setBookId(rs.getInt(2));
				discuss.setCustId(rs.getInt(3));
				discuss.setContext(rs.getString(4));
				discuss.setStates(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return discuss;
	}

	public List<BookDiscuss> findAll() {
		List<BookDiscuss> discusses = new Vector<BookDiscuss>();
		String sql = "select disId, bookId, custId, context, states from bookDiscuss";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookDiscuss discuss = new BookDiscuss();
				discuss.setDisId(rs.getInt(1));
				discuss.setBookId(rs.getInt(2));
				discuss.setCustId(rs.getInt(3));
				discuss.setContext(rs.getString(4));
				discuss.setStates(rs.getInt(5));
				discusses.add(discuss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return discusses;
	}

	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from bookDiscuss";
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

	public List<BookDiscuss> getNowPage(int nowPage, int pageSize) {
		List<BookDiscuss> discusses = new Vector<BookDiscuss>();
		String sql = "select * from bookDiscuss limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookDiscuss discuss = new BookDiscuss();
				discuss.setDisId(rs.getInt(1));
				discuss.setBookId(rs.getInt(2));
				discuss.setCustId(rs.getInt(3));
				discuss.setContext(rs.getString(4));
				discuss.setStates(rs.getInt(5));
				discusses.add(discuss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return discusses;
	}

	public List<BookDiscuss> findByBookId(int bookId) {
		List<BookDiscuss> discusses = new Vector<BookDiscuss>();
		String sql = "select disId ,bookId,custId,context,states from bookDiscuss where states = 1 and bookId = "+bookId+"";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookDiscuss discuss = new BookDiscuss();
				discuss.setDisId(rs.getInt(1));
				discuss.setBookId(rs.getInt(2));
				discuss.setCustId(rs.getInt(3));
				discuss.setContext(rs.getString(4));
				discuss.setStates(rs.getInt(5));
				discusses.add(discuss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return discusses;
	}
}
