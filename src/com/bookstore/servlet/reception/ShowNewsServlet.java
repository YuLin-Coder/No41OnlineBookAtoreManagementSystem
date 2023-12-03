package com.bookstore.servlet.reception;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookType;
import com.bookstore.bean.News;
import com.bookstore.dao.IBookTypeDAO;
import com.bookstore.dao.INewsDAO;
import com.bookstore.dao.impl.BookTypeDAOImpl;
import com.bookstore.dao.impl.NewsDAOImpl;

public class ShowNewsServlet extends HttpServlet {	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int newId = Integer.parseInt(request.getParameter("id"));
		INewsDAO newsDAO = new NewsDAOImpl();
		News news = newsDAO.findById(newId);
		request.setAttribute("news", news);
		List<News> newsList = newsDAO.findTopNine(10);
		request.setAttribute("newsList", newsList);
		
		Map<BookType, List<BookType>> bookTypes = new Hashtable<BookType, List<BookType>>();
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		//得到所有的父类别（顶层类别）
		List<BookType> fuqins = bookTypeDAO.findByParentId(0);
		for (BookType fuqin : fuqins) {
			//得到每个父类别的所有子类别
			List<BookType> erzi = bookTypeDAO.findByParentId(fuqin.getBookTypeId());
			bookTypes.put(fuqin, erzi);
		}
		request.setAttribute("bookTypes", bookTypes);
		RequestDispatcher rd = request.getRequestDispatcher("/showNews.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
