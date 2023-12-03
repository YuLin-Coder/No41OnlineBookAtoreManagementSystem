package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.BookType;
import com.bookstore.dao.IBookTypeDAO;
import com.bookstore.db.DBManager;
//图书类别
public class BookTypeDAOImpl implements IBookTypeDAO {

	public boolean delete(int id) {
		String sql = "delete from BookType where bookTypeId = " + id + "";
		DBManager manager = new DBManager();
		return (manager.update(sql) == 1);
	}

	public List<BookType> findAll() {
		List<BookType> bookType = new Vector<BookType>();
		String sql = 
				" select " +
				"bookTypeId, parentId, bookTypeName, context, isDelete " +
				" from bookType ";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookType bt = new BookType();
				bt.setBookTypeId(rs.getInt(1));
				bt.setParentId(rs.getInt(2));
				bt.setBookTypeName(rs.getString(3));
				bt.setContext(rs.getString(4));
				bt.setIsDelete(rs.getInt(5));
				bookType.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookType;
	}
		
	
	public BookType findById(int id) {
		String sql = 
				" select " +
				"bookTypeId, parentId, bookTypeName, context, isDelete " +
				" from bookType " +
				"where bookTypeId = '" + id + "'";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		BookType bt = new BookType();
		try {
			if(rs.next()) {
				bt.setBookTypeId(rs.getInt(1));
				bt.setParentId(rs.getInt(2));
				bt.setBookTypeName(rs.getString(3));
				bt.setContext(rs.getString(4));
				bt.setIsDelete(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bt;
	}
		
	public boolean save(BookType bookType) {
		String sql = 
				" insert into " +
				"bookType(parentId, bookTypeName, context, isDelete) " +
				" values " +
				"(" + bookType.getParentId() + " , " +"'" +
				   "" + bookType.getBookTypeName() + "', '" + 
				   bookType.getContext() + "', " + 
				   bookType.getIsDelete() + ")";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(BookType bookType) {
		String sql = "update bookType set " +
				"parentId = "+ bookType.getParentId() + ", " +
				"bookTypeName = '" + bookType.getBookTypeName() + "', " +
				"context = '" + bookType.getContext() + 
				"isDelete = "+ bookType.getIsDelete() + ", " +
				"' where bookTypeId = " + bookType.getBookTypeId() + "";
		DBManager dbManager = new DBManager();
		return(dbManager.update(sql) == 1);
	}

	//得到总页数
	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from bookType";
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

	public List<BookType> getNowPage(int nowPage, int pageSize) {
		List<BookType> bookType = new Vector<BookType>();
		String sql = "select * from bookType limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookType bt = new BookType();
				bt.setBookTypeId(rs.getInt(1));
				bt.setParentId(rs.getInt(2));
				bt.setBookTypeName(rs.getString(3));
				bt.setContext(rs.getString(4));
				bt.setIsDelete(rs.getInt(5));
				bookType.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookType;
	}

	public List<BookType> findByParentId(int parentId) {
		String sql = "select bookTypeId,parentId,bookTypeName,context,isDelete from bookType where parentId = '"+ parentId +"'";
		List<BookType> bookTypes = new Vector<BookType>();
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookType bookType = new BookType(rs.getInt("bookTypeId"),
						rs.getInt("parentId"),
						rs.getString("bookTypeName"),
						rs.getString("context"),
						rs.getInt("isDelete"));
				bookTypes.add(bookType);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookTypes;
	}
}
