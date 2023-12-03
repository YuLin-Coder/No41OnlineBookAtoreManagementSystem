package com.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.bookstore.bean.BookInfo;
import com.bookstore.common.DateConvert;
import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.db.DBManager;

//图书基本信息
public class BookInfoDAOImpl implements IBookInfoDAO{

	public boolean save(BookInfo bookInfo) {
		//将日期转换为字符串型
		String dateStr1 = DateConvert.convertToString(bookInfo.getPbdate());
		String dateStr2 = DateConvert.convertToString(bookInfo.getSjdate());
		String sql = "insert into "
				+ "bookInfo(bookName,booktypeId,author,pbName,context,smallImg,"
				+ "bigImg,price,pbdate,hyprice,bookStates,sjdate,num,saleCount) "
				+ "values ('" + bookInfo.getBookName()
				+ "', " + bookInfo.getBooktypeId()
				+ ", '" + bookInfo.getAuthor()
				+ "', '" + bookInfo.getPbName()
				+ "', '" + bookInfo.getContext()
				+ "', '" + bookInfo.getSmallImg()
				+ "', '" + bookInfo.getBigImg()
				+ "', " + bookInfo.getPrice()
				+ ", '" + dateStr1
				+ "', " + bookInfo.getHyprice()
				+ ", " + bookInfo.getBookStates()
				+ ", '" + dateStr2
				+ "', " + bookInfo.getNum()
				+ ", " + bookInfo.getSaleCount() + ")";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(BookInfo bookInfo) {
		//将时间格式转换为字符串
		String Str1 = DateConvert.convertToString(bookInfo.getPbdate());
		String Str2 = DateConvert.convertToString(bookInfo.getSjdate());
		String sql = "update bookInfo set " +
				"bookName='"+bookInfo.getBookName()+"',booktypeId="+bookInfo.getBooktypeId()+"," +
				"author='"+bookInfo.getAuthor()+"',pbName='"+bookInfo.getPbName()+"'," +
				"context='q',smallImg='"+bookInfo.getSmallImg()+"'," +
				"bigImg='"+bookInfo.getBigImg()+"',price="+bookInfo.getPrice()+"," +
				"pbdate='"+Str1+"',hyprice="+bookInfo.getHyprice()+"," +
				"bookStates="+bookInfo.getBookStates()+",sjdate='"+Str2+"'," +
				"num="+bookInfo.getNum()+",saleCount="+bookInfo.getSaleCount()+" " +
						"where bookId = "+bookInfo.getBookId()+"";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from bookInfo where bookId = '" + id + "'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public BookInfo findById(int id) {
		String sql = "select bookId,bookName,booktypeId,author,pbName,context" +
				",smallImg,bigImg,price,pbdate,hyprice,bookStates,sjdate" +
				",num,saleCount from bookInfo where bookId = '" + id + "'";
		DBManager dbManager = new DBManager();
		BookInfo info = new BookInfo();
		ResultSet rs = dbManager.query(sql);
		try {
			if(rs.next()) {
				info.setBookId(rs.getInt(1));
				info.setBookName(rs.getString(2));
				info.setBooktypeId(rs.getInt(3));
				info.setAuthor(rs.getString(4));
				info.setPbName(rs.getString(5));
				info.setContext(rs.getString(6));
				info.setSmallImg(rs.getString(7));
				info.setBigImg(rs.getString(8));
				info.setPrice(rs.getDouble(9));
				info.setPbdate(rs.getDate(10));
				info.setHyprice(rs.getDouble(11));
				info.setBookStates(rs.getInt(12));
				info.setSjdate(rs.getDate(13));
				info.setNum(rs.getInt(14));
				info.setSaleCount(rs.getInt(15));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return info;
	}

	public List<BookInfo> findAll() {
		List<BookInfo> books = new Vector<BookInfo>();
		String sql = "select bookId,bookName,booktypeId,author,pbName,context" +
				",smallImg,bigImg,price,pbdate,hyprice,bookStates,sjdate" +
				",num,saleCount from bookInfo";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookInfo info = new BookInfo();
				info.setBookId(rs.getInt(1));
				info.setBookName(rs.getString(2));
				info.setBooktypeId(rs.getInt(3));
				info.setAuthor(rs.getString(4));
				info.setPbName(rs.getString(5));
				info.setContext(rs.getString(6));
				info.setSmallImg(rs.getString(7));
				info.setBigImg(rs.getString(8));
				info.setPrice(rs.getDouble(9));
				info.setPbdate(rs.getDate(10));
				info.setHyprice(rs.getDouble(11));
				info.setBookStates(rs.getInt(12));
				info.setSjdate(rs.getDate(13));
				info.setNum(rs.getInt(14));
				info.setSaleCount(rs.getInt(15));
				books.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return books;
	}

	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from bookInfo";
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

	public List<BookInfo> getNowPage(int nowPage, int pageSize) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		String sql = "select * from bookInfo limit "+((nowPage-1)*pageSize)+", "+ pageSize;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookInfo info = new BookInfo();
				info.setBookId(rs.getInt(1));
				info.setBookName(rs.getString(2));
				info.setBooktypeId(rs.getInt(3));
				info.setAuthor(rs.getString(4));
				info.setPbName(rs.getString(5));
				info.setContext(rs.getString(6));
				info.setSmallImg(rs.getString(7));
				info.setBigImg(rs.getString(8));
				info.setPrice(rs.getDouble(9));
				info.setPbdate(rs.getDate(10));
				info.setHyprice(rs.getDouble(11));
				info.setBookStates(rs.getInt(12));
				info.setSjdate(rs.getDate(13));
				info.setNum(rs.getInt(14));
				info.setSaleCount(rs.getInt(15));
				bookInfos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;
	}

	//获取最新商品
	public List<BookInfo> findBySjdate(int num) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		/*String sql = "select top "+num+" " +
				"bookId,bookName,booktypeId,author,pbName," +
				"context,smallImg,bigImg,price,pbdate,hyprice," +
				"bookStates,sjdate,num,saleCount " +
				"from bookInfo order by sjdate desc";*/
		String sql = "select * from bookInfo order by sjdate desc limit "+num+"";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookInfo info = new BookInfo();
				info.setBookId(rs.getInt(1));
				info.setBookName(rs.getString(2));
				info.setBooktypeId(rs.getInt(3));
				info.setAuthor(rs.getString(4));
				info.setPbName(rs.getString(5));
				info.setContext(rs.getString(6));
				info.setSmallImg(rs.getString(7));
				info.setBigImg(rs.getString(8));
				info.setPrice(rs.getDouble(9));
				info.setPbdate(rs.getDate(10));
				info.setHyprice(rs.getDouble(11));
				info.setBookStates(rs.getInt(12));
				info.setSjdate(rs.getDate(13));
				info.setNum(rs.getInt(14));
				info.setSaleCount(rs.getInt(15));
				bookInfos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;
	}
	
	//获取热销商品
	public List<BookInfo> findBySaleCount(int num) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		/*String sql = "select top "+num+" " +
				"bookId,bookName,booktypeId,author,pbName," +
				"context,smallImg,bigImg,price,pbdate," +
				"hyprice,bookStates,sjdate,num,saleCount " +
				"from bookInfo order by saleCount desc";*/
		String sql = "select * from bookInfo order by saleCount desc limit "+num+"";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookInfo info = new BookInfo();
				info.setBookId(rs.getInt(1));
				info.setBookName(rs.getString(2));
				info.setBooktypeId(rs.getInt(3));
				info.setAuthor(rs.getString(4));
				info.setPbName(rs.getString(5));
				info.setContext(rs.getString(6));
				info.setSmallImg(rs.getString(7));
				info.setBigImg(rs.getString(8));
				info.setPrice(rs.getDouble(9));
				info.setPbdate(rs.getDate(10));
				info.setHyprice(rs.getDouble(11));
				info.setBookStates(rs.getInt(12));
				info.setSjdate(rs.getDate(13));
				info.setNum(rs.getInt(14));
				info.setSaleCount(rs.getInt(15));
				bookInfos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;
	}

	//获取推荐商品
	public List<BookInfo> findTjbooks(int num) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		/*String sql = "select top "+num+" " +
				"bookId,bookName,booktypeId,author,pbName," +
				"context,smallImg,bigImg,price,pbdate," +
				"hyprice,bookStates,sjdate,num,saleCount " +
				"from bookInfo";*/
		String sql = "select * from bookInfo limit "+num+"";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookInfo info = new BookInfo();
				info.setBookId(rs.getInt(1));
				info.setBookName(rs.getString(2));
				info.setBooktypeId(rs.getInt(3));
				info.setAuthor(rs.getString(4));
				info.setPbName(rs.getString(5));
				info.setContext(rs.getString(6));
				info.setSmallImg(rs.getString(7));
				info.setBigImg(rs.getString(8));
				info.setPrice(rs.getDouble(9));
				info.setPbdate(rs.getDate(10));
				info.setHyprice(rs.getDouble(11));
				info.setBookStates(rs.getInt(12));
				info.setSjdate(rs.getDate(13));
				info.setNum(rs.getInt(14));
				info.setSaleCount(rs.getInt(15));
				bookInfos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;
	}

	public List<BookInfo> findByTypeId(int typeId) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		String sql = "select bookId,bookName,booktypeId,author,pbName," +
				"context,smallImg,bigImg,price,pbdate," +
				"hyprice,bookStates,sjdate,num,saleCount " +
				"from bookInfo where booktypeId = "+ typeId +"";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				BookInfo info = new BookInfo();
				info.setBookId(rs.getInt(1));
				info.setBookName(rs.getString(2));
				info.setBooktypeId(rs.getInt(3));
				info.setAuthor(rs.getString(4));
				info.setPbName(rs.getString(5));
				info.setContext(rs.getString(6));
				info.setSmallImg(rs.getString(7));
				info.setBigImg(rs.getString(8));
				info.setPrice(rs.getDouble(9));
				info.setPbdate(rs.getDate(10));
				info.setHyprice(rs.getDouble(11));
				info.setBookStates(rs.getInt(12));
				info.setSjdate(rs.getDate(13));
				info.setNum(rs.getInt(14));
				info.setSaleCount(rs.getInt(15));
				bookInfos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;
	}
}
