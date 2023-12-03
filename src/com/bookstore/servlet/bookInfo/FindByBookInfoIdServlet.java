package com.bookstore.servlet.bookInfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookInfo;
import com.bookstore.dao.IBookInfoDAO;
import com.bookstore.dao.impl.BookInfoDAOImpl;

public class FindByBookInfoIdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt((request.getParameter("id")));
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		BookInfo bookInfo = bookInfoDAO.findById(id);
		request.setAttribute("bookInfo", bookInfo);
		RequestDispatcher rd = request.getRequestDispatcher("/background/updateBookInfo.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
