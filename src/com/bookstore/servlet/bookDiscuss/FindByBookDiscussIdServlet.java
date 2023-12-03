package com.bookstore.servlet.bookDiscuss;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookDiscuss;
import com.bookstore.dao.IBookDiscussDAO;
import com.bookstore.dao.impl.BookDiscussDAOImpl;

public class FindByBookDiscussIdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt((request.getParameter("id")));
		IBookDiscussDAO dao = new BookDiscussDAOImpl();
		BookDiscuss discuss = dao.findById(id);
		request.setAttribute("discuss", discuss);
		RequestDispatcher rd = request.getRequestDispatcher("/background/updateBookDiscuss.jsp");
		rd.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
