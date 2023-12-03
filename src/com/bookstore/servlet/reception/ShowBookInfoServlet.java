package com.bookstore.servlet.reception;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookDiscuss;
import com.bookstore.bean.BookInfo;
import com.bookstore.bean.BookType;
import com.bookstore.dao.IBookDiscussDAO;
import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.dao.IBookTypeDAO;
import com.bookstore.dao.impl.BookDiscussDAOImpl;
import com.bookstore.dao.impl.BookInfoDAOImpl;
import com.bookstore.dao.impl.BookTypeDAOImpl;

public class ShowBookInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//bookTypeDAO--得到图书类别
		Map<BookType, List<BookType>> bookTypes = new Hashtable<BookType, List<BookType>>();
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		//得到所有的父类别（顶层类别）
		List<BookType> fuqins = bookTypeDAO.findByParentId(0);
		for (BookType fuqin : fuqins) {
			//得到每个父类别的所有子类别
			List<BookType> erzi = bookTypeDAO.findByParentId(fuqin.getBookTypeId());
			bookTypes.put(fuqin, erzi);
		}
		
		//bookInfoDAO
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		//得到图书信息
		BookInfo bookInfo = bookInfoDAO.findById(id);
		//得到最新排行
		List<BookInfo> rxbooks = bookInfoDAO.findBySaleCount(10);
		//bookDiscussDAO
		IBookDiscussDAO discussDAO = new BookDiscussDAOImpl();
		//得到当前图书的所有书评
		List<BookDiscuss> discuss = discussDAO.findByBookId(id);
		request.setAttribute("bookTypes", bookTypes);
		request.setAttribute("bookInfo", bookInfo);
		request.setAttribute("rxbooks", rxbooks);
		request.setAttribute("discuss", discuss);
		request.getRequestDispatcher("bookInfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
