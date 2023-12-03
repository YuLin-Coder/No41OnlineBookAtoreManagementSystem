package com.bookstore.servlet.bookType;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.BookType;
import com.bookstore.dao.IBookTypeDAO;
import com.bookstore.dao.impl.BookTypeDAOImpl;

public class FindByBookTypeIdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		BookType bookType = bookTypeDAO.findById(id);
		request.setAttribute("bookType", bookType);
		RequestDispatcher rd = request.getRequestDispatcher("/background/updateBookType.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
